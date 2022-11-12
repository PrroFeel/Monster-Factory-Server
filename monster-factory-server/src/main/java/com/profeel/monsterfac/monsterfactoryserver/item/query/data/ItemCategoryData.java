package com.profeel.monsterfac.monsterfactoryserver.item.query.data;

/**
 * <pre>
 * Class : ItemCategoryData
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

public class ItemCategoryData {

    private int itemCategoryId;
    private String itemCategoryName;

    public ItemCategoryData(int itemCategoryId, String itemCategoryName) {
        this.itemCategoryId = itemCategoryId;
        this.itemCategoryName = itemCategoryName;
    }

    public int getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(int itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }

    @Override
    public String toString() {
        return "ItemCategoryData{" +
                "itemCategoryId=" + itemCategoryId +
                ", itemCategoryName='" + itemCategoryName + '\'' +
                '}';
    }
}
