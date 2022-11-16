package com.profeel.monsterfac.monsterfactoryserver.inventory.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.inventory.query.data.InventoryData;
import com.profeel.monsterfac.monsterfactoryserver.inventory.query.service.InventoryQueryService;
import com.profeel.monsterfac.monsterfactoryserver.item.query.data.ItemData;
import io.swagger.annotations.Api;
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
 * Class : InventoryQueryController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-16       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Api(tags = {"Inventory 조회 API"}, description = "inventory 조회 관련 api")
@RestController
@RequestMapping("/inventory")
public class InventoryQueryController {

    private InventoryQueryService inventoryQueryService;

    @Autowired
    public InventoryQueryController(InventoryQueryService inventoryQueryService) {
        this.inventoryQueryService = inventoryQueryService;
    }

    @ApiOperation(value = "인벤토리 조회", notes = "인벤토리 정보가 나오는 api이다")
    @GetMapping("/{id}")
    public ResponseEntity<?> findInventoryItemByMemberId(@PathVariable("id") String memberId) {

        List<InventoryData> inventoryDataList = inventoryQueryService.findInventoryItemByMemberId(memberId);

        return ResponseEntity.ok().body(inventoryDataList);
    }
}
