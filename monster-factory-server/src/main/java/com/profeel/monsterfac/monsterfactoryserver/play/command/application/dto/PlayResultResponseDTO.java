package com.profeel.monsterfac.monsterfactoryserver.play.command.application.dto;

import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.PlayGame;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.Player;

import java.sql.Time;

/**
 * <pre>
 * Class : PlayResultResponseDTO
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

public class PlayResultResponseDTO {

    private Player playerId;
    private PlayGame gameId;
    private String playTime;

    public PlayResultResponseDTO(Player playerId, PlayGame gameId, String playTime) {
        this.playerId = playerId;
        this.gameId = gameId;
        this.playTime = playTime;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public PlayGame getGameId() {
        return gameId;
    }

    public String getPlayTime() {
        return playTime;
    }

    @Override
    public String toString() {
        return "PlayResultResponseDTO{" +
                "playerId='" + playerId + '\'' +
                ", gameId=" + gameId +
                ", playTime=" + playTime +
                '}';
    }
}
