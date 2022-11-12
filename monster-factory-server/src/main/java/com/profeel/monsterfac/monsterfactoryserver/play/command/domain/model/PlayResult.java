package com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model;

import javax.persistence.*;
import java.sql.Time;

/**
 * <pre>
 * Class : PlayResult
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

@Entity
@Table(name = "tbl_play_result")
public class PlayResult {

    @Id
    @Column(name = "play_result_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playResultId;

    @Embedded
    private Player playerId;

    @Embedded
    private PlayGame playGameId;

    @Column(name = "play_time")
    private Time playTime;


    public PlayResult() {}

    public PlayResult(int playResultId, Player playerId, PlayGame playGameId, Time playTime) {
        this.playResultId = playResultId;
        this.playerId = playerId;
        this.playGameId = playGameId;
        this.playTime = playTime;
    }

    public int getPlayResultId() {
        return playResultId;
    }

    public void setPlayResultId(int playResultId) {
        this.playResultId = playResultId;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public PlayGame getPlayGameId() {
        return playGameId;
    }

    public void setPlayGameId(PlayGame playGameId) {
        this.playGameId = playGameId;
    }

    public Time getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Time playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return "PlayResult{" +
                "playResultId=" + playResultId +
                ", playerId=" + playerId +
                ", playGameId=" + playGameId +
                ", playTime=" + playTime +
                '}';
    }
}
