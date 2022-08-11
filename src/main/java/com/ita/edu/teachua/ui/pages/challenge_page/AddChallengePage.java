package com.ita.edu.teachua.ui.pages.challenge_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.locators.ChallengePageLocators.ChallengePageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.File;

public class AddChallengePage extends BasePage implements ChallengePage {

    @FindBy(how = How.XPATH, using = ChallengePageLocators.ADD_CHALLENGE_SEQUENCE_NUMBER_FIELD)
    private Input sequenceNumberField;
    @FindBy(how = How.XPATH, using = ChallengePageLocators.ADD_CHALLENGE_NAME_FIELD)
    private Input nameField;
    @FindBy(how = How.XPATH, using = ChallengePageLocators.ADD_CHALLENGE_TITLE_FIELD)
    private Input titleField;
    @FindBy(how = How.XPATH, using = ChallengePageLocators.ADD_CHALLENGE_DESCRIPTION_FIELD)
    private Input descriptionField;
    @FindBy(how = How.XPATH, using = ChallengePageLocators.ADD_CHALLENGE_PHOTO_FIELD)
    private Input photoField;
    @FindBy(how = How.XPATH, using = ChallengePageLocators.ADD_CHALLENGE_SAVE_BUTTON)
    private Button saveButton;
    @FindBy(how = How.XPATH, using = ChallengePageLocators.ADD_CHALLENGE_INPUT_PHOTO_ID)
    private Input inputPhoto;
    @FindBy(how = How.XPATH, using = ChallengePageLocators.ADD_CHALLENGE_ALERT_MASSAGE)
    private Input errorMassage;


    public AddChallengePage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill sequence number field")
    public AddChallengePage fillSequenceNumberField(String number){
        sequenceNumberField.sendKeys(number);
        return this;
    }

    @Step("Clear sequence number field")
    public AddChallengePage clearSequenceNumberField(){
        sequenceNumberField.clear();
        return this;
    }

    @Step("Fill name field")
    public AddChallengePage fillNameField(String name){
        nameField.sendKeys(name);
        return this;
    }

    @Step("Clear name field")
    public AddChallengePage clearNameField(){
        nameField.clear();
        return this;
    }

    @Step("Fill title field")
    public AddChallengePage fillTitleField(String title){
        titleField.sendKeys(title);
        return this;
    }

    @Step("Fill description field")
    public AddChallengePage fillDescriptionField(String description){
        descriptionField.sendKeys(description);
        return this;
    }

    @Step("Clear description field")
    public AddChallengePage clearDescriptionField(){
        descriptionField.clear();
        return this;
    }

    @Step("Click save button")
    public AddChallengePage clickSaveChallengeButton(){
        saveButton.click();
        return this;
    }

    @Step("Click photo field")
    public AddChallengePage clickPhotoField(){
        photoField.click();
        return this;
    }

    @Step("Add image")
    public AddChallengePage addImage(File image){
        inputPhoto.sendKeys(image.getAbsolutePath());
        sleep(3000);
        return this;
    }

    @Step("Get error massage")
    public String getErrorMassage(){
        return errorMassage.getText();
    }

    @Step("Print numbers of symbols")
    public String printNumberOfSymbols(int number){
        String word = "";
        for (int i = 0 ; i < number ; i++){
        word = word + "a";
        }
        return word;
    }


    public AddChallengePage getAddChallengePage(){
        return this;
    }
}
