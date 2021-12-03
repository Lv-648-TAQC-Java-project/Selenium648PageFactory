package com.ita.edu.teachua.ui.locators_example.pageslocators.headerlocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum RestoringPasswordPopUpLocators implements Locator {
    PASSWORD_FIELD(By.id("edit_password")),
    PASSWORD_CONFIRM_FIELD(By.id("edit_new-password")),
    CHANGE_PASSWORD_BUTTON(By.xpath("//button[@type='submit']/span[contains(text(),'Змінити пароль')]"));

    private final By path;

    RestoringPasswordPopUpLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
