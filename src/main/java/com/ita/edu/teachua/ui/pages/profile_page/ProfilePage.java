package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.ButtonElement;
import com.ita.edu.teachua.ui.elements.DropDownElement;
import com.ita.edu.teachua.ui.elements.LinkElement;
import com.ita.edu.teachua.ui.locators.pageslocators.profilelocators.ProfilePageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import com.ita.edu.teachua.ui.pages.clubs_page.ClubPagePopUpComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProfilePage extends BasePage {
    private ButtonElement addButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }


    public AddDropdownComponent clickOnAddButton() {
        addButton = new ButtonElement(driver, ProfilePageLocators.ADD_BUTTON);
        addButton.click();
        return new AddDropdownComponent(driver);
    }

    public ProfileEditPopUpComponent clickEditProfile() {
        LinkElement editProfile = new LinkElement(driver, ProfilePageLocators.EDIT_PROFILE);
        editProfile.click();
        return new ProfileEditPopUpComponent(driver);
    }

    public ProfilePage clickAddClubButton() {
        Actions action = new Actions(driver);
        DropDownElement addClubButton = new DropDownElement(driver, ProfilePageLocators.ADD_CLUB_BUTTON);
        action.moveToElement(addClubButton.getElement()).build().perform();
        return this;
    }

    public ClubPagePopUpComponent clickAddClub() throws InterruptedException {
        ButtonElement addClub = new ButtonElement(driver, ProfilePageLocators.ADD_CLUB);
        addClub.click();
        return new ClubPagePopUpComponent(driver);
    }
}
