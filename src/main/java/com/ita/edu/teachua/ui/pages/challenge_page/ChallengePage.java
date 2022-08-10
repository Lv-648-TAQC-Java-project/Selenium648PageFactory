package com.ita.edu.teachua.ui.pages.challenge_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.ChallengePageLocators.ChallengePageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChallengePage extends BasePage {

    @FindBy(how = How.XPATH, using = ChallengePageLocators.ADD_CHALLENGE)
    private Button addChallengeButton;

    public ChallengePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click add challenge button")
    public ChallengePage clickAddChallengeButton(){
        addChallengeButton.click();
        return this;
    }

    public ChallengePage getChallengePage(){
        return this;
    }
}
