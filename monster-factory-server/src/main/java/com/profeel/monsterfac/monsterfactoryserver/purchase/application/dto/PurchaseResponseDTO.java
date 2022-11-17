package com.profeel.monsterfac.monsterfactoryserver.purchase.application.dto;

import io.swagger.annotations.ApiModelProperty;

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
    @ApiModelProperty(example = "구매 처리 고유 번호")
    private int purchaseId;

    @ApiModelProperty(example = "구매된 아이템 이름")
    private String purchasedItemName;

    @ApiModelProperty(example = "구매자 ID")
    private String purchaserId;

    @ApiModelProperty(example = "구매자의 구매 후 잔금")
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
