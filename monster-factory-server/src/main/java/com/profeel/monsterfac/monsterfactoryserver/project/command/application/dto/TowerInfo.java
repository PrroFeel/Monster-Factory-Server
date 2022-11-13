package com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;

/**
 * <pre>
 * Class : TowerInfo
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
public class TowerInfo {
    @ApiModelProperty(value = "타워 이름", example = "skeleton_spwanTower")
    @JsonProperty("tower_name")
    private String towerName;

    @ApiModelProperty(value = "배치된 위치", example = "[0,0,0]")
    @JsonProperty("tower_position")
    private Float[] towerPosition;

    @ApiModelProperty(value = "타워 스폰 주기", example = "3.5f")
    @JsonProperty("tower_spawnTime")
    private Float towerSpawnTime;

    protected TowerInfo(){}

    public TowerInfo(String towerName, Float[] towerPosition, Float towerSpawnTime) {
        this.towerName = towerName;
        this.towerPosition = towerPosition;
        this.towerSpawnTime = towerSpawnTime;
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }

    public Float[] getTowerPosition() {
        return towerPosition;
    }

    public void setTowerPosition(Float[] towerPosition) {
        this.towerPosition = towerPosition;
    }
    public float getTowerSpawnTime() {
        return towerSpawnTime;
    }

    public void setTowerSpawnTime(Float towerSpawnTime) {
        this.towerSpawnTime = towerSpawnTime;
    }

    @Override
    public String toString() {
        return "TowerInfo{" +
                "towerName='" + towerName + '\'' +
                ", towerPosition=" + Arrays.toString(towerPosition) +
                ", towerSpawnTime=" + towerSpawnTime +
                '}';
    }
}
