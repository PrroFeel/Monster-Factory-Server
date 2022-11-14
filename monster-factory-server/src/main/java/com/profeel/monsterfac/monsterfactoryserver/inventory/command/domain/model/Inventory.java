package com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * <pre>
 * Class : Inventory
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

@Entity
@Table(name = "tbl_inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;

    @Embedded
    private InventoryOwner inventoryOwner;

    @Embedded
    private HoldingItems holdingItems;

    @Column(name = "inventory_item_status")
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'NON_WEARING'")
    private InventoryItemStatus status;

    public Inventory() {}

    public Inventory(InventoryOwner inventoryOwner, HoldingItems holdingItems, InventoryItemStatus status) {
        this.inventoryOwner = inventoryOwner;
        this.holdingItems = holdingItems;
        this.status = status;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public InventoryOwner getInventoryOwner() {
        return inventoryOwner;
    }

    public HoldingItems getHoldingItems() {
        return holdingItems;
    }

    public InventoryItemStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", inventoryOwner=" + inventoryOwner +
                ", holdingItems=" + holdingItems +
                ", status=" + status +
                '}';
    }
}
