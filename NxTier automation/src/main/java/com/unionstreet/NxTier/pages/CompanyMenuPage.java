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
    public final String CHARGEGROUPS_BUTTON = "//*[@id='subMenu']/ul/li[5]/a";
    public final String ADDCHARGEGROUP_DESTINATION_FIELD = "Destination";
    public final String ADDCHARGEGROUP_PLATFORMSELECTION_RADIOBUTTON = "//div[@class='field-input lineheight28 left']/label/input[@value='True']";
    public final String ADDCHARGEGROUP_SUBMIT_BUTTON = "//input[@value='Submit']";
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
    private final String CLI_NUMBER_FIELD = "CLI";
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
    private final String ADDSERVICECHARGE_FREQUENCY_FIELD = "//select[@id='rc_frequency_type_id']";
    private final String PACKAGEMANAGER_BUTTON = "//*[@id='subMenu']/ul/li[3]/a";
    private final String ADDPACKAGE_TARIFFNAME_FIELD = "mpackage_name";
    ElementUtils utils = new ElementUtils();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    private String SERVICECHARGE_SAVE_BUTTON = "//input[@onclick='return ValidateType();']";
    private long today;
    private String day;

    public void accessCompanyMenu() {

        try {
            newBusinessCustomerPage.clickContactManagerButton();
            utils.sendText(By.id(SEARCH_BUTTON), NewBusinessCustomerPage.RanName);
            utils.keyBoardEnter(By.id(SEARCH_BUTTON));
            utils.clickBtn(By.linkText(NewBusinessCustomerPage.RanName));
            utils.switchToNewWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickInvoicingDetailsButton() {
        utils.clickBtn(By.id(INVOICINGDETAILS_BUTTON));
    }

    public void addInvoicingDetails() {
        try {
            accessCompanyMenu();
            clickInvoicingDetailsButton();
            utils.selectByVisibleText(By.id(BILLING_REPORT_PROFILE_DROPDOWN), utils.getProperty("billingReportProfile"));
            utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assertSavedInvoiceDetails() {
        try {
            utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickBillingDetailsButton() {
        utils.clickBtn(By.id(BILLINGDETAILS_BUTTON));
    }

    public void addBillingDetails() {
        try {
            clickBillingDetailsButton();
            utils.selectByVisibleText(By.id(MODE_OF_PAYMENT_FIELD), utils.getProperty("billingDetailsPaymentMode"));
            utils.sendText(By.id(SORT_CODE_FIELD), utils.getProperty("sortCode"));
            utils.sendText(By.id(ACCOUNT_NUMBER_FIELD), utils.getProperty("accountNumber"));
            utils.sendText(By.id(ACCOUNT_NAME_FIELD), utils.getProperty("firstName"));
            utils.sendText(By.id(CUSTOMER_REFERENCE_FIELD), utils.getProperty("customerRef"));
            utils.selectByVisibleText(By.id(BILLING_CONTACTID_FIELD), utils.getProperty("firstName"));
            utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assertSavedBillingDetails() {
        try {
            utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickCLIButton() {
        utils.clickBtn(By.id(CLI_BUTTON));
    }

    public void addCLIs() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assertCLIs() {
        try {
            clickCLIButton();
            utils.verifyStringMatch(By.linkText(RanNumber), RanNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickServiceChargesButton() {
        utils.clickBtn(By.id(SERVICECHARGE_BUTTON));
    }

    public void clickServiceChargesOneOffButton() {
        utils.clickBtn(By.linkText(SERVICECHARGE_ONEOFF_BUTTON));
    }

    public void addRecurringChargesPart1() {
        try {
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
            utils.selectByVisibleText(By.id(SERVICECHARGE_CHARGETYPE_DROPDOWN), utils.getProperty("serviceChargeType"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRecurringChargesPart2() {
        try {
            utils.selectByVisibleText(By.id(SERVICECHARGE_FREQUENCY_DROPDOWN), utils.getProperty("serviceChargeRecurringFrequency"));
            utils.selectByVisibleText(By.id(SELECT_CLI_DROPDOWN), RanNumber);
            utils.sendText(By.id(SERVICECHARGE_QUANTITY_FIELD), utils.getProperty("serviceChargeQuantity"));
            utils.selectByVisibleText(By.id(SERVICECHARGE_CARRIER_DROPDOWN), utils.getProperty("serviceChargeCarrier"));
            utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
            utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
            utils.closeCurrentPage();
            utils.switchToParentWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assertAddedRecurringCharges() {
        try {
            clickServiceChargesButton();
            utils.verifyStringMatch(By.linkText("Monthly"), "Monthly");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addOneOffChargesPart1() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addOneOffChargesPart2() {
        try {
            utils.selectByVisibleText(By.id(SERVICECHARGE_FREQUENCY_DROPDOWN), utils.getProperty("serviceChargeOneOffFrequency"));
            utils.selectByVisibleText(By.id(SERVICECHARGE_CARRIER_DROPDOWN), utils.getProperty("serviceChargeCarrier"));
            utils.sendText(By.id(SERVICECHARGE_QUANTITY_FIELD), utils.getProperty("serviceChargeQuantity"));
            utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
            utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
            utils.closeCurrentPage();
            utils.switchToParentWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assertAddedOneOffCharges() {
        try {
            clickServiceChargesButton();
            clickServiceChargesOneOffButton();
            utils.verifyStringMatch(By.linkText("One Off"), "One Off");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addPricingDetails() {
        try {
            accessCompanyMenu();
            clickPricingDetails();
            utils.selectByVisibleText(By.id(PRICING_DETAILS_PACKAGE_FIELD), utils.getProperty("pricingDetailsPackage"));
            utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assertAddedPricingDetails() throws InterruptedException {
        utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
    }

    public void clickConfigManager() {
        utils.clickBtn(By.id(CONFIGMANAGER_BUTTON));
    }

    public void addNewTariffWithTariffCategory(String tariff_Categories) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickPricingDetails() {
        utils.clickBtn(By.id(PRICING_DETAILS_BUTTON));
    }

    public void verifyNewlyAddedTariffCategory() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTariffWithTariffTypes(String tariff_types) {
        try {
            clickConfigManager();
            utils.clickBtn(By.xpath(TARIFFMANAGER_BUTTON));
            utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
            utils.switchToNewWindow();
            utils.clickBtn(By.id(TARIFFNAME_FIELD));
            utils.sendText(By.id(TARIFFNAME_FIELD), NewBusinessCustomerPage.RanName);
            utils.clickBtn(By.xpath("//td[@class='label_txt']//input[@value='" + tariff_types + "']"));
            utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
            utils.closeCurrentPage();
            utils.switchToParentWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchAndAssertNewlyAddedTariffType(String tariff_search) throws InterruptedException {
        try {
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
        } catch (Exception e) {
        }
    }

    public void createNewServiceChargeType() throws InterruptedException {
        try {
            clickConfigManager();
            utils.clickBtn(By.xpath(SERVICECHARGETYPES_BUTTON));
            utils.clickBtn(By.cssSelector(ADD_BUTTON_CSS));
            utils.switchToNewWindow();
            utils.clickBtn(By.id(ADDSERVICECHARGE_CHARGETYPE_FIELD));
            utils.sendText(By.id(ADDSERVICECHARGE_CHARGETYPE_FIELD), NewBusinessCustomerPage.RanName);
            utils.selectByVisibleText(By.xpath(ADDSERVICECHARGE_FREQUENCY_FIELD), "Monthly");
            utils.waitForElementVisible(By.xpath(SERVICECHARGE_SAVE_BUTTON));
            utils.clickBtn(By.xpath(SERVICECHARGE_SAVE_BUTTON));
            utils.clickBtn(By.id(SEARCH_BUTTON));
            utils.sendText(By.id(SEARCH_BUTTON), NewBusinessCustomerPage.RanName);
            utils.keyBoardEnter(By.id(SEARCH_BUTTON));
            utils.verifyStringMatch(By.linkText(NewBusinessCustomerPage.RanName), NewBusinessCustomerPage.RanName);
        } catch (Exception e) {
        }
    }

    public void verifyServiceChargeTypes() {

        try {
            accessCompanyMenu();
            clickServiceChargesButton();
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

        } catch (Exception e) {
        }
    }

    public void createBillingPackage() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyBillingPackage() {
        try {
            newBusinessCustomerPage.clickContactManagerButton();
            accessCompanyMenu();
            utils.clickBtn(By.id(PRICING_DETAILS_BUTTON));
            utils.clickBtn(By.id(PRICING_DETAILS_PACKAGE_FIELD));
            utils.selectByVisibleText(By.id(PRICING_DETAILS_PACKAGE_FIELD), NewBusinessCustomerPage.RanName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createNewFreeMinutePlan() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyFreeMinutePlan() {
        try {
            clickConfigManager();
            utils.clickBtn(By.xpath(PACKAGEMANAGER_BUTTON));
            utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
            utils.switchToNewWindow();
            utils.clickBtnWithWait(By.id(ADDPACKAGE_TARIFFNAME_FIELD));
            driver.findElement(By.cssSelector(PACKAGEMANAGER_FREEMINUTES_SELECTBOX));
            String expectedText = driver.findElement(By.xpath("//table[@id='GroupTable']/tbody//tr/td[contains(text(),'" + NewBusinessCustomerPage.RanName + "')]")).getText();
            Assert.assertEquals(expectedText, NewBusinessCustomerPage.RanName);
            utils.clickBtn(By.xpath("//table[@id='GroupTable']/tbody//tr/td[contains(text(),'" + NewBusinessCustomerPage.RanName + "')]/../td/label"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createChargeGroup() {
        try {
            clickConfigManager();
            utils.clickBtn(By.xpath(CHARGEGROUPS_BUTTON));
            utils.clickBtn(By.cssSelector(ADD_BUTTON_CSS));
            utils.clickBtn(By.id(ADDCHARGEGROUP_DESTINATION_FIELD));
            utils.sendText(By.id(ADDCHARGEGROUP_DESTINATION_FIELD), NewBusinessCustomerPage.RanName);
            utils.clickBtn(By.xpath(ADDCHARGEGROUP_PLATFORMSELECTION_RADIOBUTTON));
            Thread.sleep(1000);
            utils.clickBtn(By.xpath(ADDCHARGEGROUP_SUBMIT_BUTTON));
            driver.switchTo().parentFrame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyChargeGroup() {
        try {
            utils.clickBtn(By.linkText("Mobile"));
            utils.clickBtn(By.id(SEARCH_BUTTON));
            utils.sendText(By.id(SEARCH_BUTTON), NewBusinessCustomerPage.RanName);
            utils.keyBoardEnter(By.id(SEARCH_BUTTON));
            utils.verifyStringMatch(By.linkText(NewBusinessCustomerPage.RanName), NewBusinessCustomerPage.RanName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
