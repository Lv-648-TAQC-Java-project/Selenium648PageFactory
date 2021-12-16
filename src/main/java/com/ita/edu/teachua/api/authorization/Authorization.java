package com.ita.edu.teachua.api.authorization;

import com.ita.edu.teachua.api.clients.SignInClient;
import com.ita.edu.teachua.api.models.user.User_Simple;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Authorization {
    User_Simple userSimple;
    SignInClient signInClient;
    String token;
    RequestSpecification request;

    public Authorization(String email, String password) {
        this.userSimple = new User_Simple(email, password);
        this.signInClient = new SignInClient();
        this.token = signInClient
                .successSignInRequest()
                .getAccessToken();
    }

    public String getToken(){
        /*this.request = RestAssured.given();
        return request.header("Authorization","Bearer " + token);*/
        return token;
    }

}
