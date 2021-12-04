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

   /* public boolean isDataAccepted(String id) {

        try {
            fieldAcceptLabel = new LabelElement(driver, new AddLocationPopUpDynamicLocators().byId(id));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }*/
}
