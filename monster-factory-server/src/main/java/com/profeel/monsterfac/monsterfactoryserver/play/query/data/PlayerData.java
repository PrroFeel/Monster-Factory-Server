package com.profeel.monsterfac.monsterfactoryserver.play.query.data;

/**
 * <pre>
 * Class : PlayerData
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

public class PlayerData {

    private String player;

    public PlayerData(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "PlayerData{" +
                "player='" + player + '\'' +
                '}';
    }
}
