package com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.ItemId;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * Class : PurchasedItem
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-17       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Embeddable
public class PurchasedItem {
    @AttributeOverride(name="id", column = @Column(name="purchased_item_id"))
    ItemId itemId;

    @Column(name="purchased_item_name")
    String name;

    @Column(name="purchased_item_price")
    int price;

    protected PurchasedItem(){}

    public PurchasedItem(ItemId itemId, String name, int price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
