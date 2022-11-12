package com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;

/**
 * <pre>
 * Class : ObstacleInfo
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-12       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class ObstacleInfo {
    @ApiModelProperty(value = "장애물 이름", example = "fense")
    @JsonProperty("obstacle_name")
    private String obstacleName;

    @ApiModelProperty(value = "배치 위치", example = "[0,0,0]")
    @JsonProperty("obstacle_position")
    private Float[] obstaclePosition;
    protected ObstacleInfo(){}

    public ObstacleInfo(String obstacleName, Float[] obstaclePosition) {
        this.obstacleName = obstacleName;
        this.obstaclePosition = obstaclePosition;
    }

    public String getObstacleName() {
        return obstacleName;
    }

    public void setObstacleName(String obstacleName) {
        this.obstacleName = obstacleName;
    }

    public Float[] getObstaclePosition() {
        return obstaclePosition;
    }

    public void setObstaclePosition(Float[] obstaclePosition) {
        this.obstaclePosition = obstaclePosition;
    }

    @Override
    public String toString() {
        return "ObstacleInfo{" +
                "obstacleName='" + obstacleName + '\'' +
                ", obstaclePosition=" + Arrays.toString(obstaclePosition) +
                '}';
    }
}
