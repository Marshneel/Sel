package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class WLR3_InstallationAddressPage {

    private final String INSTALLATION_ADDRESS_BUTTON = "//a[starts-with(@onclick,'loadInstallationAddress')]";
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


    ElementUtils utils=new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();


    public void accessInstallationAddressPage() throws InterruptedException {
        utils.waitForElementVisibleForWLR3Page(By.xpath(wlr3_orderDetails_page.TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.waitForElementVisible(By.xpath(INSTALLATION_ADDRESS_BUTTON));
        utils.scrollUp(By.xpath(INSTALLATION_ADDRESS_BUTTON));
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(INSTALLATION_ADDRESS_BUTTON));
    }

    public void EnterPostCodeInSearchAddressByPostCode(String postCode) {
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
        utils.waitForElementVisibleForWLR3Page(By.xpath(wlr3_orderDetails_page.TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.jumpToPopUpWindowByJavaExeClick(By.xpath(INSTALLATION_ADDRESS_BUTTON));
        EnterPostCodeInSearchAddressByPostCode("lu1 1dq");
        wlr3_orderDetails_page.assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26");
    }
    public void enterAddressKeyInSearchAddressByAddressKey(String addressKey) {
        utils.clickBtn(By.id(ADDRESSKEY_FIELD));
        utils.sendText(By.id(ADDRESSKEY_FIELD), addressKey);
        utils.clickBtn(By.id(ADDRESSKEY_SEARCH));
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
    public void searchAndAssertResult(String roadName, String premiseName, String subPremiseName, String premiseNumber, String postCode) throws InterruptedException {
        utils.clickBtn(By.xpath(ADVANCED_ADDRESS_SEARCH));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__ThoroughfareName'][@value='" + roadName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__PremisesName'][@value='" + premiseName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__SubPremises'][@value='" + subPremiseName + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__ThoroughfareNumber'][@value='" + premiseNumber + "']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Addresses_0__Postcode'][@value='" + postCode + "']"));
    }
    public void accessAddressKeyTab() {
        utils.clickBtn(By.xpath(ADDRESSKEY_SEARCH_TAB));
    }

}
