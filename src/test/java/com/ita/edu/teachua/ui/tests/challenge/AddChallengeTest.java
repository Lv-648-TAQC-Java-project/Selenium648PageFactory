package com.ita.edu.teachua.ui.tests.challenge;

import com.ita.edu.teachua.ui.pages.header_page.HeaderPage;
import com.ita.edu.teachua.ui.tests.TestRunner;
import org.testng.annotations.Test;

public class AddChallengeTest extends TestRunner {


    @Test(description = "Verify all fields on challenge page with valid data")
    public void verifyAddChallengePage() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.authorize(testValueProvider.getAdminEmail(), testValueProvider.getAdminPassword())
        .clickOnOwnerDropdown()
        .clickOnAdministrationButton()
        .clickOnChallengesButton()
        .clickAddChallengeButton();

    }
}
