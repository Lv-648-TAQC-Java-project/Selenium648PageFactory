package com.ita.edu.teachua.ui.pages.profile_page;


import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Dropdown;
import com.ita.edu.teachua.ui.elements.custom_elements.Link;
import com.ita.edu.teachua.ui.locators.profile_locators.ProfilePageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import com.ita.edu.teachua.ui.pages.clubs_page.ClubPagePopUpComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage extends BasePage {
    @FindBy(how = How.CSS, using = ProfilePageLocators.ADD_BUTTON_CSS_SELECTOR)
    private Button addButton;
    @FindBy(how = How.XPATH, using = ProfilePageLocators.EDIT_PROFILE_XPATH)
    private Link editProfile;
    @FindBy(how = How.XPATH, using = ProfilePageLocators.ADD_CLUB_BUTTON_XPATH)
    private Dropdown addClubButton;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'Додати' button")
    public AddDropdownComponent clickOnAddButton() {
        addButton.click();
        return new AddDropdownComponent(driver);
    }

    public ProfileEditPopUpComponent clickEditProfile() {
        editProfile.click();
        return new ProfileEditPopUpComponent(driver);
    }

    public ProfilePage clickAddClubButton() {
        Actions action = new Actions(driver);
        action.moveToElement(addClubButton).build().perform();
        return this;
    }

    public ClubPagePopUpComponent clickAddClub() throws InterruptedException {
        addClubButton.click();
        return new ClubPagePopUpComponent(driver);
    }
}
