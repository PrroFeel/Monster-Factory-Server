package com.profeel.monsterfac.monsterfactoryserver.review.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.review.query.service.ReviewQueryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <pre>
 * Class : ReviewController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-28       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Api(tags = {"review 조회 API"}, description = "review 조회 관련 api")
@ApiResponses(value = {@ApiResponse(code = 200, message = "성공")})
@Controller
@RequestMapping("/reviews")
public class ReviewQueryController {

    private ReviewQueryService reviewQueryService;

    @Autowired
    public ReviewQueryController(ReviewQueryService reviewQueryService){
        this.reviewQueryService = reviewQueryService;
    }


    @ApiOperation(value = "심사 내용 조회", notes = "심사 된 게임의 심사 내용을 조회하는 api")
    @ApiImplicitParam(name = "game", value = "조회하고자 하는 게임 고유 번호")
    @GetMapping("")
    public ResponseEntity<ResponseDTO> findReviewByGame(@RequestParam("game") int gameId){
        System.out.println("[ReviewQueryController] findReviewByGame -- GET");
        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "리뷰 조회"
                        , reviewQueryService.findReviewDataListByGameId(gameId)
                )
        );
    }
}
