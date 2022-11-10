package com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * Class : ProjectObjectInfo
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
public class ProjectObject {

    private MultipartFile modelingFile;

    private String transform;

    private Integer objectId;

    public ProjectObject() {
    }

    public ProjectObject(MultipartFile modelingFile, String transform, Integer objectId) {
        this.modelingFile = modelingFile;
        this.transform = transform;
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "ProjectObject{" +
                "modelingFile=" + modelingFile +
                ", transform=" + transform +
                ", objectId=" + objectId +
                '}';
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public MultipartFile getModelingFile() {
        return modelingFile;
    }

    public void setModelingFile(MultipartFile modelingFile) {
        this.modelingFile = modelingFile;
    }

    public String getTransform() {
        return transform;
    }

    public void setTransform(String transform) {
        this.transform = transform;
    }
}
