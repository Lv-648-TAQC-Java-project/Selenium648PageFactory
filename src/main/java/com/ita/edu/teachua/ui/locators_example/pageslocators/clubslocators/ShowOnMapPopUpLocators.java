package com.ita.edu.teachua.ui.locators_example.pageslocators.clubslocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum ShowOnMapPopUpLocators implements Locator {
    ;
    private final By path;

    ShowOnMapPopUpLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
