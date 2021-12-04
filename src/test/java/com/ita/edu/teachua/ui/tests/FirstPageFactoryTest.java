package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.header_page.HeaderPage;
import org.testng.annotations.Test;

public class FirstPageFactoryTest extends TestRunner {

    @Test
    public void FirstTest() throws InterruptedException {
        HeaderPage header = new HeaderPage(driver);
        header.clickOnGuestDropdown();
        Thread.sleep(5000);
    }


}
