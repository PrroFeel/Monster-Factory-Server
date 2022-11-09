package com.profeel.monsterfac.monsterfactoryserver.category.command.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * Class : Category
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-08       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Entity
@Table(name="tbl_item_category")
public class Category implements Serializable {

    @Id
    @Column(name="item_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name="item_category_name")
    @NotNull
    private String categoryName;

    // 셀프 참조를 위한 부모 정의
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="ref_item_category_id")
    private Category parRefCategoryId;

    // 셀프 참조를 위한 자식 정의
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parRefCategoryId")
    private List<Category> children;

    public Category() {}

    public Category(int categoryId, String categoryName, Category parRefCategoryId) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parRefCategoryId = parRefCategoryId;
    }

    public Category(String categoryName) {
    }

    public Category(int categoryId) {

    }

    public Category(String categoryName, int refCategoryId) {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category getParRefCategoryId() {
        return parRefCategoryId;
    }

    public void setParRefCategoryId(Category parRefCategoryId) {
        this.parRefCategoryId = parRefCategoryId;
    }

    @Override
    public String toString() {
        return "ItemCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", parRefCategoryId=" + parRefCategoryId +
                '}';
    }
}
