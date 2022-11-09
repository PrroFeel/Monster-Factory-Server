package com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model;

import javax.persistence.*;

/**
 * <pre>
 * Class : File
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-07       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Entity
@Table(name="tbl_file")
@Inheritance(strategy =  InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
public class FileInfo {

    @Id
    @Column(name="file_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 dbms에 자동 위임
    private Integer id;

    @Column(name="original_filename")
    private String originalName;    // 원본 파일명

    @Column(name="filename_extension")
    private String extension;       // 확장자

    @Column(name="file_path")
    private String filePath;

    @Column(name="upload_datetime")
    private String uploadDatetime;  // 업로드 일시

    public FileInfo(String originalName, String extension, String filePath, String uploadDatetime) {
        this.originalName = originalName;
        this.extension = extension;
        this.filePath = filePath;
        this.uploadDatetime = uploadDatetime;
    }

    public FileInfo() {
    }

    public Integer getId() {
        return id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getExtension() {
        return extension;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getUploadDatetime() {
        return uploadDatetime;
    }


}
