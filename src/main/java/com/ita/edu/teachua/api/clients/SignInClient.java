package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.singin.SuccessSignIn;
import com.ita.edu.teachua.api.models.user.User_Simple;
import com.ita.edu.teachua.utils.ValueProvider;
import io.restassured.http.ContentType;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class SignInClient extends BaseClient {

    private final String clientUrl;
    private  SuccessSignIn successSignIn;
    protected ValueProvider valueProvider;

    public SignInClient()  {
        super();
        try {
            valueProvider = new ValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.clientUrl = valueProvider.getSignInClientUrl();
    }

    public SuccessSignIn successSignInRequest(){
        User_Simple userSimple = new User_Simple(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
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
