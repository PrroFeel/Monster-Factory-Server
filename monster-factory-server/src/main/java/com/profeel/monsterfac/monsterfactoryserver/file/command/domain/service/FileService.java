package com.profeel.monsterfac.monsterfactoryserver.file.command.domain.service;

import com.profeel.monsterfac.monsterfactoryserver.common.service.DateService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ImageFileInfo;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ModelingFileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
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

    // 현재 프로파일 ( local / development )
    @Value("${spring.environment}")
    private String environment;

    // 파일 임시 저장 경로
    @Value("${spring.file-dir}")
    private String fileDir;
    private String filePath;

    @PostConstruct
    private void init(){
        // 현재 프로파일에 맞게 임시 파일 경로 설정
        if(environment.equals("local")){
            String fileFolder = System.getProperty("user.dir") + this.fileDir;
            mkdirResource(fileFolder);
            this.filePath = fileFolder;
        } else if(environment.equals("development")){
            String fileFolder =  "/var/www/html/files";
            mkdirResource(fileFolder);
            this.filePath = this.fileDir;
        }
    }
    public String createSavePath(String dirName, String saveFileName){
        return String.format("%s/%s", dirName, saveFileName);
    }

    public ModelingFileInfo createModelingFileInfo(MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        String ext = extractExt(originalFilename);
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

//    public FileInfo createFileInfo(MultipartFile multipartFile, String dirName){
//        String originalFilename = multipartFile.getOriginalFilename();
//        String ext = extractExt(originalFilename);
//        return new ModelingFileInfo(
//                originalFilename,
//                ext,
//                createFilePath(dirName, createSaveFilename(ext)),
//                DateService.getCurrentDatetimeWithFormating()
//        );
//    }

    private static void mkdirResource(String fileDir){
        File Folder = new File(fileDir);

        if(!Folder.exists()) {
            Folder.mkdir(); // 폴더 생성
        }
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

    public File convertToFile(MultipartFile multipartFile) throws IOException {
        return convert(multipartFile)
                .orElseThrow(()-> new IllegalArgumentException("error: MultipartFile -> File convert fail"));
    }
    // Multipart 파일을 임시 저장 경로의 File 객채로 변환 메소드
    private Optional<File> convert(MultipartFile multipartFile) throws IOException {
        if(multipartFile.isEmpty()){
            return Optional.empty();
        }

        String ext = extractExt(multipartFile.getOriginalFilename());
        String changedFilename = createSaveFilename(ext);

        File file = new File(filePath+changedFilename);
        multipartFile.transferTo(file);

        return Optional.of(file);
    }



}

