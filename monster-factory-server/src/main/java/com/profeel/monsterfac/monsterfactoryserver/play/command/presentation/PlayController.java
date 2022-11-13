package com.profeel.monsterfac.monsterfactoryserver.play.command.presentation;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.play.command.application.dto.RegistPlayResultDTO;
import com.profeel.monsterfac.monsterfactoryserver.play.command.application.service.RegistPlayResultService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * Class : PlayController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-12       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@RestController
@RequestMapping("/play")
public class PlayController {

    private final RegistPlayResultService registPlayResultService;

    @Autowired
    public PlayController(RegistPlayResultService registPlayResultService) {
        this.registPlayResultService = registPlayResultService;
    }

    @ApiOperation(value = "플레이 결과 추가", notes = "플레이 결과를 추가하는 api")
    @PostMapping(value = "/regist")
    public ResponseEntity<ResponseDTO> registPlayResult(@RequestBody RegistPlayResultDTO registPlayResultInfo) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK.value(), "플레이 결과 추가 성공", registPlayResultService.registPlayResult(registPlayResultInfo)));
    }
}
