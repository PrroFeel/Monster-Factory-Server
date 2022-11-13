package com.profeel.monsterfac.monsterfactoryserver.game.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.game.command.application.dto.SubmitGameRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.game.command.application.dto.UploadGameRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Class : GameRequestValidator
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Service
public class GameRequestValidator {
    public List<ValidationError> validate(SubmitGameRequestDTO submitGameRequest) {
        List<ValidationError> errors = new ArrayList<>();
        if (submitGameRequest == null) {
            errors.add(ValidationError.of("required"));
        } else {
            if(submitGameRequest.getGameName() == null){
                errors.add(ValidationError.of("gameName", "required"));
            }
            if(submitGameRequest.getGameDescription() == null ){
                errors.add(ValidationError.of("gameDescription", "required"));
            }
            if(submitGameRequest.getThumbnailFile() == null || submitGameRequest.getThumbnailFile().isEmpty()){
                errors.add(ValidationError.of("thumbnailFile", "required"));
            }
            if(submitGameRequest.getProjectId() == null){
                errors.add(ValidationError.of("thumbnailFile", "required"));
            }
        }
        return errors;
    }

    public List<ValidationError> validate(UploadGameRequestDTO upladGameRequest) {
        List<ValidationError> errors = new ArrayList<>();
        if (upladGameRequest == null) {
            errors.add(ValidationError.of("required"));
        } else {
            if (upladGameRequest.getRewardItmes() == null) {
                errors.add(ValidationError.of("rewardItemList", "required"));
            }

            if(upladGameRequest.getRewardMoney() == null){
                errors.add(ValidationError.of("rewardMoney", "required"));
            }
        }
        return errors;
    }
}
