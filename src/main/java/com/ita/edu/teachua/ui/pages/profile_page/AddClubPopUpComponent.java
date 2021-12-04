package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.ButtonElement;
import com.ita.edu.teachua.ui.elements.CheckBoxElement;
import com.ita.edu.teachua.ui.elements.InputElement;
import com.ita.edu.teachua.ui.elements.LabelElement;
import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.CheckBox;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.elements.custom_elements.Label;
import com.ita.edu.teachua.ui.locators.pageslocators.profilelocators.AddClubPopUpComponentLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddClubPopUpComponent extends BasePage {


    private Input nameOfClub;
    private CheckBox dancesCheckbox;
    private Input ageFrom;
    private Input ageTo;
    private Button fromAgeUpperArrow;
    private Button toAgeUpperArrow;
    private Button lowerArrow;
    private Button nextStepButton;
    private Input telephoneNumber;
    private Input descriptionField;
    private Button endButton;
    private Label tick;
    private Label error;
    private Input clubNameInput;
    private CheckBox sportSectionsCheckBox;
    private Input childAgeFromInput;
    private Input childAgeToInput;
    private Button addLocation;

    public AddClubPopUpComponent(WebDriver driver) {
        super(driver);
    }

    public AddClubPopUpComponent enterNameOfClub(String text) {

        nameOfClub.click();
        nameOfClub.clear();
        nameOfClub.sendKeys(text);
        return this;
    }

    public AddClubPopUpComponent clickOnDancesCheckbox() {

        dancesCheckbox.click();
        return this;
    }

    public AddClubPopUpComponent hoverToElement(String id) {
        WebElement element = driver.findElement(By.id(id));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        return this;
    }

    public AddClubPopUpComponent severalClicksOnFromAgeUpperArrow() {

        for (int i = 0; i <= 6; i++) {
            fromAgeUpperArrow.click();
        }
        return this;
    }

    public AddClubPopUpComponent severalClicksOnAgeToUpperArrow() {

        for (int i = 0; i <= 7; i++) {
            toAgeUpperArrow.click();
        }
        return this;
    }

    /*Base info area start*/
    public AddClubPopUpComponent fillClubNameField(String clubName) {
        clubNameInput.clear();
        clubNameInput.sendKeys(clubName);
        return this;
    }

    public AddClubPopUpComponent chooseSportSections() {
        sportSectionsCheckBox.click();
        return this;
    }

    public AddClubPopUpComponent fillChildAge(String ageFrom, String ageTo) {
        childAgeFromInput.clear();
        childAgeFromInput.sendKeys(ageFrom);
        childAgeToInput.clear();
        childAgeToInput.sendKeys(ageTo);
        return this;

    }

    public AddClubPopUpComponent clickOnNextStepButton() {
        nextStepButton.click();
        return this;
    }

    public AddClubPopUpComponent enterValidTelephoneNumber(String number) {
        telephoneNumber.click();
        telephoneNumber.clear();
        telephoneNumber.sendKeys(number);
        return this;
    }

    public AddClubPopUpComponent inputInDescriptionField(String text) {
        descriptionField.click();
        descriptionField.clear();
        descriptionField.sendKeys(text);
        sleep(1000);
        return this;
    }

    public Button getEndButton() {
        return endButton;
    }

    public Label getTick() {
        return tick;
    }

    /*public LabelElement getError() {
        return new LabelElement(driver, AddClubPopUpComponentLocators.ERROR_IN_DESCRIPTION_FIELD);
    }*/
    /*Base info area end*/

    /*Contacts area start*/
    public AddLocationPopUpComponent clickOnAddLocation() {
        addLocation.click();
        return new AddLocationPopUpComponent(driver);
    }
    /*Contacts area end*/
}
