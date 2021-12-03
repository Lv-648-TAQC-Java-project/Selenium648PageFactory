package com.ita.edu.teachua.ui.locators_example.pageslocators.clubslocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum ClubCardComponentLocators implements Locator {
    ;

    private final By path;

    ClubCardComponentLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
