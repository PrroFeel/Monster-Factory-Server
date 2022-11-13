package com.profeel.monsterfac.monsterfactoryserver.play.query.data;

/**
 * <pre>
 * Class : PlayGameData
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

public class PlayGameData {

    private Integer playGameId;
    private String playGameName;

    public PlayGameData(Integer playGameId, String playGameName) {
        this.playGameId = playGameId;
        this.playGameName = playGameName;
    }

    public Integer getPlayGameId() {
        return playGameId;
    }

    public void setPlayGameId(Integer playGameId) {
        this.playGameId = playGameId;
    }

    public String getPlayGameName() {
        return playGameName;
    }

    public void setPlayGameName(String playGameName) {
        this.playGameName = playGameName;
    }

    @Override
    public String toString() {
        return "PlayGameData{" +
                "playGameId=" + playGameId +
                ", playGameName='" + playGameName + '\'' +
                '}';
    }
}
