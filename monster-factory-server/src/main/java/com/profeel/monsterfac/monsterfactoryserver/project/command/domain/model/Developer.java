package com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.MemberId;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : Editor
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Embeddable
public class Developer {

    @AttributeOverrides(
            @AttributeOverride(name="id", column = @Column(name="developer_member_id"))
    )
    MemberId memberId;


    protected Developer() {}

    public Developer(MemberId memberId) {
        this.memberId = memberId;
    }



}
