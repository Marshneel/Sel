package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_AnaMultLine_SitePage {

    private final String EDIT_SERVICECHARGES_BUTTON = "//a[starts-with(@onclick,'getWLR3ChargesEdit')]";
    private final String SAVE_SERVICECHARGES_BUTTON = "//button[starts-with(@onclick,'saveWLR3Charges')]";
    private final String EMERGENCY_INFO_TEXTBOX = "EmergencyInfo";
    public final String TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO = "WLR3Order_contact_number";
    private final String ANALOGUE_MULTILINE_INSTALLATION_CHARGE = "ChargeList_0__install_charge";
    private final String NEW_PROVIDE_SITEINFO_SCREEN = "NewProvideSiteInfoForm";
    private final String SELECT_CONTACT_UNDER_SITEINFO = "ContactList";
    private final String PHONE_NUMBER_MANDATORY_ERROR_MESSAGE = "//span[text()='Contact Telephone number is required']";
    private final String SITE_CONTACTS_TEXT="//legend[text()='Site Contact']";

    WLR3_InstallationAddressPage wlr3_installationAddressPage = new WLR3_InstallationAddressPage();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    ElementUtils utils = new ElementUtils();
    WLR3_New_Provide_Analogue_Multiline_OrderPage wlr3_new_provide_analogue_multiline_orderPage = new WLR3_New_Provide_Analogue_Multiline_OrderPage();


    //populate and assert installation address
    public void zoomOutOnInstallationAddressUnderSITE() throws InterruptedException {
        utils.waitForElementVisible(By.id(NEW_PROVIDE_SITEINFO_SCREEN));
    }

    public void zoomOutOnInstallationAddressUnderModifyOrder() throws InterruptedException {
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.INSTALLATION_ADDRESS_SUMMARY_PANEL));
    }

    public void populateAndAssertInstallationAddressUnderSITE(String postCode) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//h3[contains(text(),'New Line')]"));
        try {
            utils.waitForElementVisible(By.xpath(wlr3_installationAddressPage.INSTALLATION_ADDRESS_BUTTON));
            utils.clickBtn(By.xpath(wlr3_installationAddressPage.INSTALLATION_ADDRESS_BUTTON));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(wlr3_installationAddressPage.INSTALLATION_ADDRESS_BUTTON));
            utils.clickBtn(By.xpath(wlr3_installationAddressPage.INSTALLATION_ADDRESS_BUTTON));
        }
        wlr3_installationAddressPage.EnterPostCodeInSearchAddressByPostCode(postCode);
        utils.clickBtn(By.id(wlr3_orderDetails_page.ADDRESS_SEARCH_RESULT));
        utils.javaScriptExecutorClick(By.xpath(wlr3_orderDetails_page.CONTINUE_AFTER_ADDRESS_IS_CHOOSEN));
        utils.jumpToParentPopUp();
    }

    //populate emergency info
    public void populateEmergencyInfoUnderSITE(String message) throws InterruptedException {
        Thread.sleep(1000);
        try {
            utils.waitForElementVisible(By.id(EMERGENCY_INFO_TEXTBOX));
            utils.clickBtn(By.id(EMERGENCY_INFO_TEXTBOX));
            utils.sendText(By.id(EMERGENCY_INFO_TEXTBOX), message);
        } catch (Exception e) {
            utils.waitForElementVisible(By.id(EMERGENCY_INFO_TEXTBOX));
            Thread.sleep(1000);
            utils.clickBtn(By.id(EMERGENCY_INFO_TEXTBOX));
            utils.sendText(By.id(EMERGENCY_INFO_TEXTBOX), message);
        }

    }

    public void populateSiteContactUnderSITE(String number) throws InterruptedException {
        //select contact from the list
        utils.selectByVisibleText(By.id(SELECT_CONTACT_UNDER_SITEINFO), ", Jeroen");
        //assert that the contact phone number is mandatory(click next with out selecting the phone number)
        utils.waitForElementVisible(By.xpath(SITE_CONTACTS_TEXT));

        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        try { Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(wlr3_new_provide_analogue_multiline_orderPage.NEXT_BUTTON));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(wlr3_new_provide_analogue_multiline_orderPage.NEXT_BUTTON));
        }
        //verify the presence of error message
        utils.waitForElementVisible(By.xpath(PHONE_NUMBER_MANDATORY_ERROR_MESSAGE));
        //enter contact phone number
        utils.sendText(By.id(TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO), number);

    }

    public void editAndAssertServicesChargesUnderSITE(String charges) throws InterruptedException {
        Thread.sleep(1000);
        try {
            utils.javaScriptExecutorClick(By.xpath(EDIT_SERVICECHARGES_BUTTON));
        } catch (Exception e) {
            utils.javaScriptExecutorClick(By.xpath(EDIT_SERVICECHARGES_BUTTON));
        }
        utils.waitForElementVisible(By.xpath(SAVE_SERVICECHARGES_BUTTON));
        utils.sendText(By.id(ANALOGUE_MULTILINE_INSTALLATION_CHARGE), "" + charges + "");
        utils.clickBtn(By.xpath(SAVE_SERVICECHARGES_BUTTON));
        utils.waitForElementVisible(By.xpath("//td[text()='£" + charges + ".00']"));

    }
}