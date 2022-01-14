package com.ita.edu.teachua.cucumber.steps_definitions;



import com.ita.edu.teachua.ui.pages.header_page.HeaderPage;
import com.ita.edu.teachua.ui.pages.profile_page.AddCenterPopUpComponent;
import com.ita.edu.teachua.ui.pages.profile_page.AddLocationPopUpComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.testng.asserts.SoftAssert;


import java.io.IOException;



public class CannotAddLocation  {
    private BaseDefinition baseDef;
    private Object obj;
    private SoftAssert softAssert;
    public CannotAddLocation(BaseDefinition baseDef) throws IOException {
       this.baseDef = baseDef;

    }

    @Given("Log in as an Керівник email = {string}, password = {string}")
    public void logInAsAnКерівникEmailPassword(String email, String password) {
        softAssert = new SoftAssert();
        HeaderPage header = new HeaderPage(baseDef.getDriver());
        obj = header
                .authorize(email, password);

    }

    @Then("Go to the Додати центр")
    public void goToTheДодатиЦентр() {
        obj = ((HeaderPage) obj).clickOnOwnerDropdown().clickOnAddCenterButton();
    }

    @And("Click on Додати локацію button")
    public void clickOnДодатиЛокаціюButton() {
        obj = ((AddCenterPopUpComponent) obj).clickOnAddLocationButton();

    }

    @Then("Check if Додати локацію pop up is opened")
    public void checkIfДодатиЛокаціюPopUpIsOpened() {
        softAssert.assertTrue(((AddLocationPopUpComponent) obj).addLocationPopUpBlockIsDisplayed());
    }


    @And("Check if Додати button is disabled.")
    public void checkIfДодатиButtonIsDisabled() {
        softAssert.assertFalse(new AddLocationPopUpComponent(baseDef.getDriver())
                .checkAddButton());
        softAssert.assertAll();
    }



}
