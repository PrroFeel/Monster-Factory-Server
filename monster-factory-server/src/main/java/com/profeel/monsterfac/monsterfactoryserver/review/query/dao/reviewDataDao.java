package com.profeel.monsterfac.monsterfactoryserver.review.query.dao;

import com.profeel.monsterfac.monsterfactoryserver.review.query.data.reviewData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : reviewDataDao
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
 * @see 참고할 class 또는 외부 url
 */
public interface reviewDataDao extends JpaRepository<reviewData, Integer> {
    List<reviewData> findAllByTargetGameId(int targetGameId);
}
