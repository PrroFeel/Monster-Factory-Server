package com.profeel.monsterfac.monsterfactoryserver.project.command.presentation.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationErrorException;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.ProjectResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.RegistProjectRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.SaveProjectRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.ProjectRequestValidator;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.RegistProjectService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.SaveProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    private ProjectRequestValidator projectRequestValidator;
    @Autowired
    public ProjectController(ProjectRequestValidator projectRequestValidator, RegistProjectService registProjectService, SaveProjectService saveProjectService ) {
        this.projectRequestValidator = projectRequestValidator;
        this.registProjectService = registProjectService;
        this.saveProjectService = saveProjectService;
    }

    @PostMapping("/projects")
    ResponseEntity<ResponseDTO> createProject(@RequestBody RegistProjectRequestDTO registProjectRequest) {
        System.out.println("[ProjectController] createProject 메소드 -- POST");
        System.out.println("registProjectRequest : " + registProjectRequest);
        // 필수 데이터 유무 검사
        List<ValidationError> errors = projectRequestValidator.validate(registProjectRequest);
        if (!errors.isEmpty()) throw new ValidationErrorException(errors);

        ProjectResponseDTO results = registProjectService.registProject(registProjectRequest);

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "프로젝트 생성 성공"
                        , results
                )
        );
    }

    @PostMapping("/projects/{id}/save")
    ResponseEntity<ResponseDTO> saveProjet(@PathVariable("id") Integer projectId, @RequestBody SaveProjectRequestDTO saveProjectRequest) {
        System.out.println("[ProjectController] saveProjet -- POST");
        // 필수 입력값 유무 검사
        List<ValidationError> errors = projectRequestValidator.validate(saveProjectRequest);
        if (!errors.isEmpty()) {
            throw new ValidationErrorException(errors);
        }

        System.out.println("projectId : " + projectId);
        System.out.println("storeProjectRequest.modelList : " + saveProjectRequest.getProjectPlacedTowerList());

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "프로젝트 저장 성공"
                        ,  saveProjectService.saveProject(projectId, saveProjectRequest.getProjectPlacedTowerList())
                )
        );
    }

    @PutMapping("/projects/{id}")
    ResponseEntity<ResponseDTO> updateNameOfProject(@PathVariable("id") Integer projectId, @RequestParam("name") String projectName){
        System.out.println("[ProjectController] updateNameOfProject -- PUT");
        System.out.println("projectName : " + projectName);

        List<ValidationError> errors = projectRequestValidator.validate(projectName);
        if (!errors.isEmpty()) {
            throw new ValidationErrorException(errors);
        }


        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"프로젝트 이름 수정 성공"
                        , "수정된 프로젝트 id: "+projectId
                )
        );
    }
}
