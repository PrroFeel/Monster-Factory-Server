package com.profeel.monsterfac.monsterfactoryserver.project.command.presentation.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationError;
import com.profeel.monsterfac.monsterfactoryserver.common.exception.ValidationErrorException;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.ProjectResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.RegistProjectRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.dto.SaveProjectRequestDTO;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.DeleteProjectService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.ProjectRequestValidator;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.RegistProjectService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.UpdateProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = {"Project API"})
@Controller
@RequestMapping("/projects")
public class ProjectController {
    private ProjectRequestValidator projectRequestValidator;
    private RegistProjectService registProjectService;
    private UpdateProjectService updateProjectService;

    private DeleteProjectService deleteProjectService;
    @Autowired
    public ProjectController(ProjectRequestValidator projectRequestValidator, RegistProjectService registProjectService, UpdateProjectService updateProjectService, DeleteProjectService deleteProjectService) {
        this.projectRequestValidator = projectRequestValidator;
        this.registProjectService = registProjectService;
        this.updateProjectService =updateProjectService;
        this.deleteProjectService = deleteProjectService;
    }

    @ApiOperation(value = "프로젝트 생성", notes = "프로젝트 생성하는 api")
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

    @ApiOperation(value = "프로젝트 저장", notes = "프로젝트 edit 정보를 저장하는 api")
    @PatchMapping("/{id}/save")
    ResponseEntity<ResponseDTO> saveProjet(@PathVariable("id") Integer projectId, @RequestBody SaveProjectRequestDTO saveProjectRequest) {
        System.out.println("[ProjectController] saveProjet -- POST");
        // 필수 입력값 유무 검사
        List<ValidationError> errors = projectRequestValidator.validate(saveProjectRequest);
        if (!errors.isEmpty()) {
            throw new ValidationErrorException(errors);
        }

        System.out.println("projectId : " + projectId);
        System.out.println("saveProjectRequest: " + saveProjectRequest);

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "프로젝트 저장 성공"
                        ,  updateProjectService.saveProject(projectId, saveProjectRequest)
                )
        );
    }

    @ApiOperation(value = "프로젝트 완료 (개발중)", notes = "최종 edit 정보를 저장하고 개발 완료 처리하는 api")
    @PatchMapping("/{id}/complete")
    ResponseEntity<ResponseDTO> completeProject(@PathVariable("id") Integer projectId, @RequestBody SaveProjectRequestDTO saveProjectRequest){
        System.out.println("[ProjectController] completeProject -- put");
        System.out.println("saveProjectRequest : " + saveProjectRequest);

        List<ValidationError> errors = projectRequestValidator.validate(saveProjectRequest);
        if (!errors.isEmpty()) {
            throw new ValidationErrorException(errors);
        }

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"최종 edit 정보 저장 & 개발 완료 처리 성공"
                        , ""
                )
        );
    }

    @PatchMapping("/{id}")
    ResponseEntity<ResponseDTO> modifyProjectName(@PathVariable("id") Integer projectId, @RequestParam("name") String newName){
        System.out.println("[ProjectController] modifyProjectName -- Patch");
        System.out.println("newName : " + newName);

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"프로젝트 이름 수정 성공"
                        , updateProjectService.modifyProjectName(projectId, newName)
                )
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseDTO> deleteProject(@PathVariable("id") Integer projectId){
        System.out.println("[ProjectController] deleteProject -- Delete");
        System.out.println("projectId : " + projectId);

        // 프로젝트 삭제 서비스
        deleteProjectService.deleteProject(projectId);

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        ,"프로젝트 삭제 성공"
                        , null
                )
        );
    }
}
