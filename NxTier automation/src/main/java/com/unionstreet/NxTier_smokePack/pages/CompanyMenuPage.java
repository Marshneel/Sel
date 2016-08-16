package com.unionstreet.NxTier_smokePack.pages;

import com.unionstreet.NxTier_smokePack.support.ElementUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import java.text.SimpleDateFormat;
import static com.unionstreet.NxTier_smokePack.support.BaseClass.driver;

public class CompanyMenuPage {

    private final String INVOICINGDETAILS_BUTTON = "HrefInvoicingDetails";
    private final String BILLINGDETAILS_BUTTON = "HrefBillingDetails";
    private final String SEARCH_BUTTON = "txtsearch";
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
    private final String PRICING_DETAILS = "HrefPricingDetails";
    private final String PRICING_DETAILS_PACKAGE = "sinfo_package";
    private final String ORDERS_BUTTON = "HrefOrders";
    //TODO
    private final String ORDERS_CREATEQUOTE = ".add";
    //TODO
    private final String ASSERT_ORDER = "//*[@class='table_row_alt_subchild']/td[2]";
    private final String ORDERQUOTE_DESCRIPTION = "QuoteDescription";
    private final String ORDERS_SAVEQUOTE = "CreateQuoteButton";
    public static String RanNumber;
    private long today;
    private String day;
    ElementUtils utils = new ElementUtils();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();

    public void accessCompanyMenu() {
        try {
            newBusinessCustomerPage.clickContactManagerButton();
            utils.sendText(By.id(SEARCH_BUTTON), newBusinessCustomerPage.RanName);
            utils.keyBoardEnter(By.id(SEARCH_BUTTON));
            utils.clickBtn(By.linkText(newBusinessCustomerPage.RanName));
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
            utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUSINESSCUSTOMER_CLI_SERVICE_CHARGES_BUTTON));
            utils.switchToNewWindow();
            RanNumber = RandomStringUtils.randomNumeric(8);
            utils.sendText(By.id(CLI_NUMBER_FIELD), RanNumber);
            utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
            utils.verifyStringMatch(By.cssSelector(ADDED_CLI_CHECK_FIELD), RanNumber);
            //TODO
            driver.close();
            driver.switchTo().window(utils.parentWindow);
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
            utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUSINESSCUSTOMER_CLI_SERVICE_CHARGES_BUTTON));
            utils.switchToNewWindow();
            utils.sendText(By.id(SERVICECHARGE_DESC_FIELD), utils.getProperty("serviceChargeRecurringDesc"));
            utils.clickBtn(By.id(FIRSTPAYMENT_DESC_FIELD));
            today = new java.util.Date().getTime();
            utils.selectByVisibleText(By.cssSelector(SELECT_MONTH_DROPDOWN), new SimpleDateFormat("MMM").format(today));
            utils.selectByVisibleText(By.cssSelector(SELECT_YEAR_DROPDOWN), new SimpleDateFormat("yyyy").format(today));
            day = new SimpleDateFormat("dd").format(today);
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
            driver.close();
            driver.switchTo().window(utils.parentWindow);
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
            utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUSINESSCUSTOMER_CLI_SERVICE_CHARGES_BUTTON));
            utils.switchToNewWindow();
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
            driver.close();
            driver.switchTo().window(utils.parentWindow);
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

    public void clickOrdersButton() {
        utils.clickBtn(By.id(ORDERS_BUTTON));
    }

    public void addOrders() {
        accessCompanyMenu();
        clickOrdersButton();
        utils.jumpToPopUpWindow(By.cssSelector(ORDERS_CREATEQUOTE));
        utils.sendText(By.id(ORDERQUOTE_DESCRIPTION), newBusinessCustomerPage.RanName);
        utils.clickBtn(By.id(ORDERS_SAVEQUOTE));
        driver.close();
        driver.switchTo().window(utils.parentWindow);
    }

    public void assertAddedOrders() {
        accessCompanyMenu();
        clickOrdersButton();
        utils.verifyStringMatch(By.xpath(ASSERT_ORDER), utils.getProperty("assertOrderActualValue"));
    }

    public void addPricingDetails() {
        accessCompanyMenu();
        utils.clickBtn(By.id(PRICING_DETAILS));
        utils.selectByVisibleText(By.id(PRICING_DETAILS_PACKAGE), utils.getProperty("pricingDetailsPackage"));
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
    }

    public void assertAddedPricingDetails() {
        utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
    }
}