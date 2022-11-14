package com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

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

    @Column(name="placed_tower_name")
    private String name;

    @Column(name = "placed_tower_position")
    private String position;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlacedTower that = (PlacedTower) o;
        return Objects.equals(name, that.name) && Objects.equals(position, that.position) && Objects.equals(spawntime, that.spawntime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, spawntime);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", spawntime=" + spawntime +
                '}';
    }
}
