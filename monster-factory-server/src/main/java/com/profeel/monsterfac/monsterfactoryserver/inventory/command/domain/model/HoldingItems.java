package com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * <pre>
 * Class : HoldingItems
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Embeddable
public class HoldingItems implements Serializable {

    @Column(name = "inventory_holding_item")
    private int inventoryHoldingItem;

    public HoldingItems() {}

    public HoldingItems(int inventoryHoldingItem) {
        this.inventoryHoldingItem = inventoryHoldingItem;
    }

    public int getInventoryHoldingItem() {
        return inventoryHoldingItem;
    }

    @Override
    public String toString() {
        return "HoldingItems{" +
                "inventoryHoldingItem=" + inventoryHoldingItem +
                '}';
    }
}
