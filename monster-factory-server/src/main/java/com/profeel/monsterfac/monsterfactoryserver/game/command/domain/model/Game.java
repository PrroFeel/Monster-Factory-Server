package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.common.exception.NagativeMoneyException;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.exception.NotApprovedStatusException;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.exception.RewardNullException;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

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


    @Column(name = "game_status")
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'JUDGE_WAIT'")
    private GameStatus gameStatus;
    @Embedded
    private Reward reward;



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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public FileInfo getThumbnail() {
        return thumbnail;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public DevelopProject getDevelopProject() {
        return developProject;
    }

    public Reward getReward() {
        return reward;
    }

    private boolean verifyRewardExist(){
        return this.gameStatus != null;
    }

    public void updateStatus(String status) {
        if(fromString(status)==null){
            throw new IllegalArgumentException("유효하지 않은 게임 상태 값 입니다");
        }
        System.out.println(status);
        this.gameStatus = GameStatus.APPROVED;
    }



    public void registRewardAndUpload(Reward newReward){
        registReward(newReward);
        upload();
    }
    private boolean verifyApprovedStatus(){
        return this.gameStatus.equals(GameStatus.APPROVED);
    }

    private void upload(){
        if(!verifyApprovedStatus()){
            throw new NotApprovedStatusException("승인된 게임만 업로드 할 수 있습니다");
        }
        if(!verifyRewardExist()){
            throw new RewardNullException("보상을 등록해야만 업로드할 수 있습니다");
        }
        if(!this.gameStatus.equals(GameStatus.UPLOADED)){
            this.gameStatus = GameStatus.UPLOADED;
        }
    }

    public void registReward(Reward newReward){
        if(newReward.getMoney()== 0 && newReward.getRewardItems().isEmpty()){
            throw  new IllegalArgumentException("게임 보상 내용이 존재하지 않습니다");
        }
        if(newReward.getMoney()<0){
            throw new NagativeMoneyException("게임 보상 머니는 음수가 될 수 없습니다");
        }
        if(!verifyApprovedStatus()){
            throw new NotApprovedStatusException("승인된 게임만 보상을 등록할 수 있습니다");
        }
        this.reward = newReward;
    }


}
