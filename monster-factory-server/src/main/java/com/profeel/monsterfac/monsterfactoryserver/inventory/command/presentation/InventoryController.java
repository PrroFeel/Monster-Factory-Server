package com.profeel.monsterfac.monsterfactoryserver.inventory.command.presentation;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.application.dto.RegistInventoryRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.application.service.RegistInventoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * Class : InventoryController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final RegistInventoryService registInventoryService;

    @Autowired
    public InventoryController(RegistInventoryService registInventoryService) {
        this.registInventoryService = registInventoryService;
    }

    @ApiOperation(value = "인벤토리에 아이템 추가", notes = "인벤토리에 아이템을 추가하는 api")
    @PostMapping("/regist")
    public ResponseEntity<ResponseDTO> registInventory(RegistInventoryRequestDTO registInventoryRequestInfo) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK.value(), "인벤토리에 아이템 추가 완료", registInventoryService.registInventory(registInventoryRequestInfo)));
    }
}
