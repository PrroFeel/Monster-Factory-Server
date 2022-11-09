package com.profeel.monsterfac.monsterfactoryserver.member.query.data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Class : MemberData
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-06       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Entity
@Table(name="tbl_members")
public class MemberData {
    @Id
    @Column(name="member_id")
    private String id;

    @Column(name="member_pwd")
    private String password;


    protected MemberData() {}

    public MemberData(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getMemberId() {
        return id;
    }

}
