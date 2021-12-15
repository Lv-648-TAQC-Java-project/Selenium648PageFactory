package com.ita.edu.teachua.api.models.club.add_club;

public class User {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Object urlLogo;
    private Object provider;
    private Object providerId;
    private Boolean status;
    private Object verificationCode;

    public User(Integer id, String email, String password, String firstName, String lastName, String phone, Object urlLogo, Object provider, Object providerId, Boolean status, Object verificationCode) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.urlLogo = urlLogo;
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

    public Object getUrlLogo() {
        return urlLogo;
    }

    public Object getProvider() {
        return provider;
    }

    public Object getProviderId() {
        return providerId;
    }

    public Boolean getStatus() {
        return status;
    }

    public Object getVerificationCode() {
        return verificationCode;
    }
}
