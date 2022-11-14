package com.profeel.monsterfac.monsterfactoryserver.inventory.command.domain.model;

/**
 * <pre>
 * Class : InventoryItemStatus
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

public enum InventoryItemStatus {

    WEARING, NON_WEARING;

    public static InventoryItemStatus fromString(String state) {
        switch(state) {
            case "WEARING": return WEARING;
            case "NON_WEARING": return NON_WEARING;
            default: return null;
        }
    }
}
