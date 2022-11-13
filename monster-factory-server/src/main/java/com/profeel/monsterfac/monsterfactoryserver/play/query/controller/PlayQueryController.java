package com.profeel.monsterfac.monsterfactoryserver.play.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.play.query.data.PlayRankData;
import com.profeel.monsterfac.monsterfactoryserver.play.query.service.PlayQueryService;
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
 * Class : PlayQueryController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Api(tags = {"Ranking API"}, description = "게임 랭킹 조회 api")
@RestController
@RequestMapping("/play")
public class PlayQueryController {

    private PlayQueryService playQueryService;

    @Autowired
    public PlayQueryController(PlayQueryService playQueryService) {
        this.playQueryService = playQueryService;
    }

    @ApiOperation(value = "플레이 랭킹 조회", notes = "플레이 랭킹이 나오는 api이다")
    @GetMapping("/{id}")
    public ResponseEntity<?> findRankingByGameId(@PathVariable("id") int playGameId) {

        List<PlayRankData> GameRanking = playQueryService.findRankingByGameId(playGameId);

        return ResponseEntity.ok().body(GameRanking);
    }
}
