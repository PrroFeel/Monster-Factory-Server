package com.profeel.monsterfac.monsterfactoryserver.game.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.game.command.application.dto.RegistRewardItem;
import com.profeel.monsterfac.monsterfactoryserver.game.command.application.dto.UploadGameRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.Game;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.GameId;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.RewardItem;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.repository.GameRepository;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    private GameQueryService gameQueryService;
    @Autowired
    public UpdateGameSerive(GameService gameService, GameRepository gameRepository, GameQueryService gameQueryService){
        this.gameService = gameService;
        this.gameRepository = gameRepository;
        this.gameQueryService = gameQueryService;
    }
    public void updateGameStatus(GameId gameId, String status) {
        Game targetGame = gameQueryService.getGame(gameId.getId());
        targetGame.updateStatus(status);
    }


    public Game uploadGameWithReward(Integer gameId, UploadGameRequestDTO upladGameRequest){
        // game id 검증
        Game targetGame = gameQueryService.getGame(gameId);

        // rewardItem list 생성
        List<RewardItem> rewardItemList = new ArrayList<>();
        for(RegistRewardItem registRewardItem : upladGameRequest.getRewardItmes()){
            rewardItemList.add(gameService.createRewardItem(registRewardItem.getId(), registRewardItem.getQuantity()));
        }

        // game reward regist & upload
        targetGame.registReward(upladGameRequest.getRewardMoney(), rewardItemList);
        targetGame.uploadGame();

        // response dto 반환
        return targetGame;
    }
}
