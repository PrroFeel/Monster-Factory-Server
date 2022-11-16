package com.profeel.monsterfac.monsterfactoryserver.item.command.application.dto;

import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.ItemCategory;

/**
 * <pre>
 * Class : ItemResponseDTO
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

public class ItemResponseDTO {

    private String itemName;
    private String itemImgUrl;
    private int itemPrice;
    private ItemCategory categoryId;
    private String itemExplanation;
    private int itemPower;
    private String itemObjectName;

    public ItemResponseDTO(String itemName, String itemImgUrl, int itemPrice, ItemCategory categoryId, String itemExplanation, int itemPower, String itemObjectName) {
        this.itemName = itemName;
        this.itemImgUrl = itemImgUrl;
        this.itemPrice = itemPrice;
        this.categoryId = categoryId;
        this.itemExplanation = itemExplanation;
        this.itemPower = itemPower;
        this.itemObjectName = itemObjectName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public ItemCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(ItemCategory categoryId) {
        this.categoryId = categoryId;
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
        return "ItemResponseDTO{" +
                "itemName='" + itemName + '\'' +
                ", itemImgUrl='" + itemImgUrl + '\'' +
                ", itemPrice=" + itemPrice +
                ", categoryId=" + categoryId +
                ", itemExplanation=" + itemExplanation +
                ", itemPower=" + itemPower +
                ", itemObjectName='" + itemObjectName + '\'' +
                '}';
    }
}
