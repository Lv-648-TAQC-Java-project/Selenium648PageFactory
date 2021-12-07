package com.ita.edu.teachua.ui.pages.advanced_search;

import com.ita.edu.teachua.ui.locators.advanced_search_page_locators.ClubsItemComponentLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ClubsItemComponent {
    WebElement root;
    WebDriver driver;
    @FindBy(how = How.CSS, using = ClubsItemComponentLocators.CARD_TITLE_CSS_SELECTOR)
    private WebElement cartTitle;

    @Step("Get title of the card")
    public String getCardTitle(){
        return cartTitle.getText();
    }

    public ClubsItemComponent(WebDriver driver, WebElement root) {
        this.driver = driver;
        this.root = root;
    }

    @Step("Check if club is displayed as a list")
    public boolean isList() {
        String str = root.getAttribute("class");
        return str.contains("list-rectangle-item");
    }

    public boolean isBlock() {
        String str = root.getAttribute("class");
        return !str.contains("list-rectangle-item");
    }
}
