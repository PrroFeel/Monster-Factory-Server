package com.profeel.monsterfac.monsterfactoryserver.inventory.query.data;

/**
 * <pre>
 * Class : InventoryItemCategoryData
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

public class InventoryItemCategoryData {

    private int inventoryItemCategoryId;
    private String inventoryItemCategoryName;

    public InventoryItemCategoryData() {}

    public InventoryItemCategoryData(int inventoryItemCategoryId, String inventoryItemCategoryName) {
        this.inventoryItemCategoryId = inventoryItemCategoryId;
        this.inventoryItemCategoryName = inventoryItemCategoryName;
    }

    public int getInventoryItemCategoryId() {
        return inventoryItemCategoryId;
    }

    public void setInventoryItemCategoryId(int inventoryItemCategoryId) {
        this.inventoryItemCategoryId = inventoryItemCategoryId;
    }

    public String getInventoryItemCategoryName() {
        return inventoryItemCategoryName;
    }

    public void setInventoryItemCategoryName(String inventoryItemCategoryName) {
        this.inventoryItemCategoryName = inventoryItemCategoryName;
    }

    @Override
    public String toString() {
        return "InventoryItemCategoryData{" +
                "inventoryItemCategoryId=" + inventoryItemCategoryId +
                ", inventoryItemCategoryName='" + inventoryItemCategoryName + '\'' +
                '}';
    }
}
