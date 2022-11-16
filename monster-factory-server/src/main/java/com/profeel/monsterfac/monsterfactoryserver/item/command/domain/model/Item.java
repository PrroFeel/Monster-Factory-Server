package com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ImageFileInfo;
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

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="item_img_id", unique = true)
    private FileInfo itemImgInfo;

    @ApiModelProperty(value="아이템이 속한 카테고리 아이디", example = "1")
    @Embedded
    private ItemCategory categoryId;

    @ApiModelProperty(value="아이템 설명", example = "용 미니언을 소횐하는 지팡이")
    @Column(name = "item_explanation")
    private String itemExplanation;

    @ApiModelProperty(value="아이템 공격력", example = "20")
    @Column(name = "item_power")
    private int itemPower;

    @ApiModelProperty(value="아이템 오브젝트 이름", example = "dragon's cane")
    @Column(name = "item_object_name")
    private String itemObjectName;

    public Item() {}

    public Item(String itemName, int itemPrice, FileInfo itemImgInfo, ItemCategory categoryId, String itemExplanation, int itemPower, String itemObjectName) {
        this.itemName = itemName;
        validateNegativePrice(itemPrice);
        this.itemImgInfo = itemImgInfo;
        this.categoryId = categoryId;
        this.itemExplanation = itemExplanation;
        this.itemPower = itemPower;
        this.itemObjectName = itemObjectName;
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

    public FileInfo getItemImgUrl() {
        return itemImgInfo;
    }

    public ItemCategory getCategoryId() {
        return categoryId;
    }

    public String getItemExplanation() {
        return itemExplanation;
    }

    public int getItemPower() {
        return itemPower;
    }

    public String getItemObjectName() {
        return itemObjectName;
    }


    private void validateNegativePrice(int itemPrice) {
        if(itemPrice < 0) {
            throw new ItemPriceException("아이템 가격은 음수일 수 없습니다");
        }
        this.itemPrice = itemPrice;
    }

    public void changeItem(String itemName, int itemPrice, ImageFileInfo itemImgFile, ItemCategory itemCategoryCode, String itemExplanation, int itemPower, String itemObjectName) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImgInfo = itemImgFile;
        this.categoryId = itemCategoryCode;
        this.itemExplanation = itemExplanation;
        this.itemPower = itemPower;
        this.itemObjectName = itemObjectName;
    };
}
