package com.profeel.monsterfac.monsterfactoryserver.project.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.ProjectPlacedTower;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.ProjectResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.PlacedTower;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Project;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.repository.ProjectRepository;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.service.ProjectService;
import com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.model.TowerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private ProjectQueryService projectQueryService;

    @Autowired
    public SaveProjectService(ProjectRepository projectRepository, ProjectService projectService, ProjectQueryService projectQueryService){
        this.projectQueryService = projectQueryService;
        this.projectRepository = projectRepository;
        this.projectService = projectService;
    }


    @Transactional
    public ProjectResponseDTO saveProject(Integer projectId, List<ProjectPlacedTower> projectPlacedTowerList)  {

        // project id 검증
        Project updateProject = projectQueryService.getProject(projectId);

        // 빈 PlacedTower 객체 리스트 선언
        List<PlacedTower> placedTowerList = new ArrayList<>();
        for(ProjectPlacedTower placedTower : projectPlacedTowerList){
            // tower id 검증
            TowerId towerId = projectService.isValid(placedTower.getTowerId());
            placedTowerList.add(new PlacedTower(towerId, placedTower.getAbility().toString(), placedTower.getPattern().toString(), placedTower.getTransform().toString()));
        }

        // project save
        updateProject.save(placedTowerList);

        return  new ProjectResponseDTO(updateProject.getId(), updateProject.getRecentUpdateDatetime());
    }





}