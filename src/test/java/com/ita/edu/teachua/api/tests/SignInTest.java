package com.ita.edu.teachua.api.tests;
import com.ita.edu.teachua.api.clients.sigin.SignInClient;
import com.ita.edu.teachua.api.models.user.User_Simple;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignInTest extends ApiTestRunner {

    @Test(description="TUA-406")
    public void successSignInTest() throws IOException {
        SignInClient signInClient = new SignInClient();
        String token = signInClient
                .successSignInRequest(new User_Simple("admin@gmail.com","admin"))
                .getAccessToken();
        Assert.assertNotNull(token);
    }
}
