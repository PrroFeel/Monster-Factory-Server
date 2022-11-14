package com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * <pre>
 * Class : PlacedObjects
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
public class PlacedObjects {

    @Column(name="selected_map_type")
    private String mapType;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="tbl_placed_towers", joinColumns = @JoinColumn(name="project_id"))
    @OrderColumn(name="placed_tower_idx")
    private List<PlacedTower> towers;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="tbl_placed_obstacles", joinColumns = @JoinColumn(name="project_id"))
    @OrderColumn(name="placed_obstacle_idx")
    private List<PlacedObstacle> obstacles;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="tbl_placed_debuffs", joinColumns = @JoinColumn(name="project_id"))
    @OrderColumn(name="placed_debuff_idx")
    private List<PlacedDebuff> debuffs;

    protected PlacedObjects(){}

    public PlacedObjects(String mapType, List<PlacedTower> towers, List<PlacedObstacle> obstacles, List<PlacedDebuff> debuffs) {
        this.mapType = mapType;
        this.towers = towers;
        this.obstacles = obstacles;
        this.debuffs = debuffs;
    }

    public List<PlacedTower> getTowers() {
        return towers;
    }

    public List<PlacedObstacle> getObstacles() {
        return obstacles;
    }

    public List<PlacedDebuff> getDebuffs() {
        return debuffs;
    }

    public String getMapType() {
        return mapType;
    }

    protected void setMapType(String mapType) {
        this.mapType = mapType;
    }

    protected void setDebuffs(List<PlacedDebuff> newPlacedDebuffs) {
        this.debuffs = newPlacedDebuffs;
    }

    protected void setObstacles(List<PlacedObstacle> newPlacedObstacles) {
        this.obstacles = newPlacedObstacles;
    }

    public void setTowers(List<PlacedTower> newPlacedTowers) {
        this.towers = newPlacedTowers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlacedObjects that = (PlacedObjects) o;
        return Objects.equals(towers, that.towers) && Objects.equals(obstacles, that.obstacles) && Objects.equals(debuffs, that.debuffs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(towers, obstacles, debuffs);
    }

}
