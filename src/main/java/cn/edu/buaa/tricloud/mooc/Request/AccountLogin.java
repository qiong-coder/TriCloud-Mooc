package cn.edu.buaa.tricloud.mooc.Request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by qixiang on 8/19/17.
 */
public class AccountLogin {

    @NotNull
    @Size(min=6,max=20)
    private String loginame;

    @NotNull
    @Size(min=6,max=20)
    private String password;

    public String getLoginame() {
        return loginame;
    }

    public void setLoginame(String loginame) {
        this.loginame = loginame;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
