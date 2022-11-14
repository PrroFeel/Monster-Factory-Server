package com.profeel.monsterfac.monsterfactoryserver.project.query.service;

import com.profeel.monsterfac.monsterfactoryserver.member.query.service.MemberQueryService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.exception.NotFoundProjectException;
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
    private MemberQueryService memberQueryService;
    @Autowired
    public ProjectQueryService(MemberQueryService memberQueryService,
                               ProjectInfoDataDao projectInfoDataDao,
                               EditInfoDataDao editInfoDataDao,
                               ProjectSummaryDataDao projectSummaryDataDao){
        this.memberQueryService = memberQueryService;
        this.projectInfoDataDao = projectInfoDataDao;
        this.editInfoDataDao = editInfoDataDao;
        this.projectSummaryDataDao = projectSummaryDataDao;
    }

    public boolean isVaild(Integer projectId){
        boolean result = projectInfoDataDao.existsById(projectId);
        if(!result){
            throw new NotFoundProjectException("없는 project id 입니다");
        }
        return result;
    }

    public ProjectInfoData findProjectInfoDataById(Integer projectId) {
        isVaild(projectId);
        return projectInfoDataDao.findById(projectId).get();
    }

    public EditInfoData findEditInfoDataById(Integer projectId){
        isVaild(projectId);
        return editInfoDataDao.findById(projectId).get();
    }

    public List<ProjectSummaryData> findProjectSummaryListByUserId(String userId) {
        memberQueryService.isVailable(userId);
        List<String> statusFilter = new ArrayList<>();
        statusFilter.add("DONE");
        return projectSummaryDataDao.findAllByDeveloperMemberIdAndProejctStatusNotInOrderByRecentUpdateDatetimeDesc(userId, statusFilter);
    }
}
