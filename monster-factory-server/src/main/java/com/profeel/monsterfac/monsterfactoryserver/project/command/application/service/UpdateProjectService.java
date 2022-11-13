package com.profeel.monsterfac.monsterfactoryserver.project.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.*;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.*;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Class : UpdateNameService
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
public class UpdateProjectService {

    private ProjectQueryService projectQueryService;
    private ProjectService projectService;
    public UpdateProjectService(ProjectService projectService, ProjectQueryService projectQueryService){
        this.projectQueryService = projectQueryService;
        this.projectService = projectService;
    }

    @Transactional
    public ProjectResponseDTO saveProject(Integer projectId, SaveProjectRequestDTO saveProjectRequest)  {

        // project id 검증
        Project updateProject = projectQueryService.getProject(projectId);

        // 빈 PlacedTower 객체 리스트 선언
        List<PlacedTower> placedTowerList = new ArrayList<>();
        for(TowerInfo towerInfo : saveProjectRequest.getTowerInfoList()){
            placedTowerList.add(new PlacedTower(
                    towerInfo.getTowerName(),
                    Arrays.toString(towerInfo.getTowerPosition()),
                    towerInfo.getTowerSpawnTime()
            ));
        }

        List<PlacedObstacle> placedObstacleList = new ArrayList<>();
        for(ObstacleInfo obstacleInfo : saveProjectRequest.getObstacleInfoList()){
            placedObstacleList.add(
                new PlacedObstacle(
                        obstacleInfo.getObstacleName(),
                        Arrays.toString(obstacleInfo.getObstaclePosition())
                )
            );
        }

        List<PlacedDebuff> placedDebuffList = new ArrayList<>();
        for(DebuffInfo debuffInfo : saveProjectRequest.getDebuffInfoList()){
            placedDebuffList.add(
                new PlacedDebuff(
                        debuffInfo.getDebuffName(),
                        Arrays.toString(debuffInfo.getDebuffPosition())
                )
            );
        }

        // project save
        updateProject.save(
                new PlacedObjects(placedTowerList, placedObstacleList, placedDebuffList)
        );

        return  new ProjectResponseDTO(updateProject.getId(), updateProject.getRecentUpdateDatetime(), updateProject.getStatus().toString());
    }




    @Transactional
    public ProjectResponseDTO modifyProjectName(Integer projectId, String newName){
        // project id 검증
        Project targetProject = projectQueryService.getProject(projectId);

        // project name modify
        targetProject.modifyName(newName);

        return new ProjectResponseDTO(targetProject.getId(), targetProject.getRecentUpdateDatetime(), targetProject.getStatus().toString());
    }

    @Transactional
    public ProjectResponseDTO completedProject(Integer projectId){

        // project id 검증
        Project targetProject = projectQueryService.getProject(projectId);

        // project name update
        targetProject.comleted();

        return new ProjectResponseDTO(targetProject.getId(), targetProject.getRecentUpdateDatetime(), targetProject.getStatus().toString());
    }
}
