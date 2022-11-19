package com.profeel.monsterfac.monsterfactoryserver.history.entity;

import javax.persistence.*;

/**
 * <pre>
 * Class : CoinVariance
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-16       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Entity
@Table(name = "tbl_coinvariance_history")
public class CoinVariance {
//    @ApiModelProperty(value="아이템 아이디", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coin_variance_id")
    private int id;

    @Embedded
    Changer changer;


    @Column(name="coin_variance_datetime")
    String varianceDateTime;

    @Column(name="varianced_content")
    String variancedContent;

    @Column(name="varianced_content_id")
    int variancedContentId;

    @Column(name="coin_variance_action")
    String action;

    @Column(name="coin_variance_amount")
    int amount;


    @Column(name="coin_variance_remarks")
    String remarks;


    protected CoinVariance(){}

    public CoinVariance(Changer changer, String varianceDateTime, String variancedContent, int variancedContentId, String action, int amount, String remarks) {
        this.changer = changer;
        this.varianceDateTime = varianceDateTime;
        this.variancedContent = variancedContent;
        this.variancedContentId = variancedContentId;
        this.action = action;
        this.amount = amount;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public Changer getChanger() {
        return changer;
    }

    public String getVarianceDateTime() {
        return varianceDateTime;
    }

    public String getVariancedContent() {
        return variancedContent;
    }

    public String getAction() {
        return action;
    }

    public int getAmount() {
        return amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public int getVariancedContentId() {
        return variancedContentId;
    }
}
