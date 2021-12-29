package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.club.add_club_request.AddClub;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;
import org.json.JSONObject;

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

    public Response addNewClub(AddClub addClub){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .body(addClub)
                .when()
                .post(clientUrl);
    }
    public Response addNewClub(JSONObject addClub){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .body(addClub.toString())
                .when()
                .post(clientUrl);
    }

    public Response deleteClub(Integer id){
        return preparedRequest()
                .header("Authorization", String.format("Bearer %s",token))
                .when()
                .delete(String.format("%s/%d",clientUrl,id));
    }

}
