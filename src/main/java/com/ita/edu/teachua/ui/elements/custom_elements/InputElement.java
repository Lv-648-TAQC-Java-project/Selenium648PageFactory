package com.ita.edu.teachua.ui.elements.custom_elements;

import org.openqa.selenium.WebElement;
import com.ita.edu.teachua.ui.elements.base_element.BaseElement;

/**
 * TextInput  wrapper.
 */
public class InputElement extends BaseElement implements Input {
    /**
     * Creates a Element for a given WebElement.
     *
     * @param element element to wrap up
     */
    public InputElement(WebElement element) {
        super(element);
    }

    @Override
    public void clear() {
        getWrappedElement().clear();
    }

    @Override
    public void set(String text) {
        WebElement element = getWrappedElement();
        element.clear();
        element.sendKeys(text);
    }
    public String getCSSValue(String cssValue){
        return getWrappedElement().getCssValue(cssValue);
    }
    /**
     * Gets the value of an input field.
     * @return String with the value of the field.
     */
    @Override
    public String getText() {
        return getWrappedElement().getAttribute("value");
    }
}
