package com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model;

import javax.persistence.*;

/**
 * <pre>
 * Class : Purchase
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
@Entity
@Table(name = "tbl_purchases")
public class Purchase {

    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    Purchaser purchaser;

    @Embedded
    PurchasedItem purchaedItem;

    @Column(name="purchase_datatime")
    String purchaseDatetime;

    protected Purchase(){}
    public Purchase(Purchaser purchaser, PurchasedItem purchaedItem, String purchaseDatetime) {
        this.purchaser = purchaser;
        this.purchaedItem = purchaedItem;
//        this.purchaseDatetime = getCurrentDatetimeWithFormating();
        this.purchaseDatetime = purchaseDatetime;
    }

    public int getId() {
        return id;
    }

    public Purchaser getPurchaser() {
        return purchaser;
    }

    public PurchasedItem getPurchaedItem() {
        return purchaedItem;
    }

    public String getPurchaseDatetime() {
        return purchaseDatetime;
    }
}
