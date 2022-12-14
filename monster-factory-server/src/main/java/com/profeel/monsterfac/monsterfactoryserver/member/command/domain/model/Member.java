package com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.common.model.Money;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * <pre>
 * Class : Member
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-03       최은진           최초 생성
 * 2022-11-18       최윤서           money 증감 로직 추가
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Entity
@Table(name="tbl_members")
@DynamicUpdate
public class Member {

    @Id
    @NotBlank
    @Column(name="member_id")
    private String memberId;

    @Embedded
    private Password password;

    @Column(name="member_gender")
    private String gender;

    @Column(name="member_birthday")
    private Date birthday;

    @Column(name="member_withdraw_yn")
    private String secessionYn;

    @Embedded
    private Money money;

    @Column(name="member_regist_date")
    private Date memberRegistDate;

    @Column(name="member_auth")
    private String auth;

    public Member(String memberId, Password password, String gender, Date birthday, String secessionYn, Money money, Date memberRegistDate, String auth) {
        this.memberId = memberId;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.secessionYn = secessionYn;
        this.money = money;
        this.memberRegistDate = memberRegistDate;
        this.auth = auth;
    }

    public Member() {}

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        if(memberId == null) throw new IllegalArgumentException("no memberId");
        this.memberId = memberId;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSecessionYn() {
        return secessionYn;
    }

    public void setSecessionYn(String secessionYn) {
        this.secessionYn = secessionYn;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Date getMemberRegistDate() {
        return memberRegistDate;
    }

    public void setMemberRegistDate(Date memberRegistDate) {
        this.memberRegistDate = memberRegistDate;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public void decreaseMoney(int amount){
        if(amount != 0){
            this.money = this.money.decrease(amount);
        }
    }

    public void increaseMoney(int amount){
        if(amount != 0){
            this.money = this.money.increase(amount);
        }
    }

}
