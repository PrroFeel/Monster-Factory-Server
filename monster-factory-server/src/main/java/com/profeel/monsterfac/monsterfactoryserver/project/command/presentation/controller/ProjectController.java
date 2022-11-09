package com.profeel.monsterfac.monsterfactoryserver.project.command.presentation.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.ProjectResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.RegistProjectRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.RegistProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @Autowired
    public ProjectController(RegistProjectService registProjectService) {
        this.registProjectService = registProjectService;
//        this.storeProjectService = storeProjectService;
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
}
