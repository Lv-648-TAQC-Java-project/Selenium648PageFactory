package com.ita.edu.teachua.ui.locators_example.pageslocators.headerlocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum HeaderLocators implements Locator {
    CLUBS_LINK(By.xpath("//a[contains(text(),'Гуртки')]")),
    ABOUT_US_LINK(By.xpath("//a[contains(text(),'Про нас')]")),
    SERVICES_LINK(By.xpath("//a[contains(text(),'Послуги українською')]")),
    GUEST_DROPDOWN(By.xpath("//div[@class = 'ant-dropdown-trigger user-profile']/span[@role]")),
    OWNER_DROPDOWN(By.cssSelector("div.ant-dropdown-trigger.user-profile>span.avatarIfLogin"));

    private final By path;

    HeaderLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
