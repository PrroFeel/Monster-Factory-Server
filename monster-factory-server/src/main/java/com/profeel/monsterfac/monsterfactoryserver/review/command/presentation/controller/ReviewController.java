package com.profeel.monsterfac.monsterfactoryserver.review.command.presentation.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.review.command.application.dto.RegistReviewRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * Class : JudgeController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-12       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Api(tags = {"Review API"}, description = "심사 관련 api")
@ApiResponses(value = {@ApiResponse(code = 200, message = "성공")})
@Controller
@RequestMapping("/reviews")
public class ReviewController {

//    private JudgeValidateService judgeValidateService;

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> registReview(@RequestBody RegistReviewRequestDTO registReviewRequest){
        System.out.println("[JudgeResultController] registJudgeResult -- POST");
        System.out.println("registResultRequest:" + registReviewRequest);


        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "게임 심사 결과 저장 성공"
                        , "저장된 정보 보여질 예정"
                )
        );

    }
}
