package com.profeel.monsterfac.monsterfactoryserver.review.command.presentation.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationErrorException;
import com.profeel.monsterfac.monsterfactoryserver.review.command.application.dto.RegistReviewRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.review.command.application.dto.ReviewResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.review.command.application.service.RegistReviewService;
import com.profeel.monsterfac.monsterfactoryserver.review.command.application.service.ReviewValidateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
@ApiResponses(value = {@ApiResponse(code = 200, message = "성공", response = ReviewResponseDTO.class)})
@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewValidateService reviewValidateService;
    private RegistReviewService registReviewService;

    @Autowired
    public ReviewController(RegistReviewService registReviewService, ReviewValidateService reviewValidateService){
        this.registReviewService = registReviewService;
        this.reviewValidateService = reviewValidateService;
    }

    @ApiOperation(value = "심사 리뷰 등록 api", notes = "리뷰 정보를 저장하는 api")
    @PostMapping("/")
    public ResponseEntity<ResponseDTO> registReview(@RequestBody RegistReviewRequestDTO registReviewRequest){
        System.out.println("[JudgeResultController] registJudgeResult -- POST");
        System.out.println("registResultRequest:" + registReviewRequest);

        List<ValidationError> errors = reviewValidateService.validate(registReviewRequest);
        if (!errors.isEmpty()) throw new ValidationErrorException(errors);


        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "게임 심사 결과 저장 성공"
                        , registReviewService.registReview(registReviewRequest, "admin")
                )
        );

    }
}
