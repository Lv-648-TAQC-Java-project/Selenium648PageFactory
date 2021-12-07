package com.ita.edu.teachua.ui.pages.header_page;

import com.ita.edu.teachua.ui.elements.custom_elements.Button;
import com.ita.edu.teachua.ui.elements.custom_elements.Input;
import com.ita.edu.teachua.ui.locators.header_locators.RestoringBeginPopUpLocators;
import com.ita.edu.teachua.ui.pages.base_page.BasePage;
import com.ita.edu.teachua.utils.GmailContentExtractor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RestoringBeginPopUpComponent extends BasePage {
    @FindBy(how = How.ID, using = RestoringBeginPopUpLocators.EDIT_EMAIL_FIELD_ID)
    private Input editEmail;
    @FindBy(how = How.CSS, using = RestoringBeginPopUpLocators.RESTORE_CSS_SELECTOR)
    private Button restore;

    public RestoringBeginPopUpComponent(WebDriver driver) {
        super(driver);
    }

    public RestoringBeginPopUpComponent inputEmail(String email) {
        editEmail.clear();
        editEmail.sendKeys(email);
        return this;
    }

    public RestoringPasswordFinishPopUpComponent clickOnRestore() {
        restore.click();
        sleep(5000);
        driver.get(GmailContentExtractor.getGmailMessageLink("subject:Відновлення паролю"));
        return new RestoringPasswordFinishPopUpComponent(driver);
    }
}