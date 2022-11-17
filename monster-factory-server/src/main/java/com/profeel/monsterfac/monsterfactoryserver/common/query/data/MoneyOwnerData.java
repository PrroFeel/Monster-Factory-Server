package com.profeel.monsterfac.monsterfactoryserver.common.query.data;

/**
 * <pre>
 * Class : MoneyOwnerData
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-17       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

public class MoneyOwnerData {

    private String memberId;

    public MoneyOwnerData() {}

    public MoneyOwnerData(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MoneyOwnerData{" +
                "memberId='" + memberId + '\'' +
                '}';
    }
}
