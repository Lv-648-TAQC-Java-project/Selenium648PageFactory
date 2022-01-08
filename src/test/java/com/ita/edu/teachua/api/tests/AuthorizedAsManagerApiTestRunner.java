package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class AuthorizedAsManagerApiTestRunner {
    protected static TestValueProvider testValueProvider;
    protected Authorization authorizationAsManager;

    @BeforeSuite
    public void BeforeSuite() throws IOException {
        testValueProvider = new TestValueProvider();
        authorizationAsManager = new Authorization(testValueProvider.getManagerEmail(), testValueProvider.getManagerPassword());
    }
}
