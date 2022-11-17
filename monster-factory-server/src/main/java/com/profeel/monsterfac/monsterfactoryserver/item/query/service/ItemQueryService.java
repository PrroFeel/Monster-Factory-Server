package com.profeel.monsterfac.monsterfactoryserver.item.query.service;

import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.repository.ItemRepository;
import com.profeel.monsterfac.monsterfactoryserver.item.query.data.ItemData;
import com.profeel.monsterfac.monsterfactoryserver.item.query.repository.ItemQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Class : ItemQueryService
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
public class ItemQueryService {

    private ItemQueryMapper itemQueryMapper;

    private ItemRepository itemRepository;

    @Autowired
    public ItemQueryService(ItemQueryMapper itemQueryMapper, ItemRepository itemRepository) {
        this.itemQueryMapper = itemQueryMapper;
        this.itemRepository = itemRepository;
    }



    public List<ItemData> findItem() {

        return itemQueryMapper.findItem();
    }

    public List<ItemData> findItemById(int itemId) {

        return itemQueryMapper.findItemById(itemId);
    }

}
