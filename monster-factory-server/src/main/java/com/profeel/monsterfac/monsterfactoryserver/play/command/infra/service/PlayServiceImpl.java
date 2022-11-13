package com.profeel.monsterfac.monsterfactoryserver.play.command.infra.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.GameId;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.MemberId;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.PlayGame;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.Player;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.service.PlayService;

/**
 * <pre>
 * Class : PlayServiceImpl
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
public class PlayServiceImpl implements PlayService {

    @Override
    public Player createPlayer(String playerId) {
        return new Player(new MemberId(playerId));
    }

    @Override
    public PlayGame createPlayGame(int gameId) {
        return new PlayGame(new GameId(gameId));
    }
}
