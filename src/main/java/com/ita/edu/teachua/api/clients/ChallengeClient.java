package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.restassured.response.Response;

import java.io.IOException;

public class ChallengeClient extends BaseClient{
    private final String clientUrl;
    private final String token;
    public ChallengeClient(String token) throws IOException {
        super();
        this.clientUrl=mainValueProvider.getChallengeUrl();
        this.token=token;
    }
    public Response addChallenge(){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddChallenge())
                .when()
                .post(clientUrl);
    }
}
