package com.ita.edu.teachua.ui.tests.challenge;

import com.ita.edu.teachua.data.challenges.Challenge;
import com.ita.edu.teachua.data.challenges.ChallengeRepository;
import com.ita.edu.teachua.ui.user.UserRepository;
import com.ita.edu.teachua.ui.pages.challenge_page.AddChallengePage;
import com.ita.edu.teachua.ui.tests.TestRunner;
import com.ita.edu.teachua.ui.user.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AddChallengeTest extends TestRunner {

    @DataProvider(parallel = true)
    public Object[][] data(){
        ChallengeRepository challengeRepository = new ChallengeRepository();
        Object[][] data = new Object[][]{
                {UserRepository.get().adminUser() , challengeRepository.challengeWithValidData() , AddChallengePage.THIS_FIELD_CAN_CONTAIN_ONLY_UNIQUE_NUMBER_MASSAGE}};
        return data;
    }


    @Test(description = "Verify all fields on challenge page with valid data" ,dataProvider = "data")
    public void canCreateChallengeWithValidData(User adminUser ,Challenge validChallenge ,String expectedMassage) {
        AddChallengePage addChallengePage = runApplication()
                .authorize(adminUser)
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField(validChallenge.getSequenceNumber())
                .fillNameField(validChallenge.getName())
                .fillTitleField(validChallenge.getTitle())
                .fillDescriptionField(validChallenge.getDescription())
                .addImage(validChallenge.getPhoto())
                .clickSaveChallengeButton();
        Assert.assertTrue(initPages().getChallengePage().listContainName(allChallengesList(), validChallenge.getName()));
        Assert.assertNotEquals(initPages().getChallengePage().getMassage(),expectedMassage );
        deleteDataBaseRequest(validChallenge.getName());
    }

//    @Test(description = "Verify sequence number fields on challenge page with invalid data")
//    public void verifySequenceNumberFieldsWithInvalidData() {
//        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
//                .goToOwnerDropdown()
//                .goToAdministrationDropDown()
//                .goToChallengesPage()
//                .goToAddChallengePage()
//                .fillSequenceNumberField(data.getFloatSequenceNumber())
//                .fillNameField(data.getValidChallengeName())
//                .fillTitleField(data.getValidTitle())
//                .fillDescriptionField(data.getValidDescription())
//                .addImage(testValueProvider.getImage())
//                .clickSaveChallengeButton();
//        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Це поле може містити лише унікальні цифри");
//
//        initPages().getChallengePage()
//                .clearSequenceNumberField()
//                .fillSequenceNumberField(data.getNegativeSequenceNumber())
//                .clickSaveChallengeButton();
//        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Це поле може містити лише унікальні цифри");
//        softAssert.assertAll();
//        softAssert = null;
//    }
//
//    @Test(description = "Verify name fields on challenge page with invalid data")
//    public void verifyNameFieldsWithInvalidData() {
//        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
//                .goToOwnerDropdown()
//                .goToAdministrationDropDown()
//                .goToChallengesPage()
//                .goToAddChallengePage()
//                .fillSequenceNumberField(data.getValidSequenceNumber())
//                .fillNameField(data.getEmptyNameField())
//                .fillTitleField(data.getValidTitle())
//                .fillDescriptionField(data.getValidDescription())
//                .addImage(testValueProvider.getImage())
//                .clickSaveChallengeButton();
//        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Поле ‘Назва Челенджу не може бути порожнім");
//
//        initPages().getChallengePage()
//                .clearSequenceNumberField()
//                .fillNameField(data.getToLongChallengeName())
//                .clickSaveChallengeButton();
//        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Назва Челенджу задовга");
//        softAssert.assertAll();
//        softAssert = null;
//    }
//
//    @Test(description = "Verify description fields on challenge page with invalid data")
//    public void verifyDescriptionFieldsWithInvalidData() {
//        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
//                .goToOwnerDropdown()
//                .goToAdministrationDropDown()
//                .goToChallengesPage()
//                .goToAddChallengePage()
//                .fillSequenceNumberField(data.getValidSequenceNumber())
//                .fillNameField(data.getValidChallengeName())
//                .fillTitleField(data.getValidTitle())
//                .fillDescriptionField(data.getToShortChallengeDescription())
//                .addImage(testValueProvider.getImage())
//                .clickSaveChallengeButton();
//        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Опис Челенджу закороткий");
//
//        initPages().getChallengePage()
//                .clearDescriptionField()
//                .fillDescriptionField(data.getToLongChallengeDescription())
//                .clickSaveChallengeButton();
//        softAssert.assertEquals(initPages().getChallengePage().getMassage(), "Опис Челенджу задовгий");
//        softAssert.assertAll();
//        softAssert = null;
//    }
//
//    @Test(description = "Verify photo fields on challenge page with invalid data")
//    public void verifyPhotoFieldsWithInvalidData() {
//        runApplication().authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
//                .goToOwnerDropdown()
//                .goToAdministrationDropDown()
//                .goToChallengesPage()
//                .goToAddChallengePage()
//                .fillSequenceNumberField(data.getValidSequenceNumber())
//                .fillNameField(data.getValidChallengeName())
//                .fillTitleField(data.getValidTitle())
//                .fillDescriptionField(data.getValidDescription())
//                .clickSaveChallengeButton();
//        Assert.assertEquals(initPages().getChallengePage().getMassage(), "Ви не додали фото для завдання челенджу.");
//    }
}
