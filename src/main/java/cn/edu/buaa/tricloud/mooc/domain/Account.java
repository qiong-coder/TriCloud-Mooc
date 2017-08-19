package cn.edu.buaa.tricloud.mooc.domain;

import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * Created by stupid-coder on 8/15/17.
 */
@Entity(name = "Account")
@DynamicUpdate
@DynamicInsert
public class Account {

    @Id
    @GeneratedValue
    private Integer id;

    @NaturalId
    @Column(unique = true)
    private String login_name;

    private String username;

    private String password;

    private String roles;

    private Integer school;

    private Integer status;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Timestamp create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
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
