package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.sql.SQLException;

/**
 * Created by rajeshg on 24/10/2016.
 */
public class WLR3_OrderDetails_Page {

    // TODO: 06/01/2017
    public final String TEXT_ON_WLR3_ORDER_DETAIL_PAGE = "//h3[contains(text(),'WLR3 Quote')]";
    public final String ADDRESS_SEARCH_RESULT = "address_0";
    public final String CONTINUE_AFTER_ADDRESS_IS_CHOOSEN = "//button[text()='Continue']";
    public final String POSTCODE_SEARCH_POSTCODE_FIELD = "Postcode";
    public final String NETWORK_FEATURES_BUTTON = "//a[contains(@onclick,'return showNetworkFeatures')]";
    public final String SITE_INFORMATION_BUTTON = "//a[contains(@onclick,'return showSiteInformation')]";
    public final String DIRECTORY_INFORMATION_BUTTON = "//a[contains(@onclick,'loadDirectoryInformationPopup')]";
    public final String SAVE = "saveBtn";
    public final String CANCEL = "cancelBtn";
    private final String INVALID_ADDRESSKEY = "//span[text()='Invalid Address Key']";
    public final String ADDRESS_SEARCH_RESULT_FOR_LU1_1DQ_ON_WLR3_ORDER_PAGE = "//p[@id='display_WLR3Order_addr_postcode'][contains(text(),'LU1 1DQ')]";
    private final String LINE_NUMBERING_BUTTON = "//a[contains(@onclick,'loadLineNumbering')]";
    private final String ADMIN_CONT_CAL_DIV_ON_ORDER_DETAIL_PAGE = "//label[@class='networkFeature'][contains(text(),'Admin Controlled Call Diversion')]";
    private final String SURNAME_OF_DIRECTORY_INFO_ON_WLR3_ORDER_PAGE = "//p[text()='Telecom ']";
    private final String ANO_CAL_REJ_UNDER_ON_ORDER_DETAIL_PAGE = "//label[@class='text-success'][text()[contains(.,'Anonymous Call Reject')]]";
    private final String SITE_CONTACT_NAME_ON_WLR3_ORDER_PAGE = "//p[@id='display_WLR3Order_contact_name'][contains(text(),'Jeroen')]";
    private final String SITE_EMAILID_ON_WLR3_ORDER_PAGE = "//p[@id='display_WLR3Order_contact_email'][contains(text(),'Jeroen@vodafone.co.uk')]";
    public final String ITEMID_ON_EDITORDER = "//a[contains(@onclick,'OpenNewWLR3OrderDetailPopup')]";
    private final String CONTINUETAB_UNDER_NOCHANGE_LINE_INFO = "//a[@onclick='lineNumbering.submitChanges(0);']";
    public final String APPOINTMENT_TAB_ON_WLR3_ORDER_PAGE = "//a[contains(@onclick,'showNewBookAppointment')]";
    private final String TEXT_ON_APPOINTMENT_PAGE = "//legend[text()='Hazard and Warning Notes']";
    private final String ORDERTYPE_TAB = "//a[contains(@onclick,'loadOrderTypePopup')]";
    public final String LINE_INFO_TAB = "//a[contains(@onclick,'loadLineInformationPopup')]";
    private final String HAZARD_ASSERTION_TEXT = "//div[@id='appointmentSummaryPanel']//p[contains(text(),'hazard note')]";
    private final String WARNING_ASSERTION_TEXT = "//div[@id='appointmentSummaryPanel']//p[contains(text(),'warning notes')]";
    private final String ACTIVE_ANONYMOUS_CALL_REJECT = "//div[@id='networkFeaturesSummaryPanel']//label[contains(text(),'Anonymous Call Reject')]";
    private final String INACTIVE_ANONYMOUS_CALL_REJECT = "//label[@class='networkFeatureDelete'][contains(text(),'Anonymous Call Reject')]";
    private final String EDIT_SITEINFO_FOR_INCREASE = "//div[@id='divValidationMessages']//a[contains(@onclick,'SiteInformation')]";
    private final String SITE_INFO_FOR_LINE_DECREASE = "//div[@id='siteInformationSummaryPanel']//a";
    public final String PAGE_LOADER_ELEMENT = "//div[@id='pageLoader'][@class='page-loader']";
    private final String TEXT_UNDER_DIRECTORY_INFO_SUMMARY_PANEL = "//div[@id='directoryInformationSummaryPanel']//p[contains(text(),'Telecom')]";
    private final String TEXT_UNDER_NETWORK_FEATURES_SUMMARY_PANEL = "//div[@id='networkFeaturesSummaryPanel']//label[contains(text(),'Anonymous Call Reject')]";
    public final String LINE_NUMBERING_SUMMARY_PANEL = "lineNumberingSummaryPanel";
    public final String SITE_INFO_SUMMARY_PANEL = "siteInformationSummaryPanel";
    public final String INSTALLATION_ADDRESS_SUMMARY_PANEL = "installationAddressSummaryPanel";
    public final String NETWORK_FEATURES_SUMMARY_PANEL = "networkFeaturesSummaryPanel";
    public final String DIRECTORY_INFO_SUMMARY_PANEL = "directoryInformationSummaryPanel";
    private final String EDIT_EMERGENCY_INFO_TAB = "div_EmergencyInfo";
    public final String EMERGENCY_INFO_TEXT_BOX = "EmergencyInfo";
    private final String SAVE_EMERGENCY_INFO = "//img[contains(@onclick,'jet_update_value_FromTextbox')]";
    public final String MANUAL_ENTRY_TAB = "manualEntryBtn";
    private final String WLR3_WARNING_PANEL_LOCATOR = "//div[@id='WLR3OrderWarnings']";
    private final String ISDN_LABEL_UNDERCHARGES = "//div[@id='chargesSummaryPanel']//td[contains(text(),'ISDN30E')]";
    private final String SNDDI_LABEL_UNDER_DIRINFO = "//b[contains(text(),'SNDDI - To be allocated')]";
    private final String AUTOMATICALLY_ALLOCATED_TEXT_UNDER_LINNUM = "//div[contains(text(),'Automatically allocated')]";
    private final String TEXT_ON_CHANGE_OF_ADDRESS_POPUP = "//div[@id='wlr3OrderDetailPopupDiv']//h3[contains(text(),'WLR3 Change Of Address Order')]";
    private final String BUSINESS_CONTINUITY_LABEL_ON_THE_BUSINESS_CONTINUITY_POPUP = "//h4[contains(text(),'Business Continuity Alert!')]";
    private final String YES_BUTTON_ON_POPUP = "//button[contains(text(),'Yes')]";
    private final String BUSINESS_CONTINUITY_LABEL_ON_BUSINESS_CONTINUITY_CHECKBOX_POPUP = "//h3[contains(text(),'Business Continuity')]";
    private final String OPEN_REACH_MANAGED_ERROR_MESSAGE_FOR_ISDN30="//div[contains(text(),'Currently Openreach does not allow Openreach Managed change of address for ISDN30 orders')]";
    private final String EDIT_OPENREACH_MANAGED="//div[@id='div_coa_openreach']//div[@id='divLabel']/img";
    private final String OPENREACH_MANAGED_DROP_DOWN="coa_openreach";
    private final String SAVE_EDITED_OPENREACH_MANAGED="//img[contains(@onclick,'jet_update_value_FromDropdown')]";
    private final String ERROR_MESSAGE_POINT_TO_POINT__TO__POINT_TO_MULTIPOINT="//div[contains(text(),'An ISDN2 System line must be set to Point-To-Point configuration when either DDI Ranges or more than 1 SNDDI is selected')]";
    private final String POINT_TO_MULTIPOINT_TEXT_ON_SUMMARY_PAGE="//p[contains(text(),'Point-to-Multipoint')]";
    private final String POINT_TO_POINT_TEXT_ON_SUMMARY_PAGE="//p[contains(text(),'Point-to-Point')]";
    public final String TEXT_ON_SITE_INFORMATION = "//legend[text()='Site Contact']";
    private final String HAZARD_NOTES_REQUISITION_ERROR_MESSAGE="//div[contains(text(),'An engineer visit is required, but Hazard Notes have not been supplied')]";
    private final String WARNING_NOTES_REQUISITION_ERROR_MESSAGE="//div[contains(text(),'An engineer visit is required, but Warning Notes have not been supplied')]";
    private final String EDIT_NUMBER_OF_CHANNELS="//div[@id='div_WLR3Order_num_lines']//img[contains(@onclick,'editMode')]";
    private final String SAVE_CHANGES_AFTER_QUICK_EDIT_ON_ORDER_SUMMARY_PAGE="//img[contains(@onclick,'jet_update_value_FromTextbox')]";
    public final String EDIT_NUMBER_OF_CHANNELS_TEXT_BOX="WLR3Order_num_lines";
    private final String NO_ENGINEERING_NOTES_WITH_OUT_SITE_VISIT_MESSAGE="//div[contains(text(),'Engineering Notes cannot be entered when an engineer visit is not required')]";



    CompanyMenuPage companyMenuPage = new CompanyMenuPage();
    ElementUtils utils = new ElementUtils();
    OrdersManagerPage ordersManagerPage = new OrdersManagerPage();
    CommonMethods commonMethods = new CommonMethods();
    NewBusinessCustomerPage newBusinessCustomerPage=new NewBusinessCustomerPage();

    public void enterPhoneNumberAndPostCodeToInitiateTheTransfer(String number, String postCode) {
        utils.waitForElementVisible(By.id(SAVE));
        utils.clickBtn(By.id(companyMenuPage.CLI_NUMBER_FIELD));
        utils.sendText(By.id(companyMenuPage.CLI_NUMBER_FIELD), number);
        utils.clickBtn(By.id(POSTCODE_SEARCH_POSTCODE_FIELD));
        utils.sendText(By.id(POSTCODE_SEARCH_POSTCODE_FIELD), postCode);
        utils.clickBtn(By.id(SAVE));

    }

    public void assertAddress(String roadName, String premiseName, String subpremiseName, String premiseNumber, String addressKey) throws InterruptedException {
       utils.waitForElementVisible(By.xpath("//p[contains(text(),'"+subpremiseName+", "+premiseName+", "+premiseNumber+" "+roadName+", Luton, LU1 1DQ')]"));
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'Address Key: "+addressKey+"')]"));
    }

    public void pickAndAssertPostCodeOnWLR3OrderPage(String type, String postCode) throws InterruptedException, SQLException {

        utils.clickBtn(By.id(ADDRESS_SEARCH_RESULT));
        utils.javaScriptExecutorClick(By.xpath(CONTINUE_AFTER_ADDRESS_IS_CHOOSEN));
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage(type);
        utils.waitForElementVisible(By.id(INSTALLATION_ADDRESS_SUMMARY_PANEL));
        utils.verifyStringMatch(By.xpath(ADDRESS_SEARCH_RESULT_FOR_LU1_1DQ_ON_WLR3_ORDER_PAGE), postCode);
    }

    public void pickAddressFromSearchResults() throws InterruptedException {
        utils.clickBtn(By.id(ADDRESS_SEARCH_RESULT));
        utils.waitForElementVisible(By.xpath(PAGE_LOADER_ELEMENT));
        utils.javaScriptExecutorClick(By.xpath(CONTINUE_AFTER_ADDRESS_IS_CHOOSEN));
        utils.jumpToParentPopUp();
    }

    public void assertErrorMessageUponEnteringInvalidAddressKey() {
        utils.waitForElementVisible(By.xpath(INVALID_ADDRESSKEY));
    }

    public void assertPopulatedNetworkCallingFeaturesOnWlr3OrderPage(String type) throws InterruptedException, SQLException {
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage(type);
        utils.waitForElementVisible(By.id(NETWORK_FEATURES_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(ADMIN_CONT_CAL_DIV_ON_ORDER_DETAIL_PAGE));
        utils.waitForElementVisible(By.xpath(ANO_CAL_REJ_UNDER_ON_ORDER_DETAIL_PAGE));
    }

    public void assertPopulatedDirectoryInformationOnWlr3OrderPage() throws InterruptedException {
        utils.waitForElementVisible(By.id(DIRECTORY_INFO_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(SURNAME_OF_DIRECTORY_INFO_ON_WLR3_ORDER_PAGE));
    }

    public void assertPopulatedSiteContactsOnWLR3OrderPage() throws InterruptedException {
        utils.waitForElementVisible(By.id(SITE_INFO_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(SITE_CONTACT_NAME_ON_WLR3_ORDER_PAGE));
        utils.waitForElementVisible(By.xpath(SITE_EMAILID_ON_WLR3_ORDER_PAGE));
    }

    public void assertDepopulatedNetworkCallingFeaturesOnWlr3OrderPage() throws InterruptedException, SQLException {
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage(newBusinessCustomerPage.RanName);
        utils.waitForElementVisible(By.id(NETWORK_FEATURES_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(NETWORK_FEATURES_BUTTON));
        utils.assertElementNotPresent(By.xpath(ADMIN_CONT_CAL_DIV_ON_ORDER_DETAIL_PAGE));
        utils.assertElementNotPresent(By.xpath(ANO_CAL_REJ_UNDER_ON_ORDER_DETAIL_PAGE));
    }

    public void assertDepopularedDirectoryInformationOnWlr3OrderPage() throws InterruptedException {
        utils.waitForElementVisible(By.id(DIRECTORY_INFO_SUMMARY_PANEL));
        utils.waitForElementToVanish(By.xpath(SURNAME_OF_DIRECTORY_INFO_ON_WLR3_ORDER_PAGE));
    }

    public void assertDepopulatedSiteInformationOnWLR3OrderPage(String type) throws InterruptedException, SQLException {
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage(type);
        utils.waitForElementVisible(By.id(SITE_INFO_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(SITE_INFORMATION_BUTTON));
        utils.waitForElementToVanish(By.xpath(SITE_CONTACT_NAME_ON_WLR3_ORDER_PAGE));
        utils.waitForElementToVanish(By.xpath(SITE_EMAILID_ON_WLR3_ORDER_PAGE));
    }

    public void clickLineNumbering(String type) throws InterruptedException, SQLException {
        textOnWLR3OrderPage(type);
        utils.waitForElementVisible(By.id(LINE_NUMBERING_SUMMARY_PANEL));
        try {
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(LINE_NUMBERING_BUTTON));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(LINE_NUMBERING_BUTTON));
        }
    }

    public void lineNumberingNoChangeWithAssertions(String number) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//h1[text()='" + number + "']"));
        utils.clickBtn(By.xpath(CONTINUETAB_UNDER_NOCHANGE_LINE_INFO));
        utils.jumpToParentPopUp();
        utils.waitForElementVisible(By.id(LINE_NUMBERING_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][contains(text(),'" + number + "')]"));
    }

    public void clickOnAppointment() {
        utils.clickBtn(By.xpath(APPOINTMENT_TAB_ON_WLR3_ORDER_PAGE));
        utils.waitForElementVisible(By.xpath(TEXT_ON_APPOINTMENT_PAGE));
    }


    public void assertImportedLineWithChangeOfPostCodeAndAidOfGoldAddress(String type, String importedNumber) throws InterruptedException, SQLException {
        textOnWLR3OrderPage(type);
        utils.waitForElementVisible(By.id(LINE_NUMBERING_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }

    public void assertImportedLineWithAidOfLetterOfAuthority(String type, String importedNumber) throws InterruptedException, SQLException {
        textOnWLR3OrderPage(type);
        utils.refreshPage();
        utils.jumpToPopUpWindow(By.xpath(ITEMID_ON_EDITORDER));
        utils.waitForElementVisible(By.id(LINE_NUMBERING_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }

    public void assertNumberImportedWithVic(String type, String importedNumber, String vic) throws InterruptedException, SQLException {
        textOnWLR3OrderPage(type);
        utils.waitForElementVisible(By.id(LINE_NUMBERING_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath("//p[@id='display_WLR3Order_vic'][contains(text(),'" + vic + "')]"));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }

    public void textOnWLR3OrderPage(String type) throws InterruptedException, SQLException {
        try {
            utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        } catch (Exception e) {
            getToWLR3QuotePage(type);
        }
    }
    public void assertTextOnWLR3OrderPage(){
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
    }

    public void getToWLR3QuotePage(String type) throws InterruptedException, SQLException {
        Thread.sleep(2000);
        utils.getOrdersPage();
        clickOnQuoteID(type);
    }
        public void clickOnQuoteID(String type) throws InterruptedException, SQLException {
           ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(type);
            utils.waitForElementVisible(By.xpath(ITEMID_ON_EDITORDER));
            utils.clickBtn(By.xpath(ITEMID_ON_EDITORDER));
            utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
       }


    public void verifyOrderTypeTab() throws InterruptedException {
        Thread.sleep(1000);
        try {
            utils.javaScriptExecutorClick(By.xpath(ORDERTYPE_TAB));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.javaScriptExecutorClick(By.xpath(ORDERTYPE_TAB));
        }
        utils.waitForElementVisible(By.xpath("//h3[contains(text(),'Order Type')]"));
        try {
            Thread.sleep(1000);
            utils.clickBtn(By.id(CANCEL));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.javaScriptExecutorClick(By.id(CANCEL));
        }
    }

    public void assertAppointmentInfo() {
        utils.waitForElementVisible(By.xpath(HAZARD_ASSERTION_TEXT));
        utils.waitForElementVisible(By.xpath(WARNING_ASSERTION_TEXT));
    }

    public void checkNetworkCallFeaturesBeforeRemoval() {
        utils.waitForElementVisible(By.xpath(ACTIVE_ANONYMOUS_CALL_REJECT));
    }

    public void checkNetworkCallFeaturesAfterRemoval() {
        utils.waitForElementVisible(By.xpath(INACTIVE_ANONYMOUS_CALL_REJECT));
    }

    public void assertQuoteForCeaseOrder() {
        utils.assertElementNotPresent(By.xpath(LINE_NUMBERING_BUTTON));
        utils.assertElementNotPresent(By.xpath(DIRECTORY_INFORMATION_BUTTON));
        utils.assertElementNotPresent(By.xpath(LINE_INFO_TAB));
    }

    public void clickOnSiteInfoErrorTabForIncrease() throws InterruptedException {
        try {
            utils.clickBtn(By.xpath(EDIT_SITEINFO_FOR_INCREASE));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(EDIT_SITEINFO_FOR_INCREASE));
        }
    }

    public void clickOnSiteInfoErrorTabForDecrease() throws InterruptedException {
        try {
            utils.clickBtn(By.xpath(SITE_INFO_FOR_LINE_DECREASE));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(SITE_INFO_FOR_LINE_DECREASE));
        }
    }

    public void assertQuoteSummaryPageForAddAuxLine() {
        utils.waitForElementVisible(By.xpath(LINE_INFO_TAB));
        utils.waitForElementVisible(By.xpath(NETWORK_FEATURES_BUTTON));
    }

    public void assertQuoteSummaryPageForRemoveAuxLine() {
        utils.assertElementNotPresent(By.xpath(LINE_INFO_TAB));
        utils.assertElementNotPresent(By.xpath(NETWORK_FEATURES_BUTTON));
    }

    public void enterEmergencyInfo(String type) throws InterruptedException, SQLException {
        textOnWLR3OrderPage(type);
        utils.waitForElementVisible(By.xpath(PAGE_LOADER_ELEMENT));
        utils.waitForElementVisible(By.id(EDIT_EMERGENCY_INFO_TAB));
        // Thread.sleep(1000);
        utils.clickBtn(By.id(EDIT_EMERGENCY_INFO_TAB));
        utils.sendText(By.id(EMERGENCY_INFO_TEXT_BOX), EMERGENCY_INFO_TEXT_BOX);
        utils.clickBtn(By.xpath(SAVE_EMERGENCY_INFO));
    }

    public void assertChangesForAmendOrder() {
        utils.waitForElementVisible(By.xpath(TEXT_UNDER_NETWORK_FEATURES_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(TEXT_UNDER_DIRECTORY_INFO_SUMMARY_PANEL));
    }

    public void verifyCommonNetworkCallingFeaturesForSingleLine(String ntWrkFtre_one, String ntWrkFtre_two) {
        utils.waitForElementVisible(By.xpath("//div[@id='networkFeaturesSummaryPanel']//label[contains(text(),'" + ntWrkFtre_one + "')]"));
        utils.waitForElementVisible(By.xpath("//div[@id='networkFeaturesSummaryPanel']//label[contains(text(),'" + ntWrkFtre_two + "')]"));

    }

    public void assertNtwrkCallFeaturesAndDirectoryInfoForMultiLine(String ntWrkFtre) {
        utils.assertElementNotPresent(By.xpath("//div[@id='networkFeaturesSummaryPanel']//label[contains(text(),'" + ntWrkFtre + "')]"));
        utils.assertElementNotPresent(By.xpath("//div[@id='directoryInformationSummaryPanel']//b[contains(text(),'" + ntWrkFtre + "')]"));
    }

    public void assertCLI(String CLI) {
        utils.waitForElementVisible(By.xpath("//div[@id='lineNumberingSummaryPanel']//p[contains(text(),'" + CLI + "')]"));
    }

    public void assertLineCharges(String changedLine) {
        utils.waitForElementVisible(By.xpath("//div[@id='chargesSummaryPanel']//td[contains(text(),'" + changedLine + "')]"));
    }

    public void assertAbsenceOfTerminationType(String terminationType) {
        utils.assertElementNotPresent(By.xpath("//label[text()='Termination']"));
        utils.assertElementNotPresent(By.xpath("//p[@id='display_TerminationType'][contains(text(),'" + terminationType + "')]"));
    }

    public void assertValidationMessageOnOrderDetailsPage(String incompleteContactDetails) {
        //assert validation message for incomplete contact details
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'" + incompleteContactDetails + "')]"));
    }

    public void assertWarningMessageOnSummaryPage(String warning) {
        utils.searchAndAssertTextPresent(By.xpath(WLR3_WARNING_PANEL_LOCATOR), "" + warning + "");
    }

    public void assertingTheNumberOfLinesForMultiLineSwitch(String number) {
        utils.waitForElementVisible(By.xpath("//span[text()='" + number + "']"));
    }

    public void assertingTheNumberOfLinesForSingleLineSwitch(String number) {
        utils.assertElementNotPresent(By.xpath("//span[text()='" + number + "']"));
    }

    public void assertTheAbsenceOfFeatureUnderNetworkFeatures(String ntwrkFeature) {
        utils.assertElementNotPresent(By.xpath("//ul[@id='directoryInformationNavigation']//a[contains(text(),'" + ntwrkFeature + "')]"));

    }

    public void assertISDNNewProvideSummaryPage(String numberOfChannels, String ddiRange) {
        utils.waitForElementVisible(By.xpath(ISDN_LABEL_UNDERCHARGES));
        utils.waitForElementVisible(By.xpath(SNDDI_LABEL_UNDER_DIRINFO));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'" + numberOfChannels + "')]"));
        utils.waitForElementVisible(By.xpath(AUTOMATICALLY_ALLOCATED_TEXT_UNDER_LINNUM));
        utils.waitForElementVisible(By.xpath("//div[@id='lineNumberingSummaryPanel']//label[contains(text(),'DDI range of " + ddiRange + "')]"));
    }

    public void assertBusinessContinuity() {
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Site Assurance Option 1')]"));

    }

    public void assertLineNumberingForISDN(String action1, String action2) {
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'" + action1 + "')]"));
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'" + action2 + "')]"));
    }

    public void loadTabOnWLR3OrderSummaryPage() throws InterruptedException, SQLException {
        ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
        utils.waitForElementVisible(By.xpath(ITEMID_ON_EDITORDER));
        utils.clickBtn(By.xpath(ITEMID_ON_EDITORDER));
    }

    public void siteInfoValidationMessagesForISDN2OnOrderSummaryPage() {
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'You must specify a Floor for Digital products')]"));
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'You must specify a Room for Digital products')]"));
    }

    public void editTabsForISDN30AmendWithCustomerDelayReason() throws InterruptedException {
        //appointment tab
        utils.waitForElementVisible(By.xpath(APPOINTMENT_TAB_ON_WLR3_ORDER_PAGE));
        clickOnAppointment();
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(commonMethods.CLOSE_POPUP));
        //order type
        utils.waitForElementVisible(By.xpath(ORDERTYPE_TAB));
        verifyOrderTypeTab();

        utils.assertElementNotPresent(By.xpath(SITE_INFORMATION_BUTTON));
    }

    public void editTabsForISDN30AmendOrder() {
        utils.waitForElementVisible(By.xpath(APPOINTMENT_TAB_ON_WLR3_ORDER_PAGE));
        utils.waitForElementVisible(By.xpath(ORDERTYPE_TAB));
        utils.waitForElementVisible(By.xpath(SITE_INFORMATION_BUTTON));

    }

    public void cancelAmendOrder() throws InterruptedException {
        utils.waitForElementVisible(By.id("CancelAmend"));
        Thread.sleep(1000);
        utils.clickBtn(By.id("CancelAmend"));
        utils.waitForElementVisible(By.id("AmendOrder"));
    }

    public void textOnChangeOfAddressOrderPage() {
        utils.waitForElementVisible(By.xpath(TEXT_ON_CHANGE_OF_ADDRESS_POPUP));
    }

    public void processBusinessContinuityAlert() {
        utils.waitForElementVisible(By.xpath(BUSINESS_CONTINUITY_LABEL_ON_THE_BUSINESS_CONTINUITY_POPUP));
        utils.clickBtn(By.xpath(YES_BUTTON_ON_POPUP));
        utils.waitForElementVisible(By.xpath(BUSINESS_CONTINUITY_LABEL_ON_BUSINESS_CONTINUITY_CHECKBOX_POPUP));
        utils.clickBtn(By.id("WLR3Order_site_assurance_option_1"));
        utils.clickBtn(By.id(SAVE));
    }

    public void assertEditedChargesForISDN30Modify() {
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'£100.00')]"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'£200.00')]"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'Annual')]"));
    }

    public void postCodeTextForModifyOrder() {
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Existing Postcode')]"));
    }
    public void assertCallForwardAndRedirect(String existingCLI,String redirectToNumber, String typeOfForward){
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Calls to "+existingCLI+" will be redirected to "+redirectToNumber+"')]"));
    utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+typeOfForward+"')]"));
    }
    public void openReachAddressValidationForISDN30(){
        utils.waitForElementVisible(By.xpath(OPEN_REACH_MANAGED_ERROR_MESSAGE_FOR_ISDN30));
    }
    public void editOpenReachManaged() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(EDIT_OPENREACH_MANAGED));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(EDIT_OPENREACH_MANAGED));
        utils.selectByVisibleText(By.id(OPENREACH_MANAGED_DROP_DOWN),"No (CP Managed)");
        utils.clickBtn(By.xpath(SAVE_EDITED_OPENREACH_MANAGED));
    }
    public void assertingPointToMultiPointTextOnSummaryPage(){
        utils.waitForElementVisible(By.xpath(POINT_TO_MULTIPOINT_TEXT_ON_SUMMARY_PAGE));
    }
    public void assertingPointToPointTextOnSummaryPage(){
        utils.waitForElementVisible(By.xpath(POINT_TO_POINT_TEXT_ON_SUMMARY_PAGE));
    }
    public void assertingErrorMessageChangeFromPointToPoint_To_PointToMultiPoint(){
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_POINT_TO_POINT__TO__POINT_TO_MULTIPOINT));
    }
    public void loadLineInfo() throws InterruptedException, SQLException {
        try {
            utils.waitForElementVisible(By.xpath(PAGE_LOADER_ELEMENT));
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(LINE_INFO_TAB));
        } catch (Exception e) {
            loadTabOnWLR3OrderSummaryPage();
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(LINE_INFO_TAB));
        }}
    public void assertNumberOfDigitsToSwitchOnOrderDetailsPage(String actualNumber){
        utils.waitForElementVisible(By.xpath("//p[@id='display_WLR3Order_digits_to_switch'][contains(text(),'"+actualNumber+"')]"));
    }
    public void clickSiteInfo() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(PAGE_LOADER_ELEMENT));
        utils.waitForElementVisible(By.xpath(SITE_INFORMATION_BUTTON));
        try {Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(SITE_INFORMATION_BUTTON));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(SITE_INFORMATION_BUTTON));
            utils.waitForElementVisible(By.xpath(PAGE_LOADER_ELEMENT));
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(SITE_INFORMATION_BUTTON));
        }
        utils.waitForElementVisible(By.xpath(TEXT_ON_SITE_INFORMATION));
    }
    public void assertErrorMessageForHazardAndWarningNotes(){
        utils.waitForElementVisible(By.xpath(PAGE_LOADER_ELEMENT));
        utils.waitForElementVisible(By.xpath(HAZARD_NOTES_REQUISITION_ERROR_MESSAGE));
        utils.waitForElementVisible(By.xpath(WARNING_NOTES_REQUISITION_ERROR_MESSAGE));
    }
    public void assertAbsenceOfErrorMessageForHazardAndWarningNotes(){
        utils.waitForElementVisible(By.xpath(PAGE_LOADER_ELEMENT));
        utils.assertElementNotPresent(By.xpath(HAZARD_NOTES_REQUISITION_ERROR_MESSAGE));
        utils.assertElementNotPresent(By.xpath(WARNING_NOTES_REQUISITION_ERROR_MESSAGE));
    }
    public void editChannelNumberForPremiumAndISDNlines(String linesOrChannels, String minNumber, String maxNumber){
        utils.waitForElementVisible(By.xpath(EDIT_NUMBER_OF_CHANNELS));
        utils.waitForElementVisible(By.xpath(PAGE_LOADER_ELEMENT));
        utils.clickBtn(By.xpath(EDIT_NUMBER_OF_CHANNELS));
        utils.sendText(By.id(EDIT_NUMBER_OF_CHANNELS_TEXT_BOX),"0");
        utils.clickBtn(By.xpath(SAVE_CHANGES_AFTER_QUICK_EDIT_ON_ORDER_SUMMARY_PAGE));
        // TODO: 26/04/2017  
      utils.waitForElementVisible(By.xpath("//span[contains(text(),'"+linesOrChannels+" must be greater or equal to "+minNumber+" for this product.')]"));
          utils.sendText(By.id(EDIT_NUMBER_OF_CHANNELS_TEXT_BOX),"1000");
          utils.clickBtn(By.xpath(SAVE_CHANGES_AFTER_QUICK_EDIT_ON_ORDER_SUMMARY_PAGE));
          utils.waitForElementVisible(By.xpath("//span[contains(text(),'"+linesOrChannels+" must be less than or equal to "+maxNumber+" for this product.')]"));
          utils.sendText(By.id(EDIT_NUMBER_OF_CHANNELS_TEXT_BOX),"10");
          utils.clickBtn(By.xpath(SAVE_CHANGES_AFTER_QUICK_EDIT_ON_ORDER_SUMMARY_PAGE));}


    public void assertDefaultAndEditableChannels(String defaultChannels){
        utils.waitForElementVisible(By.xpath(EDIT_NUMBER_OF_CHANNELS));
        utils.waitForElementVisible(By.xpath("//span[text()='"+defaultChannels+"']"));
    }
    public void assertErrorMessageForUnwantedEngineeringNotes(){
        utils.waitForElementVisible(By.xpath(NO_ENGINEERING_NOTES_WITH_OUT_SITE_VISIT_MESSAGE));
    }
    public void assertAbsentErrorMessageForUnwantedEngineeringNotes(){
        utils.assertElementNotPresent(By.xpath(NO_ENGINEERING_NOTES_WITH_OUT_SITE_VISIT_MESSAGE));
    }
    public void assertExcessConstructionCharges(String charges){
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+charges+"')]"));
    }
    public void assertExclusiveFeatures(String exclusiveFeature){
        utils.waitForElementVisible(By.xpath("//div[text()[contains(.,'"+exclusiveFeature+"')]]"));
    }

    public void assertCommonFeatures(String commonFeature){
        utils.waitForElementVisible(By.xpath("//label[text()[contains(.,'"+commonFeature+"')]]"));
    }
    public void assertRemovedFeature(String commonFeature){
        utils.assertElementNotPresent(By.xpath("//label[text()[contains(.,'"+commonFeature+"')]]"));
    }
    public void errorMessages_WhenLineIsChangedFromAnalogueToISDN(){
        utils.waitForElementVisible(By.xpath("//div[text()[contains(.,'You must specify a Position for Digital products')]]"));
        utils.waitForElementVisible(By.xpath("//div[text()[contains(.,'You must specify a Room for Digital products')]]"));
        utils.waitForElementVisible(By.xpath("//div[text()[contains(.,'You must specify a Floor for Digital products')]]"));
    }
    public void errorMessagesWhenEngineeringVisitIsRequired(){
        utils.waitForElementVisible(By.xpath("//div[text()[contains(.,'An engineer visit is required, but Hazard Notes have not been supplied')]]"));
        utils.waitForElementVisible(By.xpath("//div[text()[contains(.,'An engineer visit is required, but Warning Notes have not been supplied')]]"));
    }
    public void assertCLIrequiredAlertMessageForVirtualLines(String lineName){
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'A CLI is required for the "+lineName+" Network And Calling Feature')]"));
    }
    public void clickOnTheCLIAlertMessage(){
        utils.waitForElementVisible(By.xpath("//a[contains(@onclick,'wlr3PopupWindows')]"));
        utils.jumpToPopUpWindow(By.xpath("//a[contains(@onclick,'wlr3PopupWindows')]"));

    }
    public void loadNetworkFeatures() throws InterruptedException {
        Thread.sleep(1000);
        utils.waitForElementVisible(By.xpath(PAGE_LOADER_ELEMENT));
        utils.waitForElementVisible(By.xpath("//a[contains(@onclick,'return showNetworkFeaturesPopup')]"));
        utils.clickBtn(By.xpath("//a[contains(@onclick,'return showNetworkFeaturesPopup')]"));
    }
    public void assertSavedSiteContactTelephoneNumber(String telephone){
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'"+telephone+"')]"));
    }
    public void assertTextUnderCharges(String text){
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+text+"')]"));
    }
    public void assertChannelsNotEditable(){
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Number of Channels')]"));
        utils.assertElementNotPresent(By.xpath(EDIT_NUMBER_OF_CHANNELS));
    }
    public void assertChannelsAreEditable(){
        utils.waitForElementVisible(By.xpath(EDIT_NUMBER_OF_CHANNELS));
    }
    public void verifyLineTypeAndProvisionType(String lineType,String provisionType){
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'"+lineType+"')]"));
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'"+provisionType+"')]"));
    }
    public void assertValidationMessageWhenTerminationTypeIsSwitched(){
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'You must select a Signal Type when the Termination Type of NTTP has been specified')]"));
    }
    public void assertCPManaged(){
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'No (CP Managed)')]"));
    }
    public void assertWorkingLineTakeOver(){
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'Working Line Takeover')]"));
    }
    public void loadDirectoryInfo() throws InterruptedException {
        utils.waitForElementVisible(By.id(DIRECTORY_INFO_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(DIRECTORY_INFORMATION_BUTTON));
        Thread.sleep(1000);
        try {
            utils.jumpToPopUpWindow(By.xpath(DIRECTORY_INFORMATION_BUTTON));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.jumpToPopUpWindow(By.xpath(DIRECTORY_INFORMATION_BUTTON));
        }
    }
    public void assertChangedDirectoryType(String line){
        utils.waitForElementVisible(By.xpath("//b[contains(text(),'"+line+"')]/following-sibling::p[contains(text(),'No Directory Entry Required')]"));
    }
    public void checkingValidationForEmergencyInfo(){
        utils.waitForElementVisible(By.xpath("//div[@id='div_EmergencyInfo']//img[contains(@onclick,'editMode')]"));
        utils.clickBtn(By.xpath("//div[@id='div_EmergencyInfo']//img[contains(@onclick,'editMode')]"));
        utils.waitForElementVisible(By.id(EMERGENCY_INFO_TEXT_BOX));
        utils.sendText(By.id(EMERGENCY_INFO_TEXT_BOX),"Emer&*^%");
        utils.clickBtn(By.xpath(SAVE_EMERGENCY_INFO));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Emergency Information can only contain alphanumeric')]"));
        utils.sendText(By.id(EMERGENCY_INFO_TEXT_BOX),"Emergency Info");
        utils.clickBtn(By.xpath(SAVE_EMERGENCY_INFO));


    }
}
