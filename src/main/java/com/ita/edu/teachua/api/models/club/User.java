package com.ita.edu.teachua.api.models.club;

public class User {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String urlLogo;
    private Role role;
    private String provider;
    private String providerId;
    private Boolean status;
    private String verificationCode;

    public User() {
    }

    public User(Integer id, String email, String password, String firstName, String lastName, String phone, String urlLogo, Role role, String provider, String providerId, Boolean status, String verificationCode) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.urlLogo = urlLogo;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.status = status;
        this.verificationCode = verificationCode;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public Role getRole() {
        return role;
    }

    public String getProvider() {
        return provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getVerificationCode() {
        return verificationCode;
    }
}
