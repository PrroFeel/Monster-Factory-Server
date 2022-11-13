package com.profeel.monsterfac.monsterfactoryserver.project.query.service;

import com.profeel.monsterfac.monsterfactoryserver.project.query.dao.ProjectInfoDataDao;
import com.profeel.monsterfac.monsterfactoryserver.project.query.data.ProjectInfoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <pre>
 * Class : ProjectQueryService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Service
public class ProjectQueryService {

    private ProjectInfoDataDao projectInfoDataDao;
    @Autowired
    public ProjectQueryService(ProjectInfoDataDao projectInfoDataDao){
        this.projectInfoDataDao = projectInfoDataDao;
    }
    public Optional<ProjectInfoData> findProjectInfoDataById(Integer projectId) {
        return projectInfoDataDao.findById(projectId);
    }
}
