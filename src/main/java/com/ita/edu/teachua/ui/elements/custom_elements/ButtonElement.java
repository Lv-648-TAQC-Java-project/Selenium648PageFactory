package com.ita.edu.teachua.ui.elements.custom_elements;

import com.ita.edu.teachua.ui.elements.base_element.BaseElement;
import org.openqa.selenium.WebElement;

public class ButtonElement extends BaseElement implements Button {

    public ButtonElement(WebElement element) {
        super(element);
    }

    public void click() {
        getWrappedElement().click();
    }
    public boolean isActive(){
        return getWrappedElement().isDisplayed();
    }
}
