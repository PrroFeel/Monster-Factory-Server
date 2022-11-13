package com.profeel.monsterfac.monsterfactoryserver.review.command.application.dto;

/**
 * <pre>
 * Class : ReviewResponseDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class ReviewResponseDTO {
    private Integer reviewId;
    private String comment;
    private String result;
    private String registDatetime;
    private Integer targetGameId;
    private String picId;

    protected ReviewResponseDTO(){}
    public ReviewResponseDTO(Integer reviewId, String comment, String result, String registDatetime, Integer targetGameId, String picId) {
        this.reviewId = reviewId;
        this.comment = comment;
        this.result = result;
        this.registDatetime = registDatetime;
        this.targetGameId = targetGameId;
        this.picId = picId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRegistDatetime() {
        return registDatetime;
    }

    public void setRegistDatetime(String registDatetime) {
        this.registDatetime = registDatetime;
    }

    public Integer getTargetGameId() {
        return targetGameId;
    }

    public void setTargetGameId(Integer targetGameId) {
        this.targetGameId = targetGameId;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }
}
