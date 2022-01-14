package com.ita.edu.teachua.cucumber.steps_definitions;



import com.ita.edu.teachua.ui.pages.AllPages;

import com.ita.edu.teachua.ui.pages.profile_page.AddLocationPopUpComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.testng.asserts.SoftAssert;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class CannotAddLocation  {
    private final BaseDefinition baseDef;
    private AllPages allPages;
    private SoftAssert softAssert;
    public CannotAddLocation(BaseDefinition baseDef) throws IOException {
       this.baseDef = baseDef;
       allPages = new AllPages(baseDef.getDriver());
       softAssert = new SoftAssert();
    }

    @Given("Log in as an Керівник email = {string}, password = {string}")
    public void logInAsAnКерівникEmailPassword(String email, String password) {
        allPages.getHeaderPage().authorize(email,password);
    }

    @Then("Go to the Додати центр")
    public void goToTheДодатиЦентр() {
        allPages.setCurrentComponent(allPages.getHeaderPage().clickOnOwnerDropdown().clickOnAddCenterButton());
    }

    @And("Click on Додати локацію button")
    public void clickOnДодатиЛокаціюButton() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        allPages.setCurrentComponent(
                allPages.getCurrentComponent()
                        .getClass()
                        .getMethod("clickOnAddLocationButton").
                        invoke(allPages.getCurrentComponent())
        );

    }

    @Then("Check if Додати локацію pop up is opened")
    public void checkIfДодатиЛокаціюPopUpIsOpened() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        softAssert.assertTrue(
                (Boolean) allPages.getCurrentComponent()
                        .getClass()
                        .getMethod("addLocationPopUpBlockIsDisplayed")
                        .invoke(allPages.getCurrentComponent())
        );
    }


    @And("Check if Додати button is disabled.")
    public void checkIfДодатиButtonIsDisabled() {
        softAssert.assertFalse(new AddLocationPopUpComponent(baseDef.getDriver())
                .checkAddButton());
        softAssert.assertAll();
    }



}
