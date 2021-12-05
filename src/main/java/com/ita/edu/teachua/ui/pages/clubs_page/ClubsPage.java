package com.ita.edu.teachua.ui.pages.clubs_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.pages_locators.clubs_page_locators.ClubsPageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ClubsPage extends BasePage {

    @FindBy(how = How.XPATH, using = ClubsPageLocators.NEXT_PAGE_BUTTON_XPATH)
    private Button nextPageButton;
    @FindBy(how = How.XPATH, using = ClubsPageLocators.LAST_PAGE_BUTTON_XPATH)
    private Button lastPageButton;

    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllTitlesOfCards() {
        return driver.findElements(new By.ByCssSelector(ClubsPageLocators.CARD_TITLE_CSS_SELECTOR));
    }

    public String getTitleOfInvalidSearchPage() {
        return driver.findElement(new By.ByCssSelector(ClubsPageLocators.INVALID_CLUBS_BASIC_SEARCH_CSS_SELECTOR)).getText();
    }

    public boolean isClubPresent(String title) {
        int attempts = 10;
        for (int i = 0; i < attempts; i++) {
            if (driver.getCurrentUrl().equals("https://speak-ukrainian.org.ua/dev/clubs")) {
                break;
            }
            sleep(100);
        }
        List<WebElement> titles = getAllTitlesOfCards();
        System.out.println(titles.size());
        boolean isPresent = false;
        String res = "";
        for (WebElement t : titles) {
            res = t.getText();
            if (res.equals(title)) {
                isPresent = true;
            }
        }
        return isPresent;
    }

    public ClubsPage clickOnNextPageButton() {
        nextPageButton.click();
        return this;
    }

    public int getNumberOfPagesWithClubs() {
        return Integer.parseInt(lastPageButton.getText());
    }
}
