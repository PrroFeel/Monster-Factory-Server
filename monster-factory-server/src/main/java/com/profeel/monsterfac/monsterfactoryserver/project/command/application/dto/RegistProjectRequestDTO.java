package com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <pre>
 * Class : ProjectRequestDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class RegistProjectRequestDTO {

    @ApiModelProperty(name = "유저 id", example = "profeel", notes = "액세스 토큰을 보내는 방식이 될 예정")
    private String userId;
    @ApiModelProperty(name = "프로젝트 이름", example = "큐비 프로젝트")
    private String projectName;

    public RegistProjectRequestDTO() {}
    public RegistProjectRequestDTO(String userId, String projectName) {
        this.userId = userId;
        this.projectName = projectName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "ProjectRequestDTO{" +
                "userId='" + userId + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
