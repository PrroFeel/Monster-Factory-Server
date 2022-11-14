package com.profeel.monsterfac.monsterfactoryserver.game.query.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * Class : ImageFileUrl
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-14       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
@Entity
@Table(name="tbl_image_files")
public class ImageFile {

    @Id
    @Column(name = "file_id")
    private Integer id;

    @Column(name = "file_url")
    private String url;

    protected ImageFile(){}

    public ImageFile(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}