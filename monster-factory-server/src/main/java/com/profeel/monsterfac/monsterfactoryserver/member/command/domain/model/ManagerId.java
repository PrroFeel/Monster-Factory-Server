package com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * <pre>
 * Class : ManagerId
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Embeddable
@Access(AccessType.FIELD)
public class ManagerId  implements Serializable {

    private String id;

    protected ManagerId(){}

    public ManagerId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerId managerId = (ManagerId) o;
        return Objects.equals(id, managerId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
