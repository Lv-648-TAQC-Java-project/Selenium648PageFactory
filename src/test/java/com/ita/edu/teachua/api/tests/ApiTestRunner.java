package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.authorization.Authorization;
import com.ita.edu.teachua.utils.ValueProvider;


import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class ApiTestRunner {
    protected static ValueProvider valueProvider;
    protected Authorization authorization;
    @BeforeSuite
    public void beforeSuite() throws IOException {
        valueProvider = new ValueProvider();
    }
}
