package com.profeel.monsterfac.monsterfactoryserver.purchase.application.service;

import com.profeel.monsterfac.monsterfactoryserver.purchase.application.dto.PurchaseRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.Purchase;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.PurchasedItem;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.Purchaser;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.repository.PurchaseRepository;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.service.PurchaseService;
import org.springframework.stereotype.Service;

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

    int purchaseItem(PurchaseRequestDTO purchaseRequest){

        PurchasedItem purchasedItem = purchaseService.createPurchasedItem(purchaseRequest.getPurchasedItemId());
        Purchaser purchaser = purchaseService.changeMoneyAndCreatePurchaser(purchaseRequest.getPurchaserId(), purchasedItem.getPrice());
        purchaseService.putInventory(purchaser.getMemberId().getId(), purchasedItem.getItemId().getId());

        Purchase newPurchase = purchaseRepository.save(
                new Purchase(
                        purchaser,
                        purchasedItem,
                        purchaseRequest.getPurchaseDatetime()
                )
        );

        purchaseService.logCoinDecrease(purchaser.getMemberId().getId(), purchaseRequest.getPurchaseDatetime(), newPurchase.getId(), purchasedItem.getPrice(),"아이템 구매");

        return newPurchase.getId();
    }
}
