package com.profeel.monsterfac.monsterfactoryserver.item.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ImageFileInfo;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.dto.ItemResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.dto.RegistItemRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.Item;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.ItemCategory;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * <pre>
 * Class : UpdateItemService
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

@Service
public class UpdateItemService {

    private final ItemService itemService;
    private final ItemAppQueryService itemAppQueryService;

    public UpdateItemService(ItemService itemService, ItemAppQueryService itemAppQueryService) {
        this.itemService = itemService;
        this.itemAppQueryService = itemAppQueryService;
    }

    @Transactional
    public ItemResponseDTO updateItemInfo(int itemId, RegistItemRequestDTO registItemRequestInfo) throws IOException {

        Item targetItem = itemAppQueryService.getItem(itemId);
        ImageFileInfo itemFileInfo = itemService.uploadFile(registItemRequestInfo.getItemImgFile());

        targetItem.changeItem(
                registItemRequestInfo.getItemName(),
                registItemRequestInfo.getItemPrice(),
                itemFileInfo,
                new ItemCategory(registItemRequestInfo.getItemCategoryCode())
        );

        ItemResponseDTO itemResponseDTO = new ItemResponseDTO(
                targetItem.getItemName(),
                itemFileInfo.getUrl(),
                targetItem.getItemPrice(),
                targetItem.getCategoryId()
        );

        return itemResponseDTO;
    }
}
