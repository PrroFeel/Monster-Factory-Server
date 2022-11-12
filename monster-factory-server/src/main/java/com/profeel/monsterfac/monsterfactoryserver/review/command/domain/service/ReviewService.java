package com.profeel.monsterfac.monsterfactoryserver.review.command.domain.service;

import com.profeel.monsterfac.monsterfactoryserver.review.command.domain.model.TargetGame;

/**
 * <pre>
 * Class : ReviewService
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

public interface ReviewService {
    TargetGame createTargetGame(Integer targetGameId);
}
