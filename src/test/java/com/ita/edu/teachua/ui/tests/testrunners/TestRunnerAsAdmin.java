package com.ita.edu.teachua.ui.tests.testrunners;

import com.ita.edu.teachua.ui.pages.header_page.AllHeaderComponents;
import com.ita.edu.teachua.ui.pages.header_page.HeaderPage;
import org.testng.annotations.*;
import java.io.IOException;

public class TestRunnerAsAdmin extends BaseTestRunner {

    @BeforeClass
    public void beforeClass() {
        new HeaderPage(driver)
                .clickOnGuestDropdown()
                .clickOnLoginButton();

        new AllHeaderComponents(driver)
                .getLoginPopUpComponent()
                .sendKeysEmailField(valueProvider.getAdminEmail())
                .sendKeysPasswordField(valueProvider.getAdminPassword())
                .clickLoginSubmitButton();
    }

    @AfterClass
    public void afterClass() throws IOException {
        if (driver != null) {
            driver.quit();
        }
    }
}
