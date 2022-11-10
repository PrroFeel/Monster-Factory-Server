package com.profeel.monsterfac.monsterfactoryserver.project.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Project;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Class : DeleteProjectService
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

@Service
public class DeleteProjectService {
    private ProjectQueryService projectQueryService;
    private ProjectRepository projectRepository;

    @Autowired
    public DeleteProjectService(ProjectRepository projectRepository, ProjectQueryService projectQueryService){
        this.projectQueryService = projectQueryService;
        this.projectRepository = projectRepository;
    }

    @Transactional
    public void deleteProject(Integer projectId){
        // id 검증
        Project targetProject = projectQueryService.getProject(projectId);

        // project delete
        projectRepository.delete(targetProject);
    }
}
