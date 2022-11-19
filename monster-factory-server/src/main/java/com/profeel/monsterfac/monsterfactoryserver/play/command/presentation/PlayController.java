package com.profeel.monsterfac.monsterfactoryserver.play.command.presentation;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.play.command.application.dto.RegistPlayResultDTO;
import com.profeel.monsterfac.monsterfactoryserver.play.command.application.service.GetRewardService;
import com.profeel.monsterfac.monsterfactoryserver.play.command.application.service.RegistPlayResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * Class : PlayController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-12       최은진           최초 생성
 * 2022-11-19       최윤서           보상 수령 관련 컨트롤러 추가
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Api(tags = {"Play API"}, description = "게임 플레이와 관련된 api들")
@RestController
@RequestMapping("/play")
public class PlayController {

    private final RegistPlayResultService registPlayResultService;
    private final GetRewardService getRewardService;

    @Autowired
    public PlayController(RegistPlayResultService registPlayResultService,
                          GetRewardService getRewardService) {
        this.registPlayResultService = registPlayResultService;
        this.getRewardService = getRewardService;
    }

    @ApiOperation(value = "플레이 결과 추가", notes = "플레이 결과를 추가하는 api")
    @PostMapping(value = "/regist")
    public ResponseEntity<ResponseDTO> registPlayResult(@RequestBody RegistPlayResultDTO registPlayResultInfo) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK.value(), "플레이 결과 추가 성공", registPlayResultService.registPlayResult(registPlayResultInfo)));
    }

    @ApiOperation(value = "게임 보상", notes = "게임 보상 머니 수령 api")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="game", value = "클리어한 게임 고유 번호"),
            @ApiImplicitParam(name="user", value="수령 받을 유저 id(토큰으로 대체될 예정)")
    })
    @PutMapping(value = "/get-reward")
    public ResponseEntity<ResponseDTO> getReward(@RequestParam("game") int gameId, @RequestParam("user") String userId){
        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value(),
                        "보상 수령 완료",
                        getRewardService.increaseMoneyForReward(gameId, userId)
                )
        );
    }



}
