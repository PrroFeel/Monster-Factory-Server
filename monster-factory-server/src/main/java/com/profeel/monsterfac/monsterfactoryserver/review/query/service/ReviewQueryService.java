package com.profeel.monsterfac.monsterfactoryserver.review.query.service;

import com.profeel.monsterfac.monsterfactoryserver.review.query.dao.ReviewDataDao;
import com.profeel.monsterfac.monsterfactoryserver.review.query.data.ReviewData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class : ReviewQueryService
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

@Service
public class ReviewQueryService {
    private ReviewDataDao reviewDataDao;

    @Autowired
    public ReviewQueryService(ReviewDataDao reviewDataDao){
        this.reviewDataDao = reviewDataDao;
    }

    public ReviewData findReviewDataListByGameId(int gameId){
        return reviewDataDao.findFirstByTargetGameId(gameId);
    }
}
