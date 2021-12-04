package com.ita.edu.teachua.ui.locators_example.pageslocators.headerlocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum AddDropdownComponentLocators {


    public static final String ADD_CENTER_BUTTON_XPATH = "//ul[@classname='menu']//div[contains(text(),'Додати центр')]";
    ADD_CLUB_BUTTON(By.xpath("//ul[@classname='menu']//div[contains(text(),'Додати гурток')]"));


}
