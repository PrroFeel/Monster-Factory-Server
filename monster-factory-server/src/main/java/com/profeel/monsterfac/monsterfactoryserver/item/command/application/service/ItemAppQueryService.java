package com.profeel.monsterfac.monsterfactoryserver.item.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.item.command.application.exception.NotFoundItemException;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.Item;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.repository.ItemRepository;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class : ItemService
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
public class ItemAppQueryService {

    private ItemRepository itemRepository;

    public ItemAppQueryService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public boolean isValidable(int itemId) {

        boolean result = itemRepository.existsById(itemId);

        if(!result) {
            throw new NotFoundItemException("해당 아이템을 찾을 수 없습니다");
        }

        return result;
    }

    public Item getItem(int itemId) {

        isValidable(itemId);

        return itemRepository.findById(itemId).get();
    }
}
