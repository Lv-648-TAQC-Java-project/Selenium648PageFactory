package com.ita.edu.teachua.ui.pages.profile_page;


import com.ita.edu.teachua.ui.elements.custom_elements.*;
import com.ita.edu.teachua.ui.locators.pages_locators.profile_locators.ProfileEditPopUpLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.swing.text.LabelView;

public class ProfileEditPopUpComponent extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.PHONE_EDIT_XPATH)
    private InputElement phone;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.FIRSTNAME_EDIT_XPATH)
    private InputElement firstName;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.LASTNAME_EDIT_XPATH)
    private InputElement lastName;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.SAVE_BUTTON_XPATH)
    private ButtonElement saveButton;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.PASSWORD_EDIT_CHECKBOX_XPATH)
    private CheckBoxElement changePassword;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.SAVE_BUTTON_XPATH)
    private ButtonElement saveChangeButton;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.CURRENT_PASSWORD_INPUT_XPATH)
    private InputElement currentPasswordInput;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.NEW_PASSWORD_INPUT_XPATH)
    private InputElement newPasswordInput;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.CONFIRM_PASSWORD_INPUT_XPATH)
    private InputElement confirmPasswordInput;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.MESSAGE_INVALID_INPUT_XPATH)
    private LabelElement messageInvalidInput;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.CURRENT_PASSWORD_ERROR_MESSAGE_XPATH)
    private LabelElement currentPasswordErrorMessage;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.NEW_PASSWORD_ERROR_MESSAGE_XPATH)
    private LabelElement newPasswordErrorMessage;
    @FindBy(how = How.CLASS_NAME, using = ProfileEditPopUpLocators.CONFIRM_PASSWORD_ERROR_MESSAGE_XPATH)
    private LabelElement confirmPasswordErrorMessage;

    public ProfileEditPopUpComponent(WebDriver driver) {
        super(driver);
    }

    public ProfileEditPopUpComponent fillPhone(String phoneNumber) {

        phone.clear();
        phone.sendKeys(phoneNumber);
        sleep(2000);
        return this;
    }

    public ProfileEditPopUpComponent fillFirstName(String firstNameFill) {
        firstName.clear();
        firstName.sendKeys(firstNameFill);
        return this;
    }

    public ProfileEditPopUpComponent fillLastName(String lastNameFill) {
        lastName.clear();
        lastName.sendKeys(lastNameFill);
        sleep(2000);
        return this;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public ProfileEditPopUpComponent clickSubmit() {
        saveButton.click();
        return this;
    }


    public String getMessage() {
        return messageInvalidInput.getText();
    }

    public ProfileEditPopUpComponent clickOnChangePasswordCheckBox() {
        try {
            changePassword.click();
        }catch (org.openqa.selenium.ElementClickInterceptedException e){
            sleep(100);
            return clickOnChangePasswordCheckBox();
        }
        return this;
    }

    public ProfileEditPopUpComponent clickOnSaveChangeButton() {
        saveChangeButton.click();
        return this;
    }

    public String getErrorMessageCurrentPasswordInput() {
        return currentPasswordErrorMessage.getText();
    }

    public String getErrorMessageNewPasswordInput() {
        return newPasswordErrorMessage.getText();
    }

    public String getErrorMessageConfirmPasswordInput() {
        return confirmPasswordInput.getText();
    }

    public String getCurrentPasswordInputBorderColor() {
        return currentPasswordInput.getCSSValue("border-color");
    }

    public String getNewPasswordInputBorderColor() {
        return newPasswordInput.getCSSValue("border-color");
    }

    public String getConfirmPasswordInputBorderColor() {
        return confirmPasswordInput.getCSSValue("border-color");
    }

    public ProfileEditPopUpComponent fillInCurrentPasswordInput(String currentPassword) {
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys(currentPassword);
        return this;
    }

    public ProfileEditPopUpComponent fillInNewPasswordInput(String newPassword) {
        newPasswordInput.clear();
        newPasswordInput.sendKeys(newPassword);
        return this;
    }

    public ProfileEditPopUpComponent fillInConfirmPasswordInput(String confirmPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
        return this;
    }


}
