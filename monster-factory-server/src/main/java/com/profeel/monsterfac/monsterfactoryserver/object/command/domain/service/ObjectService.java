package com.profeel.monsterfac.monsterfactoryserver.object.command.domain.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.object.command.domain.model.Project;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectId;
import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * Class : ObjectService
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
 * @see 참고할 class 또는 외부 url
 */
public interface ObjectService {

    FileInfo createFileInfo(MultipartFile multipartFile, String dirName);

    Project createProject(ProjectId projectId);
}
