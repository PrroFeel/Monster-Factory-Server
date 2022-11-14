package com.profeel.monsterfac.monsterfactoryserver.category.query.service;

import com.profeel.monsterfac.monsterfactoryserver.category.query.data.CategoryData;
import com.profeel.monsterfac.monsterfactoryserver.category.query.repository.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Class : CategoryFindAllService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-14       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Service
public class CategoryFindAllService {

    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryFindAllService(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryData> findAllCategorys() {

        return categoryMapper.findAllCategorys();
    }
}
