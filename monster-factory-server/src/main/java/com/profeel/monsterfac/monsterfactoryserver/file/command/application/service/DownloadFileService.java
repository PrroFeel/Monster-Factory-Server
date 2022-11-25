package com.profeel.monsterfac.monsterfactoryserver.file.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.application.dto.FileDownloadResponseDTO;
import com.profeel.monsterfac.monsterfactoryserver.file.command.application.exception.AlreadyDeletedFileException;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * <pre>
 * Class : DownloadFileService
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
@Service
public class DownloadFileService {
    private S3Service s3Service;
    private FileInfoAppQueryService fileAppQueryService;

    @Autowired
    public DownloadFileService(S3Service s3Service,
                               FileInfoAppQueryService fileAppQueryService){
        this.s3Service = s3Service;
        this.fileAppQueryService = fileAppQueryService;
    }

    public FileDownloadResponseDTO downloadFileById(int fileId) throws IOException {
        FileInfo fileInfo = fileAppQueryService.getFileInfo(fileId);

        if(fileInfo.isDelete()){
            throw new AlreadyDeletedFileException("이미 제거된 파일은 다운로드 할 수 없습니다");
        }

        return new FileDownloadResponseDTO(
                s3Service.getFileObject(fileInfo.getSavePath()),
                fileInfo.getOriginalName()
        );
    }

}
