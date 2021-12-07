package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.custom_elements.*;
import com.ita.edu.teachua.ui.locators.profile_locators.AddClubPopUpComponentLocators;
import com.ita.edu.teachua.ui.locators.profile_locators.ProfileDynamicLabelsLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddClubPopUpComponent extends BasePage {

    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.NAME_OF_CLUB_ID)
    private Input nameOfClub;
    @FindBy(how = How.XPATH, using = AddClubPopUpComponentLocators.DANCES_CHECKBOX_XPATH)
    private CheckBox dancesCheckbox;
    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.CHILD_AGE_FROM_INPUT_ID)
    private Input ageFrom;
    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.CHILD_AGE_TO_INPUT_ID)
    private Input ageTo;
    @FindBy(how = How.XPATH, using = AddClubPopUpComponentLocators.NEXT_STEP_BUTTON_XPATH)
    private Button nextStepButton;
    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.TELEPHONE_NUMBER_ID)
    private Input telephoneNumber;
    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.FACEBOOK_FIELD_ID)
    private Input facebookField;
    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.WHATSAPP_FIELD_ID)
    private Input whatsAppField;
    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.EMAIL_FIELD_ID)
    private Input emailField;
    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.SKYPE_FIELD_ID)
    private Input skypeField;
    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.SITE_FIELD_ID)
    private Input siteField;

    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.DESCRIPTION_FIELD_ID)
    private Input descriptionField;
    @FindBy(how = How.CSS, using = AddClubPopUpComponentLocators.END_BUTTON_CSS_SELECTOR)
    private Button endButton;

    @FindBy(how = How.XPATH, using = AddClubPopUpComponentLocators.COMPLETE_BUTTON_XPATH)
    private Button completeButton;

    @FindBy(how = How.XPATH, using = AddClubPopUpComponentLocators.TICK_XPATH)
    private Label tick;
    @FindBy(how = How.XPATH, using = AddClubPopUpComponentLocators.ERROR_IN_DESCRIPTION_FIELD_XPATH)
    private Label error;
    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.CLUB_NAME_INPUT_ID)
    private Input clubNameInput;
    @FindBy(how = How.CSS, using = AddClubPopUpComponentLocators.SPORT_SECTIONS_CHECKBOX_CSS_SELECTOR)
    private CheckBox sportSectionsCheckBox;
    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.CHILD_AGE_FROM_INPUT_ID)
    private Input childAgeFromInput;
    @FindBy(how = How.ID, using = AddClubPopUpComponentLocators.CHILD_AGE_TO_INPUT_ID)
    private Input childAgeToInput;
    @FindBy(how = How.CLASS_NAME, using = AddClubPopUpComponentLocators.ADD_LOCATION_BUTTON_CLASS_NAME)
    private Button addLocation;
    @FindBy(how = How.TAG_NAME, using = AddClubPopUpComponentLocators.ADDED_LOCATION_TITLE_TAG_NAME)
    private Title addedLocationTitle;

    private Label fieldAcceptLabel;

    public AddClubPopUpComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Fill 'Назва' field with {text}")
    public AddClubPopUpComponent enterNameOfClub(String text) {
        waitUntilElementToBeClickable(By.id(AddClubPopUpComponentLocators.NAME_OF_CLUB_ID), 5);
        nameOfClub.set(text);
        return this;
    }

    @Step("Click on 'Танці, хореографія' checkbox")
    public AddClubPopUpComponent clickOnDancesCheckbox() {
        waitUntilElementToBeClickable(By.xpath(AddClubPopUpComponentLocators.DANCES_CHECKBOX_XPATH), 5);
        dancesCheckbox.click();
        return this;
    }

    @Step("Hover to {id} element")
    public AddClubPopUpComponent hoverToElement(String id) {
        WebElement element = driver.findElement(By.id(id));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        return this;
    }

    @Step("Click 6 times on upper arrow in 'Від' field")
    public AddClubPopUpComponent severalClicksOnFromAgeUpperArrow() {
        for (int i = 0; i <= 6; i++) {
            ageFrom.sendKeys(Keys.ARROW_UP);
        }
        return this;
    }
    @Step("Click 7 times on upper arrow in 'до' field")
    public AddClubPopUpComponent severalClicksOnAgeToUpperArrow() {
        for (int i = 0; i <= 7; i++) {
            ageTo.sendKeys(Keys.ARROW_UP);
        }
        return this;
    }


    /*Base info area start*/
    public AddClubPopUpComponent fillClubNameField(String clubName) {
        clubNameInput.set(clubName);
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

    @Step("Click on 'Наступний крок' button")
    public AddClubPopUpComponent clickOnNextStepButton() {
        nextStepButton.click();
        return this;
    }

    @Step("Fill 'Опис' field with {text}")
    public AddClubPopUpComponent inputInDescriptionField(String text) {
        descriptionField.set(text);
        sleep(1000);
        return this;
    }

    public AddClubPopUpComponent clickOnCompleteButton() {
        completeButton.click();
        return this;
    }

    @Step("Get 'Завершити' button")
    public Button getEndButton() {
        return endButton;
    }
    @Step("Get tick")
    public Label getTick() {
        return tick;
    }

    @Step("Get error message")
    public Label getError() {
        return error;
    }
    /*Base info area end*/

    /*Contacts area start*/
    public Title getAddedLocationTitle() {
        return addedLocationTitle;
    }

    public AddLocationPopUpComponent clickOnAddLocation() {
        addLocation.click();
        return new AddLocationPopUpComponent(driver);
    }

    @Step("Fill 'Контакти' field with {number}")
    public AddClubPopUpComponent enterValidTelephoneNumber(String number) {
        telephoneNumber.set(number);
        return this;
    }

    public AddClubPopUpComponent enterValidFacebook(String facebook) {
        facebookField.clear();
        facebookField.sendKeys(facebook);
        return this;
    }

    public AddClubPopUpComponent enterValidWhatsApp(String whatsApp) {
        whatsAppField.clear();
        whatsAppField.sendKeys(whatsApp);
        return this;
    }

    public AddClubPopUpComponent enterValidEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public AddClubPopUpComponent enterValidSkype(String skype) {
        skypeField.clear();
        skypeField.sendKeys(skype);
        return this;
    }

    public AddClubPopUpComponent enterValidSite(String site) {
        siteField.clear();
        siteField.sendKeys(site);
        return this;
    }


    public boolean isDataAccepted(String id) {
        try {
            fieldAcceptLabel = new LabelElement(new ProfileDynamicLabelsLocators().addClubPopUpDynamicIdByXPath(driver, id));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    /*Contacts area end*/
}
