package com.profeel.monsterfac.monsterfactoryserver.play.command.domain.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameRewardData;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.Member;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.PlayGame;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.Player;

/**
 * <pre>
 * Class : PlayService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-12       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@DomainService
public interface PlayService {

    Player createPlayer(String playerId);

    PlayGame createPlayGame(int gameId);

    GameRewardData getGameRewardById(int gameId);

    Member increaseMoneyWithReward(String userId, Integer rewardMoney);
}
