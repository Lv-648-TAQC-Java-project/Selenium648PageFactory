package com.ita.edu.teachua.ui.locators_example.pageslocators.headerlocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum OwnerDropdownLocators implements Locator {
    REGISTER_BUTTON(By.xpath("//span/div[contains(text(),'Зареєструватися')]")),
    LOGIN_BUTTON(By.xpath("//span/div[contains(text(),'Увійти')]")),
    ADD_CENTER_BUTTON(By.xpath("//span/div[contains(text(),'Додати центр')]")),
    MY_PROFILE_BUTTON(By.xpath("//span/a[contains(text(),'Мій Профіль')]"));
    // MY_PROFILE_BUTTON(By.xpath("//div[@class='ant-dropdown ant-dropdown-show-arrow ant-dropdown-placement-bottomCenter ']//li[3]"));

    private final By path;

    OwnerDropdownLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
