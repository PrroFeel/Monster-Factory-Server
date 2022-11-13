package com.profeel.monsterfac.monsterfactoryserver.project.query.data;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("debuff_name")
    @Column(name="placed_debuff_name")
    private String name;
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
