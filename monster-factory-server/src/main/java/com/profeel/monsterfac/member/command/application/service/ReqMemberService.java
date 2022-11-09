package com.profeel.monsterfac.member.command.application.service;

import com.profeel.monsterfac.common.model.Money;
import com.profeel.monsterfac.member.command.application.dto.MemberDTO;
import com.profeel.monsterfac.member.command.application.dto.TokenDTO;
import com.profeel.monsterfac.member.command.domain.service.MemberService;
import com.profeel.monsterfac.jwt.TokenProvider;
import com.profeel.monsterfac.member.command.application.dto.LoginDTO;
import com.profeel.monsterfac.member.command.application.dto.SignUpDTO;
import com.profeel.monsterfac.member.command.domain.model.Member;
import com.profeel.monsterfac.member.command.domain.model.Password;
import com.profeel.monsterfac.member.command.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.profeel.monsterfac.member.command.domain.exception.LoginFailedException;

import java.util.Date;

@Service
public class ReqMemberService {

    private final MemberRepository memberRepository;

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    private final TokenProvider tokenProvider;

    @Autowired
    public ReqMemberService(MemberRepository memberRepository, MemberService memberService, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
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

}
