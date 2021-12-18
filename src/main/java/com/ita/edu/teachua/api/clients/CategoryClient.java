package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;
import java.io.IOException;

public class CategoryClient extends BaseClient{

    private final String clientUrl;
    protected MainValueProvider valueProvider;
    private String token;

    public CategoryClient(String token) throws IOException {
        super();
        try {
            valueProvider = new MainValueProvider();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.clientUrl = valueProvider.getCategoryClientUrl();
        this.token = token;
    }

    public Response addNewCategory(){
        return preparedRequest()
                .header("Authorization","Bearer " + token)
                .body(new ClientDataTransfer().getAddCategory())
                .when()
                .post(clientUrl);
    }

    public Response deleteNewCategory(int id){
        return preparedRequest()
                .header("Authorization","Bearer " + token)
                .delete(clientUrl + "/" + id);
    }

    public Response getNewCategory(int id){
        return preparedRequest()
                .header("Authorization","Bearer " + token)
                .get(clientUrl + "/" + id);
    }
}
