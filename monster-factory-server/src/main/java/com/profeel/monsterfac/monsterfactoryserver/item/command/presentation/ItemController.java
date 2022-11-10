package com.profeel.monsterfac.monsterfactoryserver.item.command.presentation;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.dto.RegistItemRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.service.RegistItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    public ItemController(RegistItemService registItemService) {
        this.registItemService = registItemService;
    }

    @ApiOperation(value = "아이템 추가", notes = "아이템을 추가(등록)하는 api")
    @PostMapping(value = "/regist")
    public ResponseEntity<ResponseDTO> registItem(RegistItemRequestDTO registItemRequest) throws IOException {

        System.out.println("controller file" + registItemRequest.getItemImgFile());

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK.value(), "아이템 추가 완료", registItemService.registItemImg(registItemRequest)));
    }

}
