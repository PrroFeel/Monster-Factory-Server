package com.profeel.monsterfac.monsterfactoryserver.game.command.presentation.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.game.command.application.dto.SubmitGameRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * Class : GameController
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
@Controller
@RequestMapping("/test/games")
public class GameController {

    @PostMapping("/submit")
    public ResponseEntity<ResponseDTO> submitGame(SubmitGameRequestDTO submitGameRequest){
        System.out.println("[GameController] submitGame -- post");
        System.out.println("submitGameRequest : " +submitGameRequest);

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "게임 심사 제출 성공"
                        , "제출된 정보 보여질 예정"
                )
        );
    }

}
