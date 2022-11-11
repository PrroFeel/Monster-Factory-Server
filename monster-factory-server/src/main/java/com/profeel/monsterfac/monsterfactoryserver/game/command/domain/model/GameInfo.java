package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : GameInfo
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
public class GameInfo {
    @Column(name="game_name")
    private String name;

    @Column(name="game_description")
    private String description;

    protected GameInfo(){}
    public GameInfo(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
