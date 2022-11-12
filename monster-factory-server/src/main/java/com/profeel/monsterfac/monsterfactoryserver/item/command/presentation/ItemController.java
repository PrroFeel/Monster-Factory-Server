package com.profeel.monsterfac.monsterfactoryserver.item.command.presentation;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.dto.RegistItemRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.service.RegistItemService;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.service.UpdateItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * <pre>
 * Class : ItemController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@RestController
@RequestMapping("/item")
public class ItemController {

    private final RegistItemService registItemService;
    private final UpdateItemService updateItemService;

    @Autowired
    public ItemController(RegistItemService registItemService, UpdateItemService updateItemService) {
        this.registItemService = registItemService;
        this.updateItemService = updateItemService;
    }

    @ApiOperation(value = "아이템 추가", notes = "아이템을 추가(등록)하는 api")
    @PostMapping(value = "/regist")
    public ResponseEntity<ResponseDTO> registItem(RegistItemRequestDTO registItemRequest) throws IOException {

        System.out.println("controller file" + registItemRequest.getItemImgFile());

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK.value(), "아이템 추가 완료", registItemService.registItemImg(registItemRequest)));
    }

    @ApiOperation(value = "아이템 정보 수정", notes = "아이템 정보를 수정하는 api")
    @PutMapping(value = "/{id}/update")
    public ResponseEntity<ResponseDTO> updateItem(@PathVariable("id") int itemId, RegistItemRequestDTO registItemRequestInfo) throws IOException {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK.value(), "아이템 정보 수정 성공", updateItemService.updateItemInfo(itemId, registItemRequestInfo)));
    }

}
