package com.profeel.monsterfac.monsterfactoryserver.game.query.service;

import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.exception.NotFoundGameException;
import com.profeel.monsterfac.monsterfactoryserver.game.query.repository.GameDataRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class : MemberService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-06       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Service
public class GameQueryService {


    private GameDataRepositoy gameDataRepositoy;

    @Autowired
    public GameQueryService(GameDataRepositoy gameDataRepositoy){
        this.gameDataRepositoy = gameDataRepositoy;
    }

    public boolean isVailable(Integer gameId) {

        boolean result = gameDataRepositoy.existsById(gameId);

        if(!result) {
            throw new NotFoundGameException("존재하지 않은 게임 입니다.");
        }

        return result;
    }

    public GameData getGameData(Integer gameId) {
        isVailable(gameId);
        return  (gameDataRepositoy.findById(gameId)).get();
    }
}
