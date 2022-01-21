package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.utils.TestValueProvider;


import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class ApiTestRunner {
    protected static TestValueProvider testValueProvider;

    @BeforeClass
    public void beforeClass() throws IOException {
        testValueProvider = new TestValueProvider();
    }
}
