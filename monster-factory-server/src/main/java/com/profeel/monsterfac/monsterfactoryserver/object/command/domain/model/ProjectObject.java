package com.profeel.monsterfac.monsterfactoryserver.object.command.domain.model;

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
 */
@Entity
@Table(name="tbl_objects")
public class ProjectObject {

    @Id
    @Column(name="object_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="object_file_id", unique = true)
    private ObjectFileInfo objectFileInfo;


    @Column(name = "object_transform")
    private String transform;

    @Embedded
    Project project;

    protected ProjectObject() {
    }
    public ProjectObject(ObjectFileInfo objectFileInfo, String transform, Project project) {
        this.objectFileInfo = objectFileInfo;
        this.transform = transform;
        this.project = project;
    }


    public Integer getId() {
        return id;
    }

    public ObjectFileInfo getObjectFileInfo() {
        return objectFileInfo;
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
                ", objectFileInfo=" + objectFileInfo +
                ", transform=" + transform +
                ", project=" + project +
                '}';
    }
}