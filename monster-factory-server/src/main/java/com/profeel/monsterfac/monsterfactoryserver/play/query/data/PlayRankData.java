package com.profeel.monsterfac.monsterfactoryserver.play.query.data;

import lombok.NoArgsConstructor;

/**
 * <pre>
 * Class : PlayRankData
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@NoArgsConstructor
public class PlayRankData {

    private int rankingId;
    private String playTime;
    private PlayGameData playGameData;
    private PlayerData playerData;


    public PlayRankData(int rankingId, String playTime, PlayerData playerData, PlayGameData playGameData) {
        this.rankingId = rankingId;
        this.playTime = playTime;
        this.playerData = playerData;
        this.playGameData = playGameData;
    }

    public void setRankingId(int rankingId) {
        this.rankingId = rankingId;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public void setPlayerData(PlayerData playerData) {
        this.playerData = playerData;
    }

    public void setPlayGameData(PlayGameData playGameData) {
        this.playGameData = playGameData;
    }

    public int getRankingId() {
        return rankingId;
    }

    public String getPlayTime() {
        return playTime;
    }

    public PlayerData getPlayerData() {
        return playerData;
    }

    public PlayGameData getPlayGameData() {
        return playGameData;
    }

    @Override
    public String toString() {
        return "PlayRankData{" +
                "rankingId=" + rankingId +
                ", playTime='" + playTime + '\'' +
                ", playerData=" + playerData +
                ", playGameData=" + playGameData +
                '}';
    }
}
