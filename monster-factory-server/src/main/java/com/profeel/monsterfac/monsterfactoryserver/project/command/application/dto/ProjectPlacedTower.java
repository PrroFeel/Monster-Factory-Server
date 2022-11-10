package com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto;

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
 * @see 참고할 class 또는 외부 url
 */
public class ProjectPlacedTower {
    private Integer towerId;
    private Object ability;  // 고유 능력
    private Object pattern;  // 공격 패턴
    private Object transform; // 위치, 스케일, mat

    protected ProjectPlacedTower() {}

    public ProjectPlacedTower(Integer towerId, Object ability, Object pattern, Object transform) {
        this.towerId = towerId;
        this.ability = ability;
        this.pattern = pattern;
        this.transform = transform;
    }

    public Integer getTowerId() {
        return towerId;
    }

    public void setTowerId(Integer towerId) {
        this.towerId = towerId;
    }

    public Object getAbility() {
        return ability;
    }

    public void setAbility(Object ability) {
        this.ability = ability;
    }

    public Object getPattern() {
        return pattern;
    }

    public void setPattern(Object pattern) {
        this.pattern = pattern;
    }

    public Object getTransform() {
        return transform;
    }

    public void setTransform(Object transform) {
        this.transform = transform;
    }

    @Override
    public String toString() {
        return "ProjectPlacedTower{" +
                "towerId=" + towerId +
                ", ability='" + ability + '\'' +
                ", pattern='" + pattern + '\'' +
                ", transform='" + transform + '\'' +
                '}';
    }
}
