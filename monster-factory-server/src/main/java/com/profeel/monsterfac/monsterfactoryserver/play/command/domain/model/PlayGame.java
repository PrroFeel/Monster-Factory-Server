package com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.GameId;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : PlayGame
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-12       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Embeddable
public class PlayGame {

    @AttributeOverride(name="id", column = @Column(name="play_game_id"))
    private GameId gameId;

    public PlayGame() {};

    public PlayGame(GameId gameId) {
        this.gameId = gameId;
    }

    public GameId getGameId() {
        return gameId;
    }

    @Override
    public String toString() {
        return "PlayGame{" +
                "gameId=" + gameId +
                '}';
    }
}
