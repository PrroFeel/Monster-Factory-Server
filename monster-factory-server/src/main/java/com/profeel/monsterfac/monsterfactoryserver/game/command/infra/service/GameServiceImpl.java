package com.profeel.monsterfac.monsterfactoryserver.game.command.infra.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.application.service.UploadFileService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.DevelopProject;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.service.GameService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.ProjectQueryService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Project;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <pre>
 * Class : GameService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@DomainService
public class GameServiceImpl implements GameService {
    private ProjectQueryService projectQueryService;
    private UploadFileService uploadFileService;

    @Autowired
    public GameServiceImpl(ProjectQueryService projectQueryService, UploadFileService uploadFileService){
        this.projectQueryService = projectQueryService;
        this.uploadFileService = uploadFileService;
    }

    @Override
    public DevelopProject createProject(Integer projectId) {
        Project project = projectQueryService.getProject(projectId);
        return new DevelopProject(
                new ProjectId(project.getId()),
                project.getEditor()
        );
    }

    @Override
    public FileInfo uploadImageFile(MultipartFile thumbnailFile) throws IOException {
        return uploadFileService.uploadImageFile(thumbnailFile);
    }
}
