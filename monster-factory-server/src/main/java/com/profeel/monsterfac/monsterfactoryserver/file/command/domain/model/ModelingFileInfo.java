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
@Table(name="tbl_modeling_files")
public class ModelingFileInfo extends FileInfo {
    protected ModelingFileInfo() {

    }
    public ModelingFileInfo(String originalName, String extension, String savePath, String uploadDatetime) {
        super(originalName, extension, savePath, uploadDatetime);
    }

    @Override
    public String toString() {
        return "ModelingFileInfo{" +
                '}' + super.toString();
    }
}
