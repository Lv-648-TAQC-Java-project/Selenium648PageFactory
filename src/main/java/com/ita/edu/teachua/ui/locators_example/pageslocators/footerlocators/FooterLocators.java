package com.ita.edu.teachua.ui.locators_example.pageslocators.footerlocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum FooterLocators implements Locator {
    ;

    private final By path;

    FooterLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
