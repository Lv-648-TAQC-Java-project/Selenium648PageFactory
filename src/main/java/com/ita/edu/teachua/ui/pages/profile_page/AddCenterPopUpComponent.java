package com.ita.edu.teachua.ui.pages.profile_page;


import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Div;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;

import com.ita.edu.teachua.ui.locators.pages_locators.profile_locators.AddCenterPopUpComponentLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCenterPopUpComponent extends BasePage {
    @FindBy(how = How.CLASS_NAME, using = AddCenterPopUpComponentLocators.ADD_LOCATION_BUTTON_CLASS_NAME)
    private Button addLocation;
    @FindBy(how = How.CLASS_NAME, using = AddCenterPopUpComponentLocators.CENTER_NAME_INPUT_ID)
    private Input centerName;
    @FindBy(how = How.CSS, using = AddCenterPopUpComponentLocators.NEXT_STEP_BUTTON_CSS_SELECTOR)
    private Button nextStepButton;
    @FindBy(how = How.CSS, using = AddCenterPopUpComponentLocators.CENTER_NAME_ERROR_BLOCK_CSS_SELECTOR)
    private Div errorBlock;
    @FindBy(how = How.ID, using = AddCenterPopUpComponentLocators.CENTER_NAME_INPUT_ID)
    private Input nameField;
    @FindBy(how = How.XPATH, using = AddCenterPopUpComponentLocators.PHONE_NUMBER_FIELD_ID)
    private Input phoneNumberField;
    @FindBy(how = How.ID, using = AddCenterPopUpComponentLocators.DESCRIPTION_FIELD_ID)
    private Input description;
    @FindBy(how = How.XPATH, using = AddCenterPopUpComponentLocators.FINISH_BUTTON_XPATH)
    private Button finishButton;

    public AddCenterPopUpComponent(WebDriver driver) {
        super(driver);
    }

    public AddLocationPopUpComponent clickOnAddLocation() {
        addLocation.click();
        return new AddLocationPopUpComponent(driver);
    }

    public AddLocationPopUpComponent fillNameField(String name) {
        nameField.click();
        nameField.sendKeys(name);
        return new AddLocationPopUpComponent(driver);
    }

    public AddLocationPopUpComponent fillPhoneNumberField(String phone) {
        phoneNumberField.click();
        phoneNumberField.sendKeys(phone);
        return new AddLocationPopUpComponent(driver);
    }

    public AddLocationPopUpComponent fillDescriptionField(String text) {
        description.click();
        description.sendKeys(text);
        return new AddLocationPopUpComponent(driver);
    }

    public AddCenterPopUpComponent clearCenterName() {
        centerName.clear();
        return this;
    }

    public AddCenterPopUpComponent clickOnNextStepButton() {
        nextStepButton.click();
        return this;
    }

    public boolean errorsIsDisplayed() {
        return errorBlock.isDisplayed();
    }

    public ProfilePage clickOnFinishButton() {

        finishButton.click();
        return new ProfilePage(driver);
    }

    public AddCenterPopUpComponent clickOnNextStep() {
        nextStepButton.click();
        return this;
    }

    /*public CheckBoxElement getCheckBoxByName(String name) {
        return new CheckBoxElement(driver.findElement(By.xpath("//span[contains(text(),'" + name + "')]")));
    }*/

    /*public AddCenterPopUpComponent clickOnCheckBoxByName(String name) {
        getCheckBoxByName(name).click();
        return this;
    }*/

}
