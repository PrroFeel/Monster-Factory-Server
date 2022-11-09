package com.profeel.monsterfac.monsterfactoryserver.project.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationErrorException;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.ProjectObject;
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

        // 요청 들어온 ModelList를 하나씩 읽어 s3 업로드 및 파일 정보 저장 -> 각 파일 id와 model 정보를 담는 Model객체 List 구축
        for(ProjectObject object : saveProjectRequest.getObjectList()){
            // 모델링 파일 s3 업로드 및 파일 정보 저장
            Integer fileId = projectService.uploadAndRegistModelingFile(object.getModelingFile());

            // Model 객체 생성 후 modelList에 추가
//            projectService.registObjectInfo(fileId, object.getTransform(), projectId);
        }

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