package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_SitePage {

    private final String EDIT_SERVICECHARGES_BUTTON = "//a[starts-with(@onclick,'getWLR3ChargesEdit')]";
    private final String SAVE_SERVICECHARGES_BUTTON = "//button[starts-with(@onclick,'saveWLR3Charges')]";
    private final String EMERGENCY_INFO_TEXTBOX = "EmergencyInfo";
    public final String TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO = "WLR3Order_contact_number";
    private final String NEW_PROVIDE_SITEINFO_SCREEN = "NewProvideSiteInfoForm";
    private final String PHONE_NUMBER_MANDATORY_ERROR_MESSAGE = "//span[text()='Contact Telephone number is required']";
    private final String SITE_CONTACTS_TEXT="//legend[text()='Site Contact']";
    private final String CLOSE_BUTTON="//button[@id='closeBtn']";
    private final String THIS_ORDER_REQUIRES_ADDRESS_TO_MATCH_OPENREACH_RECORDS="//span[text()='This order requires the address to match with Openreach records. Please select an address from the address search.']";
    private final String HIGH_LIKELY_HOOD_OF_ISDN_LINE_BEING_AVAILABLE="//label[text()='Green - High likelihood of ISDN line being available']";

    WLR3_InstallationAddressPage wlr3_installationAddressPage = new WLR3_InstallationAddressPage();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    ElementUtils utils = new ElementUtils();
    WLR3_New_Provide_OrderPage wlr3_new_provide__orderPage = new WLR3_New_Provide_OrderPage();
    WLR3_Summary_Charges_Page wlr3_summary_charges_page=new WLR3_Summary_Charges_Page();

    //populate and assert installation address
    public void zoomOutOnInstallationAddressUnderSITE() throws InterruptedException {
        utils.waitForElementVisible(By.id(NEW_PROVIDE_SITEINFO_SCREEN));
    }

    public void zoomOutOnInstallationAddressUnderModifyOrder() throws InterruptedException {
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.INSTALLATION_ADDRESS_SUMMARY_PANEL));
    }

    public void loadInstallationAddress(){
        try {
           // utils.waitForElementVisible(By.xpath(wlr3_installationAddressPage.INSTALLATION_ADDRESS_BUTTON));
            utils.clickBtn(By.xpath(wlr3_installationAddressPage.INSTALLATION_ADDRESS_BUTTON));
        } catch (Exception e) {
          //  utils.waitForElementVisible(By.xpath(wlr3_installationAddressPage.INSTALLATION_ADDRESS_BUTTON));
            utils.clickBtn(By.xpath(wlr3_installationAddressPage.INSTALLATION_ADDRESS_BUTTON));
        }
    }

    public void populateAndAssertInstallationAddressUnderSITE(String postCode,String addressKey) throws InterruptedException {
       loadInstallationAddress();
        wlr3_installationAddressPage.EnterPostCodeInSearchAddressByPostCode(postCode);
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'Address Key: "+addressKey+"')]"));
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
        //assert that the contact phone number is mandatory(click next with out selecting the phone number)
        utils.waitForElementVisible(By.xpath(SITE_CONTACTS_TEXT));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        try { Thread.sleep(1000);
            utils.javaScriptExecutorClick(By.xpath(wlr3_new_provide__orderPage.NEXT_BUTTON));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.javaScriptExecutorClick(By.xpath(wlr3_new_provide__orderPage.NEXT_BUTTON));
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
        utils.sendText(By.id(wlr3_summary_charges_page.FIRST_ROW_CHARGE_FIELD_UNDER_SETUP), "" + charges + "");
        utils.clickBtn(By.xpath(SAVE_SERVICECHARGES_BUTTON));
        utils.waitForElementVisible(By.xpath("//td[text()='£" + charges + ".00']"));

    }
    public void assertAddressMatchErrorMessage(){
        utils.waitForElementVisible(By.xpath(THIS_ORDER_REQUIRES_ADDRESS_TO_MATCH_OPENREACH_RECORDS));
    }
    public void assertLineSuitabilityMessage(){
        utils.waitForElementVisible(By.xpath(HIGH_LIKELY_HOOD_OF_ISDN_LINE_BEING_AVAILABLE));
    }
    public void populateEmergencyInfo(){
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'This field is required.')]"));
        utils.sendText(By.id(wlr3_orderDetails_page.EMERGENCY_INFO_TEXT_BOX), wlr3_orderDetails_page.EMERGENCY_INFO_TEXT_BOX);
    }
    public void closeWizard(){
        utils.waitForElementVisible(By.xpath(CLOSE_BUTTON));
        utils.clickBtn(By.xpath(CLOSE_BUTTON));
    }

}