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
@Table(name="tbl_image_files")
public class ImageFileInfo extends FileInfo {

    @Column(name="file_url")
    private String url;

    protected ImageFileInfo() {

    }

    public ImageFileInfo(FileInfo fileInfo, String url) {
        this(fileInfo.getOriginalName(), fileInfo.getExtension(), fileInfo.getSavePath(), fileInfo.getUploadDatetime());
        this.url = url;
    }
    public ImageFileInfo(String originalName, String extension, String filePath, String uploadDatetime) {
        super(originalName, extension, filePath, uploadDatetime);
    }


    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ImageFileInfo{" +
                ", url='" + url + '\'' +
                '}' + super.toString();
    }
}
