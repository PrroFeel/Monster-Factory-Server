package com.profeel.monsterfac.monsterfactoryserver.file.command.application.service;


import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ImageFileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ModelingFileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.repository.ModelingFileRepository;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.FileService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.S3UploaderService;
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
    private S3UploaderService s3UploaderService;

    private ModelingFileRepository modelingFileRepository;

    @Autowired
    public UploadFileService(FileService fileService, S3UploaderService s3UploaderService, ModelingFileRepository modelingFileRepository){
        this.fileService = fileService;
        this.s3UploaderService = s3UploaderService;
        this.modelingFileRepository =modelingFileRepository;
    }

    public ModelingFileInfo uploadModelingFile(MultipartFile multipartFile, String type) throws IOException {
        ModelingFileInfo fileInfo = fileService.createModelingFileInfo(multipartFile);

        // s3 업로드
        s3UploaderService.modelUpload(fileService.convertToFile(multipartFile), fileInfo.getSavePath());

        return fileInfo;
    }

    public ImageFileInfo uploadImageFile(MultipartFile multipartFile, String type) throws IOException {
        ImageFileInfo fileInfo = fileService.createImageFileInfo(multipartFile);
        String url = s3UploaderService.imageUpload(fileService.convertToFile(multipartFile), fileInfo.getSavePath());
        fileInfo = new ImageFileInfo(fileInfo, url);
        return fileInfo;
    }
}