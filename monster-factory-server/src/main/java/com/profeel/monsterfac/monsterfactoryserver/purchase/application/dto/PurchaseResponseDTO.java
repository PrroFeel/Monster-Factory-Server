package com.profeel.monsterfac.monsterfactoryserver.purchase.application.dto;

/**
 * <pre>
 * Class : PurchaseResponseDTO
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
public class PurchaseResponseDTO {
    private int purchaseId;
    private String purchasedItemName;
    private String purchaserId;
    private int balace;

    protected PurchaseResponseDTO(){}
    public PurchaseResponseDTO(int purchaseId, String purchasedItemName, String purchaserId, int balace) {
        this.purchaseId = purchaseId;
        this.purchasedItemName = purchasedItemName;
        this.purchaserId = purchaserId;
        this.balace = balace;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchasedItemName() {
        return purchasedItemName;
    }

    public void setPurchasedItemName(String purchasedItemName) {
        this.purchasedItemName = purchasedItemName;
    }

    public String getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(String purchaserId) {
        this.purchaserId = purchaserId;
    }

    public int getBalace() {
        return balace;
    }

    public void setBalace(int balace) {
        this.balace = balace;
    }

    @Override
    public String toString() {
        return "PurchaseResponseDTO{" +
                "purchaseId=" + purchaseId +
                ", purchasedItemName='" + purchasedItemName + '\'' +
                ", purchaserId='" + purchaserId + '\'' +
                ", balace=" + balace +
                '}';
    }
}
