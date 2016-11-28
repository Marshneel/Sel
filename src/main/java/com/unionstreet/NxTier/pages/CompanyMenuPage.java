package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.List;

import static com.unionstreet.NxTier.support.BaseClass.driver;
import static junit.framework.TestCase.assertTrue;

public class CompanyMenuPage {

    public static String RanNumber = RandomStringUtils.randomNumeric(8);
    public final String SEARCH_BUTTON = "txtsearch";
    //TODO
    public final String ADD_BUTTON_CSS = ".add";
    public final String FREEMINUTES_BUTTON = "//*[@id='subMenu']/ul/li[2]/a";
    public final String FREEMINUTES_PLANNAME_FIELD = "Plan_name";
    public final String FREEMINUTES_PLANAMOUNT_FIELD = "Dfreeminutedetails_amount";
    public final String FREEMINUTES_PLAN_WHATID_FIELD = "Dfreeminutedetails_what_id";
    public final String FREEMINUTES_PLAN_APPLYTO_FIELD = "Dfreeminutedetails_apply_to_id";
    public final String FREEMINUTES_PLAN_FREQUENCY_FIELD = "Dfreeminutedetails_frequency_id";
    public final String PACKAGEMANAGER_FREEMINUTES_SELECTBOX = ".field-input.right>div";
    private final String INVOICINGDETAILS_BUTTON = "HrefInvoicingDetails";
    private final String BILLINGDETAILS_BUTTON = "HrefBillingDetails";
    private final String MODE_OF_PAYMENT_FIELD = "sinfo_paymentconditions_id";
    private final String SORT_CODE_FIELD = "sinfo_sort_code";
    private final String ACCOUNT_NUMBER_FIELD = "direct_debit_account_number";
    private final String ACCOUNT_NAME_FIELD = "sinfo_account_name";
    private final String CUSTOMER_REFERENCE_FIELD = "sinfo_customer_ref";
    private final String BILLING_REPORT_PROFILE_DROPDOWN = "BillingInfo_report_profile";
    private final String BILLING_CONTACTID_FIELD = "sinfo_billingcontact_id";
    private final String CLI_BUTTON = "HrefCLIs";
    public final String CLI_NUMBER_FIELD = "CLI";
    private final String ADDED_CLI_CHECK_FIELD = ".field-input.w35.left";
    private final String SERVICECHARGE_BUTTON = "HrefServiceCharges";
    //TODO
    private final String SERVICECHARGE_DESC_FIELD = "r_desc";
    private final String FIRSTPAYMENT_DESC_FIELD = "r_first_payment";
    private final String SERVICECHARGE_CHARGETYPE_DROPDOWN = "r_chargeid";
    private final String SERVICECHARGE_FREQUENCY_DROPDOWN = "rc_frequency_type_id";
    private final String SERVICECHARGE_ONEOFF_BUTTON = "Service Charge One-Off";
    private final String SELECT_CLI_DROPDOWN = "cli";
    //TODO
    private final String SELECT_MONTH_DROPDOWN = ".ui-datepicker-month";
    //TODO
    private final String SELECT_YEAR_DROPDOWN = ".ui-datepicker-year";
    private final String SERVICECHARGE_QUANTITY_FIELD = "r_quantity";
    private final String SERVICECHARGE_CARRIER_DROPDOWN = "r_carrier";
    private final String PRICING_DETAILS_BUTTON = "HrefPricingDetails";
    private final String PRICING_DETAILS_PACKAGE_FIELD = "sinfo_package";
    private final String PRICINGDETAILS_MOBILE_DROPDOWN = "//div[@class='box']//select[@id='sinfo_Mob_Tariff']";
    private final String PRICINGDETAILS_SERVICECHARGE_DROPDOWN = "//select[@id='sinfo_sc_tariff']";
    private final String PRICINGDETAILS_VOICE_DROPDOWN = "//select[@id='sinfo_LCR_Tariff']";
    private final String PRICINGDETAILS_DATA_DROPDOWN = "//select[@id='sinfo_Data_Tariff']";
    private final String TARIFFMANAGER_BUTTON = "//*[@id='subMenu']/ul/li[1]/a";
    private final String CONFIGMANAGER_BUTTON = "HrefConfigManager";
    private final String TARIFFNAME_FIELD = "TariffName1";
    private final String TARIFFSEARCH_BYTYPE_FIELD = "lstType";
    private final String SERVICECHARGETYPES_BUTTON = "//*[@id='subMenu']/ul/li[6]/a";
    private final String ADDSERVICECHARGE_CHARGETYPE_FIELD = "RecChargeType";
    private final String ADDSERVICECHARGE_FREQUENCY_FIELD = "rc_frequency_type_id";
    private final String PACKAGEMANAGER_BUTTON = "//*[@id='subMenu']/ul/li[3]/a";
    private final String ADDPACKAGE_TARIFFNAME_FIELD = "mpackage_name";
    private String SERVICECHARGE_SAVE_BUTTON = "//input[@onclick='return ValidateType();']";
    public final String SITEDETAILS_SITE_NAME = "SiteName";
    public final String SITEDETAILS_SHORT_NAME = "ShortName";
    private final String SITEDETAILS_POSTCODE = "PostCode";
    private final String SITEDETAILS_TELEPHONE = "Telephone";
    private final String SITEDETAILS_ACCOUNT_REF = "sage_id";
    private final String SITEDETAILS_BILLING_ADDRESS = "InvoiceAddress";
    private final String COMPANYSITES_BUTTON = "HrefCompanySites";
    private long today;
    private String day;
    ElementUtils utils = new ElementUtils();


    CommonMethods commonMethods = new CommonMethods();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();

    public void addNewSite() {
        accessCompanyMenu();
        clickCompanySitesButton();
        utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow();
    }

    public void addNewSiteNames() {
        utils.sendText(By.id(SITEDETAILS_SITE_NAME), (newBusinessCustomerPage.RanName + RanNumber));
        utils.sendText(By.id(SITEDETAILS_SHORT_NAME), (newBusinessCustomerPage.RanName + RanNumber));
        utils.sendText(By.id(SITEDETAILS_ACCOUNT_REF), (RanNumber));
    }

    public void addNewSiteAddress() {
        utils.sendText(By.id(SITEDETAILS_POSTCODE), utils.getProperty("postCode"));
        utils.sendText(By.id(SITEDETAILS_TELEPHONE), (RanNumber));
        utils.sendText(By.id(SITEDETAILS_ACCOUNT_REF), (RanNumber));
    }

    public void setOwnSiteBillingAddress() {

        utils.selectByVisibleText(By.id(SITEDETAILS_BILLING_ADDRESS), utils.getProperty("siteOwnBillingAddress"));
    }

    public void setHeadSiteBillingAddress() {
        utils.selectByVisibleText(By.id(SITEDETAILS_BILLING_ADDRESS), (newBusinessCustomerPage.RanName));
    }

    public void assertNewSite() {
        driver.switchTo().window(utils.parentWindow);
        utils.verifyStringMatch(By.linkText(newBusinessCustomerPage.RanName + RanNumber), newBusinessCustomerPage.RanName + RanNumber);
    }

    public void clickCompanySitesButton() {
        utils.waitForElementVisible(By.id(COMPANYSITES_BUTTON));
        utils.clickBtn(By.id(COMPANYSITES_BUTTON));
    }

    public void accessCompanyMenu() {
        newBusinessCustomerPage.clickContactManagerButton();
        utils.sendText(By.id(SEARCH_BUTTON), NewBusinessCustomerPage.RanName);
        utils.keyBoardEnter(By.id(SEARCH_BUTTON));
        utils.clickBtn(By.linkText(NewBusinessCustomerPage.RanName));
        utils.switchToNewWindow();
    }

    public void clickInvoicingDetailsButton() {
        utils.clickBtn(By.id(INVOICINGDETAILS_BUTTON));
    }

    public void addInvoicingDetails() {
        accessCompanyMenu();
        clickInvoicingDetailsButton();
        utils.selectByVisibleText(By.id(BILLING_REPORT_PROFILE_DROPDOWN), utils.getProperty("billingReportProfile"));
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
    }

    public void assertSavedInvoiceDetails() {
        utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
    }

    public void clickBillingDetailsButton() {
        utils.clickBtn(By.id(BILLINGDETAILS_BUTTON));
    }

    public void addBillingDetails() {
        clickBillingDetailsButton();
        utils.selectByVisibleText(By.id(MODE_OF_PAYMENT_FIELD), utils.getProperty("billingDetailsPaymentMode"));
        utils.sendText(By.id(SORT_CODE_FIELD), utils.getProperty("sortCode"));
        utils.sendText(By.id(ACCOUNT_NUMBER_FIELD), utils.getProperty("accountNumber"));
        utils.sendText(By.id(ACCOUNT_NAME_FIELD), utils.getProperty("firstName"));
        utils.sendText(By.id(CUSTOMER_REFERENCE_FIELD), utils.getProperty("customerRef"));
        utils.selectByVisibleText(By.id(BILLING_CONTACTID_FIELD), utils.getProperty("firstName"));
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
    }

    public void assertSavedBillingDetails() {

        utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
    }

    public void clickCLIButton() {
        utils.clickBtn(By.id(CLI_BUTTON));
    }

    public void addCLIs() {
        accessCompanyMenu();
        clickCLIButton();
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();

        utils.clickBtn(By.id(CLI_NUMBER_FIELD));
        utils.sendText(By.id(CLI_NUMBER_FIELD), RanNumber);
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        utils.verifyStringMatch(By.cssSelector(ADDED_CLI_CHECK_FIELD), RanNumber);
        //TODO
        utils.closeCurrentPage();
        utils.switchToParentWindow();
    }

    public void assertCLIs() {
        clickCLIButton();
        utils.verifyStringMatch(By.linkText(RanNumber), RanNumber);
    }

    public void clickServiceChargesButton() {
        utils.clickBtn(By.id(SERVICECHARGE_BUTTON));
    }

    public void clickServiceChargesOneOffButton() {
        utils.clickBtn(By.linkText(SERVICECHARGE_ONEOFF_BUTTON));
    }

    public void addRecurringChargesPart1() {
        clickServiceChargesButton();
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.clickBtn(By.id(SERVICECHARGE_DESC_FIELD));
        utils.sendText(By.id(SERVICECHARGE_DESC_FIELD), utils.getProperty("serviceChargeRecurringDesc"));
        utils.clickBtn(By.id(FIRSTPAYMENT_DESC_FIELD));
        today = new java.util.Date().getTime();
        utils.selectByVisibleText(By.cssSelector(SELECT_MONTH_DROPDOWN), new SimpleDateFormat("MMM").format(today));
        utils.selectByVisibleText(By.cssSelector(SELECT_YEAR_DROPDOWN), new SimpleDateFormat("yyyy").format(today));
        day = Integer.toString(Integer.parseInt(new SimpleDateFormat("dd").format(today)));
        utils.selectDay(By.partialLinkText(day), day);
        utils.selectByIndex(By.id(SERVICECHARGE_CHARGETYPE_DROPDOWN), 1);
    }

    public void addRecurringChargesPart2() {
        utils.selectByIndex(By.id(SERVICECHARGE_FREQUENCY_DROPDOWN), 1);
        utils.selectByVisibleText(By.id(SELECT_CLI_DROPDOWN), RanNumber);
        utils.sendText(By.id(SERVICECHARGE_QUANTITY_FIELD), utils.getProperty("serviceChargeQuantity"));
        utils.selectByIndex(By.id(SERVICECHARGE_CARRIER_DROPDOWN), 1);
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
        utils.closeCurrentPage();
        utils.switchToParentWindow();
    }

    public void assertAddedRecurringCharges() {
        clickServiceChargesButton();
    }

    public void addOneOffChargesPart1() {
        clickServiceChargesOneOffButton();
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.clickBtn(By.id(SERVICECHARGE_DESC_FIELD));
        utils.sendText(By.id(SERVICECHARGE_DESC_FIELD), utils.getProperty("serviceChargeOneOffDesc"));
        utils.clickBtn(By.id(FIRSTPAYMENT_DESC_FIELD));
        utils.selectByVisibleText(By.cssSelector(SELECT_MONTH_DROPDOWN), new SimpleDateFormat("MMM").format(today));
        utils.selectByVisibleText(By.cssSelector(SELECT_YEAR_DROPDOWN), new SimpleDateFormat("yyyy").format(today));
        utils.selectDay(By.partialLinkText(day), day);
        utils.selectByVisibleText(By.id(SELECT_CLI_DROPDOWN), RanNumber);
        utils.selectByVisibleText(By.id(SERVICECHARGE_CHARGETYPE_DROPDOWN), utils.getProperty("serviceChargeType"));
    }

    public void addOneOffChargesPart2() {
        utils.selectByVisibleText(By.id(SERVICECHARGE_FREQUENCY_DROPDOWN), utils.getProperty("serviceChargeOneOffFrequency"));
        utils.selectByVisibleText(By.id(SERVICECHARGE_CARRIER_DROPDOWN), utils.getProperty("serviceChargeCarrier"));
        utils.sendText(By.id(SERVICECHARGE_QUANTITY_FIELD), utils.getProperty("serviceChargeQuantity"));
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
        utils.closeCurrentPage();
        utils.switchToParentWindow();
    }

    public void assertAddedOneOffCharges() {
        clickServiceChargesButton();
        clickServiceChargesOneOffButton();
        utils.verifyStringMatch(By.linkText("One Off"), "One Off");
    }

    public void addPricingDetails() {
        accessCompanyMenu();
        clickPricingDetails();
        utils.selectByIndex(By.id(PRICING_DETAILS_PACKAGE_FIELD), 1);
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
    }

    public void assertAddedPricingDetails() {
        utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
    }

    public void clickConfigManager() {
        utils.clickBtn(By.id(CONFIGMANAGER_BUTTON));
    }

    public void addNewTariffWithTariffCategory(String tariff_Categories) {
        clickConfigManager();
        utils.clickBtn(By.xpath(TARIFFMANAGER_BUTTON));
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.clickBtn(By.id(TARIFFNAME_FIELD));
        utils.sendText(By.id(TARIFFNAME_FIELD), NewBusinessCustomerPage.RanName);
        utils.clickBtn(By.cssSelector("input[value='" + tariff_Categories + "']"));
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        utils.closeCurrentPage();
        utils.switchToParentWindow();
    }

    public void clickPricingDetails() {
        utils.clickBtn(By.id(PRICING_DETAILS_BUTTON));
    }

    public void verifyNewlyAddedTariffCategory() {
        accessCompanyMenu();
        clickPricingDetails();
        utils.clickBtn(By.xpath(PRICINGDETAILS_MOBILE_DROPDOWN));
        String expectedText = driver.findElement(By.xpath("//select[@id='sinfo_Mob_Tariff']//option[contains(text(),'" + NewBusinessCustomerPage.RanName + "')]")).getText();
        Assert.assertEquals(expectedText, NewBusinessCustomerPage.RanName);
        String checkInVoice = driver.findElement(By.xpath(PRICINGDETAILS_VOICE_DROPDOWN)).getText();
        Assert.assertNotEquals(checkInVoice, NewBusinessCustomerPage.RanName);
        String checkInData = driver.findElement(By.xpath(PRICINGDETAILS_DATA_DROPDOWN)).getText();
        Assert.assertNotEquals(checkInData, NewBusinessCustomerPage.RanName);
        String checkInServiceCharge = driver.findElement(By.xpath(PRICINGDETAILS_SERVICECHARGE_DROPDOWN)).getText();
        Assert.assertNotEquals(checkInServiceCharge, NewBusinessCustomerPage.RanName);
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
    }

    public void addTariffWithTariffTypes(String tariff_types) {
        clickConfigManager();
        utils.clickBtn(By.xpath(TARIFFMANAGER_BUTTON));
        utils.waitForElementVisible(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.clickBtn(By.id(TARIFFNAME_FIELD));
        utils.sendText(By.id(TARIFFNAME_FIELD), NewBusinessCustomerPage.RanName);
        utils.clickBtn(By.xpath("//td[@class='label_txt']//input[@value='" + tariff_types + "']"));
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        utils.closeCurrentPage();
        utils.switchToParentWindow();
    }

    public void searchAndAssertNewlyAddedTariffType(String tariff_search) {
        utils.selectByVisibleText(By.id(TARIFFSEARCH_BYTYPE_FIELD), tariff_search);
        utils.sendText(By.id(SEARCH_BUTTON), NewBusinessCustomerPage.RanName);
        utils.keyBoardEnter(By.id(SEARCH_BUTTON));
        utils.verifyStringMatch(By.linkText(newBusinessCustomerPage.RanName), newBusinessCustomerPage.RanName);
        utils.selectByVisibleText(By.id(TARIFFSEARCH_BYTYPE_FIELD), "Buy");
        List<WebElement> checkInBuy = driver.findElements(By.xpath("//a[@href='/team3/Configuration/EditTariff/292'][contains(text(),'" + newBusinessCustomerPage.RanName + "')]"));
        assertTrue(checkInBuy.isEmpty());
        utils.selectByVisibleText(By.id(TARIFFSEARCH_BYTYPE_FIELD), "Baseline");
        List<WebElement> checkInBaseline = driver.findElements(By.xpath("//a[@href='/team3/Configuration/EditTariff/292'][contains(text(),'" + newBusinessCustomerPage.RanName + "')]"));
        assertTrue(checkInBaseline.isEmpty());
    }

    public void createNewServiceChargeType() {
        clickConfigManager();
        utils.clickBtn(By.xpath(SERVICECHARGETYPES_BUTTON));
        //utils.clickBtn(By.cssSelector(ADD_BUTTON_CSS));
        utils.waitForElementVisible(By.cssSelector(ADD_BUTTON_CSS));
        utils.jumpToPopUpWindow(By.cssSelector(ADD_BUTTON_CSS));
        utils.waitForElementVisible(By.id(ADDSERVICECHARGE_CHARGETYPE_FIELD));
        utils.clickBtn(By.id(ADDSERVICECHARGE_CHARGETYPE_FIELD));
        utils.sendText(By.id(ADDSERVICECHARGE_CHARGETYPE_FIELD), NewBusinessCustomerPage.RanName);
        utils.selectByVisibleText(By.id(ADDSERVICECHARGE_FREQUENCY_FIELD), "Monthly");
        utils.waitForElementVisible(By.xpath(SERVICECHARGE_SAVE_BUTTON));
        utils.clickBtn(By.xpath(SERVICECHARGE_SAVE_BUTTON));
        utils.jumpToParentPopUp();
        utils.clickBtn(By.id(SEARCH_BUTTON));
        utils.sendText(By.id(SEARCH_BUTTON), NewBusinessCustomerPage.RanName);
        utils.keyBoardEnter(By.id(SEARCH_BUTTON));
        utils.verifyStringMatch(By.linkText(NewBusinessCustomerPage.RanName), NewBusinessCustomerPage.RanName);
    }

    public void verifyServiceChargeTypes() {
        accessCompanyMenu();
        clickServiceChargesButton();
        utils.waitForElementVisible(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.clickBtn(By.id(SERVICECHARGE_CHARGETYPE_DROPDOWN));
        utils.assertTheElementAndTextPresent(By.xpath("//select[@id='r_chargeid']//option[contains(text(),'" + newBusinessCustomerPage.RanName + "')]"), newBusinessCustomerPage.RanName);
        driver.switchTo().window(utils.parentWindow);
        utils.clickBtn(By.linkText(SERVICECHARGE_ONEOFF_BUTTON));
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.clickBtn(By.id(SERVICECHARGE_CHARGETYPE_DROPDOWN));
        utils.assertTheElementAndTextPresent(By.xpath("//select[@id='r_chargeid']//option[contains(text(),'" + newBusinessCustomerPage.RanName + "')]"), newBusinessCustomerPage.RanName);
        driver.switchTo().window(utils.parentWindow);
    }

    public void createBillingPackage() {

        clickConfigManager();
        utils.clickBtn(By.xpath(PACKAGEMANAGER_BUTTON));
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.clickBtnWithWait(By.id(ADDPACKAGE_TARIFFNAME_FIELD));
        utils.sendText(By.id(ADDPACKAGE_TARIFFNAME_FIELD), NewBusinessCustomerPage.RanName);
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        utils.closeCurrentPage();
        utils.switchToParentWindow();
        utils.verifyStringMatch(By.linkText(NewBusinessCustomerPage.RanName), NewBusinessCustomerPage.RanName);
    }


    public void verifyBillingPackage() {
        newBusinessCustomerPage.clickContactManagerButton();
        accessCompanyMenu();
        utils.clickBtn(By.id(PRICING_DETAILS_BUTTON));
        utils.clickBtn(By.id(PRICING_DETAILS_PACKAGE_FIELD));
        utils.selectByVisibleText(By.id(PRICING_DETAILS_PACKAGE_FIELD), NewBusinessCustomerPage.RanName);
    }

    public void createNewFreeMinutePlan() {
        clickConfigManager();
        utils.clickBtn(By.xpath(FREEMINUTES_BUTTON));
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.clickBtnWithWait(By.id(FREEMINUTES_PLANNAME_FIELD));
        utils.sendText(By.id(FREEMINUTES_PLANNAME_FIELD), NewBusinessCustomerPage.RanName);
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        utils.jumpToPopUpWindow(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.sendText(By.id(FREEMINUTES_PLANAMOUNT_FIELD), "1000");
        utils.selectByVisibleText(By.id(FREEMINUTES_PLAN_WHATID_FIELD), "Calls");
        utils.selectByVisibleText(By.id(FREEMINUTES_PLAN_APPLYTO_FIELD), "Per Cli");
        utils.selectByVisibleText(By.id(FREEMINUTES_PLAN_FREQUENCY_FIELD), "Per Billing Period");
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
        utils.closeCurrentPage();
        utils.switchToParentWindow();
    }

    public void verifyFreeMinutePlan() {
        clickConfigManager();
        utils.clickBtn(By.xpath(PACKAGEMANAGER_BUTTON));
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.clickBtnWithWait(By.id(ADDPACKAGE_TARIFFNAME_FIELD));
        driver.findElement(By.cssSelector(PACKAGEMANAGER_FREEMINUTES_SELECTBOX));
        String expectedText = driver.findElement(By.xpath("//table[@id='GroupTable']/tbody//tr/td[contains(text(),'" + NewBusinessCustomerPage.RanName + "')]")).getText();
        Assert.assertEquals(expectedText, NewBusinessCustomerPage.RanName);
        utils.clickBtn(By.xpath("//table[@id='GroupTable']/tbody//tr/td[contains(text(),'" + NewBusinessCustomerPage.RanName + "')]/../td/label"));
    }
}

