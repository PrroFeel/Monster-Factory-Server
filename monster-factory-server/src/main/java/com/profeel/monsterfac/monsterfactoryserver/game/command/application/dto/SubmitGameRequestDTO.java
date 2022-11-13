package com.profeel.monsterfac.monsterfactoryserver.game.command.application.dto;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value="게임 이름", example = "탕탕탕 특공대")
    private String gameName;

    @ApiModelProperty(value="게임 설명", example = "몬스터를 잡으며 앞으로 전진해보세요!")
    private String gameDescription;

    @ApiModelProperty(value="게임 썸네일 파일", example = "monster.jpg")
    private MultipartFile thumbnailFile;

    @ApiModelProperty(value="작업한 프로젝트 id", example = "3")
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
