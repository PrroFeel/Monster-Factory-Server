package com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.model.TowerId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * <pre>
 * Class : PlacedTower
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Embeddable
public class PlacedTower {

    @Embedded
    private TowerId towerId;

    @Column(name = "tower_ability")
    private String ability;  // 고유 능력

    @Column(name = "tower_pattern")
    private String pattern;  // 공격 패턴

    @Column(name = "tower_transform")
    private String transform; // 위치, 스케일, mat

    protected PlacedTower() {}

    public PlacedTower(TowerId towerId, String ability, String pattern, String transform) {
        this.towerId = towerId;
        this.ability = ability;
        this.pattern = pattern;
        this.transform = transform;
    }

    public TowerId getTowerId() {
        return towerId;
    }

    public String getAbility() {
        return ability;
    }

    public String getPattern() {
        return pattern;
    }

    public String getTransform() {
        return transform;
    }

    @Override
    public String toString() {
        return "PlacedTower{" +
                "towerId=" + towerId +
                ", ability='" + ability + '\'' +
                ", pattern='" + pattern + '\'' +
                ", transform='" + transform + '\'' +
                '}';
    }
}
