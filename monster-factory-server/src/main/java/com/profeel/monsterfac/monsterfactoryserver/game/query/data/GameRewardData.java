package com.profeel.monsterfac.monsterfactoryserver.game.query.data;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

/**
 * <pre>
 * Class : GameRewardData
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
 * @see 참고할 class 또는 외부 url
 */
@Entity
@Table(name = "tbl_games")
public class GameRewardData {

    @ApiModelProperty(example = "게임 고유 번호")
    @Id
    @Column(name = "game_id")
    private Integer id;

    @ApiModelProperty(example = "보상 코인")
    @Column(name="game_reward_money")
    private Integer rewardMoney;
    @Column(name="project_id")
    private Integer projectId;

    @ApiModelProperty(example = "보상 코인")
    @ElementCollection
    @CollectionTable(name="tbl_reward_items", joinColumns = @JoinColumn(name="game_id"))
    @OrderColumn(name="reward_item_idx")
    private List<RewardItemData> rewardItems;



    protected GameRewardData(){}

    public GameRewardData(Integer id, Integer rewardMoney, List<RewardItemData> rewardItems, Integer projectId) {
        this.id = id;
        this.rewardMoney = rewardMoney;
        this.rewardItems = rewardItems;
        this.projectId = projectId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRewardMoney() {
        return rewardMoney;
    }

    public List<RewardItemData> getRewardItems() {
        return rewardItems;
    }

    public Integer getProjectId() {
        return projectId;
    }
}
