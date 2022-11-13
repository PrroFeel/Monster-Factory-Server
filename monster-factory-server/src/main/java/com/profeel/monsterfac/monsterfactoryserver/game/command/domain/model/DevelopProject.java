package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Developer;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectId;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * <pre>
 * Class : GameProject
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Embeddable
public class DevelopProject {
    @Embedded
    private ProjectId projectId;

    @Embedded
    private Developer developer;

    protected DevelopProject(){
    }

    public DevelopProject(ProjectId projectId, Developer developer) {
        this.projectId = projectId;
        this.developer = developer;
    }

    public ProjectId getProjectId() {
        return projectId;
    }

    public Developer getDeveloper() {
        return developer;
    }
}
