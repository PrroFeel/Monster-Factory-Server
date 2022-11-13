package com.profeel.monsterfac.monsterfactoryserver.project.query.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : PlacedTower
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Embeddable
public class PlacedTower {
    @JsonProperty("tower_name")
    @Column(name="placed_tower_name")
    private String name;
    @JsonProperty("tower_position")
    @Column(name = "placed_tower_position")
    private String position;
    @JsonProperty("tower_spawnTime")
    @Column(name="placed_tower_spawntime")
    private Float spawntime;

    protected PlacedTower() {}

    public PlacedTower(String name, String position, Float spawntime) {
        this.name = name;
        this.position = position;
        this.spawntime = spawntime;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Float getSpawntime() {
        return spawntime;
    }

    @Override
    public String toString() {
        return "PlacedTower{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", spawntime=" + spawntime +
                '}';
    }
}
