package com.profeel.monsterfac.monsterfactoryserver.purchase.application.dto;

import io.swagger.annotations.ApiModelProperty;

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
 */
public class PurchaseRequestDTO {
    @ApiModelProperty(name = "구매한 item 고유 번호", example = "3")
    private int purchaseItemId;

    @ApiModelProperty(name = "구매한 날짜 및 시간", example = "2022-11-18 07:01:00", notes = "\"yyyy-dd-MM HH:mm:ss\" 와 같은 포맷을 지켜야 한다")
    private String purchaseDatetime;

    protected PurchaseRequestDTO(){}

    public PurchaseRequestDTO( int purchaseItemId, String purchaseDatetime) {
        this.purchaseItemId = purchaseItemId;
        this.purchaseDatetime = purchaseDatetime;
    }


    public int getPurchaseItemId() {
        return purchaseItemId;
    }

    public void setPurchaseItemId(int purchasedItemId) {
        this.purchaseItemId = purchasedItemId;
    }

    public String getPurchaseDatetime() {
        return purchaseDatetime;
    }

    public void setPurchaseDatetime(String purchaseDatetime) {
        this.purchaseDatetime = purchaseDatetime;
    }
}
