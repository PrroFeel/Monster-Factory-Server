package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.exception.NotApprovedStatusException;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.exception.RewardNullException;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import java.util.List;

import static com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.GameStatus.fromString;

/**
 * <pre>
 * Class : Game
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
@Entity
@Table(name="tbl_games")
@DynamicUpdate
public class Game {

    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="game_name")
    private String name;

    @Column(name="game_description")
    private String description;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="thumbnail_file_id", unique = true)
    private FileInfo thumbnail;

    @Embedded
    private Reward reward;

    @Column(name = "game_status")
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'JUDGE_WAIT'")
    private GameStatus gameStatus;

    @Embedded
    private DevelopProject developProject;

    protected Game() {}

    public Game(String name, String description, FileInfo thumbnail, DevelopProject developProject) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.developProject = developProject;
        this.gameStatus = fromString("JUDGE_WAIT");
    }

    public Game(String name, String description,FileInfo thumbnail, Reward reward, GameStatus gameStatus, DevelopProject developProject) {
        this(name, description, thumbnail, developProject);
        this.reward = reward;
        this.gameStatus = gameStatus;
    }



    public Integer getId() {
        return id;
    }


    public FileInfo getThumbnail() {
        return thumbnail;
    }

    public Reward getReward() {
        return reward;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public DevelopProject getDevelopProject() {
        return developProject;
    }


    public void updateStatus(String status) {
        if(fromString(status)==null){
            throw new IllegalArgumentException("유효하지 않은 게임 상태 값 입니다");
        }
        this.gameStatus = fromString(status);
    }

    public void registReward(Integer money, List<RewardItem> rewardItems){
        if(money == 0 && rewardItems.isEmpty()){
            throw  new IllegalArgumentException("게임 보상 내용이 존재하지 않습니다");
        }
        if(verfiyApprovedStatus()){
            throw new NotApprovedStatusException("승인된 게임만 보상을 등록할 수 있습니다");
        }
        this.reward = new Reward(money, rewardItems);
    }
    private boolean verfiyApprovedStatus(){
        return this.gameStatus == GameStatus.APPROVED;
    }

    public void uploadGame(){
        if(verfiyApprovedStatus()){
            throw new NotApprovedStatusException("승인된 게임만 업로드 할 수 있습니다");
        }
        if(!verfiyRewardExist()){
            throw new RewardNullException("보상을 등록해야만 업로드할 수 있습니다");
        }

        this.gameStatus = GameStatus.UPLOADED;
    }

    private boolean verfiyRewardExist(){
        return this.gameStatus != null;
    }
}
