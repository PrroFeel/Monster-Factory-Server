package com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;

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
@Table(name="tbl_towers")
public class MonsterTower {

    @Id
    @Column(name="tower_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="tower_name")
    private String towerName;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="tower_file_id", unique = true)
    private FileInfo towerModelingFileInfo;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="tower_image_id", unique = true)
    private FileInfo towerImageInfo;

    @Column(name="monster_name")
    private String monsterName;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="monster_file_id", unique = true)
    private FileInfo monsterModelingFileInfo;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="monster_image_id", unique = true)
    private FileInfo monsterImageFileInfo;

    @Column(name="ability")
    private String ability;

    protected MonsterTower(){}

    public MonsterTower( String towerName, FileInfo towerModelingFileInfo, FileInfo towerImageInfo, String monsterName, FileInfo monsterModelingFileInfo, FileInfo monsterImageFileInfo, String ability) {
        this.towerName = towerName;
        this.towerModelingFileInfo = towerModelingFileInfo;
        this.towerImageInfo = towerImageInfo;
        this.monsterName = monsterName;
        this.monsterModelingFileInfo = monsterModelingFileInfo;
        this.monsterImageFileInfo = monsterImageFileInfo;
        this.ability = ability;
    }

    public Integer getId() {
        return id;
    }

    public String getTowerName() {
        return towerName;
    }

    public FileInfo getTowerModelingFileInfo() {
        return towerModelingFileInfo;
    }

    public FileInfo getTowerImageInfo() {
        return towerImageInfo;
    }

    public FileInfo getMonsterImageFileInfo() {
        return monsterImageFileInfo;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public FileInfo getMonsterModelingFileInfo() {
        return monsterModelingFileInfo;
    }


    public String getAbility() {
        return ability;
    }
}