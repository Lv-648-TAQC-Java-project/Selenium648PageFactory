package com.ita.edu.teachua.ui.elements.custom_elements;

import com.ita.edu.teachua.ui.elements.base_element.BaseElement;
import org.openqa.selenium.WebElement;


public class LabelElement extends BaseElement implements Label {

    public LabelElement(WebElement element) {
        super(element);
    }

    public boolean isDisplayed(){
        return getWrappedElement().isDisplayed();
    }
    
    @Override
    public void click(){
        getWrappedElement().click();
    }
    public String getText(){
       return getWrappedElement().getText();

    }

}
