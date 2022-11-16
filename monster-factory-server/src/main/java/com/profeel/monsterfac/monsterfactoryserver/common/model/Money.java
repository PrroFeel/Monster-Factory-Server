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

    public void decrease(int amount){
        int result = this.value - amount;
        if(result < 0){
            throw new NagativeMoneyException("소유한 coin 이 충분하지 않습니다");
        }
        if(amount != 0){
            this.value = result;
        }
    }

    public void increase(int amount){
        int result = this.value + amount;
        if(amount != 0){
            this.value = result;
        }
        this.value = result;
    }


}