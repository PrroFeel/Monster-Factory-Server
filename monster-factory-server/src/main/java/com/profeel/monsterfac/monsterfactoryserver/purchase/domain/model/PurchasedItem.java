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
    ItemId id;

    @Column(name="purchased_item_name")
    String name;

    protected PurchasedItem(){}

    public PurchasedItem(ItemId id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemId getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
