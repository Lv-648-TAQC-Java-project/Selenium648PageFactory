package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class AuthorizedApiTestRunner {
    protected static TestValueProvider testValueProvider;
    protected Authorization authorization;

    @BeforeClass
    public void beforeClass() throws IOException {
        testValueProvider = new TestValueProvider();
        authorization = new Authorization(testValueProvider.getTestTeachUaMetaEmail(), testValueProvider.getTestTeachUaMetaPassword());
    }
}
