package com.profeel.monsterfac.monsterfactoryserver.project.query.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : PlacedDebuff
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
public class PlacedDebuff {

    @ApiModelProperty(example = "디버프 이름")
    @JsonProperty("debuff_name")
    @Column(name="placed_debuff_name")
    private String name;

    @ApiModelProperty(example = "배치 위치")
    @JsonProperty("debuff_position")
    @Column(name = "placed_debuff_position")
    private String position;


    protected PlacedDebuff(){}

    public PlacedDebuff(String name, String position) {
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
        return "PlacedDebuff{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
