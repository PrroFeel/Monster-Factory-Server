package com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto;

/**
 * <pre>
 * Class : UpdateProjectRequestDTO
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
 * @see 참고할 class 또는 외부 url
 */
public class UpdateNameRequestDTO {
    private String projectName;

    protected UpdateNameRequestDTO() {}
    public UpdateNameRequestDTO(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "UpdateProjectRequestDTO{" +
                "projectName='" + projectName + '\'' +
                '}';
    }
}
