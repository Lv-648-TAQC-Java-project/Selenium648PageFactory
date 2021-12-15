package com.ita.edu.teachua.api.tests;
import com.ita.edu.teachua.api.clients.SignInClient;
import com.ita.edu.teachua.api.models.user.User_Simple;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends ApiTestRunner {

    @Test(description="TUA-406")
    public void successSignInTest(){
        User_Simple userSimple = new User_Simple(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
        SignInClient signInClient = new SignInClient(valueProvider.getBaseApiUrl(), ContentType.JSON, valueProvider.getSignInClientUrl(),200);
        String token = signInClient
                .successSignInRequest(userSimple)
                .getAccessToken();

        Assert.assertNotNull(token);
    }
}
