package com.profeel.monsterfac.monsterfactoryserver.project.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationErrorException;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.ProjectPlacedTower;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.ProjectResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.SaveProjectRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.PlacedTower;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Project;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.repository.ProjectRepository;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.service.ProjectService;
import com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.model.TowerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.List;

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
        // 필수 입력값 유무 검사
        List<ValidationError> errors = validateSaveRequest(saveProjectRequest);
        if (!errors.isEmpty()) {
            throw new ValidationErrorException(errors);
        }

        // project id 검사
        if(!isValid(saveProjectRequest.getProjectId())){
            throw new NotActiveException("유효하지 않은 프로젝트 id 입니다");
        }

        // 빈 PlacedTower 객체 리스트 선언
        List<PlacedTower> placedTowerList = new ArrayList<>();
        for(ProjectPlacedTower placedTower : saveProjectRequest.getProjectPlacedTowerList()){
            // tower id 검증
            TowerId towerId = projectService.isValid(placedTower.getTowerId());
            placedTowerList.add(new PlacedTower(towerId, placedTower.getAbility().toString(), placedTower.getPattern().toString(), placedTower.getTransform().toString()));
        }

        // project save
        Project updateProject = projectRepository.findById(saveProjectRequest.getProjectId()).get();
        updateProject.saveProject(placedTowerList);

        return  new ProjectResponseDTO(updateProject.getId(), updateProject.getRecentUpdateDatetime());
    }


    protected  boolean isValid(Integer id){
         return projectRepository.existsById(id);
    }


}