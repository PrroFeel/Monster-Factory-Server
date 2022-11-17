package com.profeel.monsterfac.monsterfactoryserver.purchase.application.service;

import com.profeel.monsterfac.monsterfactoryserver.purchase.application.dto.PurchaseRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.Purchase;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.PurchaseItem;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.Purchaser;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.repository.PurchaseRepository;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.service.PurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Class : PurchaseRequestService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-17       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Service
public class PurchaseRequestService {
    private PurchaseRepository purchaseRepository;
    private PurchaseService purchaseService;
    public PurchaseRequestService(PurchaseRepository purchaseRepository, PurchaseService purchaseService){
        this.purchaseRepository = purchaseRepository;
        this.purchaseService = purchaseService;
    }

    @Transactional
    public Purchase purchaseItem(String userId, PurchaseRequestDTO purchaseRequest){

        PurchaseItem purchasedItem = purchaseService.createPurchasedItem(purchaseRequest.getPurchasedItemId());
        Purchaser purchaser = purchaseService.changeMoneyAndCreatePurchaser(userId, purchasedItem.getPrice());
        purchaseService.putInventory(purchaser.getMemberId().getId(), purchasedItem.getItemId().getId());

        Purchase purchase = purchaseRepository.save(
                new Purchase(
                        purchaser,
                        purchasedItem,
                        purchaseRequest.getPurchaseDatetime()
                )
        );

//        if(purchasedItem.getPrice() != 0){
//            purchaseService.logCoinDecrease(purchaser.getMemberId().getId(), purchaseRequest.getPurchaseDatetime(), newPurchase.getId(), purchasedItem.getPrice(),"아이템 구매");
//        }


        return purchase;
    }
}
