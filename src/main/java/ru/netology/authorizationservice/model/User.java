package ru.netology.authorizationservice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
    @Size(min = 3, max = 20)
    @NotBlank
    private String user;

    @Size(min = 2, max = 30)
    @NotBlank
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}