package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.pages_locators.profile_locators.LocalityDropdownLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LocalityDropdownComponent extends BasePage {

    @FindBy(how = How.XPATH, using = LocalityDropdownLocators.AKADEMMISTECHKO_BUTTON_XPATH)
    private Button akademmistechkoButton;


    public LocalityDropdownComponent(WebDriver driver) {
        super(driver);
    }


    public AddLocationPopUpComponent clickOnAkademmistechkoButton() {
        akademmistechkoButton.click();
        return new AddLocationPopUpComponent(driver);
    }
}