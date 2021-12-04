package com.ita.edu.teachua.ui.pages.profile_page;


import com.ita.edu.teachua.ui.elements.custom_elements.ButtonElement;
import com.ita.edu.teachua.ui.elements.custom_elements.DropdownElement;
import com.ita.edu.teachua.ui.elements.custom_elements.LinkElement;
import com.ita.edu.teachua.ui.locators.pages_locators.profile_locators.ProfileEditPopUpLocators;
import com.ita.edu.teachua.ui.locators.pages_locators.profile_locators.ProfilePageLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import com.ita.edu.teachua.ui.pages.clubs_page.ClubPagePopUpComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage extends BasePage {
    @FindBy(how = How.CLASS_NAME, using = ProfilePageLocators.ADD_BUTTON_XPATH)
    private ButtonElement addButton;
    @FindBy(how = How.CLASS_NAME, using = ProfilePageLocators.EDIT_PROFILE_XPATH)
    private LinkElement editProfile;
    @FindBy(how = How.CLASS_NAME, using = ProfilePageLocators.ADD_CLUB_BUTTON_XPATH)
    private DropdownElement addClubButton;
    @FindBy(how = How.CLASS_NAME, using = ProfilePageLocators.ADD_BUTTON_XPATH)
    private ButtonElement addClub;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }


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
        addClub.click();
        return new ClubPagePopUpComponent(driver);
    }
}
