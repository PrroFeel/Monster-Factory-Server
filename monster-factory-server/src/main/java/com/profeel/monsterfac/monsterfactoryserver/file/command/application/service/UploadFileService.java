package com.profeel.monsterfac.monsterfactoryserver.file.command.application.service;


import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ImageFileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ModelingFileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.FileService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <pre>
 * Class : ImageFileService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-07       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Service
public class UploadFileService {

    private FileService fileService;
    private S3Service s3UploaderService;


    @Autowired
    public UploadFileService(FileService fileService, S3Service s3UploaderService){
        this.fileService = fileService;
        this.s3UploaderService = s3UploaderService;
    }

    public ModelingFileInfo uploadModelingFile(MultipartFile multipartFile) throws IOException {
        ModelingFileInfo fileInfo = fileService.createModelingFileInfo(multipartFile);

        // s3 업로드
        s3UploaderService.upload(multipartFile, fileInfo.getSavePath());

        return fileInfo;
    }

    public ImageFileInfo uploadImageFile(MultipartFile multipartFile) throws IOException {
        ImageFileInfo fileInfo = fileService.createImageFileInfo(multipartFile);
        String url = s3UploaderService.imageUpload(multipartFile, fileInfo.getSavePath());
        fileInfo = new ImageFileInfo(fileInfo, url);
        return fileInfo;
    }
}