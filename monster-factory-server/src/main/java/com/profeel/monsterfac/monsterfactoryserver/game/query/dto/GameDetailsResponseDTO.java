package com.profeel.monsterfac.monsterfactoryserver.game.query.dto;

import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameInfoData;
import com.profeel.monsterfac.monsterfactoryserver.play.query.data.PlayRankData;

import java.util.List;

/**
 * <pre>
 * Class : GameInfoResponseDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-20       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 * @see 참고할 class 또는 외부 url
 */
public class GameDetailsResponseDTO {
    private GameInfoData gameInfoData;
    private Integer gamePlayCount;
    private List<PlayRankData> playRankData;

    protected GameDetailsResponseDTO(){}
    public GameDetailsResponseDTO(GameInfoData gameInfoData, Integer gamePlayCount, List<PlayRankData> playRankData) {
        this.gameInfoData = gameInfoData;
        this.gamePlayCount = gamePlayCount;
        this.playRankData = playRankData;
    }

    public GameInfoData getGameInfoData() {
        return gameInfoData;
    }

    public Integer getGamePlayCount() {
        return gamePlayCount;
    }

    public List<PlayRankData> getPlayRankData() {
        return playRankData;
    }
}
