package com.profeel.monsterfac.monsterfactoryserver.purchase.presentation.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.purchase.application.dto.PurchaseRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.purchase.application.dto.PurchaseResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.purchase.application.service.PurchaseRequestService;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.Purchase;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <pre>
 * Class : PurchaseController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-18       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Api(tags = {"구매 API"}, description = "purchase api")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "성공", response = PurchaseResponseDTO.class)
})
@Controller
@RequestMapping("/purchases")
public class PurchaseController {

    private PurchaseRequestService purchaseRequestService;

    @Autowired
    public PurchaseController(PurchaseRequestService purchaseRequestService){
        this.purchaseRequestService = purchaseRequestService;
    }
    @ApiOperation(value = "아이템 구매", notes = "아이템을 구매 요청하는 api로 유저의 돈이 감소하고 인벤토리에 해당 아이템이 추가된다")
    @PostMapping("")
    public ResponseEntity<ResponseDTO> purchaseItem(@RequestParam("userId") String userId, @RequestBody PurchaseRequestDTO purchaseRequest){
        System.out.println("[PurchaseController] purchaseItem -- POST");
        System.out.println("purchaseRequest : " +purchaseRequest);

        // 필수 데이터 유무 검사


        Purchase purchased = purchaseRequestService.purchaseItem(userId, purchaseRequest);

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "아이템 구매 성공"
                        , new PurchaseResponseDTO(
                                purchased.getId(),
                            purchased.getPurchaeItem().getName(),
                            purchased.getPurchaser().getMemberId().getId(),
                            purchased.getPurchaser().getBalance()
                        )
                )
        );
    }
}
