package com.profeel.monsterfac.monsterfactoryserver.member.command.application.dto;


import java.util.Date;

/**
 * <pre>
 * Class : SignUpDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

public class SignUpDTO {

    //    private MemberId memberId;
    private String memberId;
    private String password;
    private String gender;
    private Date birthday;

    public SignUpDTO(String memberId, String password, String gender, Date birthday) {
        this.memberId = memberId;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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

    @Override
    public String toString() {
        return "SignUpDTO{" +
                "memberId=" + memberId +
                ", password=" + password +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
