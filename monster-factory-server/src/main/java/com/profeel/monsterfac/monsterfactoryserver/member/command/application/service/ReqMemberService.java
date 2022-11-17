package com.profeel.monsterfac.monsterfactoryserver.member.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.common.model.Money;
import com.profeel.monsterfac.monsterfactoryserver.jwt.TokenProvider;
import com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto.LoginDTO;
import com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto.MemberDTO;
import com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto.SignUpDTO;
import com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto.TokenDTO;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.exception.LoginFailedException;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.Member;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.Password;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ReqMemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final TokenProvider tokenProvider;

    @Autowired
    public ReqMemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Transactional
    public MemberDTO registMember(SignUpDTO signupinfo) {

        Member member = new Member();
        member.setMemberId(signupinfo.getMemberId());
        member.setPassword(new Password(passwordEncoder.encode(signupinfo.getPassword())));
        member.setGender(signupinfo.getGender());
        member.setBirthday(signupinfo.getBirthday());
        member.setMoney(new Money(100));
        member.setSecessionYn("N");
        member.setMemberRegistDate(new Date());
        member.setAuth("ROLE_USER");

        System.out.println("service : " + member.getMemberId());

        Member newMember = memberRepository.save(member);

        MemberDTO memberDTO = new MemberDTO();

        System.out.println(member.getMemberId());
        System.out.println(newMember.getPassword());

        memberDTO.setMemberId(newMember.getMemberId());
        memberDTO.setGender(newMember.getGender());
        memberDTO.setBirthday(newMember.getBirthday());
        memberDTO.setMoney(newMember.getMoney());
        memberDTO.setSecessionYn(newMember.getSecessionYn());
        memberDTO.setMemberRegistDate(newMember.getMemberRegistDate());
        memberDTO.setAuth(newMember.getAuth());

        return memberDTO;
    }

    @Transactional
    public TokenDTO login(LoginDTO logininfo) {

        Member member = memberRepository.findByMemberId(logininfo.getMemberId());

        if(member == null) {
            throw new LoginFailedException("가입되지 않은 회원입니다");
        }

        System.out.println(logininfo.getPassword().getValue() + member.getPassword().getValue());

        if(!passwordEncoder.matches(logininfo.getPassword().getValue(), member.getPassword().getValue())) {
            throw new LoginFailedException("잘못된 아이디 또는 비밀번호입니다");
        }

        TokenDTO tokenDto = tokenProvider.generateTokenDto(member);

        return tokenDto;

    }

    @Transactional
    public Member decreaseMoney(String memberId, int amount){
        Member member = memberRepository.findByMemberId(memberId);

        if(member == null) {
            throw new LoginFailedException("가입되지 않은 회원입니다");
        }

        member.decreaseMoney(amount);

        return member;
    }

    @Transactional
    public Member increaseMoney(String memberId, int amount){
        Member member = memberRepository.findByMemberId(memberId);

        if(member == null) {
            throw new LoginFailedException("가입되지 않은 회원입니다");
        }

        member.increaseMoney(amount);

        return member;
    }

}
