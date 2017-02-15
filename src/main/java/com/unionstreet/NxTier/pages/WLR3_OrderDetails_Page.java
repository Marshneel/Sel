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
    public final String CLOSE = "closeBtn";
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
    private final String ITEMID_ON_EDITORDER = "//a[@href='#'][starts-with(@onclick,'OpenNewWLR3OrderDetailPopup')]";
    private final String CONTINUETAB_UNDER_NOCHANGE_LINE_INFO = "//a[@onclick='lineNumbering.submitChanges(0);']";
    public final String APPOINTMENT_TAB_ON_WLR3_ORDER_PAGE = "//a[contains(@onclick,'showNewBookAppointment')]";
    private final String TEXT_ON_APPOINTMENT_PAGE = "//legend[text()='Hazard and Warning Notes']";
    private final String ORDERTYPE_TAB = "//a[contains(@onclick,'loadOrderTypePopup')]";
    private final String LINE_INFO_TAB = "//a[contains(@onclick,'loadLineInformationPopup')]";
    private final String TEXT_ON_LINEINFO_PAGE = "//h3[contains(text(),'Line Information')]";
    private final String SERVICE_MAINTENANCE_TAB = "WLR3Order_care_level";
    private final String HAZARD_ASSERTION_TEXT = "//div[@id='appointmentSummaryPanel']//p[contains(text(),'hazard note')]";
    private final String WARNING_ASSERTION_TEXT = "//div[@id='appointmentSummaryPanel']//p[contains(text(),'warning notes')]";
    private final String ACTIVE_ANONYMOUS_CALL_REJECT = "//div[@id='networkFeaturesSummaryPanel']//label[contains(text(),'Anonymous Call Reject')]";
    private final String INACTIVE_ANONYMOUS_CALL_REJECT = "//label[@class='networkFeatureDelete'][contains(text(),'Anonymous Call Reject')]";
    private final String EDIT_SITEINFO_FOR_INCREASE = "//div[@id='divValidationMessages']//a[contains(@onclick,'SiteInformation')]";
    private final String SITE_INFO_FOR_LINE_DECREASE = "//div[@id='siteInformationSummaryPanel']//a";

    CompanyMenuPage companyMenuPage = new CompanyMenuPage();
    ElementUtils utils = new ElementUtils();
    OrdersManagerPage ordersManagerPage = new OrdersManagerPage();

    public void enterPhoneNumberAndPostCodeToInitiateTheTransfer(String number, String postCode) {
        utils.waitForElementVisible(By.id(SAVE));
        utils.clickBtn(By.id(companyMenuPage.CLI_NUMBER_FIELD));
        utils.sendText(By.id(companyMenuPage.CLI_NUMBER_FIELD), number);
        utils.clickBtn(By.id(POSTCODE_SEARCH_POSTCODE_FIELD));
        utils.sendText(By.id(POSTCODE_SEARCH_POSTCODE_FIELD), postCode);
        utils.clickBtn(By.id(SAVE));

    }

    public void assertAddress(String roadName, String premiseName, String subpremiseName, String premiseNumber) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//tr[@id='address_0']//td[contains(text(),'"+premiseName+"')]"));
        utils.waitForElementVisible(By.xpath("//tr[@id='address_0']//td[contains(text(),'"+subpremiseName+"')]"));
        utils.waitForElementVisible(By.xpath("//tr[@id='address_0']//td[contains(text(),'"+premiseNumber+"')]"));
        utils.waitForElementVisible(By.xpath("//tr[@id='address_0']//td[contains(text(),'"+roadName+"')]"));
    }

    public void pickAndAssertPostCodeOnWLR3OrderPage(String postCode) throws InterruptedException {

        utils.clickBtn(By.id(ADDRESS_SEARCH_RESULT));
        utils.javaScriptExecutorClick(By.xpath(CONTINUE_AFTER_ADDRESS_IS_CHOOSEN));
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("installationAddressSummaryPanel"));
        utils.verifyStringMatch(By.xpath(ADDRESS_SEARCH_RESULT_FOR_LU1_1DQ_ON_WLR3_ORDER_PAGE), postCode);
    }
    public void pickAddressFromSearchResults() throws InterruptedException {
        utils.clickBtn(By.id(ADDRESS_SEARCH_RESULT));
        utils.waitForElementVisible(By.xpath("//div[@id='pageLoader'][@class='page-loader']"));
        utils.javaScriptExecutorClick(By.xpath(CONTINUE_AFTER_ADDRESS_IS_CHOOSEN));
        utils.jumpToParentPopUp();
    }

    public void assertErrorMessageUponEnteringInvalidAddressKey() {
        utils.waitForElementVisible(By.xpath(INVALID_ADDRESSKEY));
    }

    public void assertPopulatedNetworkCallingFeaturesOnWlr3OrderPage() throws InterruptedException {
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("networkFeaturesSummaryPanel"));
        utils.waitForElementVisible(By.xpath(ADMIN_CONT_CAL_DIV_ON_ORDER_DETAIL_PAGE));
        utils.waitForElementVisible(By.xpath(ANO_CAL_REJ_UNDER_ON_ORDER_DETAIL_PAGE));
    }

    public void assertPopulatedDirectoryInformationOnWlr3OrderPage() throws InterruptedException {
        utils.waitForElementVisible(By.id("directoryInformationSummaryPanel"));
        utils.waitForElementVisible(By.xpath(SURNAME_OF_DIRECTORY_INFO_ON_WLR3_ORDER_PAGE));
    }

    public void assertPopulatedSiteContactsOnWLR3OrderPage() throws InterruptedException {
        utils.waitForElementVisible(By.id("siteInformationSummaryPanel"));
        utils.waitForElementVisible(By.xpath(SITE_CONTACT_NAME_ON_WLR3_ORDER_PAGE));
        utils.waitForElementVisible(By.xpath(SITE_EMAILID_ON_WLR3_ORDER_PAGE));
    }

    public void assertDepopulatedNetworkCallingFeaturesOnWlr3OrderPage() throws InterruptedException {
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("networkFeaturesSummaryPanel"));
        utils.waitForElementVisible(By.xpath(NETWORK_FEATURES_BUTTON));
        utils.assertElementNotPresent(By.xpath(ADMIN_CONT_CAL_DIV_ON_ORDER_DETAIL_PAGE));
        utils.assertElementNotPresent(By.xpath(ANO_CAL_REJ_UNDER_ON_ORDER_DETAIL_PAGE));
    }

    public void assertDepopularedDirectoryInformationOnWlr3OrderPage() throws InterruptedException {
        utils.waitForElementVisible(By.id("directoryInformationSummaryPanel"));
        utils.waitForElementToVanish(By.xpath(SURNAME_OF_DIRECTORY_INFO_ON_WLR3_ORDER_PAGE));
    }

    public void assertDepopulatedSiteInformationOnWLR3OrderPage() throws InterruptedException {
        utils.jumpToParentPopUp();
        textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("siteInformationSummaryPanel"));
        utils.waitForElementVisible(By.xpath(SITE_INFORMATION_BUTTON));
        utils.waitForElementToVanish(By.xpath(SITE_CONTACT_NAME_ON_WLR3_ORDER_PAGE));
        utils.waitForElementToVanish(By.xpath(SITE_EMAILID_ON_WLR3_ORDER_PAGE));
    }

    public void clickLineNumbering() throws InterruptedException {
        textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("lineNumberingSummaryPanel"));
        Thread.sleep(1000);
        try {
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
        utils.waitForElementVisible(By.id("lineNumberingSummaryPanel"));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][contains(text(),'" + number + "')]"));
    }

    public void clickOnAppointment() {
        utils.clickBtn(By.xpath(APPOINTMENT_TAB_ON_WLR3_ORDER_PAGE));
        utils.waitForElementVisible(By.xpath(TEXT_ON_APPOINTMENT_PAGE));
    }

    public void assertImportedLineWithChangeOfPostCodeAndAidOfGoldAddress(String importedNumber) throws InterruptedException {
        textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("lineNumberingSummaryPanel"));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }

    public void assertImportedLineWithAidOfLetterOfAuthority(String importedNumber) throws InterruptedException {
        textOnWLR3OrderPage();
        utils.refreshPage();
        utils.jumpToPopUpWindow(By.xpath(ITEMID_ON_EDITORDER));
        utils.waitForElementVisible(By.id("lineNumberingSummaryPanel"));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }

    public void assertNumberImportedWithVic(String importedNumber, String vic) throws InterruptedException {
        textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("lineNumberingSummaryPanel"));
        utils.waitForElementVisible(By.xpath("//p[@id='display_WLR3Order_vic'][contains(text(),'" + vic + "')]"));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }

    public void textOnWLR3OrderPage() {
        try {
            utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        } catch (Exception e) {
            getToWLR3QuotePage();
        }
    }

    public void getToWLR3QuotePage() {
        utils.getOrdersPage();
        utils.waitForElementVisible(By.xpath(ordersManagerPage.QUOTEID));
        utils.clickBtn(By.xpath(ordersManagerPage.QUOTEID));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath("//a[contains(@onclick,'OpenNewWLR3OrderDetailPopup')]"));
        utils.clickBtn(By.xpath("//a[contains(@onclick,'OpenNewWLR3OrderDetailPopup')]"));
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
        utils.waitForElementVisible(By.id(CLOSE));
        try {
            utils.clickBtn(By.id(CANCEL));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.javaScriptExecutorClick(By.id(CANCEL));
        }
    }

    public void verifyLineInformationTab(String level, String level_no) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(LINE_INFO_TAB));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(LINE_INFO_TAB));
        utils.waitForElementVisible(By.xpath(TEXT_ON_LINEINFO_PAGE));
        utils.waitForElementVisible(By.id(SERVICE_MAINTENANCE_TAB));
        utils.selectByVisibleText(By.id(SERVICE_MAINTENANCE_TAB), level);
        utils.waitForElementVisible(By.id(SAVE));
        utils.clickBtn(By.id(SAVE));
        utils.waitForElementVisible(By.xpath("//div[@id='lineInformationSummaryPanel']//p[contains(text(),'" + level_no + "')]"));
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
        utils.waitForElementVisible(By.id("div_EmergencyInfo"));
        Thread.sleep(1000);
        utils.clickBtn(By.id("div_EmergencyInfo"));
        utils.sendText(By.id("EmergencyInfo"), "EmergencyInfo");
        utils.clickBtn(By.xpath("//img[contains(@onclick,'jet_update_value_FromTextbox')]"));
    }

    public void assertChangesForAmendOrder() {
        utils.waitForElementVisible(By.xpath("//div[@id='networkFeaturesSummaryPanel']//label[contains(text(),'Anonymous Call Reject')]"));
        utils.waitForElementVisible(By.xpath("//div[@id='directoryInformationSummaryPanel']//p[contains(text(),'Telecom')]"));

    }

}

