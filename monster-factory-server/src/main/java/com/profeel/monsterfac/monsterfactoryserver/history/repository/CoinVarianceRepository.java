package com.profeel.monsterfac.monsterfactoryserver.history.repository;

import com.profeel.monsterfac.monsterfactoryserver.history.entity.CoinVariance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ConVarianceRepository
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
public interface CoinVarianceRepository extends JpaRepository<CoinVariance, Integer> {
}
