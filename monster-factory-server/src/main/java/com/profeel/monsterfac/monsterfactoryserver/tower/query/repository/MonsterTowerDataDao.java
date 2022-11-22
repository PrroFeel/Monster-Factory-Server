package com.profeel.monsterfac.monsterfactoryserver.tower.query.repository;

import com.profeel.monsterfac.monsterfactoryserver.tower.query.data.MonsterTowerData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : TowerDataDao
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-21       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 * @see 참고할 class 또는 외부 url
 */
public interface MonsterTowerDataDao extends JpaRepository<MonsterTowerData, Integer> {
    List<MonsterTowerData> findByTowerName(String towerName);
}
