package com.ita.edu.teachua.ui.locators_example.pageslocators.profilelocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public class AddLocationPopUpDynamicLocators implements Locator {
    private By path;


    public AddLocationPopUpDynamicLocators byId(String id) {
        this.path = By.xpath(String.format("//input[contains(@id,'%s')]/ancestor::div[@class='ant-form-item-control-input']//span[@aria-label='check-circle']", id));
        return this;
    }

    @Override
    public By getPath() {
        return path;
    }
}