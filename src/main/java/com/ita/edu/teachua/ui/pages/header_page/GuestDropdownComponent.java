package com.ita.edu.teachua.ui.pages.header_page;


import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.pages_locators.header_locators.GuestDropdownComponentLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GuestDropdownComponent extends BasePage {
    @FindBy(how = How.XPATH, using = GuestDropdownComponentLocators.REGISTER_BUTTON_XPATH)
    private Button registerButton;
    @FindBy(how = How.XPATH, using = GuestDropdownComponentLocators.LOGIN_BUTTON_XPATH)
    private Button loginButton;

    public GuestDropdownComponent(WebDriver driver) {
        super(driver);
    }

    public RegisterPopUpComponent clickOnRegisterButton() {
        registerButton.click();
        return new RegisterPopUpComponent(driver);
    }

    public LoginPopUpComponent clickOnLoginButton() {
        waitUntilElementToBeClickable(By.xpath(GuestDropdownComponentLocators.LOGIN_BUTTON_XPATH), 5);
        loginButton.click();
        return new LoginPopUpComponent(driver);
    }

}
