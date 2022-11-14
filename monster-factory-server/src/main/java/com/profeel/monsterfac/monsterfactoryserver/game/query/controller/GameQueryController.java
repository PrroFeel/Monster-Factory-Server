package com.profeel.monsterfac.monsterfactoryserver.game.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameSummaryData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.service.GameQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <pre>
 * Class : GameController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-14       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Controller
@RequestMapping("/games")
public class GameQueryController {
    private GameQueryService gameQueryService;
    @Autowired
    public GameQueryController(GameQueryService gameQueryService){
        this.gameQueryService = gameQueryService;
    }

    @GetMapping("")
    public ResponseEntity<ResponseDTO> findSubmittedGameListByUser(@RequestParam("user") String userId){
        System.out.println("[GameController] findSubmittedGameListByUser -- GET");

        List<GameSummaryData> gameSummaryDataList = gameQueryService.getGameSummaryDataList(userId);
        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"유저 '" +userId+"' 가 제출한 모든 게임 목록 조회"
                        , gameSummaryDataList
                )
        );
    }
}
