package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.CategoryClient;
import com.ita.edu.teachua.api.clients.CenterClient;
import com.ita.edu.teachua.api.models.category.Category;
import com.ita.edu.teachua.api.models.center.center_request.Center;
import com.ita.edu.teachua.api.models.center.change_response.Root;
import com.ita.edu.teachua.api.models.center.pageable_response.Root2;
import com.ita.edu.teachua.api.models.center.resprose_swagger.CenterRoot2;
import com.ita.edu.teachua.api.models.center.resprose_swagger.Location;
import com.ita.edu.teachua.api.models.center.total.Club;
import com.ita.edu.teachua.api.models.center.total.Content;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class CenterTests extends AuthorizedApiTestRunner {

    /*@Test //response swagger
    public void getCenter() throws IOException {
        Specifications.setResponseSpecification(200);
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response response = centerClient.getNewCenter(265);
        CenterRoot2 centerRoot2 = response.then().log().all()
                .extract().as(CenterRoot2.class);

        Assert.assertEquals(response.body().path("name"), centerRoot2.getName());
        Assert.assertEquals(response.body().path("description"), centerRoot2.getDescription());
    }*/

    @Test //response swagger
    public void getCenter2() throws IOException {
        Specifications.setResponseSpecification(200);
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response response = centerClient.getNewCenter(267);
        Content centerRoot2 = response.then().log().all()
                .extract().as(Content.class);

        Assert.assertEquals(response.body().path("name"), centerRoot2.getName());
        Assert.assertEquals(response.body().path("description"), centerRoot2.getDescription());
    }

    @Test //response swagger
    public void deleteCenter() throws IOException {
        Specifications.setResponseSpecification(200);
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response response = centerClient.deleteNewCenter(265);
        CenterRoot2 centerRoot2 = response.then().log().all()
                .extract().as(CenterRoot2.class);

    }

    @Test //change response
    public void changeCenter() throws IOException {
        Specifications.setResponseSpecification(200);
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Center center = new ClientDataTransfer().getAddCenter();
        center.setName("Java13");
        Response response = centerClient.changeCenter(center, 266);
        Root root = response.then().log().all()
                .extract().as(Root.class);

        Assert.assertEquals(root.getName(), "Java13");
        Assert.assertEquals(root.getDescription(), "somethingsomethingsomethingsomethingsomethingsomething");
    }

    @Test //response swagger
    public void getListOfCenters() throws IOException {
        Specifications.setResponseSpecification(200);
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response get = centerClient.getCenters();
        List<CenterRoot2> centers = get.then().log().all()
                .extract().jsonPath().getList(".", CenterRoot2.class);

        centers.forEach(x-> Assert.assertNull(x.getUrlBackgroundPicture()));
        centers.forEach(x-> Assert.assertNull(x.getEmail()));
    }

    @Test //pageable swagger
    public void getListOfCentersById() throws IOException {
        Specifications.setResponseSpecification(200);
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response get = centerClient.getCentersById(29);
        Root2 centers = get.then().log().all()
                .extract().as(Root2.class);

        Assert.assertEquals(centers.getSize(), 9);
    }
}