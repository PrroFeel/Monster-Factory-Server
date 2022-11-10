package com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * <pre>
 * Class : TowerId
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
// @Access : JPA가 엔티티 데이터에 접근하는 방식 지정
// AccessType.FIELD -> private 이여도 접근 가능하게 한다
@Embeddable
@Access(AccessType.FIELD)
public class TowerId implements Serializable {
    @Column(name = "tower_id")
    private Integer id;

    protected TowerId() {}

    public TowerId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TowerId towerId = (TowerId) o;
        return Objects.equals(id, towerId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
