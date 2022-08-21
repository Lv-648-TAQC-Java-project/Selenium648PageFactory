package com.ita.edu.teachua.utils.jdbc.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserEntity {

    public static final String SELECT_ALL = "SELECT * FROM users";

    private String email;
    private String first_name;
    private Long id;
    private String last_name;
    private String password;
    private String phone;
    private String provider;
    private String provider_id;
    private Integer role_id;
    private Boolean status;
    private String url_logo;
    private String verification_code;

    public UserEntity(){
        this.id = null;
        this.email = null;
        this.first_name = null;
        this.last_name = null;
        this.password = null;
        this.phone = null;
        this.provider = null;
        this.provider_id = null;
        this.status = null;
        this.url_logo = null;
        this.verification_code = null;
        this.role_id = null;
    }

    public static UserEntity getUser (List<String> row){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Long.parseLong(row.get(0)));
        userEntity.setEmail(row.get(1));
        userEntity.setFirst_name(row.get(2));
        userEntity.setLast_name(row.get(3));
        userEntity.setPassword(row.get(4));
        userEntity.setPhone(row.get(5));
        userEntity.setProvider(row.get(6));
        userEntity.setProvider_id(row.get(7));
        userEntity.setStatus(Boolean.parseBoolean(row.get(8)));
        userEntity.setUrl_logo(row.get(9));
        userEntity.setVerification_code(row.get(10));
        if (row.get(11) != null) {
            userEntity.setRole_id(Integer.parseInt(row.get(11)));
        }
       return userEntity;
    }

    public static List<UserEntity> getUsers(List<List<String>> rows){
        List<UserEntity> users = new ArrayList<>();
        for (List<String> row : rows){
            users.add(getUser(row));
        }
        return users;
    }

}
