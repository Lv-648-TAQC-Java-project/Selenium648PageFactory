package com.ita.edu.teachua.ui.locators_example.pageslocators.profilelocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum ProfileEditPopUpLocators implements Locator {
    PHONE_EDIT(By.xpath("//input[@id='edit_phone']")),
    LASTNAME_EDIT(By.xpath("//input[@id='edit_lastName']")),
    SAVE_BUTTON(By.xpath("//input[@id='edit_lastName']")),
    FIRSTNAME_EDIT(By.xpath("//input[@id='edit_firstName']")),
    PASSWORD_EDIT_CHECKBOX(By.xpath("//input[@class='checkbox']")),
    SAVE_CHANGE_BUTTON(By.xpath("//button[@class='ant-btn submit-button']")),
    CURRENT_PASSWORD_ERROR_MESSAGE(By.xpath("//*[@id='edit_currentPassword']/following::div[@class='ant-form-item-explain-error']")),
    NEW_PASSWORD_ERROR_MESSAGE(By.xpath("//*[@id='edit_password']/following::div[@class='ant-form-item-explain-error']")),
    CONFIRM_PASSWORD_ERROR_MESSAGE(By.xpath("//*[@id='edit_confirmPassword']/following::div[@class='ant-form-item-explain-error']")),
    CURRENT_PASSWORD_INPUT(By.xpath("//*[@id='edit_currentPassword']")),
    NEW_PASSWORD_INPUT(By.xpath("//*[@id='edit_password']")),
    CONFIRM_PASSWORD_INPUT(By.xpath("//*[@id='edit_confirmPassword']")),
    MESSAGE_INVALID_INPUT(By.xpath("//div[@role='alert']"));



    private final By path;

    ProfileEditPopUpLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}

