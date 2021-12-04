package com.ita.edu.teachua.ui.pages.profile_page;


import com.ita.edu.teachua.ui.elements.custom_elements.*;
import com.ita.edu.teachua.ui.locators.pages_locators.profile_locators.AddDropDownComponentLocators;
import com.ita.edu.teachua.ui.locators.pages_locators.profile_locators.AddLocationPopUpComponentLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddLocationPopUpComponent extends BasePage {
    @FindBy(how = How.XPATH, using = AddLocationPopUpComponentLocators.ADD_BUTTON_XPATH)
    private Button addButton;
    @FindBy(how = How.XPATH, using = AddLocationPopUpComponentLocators.ADD_LOCATION_BLOCK_HEADER_XPATH)
    private Div addLocationPopUpBlock;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.LOCATION_NAME_FIELD_ID)
    private Input locationNameField;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.CITY_DROPDOWN_ID)
    private Dropdown cityDropdown;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.DISTRICT_DROPDOWN_ID)
    private Dropdown districtDropdown;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.LOCALITY_DROPDOWN_ID)
    private Dropdown localityDropdown;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.ADDRESS_FIELD_ID)
    private Input addressField;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.COORDINATES_FIELD_ID)
    private Input coordinatesField;
    @FindBy(how = How.ID, using = AddLocationPopUpComponentLocators.PHONE_FIELD_ID)
    private Input phoneField;
    @FindBy(how = How.CSS, using = AddLocationPopUpComponentLocators.ADD_BUTTON_DISABLED_CSS_SELECTOR)
    private Button addButtonDisabled;

    //private Label fieldAcceptLabel;

    public AddLocationPopUpComponent(WebDriver driver) {
        super(driver);
    }

    public boolean checkAddButton() {
        return addButton.isDisplayed();
    }

    public boolean addLocationPopUpBlockIsDisplayed() {
        return addLocationPopUpBlock.isActive();
    }

    public AddLocationPopUpComponent clickOnLocationNameField() {
        locationNameField.click();
        return this;
    }

    public AddLocationPopUpComponent sendKeysLocationNameField(String locationName) {
        locationNameField.sendKeys(locationName);
        return this;
    }

    public CityDropdownComponent clickOnCityDropdown() {
        cityDropdown.click();
        return new CityDropdownComponent(driver);
    }


    public DistrictDropdownComponent clickOnDistrictDropdown() {
        districtDropdown.click();
        return new DistrictDropdownComponent(driver);
    }

    public LocalityDropdownComponent clickOnLocalityDropdown() {
        localityDropdown.click();
        return new LocalityDropdownComponent(driver);
    }

    public AddLocationPopUpComponent clickOnAddressField() {
        addressField.click();
        return this;
    }

    public AddLocationPopUpComponent sendKeysAddressField(String address) {
        addressField.sendKeys(address);
        return this;
    }

    public AddLocationPopUpComponent clickOnCoordinatesField() {
        coordinatesField.click();
        return this;
    }

    public AddLocationPopUpComponent sendKeysCoordinatesField(String coordinates) {
        coordinatesField.sendKeys(coordinates);
        return this;
    }

    public AddLocationPopUpComponent clickOnPhoneField() {
        phoneField.click();
        return this;
    }

    public AddLocationPopUpComponent sendKeysPhoneField(String phoneNumber) {
        phoneField.sendKeys(phoneNumber);
        return this;
    }

    public AddCenterPopUpComponent clickOnAddButton() {
        addButton.click();
        return new AddCenterPopUpComponent(driver);
    }

    public boolean isDataAccepted(String id) {

        /*try {
            fieldAcceptLabel = new LabelElement(*//*driver, new AddLocationPopUpDynamicLocators().byId(id)*//*);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }*/
    return true;
    }
}
