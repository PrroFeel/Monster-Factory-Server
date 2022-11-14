package com.profeel.monsterfac.monsterfactoryserver.game.query.service;

import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameInfoData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameSummaryData;
import com.profeel.monsterfac.monsterfactoryserver.game.query.exception.NotFoundGameException;
import com.profeel.monsterfac.monsterfactoryserver.game.query.repository.GameDataDao;
import com.profeel.monsterfac.monsterfactoryserver.game.query.repository.GameInfoDataDao;
import com.profeel.monsterfac.monsterfactoryserver.game.query.repository.GameSummaryDataDao;
import com.profeel.monsterfac.monsterfactoryserver.member.query.service.MemberQueryService;
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
    private GameDataDao gameDataDao;
    private GameSummaryDataDao gameSummaryDataDao;


    private GameInfoDataDao gameInfoDataDao;

    @Autowired
    public GameQueryService(MemberQueryService memberQueryService,
                            GameDataDao gameDataDao,
                            GameSummaryDataDao gameSummaryDataDao,
                            GameInfoDataDao gameInfoDataDao){
        this.gameDataDao = gameDataDao;
        this.gameSummaryDataDao = gameSummaryDataDao;
        this.memberQueryService = memberQueryService;
        this.gameInfoDataDao = gameInfoDataDao;
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
}
