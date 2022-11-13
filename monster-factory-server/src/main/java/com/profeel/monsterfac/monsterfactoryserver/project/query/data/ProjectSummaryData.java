package com.profeel.monsterfac.monsterfactoryserver.project.query.data;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Class : ProjectSummaryData
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
@Entity
@Table(name = "tbl_projects")
public class ProjectSummaryData {


    @ApiModelProperty(example = "프로젝트 고유 번호")
    @Id
    @Column(name="project_id")
    private Integer projectId;


    @ApiModelProperty(example = "프로젝트 최근 수정 날짜 및 시간")
    @Column(name="recent_update_datetime")
    private String recentUpdateDatetime;


    @ApiModelProperty(example = "프로젝트 이름")
    @Column(name="project_name")
    private String projectName;

    @ApiModelProperty(example = "프로젝트 상태 - PRE : 개발 전, IN_PROGRESS : 개발 중, DONE : 개발 완료")
    @Column(name="project_status")
    private String proejctStatus;

    protected ProjectSummaryData(){}

    public ProjectSummaryData(Integer projectId, String recentUpdateDatetime, String projectName, String proejctStatus) {
        this.projectId = projectId;
        this.recentUpdateDatetime = recentUpdateDatetime;
        this.projectName = projectName;
        this.proejctStatus = proejctStatus;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public String getRecentUpdateDatetime() {
        return recentUpdateDatetime;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProejctStatus() {
        return proejctStatus;
    }

    @Override
    public String toString() {
        return "ProjectSummaryData{" +
                "projectId=" + projectId +
                ", recentUpdateDatetime='" + recentUpdateDatetime + '\'' +
                ", projectName='" + projectName + '\'' +
                ", proejctStatus='" + proejctStatus + '\'' +
                '}';
    }
}
