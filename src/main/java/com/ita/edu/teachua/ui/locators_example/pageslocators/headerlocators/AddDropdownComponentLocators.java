package com.ita.edu.teachua.ui.locators_example.pageslocators.headerlocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum AddDropdownComponentLocators implements Locator {


    ADD_CENTER_BUTTON(By.xpath("//ul[@classname='menu']//div[contains(text(),'Додати центр')]")),
    ADD_CLUB_BUTTON(By.xpath("//ul[@classname='menu']//div[contains(text(),'Додати гурток')]"));

    private final By path;

    AddDropdownComponentLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
