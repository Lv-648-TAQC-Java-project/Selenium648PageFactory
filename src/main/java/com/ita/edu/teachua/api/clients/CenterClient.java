package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.category.Category;
import com.ita.edu.teachua.api.models.center.center_request.Center;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;

import java.io.IOException;

public class CenterClient extends BaseClient{
    private final String clientUrl;
    private final String centerListUrl;
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
        this.centerListUrl=valueProvider.getCentersClientUrl();
        this.token = token;
    }

    public Response addNewCenter(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddCenter())
                .when()
                .post(clientUrl);
    }

    public Response deleteNewCenter(Integer id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .delete(String.format("%s/%d", clientUrl, id));
    }

    public Response getNewCenter(Integer id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .get(String.format("%s/%d", clientUrl, id));
    }

    public Response getCenters(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .get(centerListUrl);
    }

    public Response getCentersById(Integer id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .get(String.format("%s/%d", centerListUrl, id));
    }

    public Response changeCenter(Center center, Integer id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(center)
                .when()
                .put(String.format("%s/%d", clientUrl, id));
    }
}
