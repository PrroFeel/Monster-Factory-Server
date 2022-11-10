package com.profeel.monsterfac.monsterfactoryserver.tower.command.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

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
public class RegistTowerRequestDTO {

    @JsonProperty("tower_name")
    private String towerName;
    @JsonProperty("tower_modeling_file")
    private MultipartFile towerModelingFile;

    @JsonProperty("monster_name")
    private String monsterName;
    @JsonProperty("monster_modeling_file")
    private MultipartFile monsterModelingFile;

    @JsonProperty("default_ability")
    private String ability;

    protected RegistTowerRequestDTO() {}

    public RegistTowerRequestDTO(String towerName, MultipartFile towerModelingFile, String monsterName, MultipartFile monsterModelingFile, String ability) {
        this.towerName = towerName;
        this.towerModelingFile = towerModelingFile;
        this.monsterName = monsterName;
        this.monsterModelingFile = monsterModelingFile;
        this.ability = ability;
    }

    public MultipartFile getTowerModelingFile() {
        return towerModelingFile;
    }

    public void setTowerModelingFile(MultipartFile towerModelingFile) {
        this.towerModelingFile = towerModelingFile;
    }

    public MultipartFile getMonsterModelingFile() {
        return monsterModelingFile;
    }

    public void setMonsterModelingFile(MultipartFile monsterModelingFile) {
        this.monsterModelingFile = monsterModelingFile;
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "RegistTowerRequestDTO{" +
                "towerName='" + towerName + '\'' +
                ", towerModelingFile=" + towerModelingFile +
                ", monsterName='" + monsterName + '\'' +
                ", monsterModelingFile=" + monsterModelingFile +
                ", ability='" + ability + '\'' +
                '}';
    }
}

