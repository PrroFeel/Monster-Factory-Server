package com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <pre>
 * Class : SaveProjectRequestDTO
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
public class SaveProjectRequestDTO {

    @ApiModelProperty(value = "선택된 맵 타입", example = "map1")
    @JsonProperty("map_type")
    private String mapType;

    @ApiModelProperty(value = "배치된 타워 정보 리스트")
    @JsonProperty("towerInfo_list")
    private List<TowerInfo> towerInfoList;

    @ApiModelProperty(value = "배치된 장애물 정보 리스트")
    @JsonProperty("obstacleInfo_list")
    private List<ObstacleInfo> obstacleInfoList;

    @ApiModelProperty(value = "배치된 디버프 정보 리스트")
    @JsonProperty("debuffInfo_list")
    private List<DebuffInfo> debuffInfoList;
    protected SaveProjectRequestDTO() {}

    public SaveProjectRequestDTO(String mapType, List<TowerInfo> towerInfoList, List<ObstacleInfo> obstacleInfoList, List<DebuffInfo> debuffInfoList) {
        this.mapType = mapType;
        this.towerInfoList = towerInfoList;
        this.obstacleInfoList = obstacleInfoList;
        this.debuffInfoList = debuffInfoList;
    }

    public String getMapType() {
        return mapType;
    }

    public void setMapType(String mapType) {
        this.mapType = mapType;
    }

    public List<TowerInfo> getTowerInfoList() {
        return towerInfoList;
    }

    public void setTowerInfoList(List<TowerInfo> towerInfoList) {
        this.towerInfoList = towerInfoList;
    }

    public List<ObstacleInfo> getObstacleInfoList() {
        return obstacleInfoList;
    }

    public void setObstacleInfoList(List<ObstacleInfo> obstacleInfoList) {
        this.obstacleInfoList = obstacleInfoList;
    }

    public List<DebuffInfo> getDebuffInfoList() {
        return debuffInfoList;
    }

    public void setDebuffInfoList(List<DebuffInfo> debuffInfoList) {
        this.debuffInfoList = debuffInfoList;
    }

    @Override
    public String toString() {
        return "SaveProjectRequestDTO{" +
                "mapType='" + mapType + '\'' +
                ", towerInfoList=" + towerInfoList +
                ", obstacleInfoList=" + obstacleInfoList +
                ", debuffInfoList=" + debuffInfoList +
                '}';
    }
}

