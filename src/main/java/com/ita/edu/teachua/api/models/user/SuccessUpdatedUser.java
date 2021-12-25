package com.ita.edu.teachua.api.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuccessUpdatedUser {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String urlLogo;
    private String status;
    private String role;
}
