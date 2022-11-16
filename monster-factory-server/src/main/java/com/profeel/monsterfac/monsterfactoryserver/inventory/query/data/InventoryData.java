package com.profeel.monsterfac.monsterfactoryserver.inventory.query.data;

/**
 * <pre>
 * Class : InventoryData
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-16       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

public class InventoryData {

    private int inventoryId;
    private String isUsing;
    private InventoryOwnerData inventoryOwnerData;
    private InventoryItemData inventoryItemData;

    public InventoryData() {}

    public InventoryData(int inventoryId, String isUsing, InventoryOwnerData inventoryOwnerData, InventoryItemData inventoryItemData) {
        this.inventoryId = inventoryId;
        this.isUsing = isUsing;
        this.inventoryOwnerData = inventoryOwnerData;
        this.inventoryItemData = inventoryItemData;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(String isUsing) {
        this.isUsing = isUsing;
    }

    public InventoryOwnerData getInventoryOwnerData() {
        return inventoryOwnerData;
    }

    public void setInventoryOwnerData(InventoryOwnerData inventoryOwnerData) {
        this.inventoryOwnerData = inventoryOwnerData;
    }

    public InventoryItemData getInventoryItemData() {
        return inventoryItemData;
    }

    public void setInventoryItemData(InventoryItemData inventoryItemData) {
        this.inventoryItemData = inventoryItemData;
    }

    @Override
    public String toString() {
        return "InventoryData{" +
                "inventoryId=" + inventoryId +
                ", isUsing='" + isUsing + '\'' +
                ", inventoryOwnerData=" + inventoryOwnerData +
                ", inventoryItemData=" + inventoryItemData +
                '}';
    }
}
