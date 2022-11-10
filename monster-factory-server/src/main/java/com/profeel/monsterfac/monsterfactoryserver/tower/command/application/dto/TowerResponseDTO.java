package com.profeel.monsterfac.monsterfactoryserver.tower.command.application.dto;

/**
 * <pre>
 * Class : RegistObjectDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-09       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public class TowerResponseDTO {

    private String towerName;
    private Integer towerModelingFileId;

    private String monsterName;
    private Integer monsterModelingFileId;

    private String ability;

    protected TowerResponseDTO() {}

    public TowerResponseDTO(String towerName, Integer towerModelingFileId, String monsterName, Integer monsterModelingFileId, String ability) {
        this.towerName = towerName;
        this.towerModelingFileId = towerModelingFileId;
        this.monsterName = monsterName;
        this.monsterModelingFileId = monsterModelingFileId;
        this.ability = ability;
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }

    public Integer getTowerModelingFileId() {
        return towerModelingFileId;
    }

    public void setTowerModelingFileId(Integer towerModelingFileId) {
        this.towerModelingFileId = towerModelingFileId;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public Integer getMonsterModelingFileId() {
        return monsterModelingFileId;
    }

    public void setMonsterModelingFileId(Integer monsterModelingFileId) {
        this.monsterModelingFileId = monsterModelingFileId;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "TowerResponseDTO{" +
                "towerName='" + towerName + '\'' +
                ", towerModelingFileId=" + towerModelingFileId +
                ", monsterName='" + monsterName + '\'' +
                ", monsterModelingFileId=" + monsterModelingFileId +
                ", ability='" + ability + '\'' +
                '}';
    }
}

