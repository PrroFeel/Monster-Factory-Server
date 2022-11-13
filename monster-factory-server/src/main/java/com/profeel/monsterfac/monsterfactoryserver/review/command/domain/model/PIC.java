package com.profeel.monsterfac.monsterfactoryserver.review.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.ManagerId;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : PIC
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Embeddable
public class PIC {
    @AttributeOverride(name="id", column = @Column(name="pic_manager_id"))
    private ManagerId managerId;

    protected PIC(){}

    public PIC(ManagerId managerId) {
        this.managerId = managerId;
    }

    public ManagerId getManagerId() {
        return managerId;
    }
}
