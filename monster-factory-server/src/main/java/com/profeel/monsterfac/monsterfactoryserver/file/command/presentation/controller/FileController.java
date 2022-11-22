package com.profeel.monsterfac.monsterfactoryserver.file.command.presentation.controller;

import com.profeel.monsterfac.monsterfactoryserver.common.dto.ResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.file.command.application.dto.FileDownloadResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.file.command.application.service.DeleteFileService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.application.service.DownloadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * <pre>
 * Class : FileController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-21       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Controller
@RequestMapping("/files")
public class FileController {

    private DownloadFileService downloadFileService;
    private DeleteFileService deleteFileService;
    @Autowired
    public FileController(DownloadFileService downloadFileService,
                          DeleteFileService deleteFileService){
        this.downloadFileService = downloadFileService;
        this.deleteFileService = deleteFileService;
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("id") int fileId) throws IOException {
        System.out.println("[FileController] downloadFile -- GET");

        FileDownloadResponseDTO fileDownloadResponse = downloadFileService.downloadFileById(fileId);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentLength(fileDownloadResponse.getFileData().length);
        String fileName = URLEncoder.encode(fileDownloadResponse.getOriginalFileName(), "UTF-8");
        httpHeaders.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<>(fileDownloadResponse.getFileData(), httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/file-del")
    public ResponseEntity<ResponseDTO> deleteFile(@PathVariable("id") int fileId){
        System.out.println("[FileController] deleteFileInfoAndS3Object -- DELETE");

        deleteFileService.deleteFile(fileId);

        return ResponseEntity.ok().body(
                new ResponseDTO(
                        HttpStatus.OK.value()
                        , "S3 파일 객체 제거 성공"
                        ,""
                )
        );
    }

}
