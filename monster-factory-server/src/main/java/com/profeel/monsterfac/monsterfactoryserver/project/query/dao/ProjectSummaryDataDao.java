package com.profeel.monsterfac.monsterfactoryserver.project.query.dao;

import com.profeel.monsterfac.monsterfactoryserver.project.query.data.ProjectSummaryData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : ProjectSummaryDataDao
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
public interface ProjectSummaryDataDao extends JpaRepository<ProjectSummaryData, Integer> {
    List<ProjectSummaryData> findAllByDeveloperMemberIdAndProejctStatusNotIn(String developerMemberId, List<String> projectStatus);
}
