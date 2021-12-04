package com.ita.edu.teachua.ui.pages.clubs_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.locators.pages_locators.header_locators.GuestDropdownComponentLocators;
import com.ita.edu.teachua.ui.locators_example.pageslocators.clubslocators.ClubsPageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ClubsPage extends BasePage {

    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = ClubsPageLocators.NEXT_PAGE_BUTTON_XPATH)
    private Button nextPageButton;

    @FindBy(how = How.XPATH, using = ClubsPageLocators.LAST_PAGE_BUTTON_XPATH)
    private Button lastPageButton;

    public List<WebElement> getAllTitlesOfCards() {
        return driver.findElements(new By.ByXPath(ClubsPageLocators.CLUBS_PAGE_TITLE_XPATH));
    }

    public String getTitleOfInvalidSearchPage() {
        return driver.findElement(new By.ByXPath(ClubsPageLocators.CLUBS_PAGE_TITLE_XPATH)).getText();
    }

    public boolean isClubPresent(String title) {
        List<WebElement> titles = this.getAllTitlesOfCards();
        boolean isPresent = false;
        String res = "";
        for (WebElement t : titles) {
            try {
                res = t.getText();
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                sleep(100);
                isPresent = isClubPresent(title);
                break;
            }
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
