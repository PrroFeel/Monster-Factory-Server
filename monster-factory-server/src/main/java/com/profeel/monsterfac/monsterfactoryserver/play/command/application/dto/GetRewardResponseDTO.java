package com.profeel.monsterfac.monsterfactoryserver.play.command.application.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <pre>
 * Class : PurchaseResponseDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-18       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class GetRewardResponseDTO {

    @ApiModelProperty(example = "게임 보상 머니")
    private int reward;

    @ApiModelProperty(example = "수령 후 유저 보유 머니")
    private int afterMoney;

    protected GetRewardResponseDTO(){}

    public GetRewardResponseDTO(int reward, int afterMoney) {
        this.reward = reward;
        this.afterMoney = afterMoney;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getAfterMoney() {
        return afterMoney;
    }

    public void setAfterMoney(int afterMoney) {
        this.afterMoney = afterMoney;
    }

    @Override
    public String toString() {
        return "GetRewardResponseDTO{" +
                "reward=" + reward +
                ", afterMoney=" + afterMoney +
                '}';
    }
}
