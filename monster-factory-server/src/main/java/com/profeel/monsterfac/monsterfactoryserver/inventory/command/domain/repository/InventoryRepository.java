package com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.repository;

import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : InventoryRepository
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
