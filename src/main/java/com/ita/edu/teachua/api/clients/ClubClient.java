package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class ClubClient extends BaseClient {
    private final String clientUrl;
    protected MainValueProvider mainValueProvider;
    private String token;

    public ClubClient(String token) throws IOException {
        super();
        mainValueProvider = new MainValueProvider();
        this.clientUrl = mainValueProvider.getClubClientUrl();
        this.token = token;

    }

    public Response addNewClub(){
        return preparedRequest()
                .header("Authorization","Bearer " + token)
                .body(new ClientDataTransfer().getAddClub())
                .when()
                .post(clientUrl);
    }

}
