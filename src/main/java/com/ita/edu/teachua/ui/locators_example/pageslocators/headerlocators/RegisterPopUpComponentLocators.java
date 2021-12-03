package com.ita.edu.teachua.ui.locators_example.pageslocators.headerlocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum RegisterPopUpComponentLocators implements Locator {
    LAST_NAME_FIELD(By.id("lastName")),
    FIRST_NAME_FIELD(By.id("firstName")),
    PHONE_NUMBER_FIELD(By.id("phone")),
    EMAIL_FIELD(By.id("email")),
    PASSWORD_FIELD(By.id("password")),
    PASSWORD_CONFIRM_FIELD(By.id("confirm")),
    REGISTER_BUTTON(By.xpath("//span[contains(text(),'Зареєструватися')]")),
    CLOSE_BUTTON(By.xpath("//span[@aria-label='close']//*[name()='svg']"));
    private final By path;

    RegisterPopUpComponentLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
