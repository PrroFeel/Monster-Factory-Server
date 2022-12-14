package com.profeel.monsterfac.monsterfactoryserver.game.query.data;

import com.profeel.monsterfac.monsterfactoryserver.file.query.data.ImageUrlData;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * <pre>
 * Class : GameInfoData
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

@Entity
@Table(name="tbl_games")
public class GameInfoData {

    @ApiModelProperty(example = "게임 고유 번호")
    @Id
    @Column(name = "game_id")
    private Integer id;

    @ApiModelProperty(example = "게임 이름")
    @Column(name="game_name")
    private String name;

    @ApiModelProperty(name = "썸네일 파일 정보")
    @OneToOne
    @JoinColumn(name="thumbnail_file_id", unique = true)
    private ImageUrlData thumbnailFile;

    @ApiModelProperty(example = "게임 상태 - JUDGE_WAIT : 심사 대기, APPROVED : 승인됨, RETURNED : 반려됨, UPLOADED : 업로드됨")
    @Column(name = "game_status")
    private String gameStatus;


    @ApiModelProperty(example = "개발자 ID")
    @Column(name="developer_member_id")
    private String developerMemberId;

    @ApiModelProperty(example = "게임 설명")
    @Column(name="game_description")
    private String gameDescription;

    @ApiModelProperty(example = "작업 프로젝트 고유 번호")
    @Column(name="project_id")
    private Integer projectId;

    @ApiModelProperty(example = "보상 코인")
    @Column(name="game_reward_money")
    private Integer rewardMoney;

    protected GameInfoData(){}


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ImageUrlData getThumbnailFile() {
        return thumbnailFile;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public String getDeveloperMemberId() {
        return developerMemberId;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public Integer getRewardMoney() {
        return rewardMoney;
    }
}
