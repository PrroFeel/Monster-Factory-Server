package com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import static com.profeel.monsterfac.monsterfactoryserver.common.service.DateService.getCurrentDatetimeWithFormating;

/**
 * <pre>
 * Class : Project
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Entity
@Table(name="tbl_projects")
@DynamicUpdate
public class Project {
    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="project_name")
    private String name;

    @Column(name="create_datetime")
    private String createDatetime;

    @Column(name = "recent_update_datetime")
    private String recentUpdateDatetime;

    @Column(name = "project_status")
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'PRE'")
    private ProjectStatus status;

    @Embedded
    private Editor editor;

    protected Project(){}

    public Project(String name, String createDatetime, String recentUpdateDatetime, Editor editor, ProjectStatus status) {
        this(name, createDatetime, recentUpdateDatetime, editor);
        this.status = status;
    }
    public Project(String name, String createDatetime, String recentUpdateDatetime, Editor editor) {
        this.name = name;
        this.createDatetime = createDatetime;
        this.recentUpdateDatetime = recentUpdateDatetime;
        this.editor = editor;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public String getRecentUpdateDatetime() {
        return recentUpdateDatetime;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public Editor getEditor() {
        return editor;
    }

    public void changeRecentUpdateDatetime(){
        this.recentUpdateDatetime = getCurrentDatetimeWithFormating();
    }

    public void inProgress(){
        this.status = ProjectStatus.IN_PROGRESS;
    }
}
