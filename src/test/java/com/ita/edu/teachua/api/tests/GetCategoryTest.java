package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.CategoryClient;
import com.ita.edu.teachua.api.models.category.Category;
import com.ita.edu.teachua.api.models.category.search_response.CategoryRoot2;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class GetCategoryTest extends AuthorizedApiTestRunner{

    @Test
    public void createCategory() throws IOException {
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response response = categoryClient.addNewCategory();
        Category category = response.then().log().all()
                .extract().as(Category.class);

        Assert.assertEquals(category.getDescription(), "ффффф ааааааа ооооооо");
        Assert.assertEquals(response.body().path("id"), category.getId());
        Assert.assertEquals(response.body().path("sortby"), category.getSortby());

        Response deleteResponse = categoryClient.deleteNewCategory(category.getId());
        Assert.assertEquals(deleteResponse.getStatusCode(), 200);
    }

    @Test
    public void getListOfCategories() throws IOException {
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response get = categoryClient.getCategories();
        List<Category> categories = get.then().log().all()
                .extract().jsonPath().getList(".", Category.class);

        categories.forEach(x-> Assert.assertTrue(x.getUrlLogo().contains("/static/images/categories/")));
        Assert.assertTrue(categories.stream().allMatch(x-> x.getBackgroundColor().contains("#")));
        Assert.assertTrue(categories.stream().allMatch(x-> x.getTagBackgroundColor().contains("#")));
        Assert.assertTrue(categories.stream().allMatch(x-> x.getTagTextColor().contains("#")));
    }

    @Test
    public void getListOfCategoriesSearch() throws IOException {
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response get = categoryClient.getCategoriesSearch();
        CategoryRoot2 categoryRoot2 = get.then().log().all()
                .extract().as(CategoryRoot2.class);

        Assert.assertEquals(categoryRoot2.getNumber(), 0);
        Assert.assertEquals(categoryRoot2.getTotalElements(), 13);
        Assert.assertEquals(categoryRoot2.getTotalPages(), 4);
    }

    @Test
    public void deleteCategory() throws IOException {
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response delete = categoryClient.deleteNewCategory(13);
        Category category = delete.then().log().all()
                .extract().as(Category.class);

        /*Response getResponse = categoryClient.getNewCategory(13);
        Category category2 = delete.then().log().all()
                .extract().as(Category.class);
        Assert.assertEquals(getResponse.getStatusCode(), 404);*/
    }

    @Test
    public void getCategory() throws IOException {
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Response get = categoryClient.getNewCategory(12);
        Category category = get.then().log().all()
                .extract().as(Category.class);

        Assert.assertEquals(get.body().path("id"), category.getId());
        Assert.assertEquals(get.body().path("sortby"), category.getSortby());

    }

    @Test
    public void changeCategory() throws IOException {
        CategoryClient categoryClient = new CategoryClient(authorization.getToken());
        Category category = new ClientDataTransfer().getAddCategory();
        category.setDescription("description aaa bbb");
        category.setName("Вчіться, діти");
        Response response = categoryClient.changeNewCategory(category, 12);
        Category categoryResponse = response.then().log().all()
                .extract().as(Category.class);

        Assert.assertEquals(categoryResponse.getDescription(), "description aaa bbb");
        Assert.assertEquals(categoryResponse.getName(), "Вчіться, діти");
    }

}
