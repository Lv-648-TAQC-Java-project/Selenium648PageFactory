package com.ita.edu.teachua.ui.pages.header_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.locators.header_locators.RestoringPasswordFinishPopUpLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Date;

public class RestoringPasswordFinishPopUpComponent extends BasePage {
    @FindBy(how = How.ID, using = RestoringPasswordFinishPopUpLocators.PASSWORD_FIELD_ID)
    private Input enterPassword;
    @FindBy(how = How.ID, using = RestoringPasswordFinishPopUpLocators.PASSWORD_CONFIRM_FIELD_ID)
    private Input reEnterPassword;
    @FindBy(how = How.XPATH, using = RestoringPasswordFinishPopUpLocators.CHANGE_PASSWORD_BUTTON_XPATH)
    private Button changePasswordButton;

    public RestoringPasswordFinishPopUpComponent(WebDriver driver) {
        super(driver);
    }


    @Step("Filling passwords fields by random valid values")
    public void setNewRandomPassword(){
        String newRandomPassword = String.format("Test_%d",new Date().getTime());
        enterPassword.set("");
        enterPassword.sendKeys(newRandomPassword);
        reEnterPassword.set("");
        reEnterPassword.sendKeys(newRandomPassword);
        changePasswordButton.click();
    }
}