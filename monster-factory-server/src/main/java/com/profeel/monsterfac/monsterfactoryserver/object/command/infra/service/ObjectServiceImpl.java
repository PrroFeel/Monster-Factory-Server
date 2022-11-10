package com.profeel.monsterfac.monsterfactoryserver.object.command.infra.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.FileService;
import com.profeel.monsterfac.monsterfactoryserver.object.command.domain.model.Project;
import com.profeel.monsterfac.monsterfactoryserver.object.command.domain.service.ObjectService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

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
public class ObjectServiceImpl implements ObjectService {

    FileService fileService;

    @Autowired
    public ObjectServiceImpl(FileService fileService){
        this.fileService = fileService;
    }
    @Override
    public FileInfo createFileInfo(MultipartFile multipartFile, String dirName) {
        return fileService.createFileInfo(multipartFile, dirName);
    }

    @Override
    public Project createProject(ProjectId projectId) {

        return new Project(projectId);
    }
}
