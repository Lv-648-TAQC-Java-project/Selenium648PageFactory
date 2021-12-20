package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class CenterClient extends BaseClient{
    private final String clientUrl;
    protected MainValueProvider valueProvider;
    private String token;

    public CenterClient(String token) throws IOException {
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.clientUrl = valueProvider.getCenterClientUrl();
        this.token = token;
    }

    public Response addNewCenter(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddCenter())
                .when()
                .post(clientUrl);
    }

    public Response deleteNewCenter(int id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .delete(String.format("%s/%d", clientUrl, id));
    }

    public Response getNewCenter(int id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .delete(String.format("%s/%d", clientUrl, id));
    }
}
