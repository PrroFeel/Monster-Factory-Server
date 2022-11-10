package com.profeel.monsterfac.monsterfactoryserver.object.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <pre>
 * Class : ObjectFileInfo
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-09       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Entity
@Table(name="tbl_object_file")
@DiscriminatorValue("object")
public class ObjectFileInfo extends FileInfo {
    protected ObjectFileInfo(){}
    public ObjectFileInfo(String originalName, String extension, String filePath, String uploadDatetime) {
        super(originalName, extension, filePath, uploadDatetime);
    }


    @Override
    public String toString() {
        return
                super.toString() +
                " ObjectFileInfo{" +
                '}';
    }
}