package com.profeel.monsterfac.monsterfactoryserver.project.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.project.command.application.exception.NotFoundProjectException;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Project;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class : ProjectQueryService
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
 * @see 참고할 class 또는 외부 url
 */

@Service
public class ProjectQueryService {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectQueryService(ProjectRepository projectRepository){
        this.projectRepository =projectRepository;
    }
    public boolean isValidable(Integer projectId){
        boolean result =  projectRepository.existsById(projectId);
        if(!result){
            throw new NotFoundProjectException("해당 프로젝트가 존재하지 않습니다");
        }
        return result;
    }

    public Project getProject(Integer projectId){
        isValidable(projectId);
        return projectRepository.findById(projectId).get();
    }

}
