package com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.exception.ItemPriceException;
import io.swagger.annotations.ApiModelProperty;

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

    @ApiModelProperty(value="아이템 아이디", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @ApiModelProperty(value="아이템 이름", example = "단검")
    @Column(name = "item_name")
    private String itemName;

    @ApiModelProperty(value="아이템 가격", example = "100")
    @Column(name = "item_price")
    private int itemPrice;

    @ApiModelProperty(value="아이템 url", example = "http://~~")
    @Column(name = "item_img_url")
    private String itemImgUrl;

    @ApiModelProperty(value="아이템이 속한 카테고리 아이디", example = "1")
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
