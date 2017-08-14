package cn.edu.buaa.tricloud.mooc.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by stupid-coder on 8/15/17.
 */
public class User {

    @NotNull
    @Size(min=5, max=16)
    private String firstName;

    @NotNull
    @Size(min=5, max=16)
    private String lastName;

    @NotNull
    @Size(min=6, max=30)
    private String username;

    @NotNull
    @Size(min=2, max=30)
    private String password;

    public User() {
        this.firstName = "defaultName";
        this.lastName = "Your's lastName";
        this.username = "Your login user name";
        this.password = "password must be at least 2";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
