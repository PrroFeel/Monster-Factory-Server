package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.repository;

import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : GameRepository
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
public interface GameRepository extends JpaRepository<Game, Integer> {
}
