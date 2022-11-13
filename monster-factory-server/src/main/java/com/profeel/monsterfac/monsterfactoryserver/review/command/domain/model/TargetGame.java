package com.profeel.monsterfac.monsterfactoryserver.review.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.GameId;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : TargetGame
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Embeddable
public class TargetGame {
    @AttributeOverride(name="id", column = @Column(name="target_game_id"))
    private GameId gameId;


    protected TargetGame(){}

    public TargetGame(GameId gameId) {
        this.gameId = gameId;
    }

    public GameId getGameId() {
        return gameId;
    }
}
