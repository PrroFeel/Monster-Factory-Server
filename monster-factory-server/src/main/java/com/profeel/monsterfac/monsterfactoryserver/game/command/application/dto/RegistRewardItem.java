package com.profeel.monsterfac.monsterfactoryserver.game.command.application.dto;

/**
 * <pre>
 * Class : RegistRewardItem
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class RegistRewardItem {
    private int id;
    private int quantity;

    protected RegistRewardItem(){}
    public RegistRewardItem(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RegistRewardItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
