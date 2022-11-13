package com.profeel.monsterfac.monsterfactoryserver.inventory.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model.Inventory;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.repository.InventoryRepository;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.exception.NotFoundItemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class : InventoryAppQueryService
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
public class InventoryAppQueryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryAppQueryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public boolean isValidable(int inventoryId) {

        boolean result = inventoryRepository.existsById(inventoryId);

        if(!result) {
            throw new NotFoundItemException("해당 인벤토리 정보를 찾을 수 없습니다");
        }

        return result;
    }

    public Inventory getInventory(int inventoryId) {

        isValidable(inventoryId);

        return inventoryRepository.findById(inventoryId).get();
    }

}
