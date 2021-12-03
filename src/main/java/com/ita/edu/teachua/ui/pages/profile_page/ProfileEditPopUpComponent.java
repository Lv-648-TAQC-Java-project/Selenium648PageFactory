package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.Button;
import com.ita.edu.teachua.ui.elements.CheckBox;
import com.ita.edu.teachua.ui.elements.Input;
import com.ita.edu.teachua.ui.elements.Label;
import com.ita.edu.teachua.ui.locators.pageslocators.profilelocators.ProfileEditPopUpLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.WebDriver;

public class ProfileEditPopUpComponent extends BasePage {
    public ProfileEditPopUpComponent(WebDriver driver) {
        super(driver);
    }

    public ProfileEditPopUpComponent fillPhone(String phoneNumber) {
        InputElement phone = new InputElement(driver, ProfileEditPopUpLocators.PHONE_EDIT);
        phone.clear();
        phone.sendKeys(phoneNumber);
        sleep(2000);
        return this;
    }

    public ProfileEditPopUpComponent fillFirstName(String firstNameFill) {
        InputElement firstName = new InputElement(driver, ProfileEditPopUpLocators.FIRSTNAME_EDIT);
        firstName.clear();
        firstName.sendKeys(firstNameFill);
        return this;
    }

    public ProfileEditPopUpComponent fillLastName(String lastNameFill) {
        InputElement lastName = new InputElement(driver, ProfileEditPopUpLocators.LASTNAME_EDIT);
        lastName.clear();
        lastName.sendKeys(lastNameFill);
        sleep(2000);
        return this;
    }

    public boolean getSaveButtonValue() {
        ButtonElement saveButton = new ButtonElement(driver, ProfileEditPopUpLocators.SAVE_BUTTON);
        return saveButton.isActive();
    }

    public ProfileEditPopUpComponent clickSubmit() {
        ButtonElement saveButton = new ButtonElement(driver, ProfileEditPopUpLocators.SAVE_BUTTON);
        saveButton.click();
        return this;
    }

    public String getAttributeSubmitButtonIsClickable() {
        ButtonElement saveButton = new ButtonElement(driver, ProfileEditPopUpLocators.SAVE_BUTTON);
        return saveButton.getAttribute();
    }

    public String getMessage() {
        return new LabelElement(driver, ProfileEditPopUpLocators.MESSAGE_INVALID_INPUT).getText();
    }

    public ProfileEditPopUpComponent clickOnChangePasswordCheckBox() {
        CheckBoxElement changePassword = new CheckBoxElement(driver, ProfileEditPopUpLocators.PASSWORD_EDIT_CHECKBOX);
        try {
            changePassword.click();
        }catch (org.openqa.selenium.ElementClickInterceptedException e){
            sleep(100);
            return clickOnChangePasswordCheckBox();
        }
        return this;
    }

    public ProfileEditPopUpComponent clickOnSaveChangeButton() {
        ButtonElement saveChangeButton = new ButtonElement(driver, ProfileEditPopUpLocators.SAVE_CHANGE_BUTTON);
        saveChangeButton.click();
        return this;
    }

    public String getErrorMessageCurrentPasswordInput() {
        return new LabelElement(driver, ProfileEditPopUpLocators.CURRENT_PASSWORD_ERROR_MESSAGE).getText();
    }

    public String getErrorMessageNewPasswordInput() {
        return new LabelElement(driver, ProfileEditPopUpLocators.NEW_PASSWORD_ERROR_MESSAGE).getText();
    }

    public String getErrorMessageConfirmPasswordInput() {
        return new LabelElement(driver, ProfileEditPopUpLocators.CONFIRM_PASSWORD_ERROR_MESSAGE).getText();
    }

    public String getCurrentPasswordInputBorderColor() {
        return new InputElement(driver, ProfileEditPopUpLocators.CURRENT_PASSWORD_INPUT).getCSSValue("border-color");
    }

    public String getNewPasswordInputBorderColor() {
        return new InputElement(driver, ProfileEditPopUpLocators.NEW_PASSWORD_INPUT).getCSSValue("border-color");
    }

    public String getConfirmPasswordInputBorderColor() {
        return new InputElement(driver, ProfileEditPopUpLocators.CONFIRM_PASSWORD_INPUT).getCSSValue("border-color");
    }

    public ProfileEditPopUpComponent fillInCurrentPasswordInput(String currentPassword) {
        InputElement currentPasswordInput = new InputElement(driver, ProfileEditPopUpLocators.CURRENT_PASSWORD_INPUT);
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys(currentPassword);
        return this;
    }

    public ProfileEditPopUpComponent fillInNewPasswordInput(String newPassword) {
        InputElement newPasswordInput = new InputElement(driver, ProfileEditPopUpLocators.NEW_PASSWORD_INPUT);
        newPasswordInput.clear();
        newPasswordInput.sendKeys(newPassword);
        return this;
    }

    public ProfileEditPopUpComponent fillInConfirmPasswordInput(String confirmPassword) {
        InputElement confirmPasswordInput = new InputElement(driver, ProfileEditPopUpLocators.CONFIRM_PASSWORD_INPUT);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
        return this;
    }


}
