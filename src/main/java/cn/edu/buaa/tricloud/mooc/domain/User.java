package cn.edu.buaa.tricloud.mooc.domain;


import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by stupid-coder on 8/15/17.
 */
@Entity(name = "User")
public class User {

    @Id
    @Generated(GenerationTime.INSERT)
    private Integer id;

    @NaturalId
    private String username;

    private String password;

    private Integer status;

    @Generated(GenerationTime.INSERT)
    private Timestamp create_time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}
