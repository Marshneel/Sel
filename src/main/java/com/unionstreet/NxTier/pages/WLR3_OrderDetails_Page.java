package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by rajeshg on 24/10/2016.
 */
public class WLR3_OrderDetails_Page {

    private final String SUBMIT_TRANSFER = "//input[@onclick='SubmitTransfer();']";
    // TODO: 06/01/2017  
    public final String TEXT_ON_WLR3_ORDER_DETAIL_PAGE = "//h3[text()='vodafone > WLR3 Order Detail']";
    private final String ADDRESS_SEARCH_RESULT = "address_0";
    private final String CONTINUE_AFTER_ADDRESS_IS_CHOOSEN = "//button[text()='Continue']";
    private final String INVALID_ADDRESSKEY = "//span[text()='Invalid Address Key']";
    private final String ADDRESS_SEARCH_RESULT_FOR_LU1_1DQ_ON_WLR3_ORDER_PAGE = "//p[@id='display_WLR3Order_addr_postcode'][contains(text(),'LU1 1DQ')]";
    public final String POSTCODE_SEARCH_POSTCODE_FIELD = "Postcode";
    public final String NETWORK_FEATURES_BUTTON = "//a[@href='javascript:;'][starts-with(@onclick,'return showNetworkFeaturesPopup')]";
    public final String SITE_INFORMATION_BUTTON = "//a[@href='javascript:;'][starts-with(@onclick,'return showSiteInformationPopup')]";
    public final String DIRECTORY_INFORMATION_BUTTON = "//a[@href='javascript:;'][starts-with(@onclick,'loadDirectoryInformationPopup')]";
    private final String LINE_NUMBERING_BUTTON = "//a[@href='javascript:;'][starts-with(@onclick,'loadLineNumberingPopup')]";
    private final String ADMIN_CONT_CAL_DIV_ON_ORDER_DETAIL_PAGE = "//label[@class='networkFeature'][contains(text(),'Admin Controlled Call Diversion')]";
    private final String SURNAME_OF_DIRECTORY_INFO_ON_WLR3_ORDER_PAGE = "//p[text()='Telecom ']";
    private final String ANO_CAL_REJ_UNDER_ON_ORDER_DETAIL_PAGE = "//label[@class='networkFeatureAdd'][contains(text(),'Anonymous Call Reject')]";
    public final String CLOSE = "closeBtn";
    private final String SITE_CONTACT_NAME_ON_WLR3_ORDER_PAGE = "//p[@id='display_WLR3Order_contact_name'][contains(text(),'Jeroen')]";
    private final String SITE_EMAILID_ON_WLR3_ORDER_PAGE = "//p[@id='display_WLR3Order_contact_email'][contains(text(),'Jeroen@vodafone.co.uk')]";
    private final String TEXT_ON_LINE_NUMBERING_PAGE = "//li[text()='vodafone']";
    private final String LINE_PLANT_TAB = "//a[@id='lineplant']";
    public final String SAVE = "saveBtn";
    private final String ITEMID_ON_EDITORDER = "//a[@href='#'][starts-with(@onclick,'OpenNewWLR3OrderDetailPopup')]";
    private final String CONTINUETAB_UNDER_NOCHANGE_LINE_INFO = "//a[@onclick='lineNumbering.submitChanges(0);']";
    private final String APPOINTMENT_TAB_ON_WLR3_ORDER_PAGE="//a[@href='javascript:;'][starts-with(@onclick,'showNewBookAppointmentPopup')]";
    private final String TEXT_ON_APPOINTMENT_PAGE="//legend[text()='Hazard and Warning Notes']";
    CompanyMenuPage companyMenuPage = new CompanyMenuPage();
    ElementUtils utils = new ElementUtils();

    public void enterPhoneNumberAndPostCodeToInitiateTheTransfer(String number, String postCode) {
        utils.waitForElementVisible(By.xpath(SUBMIT_TRANSFER));
        utils.clickBtn(By.id(companyMenuPage.CLI_NUMBER_FIELD));
        utils.sendText(By.id(companyMenuPage.CLI_NUMBER_FIELD), number);
        utils.clickBtn(By.id(POSTCODE_SEARCH_POSTCODE_FIELD));
        utils.sendText(By.id(POSTCODE_SEARCH_POSTCODE_FIELD), postCode);
        utils.clickBtn(By.xpath(SUBMIT_TRANSFER));
    }

    public void assertAddress(String roadName, String premiseName, String subpremiseName, String premiseNumber) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__ThoroughfareName'][@value='" + roadName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__PremisesName'][@value='" + premiseName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__SubPremises'][@value='" + subpremiseName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__ThoroughfareNumber'][@value='" + premiseNumber + "']"));
    }

    public void pickAndAssertPostCodeOnWLR3OrderPage(String postCode) throws InterruptedException {

        utils.clickBtn(By.id(ADDRESS_SEARCH_RESULT));
        utils.javaScriptExecutorClick(By.xpath(CONTINUE_AFTER_ADDRESS_IS_CHOOSEN));
        utils.jumpToParentPopUp();
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.waitForElementVisible(By.xpath(LINE_PLANT_TAB));
        utils.scrollUp(By.xpath(LINE_PLANT_TAB));
        utils.verifyStringMatch(By.xpath(ADDRESS_SEARCH_RESULT_FOR_LU1_1DQ_ON_WLR3_ORDER_PAGE), postCode);
    }

    public void assertErrorMessageUponEnteringInvalidAddressKey() {
        utils.waitForElementVisible(By.xpath(INVALID_ADDRESSKEY));
    }

    public void assertPopulatedNetworkCallingFeaturesOnWlr3OrderPage() throws InterruptedException {
        utils.jumpToParentPopUp();
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.waitForElementVisible(By.xpath(ADMIN_CONT_CAL_DIV_ON_ORDER_DETAIL_PAGE));
        utils.waitForElementVisible(By.xpath(ANO_CAL_REJ_UNDER_ON_ORDER_DETAIL_PAGE));
    }

    public void assertPopulatedDirectoryInformationOnWlr3OrderPage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(SURNAME_OF_DIRECTORY_INFO_ON_WLR3_ORDER_PAGE));
    }

    public void assertPopulatedSiteContactsOnWLR3OrderPage() {
        utils.waitForElementVisible(By.xpath(SITE_CONTACT_NAME_ON_WLR3_ORDER_PAGE));
        utils.waitForElementVisible(By.xpath(SITE_EMAILID_ON_WLR3_ORDER_PAGE));
    }

    public void assertDepopulatedNetworkCallingFeaturesOnWlr3OrderPage() throws InterruptedException {
        utils.jumpToParentPopUp();
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.waitForElementVisible(By.xpath(NETWORK_FEATURES_BUTTON));
        utils.scrollUp(By.xpath(NETWORK_FEATURES_BUTTON));
        utils.assertElementNotPresent(By.xpath(ADMIN_CONT_CAL_DIV_ON_ORDER_DETAIL_PAGE));
        utils.assertElementNotPresent(By.xpath(ANO_CAL_REJ_UNDER_ON_ORDER_DETAIL_PAGE));
    }

    public void assertDepopularedDirectoryInformationOnWlr3OrderPage() {
        utils.assertElementNotPresent(By.xpath(SURNAME_OF_DIRECTORY_INFO_ON_WLR3_ORDER_PAGE));
    }

    public void assertDepopulatedSiteInformationOnWLR3OrderPage() throws InterruptedException {
        utils.jumpToParentPopUp();
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.waitForElementVisible(By.xpath(SITE_INFORMATION_BUTTON));
        utils.scrollUp(By.xpath(SITE_INFORMATION_BUTTON));
        utils.assertElementNotPresent(By.xpath(SITE_CONTACT_NAME_ON_WLR3_ORDER_PAGE));
        utils.assertElementNotPresent(By.xpath(SITE_EMAILID_ON_WLR3_ORDER_PAGE));
    }

    public void clickLineNumbering() {
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(LINE_NUMBERING_BUTTON));
        utils.waitForElementVisible(By.xpath(TEXT_ON_LINE_NUMBERING_PAGE));
    }

    public void lineNumberingNoChangeWithAssertions(String number) {
        utils.waitForElementVisible(By.xpath("//h1[text()='" + number + "']"));
        utils.clickBtn(By.xpath(CONTINUETAB_UNDER_NOCHANGE_LINE_INFO));
        utils.jumpToParentPopUp();
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][contains(text(),'" + number + "')]"));
    }

    public void clickOnAppointment() {
        utils.clickBtn(By.xpath(APPOINTMENT_TAB_ON_WLR3_ORDER_PAGE));
        utils.waitForElementVisible(By.xpath(TEXT_ON_APPOINTMENT_PAGE));
    }

    public void assertImportedLineWithChangeOfPostCodeAndAidOfGoldAddress(String importedNumber) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }

    public void assertImportedLineWithAidOfLetterOfAuthority(String importedNumber) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.refreshPage();
        utils.jumpToPopUpWindow(By.xpath(ITEMID_ON_EDITORDER));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }

    public void assertNumberImportedWithVic(String importedNumber, String vic) {
        utils.waitForElementVisible(By.xpath("//p[@id='display_WLR3Order_vic'][contains(text(),'" + vic + "')]"));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + importedNumber + "')]]"));
    }
}