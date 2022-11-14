package com.profeel.monsterfac.monsterfactoryserver.project.query.service;

import com.profeel.monsterfac.monsterfactoryserver.project.query.dao.EditInfoDataDao;
import com.profeel.monsterfac.monsterfactoryserver.project.query.dao.ProjectInfoDataDao;
import com.profeel.monsterfac.monsterfactoryserver.project.query.dao.ProjectSummaryDataDao;
import com.profeel.monsterfac.monsterfactoryserver.project.query.data.EditInfoData;
import com.profeel.monsterfac.monsterfactoryserver.project.query.data.ProjectInfoData;
import com.profeel.monsterfac.monsterfactoryserver.project.query.data.ProjectSummaryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    private EditInfoDataDao editInfoDataDao;
    private ProjectSummaryDataDao projectSummaryDataDao;
    @Autowired
    public ProjectQueryService(ProjectInfoDataDao projectInfoDataDao,
                               EditInfoDataDao editInfoDataDao,
                               ProjectSummaryDataDao projectSummaryDataDao){
        this.projectInfoDataDao = projectInfoDataDao;
        this.editInfoDataDao = editInfoDataDao;
        this.projectSummaryDataDao = projectSummaryDataDao;
    }
    public Optional<ProjectInfoData> findProjectInfoDataById(Integer projectId) {
        return projectInfoDataDao.findById(projectId);
    }

    public Optional<EditInfoData> findEditInfoDataById(Integer projectId){
        return editInfoDataDao.findById(projectId);
    }

    public List<ProjectSummaryData> findProjectSummaryListByUserId(String userId) {
        List<String> statusFilter = new ArrayList<>();
        statusFilter.add("DONE");
        return projectSummaryDataDao.findAllByDeveloperMemberIdAndProejctStatusNotInOrderByRecentUpdateDatetimeDesc(userId, statusFilter);
    }
}
