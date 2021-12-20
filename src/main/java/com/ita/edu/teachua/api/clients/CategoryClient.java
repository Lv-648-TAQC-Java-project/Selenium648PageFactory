package com.ita.edu.teachua.api.clients;

import com.ita.edu.teachua.api.models.category.CategoryModel;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import com.ita.edu.teachua.utils.MainValueProvider;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.List;

public class CategoryClient extends BaseClient{

    private final String clientUrl;
    private final String categoryListUrl;
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
        this.categoryListUrl=valueProvider.getCategoriesClientUrl();
        this.token = token;
    }

    public Response addNewCategory(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddCategory())
                .when()
                .post(clientUrl);
    }

    public Response changeNewCategory(int id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .body(new ClientDataTransfer().getAddCategory())
                .when()
                .put(String.format("%s/%d", clientUrl, id));
    }

    public Response deleteNewCategory(int id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .delete(String.format("%s/%d", clientUrl, id));
    }

    public Response getNewCategory(int id){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .get(String.format("%s/%d", clientUrl, id));
    }

    public Response getCategories(){
        return preparedRequest()
                .header("Authorization",String.format("Bearer %s",token))
                .get(categoryListUrl);
    }

}
