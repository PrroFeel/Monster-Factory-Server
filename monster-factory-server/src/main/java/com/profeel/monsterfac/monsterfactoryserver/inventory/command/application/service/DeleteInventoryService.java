package com.profeel.monsterfac.monsterfactoryserver.inventory.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model.Inventory;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Class : DeleteInventoryService
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

@Service
public class DeleteInventoryService {

    private final InventoryAppQueryService inventoryAppQueryService;
    private final InventoryRepository inventoryRepository;

    @Autowired
    public DeleteInventoryService(InventoryAppQueryService inventoryAppQueryService, InventoryRepository inventoryRepository) {
        this.inventoryAppQueryService = inventoryAppQueryService;
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public String deleteInventory(int inventoryId) {

        Inventory inventory = inventoryAppQueryService.getInventory(inventoryId);

        inventoryRepository.delete(inventory);

        return "아이템 삭제 완료";
    }
}
