package com.profeel.monsterfac.monsterfactoryserver.object.command.application.dto;

import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectId;

/**
 * <pre>
 * Class : RegistObjectDTO
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
public class RegistObjectDTO {
    private Integer modelingFileId;
    private ProjectId projectId;
    private String transform;

    protected RegistObjectDTO() {}

    public RegistObjectDTO(Integer modelingFileId, String transform, ProjectId projectId) {
        this.modelingFileId = modelingFileId;
        this.transform = transform;
        this.projectId = projectId;
    }

    public Integer getModelingFileId() {
        return modelingFileId;
    }

    public void setModelingFileId(Integer modelingFileId) {
        this.modelingFileId = modelingFileId;
    }

    public String getTransform() {
        return transform;
    }

    public void setTransform(String transform) {
        this.transform = transform;
    }

    public ProjectId getProjectId() {
        return projectId;
    }

    public void setProjectId(ProjectId projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "RegistObjectRequestDTO{" +
                "modelingFileId=" + modelingFileId +
                ", info='" + transform + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}

