package cn.edu.buaa.tricloud.mooc.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by stupid-coder on 8/15/17.
 */
public class User {

    @NotNull
    @Size(min=8, max=30)
    private String username;

    @NotNull
    @Size(min=8, max=30)
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
}
