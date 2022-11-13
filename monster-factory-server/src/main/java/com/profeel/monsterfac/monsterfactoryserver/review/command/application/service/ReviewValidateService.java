package com.profeel.monsterfac.monsterfactoryserver.review.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.review.command.application.dto.RegistReviewRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Class : ReviewValdateService
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
public class ReviewValidateService {
    public List<ValidationError> validate(RegistReviewRequestDTO registReviewRequest) {

        List<ValidationError> errors = new ArrayList<>();
        if (registReviewRequest == null) {
            errors.add(ValidationError.of("required"));
        } else {
            if (registReviewRequest.getResult() == null){
                errors.add(ValidationError.of("reviewResult", "required"));
            }

            if (registReviewRequest.getTargetGameId() == null){
                errors.add(ValidationError.of("targetGameId", "required"));
            }

            if (registReviewRequest.getComment() == null){
                errors.add(ValidationError.of("reviewComment", "required"));
            }

        }
        return errors;
    }
}
