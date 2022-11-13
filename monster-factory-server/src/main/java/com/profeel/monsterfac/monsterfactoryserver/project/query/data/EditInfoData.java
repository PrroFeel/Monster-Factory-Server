package com.profeel.monsterfac.monsterfactoryserver.project.query.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

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
@Entity
@Table(name = "tbl_projects")
public class EditInfoData {


    @Id
    @Column(name="project_id")
    private Integer id;

    @JsonProperty("map_type")
    @Column(name="selected_map_type")

    private String mapType;



    @JsonProperty("towerInfo_list")
    @ElementCollection
    @CollectionTable(name="tbl_placed_towers", joinColumns = @JoinColumn(name="project_id"))
    @OrderColumn(name="placed_tower_idx")
    private List<PlacedTower> towers;


    @JsonProperty("obstacleInfo_list")
    @ElementCollection
    @CollectionTable(name="tbl_placed_obstacles", joinColumns = @JoinColumn(name="project_id"))
    @OrderColumn(name="placed_obstacle_idx")
    private List<PlacedObstacle> obstacles;

    @JsonProperty("debuffInfo_list")
    @ElementCollection
    @CollectionTable(name="tbl_placed_debuffs", joinColumns = @JoinColumn(name="project_id"))
    @OrderColumn(name="placed_debuff_idx")
    private List<PlacedDebuff> debuffs;

    protected EditInfoData(){}


    public EditInfoData(Integer id, String mapType, List<PlacedTower> towers, List<PlacedObstacle> obstacles, List<PlacedDebuff> debuffs) {
        this.id = id;
        this.mapType = mapType;
        this.towers = towers;
        this.obstacles = obstacles;
        this.debuffs = debuffs;
    }

    public String getMapType() {
        return mapType;
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

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EditInfoData{" +
                "id=" + id +
                ", mapType='" + mapType + '\'' +
                ", towers=" + towers +
                ", obstacles=" + obstacles +
                ", debuffs=" + debuffs +
                '}';
    }
}
