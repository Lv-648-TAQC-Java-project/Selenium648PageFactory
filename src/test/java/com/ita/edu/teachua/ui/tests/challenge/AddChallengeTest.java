package com.ita.edu.teachua.ui.tests.challenge;

import com.ita.edu.teachua.testdata.ChallengeData;
import com.ita.edu.teachua.ui.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AddChallengeTest extends TestRunner {

    ChallengeData data = new ChallengeData();
    SoftAssert softAssert = new SoftAssert();



    @Test(description = "Verify all fields on challenge page with valid data")
    public void canCreateChallengeWithValidData() {
        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField(data.getValidSequenceNumber())
                .fillNameField(data.getValidChallengeName())
                .fillTitleField(data.getValidTitle())
                .fillDescriptionField(data.getValidDescription())
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        Assert.assertTrue(initPages().getChallengePage().listContainName(allChallengesList(), data.getValidChallengeName()));
        Assert.assertNotEquals(initPages().getChallengePage().getMassage(),"Це поле може містити лише унікальні цифри");
    deleteDataBaseRequest(data.getValidChallengeName());
    }

    @Test(description = "Verify sequence number fields on challenge page with invalid data")
    public void verifySequenceNumberFieldsWithInvalidData() {
        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField(data.getFloatSequenceNumber())
                .fillNameField(data.getValidChallengeName())
                .fillTitleField(data.getValidTitle())
                .fillDescriptionField(data.getValidDescription())
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Це поле може містити лише унікальні цифри");

        initPages().getChallengePage()
                .clearSequenceNumberField()
                .fillSequenceNumberField(data.getNegativeSequenceNumber())
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Це поле може містити лише унікальні цифри");
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
                .fillSequenceNumberField(data.getValidSequenceNumber())
                .fillNameField(data.getEmptyNameField())
                .fillTitleField(data.getValidTitle())
                .fillDescriptionField(data.getValidDescription())
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Поле ‘Назва Челенджу не може бути порожнім");

        initPages().getChallengePage()
                .clearSequenceNumberField()
                .fillNameField(data.getToLongChallengeName())
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Назва Челенджу задовга");
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
                .fillSequenceNumberField(data.getValidSequenceNumber())
                .fillNameField(data.getValidChallengeName())
                .fillTitleField(data.getValidTitle())
                .fillDescriptionField(data.getToShortChallengeDescription())
                .addImage(testValueProvider.getImage())
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Опис Челенджу закороткий");

        initPages().getChallengePage()
                .clearDescriptionField()
                .fillDescriptionField(data.getToLongChallengeDescription())
                .clickSaveChallengeButton();
        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Опис Челенджу задовгий");
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
                .fillSequenceNumberField(data.getValidSequenceNumber())
                .fillNameField(data.getValidChallengeName())
                .fillTitleField(data.getValidTitle())
                .fillDescriptionField(data.getValidDescription())
                .clickSaveChallengeButton();
        Assert.assertEquals(initPages().getChallengePage().getMassage(), "Ви не додали фото для завдання челенджу.");
    }
}
