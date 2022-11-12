package com.profeel.monsterfac.monsterfactoryserver.review.command.domain.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import static com.profeel.monsterfac.monsterfactoryserver.common.service.DateService.getCurrentDatetimeWithFormating;

/**
 * <pre>
 * Class : Review
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
@Entity
@Table(name="tbl_reviews")
@DynamicUpdate
public class Review {
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String comment;

    @Column(name="review_result")
    private Result result;

    @Embedded
    private PIC pic;

    @Column(name="review_regist_datetime")
    private String registDatetime;


    @Embedded
    private TargetGame targetGame;

    protected Review(){}

    public Review(String comment, Result result, PIC pic, TargetGame targetGame) {
        this.comment = comment;
        this.result = result;
        this.pic = pic;
        this.targetGame = targetGame;
        this.registDatetime = getCurrentDatetimeWithFormating();
    }

    public String getComment() {
        return comment;
    }

    public Result getResult() {
        return result;
    }

    public PIC getPic() {
        return pic;
    }

    public TargetGame getTargetGame() {
        return targetGame;
    }
}
