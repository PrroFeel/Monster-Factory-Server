package com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto;


import java.util.List;

/**
 * <pre>
 * Class : SaveProjectRequestDTO
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
public class SaveProjectRequestDTO {
    private List<ProjectPlacedTower> projectPlacedTowerList;
    public SaveProjectRequestDTO() {}
    public SaveProjectRequestDTO(List<ProjectPlacedTower> projectPlacedTowerList) {
        this.projectPlacedTowerList = projectPlacedTowerList;
    }


    public List<ProjectPlacedTower> getProjectPlacedTowerList() {
        return projectPlacedTowerList;
    }

    public void setProjectPlacedTowerList(List<ProjectPlacedTower> projectPlacedTowerList) {
        this.projectPlacedTowerList = projectPlacedTowerList;
    }

    @Override
    public String toString() {
        return "SaveProjectRequestDTO{" +
                ", projectPlacedTowerList=" + projectPlacedTowerList +
                '}';
    }
}

