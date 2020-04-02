package com.hph.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 注册的用户
 * @author hph
 */
public class Spitter {

    @NotNull
    @Size(min = 5, max = 16, message = "sb sb sb sb")
    private String firstName;

    @NotNull
    @Size(min = 5, max = 16, message = "{lastName.size}")
    private String lastName;

    @NotNull
    @Size(min = 5, max = 16, message = "{email.size}")
    private String email;

    @NotNull
    @Size(min = 5, max = 16, message = "{username.size}")
    private String username;

    @NotNull
    @Size(min = 5, max = 16, message = "{password.size}")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
