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
    public Object[][] validChallenge() {
        ChallengeRepository challengeRepository = new ChallengeRepository();
        Object[][] data = new Object[][]{
                {UserRepository.get().adminUser(), challengeRepository.challengeWithValidData(), AddChallengePage.THIS_FIELD_CAN_CONTAIN_ONLY_UNIQUE_NUMBER_MASSAGE}};
        return data;
    }

    @Test(description = "Verify all fields on challenge page with valid data", dataProvider = "validChallenge")
    public void canCreateChallengeWithValidData(User adminUser, Challenge validChallenge, String expectedMassage) {
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
        Assert.assertTrue(addChallengePage.listContainName(allChallengesList(), validChallenge.getName()));
        Assert.assertNotEquals(addChallengePage.getMassage(), expectedMassage);
        deleteDataBaseRequest(validChallenge.getName());
    }

    @DataProvider(parallel = true)
    public Object[][] floatSequenceNumberChallenge() {
        ChallengeRepository challengeRepository = new ChallengeRepository();
        Object[][] data = new Object[][]{
                {UserRepository.get().adminUser(), challengeRepository.challengeWithInvalidFloatSequenceNumber(), AddChallengePage.THIS_FIELD_CAN_CONTAIN_ONLY_UNIQUE_NUMBER_MASSAGE}};
        return data;
    }

    @Test(description = "Verify sequence number fields on challenge page with invalid data", dataProvider = "floatSequenceNumberChallenge")
    public void verifySequenceNumberFieldsWithInvalidData(User adminUser, Challenge challenge, String expectedMassage) {
        AddChallengePage addChallengePage = runApplication()
                .authorize(adminUser)
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField(challenge.getSequenceNumber())
                .fillNameField(challenge.getName())
                .fillTitleField(challenge.getTitle())
                .fillDescriptionField(challenge.getDescription())
                .addImage(challenge.getPhoto())
                .clickSaveChallengeButton();
        Assert.assertEquals(addChallengePage.getMassage(), expectedMassage);
        deleteDataBaseRequest(challenge.getName());
    }

    @DataProvider(parallel = true)
    public Object[][] negativeSequenceNumberChallenge() {
        ChallengeRepository challengeRepository = new ChallengeRepository();
        Object[][] data = new Object[][]{
                {UserRepository.get().adminUser(), challengeRepository.challengeWithInvalidNegativeSequenceNumber(), AddChallengePage.THIS_FIELD_CAN_CONTAIN_ONLY_UNIQUE_NUMBER_MASSAGE}};
        return data;
    }

    @Test(description = "Verify sequence number fields on challenge page with invalid data", dataProvider = "negativeSequenceNumberChallenge")
    public void verifySequenceNumberFieldsWithNegativeData(User adminUser, Challenge challenge, String expectedMassage) {
        AddChallengePage addChallengePage = runApplication()
                .authorize(adminUser)
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField(challenge.getSequenceNumber())
                .fillNameField(challenge.getName())
                .fillTitleField(challenge.getTitle())
                .fillDescriptionField(challenge.getDescription())
                .addImage(challenge.getPhoto())
                .clickSaveChallengeButton();
        Assert.assertEquals(addChallengePage.getMassage(), expectedMassage);
        deleteDataBaseRequest(challenge.getName());
    }

    @DataProvider(parallel = true)
    public Object[][] challengeWithInvalidName() {
        ChallengeRepository challengeRepository = new ChallengeRepository();
        Object[][] data = new Object[][]{
                {UserRepository.get().adminUser(), challengeRepository.challengeWithEmptyName(), challengeRepository.challengeWithToLongName()
                        , AddChallengePage.THIS_FIELD_CANT_BE_EMPTY_MASSAGE , AddChallengePage.CHALLENGE_NAME_TO_LONG_MASSAGE}};
        return data;
    }

    @Test(description = "Verify name fields on challenge page with invalid data" , dataProvider = "challengeWithInvalidName")
    public void verifyNameFieldsWithInvalidData(User adminUser, Challenge challenge1 , Challenge challenge2, String expectedMassage1, String expectedMassage2) {
        AddChallengePage addChallengePage = runApplication()
                .authorize(adminUser)
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField(challenge1.getSequenceNumber())
                .fillNameField(challenge1.getName())
                .fillTitleField(challenge1.getTitle())
                .fillDescriptionField(challenge1.getDescription())
                .addImage(challenge1.getPhoto())
                .clickSaveChallengeButton();
        softAssert.assertEquals(addChallengePage.getMassage(), expectedMassage1);

        addChallengePage
                .waitThreeSecond()
                .clearNameField()
                .fillNameField(challenge2.getName())
                .clickSaveChallengeButton();
        softAssert.assertEquals(addChallengePage.getMassage(), expectedMassage2);
        softAssert.assertAll();
        softAssert = null;
    }

    @DataProvider(parallel = true)
    public Object[][] challengeWithInvalidDescription() {
        ChallengeRepository challengeRepository = new ChallengeRepository();
        Object[][] data = new Object[][]{
                {UserRepository.get().adminUser(), challengeRepository.challengeWithToShortDescription(), challengeRepository.challengeWithToLongDescription()
                        , AddChallengePage.CHALLENGE_DESCRIPTION_TO_SHORT_MASSAGE, AddChallengePage.CHALLENGE_DESCRIPTION_TO_LONG_MASSAGE}};
        return data;
    }

    @Test(description = "Verify description fields on challenge page with invalid data" , dataProvider = "challengeWithInvalidDescription" )
    public void verifyDescriptionFieldsWithInvalidData(User adminUser, Challenge challenge1 , Challenge challenge2, String expectedMassage1, String expectedMassage2) {
        AddChallengePage addChallengePage = runApplication()
                .authorize(adminUser)
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField(challenge1.getSequenceNumber())
                .fillNameField(challenge1.getName())
                .fillTitleField(challenge1.getTitle())
                .fillDescriptionField(challenge1.getDescription())
                .addImage(challenge1.getPhoto())
                .clickSaveChallengeButton();
        softAssert.assertEquals(addChallengePage.getMassage(), expectedMassage1);

        addChallengePage
                .waitThreeSecond()
                .clearDescriptionField()
                .fillDescriptionField(challenge2.getDescription())
                .clickSaveChallengeButton();
        softAssert.assertEquals(addChallengePage.getMassage(), expectedMassage2);
        softAssert.assertAll();
        softAssert = null;
    }

    @DataProvider(parallel = true)
    public Object[][] challengeWithoutPhoto() {
        ChallengeRepository challengeRepository = new ChallengeRepository();
        Object[][] data = new Object[][]{
                {UserRepository.get().adminUser(), challengeRepository.challengeWithoutPhoto(), AddChallengePage.YOU_DO_NOT_ADD_ANY_PHOTO_MASSAGE}};
        return data;
    }

    @Test(description = "Verify photo fields on challenge page with invalid data", dataProvider = "challengeWithoutPhoto")
    public void verifyPhotoFieldsWithInvalidData(User adminUser, Challenge challenge, String expectedMassage) {
        AddChallengePage addChallengePage = runApplication()
                .authorize(adminUser)
                .goToOwnerDropdown()
                .goToAdministrationDropDown()
                .goToChallengesPage()
                .goToAddChallengePage()
                .fillSequenceNumberField(challenge.getSequenceNumber())
                .fillNameField(challenge.getName())
                .fillTitleField(challenge.getTitle())
                .fillDescriptionField(challenge.getDescription())
                .clickSaveChallengeButton();
        Assert.assertEquals(addChallengePage.getMassage(), expectedMassage);
    }
}
