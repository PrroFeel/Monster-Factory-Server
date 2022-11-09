package com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * <pre>
 * Class : ProjectId
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-08       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Embeddable
@Access(AccessType.FIELD)
public class ProjectId implements Serializable {
    @Column(name="project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 dbms에 자동 위임
    private Integer id;

    protected ProjectId() {}

    public ProjectId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectId projectId = (ProjectId) o;
        return Objects.equals(id, projectId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
