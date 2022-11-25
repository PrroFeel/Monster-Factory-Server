package com.profeel.monsterfac.monsterfactoryserver.tower.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.FileService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.S3Service;
import com.profeel.monsterfac.monsterfactoryserver.tower.command.application.dto.RegistTowerRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.model.MonsterTower;
import com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.repostiory.TowerRepository;
import com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.service.TowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * <pre>
 * Class : RegistObjectService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-09       최윤서           최초 생성
 * </pre>
 * @version 1
 * @author 최윤서
 */

@Service
public class RegistTowerService {

    private TowerRepository towerRepository;
    private TowerService towerService;
    @Autowired
    public RegistTowerService(TowerRepository towerRepository, TowerService towerService, S3Service s3UploaderService, FileService fileService){
        this.towerRepository = towerRepository;
        this.towerService = towerService;

    }
    @Transactional
    public Integer registMonsterTower(RegistTowerRequestDTO registTowerRequest) throws IOException {
        System.out.println("[RegistTowerService] registMonsterTower 메소드 실행");
        System.out.println("registTowerRequest : "+ registTowerRequest);

        FileInfo monsterFileInfo = towerService.uploadFile(registTowerRequest.getMonsterModelingFile());
        FileInfo monsterImageInfo = towerService.uploadImage(registTowerRequest.getMonsterImageFile());

        FileInfo towerFileInfo = towerService.uploadFile(registTowerRequest.getTowerModelingFile());
        FileInfo towerImageInfo = towerService.uploadImage(registTowerRequest.getTowerImageFile());

        // MonsterTower 객체 생성
        MonsterTower monsterTower = new MonsterTower(
                registTowerRequest.getTowerName(),
                towerFileInfo,
                towerImageInfo,
                registTowerRequest.getMonsterName(),
                monsterFileInfo,
                monsterImageInfo,
                registTowerRequest.getAbility()
        );
        // monsterTower insert
        monsterTower = towerRepository.save(monsterTower);

        // 생성된 monserTower id 반환
        return monsterTower.getId();
    }

}