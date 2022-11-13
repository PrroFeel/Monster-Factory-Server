package com.profeel.monsterfac.monsterfactoryserver.play.command.application.dto;

import java.sql.Date;
import java.sql.Time;

/**
 * <pre>
 * Class : RegistPlayResultDTO
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

public class RegistPlayResultDTO {

    private String playerId;
    private int gameId;
    private String playTime;

    public RegistPlayResultDTO(String playerId, int gameId, String playTime) {
        this.playerId = playerId;
        this.gameId = gameId;
        this.playTime = playTime;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return "RegistPlayResultDTO{" +
                "playerId='" + playerId + '\'' +
                ", gameId='" + gameId + '\'' +
                ", playTime=" + playTime +
                '}';
    }
}
