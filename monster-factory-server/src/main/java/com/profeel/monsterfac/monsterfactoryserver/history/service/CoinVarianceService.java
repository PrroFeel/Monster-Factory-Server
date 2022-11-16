package com.profeel.monsterfac.monsterfactoryserver.history.service;

import com.profeel.monsterfac.monsterfactoryserver.history.dto.LogCoinVarianceRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.history.entity.CoinVariance;
import com.profeel.monsterfac.monsterfactoryserver.history.exception.NotVarifyCoinException;
import com.profeel.monsterfac.monsterfactoryserver.history.repository.CoinVarianceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Class : CoinVarainceService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-17       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 * @see 참고할 class 또는 외부 url
 */
@Service
public class CoinVarianceService {
    private CoinVarianceRepository coinVarianceRepository;

    public CoinVarianceService(CoinVarianceRepository coinVarianceRepository){
        this.coinVarianceRepository = coinVarianceRepository;

    }

    @Transactional
    public boolean logCoinVarianceHistory(LogCoinVarianceRequestDTO logCoinVarianceRequest){
        if(logCoinVarianceRequest.getAmount() <= 0){
            throw new NotVarifyCoinException("변동량은 0이거나 음수일 수 없습니다");
        }
        CoinVariance coinVariance = coinVarianceRepository.save(
                new CoinVariance(
                        logCoinVarianceRequest.getMemberId(),
                        logCoinVarianceRequest.getVarianceDateTime(),
                        logCoinVarianceRequest.getVariancedContent(),
                        logCoinVarianceRequest.getVariancedContentId(),
                        logCoinVarianceRequest.getAction(),
                        logCoinVarianceRequest.getAmount(),
                        logCoinVarianceRequest.getRemarks()
                )
        );
            return (coinVariance.getId() >0) ? true : false;

    }

}
