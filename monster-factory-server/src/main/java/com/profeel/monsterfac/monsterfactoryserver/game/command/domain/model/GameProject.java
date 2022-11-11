package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Editor;
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
public class GameProject {
    @Embedded
    private ProjectId projectId;

    @Embedded
    private Editor editor;

    protected  GameProject(){
    }

    public GameProject(ProjectId projectId, Editor editor) {
        this.projectId = projectId;
        this.editor = editor;
    }

    public ProjectId getProjectId() {
        return projectId;
    }

    public Editor getEditor() {
        return editor;
    }
}
