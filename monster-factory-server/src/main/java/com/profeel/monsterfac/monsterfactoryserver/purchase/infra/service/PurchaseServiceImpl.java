package com.profeel.monsterfac.monsterfactoryserver.purchase.infra.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.history.dto.LogCoinVarianceRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.history.service.CoinVarianceService;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.application.dto.RegistInventoryRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.application.service.RegistInventoryService;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.service.ItemAppQueryService;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.Item;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.ItemId;
import com.profeel.monsterfac.monsterfactoryserver.member.command.application.service.ReqMemberService;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.PurchasedItem;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.Purchaser;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * Class : PurchaseServiceImpl
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
@DomainService
public class PurchaseServiceImpl implements PurchaseService {
    private ItemAppQueryService itemQueryService;
    private RegistInventoryService registInventoryService;
    private ReqMemberService reqMemberService;
    private CoinVarianceService coinVarianceService;

    @Autowired
    public PurchaseServiceImpl(ItemAppQueryService itemQueryService,
                               ReqMemberService reqMemberService,
                               CoinVarianceService coinVarianceService,
                               RegistInventoryService registInventoryService){
        this.itemQueryService = itemQueryService;
        this.reqMemberService =reqMemberService;
        this.coinVarianceService = coinVarianceService;
        this.registInventoryService = registInventoryService;
    }

    public Purchaser changeMoneyAndCreatePurchaser(String userId, int amount){
        return new Purchaser(reqMemberService.decreaseMoney(userId, amount));
    }

    public PurchasedItem createPurchasedItem(Integer itemId){
        Item item = itemQueryService.getItem(itemId);
        return new PurchasedItem(new ItemId(item.getItemId()), item.getItemName(), item.getItemPrice());
    }

    public void putInventory(String userId, int itmeId){
        registInventoryService.registInventory(new RegistInventoryRequestDTO(userId, itmeId));
    }

    public boolean logCoinDecrease(String userId,String dateTime, Integer purchaseId, Integer decreaseAmount, String remarks){
        return coinVarianceService.logCoinVarianceHistory(
                new LogCoinVarianceRequestDTO(
                        userId,
                        dateTime,
                        "상점",
                        purchaseId,
                        "USE",
                        decreaseAmount,
                        remarks
                )
        );
    }
}
