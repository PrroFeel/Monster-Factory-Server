package com.profeel.monsterfac.monsterfactoryserver.project.query.data;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Class : ProjectInfoData
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
public class ProjectInfoData {
    @ApiModelProperty(example = "프로젝트 고유 번호")
    @Id
    @Column(name="project_id")
    private Integer projectId;


    @ApiModelProperty(example = "프로젝트 이름")
    @Column(name="project_name")
    private String projectName;

    @ApiModelProperty(example = "프로젝트 개발자 ID")
    @Column(name="developer_member_id")
    private String developerMemberId;

    @ApiModelProperty(example = "프로젝트 생성 날짜 및 시간")
    @Column(name="create_datetime")
    private String createDatetime;

    @ApiModelProperty(example = "프로젝트 최근 수정 날짜 및 시간")
    @Column(name="recent_update_datetime")
    private String recentUpdateDatetime;

    @ApiModelProperty(example = "프로젝트 상태 - PRE : 개발 전, IN_PROGRESS : 개발 중, DONE : 개발 완료")
    @Column(name="project_status")
    private String proejctStatus;

    protected ProjectInfoData(){}

    public ProjectInfoData(Integer projectId, String projectName, String developerMemberId, String createDatetime, String recentUpdateDatetime, String proejctStatus) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.developerMemberId = developerMemberId;
        this.createDatetime = createDatetime;
        this.recentUpdateDatetime = recentUpdateDatetime;
        this.proejctStatus = proejctStatus;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDeveloperMemberId() {
        return developerMemberId;
    }

    public void setDeveloperMemberId(String developerMemberId) {
        this.developerMemberId = developerMemberId;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getRecentUpdateDatetime() {
        return recentUpdateDatetime;
    }

    public void setRecentUpdateDatetime(String recentUpdateDatetime) {
        this.recentUpdateDatetime = recentUpdateDatetime;
    }

    public String getProejctStatus() {
        return proejctStatus;
    }

    public void setProejctStatus(String proejctStatus) {
        this.proejctStatus = proejctStatus;
    }

    @Override
    public String toString() {
        return "ProjectInfoData{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", developerMemberId='" + developerMemberId + '\'' +
                ", createDatetime=" + createDatetime +
                ", recentUpdateDatetime='" + recentUpdateDatetime + '\'' +
                ", proejctStatus='" + proejctStatus + '\'' +
                '}';
    }
}
