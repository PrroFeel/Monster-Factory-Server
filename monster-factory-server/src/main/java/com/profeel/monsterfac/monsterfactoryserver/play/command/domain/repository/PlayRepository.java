package com.profeel.monsterfac.monsterfactoryserver.play.command.domain.repository;

import com.profeel.monsterfac.monsterfactoryserver.play.command.domain.model.PlayResult;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : PlayRepository
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

public interface PlayRepository extends JpaRepository<PlayResult, Integer> {
}
