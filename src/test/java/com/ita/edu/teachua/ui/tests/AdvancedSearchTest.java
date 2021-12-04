package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.advanced_search.AdvancedSearchPage;
import com.ita.edu.teachua.ui.pages.advanced_search.ClubsItemComponent;
import com.ita.edu.teachua.ui.pages.main_page.MainPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class AdvancedSearchTest extends TestRunner {

    @Test
    public void verifyAllParametersActiveCenterAdvancedSearch() {
        SoftAssert softAssert = new SoftAssert();
        AdvancedSearchPage advancedSearchPage = new MainPage(driver).clickAdvancedSearchButton().clickOnCenterRadioButton();
        softAssert.assertTrue(advancedSearchPage.getCityLabel().isDisplayedLabel(), "City label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getCitiesDropdown().isDisplayed(), "Cities dropdown is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDistrictLabel().isDisplayedLabel(), "District label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDistrictDropdown().isDisplayed(), "District dropdown is not displayed");
        softAssert.assertTrue(advancedSearchPage.getMetroStationLabel().isDisplayedLabel(), "Metro station label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getMetroDropdown().isDisplayed(), "Metro station dropdown is not displayed");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));

        softAssert.assertNull(advancedSearchPage.getRemoteLabel(), "Remote label is displayed");
        softAssert.assertNull(advancedSearchPage.getAvailableOnlineCheckBox(), "Available online checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getSportSectionsCheckBox(), "Sport sections checkbox is displayed");
        softAssert.assertNull(advancedSearchPage.getDanceChoreographyCheckBox(), "Dance checkbox check box is  displayed");
        softAssert.assertNull(advancedSearchPage.getEarlyDevelopStudiesCheckBox(), "Early development studies checkbox check box is displayed");
        softAssert.assertNull(advancedSearchPage.getProgrammingStemCheckBox(), "Programming, STEM checkbox check box is displayed");
        softAssert.assertNull(advancedSearchPage.getArtDesignCheckBox(), "Art studio, design checkbox check box is displayed");
        softAssert.assertNull(advancedSearchPage.getVocalMusicCheckBox(), "Vocal studio, music checkbox check box is displayed");
        softAssert.assertNull(advancedSearchPage.getActorsTheaterCheckBox(), "Actors, theater checkbox check box is displayed");
        softAssert.assertNull(advancedSearchPage.getPersonalDevelopmentCheckBox(), "Personal development checkbox check box is displayed");
        softAssert.assertNull(advancedSearchPage.getJournalismEditVideoCheckBox(), "Journalism, editing video checkbox check box is displayed");
        softAssert.assertNull(advancedSearchPage.getDevelopCenterCheckBox(), "Develop center checkbox check box is displayed");
        softAssert.assertNull(advancedSearchPage.getOtherCheckBox(), "Other checkbox check box is displayed");
        softAssert.assertNull(advancedSearchPage.getAgeLabel(), "Age label is displayed");

        softAssert.assertAll();
    }

    @Test(description = "TUA-224 Advanced search button opens Розширений пошук section")
    public void openAdvancedSearchFieldTest() {
        SoftAssert softAssert = new SoftAssert();
        MainPage mainPage = new MainPage(driver);
        boolean isPresent = mainPage
                .clickOnAdvancedSearchButton()
                .isSearchBlockPresent();
        softAssert.assertTrue(isPresent, "Розширений пошук section did not open");
        isPresent = mainPage
                .clickOnAdvancedSearchButton()
                .isSearchBlockPresent();
        softAssert.assertFalse(isPresent, "Розширений пошук section did not close");
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] checkByAgeDataProvider() {
        return new Object[][]{
                {"2", "2"},
                {"18", "18"},
                {"1", "2"},
                {"19", "18"}
        };
    }

    @Test(dataProvider = "checkByAgeDataProvider")
    public void checkByValidAgeDataProvider(String input, String expectedResult) {
        String actualResult = new MainPage(driver).clickAdvancedSearchButton()
                .setValueAgeInput(input)
                .pressEnterAgeInput()
                .getAgeInput().getValue();
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void verifyAllParametersActiveClubsAdvancedSearch() {
        SoftAssert softAssert = new SoftAssert();
        AdvancedSearchPage advancedSearchPage = new MainPage(driver).clickAdvancedSearchButton();
        softAssert.assertTrue(advancedSearchPage.getClubsRadioButton().getAttribute("class").contains("checked"), "Clubs radio button is not selected");
        softAssert.assertTrue(advancedSearchPage.getCityLabel().isDisplayedLabel(), "City label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getCitiesDropdown().isDisplayed(), "Cities dropdown is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDistrictLabel().isDisplayedLabel(), "District label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDistrictDropdown().isDisplayed(), "District dropdown is not displayed");
        softAssert.assertTrue(advancedSearchPage.getMetroStationLabel().isDisplayedLabel(), "Metro station label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getMetroDropdown().isDisplayed(), "Metro station dropdown is not displayed");
        softAssert.assertTrue(advancedSearchPage.getRemoteLabel().isDisplayedLabel(), "Remote label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getAvailableOnlineCheckBox().isDisplayed(), "Available online checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getCategoriesLabel().isDisplayedLabel(), "Categories label is not displayed");
        softAssert.assertTrue(advancedSearchPage.getSportSectionsCheckBox().isDisplayed(), "Sport sections checkbox is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDanceChoreographyCheckBox().isDisplayed(), "Dance checkbox check box is not displayed");
        softAssert.assertTrue(advancedSearchPage.getEarlyDevelopStudiesCheckBox().isDisplayed(), "Early development studies checkbox check box is not displayed");
        softAssert.assertTrue(advancedSearchPage.getProgrammingStemCheckBox().isDisplayed(), "Programming, STEM checkbox check box is not displayed");
        softAssert.assertTrue(advancedSearchPage.getArtDesignCheckBox().isDisplayed(), "Art studio, design checkbox check box is not displayed");
        softAssert.assertTrue(advancedSearchPage.getVocalMusicCheckBox().isDisplayed(), "Vocal studio, music checkbox check box is not displayed");
        softAssert.assertTrue(advancedSearchPage.getActorsTheaterCheckBox().isDisplayed(), "Actors, theater checkbox check box is not displayed");
        softAssert.assertTrue(advancedSearchPage.getPersonalDevelopmentCheckBox().isDisplayed(), "Personal development checkbox check box is not displayed");
        softAssert.assertTrue(advancedSearchPage.getJournalismEditVideoCheckBox().isDisplayed(), "Journalism, editing video checkbox check box is not displayed");
        softAssert.assertTrue(advancedSearchPage.getDevelopCenterCheckBox().isDisplayed(), "Develop center checkbox check box is not displayed");
        softAssert.assertTrue(advancedSearchPage.getOtherCheckBox().isDisplayed(), "Other checkbox check box is not displayed");
        softAssert.assertTrue(advancedSearchPage.getAgeLabel().isDisplayedLabel(), "Age label is not displayed");
        softAssert.assertAll();
    }

    @Test
    public void checkIfCentersAreDisplayedAsAList() {
        SoftAssert softAssert = new SoftAssert();
        MainPage mainPage = new MainPage(driver);
        String urlMainPage = mainPage.getMainPageUrL();
        softAssert.assertEquals("https://speak-ukrainian.org.ua/dev/", urlMainPage);

        AdvancedSearchPage advancedSearchPage = mainPage.clickAdvancedSearchButton();
        String title = advancedSearchPage.getTitleOfAdvancedSearchField();
        softAssert.assertEquals(title, "Розширений пошук");

        boolean checkThatWorkshopRadioButtonIsChosenByDefault = advancedSearchPage.getWorkshopRadioButton().isDisplayed();
        softAssert.assertTrue(checkThatWorkshopRadioButtonIsChosenByDefault, "workshop radiobutton is NOT selected");

        boolean CenterRadioButtonSelected = advancedSearchPage
                .clickOnCenterRadioButton()
                .getCenterRadioButton().isDisplayed();
        softAssert.assertTrue(CenterRadioButtonSelected, "center radiobutton is NOT selected");

        advancedSearchPage.clickOnListIcon();
        for (ClubsItemComponent club : advancedSearchPage.getCards()) {
            softAssert.assertTrue(club.isList());
        }
        softAssert.assertAll();
    }

    @Test
    public void checkSortingClubs() {
        MainPage mainPage = new MainPage(driver);
        AdvancedSearchPage advSearch = mainPage.clickOnAdvancedSearchButton();
        List<WebElement> titles = advSearch.getAllTitlesOfCards();
        boolean actual = true;
        try {
            driver.wait(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < advSearch.getNumberOfPagesWithClubs(); i++) {
            for (int j = 0; j < titles.size() - 1; j++) {
                char[] firstTitle = titles.get(j).getText().toLowerCase().replaceAll(" ", "").toCharArray();
                char[] secondTitle = titles.get(j + 1).getText().toLowerCase().replaceAll(" ", "").toCharArray();
                int wordLength = Math.min(firstTitle.length, secondTitle.length);
                for (int k = 0; k < wordLength; k++) {
                    if (firstTitle[k] < secondTitle[k]) {
                        break;
                    } else if (firstTitle[k] > secondTitle[k]) {
                        actual = false;
                        break;
                    }
                }
                Assert.assertTrue(actual);
            }
            advSearch.clickOnNextPageButton();
        }
    }


}