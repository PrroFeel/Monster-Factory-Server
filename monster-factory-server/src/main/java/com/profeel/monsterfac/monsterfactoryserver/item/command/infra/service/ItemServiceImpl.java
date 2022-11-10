package com.profeel.monsterfac.monsterfactoryserver.item.command.infra.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.application.service.UploadFileService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ImageFileInfo;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.service.ItemService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    private final UploadFileService uploadFileService;

    public ItemServiceImpl(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @Override
    public ImageFileInfo uploadFile(MultipartFile itemImgFile) throws IOException {

        return uploadFileService.uploadImageFile(itemImgFile);
    }
}
