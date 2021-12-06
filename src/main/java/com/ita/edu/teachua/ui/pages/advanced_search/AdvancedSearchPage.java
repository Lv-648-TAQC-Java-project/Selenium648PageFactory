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

    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CLUB_RADIOBUTTON_XPATH)
    private RadioButton clubsRadioButton;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CITY_LABEL_XPATH)
    private Label cityLabel;
    @FindBy(how = How.CLASS_NAME, using = AdvancedSearchPageLocators.CITIES_DROPDOWN_CLASS_NAME)
    private Dropdown citiesDropdown;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.DISTRICT_LABEL_XPATH)
    private Label districtLabel;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.DISTRICT_DROPDOWN_XPATH)
    private Dropdown districtDropdown;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.NEAREST_STATION_LABEL_XPATH)
    private Label metroStationLabel;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.NEAREST_STATION_DROPDOWN_XPATH)
    private Dropdown metroDropdown;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.REMOTE_LABEL_XPATH)
    private Label remoteLabel;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.AVAILABLE_ONLINE_CHECKBOX_XPATH)
    private CheckBox availableOnlineCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CATEGORIES_LABEL_XPATH)
    private Label categoriesLabel;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.SPORT_SECTIONS_CHECKBOX_XPATH)
    private CheckBox sportSectionsCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.DANCE_CHOREOGRAPHY_CHECKBOX_XPATH)
    private CheckBox danceChoreographyCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.EARLY_DEVELOPMENT_STUDIES_CHECKBOX_XPATH)
    private CheckBox earlyDevelopStudiesCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.PROGRAMING_STEM_CHECKBOX_XPATH)
    private CheckBox programmingStemCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.ART_DESIGN_CHECKBOX_XPATH)
    private CheckBox artDesignCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.VOCAL_MUSIC_CHECKBOX_XPATH)
    private CheckBox vocalMusicCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.ACTORS_THEATER_CHECKBOX_XPATH)
    private CheckBox actorsTheaterCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.PERSONAL_DEVELOPMENT_CHECKBOX_XPATH)
    private CheckBox personalDevelopmentCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.JOURNALISM_EDITING_VIDEO_CHECKBOX_XPATH)
    private CheckBox journalismEditVideoCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.DEVELOPMENT_CENTER_CHECKBOX_XPATH)
    private CheckBox developCenterCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.OTHER_CHECKBOX_XPATH)
    private CheckBox otherCheckBox;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.AGE_LABEL_XPATH)
    private Label ageLabel;
    @FindBy(how = How.CSS, using = AdvancedSearchPageLocators.AGE_INPUT_CSS_SELECTOR)
    private Input ageInput;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.WORKSHOP_RADIO_BUTTON_XPATH)
    private RadioButton workShopRadioButton;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CENTER_RADIO_BUTTON_XPATH)
    private RadioButton centerRadioButton;
    @FindBy(how = How.CSS, using = AdvancedSearchPageLocators.LIST_ICON_IN_MENU_BAR_CSS_SELECTOR)
    private Button listIcon;
    @FindBy(how = How.CSS, using = AdvancedSearchPageLocators.ADVANCED_SEARCH_BLOCK_CSS_SELECTOR)
    private Div advancedSearchBlock;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CENTER_RADIO_BUTTON_CHECKED_XPATH)
    private RadioButton centerRadioButtonChecked;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.ADVANCED_SEARCH_FIELD_TITLE_XPATH)
    private Label advancedSearchFieldTitle;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CENTER_ITEM_XPATH)
    private Label centerItem; //or not label
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.CENTER_ADDRESS_XPATH)
    private Label centerAddress;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.NEXT_PAGE_BUTTON_XPATH)
    private Button nextPageButton;
    @FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.LAST_PAGE_BUTTON_XPATH)
    private Button lastPageButton;
    @FindAll(@FindBy(how = How.CSS, using = ClubsPageLocators.CARD_TITLE_CSS_SELECTOR))
    private List<WebElement> cartTitles;
    @FindAll(@FindBy(how = How.CSS, using = AdvancedSearchPageLocators.CENTER_BLOCKS_CSS_SELECTOR))
    private List<Button> centerBlocks;
    @FindAll(@FindBy(how = How.XPATH, using = AdvancedSearchPageLocators.ADVANCED_SEARCH_FIELD_TITLE_XPATH))
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

    public AdvancedSearchPage clickOnNextPageButton() {
        nextPageButton.click();
        return this;
    }

    public List<String> getTitlesFromAllPages() {
        List<WebElement> titles = new ArrayList<>();
        int n = this.getNumberOfPagesWithClubs();
        for (int i = 0; i < n; i++) {
            titles.addAll(this.getAllTitlesOfCards());
            if (i <= n - 1) {
                this.clickOnNextPageButton();
            }
        }
        List<String> stringCards = new ArrayList<>();
        for (WebElement card : titles) {
            stringCards.add(card.getText());
        }
        return stringCards;
    }

    public boolean isAlphabeticallySorted(List<String> titles, boolean asc) {
        for (int j = 0; j < titles.size() - 1; j++) {
            char[] firstTitle = titles.get(j).toLowerCase().replaceAll(" ", "").toCharArray();
            char[] secondTitle = titles.get(j + 1).toLowerCase().replaceAll(" ", "").toCharArray();
            int wordLength = Math.min(firstTitle.length, secondTitle.length);
            for (int k = 0; k < wordLength; k++) {
                System.out.println("fw letter: " + firstTitle[k]);
                System.out.println("sw letter: " + secondTitle[k]);
                if (asc) {
                    if (firstTitle[k] < secondTitle[k]) {
                        break;
                    } else if (firstTitle[k] > secondTitle[k]) {
                        return false;
                    }
                }
                if (!asc) {
                    if (firstTitle[k] > secondTitle[k]) {
                        break;
                    } else if (firstTitle[k] < secondTitle[k]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public List<WebElement> getAllTitlesOfCards() {
        sleep(1000);
        return cartTitles;
    }

    public int getNumberOfPagesWithClubs() {
        sleep(1000);
        return Integer.parseInt(lastPageButton.getInnerText());
    }


}