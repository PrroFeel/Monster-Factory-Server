package com.profeel.monsterfac.monsterfactoryserver.game.query.service;

import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameInfoData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameRewardData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameSummaryData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.dto.GameLoadResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.game.query.exception.NotFoundGameException;
import com.profeel.monsterfac.monsterfactoryserver.game.query.repository.GameDataDao;
import com.profeel.monsterfac.monsterfactoryserver.game.query.repository.GameInfoDataDao;
import com.profeel.monsterfac.monsterfactoryserver.game.query.repository.GameRewardDataDao;
import com.profeel.monsterfac.monsterfactoryserver.game.query.repository.GameSummaryDataDao;
import com.profeel.monsterfac.monsterfactoryserver.member.query.service.MemberQueryService;
import com.profeel.monsterfac.monsterfactoryserver.project.query.service.ProjectQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Class : Game
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-14       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Service
public class GameQueryService {

    private MemberQueryService memberQueryService;
    private ProjectQueryService projectQueryService;

    private GameDataDao gameDataDao;
    private GameSummaryDataDao gameSummaryDataDao;


    private GameInfoDataDao gameInfoDataDao;



    private GameRewardDataDao gameRewardDataDao;
    @Autowired
    public GameQueryService(MemberQueryService memberQueryService,
                            GameDataDao gameDataDao,
                            GameSummaryDataDao gameSummaryDataDao,
                            GameInfoDataDao gameInfoDataDao,
                            ProjectQueryService projectQueryService,
                            GameRewardDataDao gameRewardDataDao){
        this.gameDataDao = gameDataDao;
        this.gameSummaryDataDao = gameSummaryDataDao;
        this.memberQueryService = memberQueryService;
        this.gameInfoDataDao = gameInfoDataDao;
        this.projectQueryService =projectQueryService;
        this.gameRewardDataDao = gameRewardDataDao;
    }

    public boolean isVailable(Integer gameId) {

        boolean result = gameDataDao.existsById(gameId);

        if(!result) {
            throw new NotFoundGameException("존재하지 않은 게임 입니다.");
        }

        return result;
    }

    public GameData getGameData(Integer gameId) {
        isVailable(gameId);
        return (gameDataDao.findById(gameId)).get();
    }

    public List<GameSummaryData> getGameSummaryDataList(String memberId){
        memberQueryService.isVailable(memberId);
        return gameSummaryDataDao.findAllByDeveloperMemberId(memberId);
    }

    public List<GameSummaryData> getUploadedGameSummaryList() {
        return gameSummaryDataDao.findAllByGameStatus("UPLOADED");
    }

    public List<GameSummaryData> getWaitedGameList() {
        return gameSummaryDataDao.findAllByGameStatus("JUDGE_WAIT");
    }

    public GameInfoData getGameInfoData(Integer gameId){
        isVailable(gameId);
        return gameInfoDataDao.findById(gameId).get();
    }

    public GameRewardData getGameRewardData(Integer gameId){
        isVailable(gameId);
        return gameRewardDataDao.findById(gameId).get();
    }
    public GameLoadResponseDTO findGameLoadInfoById(Integer gameId){
        // game id 검증 및 rewardData read
        GameRewardData gameRewardData = getGameRewardData(gameId);

        return new GameLoadResponseDTO(
                gameRewardData,
                projectQueryService.findEditInfoDataById(gameRewardData.getProjectId())
        );
    }
}
