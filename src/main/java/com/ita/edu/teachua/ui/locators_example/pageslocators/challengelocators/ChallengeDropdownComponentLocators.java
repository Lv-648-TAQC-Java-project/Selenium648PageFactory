package com.ita.edu.teachua.ui.locators_example.pageslocators.challengelocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum ChallengeDropdownComponentLocators implements Locator {
    ;

    private final By path;

    ChallengeDropdownComponentLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
