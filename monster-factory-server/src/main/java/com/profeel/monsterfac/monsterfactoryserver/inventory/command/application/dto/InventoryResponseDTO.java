package com.profeel.monsterfac.monsterfactoryserver.inventory.command.application.dto;

import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model.HoldingItems;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model.InventoryItemStatus;
import com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model.InventoryOwner;

/**
 * <pre>
 * Class : InventoryResponseDTO
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

public class InventoryResponseDTO {

    private InventoryOwner ownerId;
    private HoldingItems itemId;
    private InventoryItemStatus status;

    public InventoryResponseDTO() {}

    public InventoryResponseDTO(InventoryOwner ownerId, HoldingItems itemId, InventoryItemStatus status) {
        this.ownerId = ownerId;
        this.itemId = itemId;
        this.status = status;
    }

    public InventoryOwner getOwnerId() {
        return ownerId;
    }

    public HoldingItems getItemId() {
        return itemId;
    }

    public InventoryItemStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "InventoryResponseDTO{" +
                "ownerId=" + ownerId +
                ", itemId=" + itemId +
                ", status=" + status +
                '}';
    }
}
