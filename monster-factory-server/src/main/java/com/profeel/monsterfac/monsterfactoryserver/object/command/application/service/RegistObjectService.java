package com.profeel.monsterfac.monsterfactoryserver.object.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.FileService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.S3UploaderService;
import com.profeel.monsterfac.monsterfactoryserver.object.command.application.dto.RegistObjectDTO;
import com.profeel.monsterfac.monsterfactoryserver.object.command.domain.model.ObjectFileInfo;
import com.profeel.monsterfac.monsterfactoryserver.object.command.domain.model.Project;
import com.profeel.monsterfac.monsterfactoryserver.object.command.domain.model.ProjectObject;
import com.profeel.monsterfac.monsterfactoryserver.object.command.domain.repostiory.ObjectFileRepository;
import com.profeel.monsterfac.monsterfactoryserver.object.command.domain.repostiory.ObjectRepository;
import com.profeel.monsterfac.monsterfactoryserver.object.command.domain.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * <pre>
 * Class : RegistObjectService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-09       최윤서           최초 생성
 * </pre>
 * @version 1
 * @author 최윤서
 */

@Service
public class RegistObjectService {

    @Value("models")
    private String dirName;
    private ObjectRepository objectRepository;
    private ObjectService objectService;

    private ObjectFileRepository objectFileRepository;

    private S3UploaderService s3UploaderService;
    private FileService fileService;
    @Autowired
    public RegistObjectService(ObjectRepository objectRepository, ObjectService objectService, ObjectFileRepository objectFileRepository, S3UploaderService s3UploaderService, FileService fileService){
        this.objectRepository = objectRepository;
        this.objectService = objectService;
        this.objectFileRepository = objectFileRepository;
        this.s3UploaderService = s3UploaderService;
        this.fileService = fileService;

    }

    @Transactional
    public Integer registObject(RegistObjectDTO registObject) throws IOException {
        System.out.println("registObject : "+ registObject);
        FileInfo fileInfo = objectService.createFileInfo(registObject.getMultipartFile(), dirName);

        System.out.println("fileInfo : " + fileInfo );

        s3UploaderService.modelUpload(fileService.convertToFile(registObject.getMultipartFile()), dirName, fileInfo.getFilePath());

        ObjectFileInfo objectFileInfo = new ObjectFileInfo(
                fileInfo.getOriginalName(),
                fileInfo.getExtension(),
                fileInfo.getFilePath(),
                fileInfo.getUploadDatetime()
        );
        System.out.println("objectFileInfo : " + objectFileInfo );

        ObjectFileInfo result =  objectFileRepository.save(objectFileInfo);
        System.out.println("objectFileInfo save result : " + result );


        // project 검증
        Project project = objectService.createProject(registObject.getProjectId());

        // projetObject 객체 생성
        ProjectObject projectObject = new ProjectObject(
                result,
                registObject.getTransform(),
                project
        );
        System.out.println("prjectObject : " + projectObject);
        // projetObject insert
        objectRepository.save(projectObject);

        return projectObject.getId();
    }


}