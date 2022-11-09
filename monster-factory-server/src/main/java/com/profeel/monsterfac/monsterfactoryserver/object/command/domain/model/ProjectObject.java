package com.profeel.monsterfac.monsterfactoryserver.object.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ModelingFileId;

import javax.persistence.*;

/**
 * <pre>
 * Class : ProjectObject
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
 * @see 참고할 class 또는 외부 url
 */
@Entity
@Table(name="tbl_objects")
public class ProjectObject {

    @Id
    @Column(name="object_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="modeling_file_id")
    private ModelingFileId modelingFileId;


    @Column(name = "object_transform")
    private String transform;

    @Embedded
    Project project;

    protected ProjectObject() {
    }
    public ProjectObject(ModelingFileId modelingFileId, String transform, Project project) {
        this.modelingFileId = modelingFileId;
        this.transform = transform;
        this.project = project;
    }

    public ProjectObject(Integer id, ModelingFileId modelingFileId, String transform, Project project) {
        this(modelingFileId, transform, project);
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public ModelingFileId getModelingFileId() {
        return modelingFileId;
    }

    public String getTransform() {
        return transform;
    }

    public Project getProject() {
        return project;
    }

    @Override
    public String toString() {
        return "ProjectObject{" +
                "id=" + id +
                ", modelingFileId=" + modelingFileId +
                ", transform=" + transform +
                ", project=" + project +
                '}';
    }
}