package com.ita.edu.teachua.cucumber.steps_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class ErrorMassagesAreShownForEmptyFields {
    private final BaseDefinition baseDef;
    private final PageContext pageContext;
    private final SoftAssert softAssert;

    public ErrorMassagesAreShownForEmptyFields(BaseDefinition baseDef) {
        this.baseDef = baseDef;
        pageContext = new PageContext(baseDef.getDriver());
        softAssert = new SoftAssert();
    }


    @Given("Go to registration page")
    public void goToRegistrationPage(){
        pageContext.getAllPages().getHeaderPage().goToOnGuestDropdown().clickOnRegisterButton()
                .getRegisterPopUpComponent();

    }

    @Then("Verify that {errorLastName} appear in last name field after fill {lastName} and clear")
    public void checkThatErrorMassageInLastNameFieldAreShown(String lastName , String errorLastName){
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().fillLastName(lastName);
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().clearLastNameField();
        softAssert.assertEquals(pageContext.getAllHeaderComponents().getRegisterPopUpComponent()
                .getErrorMassageLastNameField(),errorLastName);
    }

    @And("Verify that {errorFirstName} appear in first name field after fill {firstName} and clear")
    public void checkThatErrorMassageInFirstNameFieldAreShown(String firstName , String errorFirstName){
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().fillFirstName(firstName);
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().clearFirstNameField();
        softAssert.assertEquals(pageContext.getAllHeaderComponents().getRegisterPopUpComponent()
                .getErrorMassageFirstNameField(),errorFirstName);
    }


    @And("Verify that {errorPhone} appear in phone field after fill {validPhone} and clear")
    public void checkThatErrorMassageInPhoneFieldAreShown(String validPhone , String errorPhone){
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().fillPhoneNumber(validPhone);
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().clearPhoneField();
        softAssert.assertEquals(pageContext.getAllHeaderComponents().getRegisterPopUpComponent()
                .getErrorMassagePhoneField(),errorPhone);
    }

    @And("Verify that {errorEmail} appear in email field after fill {email} and clear")
    public void checkThatErrorMassageInEmailFieldAreShown(String email , String errorEmail){
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().fillEmail(email);
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().clearEmailField();
        softAssert.assertEquals(pageContext.getAllHeaderComponents().getRegisterPopUpComponent()
                .getErrorMassageEmailField(),errorEmail);
    }

    @And("Verify that {errorPassword} appear in password field after fill {password} and clear")
    public void checkThatErrorMassageInPasswordFieldAreShown(String password , String errorPassword){
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().fillPassword(password);
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().clearPasswordField();
        softAssert.assertEquals(pageContext.getAllHeaderComponents().getRegisterPopUpComponent()
                .getErrorMassagePasswordField(),errorPassword);
    }

    @And("Verify that {errorConfirmPassword} appear in confirm password field after fill {confirmPassword} and clear")
    public void checkThatErrorMassageInConfirmConfirmPasswordFieldAreShown(String confirmPassword , String errorConfirmPassword){
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().fillPasswordConfirm(confirmPassword);
        pageContext.getAllHeaderComponents().getRegisterPopUpComponent().clearPasswordConfirmField();
        softAssert.assertEquals(pageContext.getAllHeaderComponents().getRegisterPopUpComponent()
                .getErrorMassageConfirmPasswordField(),errorConfirmPassword);
    }
}
