package com.profeel.monsterfac.monsterfactoryserver.project.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationErrorException;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.ProjectResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.SaveProjectRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Project;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectId;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.repository.ProjectRepository;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * Class : SaveProjectService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-09       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Service
public class SaveProjectService {
    private ProjectRepository projectRepository;
    private ProjectService projectService;

    @Autowired
    public SaveProjectService(ProjectRepository projectRepository, ProjectService projectService){
        this.projectRepository = projectRepository;
        this.projectService = projectService;
    }
    private List<ValidationError> validateSaveRequest(SaveProjectRequestDTO saveProjectRequest) {

        return new ProjectRequestValidator().validate(saveProjectRequest);
    }

    @Transactional
    public ProjectResponseDTO saveProject(SaveProjectRequestDTO saveProjectRequest) throws IOException {
        // 필수 데이터 유무 검사
        List<ValidationError> errors = validateSaveRequest(saveProjectRequest);
        if (!errors.isEmpty()) throw new ValidationErrorException(errors);

        // project id 유효성 검사
        ProjectId projectId = projectService.createProjectId(saveProjectRequest.getProjectId());

        // 빈 model List 선언
        List<Integer> objectIdList = new ArrayList<>();

        // 프로젝트 상태 변경
        updateRecentDatatime(projectId.getId());
        updateStatus(projectId.getId());
        Optional<Project> projectOpt = projectRepository.findById(projectId.getId());
        Project updateProject = projectOpt.get();
        return  new ProjectResponseDTO(updateProject.getId(), updateProject.getRecentUpdateDatetime());
    }

    @Transactional
    protected void updateRecentDatatime(Integer id){
        Optional<Project> projectOpt = projectRepository.findById(id);
        projectOpt.get().changeRecentUpdateDatetime();
    }

    @Transactional
    protected void updateStatus(Integer id){
        Optional<Project> projectOpt = projectRepository.findById(id);
        projectOpt.get().inProgress();
    }

}