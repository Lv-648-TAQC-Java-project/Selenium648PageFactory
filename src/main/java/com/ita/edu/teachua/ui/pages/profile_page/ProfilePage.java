package com.ita.edu.teachua.ui.pages.profile_page;


import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Dropdown;
import com.ita.edu.teachua.ui.elements.custom_elements.Link;
import com.ita.edu.teachua.ui.locators.profile_locators.ProfilePageLocators;
import com.ita.edu.teachua.ui.pages.advanced_search.ClubsItemComponent;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import com.ita.edu.teachua.ui.pages.clubs_page.ClubPagePopUpComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends BasePage {
    @FindBy(how = How.CSS, using = ProfilePageLocators.ADD_BUTTON_CSS_SELECTOR)
    private Button addButton;
    @FindBy(how = How.XPATH, using = ProfilePageLocators.EDIT_PROFILE_XPATH)
    private Link editProfile;
    @FindBy(how = How.XPATH, using = ProfilePageLocators.ADD_CLUB_BUTTON_XPATH)
    private Dropdown addClubButton;
    @FindBy(how = How.CSS, using = ProfilePageLocators.MY_CLUBS_DROPDOWN_CSS_SELECTOR)
    private Dropdown myClubsDropdown;
    @FindAll(@FindBy (how = How.XPATH, using = ProfilePageLocators.CENTERS_BLOCKS_XPATH))
    private List<WebElement> centers;
    @FindBy(how = How.XPATH, using = ProfilePageLocators.TITLE_XPATH)
    private WebElement title;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'Додати' button")
    public AddDropdownComponent clickOnAddButton() {
        addButton.click();
        addButton.click();
        return new AddDropdownComponent(driver);
    }

    @Step("Click edit pop up")
    public ProfileEditPopUpComponent clickEditProfile() {
        editProfile.click();
        return new ProfileEditPopUpComponent(driver);
    }

    public ProfilePage clickAddClubButton() {
        Actions action = new Actions(driver);
        action.moveToElement(addClubButton).build().perform();
        return this;
    }

    public ClubPagePopUpComponent clickAddClub() {
        addClubButton.click();
        return new ClubPagePopUpComponent(driver);
    }

    public MyClubsOrCentersDropdownComponent clickOnMyClubsDropdown(){
        myClubsDropdown.click();
        //waitUntilVisibilityOfElementLocated(By.cssSelector(ProfilePageLocators.MY_CLUBS_DROPDOWN_CSS_SELECTOR), 5);
        sleep(1000);
        return new MyClubsOrCentersDropdownComponent(driver);
    }

    public List<CentersItemComponent> getCenters() {
        List<CentersItemComponent> centerBlocks = new ArrayList<>();
        for (WebElement j : centers) {
            centerBlocks.add(new CentersItemComponent(driver, j));
        }
        return centerBlocks;
    }

    public String verifyPage(){
    return title.getText();
    }

    public ProfilePage getProfilePage(){
        return this;
    }
}
