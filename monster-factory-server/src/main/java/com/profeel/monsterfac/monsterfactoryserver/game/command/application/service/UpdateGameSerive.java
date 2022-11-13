package com.profeel.monsterfac.monsterfactoryserver.game.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.game.command.application.exception.NotFoundGameException;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.Game;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.GameId;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.repository.GameRepository;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <pre>
 * Class : UpdateGameSerive
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
public class UpdateGameSerive {
    private GameService gameService;
    private GameRepository gameRepository;

    @Autowired
    public UpdateGameSerive(GameService gameService, GameRepository gameRepository){
        this.gameService = gameService;
        this.gameRepository = gameRepository;
    }
    public void updateGameStatus(GameId gameId, String status) {
        Optional<Game> gameOpt = gameRepository.findById(gameId.getId());
        Game game = gameOpt.orElseThrow(()->new NotFoundGameException("유효하지 않은 게임 id 입니다"));
        game.updateStatus(status);
    }


}
