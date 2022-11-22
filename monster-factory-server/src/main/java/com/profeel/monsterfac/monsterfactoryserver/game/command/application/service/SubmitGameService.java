package com.profeel.monsterfac.monsterfactoryserver.game.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.game.command.application.dto.SubmitGameRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.game.command.application.exception.DuplicatedGameNameException;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.DevelopProject;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.Game;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.repository.GameRepository;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * <pre>
 * Class : SubmitGameService
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
@Service
public class SubmitGameService {

    private GameService gameService;
    private GameRepository gameRepository;

    @Autowired
    public SubmitGameService(GameService gameService, GameRepository gameRepository){
        this.gameService = gameService;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public Integer submitGame(SubmitGameRequestDTO submitGameRequest) throws IOException {
        if(gameService.checkGameNameDuplicated(submitGameRequest.getGameName())){
            throw new DuplicatedGameNameException("동일한 이름의 게임이 이미 존재합니다");
        }

        // project id 검증
        DevelopProject developProject = gameService.createProject(submitGameRequest.getProjectId());

        // 썸네일 파일 s3 업로드
        FileInfo thumbnailFileInfo = gameService.uploadImageFile(submitGameRequest.getThumbnailFile());

        // Game 객체 생성
        Game submitedGame = new Game(
                submitGameRequest.getGameName(),
                submitGameRequest.getGameDescription(),
                thumbnailFileInfo,
                developProject);
        // game object insert
        submitedGame = gameRepository.save(submitedGame);

        // return inserted game result
        return submitedGame.getId();
    }

}
