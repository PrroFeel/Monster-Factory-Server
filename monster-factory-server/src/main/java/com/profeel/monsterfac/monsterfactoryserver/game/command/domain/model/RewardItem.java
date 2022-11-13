package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.ItemId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

/**
 * <pre>
 * Class : RewardItem
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Embeddable
public class RewardItem {
    @Embedded
    private ItemId itemId;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_quantity")
    private Integer quantity;

    protected RewardItem(){}

    public RewardItem(ItemId itemId, String name, Integer quantity) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardItem that = (RewardItem) o;
        return Objects.equals(itemId, that.itemId) && Objects.equals(name, that.name) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, quantity);
    }
}
