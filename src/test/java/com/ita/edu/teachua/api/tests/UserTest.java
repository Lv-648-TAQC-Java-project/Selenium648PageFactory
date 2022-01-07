package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.UserClient;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserTest extends ApiTestRunner {

    @Test
    public void testSuiteForUserAPI() throws IOException {
        UserClient userClient = new UserClient();
        Response response = userClient.getUsers();
        response.then().log().all();
        JSONArray userInfos = new JSONArray(response.body().asString());

        //ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();
        Assert.assertNotNull(userInfos);
    }
}
