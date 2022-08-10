package com.ita.edu.teachua.ui.tests.challenge;

import com.ita.edu.teachua.ui.pages.header_page.AdministrationDropdownComponent;
import com.ita.edu.teachua.ui.pages.header_page.HeaderPage;
import com.ita.edu.teachua.ui.pages.header_page.OwnerDropdownComponent;
import com.ita.edu.teachua.ui.tests.testrunners.TestRunnerAsAdmin;
import com.ita.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.Test;

public class AddChallengeTest extends TestRunnerAsAdmin {

    OwnerDropdownComponent headerDropDown = new OwnerDropdownComponent(driver);
    HeaderPage headerPage = new HeaderPage(driver);

    @Test(description = "Verify all fields on challenge page with valid data")
    public void verifyAddChallengePage() {

        headerPage.clickOnOwnerDropdown();
        headerDropDown.clickOnAdministrationButton().clickOnChallengesButton().clickAddChallengeButton();

    }
}
