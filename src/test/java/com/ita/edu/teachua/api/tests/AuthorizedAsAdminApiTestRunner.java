package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class AuthorizedAsAdminApiTestRunner {
    protected static TestValueProvider testValueProvider;
    protected Authorization authorization;
    @BeforeSuite
    public void beforeSuite() throws IOException {
        testValueProvider = new TestValueProvider();
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
    }
}
