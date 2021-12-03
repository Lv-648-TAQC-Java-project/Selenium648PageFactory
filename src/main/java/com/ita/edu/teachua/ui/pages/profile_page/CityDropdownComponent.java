package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.ButtonElement;
import com.ita.edu.teachua.ui.locators.pageslocators.profilelocators.CityDropdownLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.WebDriver;

public class CityDropdownComponent extends BasePage {

    private ButtonElement kyivButton;

    public CityDropdownComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        kyivButton = new ButtonElement(driver, CityDropdownLocators.KYIV_BUTTON);
    }

    public AddLocationPopUpComponent clickOnKyivButton() {
        kyivButton.click();
        return new AddLocationPopUpComponent(driver);
    }
}