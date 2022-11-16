package com.profeel.monsterfac.monsterfactoryserver.category.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.category.query.data.CategoryData;
import com.profeel.monsterfac.monsterfactoryserver.category.query.service.CategoryFindAllService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(tags = {"Category 조회 API"}, description = "item category 조회 api")
@RestController
@RequestMapping("/categorys")
public class CategoryQueryController {

    private CategoryFindAllService categoryFindAllService;

    @Autowired
    public CategoryQueryController(CategoryFindAllService categoryFindAllService) {
        this.categoryFindAllService = categoryFindAllService;
    }

    @ApiOperation(value = "카테고리 목록 조회", notes = "카테고리 목록을 조회하는 api")
    @GetMapping
    public ResponseEntity<?> getCategorys() {

        List<CategoryData> categoryDataList = categoryFindAllService.findAllCategorys();

        return ResponseEntity.ok().body(categoryDataList);
    }
}
