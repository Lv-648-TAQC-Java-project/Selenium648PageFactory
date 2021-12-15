package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.singin.SuccessSignIn;
import com.ita.edu.teachua.api.models.user.User_Simple;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class SignInClient extends BaseClient {

    private final String clientUrl;
    private  SuccessSignIn successSignIn;

    public SignInClient(String baseApiUrl, ContentType contentType, String clientUrl, int status) {
        super(baseApiUrl, contentType, status);
        this.clientUrl = clientUrl;
    }

    public SuccessSignIn successSignInRequest(User_Simple userSimple){
        successSignIn = given()
                .body(userSimple)
                .when()
                .post(clientUrl)
                .then().log().all()
                .extract()
                .as(SuccessSignIn.class);
        return successSignIn;
    }

}
