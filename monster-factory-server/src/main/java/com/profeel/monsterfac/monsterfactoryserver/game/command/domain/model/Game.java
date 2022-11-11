package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

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
    @ColumnDefault("JUDGE_WAIT")
    private GameStatus gameStatus;

    @Embedded
    private DevelopProject developProject;


    protected Game() {}

    public Game( FileInfo thumbnail, DevelopProject developProject) {
        this.thumbnail = thumbnail;
        this.developProject = developProject;
    }

    public Game(FileInfo thumbnail, Reward reward, GameStatus gameStatus, DevelopProject developProject) {
        this(thumbnail, developProject);
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
}
