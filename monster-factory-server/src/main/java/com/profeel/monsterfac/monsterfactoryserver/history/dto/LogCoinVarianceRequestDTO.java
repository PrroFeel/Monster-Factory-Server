package com.profeel.monsterfac.monsterfactoryserver.history.dto;

/**
 * <pre>
 * Class : LogCoinVarianceDTO
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
public class LogCoinVarianceRequestDTO {
    int memberId;
    String varianceDateTime;

    String variancedContent;

    String variancedContentId;

    String action;

    int amount;

    String remarks;

    protected LogCoinVarianceRequestDTO(){}

    public LogCoinVarianceRequestDTO(int memberId, String varianceDateTime, String variancedContent, String variancedContentId, String action, int amount, String remarks) {
        this.memberId = memberId;
        this.varianceDateTime = varianceDateTime;
        this.variancedContent = variancedContent;
        this.variancedContentId = variancedContentId;
        this.action = action;
        this.amount = amount;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "LogCoinVarianceRequestDTO{" +
                "memberId=" + memberId +
                ", varianceDateTime='" + varianceDateTime + '\'' +
                ", variancedContent='" + variancedContent + '\'' +
                ", variancedContentId='" + variancedContentId + '\'' +
                ", action='" + action + '\'' +
                ", amount=" + amount +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public int getMemberId() {
        return memberId;
    }

    public String getVarianceDateTime() {
        return varianceDateTime;
    }

    public void setVarianceDateTime(String varianceDateTime) {
        this.varianceDateTime = varianceDateTime;
    }

    public String getVariancedContent() {
        return variancedContent;
    }

    public void setVariancedContent(String variancedContent) {
        this.variancedContent = variancedContent;
    }

    public String getVariancedContentId() {
        return variancedContentId;
    }

    public void setVariancedContentId(String variancedContentId) {
        this.variancedContentId = variancedContentId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
