package com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.MemberId;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : Player
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
public class Player {

    @AttributeOverride(name="id", column = @Column(name="player_id"))
    private MemberId memberId;

    public Player() {}

    public Player(MemberId memberId) {
        this.memberId = memberId;
    }

    public MemberId getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "memberId=" + memberId +
                '}';
    }
}
