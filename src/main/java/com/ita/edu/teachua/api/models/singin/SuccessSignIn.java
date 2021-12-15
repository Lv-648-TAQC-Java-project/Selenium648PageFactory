package com.ita.edu.teachua.api.models.singin;

public class SuccessSignIn {
    private Integer id;
    private String email;
    private String accessToken;

    public SuccessSignIn() {
    }

    public SuccessSignIn(Integer id, String email, String accessToken) {
        this.id = id;
        this.email = email;
        this.accessToken = accessToken;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
