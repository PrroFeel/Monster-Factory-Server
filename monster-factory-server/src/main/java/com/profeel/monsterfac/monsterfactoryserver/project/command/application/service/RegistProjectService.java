package com.profeel.monsterfac.monsterfactoryserver.project.command.application.service;


import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationErrorException;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.ProjectResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.RegistProjectRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Editor;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Project;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectStatus;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.repository.ProjectRepository;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.profeel.monsterfac.monsterfactoryserver.common.service.DateService.getCurrentDatetimeWithFormating;

/**
 * <pre>
 * Class : RegistProjectDTO
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
public class RegistProjectService {
    private ProjectRepository projectRepository;
    private ProjectService projectService;

    @Autowired
    public RegistProjectService(ProjectRepository projectRepository, ProjectService projectService){
        this.projectRepository = projectRepository;
        this.projectService = projectService;
    }

    private List<ValidationError> validateOrderRequest(RegistProjectRequestDTO registProjectRequest) {

        return new ProjectRequestValidator().validate(registProjectRequest);
    }

    @Transactional
    public ProjectResponseDTO registProject(RegistProjectRequestDTO registProjectRequest){
        // 필수 데이터 유무 검사
        List<ValidationError> errors = validateOrderRequest(registProjectRequest);
        if (!errors.isEmpty()) throw new ValidationErrorException(errors);

        // userId 유효성 검사
        Editor editor = projectService.createEditor(registProjectRequest.getUserId());

        // 현재 날짜 및 시간 가져옴
        String currentDatetime = getCurrentDatetimeWithFormating();

        // Project 객체 생성
        Project newProject = new Project(
                registProjectRequest.getProjectName()
                , currentDatetime
                , currentDatetime
                , editor
                , ProjectStatus.fromString("PRE"));

        // project insert
        projectRepository.save(newProject);

        return new ProjectResponseDTO(newProject.getId(), newProject.getRecentUpdateDatetime());
    }
}
