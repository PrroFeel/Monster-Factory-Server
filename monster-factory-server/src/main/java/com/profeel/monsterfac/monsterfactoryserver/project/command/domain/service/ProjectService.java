package com.profeel.monsterfac.monsterfactoryserver.project.command.domain.service;

import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Editor;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectId;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <pre>
 * Class : ProjectService
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
public interface ProjectService {
    Editor createEditor(String userId);
//    Integer uploadAndRegistModelingFile(MultipartFile modelingFile) throws IOException;
    ProjectId createProjectId(Integer projectId);

//    Integer uploadAndRegistObject(MultipartFile modelingFile, String transform);

    Integer uploadAndRegistObject(MultipartFile modelingFile, ProjectId projectId, String transform) throws IOException;
}