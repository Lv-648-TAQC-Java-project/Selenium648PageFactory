package com.ita.edu.teachua.ui.pages.profile_page;


import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Div;
import com.ita.edu.teachua.ui.elements.custom_elements.Dropdown;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AddLocationPopUpComponent extends BasePage {
    private Button addButton;
    private Div addLocationPopUpBlock;
    private Input locationNameField;
    private Dropdown cityDropdown;
    private Dropdown districtDropdown;
    private Dropdown localityDropdown;
    private Input addressField;
    private Input coordinatesField;
    private Input phoneField;
    //private Label fieldAcceptLabel;

    public AddLocationPopUpComponent(WebDriver driver) {
        super(driver);
    }

    public boolean checkAddButton() {
        return addButton.isActive();
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
        districtDropdown = new DropDownElement(driver, AddLocationPopUpLocators.DISTRICT_DROPDOWN);
        districtDropdown.click();
        return new DistrictDropdownComponent(driver);
    }

    public LocalityDropdownComponent clickOnLocalityDropdown() {
        localityDropdown = new DropDownElement(driver, AddLocationPopUpLocators.LOCALITY_DROPDOWN);
        localityDropdown.click();
        return new LocalityDropdownComponent(driver);
    }

    public AddLocationPopUpComponent clickOnAddressField() {
        addressField = new InputElement(driver, AddLocationPopUpLocators.ADDRESS_FIELD);
        addressField.click();
        return this;
    }

    public AddLocationPopUpComponent sendKeysAddressField(String address) {
        addressField = new InputElement(driver, AddLocationPopUpLocators.ADDRESS_FIELD);
        addressField.sendKeys(address);
        return this;
    }

    public AddLocationPopUpComponent clickOnCoordinatesField() {
        coordinatesField = new InputElement(driver, AddLocationPopUpLocators.COORDINATES_FIELD);
        coordinatesField.click();
        return this;
    }

    public AddLocationPopUpComponent sendKeysCoordinatesField(String coordinates) {
        coordinatesField = new InputElement(driver, AddLocationPopUpLocators.COORDINATES_FIELD);
        coordinatesField.sendKeys(coordinates);
        return this;
    }

    public AddLocationPopUpComponent clickOnPhoneField() {
        phoneField = new InputElement(driver, AddLocationPopUpLocators.PHONE_FIELD);
        phoneField.click();
        return this;
    }

    public AddLocationPopUpComponent sendKeysPhoneField(String phoneNumber) {
        phoneField = new InputElement(driver, AddLocationPopUpLocators.PHONE_FIELD);
        phoneField.sendKeys(phoneNumber);
        return this;
    }

    public AddCenterPopUpComponent clickOnAddButton() {
        addButton = new ButtonElement(driver, AddLocationPopUpLocators.ADD_BUTTON);
        addButton.click();
        return new AddCenterPopUpComponent(driver);
    }

   /* public boolean isDataAccepted(String id) {

        try {
            fieldAcceptLabel = new LabelElement(driver, new AddLocationPopUpDynamicLocators().byId(id));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }*/
}
