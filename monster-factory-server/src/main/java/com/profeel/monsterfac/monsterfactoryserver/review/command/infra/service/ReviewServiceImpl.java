package com.profeel.monsterfac.monsterfactoryserver.review.command.infra.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.GameId;
import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.service.GameQueryService;
import com.profeel.monsterfac.monsterfactoryserver.member.query.service.MemberQueryService;
import com.profeel.monsterfac.monsterfactoryserver.review.command.domain.model.TargetGame;
import com.profeel.monsterfac.monsterfactoryserver.review.command.domain.service.ReviewService;

/**
 * <pre>
 * Class : ReviewServiceImpl
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
@DomainService
public class ReviewServiceImpl implements ReviewService {
    private GameQueryService gameQueryService;
    private MemberQueryService memberQueryService;

    public ReviewServiceImpl(GameQueryService gameQueryService, MemberQueryService memberQueryService){
        this.gameQueryService = gameQueryService;
        this.memberQueryService = memberQueryService;
    }


    @Override
    public TargetGame createTargetGame(Integer targetGameId) {
        GameData gameData = gameQueryService.getGameData(targetGameId);
        return new TargetGame(new GameId(gameData.getId()));
    }
}
