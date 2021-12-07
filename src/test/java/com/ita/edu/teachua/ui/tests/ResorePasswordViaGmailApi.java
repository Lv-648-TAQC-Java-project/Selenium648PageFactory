package com.ita.edu.teachua.ui.tests;


import com.ita.edu.teachua.ui.pages.header_page.HeaderPage;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

public class ResorePasswordViaGmailApi extends TestRunner {

    @Issue("TUA-318")
    @Description("This test case verifies that the user can recover or change the password, using valid values for 'New password' field.")
    @Test(description = "TUA-318")
    public void VerifyNewPasswordValidationWhenRestoringPasswordViaForgotPassword(){
        HeaderPage header = new HeaderPage(driver);
        header.clickOnGuestDropdown()
                .clickOnLoginButton()
                .clickOnForgotPasswordButton()
                .inputEmail("speak.ukrainian.atqc.test@gmail.com")
                .clickOnRestore()
                .setNewRandomPassword();



        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
