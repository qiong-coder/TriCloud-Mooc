package cn.edu.buaa.tricloud.mooc.Response;

import cn.edu.buaa.tricloud.mooc.domain.Account;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by qixiang on 8/20/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {

    private String login_name;
    private String username;
    private String roles;
    private Integer school;

    public static AccountResponse build(Account account)
    {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setLogin_name(account.getLogin_name());
        accountResponse.setUsername(account.getUsername());
        accountResponse.setRoles(account.getRoles());
        accountResponse.setSchool(account.getSchool());
        return accountResponse;
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
}
