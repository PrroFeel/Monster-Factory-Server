package com.profeel.monsterfac.monsterfactoryserver.inventory.command.application.dto;

/**
 * <pre>
 * Class : RegistInventoryRequestDTO
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

public class RegistInventoryRequestDTO {

    private String ownerId;
    private int itemId;

    public RegistInventoryRequestDTO() {}

    public RegistInventoryRequestDTO(String ownerId, int itemId) {
        this.ownerId = ownerId;
        this.itemId = itemId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "RegistInventoryRequestDTO{" +
                "ownerId='" + ownerId + '\'' +
                ", itemId=" + itemId +
                '}';
    }
}
