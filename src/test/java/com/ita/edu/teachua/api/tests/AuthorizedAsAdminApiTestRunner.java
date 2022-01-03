package com.ita.edu.teachua.api.tests;

import com.ita.edu.teachua.api.clients.sigin.Authorization;
import com.ita.edu.teachua.utils.TestValueProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;

public class AuthorizedAsAdminApiTestRunner {
    protected static TestValueProvider testValueProvider;
    protected Authorization authorization;
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        testValueProvider = new TestValueProvider();
        authorization = new Authorization(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword());
//        WebDriverManager.chromedriver().setup();
    }

//    @BeforeMethod
//    public void beforeMethod(ITestContext context) {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get(testValueProvider.getBaseUrl());
//        context.setAttribute("driver", driver);
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
