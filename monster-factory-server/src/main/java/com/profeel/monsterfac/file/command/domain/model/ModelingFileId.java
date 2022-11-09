package com.profeel.monsterfac.file.command.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * <pre>
 * Class : ModelingFileId
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
@Embeddable
public class ModelingFileId implements Serializable {
    @Id
    @Column(name = "modeling_file_id")
    private Integer modelingFileId;

    public ModelingFileId() {}
    public ModelingFileId(Integer modelingFileId) {
        this.modelingFileId = modelingFileId;
    }

    public Integer getModelingFileId() {
        return modelingFileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelingFileId that = (ModelingFileId) o;
        return Objects.equals(modelingFileId, that.modelingFileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelingFileId);
    }
}
