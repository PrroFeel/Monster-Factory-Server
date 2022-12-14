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
    private int id;

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
    private Developer developer;

    @Embedded
    private PlacedObjects placedObjects;
    protected Project(){}

    public Project(String name, String createDatetime, String recentUpdateDatetime, Developer editor, ProjectStatus status) {
        this(name, createDatetime, recentUpdateDatetime, editor);
        this.status = status;
    }
    public Project(String name, String createDatetime, String recentUpdateDatetime, Developer developer) {
        this.name = name;
        this.createDatetime = createDatetime;
        this.recentUpdateDatetime = recentUpdateDatetime;
        this.developer = developer;
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

    public Developer getEditor() {
        return developer;
    }

    public PlacedObjects getPlacedObjects() {
        return placedObjects;
    }

    public void save(PlacedObjects placedObjects){
        if(this.placedObjects.getMapType() == null){
            registMapType(placedObjects.getMapType());
        }else{
            updateMapType(placedObjects.getMapType());
        }
        updatePlacedTowers(placedObjects.getTowers());
        updatePlacedObstacles(placedObjects.getObstacles());
        updatePlacedDebuffs(placedObjects.getDebuffs());
        setRecentUpdateDatetime();
        inProgress();
    }

    private void registMapType(String selectedMapType){
        this.placedObjects.setMapType(selectedMapType);
    }

    private void updateMapType(String selectedMapType) {
        if(!this.placedObjects.getMapType().equals(selectedMapType)){
            this.placedObjects.setMapType(selectedMapType);
        }
    }
    private void updatePlacedDebuffs(List<PlacedDebuff> debuffs) {
        if(!this.placedObjects.getDebuffs().equals(debuffs)){
            this.placedObjects.setDebuffs(debuffs);
        }
    }

    private void updatePlacedObstacles(List<PlacedObstacle> obstacles) {
        if(!this.placedObjects.getObstacles().equals(obstacles)){
            this.placedObjects.setObstacles(obstacles);
        }
    }

    private void updatePlacedTowers(List<PlacedTower> towers) {
        if(!this.placedObjects.getTowers().equals(towers)){
            this.placedObjects.setTowers(towers);
        }
    }

//    private void changePlacedTowerList(List<PlacedTower> placedTowerList) {
//        this.placedTowers =placedTowerList;
//    }

    private void setRecentUpdateDatetime(){
        this.recentUpdateDatetime = getCurrentDatetimeWithFormating();
    }

    private void inProgress(){
        if(!status.equals(ProjectStatus.IN_PROGRESS)){
            this.status = ProjectStatus.IN_PROGRESS;
        }

    }

    public void modifyName(String newName) {
        if (newName == null || newName.equals("")) throw new IllegalArgumentException("새로운 이름을 입력해주세요");
        this.name = newName;
    }


    public void comleted() {
        this.status = ProjectStatus.DONE;
        setRecentUpdateDatetime();
    }
}
