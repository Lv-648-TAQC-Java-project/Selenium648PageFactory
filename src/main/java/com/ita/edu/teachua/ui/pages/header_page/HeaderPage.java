package com.ita.edu.teachua.ui.pages.header_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Dropdown;
import com.ita.edu.teachua.ui.locators.header_locators.HeaderPageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import com.ita.edu.teachua.ui.user.User;
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
    public GuestDropdownComponent goToGuestDropdown() {
        waitUntilElementToBeClickable(By.cssSelector(HeaderPageLocators.OWNER_DROPDOWN_CSS_SELECTOR),10);
        guestDropdown.click();
        sleep(200);
        return new GuestDropdownComponent(driver);
    }

    @Step("Click on dropdown for authorized user in top right corner of header")
    public OwnerDropdownComponent goToOwnerDropdown() {
        waitUntilElementToBeClickable(By.cssSelector(HeaderPageLocators.OWNER_DROPDOWN_CSS_SELECTOR),10);
        ownerDropdown.click();
        return new OwnerDropdownComponent(driver);
    }

    @Step("Authorize user with valid email {email} and password {password}")
    public HeaderPage authorize(String email, String password) {
        goToGuestDropdown().clickOnLoginButton().fillLoginFields(email, password);
        //sleep(3000);
        return new HeaderPage(driver);
    }

    @Step("Authorize user with valid email {email} and password {password}")
    public HeaderPage authorize(User user) {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToGuestDropdown().clickOnLoginButton().fillLoginFields(user.getEmail(), user.getUIPassword());
        //sleep(3000);
        return new HeaderPage(driver);
    }


}
