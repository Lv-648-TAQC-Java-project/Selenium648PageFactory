package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.profile_locators.CityDropdownLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CityDropdownComponent extends BasePage {
    @FindBy(how = How.XPATH, using = CityDropdownLocators.KYIV_BUTTON_XPATH)
    private Button kyivButton;

    public CityDropdownComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Kyiv option")
    public AddLocationPopUpComponent clickOnKyivButton() {
        kyivButton.click();
        return new AddLocationPopUpComponent(driver);
    }
}