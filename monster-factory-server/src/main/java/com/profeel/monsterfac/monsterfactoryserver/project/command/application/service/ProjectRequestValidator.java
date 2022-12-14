package com.profeel.monsterfac.monsterfactoryserver.project.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.RegistProjectRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.SaveProjectRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Class : RegistProjectValidator
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-06       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Service
public class ProjectRequestValidator {

    public List<ValidationError> validate(RegistProjectRequestDTO registProjectRequest) {

        List<ValidationError> errors = new ArrayList<>();
        if (registProjectRequest == null) {
            errors.add(ValidationError.of("required"));
        } else {
            if (registProjectRequest.getProjectName() == null){
                errors.add(ValidationError.of("projectName", "required"));
            }

            if (registProjectRequest.getUserId() == null){
                errors.add(ValidationError.of("userId", "required"));
            }

        }
        return errors;
    }


    public List<ValidationError> validate(SaveProjectRequestDTO saveProjectRequest) {

        List<ValidationError> errors = new ArrayList<>();
        if (saveProjectRequest == null) {
            errors.add(ValidationError.of("required"));
        } else{
            if(saveProjectRequest.getMapType() == null){
                errors.add(ValidationError.of("mapType", "required"));
            }
            if(saveProjectRequest.getTowerInfoList() == null){
                errors.add(ValidationError.of("towerInfoList", "required"));
            }
            if(saveProjectRequest.getObstacleInfoList() == null){
                errors.add(ValidationError.of("obstacleInfoList", "required"));
            }
            if(saveProjectRequest.getDebuffInfoList() == null){
                errors.add(ValidationError.of("debuffInfoList", "required"));
            }
        }
        return errors;
    }

}
