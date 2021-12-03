package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.ButtonElement;
import com.ita.edu.teachua.ui.locators.pageslocators.profilelocators.DistrictDropdownLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.WebDriver;

public class DistrictDropdownComponent extends BasePage {

    private ButtonElement desnianskyiButton;

    public DistrictDropdownComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        desnianskyiButton = new ButtonElement(driver, DistrictDropdownLocators.DESNIANSKYI_BUTTON);
    }

    public AddLocationPopUpComponent clickOnDesnianskyiButton() {
        desnianskyiButton.click();
        return new AddLocationPopUpComponent(driver);
    }
}