package com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

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
    @Column(name="placed_debuff_name")
    private String name;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlacedDebuff that = (PlacedDebuff) o;
        return Objects.equals(name, that.name) && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
