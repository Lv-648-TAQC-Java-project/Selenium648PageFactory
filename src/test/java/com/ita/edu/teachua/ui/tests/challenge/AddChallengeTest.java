package com.ita.edu.teachua.ui.tests.challenge;

import com.ita.edu.teachua.ui.pages.challenge_page.AddChallengePage;
import com.ita.edu.teachua.ui.pages.header_page.HeaderPage;
import com.ita.edu.teachua.ui.tests.TestRunner;
import com.ita.edu.teachua.utils.jdbc.entity.ChallengesEntity;
import com.ita.edu.teachua.utils.jdbc.services.ChallengesServices;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AddChallengeTest extends TestRunner {

    static final String validChallengeName = "ваууууу";

    @Test(description = "Verify all fields on challenge page with valid data")
    public void canCreateChallengeWithValidData() {
        AddChallengePage addChallengePage = new AddChallengePage(driver);
        SoftAssert softAssert = new SoftAssert();
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .clickOnAdministrationButton()
                .clickOnChallengesButton()
                .clickAddChallengeButton()
                .fillSequenceNumberField("155")
                .fillNameField(validChallengeName)
                .fillTitleField("dksfkdjfskldf")
                .fillDescriptionField("qwertyuiopasdghjklzxcvbnmgqwerсtghyujkiol")
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        ChallengesServices challengesServices = new ChallengesServices();
        List<ChallengesEntity> allChallenge = challengesServices.getAll();
        softAssert.assertTrue(addChallengePage.findName(allChallenge, validChallengeName));
        challengesServices.deleteChallengesByName(validChallengeName);

    }

    @Test(description = "Verify sequence number fields on challenge page with invalid data")
    public void verifySequenceNumberFieldsWithInvalidData() {
        SoftAssert softAssert = new SoftAssert();
        AddChallengePage addChallengePage = new AddChallengePage(driver);
        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .clickOnAdministrationButton()
                .clickOnChallengesButton()
                .clickAddChallengeButton()
                .fillSequenceNumberField("0,3")
                .fillNameField("ваууууу")
                .fillTitleField("dksfkdjfskldf")
                .fillDescriptionField("qwertyuiopasdghjklzxcvbnmgqwerсtghyujkiol")
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        softAssert.assertEquals(addChallengePage.getErrorMassage(), "Це поле може містити лише унікальні цифри");

        addChallengePage
                .clearSequenceNumberField()
                .fillSequenceNumberField("-14")
                .clickSaveChallengeButton();
        softAssert.assertEquals(addChallengePage.getErrorMassage(), "Це поле може містити лише унікальні цифри");
    }

    @Test(description = "Verify name fields on challenge page with invalid data")
    public void verifyNameFieldsWithInvalidData() {
        SoftAssert softAssert = new SoftAssert();
        AddChallengePage addChallengePage = new AddChallengePage(driver);

        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .clickOnAdministrationButton()
                .clickOnChallengesButton()
                .clickAddChallengeButton()
                .fillSequenceNumberField("166")
                .fillNameField("")
                .fillTitleField("dksfkdjfskldf")
                .fillDescriptionField("qwertyuiopasdghjklzxcvbnmgqwerсtghyujkiol")
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        softAssert.assertEquals(addChallengePage.getErrorMassage(), "Поле ‘Назва Челенджу не може бути порожнім");

        addChallengePage
                .clearSequenceNumberField()
                .fillNameField("qwertyuiopasdghjklzxcvbnmgqwerс")
                .clickSaveChallengeButton();
        softAssert.assertEquals(addChallengePage.getErrorMassage(), "Назва Челенджу задовга");
    }

    @Test(description = "Verify description fields on challenge page with invalid data")
    public void verifyDescriptionFieldsWithInvalidData() {
        SoftAssert softAssert = new SoftAssert();
        AddChallengePage addChallengePage = new AddChallengePage(driver);

        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .clickOnAdministrationButton()
                .clickOnChallengesButton()
                .clickAddChallengeButton()
                .fillSequenceNumberField("1687")
                .fillNameField("ваууууу")
                .fillTitleField("dksfkdjfskldf")
                .fillDescriptionField("dfgdfg")
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        softAssert.assertEquals(addChallengePage.getErrorMassage(), "Опис Челенджу закороткий");

        addChallengePage
                .clearDescriptionField()
                .fillNameField(addChallengePage.printNumberOfSymbols(1501))
                .clickSaveChallengeButton();
        softAssert.assertEquals(addChallengePage.getErrorMassage(), "Опис Челенджу задовгий");
    }

    @Test(description = "Verify photo fields on challenge page with invalid data")
    public void verifyPhotoFieldsWithInvalidData() {
        AddChallengePage addChallengePage = new AddChallengePage(driver);
        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .clickOnAdministrationButton()
                .clickOnChallengesButton()
                .clickAddChallengeButton()
                .fillSequenceNumberField("169")
                .fillNameField("ваууууу")
                .fillTitleField("dksfkdjfskldf")
                .fillDescriptionField("dfgdfg")
                .clickSaveChallengeButton();
        Assert.assertEquals(addChallengePage.getErrorMassage(), "Ви не додали фото для завдання челенджу.");
    }
}
