package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 13/01/2017.
 */
public class WLR3_New_Provide_Analogue_Multiline_OrderPage {

    ElementUtils utils = new ElementUtils();
    WLR3_InstallationAddressPage wlr3_installationAddressPage = new WLR3_InstallationAddressPage();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();


    public void clickAnalogueMultilineTab() {
        utils.waitForElementVisible(By.id("line_3"));
        utils.clickBtn(By.id("line_3"));
        utils.clickBtn(By.xpath("//button[@type='submit']"));
    }

    public void populateAndAssertInstallationAddressUnderSite(String postCode) {
        utils.waitForElementVisible(By.id("NewProvideSiteInfoForm"));
        utils.clickBtn(By.xpath(wlr3_installationAddressPage.INSTALLATION_ADDRESS_BUTTON));
        wlr3_installationAddressPage.EnterPostCodeInSearchAddressByPostCode(postCode);
        utils.clickBtn(By.id(wlr3_orderDetails_page.ADDRESS_SEARCH_RESULT));
        utils.javaScriptExecutorClick(By.xpath(wlr3_orderDetails_page.CONTINUE_AFTER_ADDRESS_IS_CHOOSEN));
        utils.jumpToParentPopUp();
    }

    public void populateEmergencyInfo(String message) throws InterruptedException {
        Thread.sleep(1000);
        utils.sendText(By.id("EmergencyInfo"), message);
    }

    public void populateSiteContact(String number) {
        utils.selectByVisibleText(By.id("ContactList"), ", Jeroen");
        utils.sendText(By.id("WLR3Order_contact_number"), number);
    }

    public void editAndAssertServicesCharges(String charges) {
        utils.clickBtn(By.xpath("//a[starts-with(@onclick,'getWLR3ChargesEdit')]"));
        utils.waitForElementVisible(By.xpath("//button[starts-with(@onclick,'saveWLR3Charges')]"));
        utils.sendText(By.id("ChargeList_0__install_charge"), "" + charges + "");
        utils.clickBtn(By.xpath("//button[starts-with(@onclick,'saveWLR3Charges')]"));
        utils.waitForElementVisible(By.xpath("//td[text()='£" + charges + ".00']"));
    }

    public void navigateToNextScreen() {
        utils.clickBtn(By.xpath("//a[starts-with(@onclick,'newProvideWizard.moveNext()')]"));
    }

    public void populateLinePlantSummary() {
        utils.waitForElementVisible(By.xpath("//legend[text()='Line Plant Summary']"));
        utils.selectByIndex(By.id("WLR3Order_termination_type"), 1);
    }

    public void populatingEngineeringNotes(String notes) {
        utils.waitForElementVisible(By.xpath("//legend[text()='Engineering Information']"));
        utils.sendText(By.id("WLR3Order_engineering_notes"), notes);
    }

    public void populateNetworkFeatures() {
        utils.waitForElementVisible(By.xpath("//legend[text()='Network Features']"));
        utils.makeSureBoxIsChecked(By.id("Features_6__value"), By.id("Features_6__value"));
    }

    public void checkLineNumberingTabAndPopulateDirectoryInfo(String info) {
        utils.waitForElementVisible(By.xpath("//legend[text()='Line Numbering']"));
        utils.clickBtn(By.xpath("//a[starts-with(@onclick,'loadLineNumberingPopup')]"));
        utils.waitForElementVisible(By.xpath("//a[starts-with(@onclick,'return lineNumbering.tabChangeEvent(this);')]"));
        utils.clickBtn(By.id("closeBtn"));
        utils.waitForElementVisible(By.id("DirectoryInfo_0__dir_BusinessDescription"));
        utils.sendText(By.id("DirectoryInfo_0__dir_BusinessDescription"), info);


    }

}
