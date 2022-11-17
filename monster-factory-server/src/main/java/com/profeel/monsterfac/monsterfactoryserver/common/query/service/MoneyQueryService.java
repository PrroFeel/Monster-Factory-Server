package com.profeel.monsterfac.monsterfactoryserver.common.query.service;

import com.profeel.monsterfac.monsterfactoryserver.common.query.data.MoneyData;
import com.profeel.monsterfac.monsterfactoryserver.common.query.repository.MoneyQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Class : MoneyQueryService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-17       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Service
public class MoneyQueryService {

    private MoneyQueryMapper moneyQueryMapper;

    @Autowired
    public MoneyQueryService(MoneyQueryMapper moneyQueryMapper) {
        this.moneyQueryMapper = moneyQueryMapper;
    }

    public List<MoneyData> findMoneyByMemberId(String memberId) {

        return moneyQueryMapper.findMoneyByMemberId(memberId);
    }
}
