package com.profeel.monsterfac.monsterfactoryserver.history.entity;

import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.MemberId;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;

/**
 * <pre>
 * Class : Changer
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-19       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class Changer {
    @AttributeOverride(name="id", column = @Column(name="changer_member_id"))
    MemberId memberId;

    protected Changer(){}

    public Changer(MemberId memberId) {
        this.memberId = memberId;
    }

    public MemberId getMemberId() {
        return memberId;
    }

}
