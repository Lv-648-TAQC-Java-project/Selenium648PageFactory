package com.ita.edu.teachua.ui.locators.pages_locators.profile_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddLocationPopUpDynamicLabelsLocators {
    public WebElement byId(WebDriver driver, String id) {
        return driver.findElement(By.xpath(String.format("//input[contains(@id,'%s')]/ancestor::div[@class='ant-form-item-control-input']//span[@aria-label='check-circle']",id)));
    }
}