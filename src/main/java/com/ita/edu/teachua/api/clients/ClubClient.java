package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.club.ClubRoot;
import com.ita.edu.teachua.api.models.club.add_club.AddClub;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.GsonParser;
import com.ita.edu.teachua.utils.ValueProvider;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class ClubClient extends BaseClient {
    private final String clientUrl;
    protected ValueProvider valueProvider;
    private String token;
    /*private AddClub addClub;
    private ClubRoot clubRoot;*/



    public ClubClient(String token) {
        super();
        try {
            valueProvider = new ValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.clientUrl = valueProvider.getClubClientUrl();
        this.token = token;

    }

    public Response addNewClub(){
        return preparedRequest()
                .header("Authorization","Bearer " + token)
                .body(new ClientDataTransfer().getAddClub())
                .when()
                .post(clientUrl);
                /*.then().log().all()
                .extract()
                .as(ClubRoot.class);*/
    }

}
