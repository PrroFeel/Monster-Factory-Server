package com.profeel.monsterfac.monsterfactoryserver.tower.query.data;

import com.profeel.monsterfac.monsterfactoryserver.file.query.data.ImageUrlData;

import javax.persistence.*;

/**
 * <pre>
 * Class : TowerData
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-21       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Entity
@Table(name="tbl_towers")
public class MonsterTowerData {

    @Id
    @Column(name="tower_id")
    private Integer id;

    @Column(name="tower_name")
    private String towerName;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="tower_image_id", unique = true)
    private ImageUrlData towerImage;

    @Column(name="monster_name")
    private String monsterName;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="monster_image_id", unique = true)
    private ImageUrlData monsterImage;

    @Column(name="ability")
    private String ability;

    protected MonsterTowerData(){}

    public Integer getId() {
        return id;
    }

    public String getTowerName() {
        return towerName;
    }

    public ImageUrlData getTowerImage() {
        return towerImage;
    }

    public ImageUrlData getMonsterImage() {
        return monsterImage;
    }

    public String getMonsterName() {
        return monsterName;
    }



    public String getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return "MonsterTowerData{" +
                "id=" + id +
                ", towerName='" + towerName + '\'' +
                ", towerImage=" + towerImage +
                ", monsterName='" + monsterName + '\'' +
                ", monsterImage=" + monsterImage +
                ", ability='" + ability + '\'' +
                '}';
    }
}
