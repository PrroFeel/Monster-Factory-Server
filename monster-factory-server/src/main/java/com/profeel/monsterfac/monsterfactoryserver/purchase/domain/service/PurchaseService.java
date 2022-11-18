package com.profeel.monsterfac.monsterfactoryserver.purchase.domain.service;

import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.PurchaseItem;
import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.Purchaser;

/**
 * <pre>
 * Class : PurchaseService
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
 * @see 참고할 class 또는 외부 url
 */
public interface PurchaseService {

    Purchaser changeMoneyAndCreatePurchaser(String userId, int amount);
    PurchaseItem createPurchasedItem(Integer itemId);
    void putInventory(String userId, int itmeId);
    boolean logCoinDecrease(String userId,String dateTime, Integer purchaseId, Integer decreaseAmount, String remarks);
}
