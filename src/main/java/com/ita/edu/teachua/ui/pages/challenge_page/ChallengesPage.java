package com.ita.edu.teachua.ui.pages.challenge_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.locators.ChallengePageLocators.ChallengePageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ChallengesPage extends BasePage implements ChallengePage {

    @FindBy(how = How.XPATH, using = ChallengePageLocators.ADD_CHALLENGE)
    private Input addChallengeButton;

    public ChallengesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click add challenge button")
    public AddChallengePage goToAddChallengePage(){
        addChallengeButton.click();
        return new AddChallengePage(driver);
    }
    public ChallengesPage getChallengesPage(){
        return this;
    }
}
