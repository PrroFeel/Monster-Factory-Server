package com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.exception.ItemPriceException;

import javax.persistence.*;

/**
 * <pre>
 * Class : Item
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Entity
@Table(name = "tbl_items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private int itemPrice;

    @Column(name = "item_img_url")
    private String itemImgUrl;

    @Embedded
    private ItemCategory categoryId;

    public Item() {}

    public Item(int itemId, String itemName, int itemPrice, String itemImgUrl, ItemCategory categoryId) {
        this.itemId = itemId;
        this.itemName = itemName;
        validateNegativePrice(itemPrice);
        this.itemImgUrl = itemImgUrl;
        this.categoryId = categoryId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public ItemCategory getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemImgUrl='" + itemImgUrl + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    private void validateNegativePrice(int itemPrice) {
        if(itemPrice < 0) {
            throw new ItemPriceException("아이템 가격은 음수일 수 없습니다");
        }
    }
}
