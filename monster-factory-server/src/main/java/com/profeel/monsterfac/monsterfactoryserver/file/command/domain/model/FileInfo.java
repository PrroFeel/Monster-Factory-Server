package com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model;

import javax.persistence.*;
import java.io.Serializable;

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
@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
public abstract class FileInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "file_id")
    private Integer id;

    @Column(name="original_filename")
    private String originalName;    // 원본 파일명

    @Column(name="filename_extension")
    private String extension;       // 확장자

    @Column(name="save_path")
    private String savePath;

    @Column(name="upload_datetime")
    private String uploadDatetime;  // 업로드 일시




    public FileInfo(String originalName, String extension, String savePath, String uploadDatetime) {
        this.originalName = originalName;
        this.extension = extension;
        this.savePath = savePath;
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

    public String getSavePath() {
        return savePath;
    }

    public String getUploadDatetime() {
        return uploadDatetime;
    }


    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", originalName='" + originalName + '\'' +
                ", extension='" + extension + '\'' +
                ", savePath='" + savePath + '\'' +
                ", uploadDatetime='" + uploadDatetime + '\'' +
                '}';
    }
}
