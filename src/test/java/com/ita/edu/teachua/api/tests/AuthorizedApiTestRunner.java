package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.authorization.Authorization;
import com.ita.edu.teachua.api.clients.SignInClient;
import com.ita.edu.teachua.utils.ValueProvider;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class AuthorizedApiTestRunner {
    protected static ValueProvider valueProvider;
    protected Authorization authorization;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        valueProvider = new ValueProvider();
        authorization = new Authorization("TestTeach.ua@meta.ua","123456789");
    }
}
