package com.profeel.monsterfac.monsterfactoryserver.tower.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.FileService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.S3UploaderService;
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
    public RegistTowerService(TowerRepository towerRepository, TowerService towerService, S3UploaderService s3UploaderService, FileService fileService){
        this.towerRepository = towerRepository;
        this.towerService = towerService;

    }
    @Transactional
    public Integer registMonsterTower(RegistTowerRequestDTO registTowerRequest) throws IOException {
        System.out.println("[RegistTowerService] registMonsterTower 메소드 실행");
        System.out.println("registTowerRequest : "+ registTowerRequest);

        FileInfo monsetFileInfo = towerService.uploadFile(registTowerRequest.getMonsterModelingFile());
        FileInfo towerFileInfo = towerService.uploadFile(registTowerRequest.getTowerModelingFile());

        // MonsterTower 객체 생성
        MonsterTower monsterTower = new MonsterTower(
                registTowerRequest.getTowerName(),
                towerFileInfo,
                registTowerRequest.getMonsterName(),
                monsetFileInfo,
                registTowerRequest.getAbility()
        );
        // monsterTower insert
        monsterTower = towerRepository.save(monsterTower);

        // 생성된 monserTower id 반환
        return monsterTower.getId();
    }
//    @Transactional
//    public Integer registObject(RegistTowerRequestDTO registObject) throws IOException {
//        System.out.println("registObject : "+ registObject);
//
//        // 모델링 파일 등록
//
//        ObjectFileInfo objectFileInfo = new ObjectFileInfo(
//                fileInfo.getOriginalName(),
//                fileInfo.getExtension(),
//                fileInfo.getFilePath(),
//                fileInfo.getUploadDatetime()
//        );
//        System.out.println("objectFileInfo : " + objectFileInfo );
//
//        ObjectFileInfo result =  objectFileRepository.save(objectFileInfo);
//        System.out.println("objectFileInfo save result : " + result );
//
//
//        // project 검증
//        Project project = objectService.createProject(registObject.getProjectId());
//
//        // projetObject 객체 생성
//        ProjectObject projectObject = new ProjectObject(
//                result,
//                registObject.getTransform(),
//                project
//        );
//        System.out.println("prjectObject : " + projectObject);
//        // projetObject insert
//        objectRepository.save(projectObject);
//
//        return projectObject.getId();
//    }


}