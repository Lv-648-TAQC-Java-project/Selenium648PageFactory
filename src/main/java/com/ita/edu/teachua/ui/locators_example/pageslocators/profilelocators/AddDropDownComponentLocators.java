package com.ita.edu.teachua.ui.locators_example.pageslocators.profilelocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum AddDropDownComponentLocators implements Locator {

    ADD_CLUB_BUTTON(By.xpath("//div[contains(text(),'Додати клуб')]")),
    ADD_CENTER_BUTTON(By.xpath("//ul[@classname='menu']//div[contains(text(),'Додати центр')]"));

    private final By path;

    AddDropDownComponentLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
