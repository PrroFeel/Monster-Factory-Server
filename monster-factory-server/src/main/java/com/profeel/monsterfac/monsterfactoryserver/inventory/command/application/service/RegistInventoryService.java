package com.profeel.monsterfac.monsterfactoryserver.inventory.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.inventory.command.application.dto.InventoryResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.application.dto.RegistInventoryRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model.HoldingItems;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model.Inventory;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model.InventoryItemStatus;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model.InventoryOwner;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Class : RegistInventoryService
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
public class RegistInventoryService {

    private InventoryRepository inventoryRepository;

    @Autowired
    public RegistInventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public Object registInventory(RegistInventoryRequestDTO registInventoryRequestInfo) {

        Inventory newInventoryItem = new Inventory(
                new InventoryOwner(registInventoryRequestInfo.getOwnerId()),
                new HoldingItems(registInventoryRequestInfo.getItemId()),
                InventoryItemStatus.fromString("NON_WEARING")
        );

        newInventoryItem = inventoryRepository.save(newInventoryItem);

        InventoryResponseDTO inventoryResponseDTO = new InventoryResponseDTO(
                newInventoryItem.getInventoryOwner(),
                newInventoryItem.getHoldingItems(),
                newInventoryItem.getStatus()
        );

        return inventoryResponseDTO;
    }

}
