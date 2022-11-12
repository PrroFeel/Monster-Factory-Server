package com.profeel.monsterfac.monsterfactoryserver.item.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.Item;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Class : DeleteItemService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-12       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Service
public class DeleteItemService {

    private final ItemAppQueryService itemAppQueryService;
    private final ItemRepository itemRepository;

    public DeleteItemService(ItemAppQueryService itemAppQueryService, ItemRepository itemRepository) {
        this.itemAppQueryService = itemAppQueryService;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public String deleteItem(int itemId) {

        Item targetItem = itemAppQueryService.getItem(itemId);

        itemRepository.delete(targetItem);

        return "아이템 삭제 완료";
    }

}
