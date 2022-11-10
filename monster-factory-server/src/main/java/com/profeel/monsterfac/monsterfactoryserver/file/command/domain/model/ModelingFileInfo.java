package com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model;

import javax.persistence.*;

/**
 * <pre>
 * Class : ModelingFile
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
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@Table(name="tbl_modeing_files")
public class ModelingFileInfo extends FileInfo {

    protected ModelingFileInfo() {

    }
    public ModelingFileInfo(String originalName, String extension, String filePath, String uploadDatetime) {
        super(originalName, extension, filePath, uploadDatetime);
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + super.getId() +
                ", originalName='" + super.getOriginalName() + '\'' +
                ", extension='" + super.getExtension() + '\'' +
                ", filePath='" + super.getFilePath() + '\'' +
                ", uploadDatetime='" + super.getUploadDatetime() + '\'' +
                '}';
    }
}
