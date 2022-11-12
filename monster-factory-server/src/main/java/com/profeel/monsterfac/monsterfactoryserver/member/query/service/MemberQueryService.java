package com.profeel.monsterfac.monsterfactoryserver.member.query.service;

import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.repository.MemberRepository;
import com.profeel.monsterfac.monsterfactoryserver.member.query.dao.MemberDataDAO;
import com.profeel.monsterfac.monsterfactoryserver.member.query.data.MemberData;
import com.profeel.monsterfac.monsterfactoryserver.member.query.exception.NotFoundGameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * <pre>
 * Class : MemberService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-06       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Service
public class MemberQueryService{

    private MemberDataDAO memberDataDAO;

    private MemberRepository memberRepository;

    @Autowired
    public MemberQueryService(MemberDataDAO memberDataDAO, MemberRepository memberRepository){
        this.memberDataDAO = memberDataDAO;
        this.memberRepository = memberRepository;
    }

    public boolean isVailable(String memberId) {

        boolean result = memberDataDAO.existsById(memberId);

        if(!result) {
            throw new NotFoundGameException("회원 정보가 존재하지 않습니다.");
        }

        return result;
    }

    public MemberData getMemberData(String memberId) {
        Optional<MemberData> memberData = memberDataDAO.findById(memberId);

        return memberData.orElseThrow(() -> new NotFoundGameException("해당 회원을 찾을 수 없습니다"));
    }

    @Transactional(readOnly = true)
    public boolean existsByMemberId(String memberId) {

        return memberRepository.existsByMemberId(memberId);
    }
}
