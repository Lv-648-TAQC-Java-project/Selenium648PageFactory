package com.ita.edu.teachua.ui.pages.advanced_search;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClubsItemComponent {
    WebElement root;
    WebDriver driver;

    public ClubsItemComponent(WebDriver driver, WebElement root) {
        this.driver = driver;
        this.root = root;
    }

    @Step("Check if club is displayed as a list")
    public boolean isList() {
        String str = root.getAttribute("class");
        return str.contains("list-rectangle-item");
    }

    public boolean isBlock() {
        String str = root.getAttribute("class");
        return !str.contains("list-rectangle-item");
    }
}
