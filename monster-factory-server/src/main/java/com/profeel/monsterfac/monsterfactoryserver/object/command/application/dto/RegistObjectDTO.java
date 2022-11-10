package com.profeel.monsterfac.monsterfactoryserver.object.command.application.dto;

import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectId;
import org.springframework.web.multipart.MultipartFile;

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

    MultipartFile multipartFile;
    private ProjectId projectId;
    private String transform;

    protected RegistObjectDTO() {}

    public RegistObjectDTO(MultipartFile multipartFile, ProjectId projectId, String transform) {
        this.multipartFile = multipartFile;
        this.projectId = projectId;
        this.transform = transform;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public ProjectId getProjectId() {
        return projectId;
    }

    public String getTransform() {
        return transform;
    }

    @Override
    public String toString() {
        return "RegistObjectDTO{" +
                "multipartFile=" + multipartFile +
                ", projectId=" + projectId +
                ", transform='" + transform + '\'' +
                '}';
    }
}

