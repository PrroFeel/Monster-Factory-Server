package com.profeel.monsterfac.monsterfactoryserver.common.model;

import com.profeel.monsterfac.monsterfactoryserver.common.exception.NagativeMoneyException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * <pre>
 * Class : Money
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-03       최은진           최초 생성
 * 2022-11-17       최윤서           money 증감 로직 추가
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Embeddable
public class Money implements Serializable {

    @Column(name="member_money")
    private int value;

    public Money(int value) {
        this.value = value;
    }

    protected Money() {}

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public Money decrease(int amount){
        int result = this.value - amount;
        if(result < 0){
            throw new NagativeMoneyException("소유한 coin 이 충분하지 않습니다");
        }
        return new Money(result);
    }

    public Money increase(int amount){
        return new Money( this.value + amount);
    }


}