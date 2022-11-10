package com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ModelingFileInfo;

import javax.persistence.*;

/**
 * <pre>
 * Class : ProjectObject
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
@Entity
@Table(name="tbl_tower")
public class MonsterTower {

    @Id
    @Column(name="tower_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="tower_name")
    private String TowerName;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="tower_file_id", unique = true)
    private ModelingFileInfo towerModelingFileInfo;



    @Column(name="monster_name")
    private String monsterName;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="monster_file_id", unique = true)
    private ModelingFileInfo monsterModelingFileInfo;


    @Column(name="ability")
    private String ability;

    protected MonsterTower() {}
    public MonsterTower(Integer id, String towerName, ModelingFileInfo towerModelingFileInfo, String monsterName, ModelingFileInfo monsterModelingFileInfo, String ability) {
        this.id = id;
        TowerName = towerName;
        this.towerModelingFileInfo = towerModelingFileInfo;
        this.monsterName = monsterName;
        this.monsterModelingFileInfo = monsterModelingFileInfo;
        this.ability = ability;
    }

    public Integer getId() {
        return id;
    }

    public String getTowerName() {
        return TowerName;
    }

    public ModelingFileInfo getTowerModelingFileInfo() {
        return towerModelingFileInfo;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public ModelingFileInfo getMonsterModelingFileInfo() {
        return monsterModelingFileInfo;
    }

    public String getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return "MonsterTower{" +
                "id=" + id +
                ", TowerName='" + TowerName + '\'' +
                ", towerModelingFileInfo=" + towerModelingFileInfo +
                ", monsterName='" + monsterName + '\'' +
                ", monsterModelingFileInfo=" + monsterModelingFileInfo +
                ", ability='" + ability + '\'' +
                '}';
    }
}