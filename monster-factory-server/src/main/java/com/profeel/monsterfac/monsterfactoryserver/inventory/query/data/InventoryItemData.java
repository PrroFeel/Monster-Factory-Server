package com.profeel.monsterfac.monsterfactoryserver.inventory.query.data;

import com.profeel.monsterfac.monsterfactoryserver.item.query.data.ItemCategoryData;
import com.profeel.monsterfac.monsterfactoryserver.item.query.data.ItemImgData;

/**
 * <pre>
 * Class : InventoryItemData
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

public class InventoryItemData {

    private int itemId;
    private String itemName;
    private int itemPrice;
    private InventoryItemImgData inventoryItemImgData;
    private InventoryItemCategoryData inventoryItemCategoryData;
    private String itemExplanation;
    private int itemPower;
    private String itemObjectName;

    public InventoryItemData() {}

    public InventoryItemData(int itemId, String itemName, int itemPrice, InventoryItemImgData inventoryItemImgData, InventoryItemCategoryData inventoryItemCategoryData, String itemExplanation, int itemPower, String itemObjectName) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.inventoryItemImgData = inventoryItemImgData;
        this.inventoryItemCategoryData = inventoryItemCategoryData;
        this.itemExplanation = itemExplanation;
        this.itemPower = itemPower;
        this.itemObjectName = itemObjectName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public InventoryItemImgData getInventoryItemImgData() {
        return inventoryItemImgData;
    }

    public void setInventoryItemImgData(InventoryItemImgData inventoryItemImgData) {
        this.inventoryItemImgData = inventoryItemImgData;
    }

    public InventoryItemCategoryData getInventoryItemCategoryData() {
        return inventoryItemCategoryData;
    }

    public void setInventoryItemCategoryData(InventoryItemCategoryData inventoryItemCategoryData) {
        this.inventoryItemCategoryData = inventoryItemCategoryData;
    }

    public String getItemExplanation() {
        return itemExplanation;
    }

    public void setItemExplanation(String itemExplanation) {
        this.itemExplanation = itemExplanation;
    }

    public int getItemPower() {
        return itemPower;
    }

    public void setItemPower(int itemPower) {
        this.itemPower = itemPower;
    }

    public String getItemObjectName() {
        return itemObjectName;
    }

    public void setItemObjectName(String itemObjectName) {
        this.itemObjectName = itemObjectName;
    }

    @Override
    public String toString() {
        return "InventoryItemData{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", inventoryItemImgData=" + inventoryItemImgData +
                ", inventoryItemCategoryData=" + inventoryItemCategoryData +
                ", itemExplanation='" + itemExplanation + '\'' +
                ", itemPower=" + itemPower +
                ", itemObjectName='" + itemObjectName + '\'' +
                '}';
    }
}
