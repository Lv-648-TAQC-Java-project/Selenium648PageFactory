package com.ita.edu.teachua.ui.elements.custom_elements;

import com.ita.edu.teachua.ui.elements.base_element.Element;
import com.ita.edu.teachua.ui.elements.base_element.ImplementedBy;

@ImplementedBy(ButtonElement.class)
public interface Button extends Element {
     void click();
     boolean isDisplayed();
     String getInnerText();
}
