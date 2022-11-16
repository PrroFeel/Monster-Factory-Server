package com.profeel.monsterfac.monsterfactoryserver.item.query.data;

import lombok.NoArgsConstructor;

/**
 * <pre>
 * Class : ItemData
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@NoArgsConstructor
public class ItemData {

    private int itemId;
    private String itemName;
    private int itemPrice;
    private ItemImgData itemImgData;
    private ItemCategoryData itemCategoryData;
    private String itemExplanation;
    private int itemPower;
    private String itemObjectName;


    public ItemData(int itemId, String itemName, int itemPrice, ItemImgData itemImgData, ItemCategoryData itemCategoryData, String itemExplanation, int itemPower, String itemObjectName) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImgData = itemImgData;
        this.itemCategoryData = itemCategoryData;
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

    public ItemImgData getItemImgData() {
        return itemImgData;
    }

    public void setItemImgData(ItemImgData itemUrl) {
        this.itemImgData = itemUrl;
    }

    public ItemCategoryData getItemCategoryData() {
        return itemCategoryData;
    }

    public void setItemCategoryData(ItemCategoryData categoryName) {
        this.itemCategoryData = categoryName;
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
        return "ItemData{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemImgData=" + itemImgData +
                ", itemCategoryData=" + itemCategoryData +
                ", itemExplanation=" + itemExplanation +
                ", itemPower=" + itemPower +
                ", itemObjectName='" + itemObjectName + '\'' +
                '}';
    }
}
