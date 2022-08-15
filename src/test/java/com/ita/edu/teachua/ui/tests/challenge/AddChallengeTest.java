package com.ita.edu.teachua.ui.tests.challenge;

import com.ita.edu.teachua.ui.tests.TestRunner;
import com.ita.edu.teachua.utils.jdbc.entity.ChallengesEntity;
import com.ita.edu.teachua.utils.jdbc.services.ChallengesServices;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AddChallengeTest extends TestRunner {

    static final String validChallengeName = "ваууууу";
    static final String validDescription = "qwertyuiopasdghjklzxcvbnmgqwerсtghyujkiol";
    static final String validTitle = "dksfkdjfskldf";
    SoftAssert softAssert = new SoftAssert();



    @Test(description = "Verify all fields on challenge page with valid data")
    public void canCreateChallengeWithValidData() {
        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField("155")
                .fillNameField(validChallengeName)
                .fillTitleField(validTitle)
                .fillDescriptionField(validDescription)
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        ChallengesServices challengesServices = new ChallengesServices();
        List<ChallengesEntity> allChallenge = challengesServices.getAll();
        Assert.assertTrue(initPages().getChallengePage().findName(allChallenge, validChallengeName));
        challengesServices.deleteChallengesByName(validChallengeName);

    }

    @Test(description = "Verify sequence number fields on challenge page with invalid data")
    public void verifySequenceNumberFieldsWithInvalidData() {
        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField("0,4")
                .fillNameField(validChallengeName)
                .fillTitleField(validTitle)
                .fillDescriptionField(validDescription)
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getErrorMassage(), "Це поле може містити лише унікальні цифри");

        initPages().getChallengePage()
                .clearSequenceNumberField()
                .fillSequenceNumberField("-15")
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getErrorMassage(), "Це поле може містити лише унікальні цифри");
        softAssert.assertAll();
        softAssert = null;
    }

    @Test(description = "Verify name fields on challenge page with invalid data")
    public void verifyNameFieldsWithInvalidData() {
        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField("166")
                .fillNameField("")
                .fillTitleField(validTitle)
                .fillDescriptionField(validDescription)
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getErrorMassage(), "Поле ‘Назва Челенджу не може бути порожнім");

        initPages().getChallengePage()
                .clearSequenceNumberField()
                .fillNameField("qwertyuiopasdghjklzxcvbnmgqwerс")
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getErrorMassage(), "Назва Челенджу задовга");
        softAssert.assertAll();
        softAssert = null;
    }

    @Test(description = "Verify description fields on challenge page with invalid data")
    public void verifyDescriptionFieldsWithInvalidData() {
        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField("1687")
                .fillNameField(validChallengeName)
                .fillTitleField(validTitle)
                .fillDescriptionField("dfgdfg")
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getErrorMassage(), "Опис Челенджу закороткий");

        initPages().getChallengePage()
                .clearDescriptionField()
                .fillNameField(initPages().getChallengePage().printNumberOfSymbols(1501))
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getErrorMassage(), "Опис Челенджу задовгий");
        softAssert.assertAll();
        softAssert = null;
    }

    @Test(description = "Verify photo fields on challenge page with invalid data")
    public void verifyPhotoFieldsWithInvalidData() {
        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField("169")
                .fillNameField(validChallengeName)
                .fillTitleField(validTitle)
                .fillDescriptionField(validDescription)
                .clickSaveChallengeButton();
        Assert.assertEquals(initPages().getChallengePage().getErrorMassage(), "Ви не додали фото для завдання челенджу.");
    }
}
