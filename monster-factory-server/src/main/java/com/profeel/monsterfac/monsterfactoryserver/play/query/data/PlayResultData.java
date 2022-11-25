package com.profeel.monsterfac.monsterfactoryserver.play.query.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Class : PlayResultData
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-20       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Entity
@Table(name = "tbl_play_result")
public class PlayResultData {

    @Id
    @Column(name = "play_result_id")
    private int playResultId;

    @Column(name="player_id")
    private String playerId;

    @Column(name="play_game_id")
    private int playGameId;

    @Column(name = "play_time")
    private String playTime;

    protected PlayResultData(){}

    public PlayResultData(int playResultId, String playerId, int playGameId, String playTime) {
        this.playResultId = playResultId;
        this.playerId = playerId;
        this.playGameId = playGameId;
        this.playTime = playTime;
    }

    public int getPlayResultId() {
        return playResultId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getPlayGameId() {
        return playGameId;
    }

    public String getPlayTime() {
        return playTime;
    }
}
