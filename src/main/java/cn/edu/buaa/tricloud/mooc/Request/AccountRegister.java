package cn.edu.buaa.tricloud.mooc.Request;

import cn.edu.buaa.tricloud.mooc.domain.Account;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by qixiang on 8/19/17.
 */
public class AccountRegister {

    @NotNull
    //@Size(min=6,max=20)
    private String login_name;

    @NotNull
    //@Size(min=2,max=4)
    private String username;

    @NotNull
    //@Size(min=6,max=20)
    private String password;

    @NotNull
    private String roles;

    @NotNull
    private Integer school;

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

    public Account build() {
        Account account = new Account();
        account.setLogin_name(getLogin_name());
        account.setPassword(getPassword());
        account.setRoles(getRoles());
        account.setSchool(getSchool());
        return account;
    }
}
