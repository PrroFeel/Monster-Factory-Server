package com.profeel.monsterfac.monsterfactoryserver.game.command.presentation.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationErrorException;
import com.profeel.monsterfac.monsterfactoryserver.game.command.application.dto.SubmitGameRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.game.command.application.service.GameRequestValidator;
import com.profeel.monsterfac.monsterfactoryserver.game.command.application.service.SubmitGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

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
@Api(tags = {"Game API"}, description = "game 관련 api")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "성공")
})
@Controller
@RequestMapping("/games")
public class GameController {

    private GameRequestValidator gameRequestValidator;
    private SubmitGameService submitGameService;
    @Autowired
    public GameController(GameRequestValidator gameRequestValidator, SubmitGameService submitGameService){
        this.gameRequestValidator = gameRequestValidator;
        this.submitGameService = submitGameService;
    }

    @ApiOperation(value = "게임 심사 제출", notes = "게임 정보를 저장하고 심사 제출 하는 api")
    @PostMapping("/submit")
    public ResponseEntity<ResponseDTO> submitGame(@RequestParam SubmitGameRequestDTO submitGameRequest) throws IOException {
        System.out.println("[GameController] submitGame -- post");
        System.out.println("submitGameRequest : " +submitGameRequest);

        List<ValidationError> errors = gameRequestValidator.validate(submitGameRequest);
        if (!errors.isEmpty()) throw new ValidationErrorException(errors);

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "게임 심사 제출 성공"
                        , "game id :" + submitGameService.submitGame(submitGameRequest)
                )
        );
    }

}
