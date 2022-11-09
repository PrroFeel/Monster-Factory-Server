package com.profeel.monsterfac.member.command.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : Password
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-02       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Embeddable
public class Password {

    @Column(name="member_pwd")
    private String value;

    protected Password() {}

    public Password(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean match(String password) {
        return this.value.equals(password);
    }
}

