package com.ita.edu.teachua.ui.tests.testrunners;

import com.ita.edu.teachua.utils.TestValueProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;

public class BaseTestRunner {

    protected static WebDriver driver;
    protected static TestValueProvider valueProvider;

    @BeforeSuite
    public void beforeSuite() throws IOException {

        if (valueProvider == null) {
            valueProvider = new TestValueProvider();
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(valueProvider.getBaseUrl());
    }

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        context.setAttribute("myDriver", driver);
        driver.get(valueProvider.getBaseUrl());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }
}
