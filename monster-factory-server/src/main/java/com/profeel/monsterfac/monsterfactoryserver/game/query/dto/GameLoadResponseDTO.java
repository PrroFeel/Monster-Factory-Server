package com.profeel.monsterfac.monsterfactoryserver.game.query.dto;

import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameRewardData;
import com.profeel.monsterfac.monsterfactoryserver.project.query.data.EditInfoData;

/**
 * <pre>
 * Class : GameLoadResponseDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-14       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class GameLoadResponseDTO {

    private GameRewardData gameRewardData;
    private EditInfoData editInfoData;



    protected  GameLoadResponseDTO(){}

    public GameLoadResponseDTO(GameRewardData gameRewardData, EditInfoData editInfoData) {
        this.gameRewardData = gameRewardData;
        this.editInfoData = editInfoData;
    }

    public GameRewardData getGameRewardData() {
        return gameRewardData;
    }

    public EditInfoData getEditInfoData() {
        return editInfoData;
    }
}
