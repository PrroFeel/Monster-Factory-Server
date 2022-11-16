package com.profeel.monsterfac.monsterfactoryserver.inventory.query.service;

import com.profeel.monsterfac.monsterfactoryserver.inventory.query.data.InventoryData;
import com.profeel.monsterfac.monsterfactoryserver.inventory.query.repository.InventoryQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Class : InventoryQueryService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-16       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Service
public class InventoryQueryService {

    private InventoryQueryMapper inventoryQueryMapper;

    @Autowired
    public InventoryQueryService(InventoryQueryMapper inventoryQueryMapper) {
        this.inventoryQueryMapper = inventoryQueryMapper;
    }

    public List<InventoryData> findInventoryItemByMemberId(String memberId) {

        return inventoryQueryMapper.findInventoryItemByMemberId(memberId);
    }
}
