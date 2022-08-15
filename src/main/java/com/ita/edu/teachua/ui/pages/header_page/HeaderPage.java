package com.ita.edu.teachua.ui.pages.header_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Dropdown;
import com.ita.edu.teachua.ui.locators.header_locators.HeaderPageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderPage extends BasePage {

    @FindBy(how = How.XPATH, using = HeaderPageLocators.GUEST_DROPDOWN_XPATH)
    private Dropdown guestDropdown;
    @FindBy(how = How.CSS, using = HeaderPageLocators.OWNER_DROPDOWN_CSS_SELECTOR)
    private Dropdown ownerDropdown;



    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on guest dropdown")
    public GuestDropdownComponent goToOnGuestDropdown() {
        waitUntilElementToBeClickable(By.cssSelector(HeaderPageLocators.GUEST_DROPDOWN_XPATH),10000);
        guestDropdown.click();
        sleep(200);
        return new GuestDropdownComponent(driver);
    }

    @Step("Click on dropdown for authorized user in top right corner of header")
    public OwnerDropdownComponent goToOnOwnerDropdown() {
        waitUntilElementToBeClickable(By.cssSelector(HeaderPageLocators.OWNER_DROPDOWN_CSS_SELECTOR),10000);
        ownerDropdown.click();
        return new OwnerDropdownComponent(driver);
    }

    @Step("Authorize user with valid email {email} and password {password}")
    public HeaderPage authorize(String email, String password) {
        goToOnGuestDropdown().clickOnLoginButton().fillLoginFields(email, password);
        //sleep(3000);
        return new HeaderPage(driver);
    }

}
