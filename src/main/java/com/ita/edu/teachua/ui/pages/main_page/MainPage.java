package com.ita.edu.teachua.ui.pages.main_page;

import com.ita.edu.teachua.ui.elements.ButtonElement;
import com.ita.edu.teachua.ui.elements.InputElement;
import com.ita.edu.teachua.ui.elements.LinkElement;
import com.ita.edu.teachua.ui.locators.pageslocators.advancedsearchlocators.AdvancedSearchPageLocators;
import com.ita.edu.teachua.ui.locators.pageslocators.mainpagelocators.MainPageLocators;
import com.ita.edu.teachua.ui.pages.advanced_search.AdvancedSearchPage;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import com.ita.edu.teachua.ui.pages.clubs_page.ClubsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class MainPage extends BasePage {

    private LinkElement clubsLink;
    private ButtonElement advancedSearchButton;
    private InputElement searchInput;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getMainPageUrL() {
        return driver.getCurrentUrl();
    }

    public String getTitleOfAdvancedSearchField() {
        return driver.findElement(AdvancedSearchPageLocators.ADVANCED_SEARCH_FIELD_TITLE.getPath()).getText();
    }

    public AdvancedSearchPage clickAdvancedSearchButton() {
        advancedSearchButton = new ButtonElement(driver, MainPageLocators.ADVANCED_SEARCH_BUTTON);
        advancedSearchButton.click();
        return new AdvancedSearchPage(driver);
    }

    public AdvancedSearchPage clickOnAdvancedSearchButton() {
        ButtonElement buttonElement = new ButtonElement(driver, MainPageLocators.ADVANCED_SEARCH_BUTTON);
        buttonElement.click();
        return new AdvancedSearchPage(driver);
    }

    public void clickSearchInput(InputElement searchInput) {
        searchInput = new InputElement(driver, MainPageLocators.SEARCH_INPUT_FIELD);
        this.searchInput = searchInput;
    }

    public ClubsPage clickOnClubs() {
        clubsLink = new LinkElement(driver, MainPageLocators.CLUBS_LINK);
        clubsLink.click();
        return new ClubsPage(driver);
    }


    public ClubsPage inputStringInSearchField(String input) {
        searchInput = new InputElement(driver, MainPageLocators.SEARCH_INPUT_FIELD);
        searchInput.sendKeys(input);
        return new ClubsPage(driver);
    }

    public ClubsPage pasteClipBoardStringInSearchField(String input) {
        searchInput = new InputElement(driver, MainPageLocators.SEARCH_INPUT_FIELD);
        StringSelection stringSelection = new StringSelection(input);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        searchInput.sendKeys(Keys.CONTROL + "V");
        return new ClubsPage(driver);
    }
}