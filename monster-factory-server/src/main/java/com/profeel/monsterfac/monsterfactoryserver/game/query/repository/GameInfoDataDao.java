package com.profeel.monsterfac.monsterfactoryserver.game.query.repository;

import com.profeel.monsterfac.monsterfactoryserver.game.query.data.GameInfoData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : GameInfoDataDao
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
public interface GameInfoDataDao extends JpaRepository<GameInfoData, Integer> {

}
