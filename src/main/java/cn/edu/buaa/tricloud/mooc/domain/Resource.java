package cn.edu.buaa.tricloud.mooc.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by qixiang on 8/20/17.
 */
@Entity(name = "Resource")
@DynamicUpdate
@DynamicInsert
public class Resource {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer cid;

    private String attachment;

    private Integer type;

    private Integer status;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Timestamp modify_time;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Timestamp create_time;

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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
