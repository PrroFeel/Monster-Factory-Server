package com.profeel.monsterfac.monsterfactoryserver.play.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameRewardData;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.Member;
import com.profeel.monsterfac.monsterfactoryserver.play.command.application.dto.GetRewardResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.service.PlayService;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class : GetRewardService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-19       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Service
public class GetRewardService {

    PlayService playService;

    public GetRewardService(PlayService playService){
        this.playService = playService;
    }

    public GetRewardResponseDTO increaseMoneyForReward(int gameId, String userId) {

        GameRewardData gameRewardData =  playService.getGameRewardById(gameId);

        Member member = playService.increaseMoneyWithReward(userId, gameRewardData.getRewardMoney());

        if(gameRewardData.getRewardMoney().intValue() != 0){
            playService.logCoinIncrease(member.getMemberId(), 1, gameRewardData.getRewardMoney().intValue(), "클리어 보상 수령");
        }

        return new GetRewardResponseDTO(
                gameRewardData.getRewardMoney(),
                member.getMoney().getValue()
        );
    }
}
