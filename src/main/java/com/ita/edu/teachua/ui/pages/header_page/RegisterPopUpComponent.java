package com.ita.edu.teachua.ui.pages.header_page;

/*import com.ita.edu.teachua.ui.elements.ButtonElement;
import com.ita.edu.teachua.ui.elements.InputElement;*/

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.locators.header_locators.RegisterPopUpComponentLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPopUpComponent extends BasePage {
    @FindBy(how = How.ID, using = RegisterPopUpComponentLocators.FIRST_NAME_FIELD_ID)
    private Input firstName;
    @FindBy(how = How.ID, using = RegisterPopUpComponentLocators.LAST_NAME_FIELD_ID)
    private Input lastName;
    @FindBy(how = How.ID, using = RegisterPopUpComponentLocators.PHONE_NUMBER_FIELD_ID)
    private Input phoneNumber;
    @FindBy(how = How.ID, using = RegisterPopUpComponentLocators.EMAIL_FIELD_ID)
    private Input email;
    @FindBy(how = How.ID, using = RegisterPopUpComponentLocators.PASSWORD_FIELD_ID)
    private Input password;
    @FindBy(how = How.ID, using = RegisterPopUpComponentLocators.PASSWORD_CONFIRM_FIELD_ID)
    private Input passwordConfirm;
    @FindBy(how = How.XPATH, using = RegisterPopUpComponentLocators.REGISTER_BUTTON_XPATH)
    private Button registerButton;
    @FindBy(how = How.XPATH, using = RegisterPopUpComponentLocators.CLOSE_BUTTON_XPATH)
    private Button closeButton;
    @FindBy(how = How.XPATH, using = RegisterPopUpComponentLocators.ERROR_MASSAGE_LAST_NAME_FIELD)
    private Button errorMassageLastNameField;
    @FindBy(how = How.XPATH, using = RegisterPopUpComponentLocators.ERROR_MASSAGE_FIRST_NAME_FIELD)
    private Button errorMassageFirstNameField;
    @FindBy(how = How.XPATH, using = RegisterPopUpComponentLocators.ERROR_MASSAGE_PHONE_FIELD)
    private Button errorMassagePhoneField;
    @FindBy(how = How.XPATH, using = RegisterPopUpComponentLocators.ERROR_MASSAGE_EMAIL_FIELD)
    private Button errorMassageEmailField;
    @FindBy(how = How.XPATH, using = RegisterPopUpComponentLocators.ERROR_MASSAGE_PASSWORD_FIELD)
    private Button errorMassagePasswordField;
    @FindBy(how = How.XPATH, using = RegisterPopUpComponentLocators.ERROR_MASSAGE_CONFIRM_PASSWORD_FIELD)
    private Button errorMassageConfirmPasswordField;


    public RegisterPopUpComponent(WebDriver driver) {
        super(driver);
    }


    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("Click on first name field")
    public RegisterPopUpComponent clickFirstNameField() {
        firstName.click();
        return this;
    }

    @Step("Fill first name in first name field")
    public RegisterPopUpComponent fillFirstName(String firstNameFill) {
        firstName.sendKeys(firstNameFill);
        return this;
    }

    public RegisterPopUpComponent clickLastNameField() {
        lastName.click();
        return this;
    }

    public Input getLastNameField() {
        return lastName;
    }

    public Input getFirstNameField() {
        return firstName;
    }

    public Input getEmailField() {
        return email;
    }

    public Input getPasswordField() {
        return password;
    }

    public Input getPhoneNumber() {
        return phoneNumber;
    }

    public Input getPasswordConfirmField() {
        sleep(800);
        return passwordConfirm;
    }

    public RegisterPopUpComponent fillLastName(String lastNameFill) {
        lastName.sendKeys(lastNameFill);
        return this;
    }

    public RegisterPopUpComponent clickEmailField() {
        email.click();
        return this;
    }

    @Step("Fill email in email field")
    public RegisterPopUpComponent fillEmail(String emailFill) {
        email.sendKeys(emailFill);
        return this;
    }

    @Step("Click phone umber field")
    public RegisterPopUpComponent clickPhoneNumberField() {
        phoneNumber.click();
        return this;
    }

    @Step("Fill phone number in phone number field")
    public RegisterPopUpComponent fillPhoneNumber(String phoneNumberFill) {
        phoneNumber.sendKeys(phoneNumberFill);
        return this;
    }

    @Step("Click password field")
    public RegisterPopUpComponent clickPasswordField() {
        password.click();
        return this;
    }

    @Step("Fill password in password field")
    public RegisterPopUpComponent fillPassword(String passwordFill) {
        password.sendKeys(passwordFill);
        return this;
    }

    @Step("Click on (password confirm field)")
    public RegisterPopUpComponent clickPasswordConfirmField() {
        passwordConfirm.click();
        return this;
    }

    @Step("Fill confirming password in confirm password field")
    public RegisterPopUpComponent fillPasswordConfirm(String passwordConfirmFill) {
        passwordConfirm.sendKeys(passwordConfirmFill);
        return this;
    }

    public void clearFirstNameField() {
        firstName.click();
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        firstName.sendKeys(del);
    }

    public void clearEmailField() {
        email.click();
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        email.sendKeys(del);
    }

    public void clearPhoneField() {
        phoneNumber.click();
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        phoneNumber.sendKeys(del);
    }

    public void clearPasswordField() {
        password.click();
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        password.sendKeys(del);
    }

    public void clearPasswordConfirmField() {
        passwordConfirm.click();
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        passwordConfirm.sendKeys(del);
    }

    @Step("Click close button")
    public HeaderPage clickCloseButton() {
        closeButton.click();
        return new HeaderPage(driver);
    }

    public void clearLastNameField() {
        lastName.click();
            String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        lastName.sendKeys(del);
    }



    @Step("Get text from field (last name)")
    public String getLastNameText() {
        return lastName.getText();
    }

    @Step("Get text from field (first name)")
    public String getFirstNameText() {
        return firstName.getText();
    }

    @Step("Get text from field (email)")
    public String getEmailText() {
        return email.getText();
    }

    @Step("Get text from field (password)")
    public String getPasswordText() {
        return password.getText();
    }

    @Step("Get text from field (Phone number)")
    public String getPhoneNumberText() {
        return phoneNumber.getText();
    }

    @Step("Get error massage from last name field")
    public String getErrorMassageLastNameField() {
        return errorMassageLastNameField.getText();
    }

    @Step("Get error massage from first name field")
    public String getErrorMassageFirstNameField() {
        return errorMassageFirstNameField.getText();
    }

    @Step("Get error massage from phone field")
    public String getErrorMassagePhoneField() {
        return errorMassagePhoneField.getText();
    }

    @Step("Get error massage from email field")
    public String getErrorMassageEmailField() {
        return errorMassageEmailField.getText();
    }

    @Step("Get error massage from password field")
    public String getErrorMassagePasswordField() {
        return errorMassagePasswordField.getText();
    }

    @Step("Get error massage from confirm password field")
    public String getErrorMassageConfirmPasswordField() {
        return errorMassageConfirmPasswordField.getText();
    }


    public RegisterPopUpComponent getRegisterPopUpComponent(){
        return this;
    }
}
