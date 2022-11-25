package com.profeel.monsterfac.monsterfactoryserver.play.query.service;

import com.profeel.monsterfac.monsterfactoryserver.play.query.data.PlayRankData;
import com.profeel.monsterfac.monsterfactoryserver.play.query.repository.PlayQueryMapper;
import com.profeel.monsterfac.monsterfactoryserver.play.query.repository.PlayResultDataDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Class : PlayQueryService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Service
public class PlayQueryService {

    private PlayQueryMapper playQueryMapper;
    private PlayResultDataDao playResultDataDao;
    public PlayQueryService(PlayQueryMapper playQueryMapper,
                            PlayResultDataDao playResultDataDao) {
        this.playQueryMapper = playQueryMapper;
        this.playResultDataDao = playResultDataDao;
    }

    public List<PlayRankData> findRankingByGameId(int playGameId) {

        return playQueryMapper.findRankingByGameId(playGameId);
    }

    public int findPlayCountByGameId(int gameId){
        return playResultDataDao.countPlayResultDataByPlayGameId(gameId);
    }

}
