package com.ita.edu.teachua.cucumber.steps_definitions;

import com.ita.edu.teachua.ui.pages.AllPages;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import com.ita.edu.teachua.ui.pages.profile_page.AllProfileComponents;
import org.openqa.selenium.WebDriver;

public class PageContext {

    private WebDriver driver;
    private AllPages allPages;
    private AllProfileComponents allProfileComponents;


    public PageContext(WebDriver driver){
        this.driver = driver;
    }

    public AllPages getAllPages() {
        allPages = new AllPages(driver);
        return  allPages;
    }
    public AllProfileComponents getAllProfilePageComponents(){
        allProfileComponents = new AllProfileComponents(driver);
        return allProfileComponents;
    }
}
