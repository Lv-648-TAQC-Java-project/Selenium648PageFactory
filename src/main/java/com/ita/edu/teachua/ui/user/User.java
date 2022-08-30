package com.ita.edu.teachua.ui.user;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String password;
    private String UIPassword;
    private String phone;
    private Boolean status;
    private Integer role_id;

}