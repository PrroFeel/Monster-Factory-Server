package com.profeel.monsterfac.monsterfactoryserver.project.command.infra.service;


import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.application.service.ModelingFileService;
import com.profeel.monsterfac.monsterfactoryserver.member.command.domain.model.MemberId;
import com.profeel.monsterfac.monsterfactoryserver.member.query.service.MemberQueryService;
import com.profeel.monsterfac.monsterfactoryserver.object.command.application.dto.RegistObjectDTO;
import com.profeel.monsterfac.monsterfactoryserver.object.command.application.service.RegistObjectService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Editor;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectId;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <pre>
 * Class : ProjectServiceImpl
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-06       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@DomainService
public class ProjectServiceImpl implements ProjectService {

    private MemberQueryService memberQueryService;
    private ModelingFileService modelingFileService;

    private RegistObjectService registObjectService;

    @Autowired
    public ProjectServiceImpl(MemberQueryService memberQueryService, ModelingFileService modelingFileService, RegistObjectService registObjectService){
        this.memberQueryService = memberQueryService;
        this.modelingFileService = modelingFileService;
        this.registObjectService = registObjectService;
    }
    @Override
    public Editor createEditor(String userId) {
        memberQueryService.isVailable(userId);
        return new Editor(new MemberId(userId));
    }
    @Override
    public ProjectId createProjectId(Integer projectId) {
        return new ProjectId(projectId);
    }

    @Override
    public Integer uploadAndRegistObject(MultipartFile modelingFile, ProjectId projectId, String transform) throws IOException {
        return registObjectService.registObject(new RegistObjectDTO(modelingFile, projectId, transform));
    }
//    @Override
//    public Integer uploadAndRegistModelingFile(MultipartFile modelingFile) throws IOException {
//        return modelingFileService.uploadAndRegistModelingFile(modelingFile);
//    }



//    @Override
//    public Integer uploadAndRegistObject(MultipartFile modelingFile, String transform) {
//        return null;
//    }


}
