package com.profeel.monsterfac.monsterfactoryserver.inventory.query.data;

/**
 * <pre>
 * Class : InventoryOwnerData
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

public class InventoryOwnerData {

    private String owner;

    public InventoryOwnerData() {}

    public InventoryOwnerData(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String player) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "InventoryOwnerData{" +
                "owner='" + owner + '\'' +
                '}';
    }
}
