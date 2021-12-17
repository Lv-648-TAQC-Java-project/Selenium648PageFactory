package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.utils.TestValueProvider;


import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class ApiTestRunner {
    protected static TestValueProvider testValueProvider;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        testValueProvider = new TestValueProvider();
    }
}
