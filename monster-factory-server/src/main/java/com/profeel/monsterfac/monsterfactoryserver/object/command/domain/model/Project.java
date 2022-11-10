package com.profeel.monsterfac.monsterfactoryserver.object.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectId;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : Project
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-09       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Embeddable
public class Project {
    @AttributeOverrides(
            @AttributeOverride(name="id", column = @Column(name="project_id"))
    )
    private ProjectId projectId;

    protected Project(){}

    public Project(ProjectId projectId){
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                '}';
    }
}
