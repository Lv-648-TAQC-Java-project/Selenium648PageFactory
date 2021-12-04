package com.ita.edu.teachua.ui.pages.advanced_search;


import com.ita.edu.teachua.ui.elements.custom_elements.*;
import com.ita.edu.teachua.ui.locators.pages_locators.advanced_search.AdvancedSearchPageLocators;
import com.ita.edu.teachua.ui.locators.pages_locators.clubs_page_locators.ClubsPageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchPage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.CLUB_RADIOBUTTON_XPATH)
    private RadioButton clubsRadioButton;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.CITY_LABEL_XPATH)
    private Label cityLabel;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.CITIES_DROPDOWN_CLASS_NAME)
    private Dropdown citiesDropdown;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.DISTRICT_LABEL_XPATH)
    private Label districtLabel;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.DISTRICT_DROPDOWN_XPATH)
    private Dropdown districtDropdown;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.NEAREST_STATION_LABEL_XPATH)
    private Label metroStationLabel;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.NEAREST_STATION_DROPDOWN_XPATH)
    private Dropdown metroDropdown;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.REMOTE_LABEL_XPATH)
    private Label remoteLabel;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.AVAILABLE_ONLINE_CHECKBOX_XPATH)
    private CheckBox availableOnlineCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.CATEGORIES_LABEL_XPATH)
    private Label categoriesLabel;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.SPORT_SECTIONS_CHECKBOX_XPATH)
    private CheckBox sportSectionsCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.DANCE_CHOREOGRAPHY_CHECKBOX_XPATH)
    private CheckBox danceChoreographyCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.EARLY_DEVELOPMENT_STUDIES_CHECKBOX_XPATH)
    private CheckBox earlyDevelopStudiesCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.PROGRAMING_STEM_CHECKBOX_XPATH)
    private CheckBox programmingStemCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.ART_DESIGN_CHECKBOX_XPATH)
    private CheckBox artDesignCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.VOCAL_MUSIC_CHECKBOX_XPATH)
    private CheckBox vocalMusicCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.ACTORS_THEATER_CHECKBOX_XPATH)
    private CheckBox actorsTheaterCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.PERSONAL_DEVELOPMENT_CHECKBOX_XPATH)
    private CheckBox personalDevelopmentCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.JOURNALISM_EDITING_VIDEO_CHECKBOX_XPATH)
    private CheckBox journalismEditVideoCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.DEVELOPMENT_CENTER_CHECKBOX_XPATH)
    private CheckBox developCenterCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.OTHER_CHECKBOX_XPATH)
    private CheckBox otherCheckBox;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.AGE_LABEL_XPATH)
    private Label ageLabel;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.AGE_INPUT_CSS_SELECTOR)
    private Input ageInput;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.WORKSHOP_RADIO_BUTTON_XPATH)
    private RadioButton workShopRadioButton;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.CENTER_RADIO_BUTTON_XPATH)
    private RadioButton centerRadioButton;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.LIST_ICON_IN_MENU_BAR_CSS_SELECTOR)
    private Button listIcon;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.ADVANCED_SEARCH_BLOCK_CSS_SELECTOR)
    private Div advancedSearchBlock;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.CENTER_RADIO_BUTTON_CHECKED_XPATH)
    private RadioButton centerRadioButtonChecked;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.ADVANCED_SEARCH_FIELD_TITLE_XPATH)
    private Label advancedSearchFieldTitle;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.CENTER_ITEM_XPATH)
    private Label centerItem; //or not label
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.CENTER_ADDRESS_XPATH)
    private Label centerAddress;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.NEXT_PAGE_BUTTON_XPATH)
    private  Button nextPageButton;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.LAST_PAGE_BUTTON_XPATH)
    private Button lastPageButton;
    @FindAll(@FindBy(how = How.CLASS_NAME, using = ClubsPageLocators.CARD_TITLE_CSS_SELECTOR))
    private List<Button> cartTitles;
    @FindAll(@FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.CENTER_BLOCKS_CSS_SELECTOR))
    private List<Button> centerBlocks;
    @FindAll(@FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.ADVANCED_SEARCH_FIELD_TITLE_XPATH))
    private List<Button> searchFields;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    public AdvancedSearchPage setValueAgeInput(String input) {
        ageInput.clear();
        ageInput.sendKeys(input);
        return this;
    }

    public CheckBox getVocalMusicCheckBox() {
        try {
            vocalMusicCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return vocalMusicCheckBox;
    }

    public RadioButton getClubsRadioButton() {
        return clubsRadioButton;
    }

    public Label getCityLabel() {
        return cityLabel;
    }

    public Dropdown getDistrictDropdown() {
        return districtDropdown;
    }

    public Dropdown getMetroDropdown() {
        return metroDropdown;
    }

    public CheckBox getAvailableOnlineCheckBox() {
        try {
            availableOnlineCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return availableOnlineCheckBox;
    }

    public CheckBox getSportSectionsCheckBox() {
        try {
            sportSectionsCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return sportSectionsCheckBox;
    }

    public CheckBox getDanceChoreographyCheckBox() {
        try {
            danceChoreographyCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return danceChoreographyCheckBox;
    }

    public CheckBox getEarlyDevelopStudiesCheckBox() {
        try {
            earlyDevelopStudiesCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return earlyDevelopStudiesCheckBox;
    }

    public CheckBox getProgrammingStemCheckBox() {
        try {
            programmingStemCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return programmingStemCheckBox;
    }

    public CheckBox getArtDesignCheckBox() {
        try {
            artDesignCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return artDesignCheckBox;
    }

    public CheckBox getActorsTheaterCheckBox() {
        try {
            actorsTheaterCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return actorsTheaterCheckBox;
    }

    public CheckBox getPersonalDevelopmentCheckBox() {
        try {
            personalDevelopmentCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return personalDevelopmentCheckBox;
    }

    public CheckBox getJournalismEditVideoCheckBox() {
        try {
            journalismEditVideoCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return journalismEditVideoCheckBox;
    }

    public CheckBox getDevelopCenterCheckBox() {
        try {
            developCenterCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return developCenterCheckBox;
    }

    public CheckBox getOtherCheckBox() {
        try {
            otherCheckBox.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return otherCheckBox;
    }

    public Input getAgeInput() {
        return ageInput;
    }

    public AdvancedSearchPage pressEnterAgeInput() {
        ageInput.pressEnter();
        return this;
    }

    public Dropdown getCitiesDropdown() {
        return citiesDropdown;
    }

    public Label getDistrictLabel() {
        return districtLabel;
    }

    public Label getMetroStationLabel() {
        return metroStationLabel;
    }

    public Label getRemoteLabel() {
        try {
            remoteLabel.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return remoteLabel;
    }

    public Label getCategoriesLabel() {
        try {
            categoriesLabel.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return categoriesLabel;
    }

    public Label getAgeLabel() {
        try {
            ageLabel.isDisplayed();
        } catch (NoSuchElementException e) {
            return null;
        }
        return ageLabel;
    }


    public RadioButton getWorkshopRadioButton() {
        return workShopRadioButton;
    }

    public AdvancedSearchPage clickOnCenterRadioButton() {
        centerRadioButton.click();
        return this;
    }

    public RadioButton getCenterRadioButton() {
        return centerRadioButton;
    }

    public AdvancedSearchPage clickOnListIcon() {
        listIcon.click();
        sleep(1000);
        return this;
    }

    //?
    public List<ClubsItemComponent> getCards() {
        List<ClubsItemComponent> clubBlocks = new ArrayList<>();
        for (WebElement j : centerBlocks) {
            clubBlocks.add(new ClubsItemComponent(driver, j));
        }
        return clubBlocks;
    }

    public boolean isAdvanceSearchFieldDisappear() {
        return searchFields.size() == 0;
    }

    public String getTitleOfAdvancedSearchField() {
        return advancedSearchFieldTitle.getText();
    }

    public boolean isSearchBlockPresent() {
        try {
            advancedSearchBlock.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public AdvancedSearchPage clickOnNextPageButton(){
        nextPageButton.click();
        return this;
    }


    public List<Button> getAllTitlesOfCards() {
        return cartTitles;
    }


    public int getNumberOfPagesWithClubs() {
        return Integer.parseInt(lastPageButton.getInnerText());
    }


}