package com.profeel.monsterfac.monsterfactoryserver.item.command.application.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * Class : RegistItemRequestDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

public class RegistItemRequestDTO {

    private String itemName;
    private MultipartFile itemImgFile;
    private int itemPrice;
    private int itemCategoryCode;

    public RegistItemRequestDTO() {};

    public RegistItemRequestDTO(String itemName, MultipartFile itemImgFile, int itemPrice, int itemCategoryCode) {
        this.itemName = itemName;
        this.itemImgFile = itemImgFile;
        this.itemPrice = itemPrice;
        this.itemCategoryCode = itemCategoryCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public MultipartFile getItemImgFile() {
        return itemImgFile;
    }

    public void setItemImgFile(MultipartFile itemImgFile) {
        this.itemImgFile = itemImgFile;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemCategoryCode() {
        return itemCategoryCode;
    }

    public void setItemCategoryCode(int itemCategoryCode) {
        this.itemCategoryCode = itemCategoryCode;
    }

    @Override
    public String toString() {
        return "RegistItemRequestDTO{" +
                "itemName='" + itemName + '\'' +
                ", itemImgFile=" + itemImgFile +
                ", itemPrice=" + itemPrice +
                ", itemCategoryCode=" + itemCategoryCode +
                '}';
    }
}
