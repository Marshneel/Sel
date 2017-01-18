package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 13/01/2017.
 */
public class WLR3_New_Provide_Analogue_Multiline_OrderPage {

    private final String WARNING_NOTES_TEXT = "//p[@id='display_WLR3Order_warning_notes'][contains(text(),'warning notes')]";
    private final String ENGINEERING_NOTES_TEXT = "//p[@id='display_WLR3Order_engineering_notes'][contains(text(),'engineering notes')]";
    private final String CALL_DIVERSION_NETWORK_FEATURES = "//div[@id='networkFeaturesSummaryPanel']//label[contains(text(),'Call Diversion')]";
    private final String TERMINATION_ATTRIBUTE_UNDER_SITE_INFO = "//p[@id='display_TerminationType'][contains(text(),'Linebox')]";
    private final String HAZARD_NOTES_TEXTBOX = "HazardNotesId";
    private final String WARNING_NOTES_TEXTBOX = "WarningNotesId";
    private final String EDIT_SERVICECHARGES_BUTTON = "//a[starts-with(@onclick,'getWLR3ChargesEdit')]";
    private final String SAVE_SERVICECHARGES_BUTTON = "//button[starts-with(@onclick,'saveWLR3Charges')]";
    private final String NEXT_BUTTON = "//a[starts-with(@onclick,'newProvideWizard.moveNext()')]";
    private final String LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO = "//legend[text()='Line Plant Summary']";
    private final String TERMINATION_TYPE_DROPDOWN_UNDER_SITEINFO = "WLR3Order_termination_type";
    private final String ENGINEERING_NOTES_TEXTBOX_UNDER_SITEINFO = "WLR3Order_engineering_notes";
    private final String ENGINEERING_INFO_TEXT_UNDER_SITEINFO = "//legend[text()='Engineering Information']";
    private final String EMERGENCY_INFO_TEXTBOX = "EmergencyInfo";
    private final String BUSINESS_DESC_TEXTBOX_UNDER_DIRECTORY_INFO = "DirectoryInfo_0__dir_BusinessDescription";
    private final String NETWORK_FEATURES_TEXT = "//legend[text()='Network Features']";
    private final String CALL_DIVERSION_RADIOBUTTON_UNDER_NETWORK_FEATURES = "Features_6__value";
    private final String TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO = "WLR3Order_contact_number";
    private final String ANALOGUE_MULTILINE_INSTALLATION_CHARGE = "ChargeList_0__install_charge";
    private final String SUBMIT_BUTTON = "//button[@type='submit']";
    private final String ANALOGUE_MULTILINE_TAB = "line_3";
    private final String NEW_PROVIDE_SCREEN = "modal-dialog-NewProvide";
    private final String NEW_PROVIDE_SITEINFO_SCREEN = "NewProvideSiteInfoForm";
    private final String SELECT_CONTACT_UNDER_SITEINFO = "ContactList";


    ElementUtils utils = new ElementUtils();
    WLR3_InstallationAddressPage wlr3_installationAddressPage = new WLR3_InstallationAddressPage();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    OrdersManagerPage ordersManagerPage = new OrdersManagerPage();
    EditOrderPage editOrderPage = new EditOrderPage();


    public void clickAnalogueMultilineTab() {
        utils.waitForElementVisible(By.id(ANALOGUE_MULTILINE_TAB));
        utils.clickBtn(By.id(ANALOGUE_MULTILINE_TAB));
        utils.clickBtn(By.xpath(SUBMIT_BUTTON));
    }

    public void populateAndAssertInstallationAddressUnderSite(String postCode) {
        utils.waitForElementVisible(By.id(NEW_PROVIDE_SITEINFO_SCREEN));
        utils.clickBtn(By.xpath(wlr3_installationAddressPage.INSTALLATION_ADDRESS_BUTTON));
        wlr3_installationAddressPage.EnterPostCodeInSearchAddressByPostCode(postCode);
        utils.clickBtn(By.id(wlr3_orderDetails_page.ADDRESS_SEARCH_RESULT));
        utils.javaScriptExecutorClick(By.xpath(wlr3_orderDetails_page.CONTINUE_AFTER_ADDRESS_IS_CHOOSEN));
        utils.jumpToParentPopUp();
    }

    public void populateEmergencyInfo(String message) throws InterruptedException {
        Thread.sleep(1000);
        try {
            utils.sendText(By.id(EMERGENCY_INFO_TEXTBOX), message);
        } catch (Exception e) {
            utils.sendText(By.id(EMERGENCY_INFO_TEXTBOX), message);
        }
        utils.zoomOut(By.id(NEW_PROVIDE_SCREEN));
        Thread.sleep(1000);
    }

    public void populateSiteContact(String number) {
        utils.selectByVisibleText(By.id(SELECT_CONTACT_UNDER_SITEINFO), ", Jeroen");
        utils.sendText(By.id(TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO), number);
    }

    public void editAndAssertServicesCharges(String charges) {
        utils.clickBtn(By.xpath(EDIT_SERVICECHARGES_BUTTON));
        utils.waitForElementVisible(By.xpath(SAVE_SERVICECHARGES_BUTTON));
        utils.sendText(By.id(ANALOGUE_MULTILINE_INSTALLATION_CHARGE), "" + charges + "");
        utils.clickBtn(By.xpath(SAVE_SERVICECHARGES_BUTTON));
        utils.waitForElementVisible(By.xpath("//td[text()='£" + charges + ".00']"));
    }

    public void navigateToNextScreen() {
        utils.clickBtn(By.xpath(NEXT_BUTTON));
    }

    public void navigateToNextScreenAndZoomIn() {
        utils.clickBtn(By.xpath(NEXT_BUTTON));
        utils.zoomIn(By.id(NEW_PROVIDE_SCREEN));
    }

    public void populateLinePlantSummary() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO));
        utils.selectByIndex(By.id(TERMINATION_TYPE_DROPDOWN_UNDER_SITEINFO), 1);


    }

    public void populatingEngineeringNotes(String notes) {
        utils.waitForElementVisible(By.xpath(ENGINEERING_INFO_TEXT_UNDER_SITEINFO));
        utils.sendText(By.id(ENGINEERING_NOTES_TEXTBOX_UNDER_SITEINFO), notes);
    }

    public void populateNetworkFeatures() {
        utils.waitForElementVisible(By.xpath(NETWORK_FEATURES_TEXT));
        utils.makeSureBoxIsChecked(By.id(CALL_DIVERSION_RADIOBUTTON_UNDER_NETWORK_FEATURES), By.id(CALL_DIVERSION_RADIOBUTTON_UNDER_NETWORK_FEATURES));
    }

    public void PopulateDirectoryInfo(String info) {
        utils.waitForElementVisible(By.id(BUSINESS_DESC_TEXTBOX_UNDER_DIRECTORY_INFO));
        utils.sendText(By.id(BUSINESS_DESC_TEXTBOX_UNDER_DIRECTORY_INFO), info);
    }

    public void populateHazardAndWarningNotes(String hazardNotes, String warningNotes) {
        try {
            utils.waitForElementVisible(By.id(HAZARD_NOTES_TEXTBOX));
            utils.sendText(By.id(HAZARD_NOTES_TEXTBOX), hazardNotes);
            utils.sendText(By.id(WARNING_NOTES_TEXTBOX), warningNotes);
        } catch (Exception e) {
            utils.waitForElementVisible(By.id(HAZARD_NOTES_TEXTBOX));
            utils.sendText(By.id(HAZARD_NOTES_TEXTBOX), hazardNotes);
            utils.sendText(By.id(WARNING_NOTES_TEXTBOX), warningNotes);
        }
    }

    public void assertionsOnOrderDetailsPage() throws InterruptedException {
        //load created quote
        utils.getOrdersPage();
        ordersManagerPage.clickOnQuoteID();
        utils.jumpToPopUpWindow(By.xpath(editOrderPage.QUOTEID_ON_EDITORDER_PAGE));
        // on quote page
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        //assert address
        utils.verifyStringMatch(By.xpath(wlr3_orderDetails_page.ADDRESS_SEARCH_RESULT_FOR_LU1_1DQ_ON_WLR3_ORDER_PAGE), "LU1 1DQ");
        //assert site contacts
        wlr3_orderDetails_page.assertPopulatedSiteContactsOnWLR3OrderPage();
        //assert network features
        utils.waitForElementVisible(By.xpath(CALL_DIVERSION_NETWORK_FEATURES));
        //assert hazard notes and warning notes
        utils.waitForElementVisible(By.xpath(WARNING_NOTES_TEXT));
        //assert engineering notes
        utils.waitForElementVisible(By.xpath(ENGINEERING_NOTES_TEXT));
        //assert installation information
        utils.waitForElementVisible(By.xpath(TERMINATION_ATTRIBUTE_UNDER_SITE_INFO));
    }

}
