package com.profeel.monsterfac.monsterfactoryserver.member.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.member.query.exception.BadRequestException;
import com.profeel.monsterfac.monsterfactoryserver.member.query.service.MemberQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * Class : MemberCheckController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-07       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Api(tags = {"Member API"}, description = "아이디 중복 체크 api")
@RestController
@RequestMapping("/auth")
public class MemberCheckController {

    private final MemberQueryService memberQueryService;

    public MemberCheckController(MemberQueryService memberQueryService) {
        this.memberQueryService = memberQueryService;
    }

    @ApiOperation(value = "닉네임 중복 검사", notes = "닉네임 중복인지 아닌지 판별하는 api")
    @GetMapping("/duplicated/{id}")
    public ResponseEntity<?> existsByMemberId(@PathVariable("id") String memberId) throws BadRequestException {
        System.out.println(memberId);

        if(memberQueryService.existsByMemberId(memberId) == true) {
            throw new BadRequestException("이미 사용 중인 아이디입니다");
        } else {
            return ResponseEntity.ok("사용 가능한 아이디입니다");
        }
    }
}
