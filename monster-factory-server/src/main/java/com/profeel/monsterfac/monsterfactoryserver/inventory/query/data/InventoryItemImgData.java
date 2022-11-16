package com.profeel.monsterfac.monsterfactoryserver.inventory.query.data;

/**
 * <pre>
 * Class : InventoryItemImgData
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

public class InventoryItemImgData {

    private int inventoryItemImgId;
    private String inventoryItemImgUrl;
    private String inventoryItemOriginalFileName;

    public InventoryItemImgData() {}

    public InventoryItemImgData(int inventoryItemImgId, String inventoryItemImgUrl, String inventoryItemOriginalFileName) {
        this.inventoryItemImgId = inventoryItemImgId;
        this.inventoryItemImgUrl = inventoryItemImgUrl;
        this.inventoryItemOriginalFileName = inventoryItemOriginalFileName;
    }

    public int getInventoryItemImgId() {
        return inventoryItemImgId;
    }

    public void setInventoryItemImgId(int inventoryItemImgId) {
        this.inventoryItemImgId = inventoryItemImgId;
    }

    public String getInventoryItemImgUrl() {
        return inventoryItemImgUrl;
    }

    public void setInventoryItemImgUrl(String inventoryItemImgUrl) {
        this.inventoryItemImgUrl = inventoryItemImgUrl;
    }

    public String getInventoryItemOriginalFileName() {
        return inventoryItemOriginalFileName;
    }

    public void setInventoryItemOriginalFileName(String inventoryItemOriginalFileName) {
        this.inventoryItemOriginalFileName = inventoryItemOriginalFileName;
    }

    @Override
    public String toString() {
        return "InventoryItemImgData{" +
                "inventoryItemImgId=" + inventoryItemImgId +
                ", inventoryItemImgUrl='" + inventoryItemImgUrl + '\'' +
                ", inventoryItemOriginalFileName='" + inventoryItemOriginalFileName + '\'' +
                '}';
    }
}
