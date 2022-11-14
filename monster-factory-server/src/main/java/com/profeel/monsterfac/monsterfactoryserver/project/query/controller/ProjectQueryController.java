package com.profeel.monsterfac.monsterfactoryserver.project.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.query.data.ProjectInfoData;
import com.profeel.monsterfac.monsterfactoryserver.project.query.data.ProjectSummaryData;
import com.profeel.monsterfac.monsterfactoryserver.project.query.service.ProjectQueryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <pre>
 * Class : ProjectQueryController
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

@Api(tags = {"Project 조회 API"}, description = "project 조화 관련 api")
@ApiResponses(value = {@ApiResponse(code = 200, message = "성공")})
@Controller
@RequestMapping("/projects")
public class ProjectQueryController {
    private ProjectQueryService projectQueryService;
    @Autowired
    public ProjectQueryController (ProjectQueryService projectQueryService){
        this.projectQueryService = projectQueryService;
    }

    @ApiOperation(value = "프로젝트 기본 정보 조회", notes = "프로젝트 이름 등 기본 정보 조회 api" ,response = ProjectInfoData.class)
    @ApiImplicitParam(name = "id", value = "조회하고자 하는 프로젝트 고유 번호")
    @GetMapping("/{id}/basic-info")
    public ResponseEntity<ResponseDTO> getProjectInfoData(@PathVariable("id") Integer projectId){
        System.out.println("[ProjectQueryController] getProjectInfoData -- GET");

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"프로젝트 기본 정보 조회"
                        , projectQueryService.findProjectInfoDataById(projectId)
                )
        );
    }

    @ApiOperation(value = "프로젝트 Edit 정보 조회", notes = "배치된 타워 등 edit 정보 조회 api" ,response = ProjectInfoData.class)
    @ApiImplicitParam(name = "id", value = "조회하고자 하는 프로젝트 고유 번호")
    @GetMapping("/{id}/edit-info")
    public ResponseEntity<ResponseDTO> getEditInfoDataById(@PathVariable("id") Integer projectId){
        System.out.println("[ProjectQueryController] getEditInfoDataById -- GET");

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"프로젝트 edit 정보 조회"
                        , projectQueryService.findEditInfoDataById(projectId)
                )
        );
    }


    @ApiOperation(value = "프로젝트 목록 조회", notes = "완료된 프로젝트를 제외한 모든 프로젝트 목록을 조회하는 api" ,response = ProjectSummaryData.class)
    @ApiImplicitParam(name = "user", value = "조회를 요청한 유저 ID (액세스 토큰으로 대체될 예정)")
    @GetMapping("")
    public ResponseEntity<ResponseDTO> getProjectSummaryList(@RequestParam(value = "user") String userId){
        System.out.println("[ProjectQueryController] getProjectSummaryList -- GET");

        List<ProjectSummaryData> projectSummaryDataList = projectQueryService.findProjectSummaryListByUserId(userId);


        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"특정 유저의 완료되지 않은 모든 프로젝트 목록 조회"
                        , projectSummaryDataList
                )
        );
    }

}
