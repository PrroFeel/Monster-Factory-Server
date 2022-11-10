package com.profeel.monsterfac.monsterfactoryserver.item.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ImageFileInfo;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.dto.ItemResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.dto.RegistItemRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.Item;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.ItemCategory;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.repository.ItemRepository;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * <pre>
 * Class : RegistItemService
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

@Service
public class RegistItemService {

    private ItemRepository itemRepository;
    private ItemService itemService;

    @Autowired
    public RegistItemService(ItemRepository itemRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @Transactional
    public ItemResponseDTO registItemImg(RegistItemRequestDTO registItemRequest) throws IOException {

        ImageFileInfo itemFileInfo = itemService.uploadFile(registItemRequest.getItemImgFile());

        Item newItem = new Item(
                registItemRequest.getItemName(),
                registItemRequest.getItemPrice(),
                itemFileInfo,
                new ItemCategory(registItemRequest.getItemCategoryCode())
        );

        newItem = itemRepository.save(newItem);

        ItemResponseDTO itemResponseDTO = new ItemResponseDTO(
                newItem.getItemName(),
                itemFileInfo.getUrl(),
                newItem.getItemPrice(),
                newItem.getCategoryId()
        );

        return itemResponseDTO;
    }
}
