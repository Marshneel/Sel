package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

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
    public final String CARE_LEVEL_PLAN_WARNING_MESSAGE = "//div[@id='divValidationMessages']//div[contains(text(),'Care Level must be 2.5 or higher for Premium lines')]";
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

    CompanyMenuPage companyMenuPage = new CompanyMenuPage();
    ElementUtils utils = new ElementUtils();
    OrdersManagerPage ordersManagerPage = new OrdersManagerPage();
    CommonMethods commonMethods = new CommonMethods();

    public void enterPhoneNumberAndPostCodeToInitiateTheTransfer(String number, String postCode) {
        utils.waitForElementVisible(By.id(SAVE));
        utils.clickBtn(By.id(companyMenuPage.CLI_NUMBER_FIELD));
        utils.sendText(By.id(companyMenuPage.CLI_NUMBER_FIELD), number);
        utils.clickBtn(By.id(POSTCODE_SEARCH_POSTCODE_FIELD));
        utils.sendText(By.id(POSTCODE_SEARCH_POSTCODE_FIELD), postCode);
        utils.clickBtn(By.id(SAVE));

    }

    public void assertAddress(String roadName, String premiseName, String subpremiseName, String premiseNumber) throws InterruptedException {
       utils.waitForElementVisible(By.xpath("//p[contains(text(),'"+subpremiseName+", "+premiseName+", "+premiseNumber+" "+roadName+", Luton, LU1 1DQ')]"));
    }

    public void pickAndAssertPostCodeOnWLR3OrderPage(String postCode) throws InterruptedException {

        utils.clickBtn(By.id(ADDRESS_SEARCH_RESULT));
        utils.javaScriptExecutorClick(By.xpath(CONTINUE_AFTER_ADDRESS_IS_CHOOSEN));
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage();
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

    public void assertPopulatedNetworkCallingFeaturesOnWlr3OrderPage() throws InterruptedException {
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage();
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

    public void assertDepopulatedNetworkCallingFeaturesOnWlr3OrderPage() throws InterruptedException {
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id(NETWORK_FEATURES_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(NETWORK_FEATURES_BUTTON));
        utils.assertElementNotPresent(By.xpath(ADMIN_CONT_CAL_DIV_ON_ORDER_DETAIL_PAGE));
        utils.assertElementNotPresent(By.xpath(ANO_CAL_REJ_UNDER_ON_ORDER_DETAIL_PAGE));
    }

    public void assertDepopularedDirectoryInformationOnWlr3OrderPage() throws InterruptedException {
        utils.waitForElementVisible(By.id(DIRECTORY_INFO_SUMMARY_PANEL));
        utils.waitForElementToVanish(By.xpath(SURNAME_OF_DIRECTORY_INFO_ON_WLR3_ORDER_PAGE));
    }

    public void assertDepopulatedSiteInformationOnWLR3OrderPage() throws InterruptedException {
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id(SITE_INFO_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(SITE_INFORMATION_BUTTON));
        utils.waitForElementToVanish(By.xpath(SITE_CONTACT_NAME_ON_WLR3_ORDER_PAGE));
        utils.waitForElementToVanish(By.xpath(SITE_EMAILID_ON_WLR3_ORDER_PAGE));
    }

    public void clickLineNumbering() throws InterruptedException {
        textOnWLR3OrderPage();
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


    public void assertImportedLineWithChangeOfPostCodeAndAidOfGoldAddress(String importedNumber) throws InterruptedException {
        textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id(LINE_NUMBERING_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }

    public void assertImportedLineWithAidOfLetterOfAuthority(String importedNumber) throws InterruptedException {
        textOnWLR3OrderPage();
        utils.refreshPage();
        utils.jumpToPopUpWindow(By.xpath(ITEMID_ON_EDITORDER));
        utils.waitForElementVisible(By.id(LINE_NUMBERING_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }

    public void assertNumberImportedWithVic(String importedNumber, String vic) throws InterruptedException {
        textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id(LINE_NUMBERING_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath("//p[@id='display_WLR3Order_vic'][contains(text(),'" + vic + "')]"));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }

    public void textOnWLR3OrderPage() throws InterruptedException {
        try {
            utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        } catch (Exception e) {
            getToWLR3QuotePage();
        }
    }

    public void getToWLR3QuotePage() throws InterruptedException {
        utils.getOrdersPage();
       ordersManagerPage.clickOnQuoteID();
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

    public void enterEmergencyInfo() throws InterruptedException {
        textOnWLR3OrderPage();
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

    public void loadTabOnWLR3OrderSummaryPage() throws InterruptedException {
        utils.getOrdersPage();
        ordersManagerPage.clickOnQuoteID();
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
    }


