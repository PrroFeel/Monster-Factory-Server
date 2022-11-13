package com.profeel.monsterfac.monsterfactoryserver.project.query.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : PlacedObstacle
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
@Embeddable
public class PlacedObstacle {

    @ApiModelProperty(example = "장애물 이름")
    @JsonProperty("obstacle_name")
    @Column(name="placed_obstacle_name")
    private String name;

    @ApiModelProperty(example = "배치 위치")
    @JsonProperty("obstacle_position")
    @Column(name = "placed_obstacle_position")
    private String position;

    protected PlacedObstacle(){}

    public PlacedObstacle(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }


    @Override
    public String toString() {
        return "PlacedObstacle{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
