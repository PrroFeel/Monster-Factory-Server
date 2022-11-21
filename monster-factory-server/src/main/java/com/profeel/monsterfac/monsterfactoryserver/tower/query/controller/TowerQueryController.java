package com.profeel.monsterfac.monsterfactoryserver.tower.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.tower.query.service.TowerQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * Class : MonsterTowerQueryController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-21       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Controller
@RequestMapping("/towers")
public class TowerQueryController {
    private final TowerQueryService towerQueryService;

    @Autowired
    public TowerQueryController(TowerQueryService towerQueryService){
        this.towerQueryService = towerQueryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findMonsterTowerInfo(@PathVariable("id") int towerId){
        System.out.println("[TowerQueryController] findMonsterTowerInfo -- GET");


        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "몬스터 타워 정보 조회"
                        , towerQueryService.findMonsterTowerById(towerId)
                )
        );
    }

    @GetMapping("")
    public ResponseEntity<ResponseDTO> findMonsterTowerList(){
        System.out.println("[TowerQueryController] findMonsterTowerList -- GET");


        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "몬스터 타워 목록 조회"
                        , towerQueryService.findMonsterTowerList()
                )
        );
    }



}
