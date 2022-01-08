package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.RoleClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.roles.RoleModel;
import com.ita.edu.teachua.api.models.roles.RolesData;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class RolesTest extends AuthorizedAsAdminApiTestRunner{

    @Test(description = "API from swagger")
    @Description("[API] Get list of all roles")
    public void getListOfRolesTest() throws IOException {
        RoleClient roleClient = new RoleClient(authorization.getToken());
        Response response = roleClient.getListOfRoles();
        List<RolesData> rolesDataList = response
                .then().log().all()
                .extract().body().jsonPath().getList(".", RolesData.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(rolesDataList.size(), 3);
    }
    @Test(description = "API from swagger")
    @Description("[API] Get role by ID")
    public void getRoleByIDTest() throws IOException {
        RoleClient roleClient = new RoleClient(authorization.getToken());
        Response response = roleClient.getRoleById(3);
        RoleModel roleModel = response
                .then().log().all()
                .extract().as(RoleModel.class);
        Assert.assertEquals(roleModel.getRoleName(), "ROLE_MANAGER");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(description = "API from swagger")
    @Description("[API] Create new role")
    public void createNewRole() throws IOException {
        RoleClient roleClient = new RoleClient(authorization.getToken());
        Response response = roleClient.addNewRole();
        RoleModel roleModel = response
                .then().log().all()
                .extract().as((Type) RolesData.class);
        Assert.assertEquals(roleModel.getRoleName(), "TEST_ROLE");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(description = "API from swagger")
    @Description("[API] Create new role")
    public void deleteRole() throws IOException {
        RoleClient roleClient = new RoleClient(authorization.getToken());
        Response response = roleClient.deleteRole(39);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}