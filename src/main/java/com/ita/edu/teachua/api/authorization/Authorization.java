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

    public Authorization(SignInClient signInClient,String email, String password) {
        this.signInClient = signInClient;
        this.userSimple = new User_Simple(email, password);
        this.token = signInClient
                .successSignInRequest(userSimple)
                .getAccessToken();
        //RestAssured.baseURI="https://speak-ukrainian.org.ua/dev/api";
        this.request = RestAssured.given();
    }
    public RequestSpecification prepareAuthorizedRequest(){

        return request.header("Authorization","Bearer " + token);
    }

}
