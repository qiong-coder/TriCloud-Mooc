package cn.edu.buaa.tricloud.mooc.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by qixiang on 8/19/17.
 */
@Entity(name = "Course")
@DynamicUpdate
@DynamicInsert
public class Course {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String identity;

    private String description;

    private String ppt;

    private String vides;

    private Integer status;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Timestamp modify_time;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Timestamp create_time;

    public void merge(Course course)
    {
        if ( course.getName() != null ) name = course.getName();
        if ( course.getPpt() != null ) ppt = course.getPpt();
        if ( course.getVides() != null ) vides = course.getVides();
        if ( course.getStatus() != null ) status = course.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPpt() {
        return ppt;
    }

    public void setPpt(String ppt) {
        this.ppt = ppt;
    }

    public String getVides() {
        return vides;
    }

    public void setVides(String vides) {
        this.vides = vides;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getModify_time() {
        return modify_time;
    }

    public void setModify_time(Timestamp modify_time) {
        this.modify_time = modify_time;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}
