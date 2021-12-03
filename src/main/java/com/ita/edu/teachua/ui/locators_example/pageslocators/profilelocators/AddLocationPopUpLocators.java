package com.ita.edu.teachua.ui.locators_example.pageslocators.profilelocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum AddLocationPopUpLocators implements Locator {
    LOCATION_NAME_FIELD(By.id("name")),
    CITY_DROPDOWN(By.id("cityName")),
    DISTRICT_DROPDOWN(By.id("districtName")),
    LOCALITY_DROPDOWN(By.id("stationName")),
    ADDRESS_FIELD(By.id("address")),
    COORDINATES_FIELD(By.id("coordinates")),
    PHONE_FIELD(By.id("phone")),
    ADD_BUTTON(By.xpath("//button[@class='ant-btn flooded-button add-club-content-next']")),
    ADD_BUTTON_DISABLED(By.cssSelector("button[disabled]")),
    ADD_LOCATION_BLOCK_HEADER(By.xpath("//div[contains(text(),'Додати локацію')]"));
    private final By path;

    AddLocationPopUpLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
