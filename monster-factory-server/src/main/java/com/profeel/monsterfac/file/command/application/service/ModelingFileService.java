package com.profeel.monsterfac.file.command.application.service;


import com.profeel.monsterfac.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.file.command.domain.model.ModelingFileInfo;
import com.profeel.monsterfac.file.command.domain.repository.ModelingFileRepository;
import com.profeel.monsterfac.file.command.domain.service.FileService;
import com.profeel.monsterfac.file.command.domain.service.S3UploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class ModelingFileService {

    @Value("models")
    private String dirName;
    private FileService fileService;
    private S3UploaderService s3UploaderService;

    private ModelingFileRepository modelingFileRepository;

    @Autowired
    public ModelingFileService(FileService fileService, S3UploaderService s3UploaderService, ModelingFileRepository modelingFileRepository){
        this.fileService = fileService;
        this.s3UploaderService = s3UploaderService;
        this.modelingFileRepository =modelingFileRepository;
    }

    public Integer uploadAndRegistModelingFile(MultipartFile multipartFile) throws IOException {

        FileInfo fileInfo = fileService.createFileInfo(multipartFile, dirName);

        s3UploaderService.modelUpload(fileService.convertToFile(multipartFile), dirName, fileInfo.getFilePath());

        ModelingFileInfo modelingFileInfo = new ModelingFileInfo(
                fileInfo.getOriginalName(),
                fileInfo.getExtension(),
                fileInfo.getFilePath(),
                fileInfo.getUploadDatetime()
        );

        modelingFileInfo =  modelingFileRepository.save(modelingFileInfo);
        System.out.println("modelingFileInfo : " + modelingFileInfo );

        return modelingFileInfo.getId();

    }
}