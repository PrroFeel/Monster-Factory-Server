package com.profeel.monsterfac.monsterfactoryserver.item.query.data;

/**
 * <pre>
 * Class : ItemImgData
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

public class ItemImgData {

    private int itemImgId;
    private String itemImgUrl;
    private String itemOriginalFileName;

    public ItemImgData(int itemImgId, String itemImgUrl, String itemOriginalFileName) {
        this.itemImgId = itemImgId;
        this.itemImgUrl = itemImgUrl;
        this.itemOriginalFileName = itemOriginalFileName;
    }

    public int getItemImgId() {
        return itemImgId;
    }

    public void setItemImgId(int itemImgId) {
        this.itemImgId = itemImgId;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }

    public String getItemOriginalFileName() {
        return itemOriginalFileName;
    }

    public void setItemOriginalFileName(String itemOriginalFileName) {
        this.itemOriginalFileName = itemOriginalFileName;
    }

    @Override
    public String toString() {
        return "ItemImgData{" +
                "itemImgId=" + itemImgId +
                ", itemImgUrl='" + itemImgUrl + '\'' +
                ", itemOriginalFileName='" + itemOriginalFileName + '\'' +
                '}';
    }
}
