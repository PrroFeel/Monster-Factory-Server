package com.profeel.monsterfac.monsterfactoryserver.tower.command.application.dto;

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

    private String towerName;
    private MultipartFile towerModelingFile;
    private MultipartFile towerImageFile;
    private String monsterName;
    private MultipartFile monsterModelingFile;
    private MultipartFile monsterImageFile;
    private String ability;

    protected RegistTowerRequestDTO() {}

    public RegistTowerRequestDTO(String towerName, MultipartFile towerModelingFile, MultipartFile towerImageFile, String monsterName, MultipartFile monsterModelingFile, MultipartFile monsterImageFile, String ability) {
        this.towerName = towerName;
        this.towerModelingFile = towerModelingFile;
        this.towerImageFile = towerImageFile;
        this.monsterName = monsterName;
        this.monsterModelingFile = monsterModelingFile;
        this.monsterImageFile = monsterImageFile;
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "RegistTowerRequestDTO{" +
                "towerName='" + towerName + '\'' +
                ", towerModelingFile=" + towerModelingFile +
                ", towerImageFile=" + towerImageFile +
                ", monsterName='" + monsterName + '\'' +
                ", monsterModelingFile=" + monsterModelingFile +
                ", monsterImageFile=" + monsterImageFile +
                ", ability='" + ability + '\'' +
                '}';
    }

    public MultipartFile getTowerImageFile() {
        return towerImageFile;
    }

    public void setTowerImageFile(MultipartFile towerImageFile) {
        this.towerImageFile = towerImageFile;
    }

    public MultipartFile getMonsterImageFile() {
        return monsterImageFile;
    }

    public void setMonsterImageFile(MultipartFile monsterImageFile) {
        this.monsterImageFile = monsterImageFile;
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

}

