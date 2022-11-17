package com.profeel.monsterfac.monsterfactoryserver.purchase.application.dto;

/**
 * <pre>
 * Class : PurchaseRequestDTO
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
 * @see 참고할 class 또는 외부 url
 */
public class PurchaseRequestDTO {
    private String purchaserId;
    private int purchasedItemId;
    private String purchaseDatetime;

    protected PurchaseRequestDTO(){}

    public PurchaseRequestDTO(String purchaserId, int purchasedItemId, String purchaseDatetime) {
        this.purchaserId = purchaserId;
        this.purchasedItemId = purchasedItemId;
        this.purchaseDatetime = purchaseDatetime;
    }

    public String getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(String purchaserId) {
        this.purchaserId = purchaserId;
    }

    public int getPurchasedItemId() {
        return purchasedItemId;
    }

    public void setPurchasedItemId(int purchasedItemId) {
        this.purchasedItemId = purchasedItemId;
    }

    public String getPurchaseDatetime() {
        return purchaseDatetime;
    }

    public void setPurchaseDatetime(String purchaseDatetime) {
        this.purchaseDatetime = purchaseDatetime;
    }
}
