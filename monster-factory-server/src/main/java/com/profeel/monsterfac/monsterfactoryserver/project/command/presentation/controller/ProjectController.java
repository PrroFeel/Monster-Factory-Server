package com.profeel.monsterfac.monsterfactoryserver.project.command.presentation.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.ProjectResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.RegistProjectRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.SaveProjectRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.RegistProjectService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.SaveProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * <pre>
 * Class : ProjectController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */

@Controller
@RequestMapping("/test")
public class ProjectController {

    private RegistProjectService registProjectService;
    private SaveProjectService saveProjectService;
    @Autowired
    public ProjectController(RegistProjectService registProjectService, SaveProjectService saveProjectService ) {
        this.registProjectService = registProjectService;
        this.saveProjectService = saveProjectService;
    }

    @PostMapping("/projects")
    ResponseEntity<ResponseDTO> createProject(@RequestBody RegistProjectRequestDTO projectRequest) {
        System.out.println("[ProjectController]");
        System.out.println("post 요청 들어옴 -- createProject 메소드");

        System.out.println("projectRequest : " + projectRequest);

        ProjectResponseDTO results = registProjectService.registProject(projectRequest);

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "프로젝트 생성 성공"
                        , results
                )
        );
    }

    @PostMapping("/projects/save")
    ResponseEntity<ResponseDTO> saveProjet(@RequestBody SaveProjectRequestDTO saveProjectRequest) throws IOException {
        System.out.println("[ProjectController]");
        System.out.println("put 요청 들어옴 -- saveProjet 메소드");

        System.out.println("storeProjectRequest.projectId : " + saveProjectRequest.getProjectId());
        System.out.println("storeProjectRequest.modelList : " + saveProjectRequest.getProjectPlacedTowerList());

        ProjectResponseDTO result = saveProjectService.saveProject(saveProjectRequest);
        System.out.println(result);
        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "프로젝트 저장 성공"
                        ,  result
                )
        );
    }
}
