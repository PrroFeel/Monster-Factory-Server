package com.profeel.monsterfac.monsterfactoryserver.game.query.data;

import javax.persistence.*;

/**
 * <pre>
 * Class : GameSummaryData
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
public class GameSummaryData {

    @Id
    @Column(name = "game_id")
    private Integer id;

    @Column(name="game_name")
    private String name;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="thumbnail_file_id", unique = true)
    private ImageFile thumbnailFile;

    @Column(name = "game_status")
    private String gameStatus;

    @Column(name="developer_member_id")
    private String developerMemberId;

    protected  GameSummaryData(){}

    public GameSummaryData(Integer id, String name, ImageFile thumbnailFile, String gameStatus, String developerMemberId) {
        this.id = id;
        this.name = name;
        this.thumbnailFile = thumbnailFile;
        this.gameStatus = gameStatus;
        this.developerMemberId = developerMemberId;
    }

    public String getDeveloperMemberId() {
        return developerMemberId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ImageFile getThumbnailFile() {
        return thumbnailFile;
    }

    public String getGameStatus() {
        return gameStatus;
    }
}