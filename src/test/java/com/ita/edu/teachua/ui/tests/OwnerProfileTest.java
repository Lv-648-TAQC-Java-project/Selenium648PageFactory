package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.elements.custom_elements.Title;
import com.ita.edu.teachua.ui.pages.header_page.HeaderPage;
import com.ita.edu.teachua.ui.pages.header_page.RegisterPopUpComponent;
import com.ita.edu.teachua.ui.pages.profile_page.AddClubPopUpComponent;
import com.ita.edu.teachua.ui.pages.profile_page.AddLocationPopUpComponent;
import com.ita.edu.teachua.ui.pages.profile_page.ProfileEditPopUpComponent;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OwnerProfileTest extends TestRunner {
    @DataProvider
    public Object[][] phoneDataProvider() {
        return new Object[][]{
                {"6895", "Телефон не відповідає вказаному формату",
                        "65987458", "Телефон не відповідає вказаному формату",
                        "6593859632586", "Телефон не відповідає вказаному формату",
                        "jngeoлщшогнеп", "Телефон не може містити літери",
                        "!96397180", "Телефон не відповідає вказаному формату",
                        "@96397180", "Телефон не відповідає вказаному формату",
                        "#96397180", "Телефон не відповідає вказаному формату",
                        "$96397180", "Телефон не відповідає вказаному формату",
                        "%96397180", "Телефон не відповідає вказаному формату",
                        "^96397180", "Телефон не відповідає вказаному формату",
                        "&96397180", "Телефон не відповідає вказаному формату",
                        "*96397180", "Телефон не відповідає вказаному формату",
                        "(96397180", "Телефон не відповідає вказаному формату",
                        "_96397180", "Телефон не відповідає вказаному формату",
                        "+96397180", "Телефон не відповідає вказаному формату",
                        ".96397180", "Телефон не відповідає вказаному формату",
                        ":96397180", "Телефон не відповідає вказаному формату",
                        "", "Будь ласка введіть Ваш номер телефону"}
        };
    }

    @Test(dataProvider = "phoneDataProvider")
    public void TestUserCheckInvalidDataForFieldPhone(String[] dataAndExpected) {
        HeaderPage profile = new HeaderPage(driver);
        ProfileEditPopUpComponent edit = profile
                .authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickEditProfile();
        SoftAssert softAssert=new SoftAssert();
        for (int i = 0; i < dataAndExpected.length; i += 2) {
            String actual = edit
                    .fillPhone(dataAndExpected[i])
                    .getMessage();


            softAssert.assertEquals(dataAndExpected[i + 1], actual);
        }
        softAssert.assertAll();
    }

    @Test(description = "TUA-160 This test case verifies that a 'Керівник' cannot add a location to the list of locations after leaving all mandatory and optional fields empty")
    public void VerifyThatOwnerCannotAddLocationToTheListOfLocationsAfterLeavingFieldsEmpty() {
        HeaderPage header = new HeaderPage(driver);
        boolean addLocationPopUpBlockIsDisplayed = header
                .authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnAddCenterButton()
                .clickOnAddLocation()
                .addLocationPopUpBlockIsDisplayed();// check first expected condition
        Assert.assertTrue(addLocationPopUpBlockIsDisplayed);

        boolean addLocationButtonEnable = new AddLocationPopUpComponent(driver)
                .checkAddButton(); // check last expected condition

        Assert.assertFalse(addLocationButtonEnable);

    }

    @DataProvider
    public Object[][] addClubPopUpComponentData() {
        return new Object[][]{
                {"ValidName2",
                        "2",
                        "18",
                        "ValidAddress",
                        "49.829104498711104, 24.005058710351314",
                        "0966666666",
                        "example@email.com",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                        "name,cityName,districtName,stationName,address,coordinates,phone",
                        "basic_contactТелефон,basic_contactFacebook,basic_contactWhatsApp,basic_contactПошта,basic_contactSkype,basic_contactSite"
                }
        };
    }

    @Test(dataProvider = "addClubPopUpComponentData", description = "TUA-237 This test case verifies that a 'Керівник' can add a location of a club that doesn't refer to any center after filling in mandatory fields with valid data.")
    public void VerifyThatOwnerCanAddLocationOfClub(String validName,
                                                    String ageFrom,
                                                    String ageTo,
                                                    String validAddress,
                                                    String validCoordinates,
                                                    String validPhone,
                                                    String validEmail,
                                                    String descriptionText,
                                                    String addLocationPopUpComponentId,
                                                    String addClubPopUpComponentId) {
        String[] locationPopUpComponentId = addLocationPopUpComponentId.split(",");
        String[] clubPopUpComponentId = addClubPopUpComponentId.split(",");
        SoftAssert softAssert = new SoftAssert();
        AddLocationPopUpComponent addLocationPopUpComponent = new HeaderPage(driver)
                .authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickOnAddButton()
                .clickOnAddClubButton()
                .fillClubNameField(validName)
                .chooseSportSections()
                .fillChildAge(ageFrom, ageTo)
                .clickOnNextStepButton()
                .clickOnAddLocation();
        boolean addLocationPopUpBlockIsDisplayed = addLocationPopUpComponent
                .addLocationPopUpBlockIsDisplayed();
        softAssert.assertTrue(addLocationPopUpBlockIsDisplayed);


        boolean isDataAccepted = addLocationPopUpComponent
                .clickOnLocationNameField()
                .sendKeysLocationNameField(validName)
                .isDataAccepted(locationPopUpComponentId[0]);
        softAssert.assertTrue(isDataAccepted);

        isDataAccepted = addLocationPopUpComponent
                .clickOnCityDropdown()
                .clickOnKyivButton()
                .isDataAccepted(locationPopUpComponentId[1]);
        softAssert.assertTrue(isDataAccepted);

        isDataAccepted = addLocationPopUpComponent.clickOnDistrictDropdown()
                .clickOnDesnianskyiButton()
                .isDataAccepted(locationPopUpComponentId[2]);
        softAssert.assertTrue(isDataAccepted);

        isDataAccepted = addLocationPopUpComponent
                .clickOnLocalityDropdown()
                .clickOnAkademmistechkoButton()
                .isDataAccepted(locationPopUpComponentId[3]);
        softAssert.assertTrue(isDataAccepted);

        isDataAccepted = addLocationPopUpComponent
                .clickOnAddressField()
                .sendKeysAddressField(validAddress)
                .isDataAccepted(locationPopUpComponentId[4]);
        softAssert.assertTrue(isDataAccepted);

        isDataAccepted = addLocationPopUpComponent
                .clickOnCoordinatesField()
                .sendKeysCoordinatesField(validCoordinates)
                .isDataAccepted(locationPopUpComponentId[5]);
        softAssert.assertTrue(isDataAccepted);

        isDataAccepted = addLocationPopUpComponent
                .clickOnPhoneField()
                .sendKeysPhoneField(validPhone)
                .isDataAccepted(locationPopUpComponentId[6]);
        softAssert.assertTrue(isDataAccepted);

        AddClubPopUpComponent addClubPopUpComponent = addLocationPopUpComponent
                .clickOnAddButtonToClubPopUp();
        Title addedLoactionTitle = addClubPopUpComponent
                .getAddedLocationTitle();
        softAssert.assertTrue(addedLoactionTitle.isDisplayed());


        isDataAccepted = addClubPopUpComponent
                .enterValidTelephoneNumber(validPhone)
                .isDataAccepted(clubPopUpComponentId[0]);
        softAssert.assertTrue(isDataAccepted);
        isDataAccepted = addClubPopUpComponent
                .enterValidFacebook(validName)
                .isDataAccepted(clubPopUpComponentId[1]);
        softAssert.assertTrue(isDataAccepted);
        isDataAccepted = addClubPopUpComponent
                .enterValidWhatsApp(validName)
                .isDataAccepted(clubPopUpComponentId[2]);
        softAssert.assertTrue(isDataAccepted);
        isDataAccepted = addClubPopUpComponent
                .enterValidEmail(validEmail)
                .isDataAccepted(clubPopUpComponentId[3]);
        softAssert.assertTrue(isDataAccepted);
        isDataAccepted = addClubPopUpComponent
                .enterValidSkype(validName)
                .isDataAccepted(clubPopUpComponentId[4]);
        softAssert.assertTrue(isDataAccepted);
        isDataAccepted = addClubPopUpComponent
                .enterValidSite(validName)
                .isDataAccepted(clubPopUpComponentId[5]);
        softAssert.assertTrue(isDataAccepted);
        addClubPopUpComponent
                .clickOnNextStepButton()
                .inputInDescriptionField(descriptionText)
                .clickOnCompleteButton();

        softAssert.assertAll();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*Title addedLoactionTitle = addLocationPopUpComponent
                .clickOnAddButtonToClubPopUp()
                .getAddedLocationTitle();*/
    }

    @Test(description = "TUA-252 This test case verifies that user cannot create a center with invalid data in 'Назва' field")
    public void VerifyThatErrorMessagesIsDisplayedAfterUserLeavesFieldsEmptyAndClicksNextStepButton() {
        boolean errorsIsDisplayed = new HeaderPage(driver)
                .authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickOnAddButton()
                .clickOnAddCenterButton()
                .clearCenterName()
                .clickOnNextStepButton()
                .errorsIsDisplayed();
        Assert.assertTrue(errorsIsDisplayed);

    }

    @Test(description = "Implement TUA-158 Verify that a 'Керівник' can add location to the " +
            "list of locations after filling in all mandatory and all optional fields with valid data")
    public void testAddLocationByOwner() {
        HeaderPage header = new HeaderPage(driver);
        boolean actual = header.authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnAddCenterButton()
                .clickOnAddLocation()
                .clickOnLocationNameField()
                .sendKeysLocationNameField("LocationTestName")
                .clickOnCityDropdown()
                .clickOnKyivButton()
                .clickOnDistrictDropdown()
                .clickOnDesnianskyiButton()
                .clickOnLocalityDropdown()
                .clickOnAkademmistechkoButton()
                .sendKeysAddressField("SomeAddress")
                .sendKeysCoordinatesField("50.46403522497495, 30.36469393119765")
                .sendKeysPhoneField("0432143210")
                .clickOnAddButtonToCenterPopUp()
                .getCheckBoxByName("LocationTestName")
                .isDisplayed();
        Assert.assertTrue(actual);
    }

    @Test(description = "UA-214 [Center] Verify that user can create a center with valid data")
    public void testAddLocationFromProfilePage() {
        HeaderPage header = new HeaderPage(driver);// TODO create dropDown element from profile page
        header.authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnAddCenterButton()
                .clickOnAddLocation()
                .clickOnLocationNameField()
                .sendKeysLocationNameField("LocationTestName")
                .clickOnCityDropdown()
                .clickOnKyivButton()
                .clickOnDistrictDropdown()
                .clickOnDesnianskyiButton()
                .clickOnLocalityDropdown()
                .clickOnAkademmistechkoButton()
                .clickOnAddressField()
                .sendKeysAddressField("SomeAddress")
                .clickOnCoordinatesField()
                .sendKeysCoordinatesField("50.46403522497495, 30.36469393119765")
                .clickOnPhoneField()
                .sendKeysPhoneField("0432143210")
                .clickOnAddButtonToCenterPopUp();
    }

    @Test(description = "TUA-321 Verify if error message is displayed after inputting invalid data for recover or change the password.")
    public void testPasswordRecovery() {
        HeaderPage header = new HeaderPage(driver);
        header.clickOnGuestDropdown();
    }

    @DataProvider
    public Object[][] verifyThatOwnerCanAddLocationToTheListOfLocationsWithValidDataDataProvider() {
        return new Object[][]{
                {"ТестЛокація2", "Харків", "Сумська 2/3", "50.00100346155677, 36.234188917163884", "0977777777"}
        };
    }


    @Test(dataProvider = "verifyThatOwnerCanAddLocationToTheListOfLocationsWithValidDataDataProvider", description = "TUA-159")
    public void addLocationWithValidDataOfMandatoryFields(String name, String town, String address, String coordinates, String phoneNumber) {
        boolean actualResult = new HeaderPage(driver).authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickOnAddButton()
                .clickOnAddCenterButton()
                .clickOnAddLocation()
                .sendKeysLocationNameField(name)
                .clickOnCityDropdown()
                .clickOnKyivButton()
                .sendKeysAddressField(address)
                .sendKeysCoordinatesField(coordinates)
                .sendKeysPhoneField(phoneNumber)
                .clickOnAddButtonToCenterPopUp()
                .getCheckBoxByName(name)
                .isDisplayed();
        Assert.assertTrue(actualResult, "Location was not create");
    }

    @Test
    public void checkLastVerifyEnteredDataInRegistrationRemembered() {
        HeaderPage header = new HeaderPage(driver);
        RegisterPopUpComponent registerCheck = header.clickOnGuestDropdown()
                .clickOnRegisterButton()
                .clickLastNameField()
                .fillLastName("Вайтович")
                .clickFirstNameField()
                .fillFirstName("Світлана")
                .clickPhoneNumberField()
                .fillPhoneNumber("0671234567")
                .clickEmailField()
                .fillEmail("svitlanawhite@gmail.com")
                .clickPasswordField()
                .fillPassword("12345678")
                .clickPasswordConfirmField()
                .fillPasswordConfirm("12345678")
                .clickCloseButton()
                .clickOnGuestDropdown()
                .clickOnRegisterButton();
        String actual1 = registerCheck.getLastNameText();
        String actual2 = registerCheck.getFirstNameText();
        String actual3 = registerCheck.getEmailText();
        String actual4 = registerCheck.getPasswordText();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actual1, "Вайтович");
        softassert.assertEquals(actual2, "Світлана");
        softassert.assertEquals(actual3, "svitlanawhite@gmail.com");
        softassert.assertEquals(actual4, "12345678");


    }

    @DataProvider
    public Object[][] lastNameDataProvider() {
        return new Object[][]{
                {"AfBbCcDdEeFfGgHhIiJjKkLlMmNn", "Прізвище не може містити більше, ніж 25 символів",
                        "AfBbCcDdEeFfGgHhIiJjKkLlMm", "Прізвище не може містити більше, ніж 25 символів",
                        "1Admin", "Прізвище не може містити цифри",
                        "2Admin", "Прізвище не може містити цифри",
                        "3Admin", "Прізвище не може містити цифри",
                        "4Admin", "Прізвище не може містити цифри",
                        "-Lastname", "Прізвище повинно починатися і закінчуватися літерою",
                        "< Lastname>", "Прізвище не може містити спеціальні символи",
                        "\'Lastname", "Прізвище повинно починатися і закінчуватися літерою",
                        "Lastname-", "Прізвище повинно починатися і закінчуватися літерою",
                        "<Lastname >", "Прізвище не може містити спеціальні символи",
                        "Lastname\'", "Прізвище повинно починатися і закінчуватися літерою",
                        "!Admin", "Прізвище не може містити спеціальні символи",
                        "@Admin", "Прізвище не може містити спеціальні символи",
                        "#Admin", "Прізвище не може містити спеціальні символи",
                        "$Admin", "Прізвище не може містити спеціальні символи",
                        "%Admin", "Прізвище не може містити спеціальні символи",
                        "^Admin", "Прізвище не може містити спеціальні символи",
                        "&Admin", "Прізвище не може містити спеціальні символи",
                        "*Admin", "Прізвище не може містити спеціальні символи",
                        "(Admin", "Прізвище не може містити спеціальні символи",
                        "_Admin", "Прізвище не може містити спеціальні символи",
                        "+Admin", "Прізвище не може містити спеціальні символи",
                        ".Admin", "Прізвище не може містити спеціальні символи",
                        ":Admin", "Прізвище не може містити спеціальні символи",
                        "", "Будь ласка введіть Ваше прізвище"}
        };
    }

    @Test(dataProvider = "lastNameDataProvider")
    public void checkErrorMsWhenFillInvalidDataIntoLastNameField(String[] dataAndExpected) {
        HeaderPage profile = new HeaderPage(driver);
        ProfileEditPopUpComponent edit = profile
                .authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickEditProfile();
        SoftAssert softAssert=new SoftAssert();
        for (int i = 0; i < dataAndExpected.length; i += 2) {
            edit = edit.fillLastName(dataAndExpected[i]);
            softAssert.assertEquals(dataAndExpected[i + 1], edit.getMessage());
        }
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] firstNameDataProvider() {
        return new Object[][]{
                {"AfBbCcDdEeFfGgHhIiJjKkLlMmNn", "Ім'я не може містити більше, ніж 25 символів",
                        "AfBbCcDdEeFfGgHhIiJjKkLlMm", "Ім'я не може містити більше, ніж 25 символів",
                        "", "Будь ласка введіть Ваше ім'я",
                        "1Admin", "Ім'я не може містити цифри",
                        "2Admin", "Ім'я не може містити цифри",
                        "3Admin", "Ім'я не може містити цифри",
                        "4Admin", "Ім'я не може містити цифри",
                        "-Name", "Ім'я повинно починатися і закінчуватися літерою",
                        "< Name>", "Ім'я не може містити спеціальні символи",
                        "\'Name", "Ім'я повинно починатися і закінчуватися літерою",
                        "Name-", "Ім'я повинно починатися і закінчуватися літерою",
                        "<Name >", "Ім'я не може містити спеціальні символи",
                        "Name\'", "Ім'я повинно починатися і закінчуватися літерою",
                        "!Admin", "Ім'я не може містити спеціальні символи",
                        "@Admin", "Ім'я не може містити спеціальні символи",
                        "#Admin", "Ім'я не може містити спеціальні символи",
                        "$Admin", "Ім'я не може містити спеціальні символи",
                        "%Admin", "Ім'я не може містити спеціальні символи",
                        "^Admin", "Ім'я не може містити спеціальні символи",
                        "&Admin", "Ім'я не може містити спеціальні символи",
                        "*Admin", "Ім'я не може містити спеціальні символи",
                        "(Admin", "Ім'я не може містити спеціальні символи",
                        "_Admin", "Ім'я не може містити спеціальні символи",
                        "+Admin", "Ім'я не може містити спеціальні символи",
                        ".Admin", "Ім'я не може містити спеціальні символи",
                        ":Admin", "Ім'я не може містити спеціальні символи",
                        "", "Будь ласка введіть Ваше ім'я"}
        };
    }

    @Test(dataProvider = "firstNameDataProvider")
    public void checkErrorMsWhenFillInvalidDataIntoFirstNameField(String dataAndExpected[]) {
        HeaderPage profile = new HeaderPage(driver);
        ProfileEditPopUpComponent edit = profile
                .authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickEditProfile();
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < dataAndExpected.length; i += 2) {
            edit = edit.fillFirstName(dataAndExpected[i]);
            softAssert.assertEquals(dataAndExpected[i + 1], edit.getMessage());
        }
        softAssert.assertAll();

    }

    @Test(description = "TUA-359 Verify that error messages are shown while leaving empty any field in the 'Змінити пароль' pop-up")
    public void getErrorMessageInChangePasswordPopUpTest() {
        HeaderPage headerPage = new HeaderPage(driver);
        ProfileEditPopUpComponent editProfile = new ProfileEditPopUpComponent(driver);
        SoftAssert softAssert = new SoftAssert();
        headerPage.authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickEditProfile()
                .clickOnChangePasswordCheckBox()
                .fillInCurrentPasswordInput(valueProvider.getAdminPassword())
                .fillInNewPasswordInput("NewPassword101!")
                .fillInConfirmPasswordInput("")
                .clickOnSaveChangeButton();
        softAssert.assertEquals(editProfile.getErrorMessageConfirmPasswordInput(), "Будь ласка, підтвердіть пароль");
        softAssert.assertEquals(editProfile.getConfirmPasswordInputBorderColor(), "rgb(255, 77, 79)", "Confirm password input isn't red");
        editProfile.fillInCurrentPasswordInput("")
                .fillInNewPasswordInput("NewPassword101!")
                .fillInConfirmPasswordInput("NewPassword101!")
                .clickOnSaveChangeButton();
        softAssert.assertEquals(editProfile.getErrorMessageCurrentPasswordInput(), "Введіть старий пароль");
        softAssert.assertEquals(editProfile.getCurrentPasswordInputBorderColor(), "rgb(255, 77, 79)", "Current password input isn't red");
        editProfile.fillInCurrentPasswordInput(valueProvider.getAdminPassword())
                .fillInNewPasswordInput("")
                .fillInConfirmPasswordInput("NewPassword101!")
                .clickOnSaveChangeButton();
        softAssert.assertEquals(editProfile.getErrorMessageNewPasswordInput(), "Будь ласка, введіть новий пароль");
        softAssert.assertEquals(editProfile.getNewPasswordInputBorderColor(), "rgb(255, 77, 79)", "New password input isn't red");
        softAssert.assertAll();
    }

    /**
     * 173-Verify that the ‘Опис’ text field is filled in with valid data
     **/
    @DataProvider
    public Object[][] specialCharactersData() {
        return new Object[][]{
                {"Education, students, Школа балетуee and so ", //Urk and Eng letters
                        "12345678901234567890123456789012345678656",   //numbers
                        "!#$%&'()*+,-./:;<=>?@[]^_`{}~^&^%%^&***#"},   //special symbols
        };
    }

    @Test(dataProvider = "specialCharactersData")
    public void checkDescriptionFieldWithValidLettersAndSymbols(String[] input) {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage
                .authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickOnAddButton()
                .clickOnAddClubButton()
                .enterNameOfClub("Танці, хореографія")
                .clickOnDancesCheckbox()
                .hoverToElement("basic_ageFrom")
                .severalClicksOnFromAgeUpperArrow()
                .hoverToElement("basic_ageTo")
                .severalClicksOnAgeToUpperArrow()
                .clickOnNextStepButton()
                .enterValidTelephoneNumber("9632548777")
                .clickOnNextStepButton();
        SoftAssert softAssert = new SoftAssert();
        for (String data : input) {
            boolean checkDescriptionFiledWithDifferentSymbols = new AddClubPopUpComponent(driver)
                    .inputInDescriptionField(data)
                    .getTick().isDisplayed();
            softAssert.assertTrue(checkDescriptionFiledWithDifferentSymbols, "field is NOT valid");
        }
        softAssert.assertAll();
    }

    /**
     * 176-Verify that error message ‘Опис гуртка закороткий’ appears when the user enters less than 40 symbols into the field
     **/
    @DataProvider
    public Object[][] lessThan40SymbolsData() {
        return new Object[][]{
                {"Also known as the Mo", //20 symbols
                        "1", //1 symbol
                        "Also known as the Monastery of the ghfg"} //39 symbols
        };
    }

    @Test(dataProvider = "lessThan40SymbolsData")
    public void checkDescriptionFieldWithLessThan40Symbols(String[] input) {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage
                .authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickOnAddButton()
                .clickOnAddClubButton()
                .enterNameOfClub("Танці, хореографія")
                .clickOnDancesCheckbox()
                .hoverToElement("basic_ageFrom")
                .severalClicksOnFromAgeUpperArrow()
                .hoverToElement("basic_ageTo")
                .severalClicksOnAgeToUpperArrow()
                .clickOnNextStepButton()
                .enterValidTelephoneNumber("9632548777")
                .clickOnNextStepButton();
        SoftAssert softAssert = new SoftAssert();
        for (String data : input) {
            String checkDescriptionFiledWithLessThan40Symbols = new AddClubPopUpComponent(driver)
                    .inputInDescriptionField(data)
                    .getError().getText();
            softAssert.assertEquals(checkDescriptionFiledWithLessThan40Symbols, "Некоректний опис гуртка\n" + "Опис гуртка може містити від 40 до 1500 символів.");
        }
        softAssert.assertAll();
    }


    /**
     * 177-Verify that error message ‘Опис гуртка задовгий’ appears when the user enters more than 1500 symbols into the field
     **/
    @DataProvider
    public Object[][] lessAndMoreThan1500data() {
        return new Object[][]{
                {"Also known as the Monastery of the Caves, Pechersk Lavra is a historic Orthodox Christian monastery which gave its name to one of the biggest districts in Kiev. This incredibly beautiful complex started as a cave monastery nearly 1,000 years ago.\n" +
                        "Interestingly, while being a major tourist attraction in Kiev, Pechersk Lavra is also an active monastery, which means that over 100 monks live there. There are several churches within the complex, while a part of the monastery serves as a museum, where you can find many architectural relics of the past.Locally known as Maidan Nezalezhnosti, this square has been in the center of many important events in the modern history of Ukraine. The most recognizable monument on the square is the so-called Independence Monument, a 200ft tall victory column placed in the center of the square.\n" +
                        "On the top of the column stands a bronze figurine of a woman holding a rose branch. Since the beginning of the Ukrainian independence movement, this square has been used for political rallies and protests. Nowadays, the square hosts a number of cultural events, and is a place where many city tours begin.In the city of churches, the Golden Gate of Kiev strikes as a rather odd structure. Currently used as a museum, this was the main gate to the fortification of Kiev in the 11th century.The original structure was nearly completely dismantled, and only few vestiges remain. The rest was rebuilt in 1982 based on a speculation , since nobody knows how the originalv", //1500 symbols
                        "Also known as the Monastery of the Caves, Pechersk Lavra is a historic Orthodox Christian monastery which gave its name to one of the biggest districts in Kiev. This incredibly beautiful complex started as a cave monastery nearly 1,000 years ago.\n" +
                                "Interestingly, while being a major tourist attraction in Kiev, Pechersk Lavra is also an active monastery, which means that over 100 monks live there. There are several churches within the complex, while a part of the monastery serves as a museum, where you can find many architectural relics of the past.Locally known as Maidan Nezalezhnosti, this square has been in the center of many important events in the modern history of Ukraine. The most recognizable monument on the square is the so-called Independence Monument, a 200ft tall victory column placed in the center of the square.", //less than 1500 symbols
                        "Also known as the Monastery of the Caves, Pechersk Lavra is a historic Orthodox Christian monastery which gave its name to one of the biggest districts in Kiev. This incredibly beautiful complex started as a cave monastery nearly 1,000 years ago.\n" +
                                "Interestingly, while being a major tourist attraction in Kiev, Pechersk Lavra is also an active monastery, which means that over 100 monks live there. There are several churches within the complex, while a part of the monastery serves as a museum, where you can find many architectural relics of the past.Locally known as Maidan Nezalezhnosti, this square has been in the center of many important events in the modern history of Ukraine. The most recognizable monument on the square is the so-called Independence Monument, a 200ft tall victory column placed in the center of the square.\n" +
                                "On the top of the column stands a bronze figurine of a woman holding a rose branch. Since the beginning of the Ukrainian independence movement, this square has been used for political rallies and protests. Nowadays, the square hosts a number of cultural events, and is a place where many city tours begin.In the city of churches, the Golden Gate of Kiev strikes as a rather odd structure. Currently used as a museum, this was the main gate to the fortification of Kiev in the 11th century.The original structure was nearly completely dismantled, and only few vestiges remain. The rest was rebuilt in 1982 based on a speculation , since nobody knows how the originalfd", //1501 symbol
                        "Also known as the Monastery of the Caves, Pechersk Lavra is a historic Orthodox Christian monastery which gave its name to one of the biggest districts in Kiev. This incredibly beautiful complex started as a cave monastery nearly 1,000 years ago.\n" +
                                "Interestingly, while being a major tourist attraction in Kiev, Pechersk Lavra is also an active monastery, which means that over 100 monks live there. There are several churches within the complex, while a part of the monastery serves as a museum, where you can find many architectural relics of the past.Locally known as Maidan Nezalezhnosti, this square has been in the center of many important events in the modern history of Ukraine. The most recognizable monument on the square is the so-called Independence Monument, a 200ft tall victory column placed in the center of the square.\n" +
                                "On the top of the column stands a bronze figurine of a woman holding a rose branch. Since the beginning of the Ukrainian independence movement, this square has been used for political rallies and protests. Nowadays, the square hosts a number of cultural events, and is a place where many city tours begin.In the city of churches, the Golden Gate of Kiev strikes as a rather odd structure. Currently used as a museum, this was the main gate to the fortification of Kiev in the 11th century.The original structure was nearly completely dismantled, and only few vestiges remain. The rest was rebuilt in 1982 based on a speculation , since nobody knows how the originalfd. With its numerous parks and gardens, Kiev is perfect for picnics and outdoor activities.\n" +
                                "Hidropark is an island in the Dnieper River whose natural beaches are very popular during the summer. Besides swimming, you can also play beach volleyball, eat delicious street food or simply sunbathe."} //more than 1500 symbols
        };
    }

    @Test(dataProvider = "lessAndMoreThan1500data")
    public void checkDescriptionFieldWithLessAndMoreThan1500Symbols(String[] input) {
        SoftAssert softAssert = new SoftAssert();
        boolean checkIfValidFiledWith1500Symbols = new HeaderPage(driver)
                .authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickOnAddButton()
                .clickOnAddClubButton()
                .enterNameOfClub("Танці, хореографія")
                .clickOnDancesCheckbox()
                .hoverToElement("basic_ageFrom")
                .severalClicksOnFromAgeUpperArrow()
                .hoverToElement("basic_ageTo")
                .severalClicksOnAgeToUpperArrow()
                .clickOnNextStepButton()
                .enterValidTelephoneNumber("9632548777")
                .clickOnNextStepButton()
                .inputInDescriptionField(input[0])
                .getTick().isDisplayed();
        softAssert.assertTrue(checkIfValidFiledWith1500Symbols, "field is NOT valid");

        boolean checkIfValidFiledWithLessThan1500Symbols = new AddClubPopUpComponent(driver)
                .inputInDescriptionField(input[1])
                .getTick().isDisplayed();
        softAssert.assertTrue(checkIfValidFiledWithLessThan1500Symbols, "field is NOT valid");

        String checkIfValidFiledWith1501Symbol = new AddClubPopUpComponent(driver)
                .inputInDescriptionField(input[2])
                .getError().getText();
        softAssert.assertEquals(checkIfValidFiledWith1501Symbol, "Опис гуртка може містити від 40 до 1500 символів.");

        String checkIfValidFiledWithMoreThan1500Symbols = new AddClubPopUpComponent(driver)
                .inputInDescriptionField(input[3])
                .getError().getText();
        softAssert.assertEquals(checkIfValidFiledWithMoreThan1500Symbols, "Опис гуртка може містити від 40 до 1500 символів.");

        softAssert.assertAll();
    }


    /**
     * 172-Verify that the ‘Опис’ text field is filled in with valid data when a user enters from 40 to 1500 symbols into the field
     **/
    @DataProvider
    public Object[][] differentSizeData() {
        return new Object[][]{
                {"Also known as the Monastery of the Caves, Pechersk Lavra is a historic Orthodox Christian monastery which gave its name to one of the biggest districts in Kiev. This incredibly beautiful complex started as a cave monastery nearly 1,000 years ago.\\n\" +\n" +
                        "\"Interestingly, while being a major tourist attraction in Kiev, Pechersk Lavra is also an active monastery, which means that over 100 monks live there. There are several churches within the complex, while a part of the monastery serves as a museum, where you can find many architectural relics of the past.Locally known as Maidan Nezalezhnosti, this square has been in the center of many important events in the modern history of Ukraine. The most recognizable monument on the square is the so-called Independence Monument, a 200ft tall victory column placed in the center of the square.\\n\" +\n" +
                        "\"On the top of the column stands a bronze figurine of a woman holding a whe are you so sad& i think that is", //1000 symbols
                        "Also known as the Monastery of the Caves", //40 symbols
                        "Also known as the Monastery of the Caves, Pechersk Lavra is a historic Orthodox Christian monastery which gave its name to one of the biggest districts in Kiev. This incredibly beautiful complex started as a cave monastery nearly 1,000 years ago.\\n\" +\n" +
                                "\"Interestingly, while being a major tourist attraction in Kiev, Pechersk Lavra is also an active monastery, which means that over 100 monks live there. There are several churches within the complex, while a part of the monastery serves as a museum, where you can find many architectural relics of the past.Locally known as Maidan Nezalezhnosti, this square has been in the center of many important events in the modern history of Ukraine. The most recognizable monument on the square is the so-called Independence Monument, a 200ft tall victory column placed in the center of the square.\\n\" +\n" +
                                "\"On the top of the column stands a bronze figurine of a woman holding a rose branch. Since the beginning of the Ukrainian independence movement, this square has been used for political rallies and protests. Nowadays, the square hosts a number of cultural events, and is a place where many city tours begin.In the city of churches, the Golden Gate of Kiev strikes as a rather odd structure. Currently used as a museum, this was the main gate to the fortification of Kiev in the 11th century.The original structure was nearly completely dismantled, and only few vestiges remain. The rest was rebuilt in 1982 b"} //1500 symbols
        };
    }

    @Test(dataProvider = "differentSizeData")
    public void checkButtonIsEnabledWithValidInput(String[] input) {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage
                .authorize(valueProvider.getAdminEmail(), valueProvider.getAdminPassword())
                .clickOnOwnerDropdown()
                .clickOnProfile()
                .clickOnAddButton()
                .clickOnAddClubButton()
                .enterNameOfClub("Танці, хореографія")
                .clickOnDancesCheckbox()
                .hoverToElement("basic_ageFrom")
                .severalClicksOnFromAgeUpperArrow()
                .hoverToElement("basic_ageTo")
                .severalClicksOnAgeToUpperArrow()
                .clickOnNextStepButton()
                .enterValidTelephoneNumber("9632548777")
                .clickOnNextStepButton();
        SoftAssert softAssert = new SoftAssert();
        for (String data : input) {
            boolean checkIfButtonIsEnabled = new AddClubPopUpComponent(driver)
                    .inputInDescriptionField(data)
                    .getEndButton().isEnabled();
            softAssert.assertTrue(checkIfButtonIsEnabled, "button is NOT enabled");
        }
        softAssert.assertAll();
    }
}


