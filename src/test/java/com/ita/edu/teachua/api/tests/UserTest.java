package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.RegistrationClient;
import com.ita.edu.teachua.api.clients.UserClient;
import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.api.models.error.BaseErrorBody;
import com.ita.edu.teachua.api.models.registration.RegisterUser;
import com.ita.edu.teachua.api.models.registration.SuccessRegistration;
import com.ita.edu.teachua.api.models.user.SuccessUpdatedUser;
import com.ita.edu.teachua.api.models.user.UserInfo;
import com.ita.edu.teachua.utils.ClientDataTransfer;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class UserTest extends ApiTestRunner {

    @Test(invocationCount = 0)
    public void testSuiteForUserAPI() throws IOException {
        UserClient userClient = new UserClient();
        Response response = userClient.getUsers();
        response.then().log().all();
        JSONArray userInfos = new JSONArray(response.body().asString());

        //ArrayList<UserInfo> userInfos = new ArrayList<UserInfo>();
        Assert.assertNotNull(userInfos);
    }

    @Description("TUA-375 [API] Verify if registered user can see personal data")
    @Issue("TUA-375")
    @Test(description = "TUA-375")
    public void testUserDataIsAvailableToUser() throws IOException {
        final int expectedStatus = 200;
        Specifications.setResponseSpecification(expectedStatus);

        //register a user
        RegistrationClient regClient = new RegistrationClient();
        RegisterUser userData = (new ClientDataTransfer()).getRegisterUser();
        SuccessRegistration successRegistration = regClient.registerUser(userData).then().log().all()
                .extract().as(SuccessRegistration.class);
        int id = successRegistration.getId();

        //Activate account
        Authorization authAdmin = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        UserClient userClientAsAdmin = new UserClient(authAdmin.getToken());
        SuccessUpdatedUser updateUserActivation = (new ClientDataTransfer()).getUpdateUser();
        updateUserActivation.setId(id);
        userClientAsAdmin.putUserNewInfo(id, updateUserActivation).then().log().all();

        //Check if data is available
        Authorization authAsUser = new Authorization(userData.getEmail(), userData.getPassword());
        UserClient userClientAsUser = new UserClient(authAsUser.getToken());
        UserInfo userInfo = userClientAsUser.getUser(id).then().log().all()
                .extract().as(UserInfo.class);

        //Delete user
        userClientAsAdmin.deleteUser(id);

        Assert.assertNotNull(userInfo);

    }

    @Description("TUA-408 [API] User can edit profile with valid data")
    @Issue("TUA-408")
    @Test(description = "TUA-408")
    public void testUserCanEditProfile() throws IOException {
        final int expectedStatus = 200;
        final String newFirstName = "Andrii";
        final String newLastName = "Yaya";
        final String newPhone = "0999999999";
        Specifications.setResponseSpecification(expectedStatus);

        //register a user
        RegistrationClient regClient = new RegistrationClient();
        RegisterUser userData = (new ClientDataTransfer()).getRegisterUser();
        SuccessRegistration successRegistration = regClient.registerUser(userData).then().log().all()
                .extract().as(SuccessRegistration.class);
        int id = successRegistration.getId();

        //Activate account
        Authorization authAdmin = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        UserClient userClientAsAdmin = new UserClient(authAdmin.getToken());
        SuccessUpdatedUser updateUserActivation = (new ClientDataTransfer()).getUpdateUser();
        updateUserActivation.setId(id);
        userClientAsAdmin.putUserNewInfo(id, updateUserActivation).then().log().all();

        //Check if user can change data
        Authorization authAsUser = new Authorization(userData.getEmail(), userData.getPassword());
        UserClient userClientAsUser = new UserClient(authAsUser.getToken());

        SuccessUpdatedUser updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(id);
        updateUserData.setLastName(newLastName);
        updateUserData.setFirstName(newFirstName);
        updateUserData.setPhone(newPhone);
        userClientAsUser.putUserNewInfo(id, updateUserData).then().log().all();

        //Check if data is changed
        UserInfo userInfo = userClientAsUser.getUser(id).then().log().all()
                .extract().as(UserInfo.class);

        //Delete user
        userClientAsAdmin.deleteUser(id);

        Assert.assertEquals(userInfo.getLastName(), newLastName);
        Assert.assertEquals(userInfo.getFirstName(), newFirstName);
        Assert.assertEquals(userInfo.getPhone(), newPhone);

    }

    @Description("TUA-411 [API. Edit profile] Verify that user can not save changes where mandatory fields are empty")
    @Issue("TUA-411")
    @Test(description = "TUA-411")
    public void testUserCanNotEditProfileWithMissingField() throws IOException {
        BaseErrorBody error;
        final int expectedStatus = 400;
        final String newFirstName = "Andrii";
        final String newLastName = "Yaya";
        final String newPhone = "0999999999";
        Specifications.setResponseSpecification(200);
        SoftAssert softAssert = new SoftAssert();
        SuccessUpdatedUser updateUserData;

        //register a user
        RegistrationClient regClient = new RegistrationClient();
        RegisterUser userData = (new ClientDataTransfer()).getRegisterUser();
        SuccessRegistration successRegistration = regClient.registerUser(userData).then().log().all()
                .extract().as(SuccessRegistration.class);
        int id = successRegistration.getId();

        //Activate account
        Authorization authAdmin = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
        UserClient userClientAsAdmin = new UserClient(authAdmin.getToken());
        SuccessUpdatedUser updateUserActivation = (new ClientDataTransfer()).getUpdateUser();
        updateUserActivation.setId(id);
        userClientAsAdmin.putUserNewInfo(id, updateUserActivation).then().log().all();

        //Check if user can change data
        Authorization authAsUser = new Authorization(userData.getEmail(), userData.getPassword());
        UserClient userClientAsUser = new UserClient(authAsUser.getToken());

        Specifications.setResponseSpecification(expectedStatus);

        //No Last name
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(id);
        updateUserData.setLastName(null);
        updateUserData.setFirstName(newFirstName);
        updateUserData.setPhone(newPhone);
        error = userClientAsUser.putUserNewInfo(id, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "\"lastName\" can`t be null");

        //No First name
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(id);
        updateUserData.setLastName(newLastName);
        updateUserData.setFirstName(null);
        updateUserData.setPhone(newPhone);
        error = userClientAsUser.putUserNewInfo(id, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "\"firstName\" can`t be null");

        //No Phone
        updateUserData = (new ClientDataTransfer()).getUpdateUser();
        updateUserData.setId(id);
        updateUserData.setLastName(newLastName);
        updateUserData.setFirstName(newFirstName);
        updateUserData.setPhone(null);
        error = userClientAsUser.putUserNewInfo(id, updateUserData).then().log().all()
                .extract().as(BaseErrorBody.class);
        softAssert.assertEquals(error.getStatus().intValue(), expectedStatus);
        softAssert.assertEquals(error.getMessage(), "phone must not be blank");

        //Delete user
        Specifications.setResponseSpecification(200);
        userClientAsAdmin.deleteUser(id);

        softAssert.assertAll();
    }
}
