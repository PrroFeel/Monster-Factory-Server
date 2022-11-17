package com.profeel.monsterfac.monsterfactoryserver.common.query.data;

import com.profeel.monsterfac.monsterfactoryserver.common.query.data.MoneyOwnerData;

/**
 * <pre>
 * Class : MoneyData
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

public class MoneyData {

    private int money;
    private MoneyOwnerData moneyOwnerData;

    public MoneyData() {}

    public MoneyData(int money, MoneyOwnerData moneyOwnerData) {
        this.money = money;
        this.moneyOwnerData = moneyOwnerData;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public MoneyOwnerData getMoneyOwnerData() {
        return moneyOwnerData;
    }

    public void setMoneyOwnerData(MoneyOwnerData moneyOwnerData) {
        this.moneyOwnerData = moneyOwnerData;
    }

    @Override
    public String toString() {
        return "MoneyData{" +
                "money=" + money +
                ", moneyOwnerData=" + moneyOwnerData +
                '}';
    }
}
