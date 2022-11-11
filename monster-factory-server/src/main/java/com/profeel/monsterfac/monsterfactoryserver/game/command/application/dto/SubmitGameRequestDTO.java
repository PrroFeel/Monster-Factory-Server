package com.profeel.monsterfac.monsterfactoryserver.game.command.application.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * Class : SubmitGameRequestDTO
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
public class SubmitGameRequestDTO {
    private String gameName;
    private String gameDescription;
    private MultipartFile thumbnailFile;
    private Integer projectId;

    protected SubmitGameRequestDTO(){}
    public SubmitGameRequestDTO(String gameName, String gameDescription, MultipartFile thumbnailFile, Integer projectId) {
        this.gameName = gameName;
        this.gameDescription = gameDescription;
        this.thumbnailFile = thumbnailFile;
        this.projectId = projectId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public MultipartFile getThumbnailFile() {
        return thumbnailFile;
    }

    public void setThumbnailFile(MultipartFile thumbnailFile) {
        this.thumbnailFile = thumbnailFile;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "SubmitGameRequestDTO{" +
                "gameName='" + gameName + '\'' +
                ", gameDescription='" + gameDescription + '\'' +
                ", thumbnailFile=" + thumbnailFile +
                ", projectId=" + projectId +
                '}';
    }
}
