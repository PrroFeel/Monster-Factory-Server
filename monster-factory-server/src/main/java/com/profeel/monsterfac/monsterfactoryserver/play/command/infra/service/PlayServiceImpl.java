package com.profeel.monsterfac.monsterfactoryserver.play.command.infra.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.GameId;
import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameRewardData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.service.GameQueryService;
import com.profeel.monsterfac.monsterfactoryserver.member.command.application.service.ReqMemberService;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.Member;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.MemberId;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.PlayGame;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.Player;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <pre>
 * Class : PlayServiceImpl
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-12       최은진           최초 생성
 * 2022-11-19       최윤서           보상 수령 관련 메소드 추가
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@DomainService
public class PlayServiceImpl implements PlayService {

    private final ReqMemberService reqMemberService;
    private final GameQueryService gameQueryService;

    @Autowired
    public PlayServiceImpl(ReqMemberService reqMemberService,
                           GameQueryService gameQueryService){
        this.gameQueryService =gameQueryService;
        this.reqMemberService =reqMemberService;
    }


    @Override
    public Player createPlayer(String playerId) {
        return new Player(new MemberId(playerId));
    }

    @Override
    public PlayGame createPlayGame(int gameId) {
        return new PlayGame(new GameId(gameId));
    }

    @Override
    public GameRewardData getGameRewardById(int gameId) {
        return  gameQueryService.getGameRewardData(gameId);
    }

    @Override
    public Member increaseMoneyWithReward(String userId, Integer rewardMoney) {
        return reqMemberService.increaseMoney(userId, rewardMoney);
    }

}
