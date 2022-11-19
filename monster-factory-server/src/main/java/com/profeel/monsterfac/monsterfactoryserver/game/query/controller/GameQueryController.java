package com.profeel.monsterfac.monsterfactoryserver.game.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameInfoData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameSummaryData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.dto.GameLoadResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.game.query.service.GameQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@Api(tags = {"Game 조회 API"}, description = "game 조회 관련 api")
@Controller
@RequestMapping("/games")
public class GameQueryController {
    private GameQueryService gameQueryService;
    @Autowired
    public GameQueryController(GameQueryService gameQueryService){
        this.gameQueryService = gameQueryService;
    }

    @ApiOperation(value = "제출 게임 목록 조회", notes = "유저가 심사 제출한 모든 게임 목록을 조회하는 api" ,response = GameSummaryData.class)
    @ApiImplicitParam(name = "user", value = "조회를 요청한 유저 ID (액세스 토큰으로 대체될 예정)")
    @GetMapping("/submitted")
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

    @ApiOperation(value = "업로드 게임 목록 조회", notes = "업로드된 모든 게임 목록을 조회하는 api" ,response = GameSummaryData.class)
    @GetMapping("/uploaded")
    public ResponseEntity<ResponseDTO> findUploadedGameList(){
        System.out.println("[GameController] findUploadedGameList -- GET");

        List<GameSummaryData> gameSummaryDataList = gameQueryService.getUploadedGameSummaryList();
        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"업로드된 모든 게임 목록 조회"
                        , gameSummaryDataList
                )
        );
    }


    @ApiOperation(value = "심사 대기 게임 목록 조회", notes = "심사 대기 중인 게임 목록을 조회하는 api" ,response = GameSummaryData.class)
    @GetMapping("/waited")
    public ResponseEntity<ResponseDTO> findWaitingGameList(){
        System.out.println("[GameController] findWaitedGameList -- GET");

        List<GameSummaryData> gameSummaryDataList = gameQueryService.getWaitedGameList();
        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"심사 대기 중인 모든 게임 목록 조회"
                        , gameSummaryDataList
                )
        );
    }

    @ApiOperation(value = "게임 상세 정보 조회", notes = "게임에 대해 각종 정보를 조회하는 api로 기본 상세 정보, 플레이수, 랭킹 정보를 포함한다" ,response = GameInfoData.class)
    @GetMapping("/{id}/detail")
    public ResponseEntity<ResponseDTO> findGameInfoById(@PathVariable("id") Integer gameId){
        System.out.println("[GameController] findGameInfoById -- GET");

        System.out.println("gameId  : " + gameId);

//        GameInfoData gameInfoData = gameQueryService.getGameInfoData(gameId);
        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"게임 기본 정보 조회"
                        , gameQueryService.findGameDetailsById(gameId)
                )
        );
    }

    @ApiOperation(value = "게임 로드 정보 조회", notes = "게임 load 시 필요한 각종 오브젝트 정보를 조회하는 api" ,response = GameLoadResponseDTO.class)
    @GetMapping("/{id}/load")
    public ResponseEntity<ResponseDTO> findGameLoadInfoById(@PathVariable("id") Integer gameId){
        System.out.println("[GameController] findGameLoadInfoById -- GET");


        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"게임 load 필요 정보 조회"
                        , gameQueryService.findGameLoadInfoById(gameId)
                )
        );
    }
}
