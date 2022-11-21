package com.profeel.monsterfac.monsterfactoryserver.tower.command.presentation.contoller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.tower.command.application.dto.RegistTowerRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.tower.command.application.service.RegistTowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * <pre>
 * Class : TowerController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Controller
@RequestMapping("/towers")
public class TowerController {

    private RegistTowerService registTowerService;

    @Autowired
    public TowerController(RegistTowerService registTowerService){
        this.registTowerService = registTowerService;
    }

    @PostMapping("")
    public ResponseEntity<ResponseDTO> registMonsterTower(RegistTowerRequestDTO registTowerRequest) throws IOException {
        System.out.println("[TowerController] registMonsterTower");
        System.out.println("registTowerRequest : " + registTowerRequest);


        Integer towerId = registTowerService.registMonsterTower(registTowerRequest);


        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "타워 등록 성공"
                        , "towerId : "+ towerId
                )
        );
    }


}
