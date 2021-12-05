package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.custom_elements.ButtonElement;
import com.ita.edu.teachua.ui.locators.pages_locators.profile_locators.CityDropdownLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CityDropdownComponent extends BasePage {
    @FindBy(how = How.XPATH, using = CityDropdownLocators.KYIV_BUTTON_XPATH)
    private ButtonElement kyivButton;

    public CityDropdownComponent(WebDriver driver) {
        super(driver);
    }


    public AddLocationPopUpComponent clickOnKyivButton() {
        kyivButton.click();
        return new AddLocationPopUpComponent(driver);
    }
}