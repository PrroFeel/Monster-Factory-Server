package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : Objects
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-14       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Embeddable
public class Objects {
    @Column(name="game_map_type")
    private String mapType;

    @Column(name="game_tower_infos")
    private String towerList;

    @Column(name="game_obstacle_list")
    private String obstacleList;

    @Column(name="game_debuff_list")
    private String debuffList;


    protected Objects(){}

    public Objects(String mapType, String towerList, String obstacleList, String debuffList) {
        this.mapType = mapType;
        this.towerList = towerList;
        this.obstacleList = obstacleList;
        this.debuffList = debuffList;
    }

    public String getMapType() {
        return mapType;
    }

    public String getTowerList() {
        return towerList;
    }

    public String getObstacleList() {
        return obstacleList;
    }

    public String getDebuffList() {
        return debuffList;
    }
}
