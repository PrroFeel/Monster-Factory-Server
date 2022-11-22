package com.profeel.monsterfac.monsterfactoryserver.game.query.repository;

import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameSummaryData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : GameSummaryDataDao
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
public interface GameSummaryDataDao extends JpaRepository<GameSummaryData, Integer> {
    List<GameSummaryData> findAllByDeveloperMemberId(String developerMemberId);
    List<GameSummaryData> findAllByGameStatusOrderBySubmitDatetime(String gameStatus);

    List<GameSummaryData> findAllByGameStatusOrderBySubmitDatetimeDesc(String gameStatus);
    List<GameSummaryData> findAllByGameStatusInOrderBySubmitDatetime(List<String> gameStatusList);
}

