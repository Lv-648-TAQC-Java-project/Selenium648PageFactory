package com.ita.edu.teachua.ui.pages.advanced_search;

import com.ita.edu.teachua.ui.locators.pageslocators.advancedsearchlocators.AdvancedSearchPageLocators;
import com.ita.edu.teachua.ui.locators.pageslocators.clubslocators.ClubsPageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchPage extends BasePage {


    private RadioButtonElement clubsRadioButton;
    private LabelElement cityLabel;
    private DropDownElement citiesDropdown;
    private LabelElement districtLabel;
    private DropDownElement districtDropdown;
    private LabelElement metroStationLabel;
    private DropDownElement metroDropdown;
    private LabelElement remoteLabel;
    private CheckBoxElement availableOnlineCheckBox;
    private LabelElement categoriesLabel;
    private CheckBoxElement sportSectionsCheckBox;
    private CheckBoxElement danceChoreographyCheckBox;
    private CheckBoxElement earlyDevelopStudiesCheckBox;
    private CheckBoxElement programmingStemCheckBox;
    private CheckBoxElement artDesignCheckBox;
    private CheckBoxElement vocalMusicCheckBox;
    private CheckBoxElement actorsTheaterCheckBox;
    private CheckBoxElement personalDevelopmentCheckBox;
    private CheckBoxElement journalismEditVideoCheckBox;
    private CheckBoxElement developCenterCheckBox;
    private CheckBoxElement otherCheckBox;
    private LabelElement ageLabel;
    private InputElement ageInput;
    private RadioButtonElement workShopRadioButton;
    private RadioButtonElement centerRadioButton;
    private ButtonElement listIcon;
    private DivElement advancedSearchBlock;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    public AdvancedSearchPage setValueAgeInput(String input) {
        ageInput = new InputElement(driver, AdvancedSearchPageLocators.AGE_INPUT);
        ageInput.sendKeys(input);
        return this;
    }

    public CheckBoxElement getVocalMusicCheckBox() {
        try {
            vocalMusicCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.VOCAL_MUSIC_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return vocalMusicCheckBox;
    }

    public RadioButtonElement getClubsRadioButton() {
        clubsRadioButton = new RadioButtonElement(driver, AdvancedSearchPageLocators.CLUB_RADIOBUTTON);
        return clubsRadioButton;
    }

    public LabelElement getCityLabel() {
        cityLabel = new LabelElement(driver, AdvancedSearchPageLocators.CITY_LABEL);
        return cityLabel;
    }

    public DropDownElement getDistrictDropdown() {
        districtDropdown = new DropDownElement(driver, AdvancedSearchPageLocators.DISTRICT_DROPDOWN);
        return districtDropdown;
    }

    public DropDownElement getMetroDropdown() {
        metroDropdown = new DropDownElement(driver, AdvancedSearchPageLocators.NEAREST_STATION_DROPDOWN);
        return metroDropdown;
    }

    public CheckBoxElement getAvailableOnlineCheckBox() {
        try {
            availableOnlineCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.AVAILABLE_ONLINE_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return availableOnlineCheckBox;
    }

    public CheckBoxElement getSportSectionsCheckBox() {
        try {
            sportSectionsCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.SPORT_SECTIONS_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return sportSectionsCheckBox;
    }

    public CheckBoxElement getDanceChoreographyCheckBox() {
        try {
            danceChoreographyCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.DANCE_CHOREOGRAPHY_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return danceChoreographyCheckBox;
    }

    public CheckBoxElement getEarlyDevelopStudiesCheckBox() {
        try {
            earlyDevelopStudiesCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.EARLY_DEVELOPMENT_STUDIES_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return earlyDevelopStudiesCheckBox;
    }

    public CheckBoxElement getProgrammingStemCheckBox() {
        try {
            programmingStemCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.PROGRAMING_STEM_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return programmingStemCheckBox;
    }

    public CheckBoxElement getArtDesignCheckBox() {
        try {
            artDesignCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.ART_DESIGN_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return artDesignCheckBox;
    }

    public CheckBoxElement getActorsTheaterCheckBox() {
        try {
            actorsTheaterCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.ACTORS_THEATER_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return actorsTheaterCheckBox;
    }

    public CheckBoxElement getPersonalDevelopmentCheckBox() {
        try {
            personalDevelopmentCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.PERSONAL_DEVELOPMENT_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return personalDevelopmentCheckBox;
    }

    public CheckBoxElement getJournalismEditVideoCheckBox() {
        try {
            journalismEditVideoCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.JOURNALISM_EDITING_VIDEO_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return journalismEditVideoCheckBox;
    }

    public CheckBoxElement getDevelopCenterCheckBox() {
        try {
            developCenterCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.DEVELOPMENT_CENTER_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return developCenterCheckBox;
    }

    public CheckBoxElement getOtherCheckBox() {
        try {
            otherCheckBox = new CheckBoxElement(driver, AdvancedSearchPageLocators.OTHER_RADIOBUTTON);
        } catch (NoSuchElementException e) {
            return null;
        }
        return otherCheckBox;
    }

    public InputElement getAgeInput() {
        ageInput = new InputElement(driver, AdvancedSearchPageLocators.AGE_INPUT);
        return ageInput;
    }

    public AdvancedSearchPage pressEnterAgeInput() {
        ageInput = new InputElement(driver, AdvancedSearchPageLocators.AGE_INPUT);
        ageInput.pressEnter();
        return this;
    }

    public DropDownElement getCitiesDropdown() {
        citiesDropdown = new DropDownElement(driver, AdvancedSearchPageLocators.CITIES_DROPDOWN);
        return citiesDropdown;
    }

    public LabelElement getDistrictLabel() {
        districtLabel = new LabelElement(driver, AdvancedSearchPageLocators.DISTRICT_LABEL);
        return districtLabel;
    }

    public LabelElement getMetroStationLabel() {
        metroStationLabel = new LabelElement(driver, AdvancedSearchPageLocators.NEAREST_STATION_LABEL);
        return metroStationLabel;
    }

    public LabelElement getRemoteLabel() {
        try {
            remoteLabel = new LabelElement(driver, AdvancedSearchPageLocators.REMOTE_LABEL);
        } catch (NoSuchElementException e) {
            return null;
        }
        return remoteLabel;
    }

    public LabelElement getCategoriesLabel() {
        try {
            categoriesLabel = new LabelElement(driver, AdvancedSearchPageLocators.CATEGORIES_LABEL);
        } catch (NoSuchElementException e) {
            return null;
        }
        return categoriesLabel;
    }

    public LabelElement getAgeLabel() {
        try {
            ageLabel = new LabelElement(driver, AdvancedSearchPageLocators.AGE_LABEL);
        } catch (NoSuchElementException e) {
            return null;
        }
        return ageLabel;
    }


    public RadioButtonElement getWorkshopRadioButton() {
        return new RadioButtonElement(driver, AdvancedSearchPageLocators.WORKSHOP_RADIO_BUTTON);
    }

    public AdvancedSearchPage clickOnCenterRadioButton() {
        centerRadioButton = new RadioButtonElement(driver, AdvancedSearchPageLocators.CENTER_RADIO_BUTTON);
        centerRadioButton.click();
        return this;
    }

    public RadioButtonElement getCenterRadioButton() {
        return new RadioButtonElement(driver, AdvancedSearchPageLocators.CENTER_RADIO_BUTTON);
    }

    public AdvancedSearchPage clickOnListIcon() {
        listIcon = new ButtonElement(driver, AdvancedSearchPageLocators.LIST_ICON_IN_MENU_BAR);
        listIcon.click();
        sleep(1000);
        return this;
    }

    public List<ClubsItemComponent> getCards() {
        List<WebElement> centerBlocks = driver.findElements(By.cssSelector(".ant-card.ant-card-bordered.card.center-list-rectangle-item"));
        List<ClubsItemComponent> clubBlocks = new ArrayList<>();
        for (WebElement j : centerBlocks) {
            clubBlocks.add(new ClubsItemComponent(driver, j));
        }
        return clubBlocks;
    }

    public boolean isAdvanceSearchFieldDisappear() {
        int searchFields = driver.findElements(AdvancedSearchPageLocators.ADVANCED_SEARCH_FIELD_TITLE.getPath()).size();
        return searchFields == 0;
    }

    public String getTitleOfAdvancedSearchField() {
        return driver.findElement(AdvancedSearchPageLocators.ADVANCED_SEARCH_FIELD_TITLE.getPath()).getText();
    }

    public boolean isSearchBlockPresent() {
        try {
            advancedSearchBlock = new DivElement(driver, AdvancedSearchPageLocators.ADVANCED_SEARCH_BLOCK);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public AdvancedSearchPage clickOnNextPageButton() {
        ButtonElement nextPageButton = new ButtonElement(driver, AdvancedSearchPageLocators.NEXT_PAGE_BUTTON);
        nextPageButton.click();
        return this;
    }

    public List<WebElement> getAllTitlesOfCards() {
        return driver.findElements(ClubsPageLocators.CARD_TITLE.getPath());
    }

    public int getNumberOfPagesWithClubs() {
        ButtonElement lastPageButton = new ButtonElement(driver, AdvancedSearchPageLocators.LAST_PAGE_BUTTON);
        return Integer.parseInt(lastPageButton.getInnerText());
    }
}