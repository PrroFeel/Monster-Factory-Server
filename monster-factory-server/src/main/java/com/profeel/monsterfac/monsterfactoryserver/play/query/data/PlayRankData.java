package com.profeel.monsterfac.monsterfactoryserver.play.query.data;

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

public class PlayRankData {

    private String playTime;
    private PlayerData playerData;
    private PlayGameData playGameData;


    public PlayRankData(String playTime, PlayerData playerData, PlayGameData playGameData) {
        this.playTime = playTime;
        this.playerData = playerData;
        this.playGameData = playGameData;
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
                "playTime='" + playTime + '\'' +
                ", playerData=" + playerData +
                ", playGameData=" + playGameData +
                '}';
    }
}
