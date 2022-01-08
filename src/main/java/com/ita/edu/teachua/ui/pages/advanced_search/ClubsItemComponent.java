package com.ita.edu.teachua.ui.pages.advanced_search;

import com.ita.edu.teachua.ui.elements.custom_elements.Label;
import com.ita.edu.teachua.ui.locators.advanced_search_page_locators.ClubsItemComponentLocators;
import com.ita.edu.teachua.ui.locators.clubs_page_locators.ClubsPageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class ClubsItemComponent {
    DefaultElementLocatorFactory parentContext;
    WebDriver driver;
    WebElement root;
    @FindBy(how = How.XPATH, using = ClubsItemComponentLocators.CARD_TITLE_XPATH)
    private WebElement cartTitle;
    /*@FindAll(@FindBy(how = How.CLASS_NAME, using = ClubsItemComponentLocators.CARD_RATING_STAR_CLASS))
    private List<WebElement> cardStars;*/

    public ClubsItemComponent(WebDriver driver, WebElement root) {
        this.driver=driver;
        parentContext = new DefaultElementLocatorFactory(root);
        PageFactory.initElements(parentContext, this);
    }

    @Step("Get title of the card")
    public WebElement getCardTitle() {
        return cartTitle;
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

    /*public Integer getRating() {
        return cardStars.size();
    }*/
}
