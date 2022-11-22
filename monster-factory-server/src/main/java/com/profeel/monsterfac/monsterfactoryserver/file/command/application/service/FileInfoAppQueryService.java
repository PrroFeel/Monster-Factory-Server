package com.profeel.monsterfac.monsterfactoryserver.file.command.application.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.application.exception.NotFoundFileInfoException;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.repository.FileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class : FileAppQueryService
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
public class FileInfoAppQueryService {

    private FileInfoRepository fileInfoRepository;

    @Autowired
    public FileInfoAppQueryService(
                                   FileInfoRepository fileInfoRepository){
        this.fileInfoRepository = fileInfoRepository;
    }

    public boolean isValidable(int fileId){
        boolean result = fileInfoRepository.existsById(fileId);
        if(!result){
            throw new NotFoundFileInfoException("해당 파일 정보를 찾을 수 없습니다");
        }
        return result;
    }


    public FileInfo getFileInfo(int fileId){
        isValidable(fileId);
        return fileInfoRepository.findById(fileId).get();
    }
}
