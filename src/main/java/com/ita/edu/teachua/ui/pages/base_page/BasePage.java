package com.ita.edu.teachua.ui.pages.base_page;

import com.ita.edu.teachua.ui.pagefactory.ElementFactory;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {

        this.driver = driver;
        initialize(this.driver);
    }

    public BasePage initialize(WebDriver driver) {
        return ElementFactory.initElements(driver, this);
    }

    public void sleep(long ms) {
        try {
            Thread.sleep(ms); // For Presentation ONLY
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
