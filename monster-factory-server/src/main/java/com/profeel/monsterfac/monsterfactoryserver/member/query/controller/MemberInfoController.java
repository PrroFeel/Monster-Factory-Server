package com.profeel.monsterfac.monsterfactoryserver.member.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.member.query.data.MemberInfoData;
import com.profeel.monsterfac.monsterfactoryserver.member.query.repository.MemberInfoMapper;
import com.profeel.monsterfac.monsterfactoryserver.member.query.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 * Class : MemberInfoController
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

@RestController
@RequestMapping("/members")
public class MemberInfoController {

    private MemberInfoService memberInfoService;
    private MemberInfoMapper memberInfoMapper;

    @Autowired
    public MemberInfoController(MemberInfoService memberInfoService, MemberInfoMapper memberInfoMapper) {
        this.memberInfoService = memberInfoService;
        this.memberInfoMapper = memberInfoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMemberInfo(@PathVariable("id") String memberId) {

        List<MemberInfoData> memberInfoDataList = memberInfoService.findMemberById(memberId);

        return ResponseEntity.ok().body(memberInfoDataList);
    }
}
