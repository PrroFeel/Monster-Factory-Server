package com.profeel.monsterfac.monsterfactoryserver.category.command.application.dto;

import com.profeel.monsterfac.category.command.domain.model.Category;

/**
 * <pre>
 * Class : CategoryDTO
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

public class CategoryDTO {

    private String categoryName;
    private Category reqCategoryId;

    public CategoryDTO(String categoryName, Category reqCategoryId) {
        this.categoryName = categoryName;
        this.reqCategoryId = reqCategoryId;
    }

    public CategoryDTO() {

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category getReqCategoryId() {
        return reqCategoryId;
    }

    public void setReqCategoryId(Category reqCategoryId) {
        this.reqCategoryId = reqCategoryId;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryName='" + categoryName + '\'' +
                ", reqCategoryId=" + reqCategoryId +
                '}';
    }
}
