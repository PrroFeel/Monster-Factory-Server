package com.profeel.monsterfac.monsterfactoryserver.item.command.infra.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.FileService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.S3UploaderService;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.Item;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.repository.ItemRepository;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * Class : ItemServiceImpl
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

@DomainService
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private S3UploaderService s3UploaderService;

    private FileService fileService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, S3UploaderService s3UploaderService, FileService fileService) {
        this.itemRepository = itemRepository;
        this.s3UploaderService = s3UploaderService;
        this.fileService = fileService;
    }

    @Override
    @Transactional
    public Object registItem(MultipartFile itemImage, Item item) {

        if(!itemImage.isEmpty()) {
            FileInfo storedItemImgFile = fileService.createFileInfo(itemImage, "itemImages");

            return storedItemImgFile;
        }

        //임시로
        return null;
    }
}
