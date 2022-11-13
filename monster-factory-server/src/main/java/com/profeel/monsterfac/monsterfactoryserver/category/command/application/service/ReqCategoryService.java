package com.profeel.monsterfac.monsterfactoryserver.category.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.category.command.application.dto.CategoryDTO;
import com.profeel.monsterfac.monsterfactoryserver.category.command.application.dto.ReqCategoryDTO;
import com.profeel.monsterfac.monsterfactoryserver.category.command.domain.model.Category;
import com.profeel.monsterfac.monsterfactoryserver.category.command.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Class : CategoryService
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

@Service
public class ReqCategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public ReqCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public CategoryDTO registCategory(ReqCategoryDTO reqCategoryinfo) {

        System.out.println("reqCategoryInfo Name : " + reqCategoryinfo.getCategoryName());

        Category newCategory = new Category(
                reqCategoryinfo.getCategoryName(),
                reqCategoryinfo.getRefCategoryId()
        );

        categoryRepository.save(newCategory);

        CategoryDTO categoryDTO = new CategoryDTO(
                newCategory.getCategoryName(),
                newCategory.getParRefCategoryId()
        );

        return categoryDTO;
    }
}
