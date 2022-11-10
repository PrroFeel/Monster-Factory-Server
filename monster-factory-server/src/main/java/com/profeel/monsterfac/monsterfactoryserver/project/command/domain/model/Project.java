package com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

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

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="tbl_placed_towers", joinColumns = @JoinColumn(name="project_id"))
    @OrderColumn(name="tower_idx")
    private List<PlacedTower> placedTowers;

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

    public void save(List<PlacedTower> placedTowerList){
        this.placedTowers =placedTowerList;
        changeRecentUpdateDatetime();
        inProgress();
    }

    private void changePlacedTowerList(List<PlacedTower> placedTowerList) {
        this.placedTowers =placedTowerList;
    }

    private void changeRecentUpdateDatetime(){
        this.recentUpdateDatetime = getCurrentDatetimeWithFormating();
    }

    private void inProgress(){
        this.status = ProjectStatus.IN_PROGRESS;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}
