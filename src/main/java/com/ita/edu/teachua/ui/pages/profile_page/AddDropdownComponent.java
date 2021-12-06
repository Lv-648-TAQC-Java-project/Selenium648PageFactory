package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.pages_locators.profile_locators.AddClubPopUpComponentLocators;
import com.ita.edu.teachua.ui.locators.pages_locators.profile_locators.AddDropDownComponentLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddDropdownComponent extends BasePage {

    @FindBy(how = How.XPATH, using = AddDropDownComponentLocators.ADD_CENTER_BUTTON_XPATH)
    private Button addCenterButton;
    @FindBy(how = How.XPATH, using = AddDropDownComponentLocators.ADD_CLUB_BUTTON_XPATH)
    private Button addClubButton;

    public AddDropdownComponent(WebDriver driver) {
        super(driver);
    }

    public AddCenterPopUpComponent clickOnAddCenterButton() {
        addCenterButton.click();
        return new AddCenterPopUpComponent(driver);
    }

    public AddClubPopUpComponent clickOnAddClubButton() {
        waitUntilVisibilityOfElementLocated(By.xpath(AddDropDownComponentLocators.ADD_CLUB_BUTTON_XPATH), 5);
        addClubButton.click();
        return new AddClubPopUpComponent(driver);
    }
}
