package com.ita.edu.teachua.api.clients.sigin;

import com.ita.edu.teachua.api.clients.BaseClient;
import com.ita.edu.teachua.api.models.user.User_Simple;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;


public class SignInClient extends BaseClient {

    private final String clientUrl;
    protected MainValueProvider mainValueProvider;

    public SignInClient() throws IOException {
        super();
        mainValueProvider = new MainValueProvider();
        this.clientUrl = mainValueProvider.getSignInClientUrl();
    }

    public Response successSignInRequest(User_Simple userSimple){
        return preparedRequest()
                .body(userSimple)
                .when()
                .post(clientUrl);
    }

}
