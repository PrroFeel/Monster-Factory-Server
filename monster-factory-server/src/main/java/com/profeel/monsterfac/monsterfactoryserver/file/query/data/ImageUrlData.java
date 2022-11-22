package com.profeel.monsterfac.monsterfactoryserver.file.query.data;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Class : ImageUrlData
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
@Entity
@Table(name="tbl_image_files")
public class ImageUrlData {

    @ApiModelProperty(example = "파일 고유 번호")
    @Id
    @Column(name = "file_id")
    private Integer id;

    @ApiModelProperty(example = "파일 url")
    @Column(name = "file_url")
    private String url;

    protected ImageUrlData(){}

    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ImageUrlData{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
