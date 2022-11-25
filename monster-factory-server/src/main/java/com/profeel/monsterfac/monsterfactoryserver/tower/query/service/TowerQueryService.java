package com.profeel.monsterfac.monsterfactoryserver.tower.query.service;

import com.profeel.monsterfac.monsterfactoryserver.tower.query.data.MonsterTowerData;
import com.profeel.monsterfac.monsterfactoryserver.tower.query.exception.NotFoundTowerException;
import com.profeel.monsterfac.monsterfactoryserver.tower.query.repository.MonsterTowerDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Class : TowerQueryService
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
 */
@Service
public class TowerQueryService {
    private final MonsterTowerDataDao monsterTowerDataDao;

    @Autowired
    public TowerQueryService(MonsterTowerDataDao monsterTowerDataDao){
        this.monsterTowerDataDao = monsterTowerDataDao;
    }

    public boolean isValidable(int towerId){
        if(!monsterTowerDataDao.existsById(towerId)){
            throw new NotFoundTowerException("해당 타워를 찾을 수 없습니다");
        }
        return true;
    }

    public MonsterTowerData findMonsterTowerByTowerName(String towerName) {
        List<MonsterTowerData> monsterTowerDataList = monsterTowerDataDao.findByTowerName(towerName);
        if(monsterTowerDataList.isEmpty()){
            throw new NotFoundTowerException("해당 이름을 가진 타워가 없습니다");
        }

        return monsterTowerDataList.get(0);

    }

    public MonsterTowerData findMonsterTowerById(int towerId) {
        isValidable(towerId);
        return monsterTowerDataDao.findById(towerId).get();
    }

    public List<MonsterTowerData> findMonsterTowerList() {
        return monsterTowerDataDao.findAll();
    }
}
