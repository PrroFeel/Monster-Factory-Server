package com.profeel.monsterfac.monsterfactoryserver.purchase.domain.repository;

import com.profeel.monsterfac.monsterfactoryserver.purchase.domain.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : PurchaseRepository
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
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
