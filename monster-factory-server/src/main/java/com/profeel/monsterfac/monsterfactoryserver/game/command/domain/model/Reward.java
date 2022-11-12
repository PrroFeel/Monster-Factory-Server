package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model;

import javax.persistence.*;
import java.util.List;

/**
 * <pre>
 * Class : Reward
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Embeddable
public class Reward {

    @Column(name="game_reward_money")
    private Integer money;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="tbl_reward_items", joinColumns = @JoinColumn(name="game_id"))
    @OrderColumn(name="reward_item_idx")
    private List<RewardItem> rewardItems;

    protected  Reward(){}
    public Reward(Integer money, List<RewardItem> rewardItems) {
        this.money = money;
        this.rewardItems = rewardItems;
    }

    public Integer getMoney() {
        return money;
    }

    public List<RewardItem> getRewardItems() {
        return rewardItems;
    }
}
