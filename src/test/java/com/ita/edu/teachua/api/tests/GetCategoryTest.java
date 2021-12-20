package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.CategoryClient;
import com.ita.edu.teachua.api.models.category.CategoryModel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class GetCategoryTest extends AuthorizedApiTestRunner{

    @Test
    public void createCategory() throws IOException {
        Specifications.setResponseSpecification(200);
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response response = categoryClient.addNewCategory();
        CategoryModel categoryModel = response.then().log().all()
                .extract().as(CategoryModel.class);

        Response response1 = categoryClient.deleteNewCategory(categoryModel.getId());
        Assert.assertEquals(response1.getStatusCode(), 200);

    }

    @Test
    public void getListOfCategories() throws IOException {
        Specifications.setResponseSpecification(200);
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response get = categoryClient.getCategories();
        List<CategoryModel> categories = get.then().log().all()
                .extract().jsonPath().getList(".", CategoryModel.class);

        categories.forEach(x-> Assert.assertTrue(x.getUrlLogo().contains("/static/images/categories/")));
        Assert.assertTrue(categories.stream().allMatch(x-> x.getBackgroundColor().contains("#")));
        Assert.assertTrue(categories.stream().allMatch(x-> x.getTagBackgroundColor().contains("#")));
        Assert.assertTrue(categories.stream().allMatch(x-> x.getTagTextColor().contains("#")));
    }

    @Test
    public void deleteCategory() throws IOException {
        Specifications.setResponseSpecification(200);
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response delete = categoryClient.deleteNewCategory(19);
        CategoryModel categoryModel = delete.then().log().all()
                .extract().as(CategoryModel.class);
    }

    @Test
    public void getCategory() throws IOException {
        Specifications.setResponseSpecification(200);
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response get = categoryClient.getNewCategory(9);
        CategoryModel categoryModel = get.then().log().all()
                .extract().as(CategoryModel.class);

        Assert.assertEquals(categoryModel.getId(), 9);
        Assert.assertEquals(categoryModel.getSortby(), 40);

    }

    @Test
    public void changeCategory() throws IOException {
        Specifications.setResponseSpecification(200);
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response response = categoryClient.changeNewCategory(19);
        CategoryModel categoryModel = response.then().log().all()
                .extract().as(CategoryModel.class);
    }

}
