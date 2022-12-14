package com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto;

/**
 * <pre>
 * Class : ProjectResponseDTO
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

public class ProjectResponseDTO {
    private Integer projectId;
    private String recentUpdateDatetime;
    private String projectStatus;

    public ProjectResponseDTO(){}
    public ProjectResponseDTO(Integer projectId, String recentUpdateDatetime, String projectStatus) {
        this.projectId = projectId;
        this.recentUpdateDatetime = recentUpdateDatetime;
        this.projectStatus = projectStatus;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getRecentUpdateDatetime() {
        return recentUpdateDatetime;
    }

    public void setRecentUpdateDatetime(String recentUpdateDatetime) {
        this.recentUpdateDatetime = recentUpdateDatetime;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    @Override
    public String toString() {
        return "ProjectResponseDTO{" +
                "projectId=" + projectId +
                ", recentUpdateDatetime='" + recentUpdateDatetime + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                '}';
    }
}
