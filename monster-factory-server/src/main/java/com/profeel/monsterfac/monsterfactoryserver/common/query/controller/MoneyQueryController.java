package com.profeel.monsterfac.monsterfactoryserver.common.query.controller;

import com.amazonaws.Response;
import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.common.query.data.MoneyData;
import com.profeel.monsterfac.monsterfactoryserver.common.query.service.MoneyQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 * Class : MoneyQueryController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-16       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Api(tags = {"Money API"}, description = "유저가 보유한 게임 머니를 조회하는 api")
@RestController
@RequestMapping("/money")
public class MoneyQueryController {

    private MoneyQueryService moneyQueryService;

    @Autowired
    public MoneyQueryController(MoneyQueryService moneyQueryService) {
        this.moneyQueryService = moneyQueryService;
    }

    @ApiOperation(value = "유저 보유 머니 조회", notes = "특정 유저가 가진 게임 머니를 조회하는 api")
    @GetMapping("/{id}")
    public ResponseEntity<?> findMoneyByMemberId(@PathVariable("id") String memberId) {

        List<MoneyData> moneyDataList = moneyQueryService.findMoneyByMemberId(memberId);

        return ResponseEntity.ok().body(moneyDataList);
    }
}
