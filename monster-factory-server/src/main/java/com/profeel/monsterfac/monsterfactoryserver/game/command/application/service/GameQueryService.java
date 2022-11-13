package com.profeel.monsterfac.monsterfactoryserver.game.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.Game;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.repository.GameRepository;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.exception.NotFoundProjectException;
import org.springframework.stereotype.Service;

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
 */
@Service
public class GameQueryService {
    private GameRepository gameRepository;

    public GameQueryService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public boolean isValidable(Integer id){
        boolean result =  gameRepository.existsById(id);
        if(!result){
            throw new NotFoundProjectException("해당 게임이 존재하지 않습니다");
        }
        return result;
    }

    public Game getGame(Integer gameId){
        isValidable(gameId);
        return gameRepository.findById(gameId).get();
    }
}
