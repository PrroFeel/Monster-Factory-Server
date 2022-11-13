package com.profeel.monsterfac.monsterfactoryserver.play.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.play.command.application.dto.PlayResultResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.play.command.application.dto.RegistPlayResultDTO;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.PlayGame;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.PlayResult;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.Player;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.repository.PlayRepository;
import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

/**
 * <pre>
 * Class : RegistPlayResultService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-12       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Service
public class RegistPlayResultService {

    private final PlayService playService;
    private final PlayRepository playRepository;

    @Autowired
    public RegistPlayResultService(PlayService playService, PlayRepository playRepository) {
        this.playService = playService;
        this.playRepository = playRepository;
    }

    public PlayResultResponseDTO registPlayResult(RegistPlayResultDTO registPlayResultInfo) {

        Player player = playService.createPlayer(registPlayResultInfo.getPlayerId());

        PlayGame playGame = playService.createPlayGame(registPlayResultInfo.getGameId());

        PlayResult playResult = new PlayResult(
                player,
                playGame,
                registPlayResultInfo.getPlayTime()
        );

        playRepository.save(playResult);

        PlayResultResponseDTO playResultResponseDTO = new PlayResultResponseDTO(
                playResult.getPlayerId(),
                playResult.getPlayGameId(),
                playResult.getPlayTime()
        );

        return playResultResponseDTO;
    }

}
