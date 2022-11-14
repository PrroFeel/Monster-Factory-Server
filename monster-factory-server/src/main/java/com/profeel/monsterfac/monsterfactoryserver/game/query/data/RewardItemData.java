package com.profeel.monsterfac.monsterfactoryserver.game.query.data;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * <pre>
 * Class : RewardItem
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Embeddable
public class RewardItemData {

    @ApiModelProperty(example = "아이템 고유 번호")
    @Column(name = "item_id")
    private Integer itemId;

    @ApiModelProperty(example = "아이템 이름")
    @Column(name = "item_name")
    private String name;

    @ApiModelProperty(example = "보상 수량")
    @Column(name = "item_quantity")
    private Integer quantity;

    protected RewardItemData(){}

    public RewardItemData(Integer itemId, String name, Integer quantity) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardItemData that = (RewardItemData) o;
        return Objects.equals(itemId, that.itemId) && Objects.equals(name, that.name) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, quantity);
    }
}
