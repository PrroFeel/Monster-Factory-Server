package com.profeel.monsterfac.monsterfactoryserver.member.query.data;

import java.util.Date;

/**
 * <pre>
 * Class : MemberInfoData
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

public class MemberInfoData {

    private String memberId;
    private Date memberBirthday;
    private String memberGender;
    private int memberMoney;

    public MemberInfoData(String memberId, Date memberBirthday, String memberGender, int memberMoney) {
        this.memberId = memberId;
        this.memberBirthday = memberBirthday;
        this.memberGender = memberGender;
        this.memberMoney = memberMoney;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getMemberBirthday() {
        return memberBirthday;
    }

    public void setMemberBirthday(Date memberBirthday) {
        this.memberBirthday = memberBirthday;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    public int getMemberMoney() {
        return memberMoney;
    }

    public void setMemberMoney(int memberMoney) {
        this.memberMoney = memberMoney;
    }

    @Override
    public String toString() {
        return "MemberInfoData{" +
                "MemberId='" + memberId + '\'' +
                ", memberBirthday=" + memberBirthday +
                ", memberGender='" + memberGender + '\'' +
                ", memberMoney=" + memberMoney +
                '}';
    }
}
