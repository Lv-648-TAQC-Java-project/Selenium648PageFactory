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
                .header("Authorization", String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddClub())
                .when()
                .post(clientUrl);
    }
    public Response addNewClubWithRussianName(){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddRusClub())
                .when()
                .post(clientUrl);
    }
    public void deleteClub(Integer id){
        preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .when()
                .delete(String.format("%s/%d",clientUrl,id));
    }

}
