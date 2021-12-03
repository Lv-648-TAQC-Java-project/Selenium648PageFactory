package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.ButtonElement;
import com.ita.edu.teachua.ui.elements.CheckBoxElement;
import com.ita.edu.teachua.ui.elements.InputElement;
import com.ita.edu.teachua.ui.elements.LabelElement;
import com.ita.edu.teachua.ui.locators.pageslocators.profilelocators.AddClubPopUpComponentLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddClubPopUpComponent extends BasePage {


    private InputElement nameOfClub;
    private CheckBoxElement dancesCheckbox;
    private InputElement ageFrom;
    private InputElement ageTo;
    private ButtonElement fromAgeUpperArrow;
    private ButtonElement toAgeUpperArrow;
    private ButtonElement lowerArrow;
    private ButtonElement nextStepButton;
    private InputElement telephoneNumber;
    private InputElement descriptionField;
    private ButtonElement endButton;
    private LabelElement tick;
    private LabelElement error;
    private InputElement clubNameInput;
    private CheckBoxElement sportSectionsCheckBox;
    private InputElement childAgeFromInput;
    private InputElement childAgeToInput;
    private ButtonElement addLocation;

    public AddClubPopUpComponent(WebDriver driver) {
        super(driver);
    }

    public AddClubPopUpComponent enterNameOfClub(String text) {
        nameOfClub = new InputElement(driver, AddClubPopUpComponentLocators.NAME_OF_CLUB);
        nameOfClub.click();
        nameOfClub.clear();
        nameOfClub.sendKeys(text);
        return this;
    }

    public AddClubPopUpComponent clickOnDancesCheckbox() {
        dancesCheckbox = new CheckBoxElement(driver, AddClubPopUpComponentLocators.DANCES_CHECKBOX);
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
        fromAgeUpperArrow = new ButtonElement(driver, AddClubPopUpComponentLocators.FROM_AGE_UPPER_ARROW);
        for (int i = 0; i <= 6; i++) {
            fromAgeUpperArrow.click();
        }
        return this;
    }

    public AddClubPopUpComponent severalClicksOnAgeToUpperArrow() {
        toAgeUpperArrow = new ButtonElement(driver, AddClubPopUpComponentLocators.TO_AGE_UPPER_ARROW);
        for (int i = 0; i <= 7; i++) {
            toAgeUpperArrow.click();
        }
        return this;
    }

    /*Base info area start*/
    public AddClubPopUpComponent fillClubNameField(String clubName) {
        clubNameInput = new InputElement(driver, AddClubPopUpComponentLocators.CLUB_NAME_INPUT);
        clubNameInput.clear();
        clubNameInput.sendKeys(clubName);
        return this;
    }

    public AddClubPopUpComponent chooseSportSections() {
        sportSectionsCheckBox = new CheckBoxElement(driver, AddClubPopUpComponentLocators.SPORT_SECTIONS_CHECKBOX);
        sportSectionsCheckBox.click();
        return this;
    }

    public AddClubPopUpComponent fillChildAge(String ageFrom, String ageTo) {
        childAgeFromInput = new InputElement(driver, AddClubPopUpComponentLocators.CHILD_AGE_FROM_INPUT);
        childAgeToInput = new InputElement(driver, AddClubPopUpComponentLocators.CHILD_AGE_TO_INPUT);
        childAgeFromInput.clear();
        childAgeFromInput.sendKeys(ageFrom);
        childAgeToInput.clear();
        childAgeToInput.sendKeys(ageTo);
        return this;

    }

    public AddClubPopUpComponent clickOnNextStepButton() {
        nextStepButton = new ButtonElement(driver, AddClubPopUpComponentLocators.NEXT_STEP_BUTTON);
        nextStepButton.click();
        return this;
    }

    public AddClubPopUpComponent enterValidTelephoneNumber(String number) {
        telephoneNumber = new InputElement(driver, AddClubPopUpComponentLocators.TELEPHONE_NUMBER);
        telephoneNumber.click();
        telephoneNumber.clear();
        telephoneNumber.sendKeys(number);
        return this;
    }

    public AddClubPopUpComponent inputInDescriptionField(String text) {
        descriptionField = new InputElement(driver, AddClubPopUpComponentLocators.DESCRIPTION_FIELD);
        descriptionField.click();
        descriptionField.clear();
        descriptionField.sendKeys(text);
        sleep(1000);
        return this;
    }

    public ButtonElement getEndButton() {
        return new ButtonElement(driver, AddClubPopUpComponentLocators.END_BUTTON);
    }

    public LabelElement getTick() {
        return new LabelElement(driver, AddClubPopUpComponentLocators.TICK);
    }

    public LabelElement getError() {
        return new LabelElement(driver, AddClubPopUpComponentLocators.ERROR_IN_DESCRIPTION_FIELD);
    }
    /*Base info area end*/

    /*Contacts area start*/
    public AddLocationPopUpComponent clickOnAddLocation() {
        addLocation = new ButtonElement(driver, AddClubPopUpComponentLocators.ADD_LOCATION_BUTTON);
        addLocation.click();
        return new AddLocationPopUpComponent(driver);
    }
    /*Contacts area end*/
}
