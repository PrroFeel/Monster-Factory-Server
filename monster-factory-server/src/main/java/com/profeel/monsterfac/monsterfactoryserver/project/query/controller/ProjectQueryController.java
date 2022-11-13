package com.profeel.monsterfac.monsterfactoryserver.project.query.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.exception.NotFoundProjectException;
import com.profeel.monsterfac.monsterfactoryserver.project.query.data.ProjectInfoData;
import com.profeel.monsterfac.monsterfactoryserver.project.query.service.ProjectQueryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

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
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getProjectInfoData(@PathVariable("id") Integer projectId){
        System.out.println("[ProjectQueryController] getProjectInfoData -- GET");

        Optional<ProjectInfoData> projectInfoDataOpt = projectQueryService.findProjectInfoDataById(projectId);
        ProjectInfoData projectInfoData = projectInfoDataOpt.orElseThrow(()->new NotFoundProjectException("해당 프로젝트를 찾을 수 없습니다"));

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"프로젝트 정보 조회"
                        , projectInfoData
                )
        );
    }

}
