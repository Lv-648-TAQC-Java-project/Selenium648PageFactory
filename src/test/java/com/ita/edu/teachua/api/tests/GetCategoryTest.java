package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.CategoryClient;
import com.ita.edu.teachua.api.models.category.CategoryModel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;

public class GetCategoryTest extends AuthorizedApiTestRunner{

    @Test
    public void createCategory() throws IOException {
        Specifications.setResponseSpecification(200);
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response response = categoryClient.addNewCategory();

        CategoryModel categoryModel = response.then().log().all()
                .extract().as(CategoryModel.class);

        System.out.println(categoryModel.getId());

        //Response delete = categoryClient.deleteNewCategory(18);
    }

    @Test
    public void deleteCategory() throws IOException {
        Specifications.setResponseSpecification(200);
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response delete = categoryClient.deleteNewCategory(17);
        CategoryModel categoryModel = delete.then().log().all()
                .extract().as(CategoryModel.class);
    }

    @Test
    public void getCategory() throws IOException {
        Specifications.setResponseSpecification(404);
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response delete = categoryClient.getNewCategory(17);
    }

}
