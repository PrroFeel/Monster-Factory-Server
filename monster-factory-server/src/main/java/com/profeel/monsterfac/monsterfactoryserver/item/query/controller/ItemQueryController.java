package com.profeel.monsterfac.monsterfactoryserver.item.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.item.query.data.ItemData;
import com.profeel.monsterfac.monsterfactoryserver.item.query.service.ItemQueryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 * Class : ItemQueryController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@RestController
@RequestMapping("/items")
public class ItemQueryController {

    private ItemQueryService itemQueryService;

    @Autowired
    public ItemQueryController(ItemQueryService itemQueryService) {
        this.itemQueryService = itemQueryService;
    }

    @ApiOperation(value = "아이템 목록 조회", notes = "아이템 전체 목록이 나오는 api이다")
    @GetMapping
    public ResponseEntity<?> findItem() {

        List<ItemData> itemDataList = itemQueryService.findItem();

        return ResponseEntity.ok().body(itemDataList);
    }

    @ApiOperation(value = "아이템 상세 조회", notes = "아이템 하나의 정보가 나오는 api이다")
    @GetMapping("/{id}")
    public ResponseEntity<?> findItemById(@PathVariable("id") int itemId) {

        List<ItemData> itemDataList = itemQueryService.findItemById(itemId);

        return ResponseEntity.ok().body(itemDataList);
    }
}
