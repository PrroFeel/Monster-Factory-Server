package com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.MemberId;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : Purchaser
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-17       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Embeddable
public class Purchaser {
    @AttributeOverride(name="id", column = @Column(name="purchaser_member_id"))
    MemberId memberId;

    protected Purchaser(){}
    public Purchaser(MemberId memberId) {
        this.memberId = memberId;
    }

    public MemberId getMemberId() {
        return memberId;
    }
}
