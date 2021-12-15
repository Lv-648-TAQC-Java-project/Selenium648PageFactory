package com.ita.edu.teachua.api.models.user;

public class User_Simple {
    private String email;
    private String password;

    public User_Simple(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
