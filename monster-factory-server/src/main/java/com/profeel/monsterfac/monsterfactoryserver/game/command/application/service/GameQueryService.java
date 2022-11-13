package com.profeel.monsterfac.monsterfactoryserver.game.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.game.command.application.exception.NotFoundGameException;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.Game;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <pre>
 * Class : GameQueryService
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
 * @see 참고할 class 또는 외부 url
 */
@Service
public class GameQueryService {
    private GameRepository gameRepository;

    public GameQueryService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public Game getGame(Integer gameId){
        Optional<Game> gameOpt = gameRepository.findById(gameId);
        return gameOpt.orElseThrow(()->new NotFoundGameException("유효하지 않은 게임 id 입니다"));
    }
}
