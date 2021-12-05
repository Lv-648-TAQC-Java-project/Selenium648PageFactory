package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.pages.header_page.HeaderPage;
import com.ita.edu.teachua.ui.pages.header_page.RegisterPopUpComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class RegistrationTest extends TestRunner {

    @Test(invocationCount = 1)
    public void checkAlertsFieldsWhenEmpty() {
        HeaderPage profile = new HeaderPage(driver);
        RegisterPopUpComponent registration = profile.clickOnGuestDropdown().clickOnRegisterButton();

        Input lastName = registration.fillLastName("a" + Keys.BACK_SPACE).getLastNameField();
        Input firstName = registration.fillFirstName("a" + Keys.BACK_SPACE).getFirstNameField();
        Input phoneNumber = registration.fillPhoneNumber("a" + Keys.BACK_SPACE).getPhoneNumber();
        Input email = registration.fillEmail("a" + Keys.BACK_SPACE).getEmailField();
        Input password = registration.fillPassword("a" + Keys.BACK_SPACE).getPasswordField();
        Input confirmPassword = registration.fillPasswordConfirm("a" + Keys.BACK_SPACE).getPasswordConfirmField();

        List<WebElement> alerts = driver.findElements(By.cssSelector("div[role=\"alert\"]"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(lastName.getCSSValue("border-color").equals("rgb(255, 77, 79)"));
        softAssert.assertTrue(firstName.getCSSValue("border-color").equals("rgb(255, 77, 79)"));
        softAssert.assertTrue(email.getCSSValue("border-color").equals("rgb(255, 77, 79)"));
        softAssert.assertTrue(phoneNumber.getCSSValue("border-color").equals("rgb(255, 77, 79)"));
        softAssert.assertTrue(password.getCSSValue("border-color").equals("rgb(255, 77, 79)"));
        softAssert.assertTrue(confirmPassword.getCSSValue("border-color").equals("rgb(255, 120, 117)"));

        softAssert.assertTrue(alerts.get(0).getText().equals("Введіть прізвище"));
        softAssert.assertTrue(alerts.get(1).getText().equals("Введіть ім`я"));
        softAssert.assertTrue(alerts.get(2).getText().equals("Введіть номер телефону"));
        softAssert.assertTrue(alerts.get(4).getText().equals("Введіть email"));
        softAssert.assertTrue(alerts.get(5).getText().equals("Введіть пароль"));
        softAssert.assertTrue(alerts.get(6).getText().equals("Підтвердіть пароль"));

        softAssert.assertAll();
    }
}
