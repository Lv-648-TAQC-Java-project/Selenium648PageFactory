package com.ita.edu.teachua.ui.locators_example.pageslocators.aboutuslocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum AboutUsLocators implements Locator {
    ;

    private final By path;

    AboutUsLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
