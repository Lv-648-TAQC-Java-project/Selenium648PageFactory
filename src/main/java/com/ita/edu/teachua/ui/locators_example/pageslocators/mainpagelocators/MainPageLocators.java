package com.ita.edu.teachua.ui.locators_example.pageslocators.mainpagelocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum MainPageLocators implements Locator {

    ADVANCED_SEARCH_BUTTON(By.xpath("//span[@title='Розширений пошук']")),
    SEARCH_INPUT_FIELD(By.cssSelector("input[id^='rc_select']")),
    CLUBS_LINK(By.xpath("//a[contains(text(),'Гуртки')]")),
    MAIN_PAGE_TITLE(By.xpath("//h2[contains(text(),'Ініціатива “Навчай українською”')]"));

    private final By path;

    MainPageLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }

}
