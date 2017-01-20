package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 13/01/2017.
 */
public class WLR3_New_Provide_Analogue_Multiline_OrderPage {

    private final String HAZARD_NOTES_TEXTBOX = "HazardNotesId";
    private final String WARNING_NOTES_TEXTBOX = "WarningNotesId";
    private final String EDIT_SERVICECHARGES_BUTTON = "//a[starts-with(@onclick,'getWLR3ChargesEdit')]";
    private final String SAVE_SERVICECHARGES_BUTTON = "//button[starts-with(@onclick,'saveWLR3Charges')]";
    private final String NEXT_BUTTON = "//a[starts-with(@onclick,'newProvideWizard.moveNext()')]";
    private final String PREVIOUS_BUTTON = "//a[@onclick='newProvideWizard.movePrevious()']";
    private final String LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO = "//legend[text()='Line Plant Summary']";
    private final String TERMINATION_TYPE_DROPDOWN_UNDER_SITEINFO = "WLR3Order_termination_type";
    private final String ENGINEERING_NOTES_TEXTBOX_UNDER_SITEINFO = "WLR3Order_engineering_notes";
    private final String ENGINEERING_INFO_TEXT_UNDER_SITEINFO = "//legend[text()='Engineering Information']";
    private final String EMERGENCY_INFO_TEXTBOX = "EmergencyInfo";
    private final String BUSINESS_DESC_TEXTBOX_UNDER_DIRECTORY_INFO = "DirectoryInfo_0__dir_TradingTitleSurname";
    private final String NETWORK_FEATURES_TEXT = "//legend[text()='Network Features']";
    private final String CALL_DIVERSION_RADIOBUTTON_UNDER_NETWORK_FEATURES = "Features_7__value";
    private final String TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO = "WLR3Order_contact_number";
    private final String ANALOGUE_MULTILINE_INSTALLATION_CHARGE = "ChargeList_0__install_charge";
    private final String SUBMIT_BUTTON = "//button[@type='submit']";
    private final String ANALOGUE_MULTILINE_TAB = "line_3";
    private final String NEW_PROVIDE_SCREEN = "modal-dialog-NewProvide";
    private final String NEW_PROVIDE_SITEINFO_SCREEN = "NewProvideSiteInfoForm";
    private final String SELECT_CONTACT_UNDER_SITEINFO = "ContactList";
    private final String PHONE_NUMBER_MANDATORY_ERROR_MESSAGE = "//span[text()='Contact Telephone number is required']";
    private final String TERMINATION_TYPE_MANDATORY_ERROR_MESSAGE = "//span[text()='Termination Type is required']";
    private final String INSTALLATION_TYPE_GUIDANCE_TAB = "installationTypeGuidance";
    private final String TEXT_ON_INSTALLATION_TYPE_GUIDANCE_PAGE = "//h3[contains(text(),'Installation Type Help')]";
    private final String INSTALLATION_TYPE_GUIDANCE_POPUP_CLOSEBTN = "//div[@id='dialog-container']//button[@id='closeBtn']";
    private final String DECREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO = "//a[contains(@onclick,'newProvideWizard.decreaseNumber')]";
    private final String INCREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO = "//a[contains(@onclick,'newProvideWizard.increaseNumber')]";
    private final String NUMBER_OF_LINES_TEXT_BOX_UNDER_INSTALLATION_INFO = "WLR3Order_num_lines";
    private final String VIEW_WORKING_LINES_UNDER_LINE_PLANT_SUMMARY = "lnkwlt";
    private final String TEXT_ON_WORKING_LINES_POPUP = "//h3[contains(text(),'Line Plant Information')]";
    private final String WORKING_LINES_POPUP_CLOSEBTN = "//div[@id='modal-dialog-LinePlant']//button[@id='closeBtn']";
    private final String CALL_DIVERSION_RADIOBTN_UNDER_NETWORK_FEATURES = "AllLineBased_123";
    private final String BUSY_OUT_LINE_RADIOBTN_UNDER_NETWORK_FEATURES = "Features_6__value";
    private final String RESIDENTIAL_RADIOBTN_UNDER_DIRECTORYINFO = "DirectoryInfo_0__dir_LocationResidential";
    private final String MANDATORYMSG_FOR_RESIDENTIAL_UNDER_DIRECTORY_INFO = "//span[text()='Title is Required for Residential Directory']";
    private final String CONTACT_TITLE_UNDER_DIRECTORY_INFO = "DirectoryInfo_0__dir_Title";
    private final String CONTACT_INITIALS_UNDER_DIRECTORY_INFO = "DirectoryInfo_0__dir_Initial";
    private final String CONTACT_SURNAME_UNDER_DIRECTORY_INFO = "DirectoryInfo_0__dir_TradingTitleSurname";
    private final String ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING = "//a[contains(@onclick,'loadLineNumberingPopup')]";
    private final String NUMBER_RESERVATION_CONFIRMATION_UNDER_LINE_NUMBERING = "//p[text()='This number has been reserved.']";

    ElementUtils utils = new ElementUtils();
    WLR3_InstallationAddressPage wlr3_installationAddressPage = new WLR3_InstallationAddressPage();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    OrdersManagerPage ordersManagerPage = new OrdersManagerPage();
    EditOrderPage editOrderPage = new EditOrderPage();
    WLR3_LineNumberingPage wlr3_lineNumberingPage = new WLR3_LineNumberingPage();


    public void clickAnalogueMultilineTab() {
        utils.waitForElementVisible(By.id(ANALOGUE_MULTILINE_TAB));
        utils.clickBtn(By.id(ANALOGUE_MULTILINE_TAB));
        utils.clickBtn(By.xpath(SUBMIT_BUTTON));
    }

    //populate and assert installation address
    public void populateAndAssertInstallationAddressUnderSITE(String postCode) throws InterruptedException {
        utils.waitForElementVisible(By.id(NEW_PROVIDE_SITEINFO_SCREEN));
        //zooming out to view next button
        utils.zoomOut(By.id(NEW_PROVIDE_SITEINFO_SCREEN));
        Thread.sleep(1000);
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
            utils.sendText(By.id(EMERGENCY_INFO_TEXTBOX), message);
        } catch (Exception e) {
            utils.waitForElementVisible(By.id(EMERGENCY_INFO_TEXTBOX));
            utils.sendText(By.id(EMERGENCY_INFO_TEXTBOX), message);
        }

    }

    public void populateSiteContactUnderSITE(String number) {
        //select contact from the list
        utils.selectByVisibleText(By.id(SELECT_CONTACT_UNDER_SITEINFO), ", Jeroen");
        //assert that the contact phone number is mandatory(click next with out selecting the phone number)
        utils.clickBtn(By.xpath(NEXT_BUTTON));
        //verify the presence of error message
        utils.waitForElementVisible(By.xpath(PHONE_NUMBER_MANDATORY_ERROR_MESSAGE));
        //enter contact phone number
        utils.sendText(By.id(TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO), number);
        //verify the entered emergency info is saved by clicking next button
        utils.clickBtn(By.xpath(NEXT_BUTTON));
        //and coming back by clicking previous button
        utils.waitForElementVisible(By.xpath(PREVIOUS_BUTTON));
        utils.clickBtn(By.xpath(PREVIOUS_BUTTON));
        //assert that the emergency info is saved
        String text = utils.getAttributeOfElement(By.id(EMERGENCY_INFO_TEXTBOX), "value");
        Assert.assertEquals(text, "emergency info");
    }

    public void editAndAssertServicesChargesUnderSITE(String charges) {
        utils.clickBtn(By.xpath(EDIT_SERVICECHARGES_BUTTON));
        utils.waitForElementVisible(By.xpath(SAVE_SERVICECHARGES_BUTTON));
        utils.sendText(By.id(ANALOGUE_MULTILINE_INSTALLATION_CHARGE), "" + charges + "");
        utils.clickBtn(By.xpath(SAVE_SERVICECHARGES_BUTTON));
        utils.waitForElementVisible(By.xpath("//td[text()='£" + charges + ".00']"));
    }

    public void navigateToNextScreen() {
        utils.clickBtn(By.xpath(NEXT_BUTTON));
    }


    public void populateLinePlantSummaryUnderPROVISION() throws InterruptedException {
        //verify the error message when termination type is not selected
        utils.waitForElementVisible(By.xpath(LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO));
        utils.clickBtn(By.xpath(NEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(TERMINATION_TYPE_MANDATORY_ERROR_MESSAGE));

        //select the termination type from the dropDown
        utils.selectByIndex(By.id(TERMINATION_TYPE_DROPDOWN_UNDER_SITEINFO), 1);

        //verify the install type pop up
        utils.clickBtn(By.id(INSTALLATION_TYPE_GUIDANCE_TAB));
        utils.waitForElementVisible(By.xpath(TEXT_ON_INSTALLATION_TYPE_GUIDANCE_PAGE));
        utils.clickBtn(By.xpath(INSTALLATION_TYPE_GUIDANCE_POPUP_CLOSEBTN));
        utils.waitForElementVisible(By.xpath(LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO));
        Thread.sleep(1000);

        //decrease the number of lines and assert
        utils.clickBtn(By.xpath(DECREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO));
        String decreaseValue = utils.getAttributeOfElement(By.id(NUMBER_OF_LINES_TEXT_BOX_UNDER_INSTALLATION_INFO), "value");
        Assert.assertEquals(decreaseValue, "2");
        //increase the number of lines and assert
        utils.clickBtn(By.xpath(INCREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO));
        String increaseValue = utils.getAttributeOfElement(By.id(NUMBER_OF_LINES_TEXT_BOX_UNDER_INSTALLATION_INFO), "value");
        Assert.assertEquals(increaseValue, "3");

        //view working lines popup
        utils.clickBtn(By.id(VIEW_WORKING_LINES_UNDER_LINE_PLANT_SUMMARY));
        utils.waitForElementVisible(By.xpath(TEXT_ON_WORKING_LINES_POPUP));
        utils.clickBtn(By.xpath(WORKING_LINES_POPUP_CLOSEBTN));
    }

    public void populatingEngineeringNotesUnderENGINEERING(String notes) {
        utils.waitForElementVisible(By.xpath(ENGINEERING_INFO_TEXT_UNDER_SITEINFO));
        utils.sendText(By.id(ENGINEERING_NOTES_TEXTBOX_UNDER_SITEINFO), notes);
    }

    public void populateNetworkFeaturesUnderFEATURES() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(NETWORK_FEATURES_TEXT));
        //select call diversion
        utils.makeSureBoxIsChecked(By.id(CALL_DIVERSION_RADIOBUTTON_UNDER_NETWORK_FEATURES), By.id(CALL_DIVERSION_RADIOBUTTON_UNDER_NETWORK_FEATURES));
        utils.waitForElementVisible(By.id(CALL_DIVERSION_RADIOBTN_UNDER_NETWORK_FEATURES));
        //select busyOutLine radio tab
        utils.makeSureBoxIsChecked(By.id(CALL_DIVERSION_RADIOBTN_UNDER_NETWORK_FEATURES), By.id(CALL_DIVERSION_RADIOBTN_UNDER_NETWORK_FEATURES));
        Thread.sleep(1000);
        //un-check the 3rd radio button under busyOutLine
        utils.makeSureBoxIsUnChecked(By.id(BUSY_OUT_LINE_RADIOBTN_UNDER_NETWORK_FEATURES), By.id(BUSY_OUT_LINE_RADIOBTN_UNDER_NETWORK_FEATURES));
    }

    public void PopulateDirectoryInfoUnderNUMBERING(String info) throws InterruptedException {
        utils.waitForElementVisible(By.id(BUSINESS_DESC_TEXTBOX_UNDER_DIRECTORY_INFO));
        //check residential tab under directory location
        utils.clickBtn(By.id(RESIDENTIAL_RADIOBTN_UNDER_DIRECTORYINFO));
        //assert that the error is thrown when the contact and initials are not populated
        utils.clickBtn(By.xpath(NEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(MANDATORYMSG_FOR_RESIDENTIAL_UNDER_DIRECTORY_INFO));
        //populate contact,initials and surname
        utils.selectByVisibleText(By.id(CONTACT_TITLE_UNDER_DIRECTORY_INFO), "Dr");
        utils.sendText(By.id(CONTACT_INITIALS_UNDER_DIRECTORY_INFO), "AJ");
        utils.sendText(By.id(CONTACT_SURNAME_UNDER_DIRECTORY_INFO), info);
    }

    public void verifyLineNumberingUnderNUMBERING() throws InterruptedException {
        //click advanced line numbering options
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        //verify the functionality of automatically assign now
        utils.waitForElementVisible(By.xpath(wlr3_lineNumberingPage.AUTOMATICALLY_ASSIGN_NOWTAB_UNDER_LINE_INFO));
        utils.clickBtn(By.xpath(wlr3_lineNumberingPage.AUTOMATICALLY_ASSIGN_NOWTAB_UNDER_LINE_INFO));
        utils.waitForElementVisible(By.xpath(wlr3_lineNumberingPage.ALLOCATENOW_TAB_UNDER_AUTOMATICALLY_ASSIGN_NOW_LINE_INFO));
        utils.clickBtn(By.xpath(wlr3_lineNumberingPage.ALLOCATENOW_TAB_UNDER_AUTOMATICALLY_ASSIGN_NOW_LINE_INFO));
        utils.waitForElementVisible(By.xpath(wlr3_lineNumberingPage.CONTINUETAB_UNDER_LINE_INFO));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(wlr3_lineNumberingPage.CONTINUETAB_UNDER_LINE_INFO));
        utils.waitForElementVisible(By.xpath(NUMBER_RESERVATION_CONFIRMATION_UNDER_LINE_NUMBERING));
    }

    public void populateHazardAndWarningNotesUnderDATE(String hazardNotes, String warningNotes) {
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

    public void verifyOrderCompletion() throws InterruptedException {
        //load created quote
        try {
            utils.getOrdersPage();
            ordersManagerPage.clickOnQuoteID();
        } catch (Exception e) {
        }
        utils.jumpToPopUpWindow(By.xpath(editOrderPage.QUOTEID_ON_EDITORDER_PAGE));
        // check for the green tick
        utils.waitForElementVisible(By.xpath(editOrderPage.GREEN_TICK));
        //zoom in to 100%
        try {
            utils.zoomIn(By.xpath(editOrderPage.GREEN_TICK));
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
}
