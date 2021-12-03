package com.ita.edu.teachua.ui.locators_example.pageslocators.profilelocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum ProfilePageLocators implements Locator {
    EDIT_PROFILE(By.xpath("//button[@class='ant-btn ant-btn-text button']")),
    ADD_CLUB_BUTTON(By.xpath("//button[@class='ant-btn ant-dropdown-trigger']")),
    ADD_CLUB(By.xpath("//ul[@classname='menu']//div[contains(text(),'Додати гурток')]")),
    ADD_BUTTON(By.cssSelector("button[classname='add-button']"));

    private final By path;

    ProfilePageLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
