package com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service;

import com.profeel.monsterfac.monsterfactoryserver.common.service.DateService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ImageFileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ModelingFileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * <pre>
 * Class : FileService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-08       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Service
public class FileService {

    @Value("models")
    private String modelDir;
    @Value("images")
    private String imageDir;

    public String createSavePath(String dirName, String saveFileName){
        return String.format("%s/%s", dirName, saveFileName);
    }

    public ModelingFileInfo createModelingFileInfo(MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        // 확장자 추출하는 메소드
        String ext = extractExt(originalFilename);
        // 오리지널 파일 이름, 확장자, S3 파일 경로, 업로드 시간 저장
        return new ModelingFileInfo(
                originalFilename,
                ext,
                createSavePath(modelDir, createSaveFilename(originalFilename)),
                DateService.getCurrentDatetimeWithFormating()
        );
    }

    public ImageFileInfo createImageFileInfo(MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        String ext = extractExt(originalFilename);
        return new ImageFileInfo(
                originalFilename,
                ext,
                createSavePath(imageDir, createSaveFilename(ext)),
                DateService.getCurrentDatetimeWithFormating()
        );
    }

    // UUID로 파일명을 변경하는 메소드
    public String createSaveFilename(String ext){
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }


    // 파일 확장자 추출 메소드
    public String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos+1);
    }



}

