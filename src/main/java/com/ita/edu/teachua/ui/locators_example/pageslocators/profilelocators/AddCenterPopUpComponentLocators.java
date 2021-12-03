package com.ita.edu.teachua.ui.locators_example.pageslocators.profilelocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum AddCenterPopUpComponentLocators implements Locator {
    NAME_FIELD(By.id("basic_name")),
    ADD_LOCATION_BUTTON(By.className("add-club-location")),
    NEXT_STEP_BUTTON(By.cssSelector("button[class='ant-btn next-btn'] span")),
    PHONE_NUMBER_FIELD(By.id("contacts_contactТелефон")),
    DESCRIPTION_FIELD(By.id("basic_description")),
    FINISH_BUTTON(By.xpath("//button[@class='finish-btn']")),
    CENTER_NAME_INPUT(By.id("basic_name")),
    CENTER_NAME_ERROR_BLOCK(By.cssSelector("div[role='alert']"));
    private final By path;

    AddCenterPopUpComponentLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
