package com.profeel.monsterfac.monsterfactoryserver.game.command.application.dto;

import java.util.List;

/**
 * <pre>
 * Class : UpladGameRequestDTO
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
public class UploadGameRequestDTO {
    private Integer rewardMoney;
    private List<RegistRewardItem> rewardItmes;

    protected UploadGameRequestDTO(){}

    public UploadGameRequestDTO(Integer rewardMoney, List<RegistRewardItem> rewardItmes) {
        this.rewardMoney = rewardMoney;
        this.rewardItmes = rewardItmes;
    }

    public Integer getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(Integer rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    public List<RegistRewardItem> getRewardItmes() {
        return rewardItmes;
    }

    public void setRewardItmes(List<RegistRewardItem> rewardItmes) {
        this.rewardItmes = rewardItmes;
    }

    @Override
    public String toString() {
        return "UpladGameRequestDTO{" +
                "rewardMoney=" + rewardMoney +
                ", rewardItmes=" + rewardItmes +
                '}';
    }
}
