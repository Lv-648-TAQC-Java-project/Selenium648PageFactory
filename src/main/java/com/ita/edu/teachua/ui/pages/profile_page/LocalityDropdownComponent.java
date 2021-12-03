package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.ButtonElement;
import com.ita.edu.teachua.ui.locators.pageslocators.profilelocators.LocalityDropdownLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.WebDriver;

public class LocalityDropdownComponent extends BasePage {

    private ButtonElement akademmistechkoButton;

    public LocalityDropdownComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        akademmistechkoButton = new ButtonElement(driver, LocalityDropdownLocators.AKADEMMISTECHKO_BUTTON);
    }

    public AddLocationPopUpComponent clickOnAkademmistechkoButton() {
        akademmistechkoButton.click();
        return new AddLocationPopUpComponent(driver);
    }
}