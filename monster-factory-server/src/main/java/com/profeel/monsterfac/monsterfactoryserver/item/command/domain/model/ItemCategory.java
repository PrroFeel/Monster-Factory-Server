package com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * <pre>
 * Class : ItemCategory
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

@Embeddable
public class ItemCategory implements Serializable {

    @Column(name = "item_category_id")
    private Integer categoryId;

    public ItemCategory() {}

    public ItemCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
