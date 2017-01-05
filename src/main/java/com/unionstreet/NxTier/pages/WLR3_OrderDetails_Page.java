package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by rajeshg on 24/10/2016.
 */
public class WLR3_OrderDetails_Page {

    private final String SUBMIT_TRANSFER = "//input[@onclick='SubmitTransfer();']";
    private final String TEXT_ON_WLR3_ORDER_DETAIL_PAGE = "//h3[text()='vodafone > WLR3 Order Detail']";
    private final String INSTALLATION_ADDRESS_BUTTON = "//a[starts-with(@onclick,'loadInstallationAddress')]";
    private final String POSTCODE_SEARCH = "PostcodeButton";
    private final String ADDRESSKEY_SEARCH = "AddressKeyButton";
    private final String WRONG_POSTCODE = "//label[text()='No addresses found that match the selection.']";
    private final String INVALID_POSTCODE = "//span[text()='Invalid Postcode']";
    private final String ADDRESS_SEARCH_RESULT = "address_0";
    private final String CONTINUE_AFTER_ADDRESS_IS_CHOOSEN = "//button[text()='Continue']";
    private final String ADVANCED_ADDRESS_SEARCH = "//button[starts-with(@onclick,'return InstallationAddress.extendedAddressSearchResults')]";
    private final String ADVANCED_SEARCH_TAB = "//a[text()='Advanced Search']";
    private final String ADDRESSKEY_SEARCH_TAB = "//a[text()='Address Key']";
    private final String INVALID_ADDRESSKEY = "//span[text()='Invalid Address Key']";
    private final String ADDRESS_SEARCH_RESULT_FOR_LU1_1DQ_ON_WLR3_ORDER_PAGE = "//p[@id='display_WLR3Order_addr_postcode'][contains(text(),'LU1 1DQ')]";
    private final String ADVANCED_SEARCH_POSTCODE_FIELD = "ExtendedAddressPostcode";
    private final String ADVANCED_SEARCH_PREMISE_NAME = "BuildingName";
    private final String ADVANCED_SEARCH_SUBPREMISE_NAME = "SubBuilding";
    private final String ADDRESSKEY_FIELD = "AddressKey";
    private final String ADVANCED_SEARCH_PREMISE_NUMBER_FIELD = "ThoroughfareNumber";
    private final String ADVANCED_SEARCH_ROAD_NAME = "ThoroughfareName";
    private final String ADVANCED_SEARCH_TOWN_FIELD = "Town";
    private final String POSTCODE_SEARCH_POSTCODE_FIELD = "Postcode";
    private final String NETWORK_FEATURES_BUTTON = "//a[@href='javascript:;'][starts-with(@onclick,'return showNetworkFeaturesPopup')]";
    private final String SITE_INFORMATION_BUTTON = "//a[@href='javascript:;'][starts-with(@onclick,'return showSiteInformationPopup')]";
    private final String DIRECTORY_INFORMATION_BUTTON = "//a[@href='javascript:;'][starts-with(@onclick,'loadDirectoryInformationPopup')]";
    private final String LINE_NUMBERING_BUTTON = "//a[@href='javascript:;'][starts-with(@onclick,'loadLineNumberingPopup')]";
    private final String ADMIN_CONT_CAL_DIV_UNDER_NTWR_CALL_FEATURES = "//label[@id='lbl_Features_0__value'][contains(text(),'Admin Controlled Call Diversion')]";
    private final String ADMIN_CONT_CAL_DIV_ON_ORDER_DETAIL_PAGE = "//label[@class='networkFeature'][contains(text(),'Admin Controlled Call Diversion')]";
    private final String SURNAME_OF_DIRECTORY_INFO_ON_WLR3_ORDER_PAGE = "//p[text()='Telecom ']";
    private final String ANO_CAL_REJ_UNDER_NTWR_CALL_FEATURES = "//label[@id='lbl_Features_1__value'][contains(text(),'Anonymous Call Reject')]";
    private final String ANO_CAL_REJ_UNDER_ON_ORDER_DETAIL_PAGE = "//label[@class='networkFeatureAdd'][contains(text(),'Anonymous Call Reject')]";
    private final String TEXT_ON_DIR_INFO_PAGE_BEFORE_POP = "retainDirInfoLabel";
    private final String TEXT_ON_DIR_INFO_AFTER_POP = "//label[text()='Directory Information below will be updated with the details below']";
    private final String TEXT_ON_SITE_INFORMATION = "//legend[text()='Site Contact']";
    private final String EDIT_DIRECTORY_INFO = "editBtn";
    private final String BUSINESS_NAME_DIRECTORY_INFORMATION = "DirectoryInfo_0__dir_TradingTitleSurname";
    private final String CLOSE_DIRECTORY_INFORMATION_PAGE = "closeBtn";
    private final String ENABLE_CHANGE_DIRECTORY_INFO_BUTTON = "//input[@value='Change'][starts-with(@onclick,'wlr3Directories.retainStateChanged')]";
    private final String SUBMIT_BUTTON = "saveBtn";
    private final String SITE_CONTACT_NAME_ON_WLR3_ORDER_PAGE = "//p[@id='display_WLR3Order_contact_name'][contains(text(),'Jeroen')]";
    private final String SITE_EMAILID_ON_WLR3_ORDER_PAGE = "//p[@id='display_WLR3Order_contact_email'][contains(text(),'Jeroen@vodafone.co.uk')]";
    private final String TEXT_ON_LINE_NUMBERING_PAGE = "//li[text()='vodafone']";
    private final String LINE_PLANT_TAB = "//a[@id='lineplant']";
    private final String SAVE = "saveBtn";
    private final String EDIT = "editBtn";

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

    public void accessInstallationAddressPage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.scrollUp(By.xpath(INSTALLATION_ADDRESS_BUTTON));
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(INSTALLATION_ADDRESS_BUTTON));
    }

    public void EnterPostCodeInSearchAddressByPostCode(String postCode) {
        utils.clickBtn(By.id(POSTCODE_SEARCH_POSTCODE_FIELD));
        utils.sendText(By.id(POSTCODE_SEARCH_POSTCODE_FIELD), postCode);
        utils.clickBtn(By.id(POSTCODE_SEARCH));
    }

    public void assertErrorMessageUponEnteringWrongPostCode() {
        utils.waitForElementVisible(By.xpath(WRONG_POSTCODE));
    }

    public void assertErrorMessageUponEnteringInvalidPostCode() {
        utils.waitForElementVisible(By.xpath(INVALID_POSTCODE));
    }

    public void populateInstallationAddressPage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(INSTALLATION_ADDRESS_BUTTON));
        EnterPostCodeInSearchAddressByPostCode("lu1 1dq");
        assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26");
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

    public void accessAddressKeyTab() {
        utils.clickBtn(By.xpath(ADDRESSKEY_SEARCH_TAB));
    }

    public void enterAddressKeyInSearchAddressByAddressKey(String addressKey) {
        utils.clickBtn(By.id(ADDRESSKEY_FIELD));
        utils.sendText(By.id(ADDRESSKEY_FIELD), addressKey);
        utils.clickBtn(By.id(ADDRESSKEY_SEARCH));
    }

    public void assertErrorMessageUponEnteringInvalidAddressKey() {
        utils.waitForElementVisible(By.xpath(INVALID_ADDRESSKEY));
    }

    public void searchAndAssertResult(String roadName, String premiseName, String subPremiseName, String premiseNumber, String postCode) throws InterruptedException {
        utils.clickBtn(By.xpath(ADVANCED_ADDRESS_SEARCH));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__ThoroughfareName'][@value='" + roadName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__PremisesName'][@value='" + premiseName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__SubPremises'][@value='" + subPremiseName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__ThoroughfareNumber'][@value='" + premiseNumber + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__Postcode'][@value='" + postCode + "']"));
    }

    public void enterPostCodeDetails(String postCode) {
        utils.clickBtn(By.id(ADVANCED_SEARCH_POSTCODE_FIELD));
        utils.sendText(By.id(ADVANCED_SEARCH_POSTCODE_FIELD), postCode);
    }

    public void clearPostCode() {
        utils.clearText(By.id(ADVANCED_SEARCH_POSTCODE_FIELD));

    }

    public void enterPremiseNumber(String number) {
        utils.clickBtn(By.id(ADVANCED_SEARCH_PREMISE_NUMBER_FIELD));
        utils.sendText(By.id(ADVANCED_SEARCH_PREMISE_NUMBER_FIELD), number);
    }

    public void clearPremiseNumber() {
        utils.clearText(By.id(ADVANCED_SEARCH_PREMISE_NUMBER_FIELD));
    }

    public void enterPremiseName(String name) {
        utils.clickBtn(By.id(ADVANCED_SEARCH_PREMISE_NAME));
        utils.sendText(By.id(ADVANCED_SEARCH_PREMISE_NAME), name);
    }

    public void clearBuildingName() {
        utils.clearText(By.id(ADVANCED_SEARCH_PREMISE_NAME));
    }

    public void enterSubPremiseName(String subPremise) {
        utils.clickBtn(By.id(ADVANCED_SEARCH_SUBPREMISE_NAME));
        utils.sendText(By.id(ADVANCED_SEARCH_SUBPREMISE_NAME), subPremise);
    }

    public void clearSubPremiseName() {
        utils.clearText(By.id(ADVANCED_SEARCH_SUBPREMISE_NAME));
    }

    public void enterRoad(String road) {
        utils.clickBtn(By.id(ADVANCED_SEARCH_ROAD_NAME));
        utils.sendText(By.id(ADVANCED_SEARCH_ROAD_NAME), road);
    }

    public void enterTown(String town) {
        utils.clickBtn(By.id(ADVANCED_SEARCH_TOWN_FIELD));
        utils.sendText(By.id(ADVANCED_SEARCH_TOWN_FIELD), town);
    }

    public void enterPremiseNumberRoadandTown(String number, String road, String town) {
        enterPremiseNumber(number);
        enterRoad(road);
        enterTown(town);
    }

    public void clearPremiseNumberRoadandTown() {
        utils.clearText(By.id(ADVANCED_SEARCH_PREMISE_NUMBER_FIELD));
        utils.clearText(By.id(ADVANCED_SEARCH_ROAD_NAME));
        utils.clearText(By.id(ADVANCED_SEARCH_TOWN_FIELD));
    }

    public void enterPremiseNameRoadandTown(String name, String road, String town) {
        enterPremiseName(name);
        enterRoad(road);
        enterTown(town);
    }

    public void accessAdvancedSearchTab() {
        utils.clickBtn(By.xpath(ADVANCED_SEARCH_TAB));
    }

    public void enterValidAddressSearchCombinations() throws InterruptedException {

        enterPostCodeDetails("LU1 1DQ");
        searchAndAssertResult("Kenilworth Road", "AppleGarth", "The Willows", "26", "LU1 1DQ");
        enterPremiseNumber("26");
        searchAndAssertResult("Kenilworth Road", "AppleGarth", "The Willows", "26", "LU1 1DQ");
        clearPremiseNumber();
        enterPremiseName("AppleGarth");
        searchAndAssertResult("Kenilworth Road", "AppleGarth", "The Willows", "26", "LU1 1DQ");
        clearBuildingName();
        enterSubPremiseName("The Willows");
        searchAndAssertResult("Kenilworth Road", "AppleGarth", "The Willows", "26", "LU1 1DQ");
        clearPostCode();
        clearSubPremiseName();
        enterPremiseNumberRoadandTown("26", "Kenilworth Road", "Luton");
        searchAndAssertResult("Kenilworth Road", "AppleGarth", "The Willows", "26", "LU1 1DQ");
        clearPremiseNumberRoadandTown();
        enterPremiseNameRoadandTown("AppleGarth", "Kenilworth Road", "Luton");
        searchAndAssertResult("Kenilworth Road", "AppleGarth", "The Willows", "26", "LU1 1DQ");
    }

    public void populateNetworkCallingFeatures() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.scrollUp(By.xpath(NETWORK_FEATURES_BUTTON));
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(NETWORK_FEATURES_BUTTON));
        utils.waitForElementVisible(By.id(SAVE));
        utils.makeSureBoxIsChecked(By.id("Features_0__value"), By.id("Features_0__value"));
        utils.makeSureBoxIsChecked(By.id("Features_1__value"), By.id("Features_1__value"));
        utils.clickBtn(By.id(SAVE));
    }

    public void populatingDirectoryInformation(String name) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.scrollUp(By.xpath(DIRECTORY_INFORMATION_BUTTON));
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(DIRECTORY_INFORMATION_BUTTON));
        utils.waitForElementVisible(By.id(TEXT_ON_DIR_INFO_PAGE_BEFORE_POP));
        utils.clickBtn(By.xpath(ENABLE_CHANGE_DIRECTORY_INFO_BUTTON));
        utils.clickBtn(By.id(EDIT_DIRECTORY_INFO));
        utils.clickBtn(By.id(BUSINESS_NAME_DIRECTORY_INFORMATION));
        utils.sendText(By.id(BUSINESS_NAME_DIRECTORY_INFORMATION), name);
        utils.clickBtn(By.id(SAVE));
        utils.waitForElementToVanish(By.id(SAVE));
        utils.javaScriptExecutorClick(By.id(CLOSE_DIRECTORY_INFORMATION_PAGE));
        utils.jumpToParentPopUp();
    }

    public void populatingSiteInformation() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.scrollUp(By.xpath(SITE_INFORMATION_BUTTON));
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(SITE_INFORMATION_BUTTON));
        utils.waitForElementVisible(By.xpath(TEXT_ON_SITE_INFORMATION));
        utils.selectByIndex(By.id("ContactList"), 1);
        utils.javaScriptExecutorClick(By.id(SUBMIT_BUTTON));
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

    public void depopulateNetworkCallingFeatures() throws InterruptedException {
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(NETWORK_FEATURES_BUTTON));
        utils.waitForElementVisible(By.id(SAVE));
        utils.makeSureBoxIsUnChecked(By.id("Features_0__value"), By.id("Features_0__value"));
        utils.makeSureBoxIsUnChecked(By.id("Features_1__value"), By.id("Features_1__value"));
        utils.clickBtn(By.id(SAVE));
    }

    public void editDirectoryInformation() throws InterruptedException {
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(DIRECTORY_INFORMATION_BUTTON));
        utils.clickBtn(By.id(EDIT));
        utils.sendText(By.id("DirectoryInfo_0__dir_TradingTitleSurname"), "vodafone");
        utils.clickBtn(By.id(SAVE));
        utils.waitForElementVisible(By.xpath("//div[@style='display: block;'][contains(text(),'vodafone')]"));
        utils.javaScriptExecutorClick(By.id(CLOSE_DIRECTORY_INFORMATION_PAGE));
    }

    public void depopulateSiteInformation() throws InterruptedException {
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(SITE_INFORMATION_BUTTON));
        utils.waitForElementVisible(By.xpath(TEXT_ON_SITE_INFORMATION));
        utils.selectByVisibleText(By.id("ContactList"), "Select");
        utils.scrollUp(By.xpath(SITE_INFORMATION_BUTTON));
        utils.javaScriptExecutorClick(By.id(SUBMIT_BUTTON));
    }

    public void assertDepopulatedNetworkCallingFeaturesOnWlr3OrderPage() throws InterruptedException {
        utils.jumpToParentPopUp();
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
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
        utils.scrollUp(By.xpath(SITE_INFORMATION_BUTTON));
        utils.assertElementNotPresent(By.xpath(SITE_CONTACT_NAME_ON_WLR3_ORDER_PAGE));
        utils.assertElementNotPresent(By.xpath(SITE_EMAILID_ON_WLR3_ORDER_PAGE));
    }

    public void clickLineNumbering() {
        utils.waitForElementVisible(By.xpath(TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(LINE_NUMBERING_BUTTON));
        utils.waitForElementVisible(By.xpath(TEXT_ON_LINE_NUMBERING_PAGE));
    }

    public void lineNumberingWithOutAddressAssertions() {
        utils.clickBtn(By.xpath("//a[@href='#default-tab-Specify_new_number']"));
        utils.waitForElementVisible(By.xpath("//div[@class='alert alert-danger']"));
        utils.clickBtn(By.xpath("//a[@href='#default-tab-Select_from_list']"));
        utils.waitForElementVisible(By.xpath("//div[@class='alert alert-danger']"));
        utils.clickBtn(By.xpath("//a[@href='#default-tab-Automatically_assign_now']"));
        utils.waitForElementVisible(By.xpath("//div[@class='alert alert-danger']"));
    }

    public void closeLineNumberingPage() {
        utils.javaScriptExecutorClick(By.xpath("//button[@class='close']"));
    }

    public void lineNumberingWithAddressAssertions() {


        utils.clickBtn(By.xpath("//a[@href='#default-tab-Specify_new_number']"));
        utils.assertElementNotPresent(By.xpath("//div[@class='alert alert-danger']"));
        utils.clickBtn(By.xpath("//a[@href='#default-tab-Select_from_list']"));
        utils.assertElementNotPresent(By.xpath("//div[@class='alert alert-danger']"));
        utils.clickBtn(By.xpath("//a[@href='#default-tab-Automatically_assign_now']"));
        utils.assertElementNotPresent(By.xpath("//div[@class='alert alert-danger']"));
    }

    public void lineNumberingNoChangeWithAssertions() {

        utils.waitForElementVisible(By.xpath("//h1[text()='01202300908']"));
        utils.clickBtn(By.xpath("//a[@onclick='lineNumbering.submitChanges(0);']"));
        utils.jumpToParentPopUp();
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][contains(text(),'01202300908')]"));
    }

    public void lineNumberingAutomaticallyAssignWithAssertions() {
        utils.clickBtn(By.xpath("//a[@href='#default-tab-Automatically_assign']"));
        utils.clickBtn(By.xpath("//a[@onclick='lineNumbering.submitChanges(1);']"));
        utils.jumpToParentPopUp();
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'Automatically allocated')]]"));
    }

    public void lineNumberingSpecifyUnAvailableNumberWithAssertions() {
        try {
            utils.clickBtn(By.xpath("//a[@href='#default-tab-Specify_new_number']"));
            utils.clickBtn(By.id("SpecificNewNumberToReserve"));
            utils.sendText(By.id("SpecificNewNumberToReserve"), "01582213000");
            utils.clickBtn(By.xpath("//a[contains(@onclick,'return lineNumbering.reservedSpecificNumber')]"));
            utils.waitForElementVisible(By.id("lineNumberNotification"));
            utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "delete from dbo.reserved_numbers where number='01582213000'");
            utils.clickBtn(By.xpath("//a[contains(@onclick,'return lineNumbering.reservedSpecificNumber')]"));
            utils.waitForElementVisible(By.xpath("//h1[text()='01582213000']"));
            utils.clickBtn(By.xpath("//a[@onclick='return lineNumbering.hidePopup();'][contains(text(),'Continue')]"));
            utils.jumpToParentPopUp();
            utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'01582213000')]]"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lineNumberingSpecifyNewNumber() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "delete from dbo.reserved_numbers where number='01582213000'");
        utils.clickBtn(By.xpath("//a[@href='#default-tab-Specify_new_number']"));
        utils.clickBtn(By.id("SpecificNewNumberToReserve"));
        utils.sendText(By.id("SpecificNewNumberToReserve"), "01582213000");
        utils.clickBtn(By.xpath("//a[contains(@onclick,'return lineNumbering.reservedSpecificNumber')]"));
        utils.waitForElementVisible(By.xpath("//h1[text()='01582213000']"));
        utils.clickBtn(By.xpath("//a[@onclick='return lineNumbering.hidePopup();'][contains(text(),'Continue')]"));
        utils.jumpToParentPopUp();
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'01582213000')]]"));
    }

    public void lineNumberingSelectFromList() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {

        utils.clickBtn(By.xpath("//a[@href='#default-tab-Select_from_list']"));
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "delete from dbo.reserved_numbers where number='01582213000'");
        utils.clickBtn(By.xpath("//button[contains(@onclick,'return lineNumbering.getAvailableNumbers')]"));
        utils.waitForElementVisible(By.xpath("//label[text()='01582213000']"));
        utils.clickBtn(By.xpath("//label[text()='01582213000']"));
        utils.waitForElementVisible(By.xpath("//a[contains(@onclick,'return lineNumbering.reservedSelectedNumber')]"));
        utils.clickBtn(By.xpath("//a[contains(@onclick,'return lineNumbering.reservedSelectedNumber')]"));
        utils.waitForElementVisible(By.xpath("//a[@onclick='return lineNumbering.hidePopup();'][contains(text(),'Continue')]"));
        utils.javaScriptExecutorClick(By.xpath("//a[@onclick='return lineNumbering.hidePopup();'][contains(text(),'Continue')]"));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
        utils.jumpToParentPopUp();
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'01582213000')]]"));
        //  clickLineNumbering();
//        utils.clickBtn(By.xpath("//a[@href='#default-tab-Select_from_list']"));
//        utils.sqlQuery("portal", "test01-sql01", "MockCVF","delete from dbo.reserved_numbers where number='01582213000'");
//        utils.clickBtn(By.id("selectList-clusterNumber"));
//        utils.sendText(By.id("selectList-clusterNumber"),"01582213000");
//        utils.clickBtn(By.xpath("//button[contains(@onclick,'return lineNumbering.getAvailableNumbers')]"));
    }

    public void lineNumberingAutomaticallyAssignNumber() {
        try {
            utils.clickBtn(By.xpath("//a[@href='#default-tab-Automatically_assign_now']"));
            utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "delete from dbo.reserved_numbers where number='01582213000'");
            utils.clickBtn(By.xpath("//a[contains(@onclick,'return lineNumbering.assignNow')]"));
            utils.waitForElementVisible(By.xpath("//h1[text()='01582213000']"));
            utils.javaScriptExecutorClick(By.xpath("//a[@onclick='return lineNumbering.hidePopup();'][contains(text(),'Continue')]"));
            utils.jumpToParentPopUp();
            utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'01582213000')]]"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnAppointment() {
        utils.clickBtn(By.xpath("//a[@href='#'][starts-with(@onclick,'showNewBookAppointmentPopup')]"));
        utils.waitForElementVisible(By.xpath("//h3[@class='box-title'][contains(text(),'vodafone > WLR3 Order Detail')]"));
    }

    public void bookAppointmentGeneral(String date, String timeSlot) {
        utils.clickBtn(By.xpath("//input[contains(@onclick,'GetAvailableAppointmentsList')]"));
        utils.clickBtn(By.xpath("//div[@data-apptdate='" + date + "'][@data-appttime='AM (" + timeSlot + ")']"));
        utils.waitForElementVisible(By.xpath("//span[text()='Current Slot: " + date + ", Wed AM (" + timeSlot + ")']"));
        utils.clickBtn(By.xpath("//input[@value='Save & Close']"));


    }
}
