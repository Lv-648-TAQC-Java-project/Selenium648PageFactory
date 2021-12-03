package com.ita.edu.teachua.ui.pages.profile_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import org.openqa.selenium.WebDriver;

public class AddDropdownComponent extends BasePage {

    private Button addCenterButton;
    private Button addClubButton;

    public AddDropdownComponent(WebDriver driver) {
        super(driver);
    }

    public AddCenterPopUpComponent clickOnAddCenterButton() {
        addCenterButton.click();
        return new AddCenterPopUpComponent(driver);
    }

    public AddClubPopUpComponent clickOnAddClubButton() {
        addClubButton.click();
        return new AddClubPopUpComponent(driver);
    }
}
