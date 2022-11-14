package com.profeel.monsterfac.monsterfactoryserver.category.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.category.query.data.CategoryData;
import com.profeel.monsterfac.monsterfactoryserver.category.query.service.CategoryFindAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 * Class : CategoryQueryController
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

@RestController
@RequestMapping("/categorys")
public class CategoryQueryController {

    private CategoryFindAllService categoryFindAllService;

    @Autowired
    public CategoryQueryController(CategoryFindAllService categoryFindAllService) {
        this.categoryFindAllService = categoryFindAllService;
    }

    @GetMapping
    public ResponseEntity<?> getCategorys() {

        List<CategoryData> categoryDataList = categoryFindAllService.findAllCategorys();

        return ResponseEntity.ok().body(categoryDataList);
    }
}
