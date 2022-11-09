package com.profeel.monsterfac.monsterfactoryserver.category.command.presentation;

import com.profeel.monsterfac.category.command.application.dto.ReqCategoryDTO;
import com.profeel.monsterfac.category.command.application.service.ReqCategoryService;
import com.profeel.monsterfac.common.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <pre>
 * Class : CategoryController
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

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final ReqCategoryService categoryService;

    public CategoryController(ReqCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/regist")
    public ResponseEntity<ResponseDto> registCategory(@RequestBody @Valid ReqCategoryDTO reqCategoryinfo) {

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK.value(), "카테고리 추가 성공", categoryService.registCategory(reqCategoryinfo)));
    }
}
