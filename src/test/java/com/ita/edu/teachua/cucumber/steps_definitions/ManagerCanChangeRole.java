package com.ita.edu.teachua.cucumber.steps_definitions;

import org.testng.asserts.SoftAssert;

public class ManagerCanChangeRole {
    private BaseDefinition baseDefinition;
    private PageContext pageContext;
    private final SoftAssert softAssert;

    public ManagerCanChangeRole(BaseDefinition baseDefinition, PageContext pageContext, SoftAssert softAssert) {
        this.baseDefinition = baseDefinition;
        pageContext = new PageContext(baseDefinition.getDriver());
        softAssert = new SoftAssert();
    }
}
