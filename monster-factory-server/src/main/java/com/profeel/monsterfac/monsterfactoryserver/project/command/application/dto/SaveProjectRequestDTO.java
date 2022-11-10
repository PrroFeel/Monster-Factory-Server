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
    private Integer projectId;
    private List<ProjectObject> objectList;
    public SaveProjectRequestDTO() {}

    public SaveProjectRequestDTO(Integer projectId, List<ProjectObject> modelList) {
        this.projectId = projectId;
        this.objectList = modelList;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public List<ProjectObject> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<ProjectObject> objectList) {
        this.objectList = objectList;
    }

    @Override
    public String toString() {
        return "StoreProjectRequestDTO{" +
                "projectId=" + projectId +
                ", modelList=" + objectList +
                '}';
    }

}

