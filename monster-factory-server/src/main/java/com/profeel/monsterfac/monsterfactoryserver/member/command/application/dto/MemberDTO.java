package com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto;

import com.profeel.monsterfac.monsterfactoryserver.common.model.Money;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * <pre>
 * Class : MemberDTO
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

public class MemberDTO implements UserDetails {

    private String memberId;
    private String accessToken;
    private String gender;
    private Date birthday;
    private String secessionYn;
    private Money money;
    private Date memberRegistDate;

    public MemberDTO() {}

    public MemberDTO(String memberId, String accessToken, String gender, Date birthday, String secessionYn, Money money, Date memberRegistDate, Collection<? extends GrantedAuthority> authorities) {
        this.memberId = memberId;
        this.accessToken = accessToken;
        this.gender = gender;
        this.birthday = birthday;
        this.secessionYn = secessionYn;
        this.money = money;
        this.memberRegistDate = memberRegistDate;
        this.authorities = authorities;

    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    // security 설정

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.accessToken;
    }

    @Override
    public String getUsername() {
        return this.memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberId=" + memberId +
                ", password=" + accessToken +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", secessionYn='" + secessionYn + '\'' +
                ", money=" + money +
                ", auth='" + memberRegistDate + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
