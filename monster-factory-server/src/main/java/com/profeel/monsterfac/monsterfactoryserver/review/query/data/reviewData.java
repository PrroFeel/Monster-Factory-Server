package com.profeel.monsterfac.monsterfactoryserver.review.query.data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Class : reviewData
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-28       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Table(name="tbl_reviews")
public class reviewData {

    @Id
    @Column(name = "review_id")
    private Integer id;

    @Column(name="review_comment")
    private String comment;

    @Column(name="review_result")
    private String result;

    @Column(name="pic_manager_id")
    private String picManagerId;

    @Column(name="review_regist_datetime")
    private String registDatetime;

    @Column(name = "target_game_id")
    private int targetGameId;

    protected reviewData(){}

    public Integer getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getResult() {
        return result;
    }

    public String getPicManagerId() {
        return picManagerId;
    }

    public String getRegistDatetime() {
        return registDatetime;
    }

    @Override
    public String toString() {
        return "reviewData{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", result='" + result + '\'' +
                ", picManagerId='" + picManagerId + '\'' +
                ", registDatetime='" + registDatetime + '\'' +
                ", targetGameId=" + targetGameId +
                '}';
    }

    public int getTargetGameId() {
        return targetGameId;
    }

}
