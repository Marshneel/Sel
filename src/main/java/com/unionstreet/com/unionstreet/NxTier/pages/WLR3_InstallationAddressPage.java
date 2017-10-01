package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

import java.sql.SQLException;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class WLR3_InstallationAddressPage {

    public final String INSTALLATION_ADDRESS_BUTTON = "//a[starts-with(@onclick,'loadInstallationAddress')]";
    private final String POSTCODE_SEARCH = "PostcodeButton";
    private final String ADDRESSKEY_SEARCH = "AddressKeyButton";
    private final String WRONG_POSTCODE = "//label[text()='No addresses found that match the selection.']";
    private final String INVALID_POSTCODE = "//span[text()='Invalid Postcode']";
    private final String ADVANCED_ADDRESS_SEARCH = "//button[starts-with(@onclick,'return InstallationAddress.extendedAddressSearchResults')]";
    private final String ADVANCED_SEARCH_TAB = "//a[text()='Advanced Search']";
    private final String ADVANCED_SEARCH_POSTCODE_FIELD = "ExtendedAddressPostcode";
    private final String ADVANCED_SEARCH_PREMISE_NAME = "BuildingName";
    private final String ADVANCED_SEARCH_SUBPREMISE_NAME = "SubBuilding";
    private final String ADDRESSKEY_FIELD = "AddressKey";
    private final String ADVANCED_SEARCH_PREMISE_NUMBER_FIELD = "ThoroughfareNumber";
    private final String ADVANCED_SEARCH_ROAD_NAME = "ThoroughfareName";
    private final String ADVANCED_SEARCH_TOWN_FIELD = "Town";
    private final String ADDRESSKEY_SEARCH_TAB = "//a[text()='Address Key']";
    private final String ADDRESS_MATCH_VALIDATION_MESSAGE = "//div[@id='InstallationAddressViewSection']//span[contains(text(),'This order requires the address to match with Openreach records')]";


    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();


    public void accessInstallationAddressPage(String type) throws InterruptedException, SQLException {
        wlr3_orderDetails_page.textOnWLR3OrderPage(type);
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.INSTALLATION_ADDRESS_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(INSTALLATION_ADDRESS_BUTTON));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(INSTALLATION_ADDRESS_BUTTON));
    }

    public void EnterPostCodeInSearchAddressByPostCode(String postCode) throws InterruptedException {
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.POSTCODE_SEARCH_POSTCODE_FIELD));
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.POSTCODE_SEARCH_POSTCODE_FIELD));
        utils.sendText(By.id(wlr3_orderDetails_page.POSTCODE_SEARCH_POSTCODE_FIELD), postCode);
        utils.clickBtn(By.id(POSTCODE_SEARCH));
    }

    public void assertErrorMessageUponEnteringWrongPostCode() {
        utils.waitForElementVisible(By.xpath(WRONG_POSTCODE));
    }

    public void assertErrorMessageUponEnteringInvalidPostCode() {
        utils.waitForElementVisible(By.xpath(INVALID_POSTCODE));
    }

    public void populateInstallationAddressPage() throws InterruptedException {
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.INSTALLATION_ADDRESS_SUMMARY_PANEL));
        utils.jumpToPopUpWindow(By.xpath(INSTALLATION_ADDRESS_BUTTON));
        EnterPostCodeInSearchAddressByPostCode("lu1 1dq");
        wlr3_orderDetails_page.assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26", "A00001043137");
    }

    public void searchForAddress(String postCode) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(INSTALLATION_ADDRESS_BUTTON));
        utils.clickBtn(By.xpath(INSTALLATION_ADDRESS_BUTTON));
        EnterPostCodeInSearchAddressByPostCode(postCode);

    }

    public void enterAddressKeyInSearchAddressByAddressKey(String addressKey) {
        utils.clickBtn(By.id(ADDRESSKEY_FIELD));
        utils.sendText(By.id(ADDRESSKEY_FIELD), addressKey);
        utils.clickBtn(By.id(ADDRESSKEY_SEARCH));
    }

    public void clearPostCode() {
        utils.clearText(By.id(ADVANCED_SEARCH_POSTCODE_FIELD));
    }

    public void enterPremiseNumber(String number) throws InterruptedException {
        Thread.sleep(1000);
        utils.clickBtn(By.id(ADVANCED_SEARCH_PREMISE_NUMBER_FIELD));
        utils.sendText(By.id(ADVANCED_SEARCH_PREMISE_NUMBER_FIELD), number);
    }

    public void clearPremiseNumber() {
        utils.clearText(By.id(ADVANCED_SEARCH_PREMISE_NUMBER_FIELD));
    }

    public void enterPremiseName(String name) throws InterruptedException {
       Thread.sleep(1000);
        utils.clickBtn(By.id(ADVANCED_SEARCH_PREMISE_NAME));
        utils.sendText(By.id(ADVANCED_SEARCH_PREMISE_NAME), name);
    }

    public void clearBuildingName() {
        utils.clearText(By.id(ADVANCED_SEARCH_PREMISE_NAME));
    }


    public void enterPostCodeDetails(String postCode) {
        utils.clickBtn(By.id(ADVANCED_SEARCH_POSTCODE_FIELD));
        utils.sendText(By.id(ADVANCED_SEARCH_POSTCODE_FIELD), postCode);
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

    public void enterPremiseNumberRoadandTown(String number, String road, String town) throws InterruptedException {
        enterPremiseNumber(number);
        enterRoad(road);
        enterTown(town);
    }

    public void clearPremiseNumberRoadandTown() {
        utils.clearText(By.id(ADVANCED_SEARCH_PREMISE_NUMBER_FIELD));
        utils.clearText(By.id(ADVANCED_SEARCH_ROAD_NAME));
        utils.clearText(By.id(ADVANCED_SEARCH_TOWN_FIELD));
    }

    public void enterPremiseNameRoadandTown(String name, String road, String town) throws InterruptedException {
        enterPremiseName(name);
        enterRoad(road);
        enterTown(town);
    }

    public void accessAdvancedSearchTab() throws InterruptedException {
        Thread.sleep(1000);
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

    public void searchAndAssertResult(String roadName, String premiseName, String subPremiseName, String premiseNumber, String postCode) throws InterruptedException {
        utils.clickBtn(By.xpath(ADVANCED_ADDRESS_SEARCH));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__ThoroughfareName'][@value='" + roadName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__PremisesName'][@value='" + premiseName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__SubPremises'][@value='" + subPremiseName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__ThoroughfareNumber'][@value='" + premiseNumber + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__Postcode'][@value='" + postCode + "']"));
    }

    public void accessAddressKeyTab() throws InterruptedException {
      Thread.sleep(1000);
        utils.clickBtn(By.xpath(ADDRESSKEY_SEARCH_TAB));
    }

    public void assertValidationMessage() {
        utils.waitForElementVisible(By.xpath(ADDRESS_MATCH_VALIDATION_MESSAGE));

    }

    public void assertTheAbsenceOfAddressMatchValidationMessage() {
        utils.assertElementNotPresent(By.xpath(ADDRESS_MATCH_VALIDATION_MESSAGE));

    }
}
