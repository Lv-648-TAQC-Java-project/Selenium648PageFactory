package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.CenterClient;
import com.ita.edu.teachua.api.models.center.center_response.CenterRoot;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class AddCenterTest extends AuthorizedApiTestRunner{

    @Test(description = "TUA-261")
    public void createCenter() throws IOException {
        Specifications.setResponseSpecification(200);
        CenterClient centerClient = new CenterClient(authorization.getToken());
        Response response = centerClient.addNewCenter();
        CenterRoot centerRoot = response.then().log().all()
                .extract().as(CenterRoot.class);

        Assert.assertEquals(centerRoot.getUserId(), 1);
        Assert.assertEquals(centerRoot.getName(), "API testing4 ");

        Response response1 = centerClient.deleteNewCenter(centerRoot.getId());
        Assert.assertEquals(response1.getStatusCode(), 200);
    }
}
