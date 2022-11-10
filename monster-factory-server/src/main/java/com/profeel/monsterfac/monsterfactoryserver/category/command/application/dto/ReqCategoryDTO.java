package com.profeel.monsterfac.monsterfactoryserver.category.command.application.dto;

/**
 * <pre>
 * Class : ReqCategoryDTO
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

public class ReqCategoryDTO {

    private String categoryName;

    private int refCategoryId;

    public ReqCategoryDTO() {}

    public ReqCategoryDTO(String categoryName, int refCategoryId) {
        this.categoryName = categoryName;
        this.refCategoryId = refCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getRefCategoryId() {
        return refCategoryId;
    }
}
