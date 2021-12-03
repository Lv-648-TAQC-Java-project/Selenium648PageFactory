package com.ita.edu.teachua.ui.locators_example.pageslocators.profilelocators;

import com.ita.edu.teachua.ui.locators_example.Locator;
import org.openqa.selenium.By;

public enum DistrictDropdownLocators implements Locator {

    DESNIANSKYI_BUTTON(By.xpath("//div[@class='ant-select-item-option-content'][contains(text(),'Деснянський')]"));

    private final By path;

    DistrictDropdownLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
