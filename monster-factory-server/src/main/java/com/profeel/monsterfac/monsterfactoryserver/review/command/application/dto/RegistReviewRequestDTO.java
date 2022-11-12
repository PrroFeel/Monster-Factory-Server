package com.profeel.monsterfac.monsterfactoryserver.review.command.application.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <pre>
 * Class : RegistResultRequestDTO
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
public class RegistReviewRequestDTO {

    @ApiModelProperty(name = "심사 대상 게임 id", example = "3")
    private Integer targetGameId;

    @ApiModelProperty(name ="심사평", example = "아주 휼룽한 게임이군요!")
    private String comment;

    @ApiModelProperty(name="심사 결과", example = "APPROVED", notes = "RETURNED 또는 APPROVED 을 넣어야합니다")
    private String result;


    protected RegistReviewRequestDTO(){}
    public RegistReviewRequestDTO(Integer targetGameId, String comment, String result) {
        this.targetGameId = targetGameId;
        this.comment = comment;
        this.result = result;
    }

    public Integer getTargetGameId() {
        return targetGameId;
    }

    public void setTargetGameId(Integer targetGameId) {
        this.targetGameId = targetGameId;
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

    @Override
    public String toString() {
        return "ReviewRequestDTO{" +
                "targetGameId=" + targetGameId +
                ", comment='" + comment + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
