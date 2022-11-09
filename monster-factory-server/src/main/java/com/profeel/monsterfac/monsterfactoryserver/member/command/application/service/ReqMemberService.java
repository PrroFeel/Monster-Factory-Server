package com.profeel.monsterfac.monsterfactoryserver.member.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.common.model.Money;
import com.profeel.monsterfac.monsterfactoryserver.jwt.TokenProvider;
import com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto.MemberDTO;
import com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto.SignUpDTO;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.Member;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.Password;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.repository.MemberRepository;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ReqMemberService {

    private final MemberRepository memberRepository;

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

//    private final MemberQueryService memberQueryService;

    private final TokenProvider tokenProvider;

    @Autowired
    public ReqMemberService(MemberRepository memberRepository, MemberService memberService, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
//        this.memberQueryService = memberQueryService;
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

}
