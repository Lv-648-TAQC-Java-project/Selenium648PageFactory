package com.ita.edu.teachua.api.clients.sigin;

import com.ita.edu.teachua.api.clients.BaseClient;
import com.ita.edu.teachua.api.models.singin.SuccessSignIn;
import com.ita.edu.teachua.api.models.user.User_Simple;
import com.ita.edu.teachua.utils.MainValueProvider;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class SignInClient extends BaseClient {

    private final String clientUrl;
    private  SuccessSignIn successSignIn;
    protected MainValueProvider mainValueProvider;

    public SignInClient() throws IOException {
        super();
        mainValueProvider = new MainValueProvider();
        this.clientUrl = mainValueProvider.getSignInClientUrl();
    }

    public SuccessSignIn successSignInRequest(User_Simple userSimple){
        successSignIn = preparedRequest()
                .body(userSimple)
                .when()
                .post(clientUrl)
                .then().log().all()
                .extract()
                .as(SuccessSignIn.class);
        return successSignIn;
    }

}
