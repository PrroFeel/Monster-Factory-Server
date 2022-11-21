package com.profeel.monsterfac.monsterfactoryserver.file.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.application.exception.AlreadyDeletedFileException;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Class : DeleteFileService
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
public class DeleteFileService {
    private S3Service s3Service;
    private FileInfoAppQueryService fileAppQueryService;


    @Autowired
    public DeleteFileService(S3Service s3Service,
                             FileInfoAppQueryService fileAppQueryService){
        this.s3Service = s3Service;
        this.fileAppQueryService = fileAppQueryService;
    }


    @Transactional
    public void deleteFile(int fileId) {
        FileInfo fileInfo = fileAppQueryService.getFileInfo(fileId);
        if(fileInfo.isDelete()){
            throw new AlreadyDeletedFileException("이미 삭제된 파일 입니다");
        }
        s3Service.deleteFileObject(fileInfo.getSavePath());
        fileInfo.deleteObject();
    }
}
