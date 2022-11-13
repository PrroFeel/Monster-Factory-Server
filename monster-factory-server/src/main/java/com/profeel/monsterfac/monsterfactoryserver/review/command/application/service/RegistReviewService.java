package com.profeel.monsterfac.monsterfactoryserver.review.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationErrorException;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.ManagerId;
import com.profeel.monsterfac.monsterfactoryserver.review.command.application.dto.RegistReviewRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.review.command.application.dto.ReviewResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.review.command.domain.model.PIC;
import com.profeel.monsterfac.monsterfactoryserver.review.command.domain.model.Result;
import com.profeel.monsterfac.monsterfactoryserver.review.command.domain.model.Review;
import com.profeel.monsterfac.monsterfactoryserver.review.command.domain.model.TargetGame;
import com.profeel.monsterfac.monsterfactoryserver.review.command.domain.repository.ReviewRepository;
import com.profeel.monsterfac.monsterfactoryserver.review.command.domain.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.GameStatus.fromString;

/**
 * <pre>
 * Class : RegistReviewService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Service
public class RegistReviewService {

    private ReviewService reviewService;
    private ReviewRepository reviewRepository;

    @Autowired
    public RegistReviewService(ReviewService reviewService, ReviewRepository reviewRepository){
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
    }

    public ReviewResponseDTO registReview(RegistReviewRequestDTO registReviewRequest, String managerId){

        if(fromString(registReviewRequest.getResult()) == null){
            List<ValidationError> errors = new ArrayList<>();
            errors.add(new ValidationError("result", "유효하지 않은 결과 값 입니다"));
            throw new ValidationErrorException(errors);
        }

        TargetGame targetGame =reviewService.createTargetGame(registReviewRequest.getTargetGameId());

        // game status update
        reviewService.updateGameStatus(targetGame.getGameId(), registReviewRequest.getResult());

        // review 객체 생성
        Review newReview = new Review(
                registReviewRequest.getComment(),
                Result.fromString(registReviewRequest.getResult()),
                new PIC(new ManagerId(managerId)),
                targetGame
        );

        // new review insert
        newReview = reviewRepository.save(newReview);
        // insert 된 review 객체 반환
        return new ReviewResponseDTO(
                newReview.getId(),
                newReview.getComment(),
                newReview.getResult().toString(),
                newReview.getRegistDatetime(),
                newReview.getTargetGame().getGameId().getId(),
                newReview.getPic().getManagerId().getId()
        );
    }

}
