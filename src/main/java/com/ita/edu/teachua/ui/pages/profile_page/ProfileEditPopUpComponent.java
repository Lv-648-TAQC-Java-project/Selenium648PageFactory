package com.ita.edu.teachua.ui.pages.profile_page;


import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.CheckBox;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.elements.custom_elements.Label;
import com.ita.edu.teachua.ui.locators.pages_locators.profile_locators.ProfileEditPopUpLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfileEditPopUpComponent extends BasePage {


    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.PHONE_EDIT_XPATH)
    private Input phone;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.FIRSTNAME_EDIT_XPATH)
    private Input firstName;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.LASTNAME_EDIT_XPATH)
    private Input lastName;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.SAVE_BUTTON_XPATH)
    private Button saveButton;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.PASSWORD_EDIT_CHECKBOX_XPATH)
    private CheckBox changePassword;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.SAVE_CHANGE_BUTTON_XPATH)
    private Button saveChangeButton;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.CURRENT_PASSWORD_INPUT_XPATH)
    private Input currentPasswordInput;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.NEW_PASSWORD_INPUT_XPATH)
    private Input newPasswordInput;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.CONFIRM_PASSWORD_INPUT_XPATH)
    private Input confirmPasswordInput;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.MESSAGE_INVALID_INPUT_XPATH)
    private Label messageInvalidInput;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.CURRENT_PASSWORD_ERROR_MESSAGE_XPATH)
    private Label currentPasswordErrorMessage;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.NEW_PASSWORD_ERROR_MESSAGE_XPATH)
    private Label newPasswordErrorMessage;
    @FindBy(how = How.XPATH, using = ProfileEditPopUpLocators.CONFIRM_PASSWORD_ERROR_MESSAGE_XPATH)
    private Label confirmPasswordErrorMessage;

    public ProfileEditPopUpComponent(WebDriver driver) {
        super(driver);
    }

    public ProfileEditPopUpComponent fillPhone(String phoneNumber) {
        phone.set(phoneNumber);
        sleep(2000);
        return this;
    }

    public ProfileEditPopUpComponent fillFirstName(String firstNameFill) {
        sleep(100);
        firstName.clear();
        firstName.set(firstNameFill);
        return this;
    }

    public ProfileEditPopUpComponent fillLastName(String lastNameFill) {
        lastName.clear();
        lastName.set(lastNameFill);
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
        sleep(100);
        return messageInvalidInput.getText();
    }

    public ProfileEditPopUpComponent clickOnChangePasswordCheckBox() {
        try {
            changePassword.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            sleep(200);
            return clickOnChangePasswordCheckBox();
        }
        return this;
    }

    public ProfileEditPopUpComponent clickOnSaveChangeButton() {
        saveChangeButton.click();
        return this;
    }

    public String getErrorMessageCurrentPasswordInput() {
        return currentPasswordErrorMessage.getAttribute("innerText");
    }

    public String getErrorMessageNewPasswordInput() {
        return newPasswordErrorMessage.getAttribute("innerText");
    }

    public String getErrorMessageConfirmPasswordInput() {
        return confirmPasswordErrorMessage.getAttribute("innerText");
    }

    public String getCurrentPasswordInputBorderColor() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return currentPasswordInput.getCssValue("border-color");
    }

    public String getNewPasswordInputBorderColor() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return newPasswordInput.getCssValue("border-color");
    }

    public String getConfirmPasswordInputBorderColor() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return confirmPasswordInput.getCssValue("border-color");
    }

    public ProfileEditPopUpComponent fillInCurrentPasswordInput(String currentPassword) {
        waitUntilVisibilityOfElementLocated(By.xpath(ProfileEditPopUpLocators.CURRENT_PASSWORD_INPUT_XPATH),5);
        Actions act = new Actions(driver);
        act.doubleClick(currentPasswordInput).perform();
        currentPasswordInput.sendKeys(Keys.DELETE);
        currentPasswordInput.sendKeys(currentPassword);
        return this;
    }

    public ProfileEditPopUpComponent fillInNewPasswordInput(String newPassword) {
        waitUntilVisibilityOfElementLocated(By.xpath(ProfileEditPopUpLocators.NEW_PASSWORD_INPUT_XPATH), 5);
        Actions act = new Actions(driver);
        act.doubleClick(newPasswordInput).perform();
        newPasswordInput.sendKeys(Keys.DELETE);
        newPasswordInput.sendKeys(newPassword);
        return this;
    }

    public ProfileEditPopUpComponent fillInConfirmPasswordInput(String confirmPassword) {
        waitUntilVisibilityOfElementLocated(By.xpath(ProfileEditPopUpLocators.CONFIRM_PASSWORD_INPUT_XPATH), 5);
        Actions act = new Actions(driver);
        act.doubleClick(confirmPasswordInput).perform();
        confirmPasswordInput.sendKeys(Keys.DELETE);
        confirmPasswordInput.sendKeys(confirmPassword);
        return this;
    }

    public ProfileEditPopUpComponent checkChangePasswordCheckBox(){
        waitUntilVisibilityOfElementLocated(By.xpath(ProfileEditPopUpLocators.PASSWORD_EDIT_CHECKBOX_XPATH), 5);

        changePassword.toggle();
        return this;
    }

}
