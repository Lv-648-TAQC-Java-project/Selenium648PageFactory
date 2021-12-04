package com.ita.edu.teachua.ui.elements.custom_elements;

import com.ita.edu.teachua.ui.elements.base_element.Element;
import com.ita.edu.teachua.ui.elements.base_element.ImplementedBy;

@ImplementedBy(LabelElement.class)
public interface Label extends Element {
     boolean isDisplayed();
     void click();
}