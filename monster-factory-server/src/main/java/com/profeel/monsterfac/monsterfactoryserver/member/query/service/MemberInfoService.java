package com.profeel.monsterfac.monsterfactoryserver.member.query.service;

import com.profeel.monsterfac.monsterfactoryserver.member.query.data.MemberInfoData;
import com.profeel.monsterfac.monsterfactoryserver.member.query.exception.BadRequestException;
import com.profeel.monsterfac.monsterfactoryserver.member.query.repository.MemberInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <pre>
 * Class : MemberInfoService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Service
public class MemberInfoService {

    private final MemberInfoMapper memberInfoMapper;

    @Autowired
    public MemberInfoService(MemberInfoMapper memberInfoMapper) {
        this.memberInfoMapper = memberInfoMapper;
    }

    @Transactional
    public List<MemberInfoData> findMemberById(String memberId) {

        if(memberId == null) {
            throw new BadRequestException("멤버가 없습니다 다시 확인해 주세요");
        }

        return memberInfoMapper.findMemberById(memberId);
    }
}
