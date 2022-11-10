package com.profeel.monsterfac.monsterfactoryserver.tower.command.infra.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.application.service.UploadFileService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ModelingFileInfo;
import com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.service.TowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <pre>
 * Class : ObjectServiceImpl
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-09       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@DomainService
public class TowerServiceImpl implements TowerService {

    private final UploadFileService uploadFileService;

    @Autowired
    public TowerServiceImpl(UploadFileService uploadFileService){
        this.uploadFileService = uploadFileService;
    }

    public ModelingFileInfo uploadFile(MultipartFile multipartFile) throws IOException {
        return uploadFileService.uploadModelingFile(multipartFile);
    }


}
