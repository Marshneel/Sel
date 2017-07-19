package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.text.SimpleDateFormat;

import static com.unionstreet.NxTier.support.BaseClass.driver;

public class CompanyMenuPage {

    public static String RanNumber = RandomStringUtils.randomNumeric(8);
    public static String RanServiceChargeName;
    public final String SEARCH_BUTTON = "txtsearch";
    public final String CLI_NUMBER_FIELD = "CLI";
    public final String SITEDETAILS_SITE_NAME = "SiteName";
    public final String SITEDETAILS_SHORT_NAME = "ShortName";
    //TODO
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
    private final String SITEDETAILS_POSTCODE = "PostCode";
    private final String SITEDETAILS_TELEPHONE = "Telephone";
    private final String SITEDETAILS_ACCOUNT_REF = "sage_id";
    private final String SITEDETAILS_BILLING_ADDRESS = "InvoiceAddress";
    private final String COMPANYSITES_BUTTON = "HrefCompanySites";
    private final String SALES_PRICE_FIELD="r_default";
    private final String COST_PRICE_FIELD="r_cost_price";
    private final String BASELINE_COST_FIELD="r_baseline";
    private final String DESCRIPTION_TEXT_ON_ADD_SURCHARGE_PAGE="//label[contains(text(),'Description')]";
    private final String BILLRUN_TEXT_ON_ADD_SURCHARGE_PAGE="//label[contains(text(),'Bill Run')]";
    private final String COST_PRICE_TEXT_ON_ADD_SURCHARGE_PAGE="//label[contains(text(),'Cost Price')]";
    private final String BASELINE_COST_TEXT_ON_ADD_SURCHARGE_PAGE="//label[contains(text(),'Baseline Cost')]";
    private final String SALES_PRICE_TEXT_ON_ADD_SURCHARGE_PAGE="//label[contains(text(),'Sales Price')]";
    private final String COST_PRICE_TEXT_IN_THE_EXISTING_SERVICE_CHARGE_PAGE="//th[contains(text(),'Cost Price')]";
    private final String BILLRUN_TEXT_IN_THE_EXISTING_SERVICE_CHARGE_PAGE="//th[contains(text(),'Bill Run')]";
    private final String VOICE_TARIFF_FROM_PACKAGE_CHECKBOX="IsVoiceTariffFromPackage";
    private final String DATA_TARIFF_FROM_PACKAGE_CHECKBOX="IsDataTariffFromPackage";
    private final String MOBILE_TARIFF_FROM_PACKAGE_CHECKBOX="IsMobileTariffFromPackage";
    private final String SERVICE_CHARGE_FROM_PACKAGE_CHECKBOX="IsSCTariffFromPackage";
    private final String ENABLE_FREEMINUTES_CHECKBOX="EnableFreeminutes";
    private final String FREEMINUTES_FROM_PACKAGE_CHECKBOX="chkFreeminsfromPackage";
    public final String VOICE_TARIFF_FIELD_DROPDOWN="sinfo_LCR_Tariff";
    public final String DATA_TARIFF_FIELD_DROPDOWN="sinfo_Data_Tariff";
    private final String SELECT_A_PACKAGE_FROM_DROPDOWN="sinfo_package";


    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods = new CommonMethods();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    ConfigManagerPage configManagerPage = new ConfigManagerPage();
    CreateTariffPage createTariffPage = new CreateTariffPage();
    private long today;
    private String day;

    public void addNewSite() throws InterruptedException {
        accessCompanyMenu(NewBusinessCustomerPage.RanName);
        clickCompanySitesButton();
        //utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow(By.cssSelector(commonMethods.ADD_BUTTON));
    }

    public void addNewSiteNames() {
        try {
            utils.sendText(By.id(SITEDETAILS_SITE_NAME), (newBusinessCustomerPage.RanName + RanNumber));
            utils.sendText(By.id(SITEDETAILS_SHORT_NAME), (newBusinessCustomerPage.RanName + RanNumber));
            utils.sendText(By.id(SITEDETAILS_ACCOUNT_REF), (RanNumber));
        } catch (Exception e) {
            utils.sendText(By.id(SITEDETAILS_SITE_NAME), (newBusinessCustomerPage.RanName + RanNumber));
            utils.sendText(By.id(SITEDETAILS_SHORT_NAME), (newBusinessCustomerPage.RanName + RanNumber));
            utils.sendText(By.id(SITEDETAILS_ACCOUNT_REF), (RanNumber));
        }
    }

    public void addNewSiteAddress() {
        utils.sendText(By.id(SITEDETAILS_POSTCODE), utils.getProperty("postCode"));
        utils.sendText(By.id(SITEDETAILS_TELEPHONE), (RanNumber));
        utils.sendText(By.id(SITEDETAILS_ACCOUNT_REF), (RanNumber));
    }

    public void setOwnSiteBillingAddress() {

        utils.selectByVisibleText(By.id(SITEDETAILS_BILLING_ADDRESS), utils.getProperty("siteOwnBillingAddress"));
    }

    public void assertNewSite() {
        driver.switchTo().window(utils.parentWindow);
        utils.verifyStringMatch(By.linkText(newBusinessCustomerPage.RanName + RanNumber), newBusinessCustomerPage.RanName + RanNumber);
    }

    public void clickCompanySitesButton() {
        utils.waitForElementVisible(By.id(COMPANYSITES_BUTTON));
        utils.clickBtn(By.id(COMPANYSITES_BUTTON));
    }

    public void accessCompanyMenu(String ranName) throws InterruptedException {
        newBusinessCustomerPage.clickContactManagerButton();
        utils.sendText(By.id(SEARCH_BUTTON), ranName);
        utils.keyBoardEnter(By.id(SEARCH_BUTTON));
        utils.waitForElementVisible(By.linkText(ranName));
       // utils.clickBtn(By.linkText(ranName));
        utils.switchToNewWindow(By.linkText(ranName));
    }

    public void clickInvoicingDetailsButton() {
        utils.clickBtn(By.id(INVOICINGDETAILS_BUTTON));
    }

    public void addInvoicingDetails() throws InterruptedException {
        accessCompanyMenu(NewBusinessCustomerPage.RanName);
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

    public void addCLIs(String ranName, String number) throws InterruptedException {
        accessCompanyMenu(ranName);
        clickCLIButton();
       // utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        try {
          try{  utils.waitForElementVisible(By.id(CLI_NUMBER_FIELD));}catch (Exception e){utils.loopThroughWebPagesUntilElementIsFound(By.id(CLI_NUMBER_FIELD));}
            utils.clickBtn(By.id(CLI_NUMBER_FIELD));
            utils.sendText(By.id(CLI_NUMBER_FIELD), number);
        } catch (TimeoutException e) {
            utils.sendText(By.id(CLI_NUMBER_FIELD), number);
        }
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
        utils.verifyStringMatch(By.cssSelector(ADDED_CLI_CHECK_FIELD), number);
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
        utils.jumpToPopUpWindow(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.waitForElementVisible(By.id(SERVICECHARGE_DESC_FIELD));
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

    public void addOneOffChargesPart1() throws InterruptedException {
        clickServiceChargesOneOffButton();
        //utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.waitForElementVisible(By.id(SERVICECHARGE_DESC_FIELD));
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

    public void addPricingDetails() throws InterruptedException {
        accessCompanyMenu(NewBusinessCustomerPage.RanName);
        clickPricingDetails();
        utils.selectByIndex(By.id(SELECT_A_PACKAGE_FROM_DROPDOWN), 1);
        utils.clickBtn(By.cssSelector(newBusinessCustomerPage.SAVE_BUTTON));
    }

    public void assertAddedPricingDetails() {
        utils.verifyStringMatch(By.id(newBusinessCustomerPage.SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
    }

    public void clickPricingDetails() {
        utils.waitForElementVisible(By.id(PRICING_DETAILS_BUTTON));
        utils.clickBtn(By.id(PRICING_DETAILS_BUTTON));
    }


    public void assertAgentCreatedTariffandFreeMinutes() throws InterruptedException {
        clickPricingDetails();
        utils.waitForElementVisible(By.id(ENABLE_FREEMINUTES_CHECKBOX));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.id(ENABLE_FREEMINUTES_CHECKBOX));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'" + configManagerPage.RanFreeMinutePlanName + "')]"));
        utils.searchAndAssertTextPresent(By.id("fmSiteTable"), "" + configManagerPage.RanFreeMinutePlanName + "");
        utils.selectByVisibleText(By.id(VOICE_TARIFF_FIELD_DROPDOWN), createTariffPage.RanTariffPlanName);
    }

    public void assignTariffAndFreeMinutesToCustomer(String FreeMinutePlan, String TariffPlan) throws InterruptedException {
        utils.waitForElementVisible(By.id(ENABLE_FREEMINUTES_CHECKBOX));
        Thread.sleep(1000);
        utils.makeSureBoxIsChecked(By.id(ENABLE_FREEMINUTES_CHECKBOX), By.id(ENABLE_FREEMINUTES_CHECKBOX));
        utils.waitForElementVisible(By.xpath(" //table[@id='fmSiteTable']//td[contains(text(),'" + FreeMinutePlan + "')]"));
        Thread.sleep(1000);
        utils.makeSureBoxIsChecked(By.id("fmSelection13_isSelected"), By.id("fmSelection13_isSelected"));
        utils.waitForElementVisible(By.id(VOICE_TARIFF_FIELD_DROPDOWN));
        utils.selectByVisibleText(By.id(VOICE_TARIFF_FIELD_DROPDOWN), TariffPlan);
        utils.selectByVisibleText(By.id(DATA_TARIFF_FIELD_DROPDOWN), TariffPlan);
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);
    }

    public void assertCPAssignedTariffAndFreeMinutes(String tariffVoiceField, String tariffDataField, String tariffPlan, String freeMinutePlan) {
        utils.waitForElementVisible(By.xpath("//select[@id='" + tariffVoiceField + "']//option[@selected='selected'][contains(text(),'" + tariffPlan + "')]"));
        utils.waitForElementVisible(By.xpath("//select[@id='" + tariffDataField + "']//option[@selected='selected'][contains(text(),'" + tariffPlan + "')]"));
        utils.waitForElementVisible(By.xpath("//table[@id='fmSiteTable']//td[contains(text(),'" + freeMinutePlan + "')]/..//input[@checked='checked']"));
    }

    public void removeCPAssignedTariffAndFreeMinutes() throws InterruptedException {
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.id(ENABLE_FREEMINUTES_CHECKBOX));
        utils.selectByVisibleText(By.id(VOICE_TARIFF_FIELD_DROPDOWN), "Select");
        utils.selectByVisibleText(By.id(DATA_TARIFF_FIELD_DROPDOWN), "Select");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
    }

    public void assertAgentCannotSeeCPAssignedTariffAndFreeMinutes(String tariffPlan, String freeMinutePlan) throws InterruptedException {
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.id(ENABLE_FREEMINUTES_CHECKBOX));
        utils.assertElementNotPresent(By.xpath("//select[@id='sinfo_LCR_Tariff']//option[contains(text(),'" + tariffPlan + "')]"));
        utils.assertElementNotPresent(By.xpath("//select[@id='sinfo_Data_Tariff']//option[contains(text(),'" + tariffPlan + "')]"));
        utils.assertElementNotPresent(By.xpath("//table[@id='GroupTable']//tr[contains(text(),'" + freeMinutePlan + "')]"));
    }

    public void assertAgentCanOnlySeeAndAssignTariffAndFreeMinutePlansThatCPHasGivenPermissionFor(String tariffPlan, String unavailableTariffPlan) throws InterruptedException {
        utils.selectByVisibleText(By.id(VOICE_TARIFF_FIELD_DROPDOWN), tariffPlan);
        utils.selectByVisibleText(By.id(DATA_TARIFF_FIELD_DROPDOWN), tariffPlan);
        utils.assertElementNotPresent(By.xpath("//select[@id='sinfo_LCR_Tariff']//option[contains(text(),'" + unavailableTariffPlan + "')]"));
    }

    public void assignOrDeletePackageToCustomer(String packageName) {
        utils.waitForElementVisible(By.id(SELECT_A_PACKAGE_FROM_DROPDOWN));
        utils.selectByVisibleText(By.id(SELECT_A_PACKAGE_FROM_DROPDOWN), "" + packageName + "");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);

    }

    public void assertAgentCannotRe_AssignDeletedCustomerPackageUnlessItsAssignedToHim(String unavailablePackage, String availablePackage) {
        utils.waitForElementVisible(By.id(SELECT_A_PACKAGE_FROM_DROPDOWN));
        utils.assertElementNotPresent(By.xpath("//select[@id='sinfo_package']//option[contains(text(),'" + unavailablePackage + "')]"));
        utils.waitForElementVisible(By.xpath("//select[@id='sinfo_package']//option[contains(text(),'" + availablePackage + "')]"));
    }

    public void selectingPackageFromDropDown(String packageName) {
        utils.waitForElementVisible(By.id(SELECT_A_PACKAGE_FROM_DROPDOWN));
        utils.selectByVisibleText(By.id(SELECT_A_PACKAGE_FROM_DROPDOWN), packageName);
    }

    public void validatePricingDetailsPage_assertCheckedTariffsAndInitialSaveWithFreeMinutePackageAssertions() throws InterruptedException {
        utils.waitTillBoxChecked(By.id(VOICE_TARIFF_FROM_PACKAGE_CHECKBOX));
        utils.waitTillBoxChecked(By.id(DATA_TARIFF_FROM_PACKAGE_CHECKBOX));
        utils.waitTillBoxChecked(By.id(MOBILE_TARIFF_FROM_PACKAGE_CHECKBOX));
        utils.waitTillBoxChecked(By.id(SERVICE_CHARGE_FROM_PACKAGE_CHECKBOX));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitTillBoxChecked(By.id(ENABLE_FREEMINUTES_CHECKBOX));
        utils.waitTillBoxChecked(By.id(FREEMINUTES_FROM_PACKAGE_CHECKBOX));
    }

    public void validatePricingDetailsPage_unCheckPackageFreeMinutesAndAddNativeFreeMinutes(String freeMinutesPackage) throws InterruptedException {
        utils.makeSureBoxIsUnChecked(By.id(FREEMINUTES_FROM_PACKAGE_CHECKBOX), By.id(FREEMINUTES_FROM_PACKAGE_CHECKBOX));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+freeMinutesPackage+"')]"));
        utils.makeSureBoxIsChecked(By.xpath("//table[@id='fmSiteTable']//tr/td[contains(text(),'"+freeMinutesPackage+"')]/following-sibling::td/label"), By.xpath("//table[@id='fmSiteTable']//tr/td[contains(text(),'"+freeMinutesPackage+"')]/following-sibling::td/label"));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath("//table[@id='fmSiteTable']//tr/td[contains(text(),'"+freeMinutesPackage+"')]/following-sibling::td/input[@checked='checked']"));
    }

    public void validatePricingDetailsPage_assertTariffDropDownCannotBeUnselectedWhenOnPackage(String freeMinutePackage) {

        utils.makeSureBoxIsChecked(By.id(FREEMINUTES_FROM_PACKAGE_CHECKBOX), By.id(FREEMINUTES_FROM_PACKAGE_CHECKBOX));
        utils.waitForElementVisible(By.xpath("//div[@id='packageFMList']//td[contains(text(),'"+freeMinutePackage+"')]"));
        utils.makeSureBoxIsUnChecked(By.id(VOICE_TARIFF_FROM_PACKAGE_CHECKBOX), By.id(VOICE_TARIFF_FROM_PACKAGE_CHECKBOX));
        utils.waitForElementVisible(By.xpath("//select[@id='"+VOICE_TARIFF_FIELD_DROPDOWN+"']//option[contains(text(),'Select')]"));
        utils.assertUnchecked(By.id(VOICE_TARIFF_FROM_PACKAGE_CHECKBOX));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitTillBoxChecked(By.id(VOICE_TARIFF_FROM_PACKAGE_CHECKBOX));
    }

    public void validatePricingDetailsPage_selectingNativeTariffFromDropDown(String sellTariff, String buyTariff) {
        utils.makeSureBoxIsUnChecked(By.id(VOICE_TARIFF_FROM_PACKAGE_CHECKBOX), By.id(VOICE_TARIFF_FROM_PACKAGE_CHECKBOX));
        utils.selectByVisibleText(By.id(VOICE_TARIFF_FIELD_DROPDOWN), sellTariff);
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath("//select[@id='sinfo_LCR_Tariff']//option[@selected='selected'][contains(text(),'"+sellTariff+"')]"));
        utils.assertElementNotPresent(By.xpath("//select[@id='sinfo_LCR_Tariff']//option[contains(text(),'"+buyTariff+"')]"));
        utils.clickBtn(By.id("imgViewVoiceTariff"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Tariff Name : "+sellTariff+"')]"));
    }

    public void assertBillRunIsPresentForCPUnderInvoicingDetails() {
        utils.waitForElementVisible(By.xpath(BILLRUN_TEXT_ON_ADD_SURCHARGE_PAGE));
    }

    public void assertBillRunIsAbsentForAgentUnderInvoicingDetails() {
        utils.assertElementNotPresent(By.xpath(BILLRUN_TEXT_ON_ADD_SURCHARGE_PAGE));
    }

    public void assertBillRunAndChargeTypeUnderAddServices(boolean user) {
        if (user == true) {
            utils.waitForElementVisible(By.xpath(COST_PRICE_TEXT_IN_THE_EXISTING_SERVICE_CHARGE_PAGE));
            utils.waitForElementVisible(By.xpath(BILLRUN_TEXT_IN_THE_EXISTING_SERVICE_CHARGE_PAGE));
        }
        if (user == false) {
            utils.assertElementNotPresent(By.xpath(COST_PRICE_TEXT_IN_THE_EXISTING_SERVICE_CHARGE_PAGE));
            utils.assertElementNotPresent(By.xpath(BILLRUN_TEXT_IN_THE_EXISTING_SERVICE_CHARGE_PAGE));
        }
        utils.waitForElementVisible(By.linkText(SERVICECHARGE_ONEOFF_BUTTON));
        utils.clickBtn(By.linkText(SERVICECHARGE_ONEOFF_BUTTON));
        utils.waitForElementVisible(By.xpath(commonMethods.ADD_XPATH));
       // utils.clickBtn(By.xpath(commonMethods.ADD_XPATH));
        utils.switchToNewWindow(By.xpath(commonMethods.ADD_XPATH));

        if (user == true) {
            utils.waitForElementVisible(By.xpath(COST_PRICE_TEXT_ON_ADD_SURCHARGE_PAGE));
            utils.waitForElementVisible(By.xpath(BILLRUN_TEXT_ON_ADD_SURCHARGE_PAGE));
            utils.waitForElementVisible(By.xpath(BASELINE_COST_TEXT_ON_ADD_SURCHARGE_PAGE));
            utils.waitForElementVisible(By.xpath(SALES_PRICE_TEXT_ON_ADD_SURCHARGE_PAGE));
        }
        if (user == false) {
            utils.waitForElementVisible(By.xpath(DESCRIPTION_TEXT_ON_ADD_SURCHARGE_PAGE));
            utils.assertElementNotPresent(By.xpath(BILLRUN_TEXT_ON_ADD_SURCHARGE_PAGE));
            utils.waitForElementVisible(By.xpath(BASELINE_COST_TEXT_ON_ADD_SURCHARGE_PAGE));
            utils.waitForElementVisible(By.xpath(SALES_PRICE_TEXT_ON_ADD_SURCHARGE_PAGE));
            try {
                utils.assertElementNotPresent(By.xpath(COST_PRICE_TEXT_ON_ADD_SURCHARGE_PAGE));
            } catch (AssertionError e) {
                System.out.println("agent is able to see the cost price");
            }

        }
    }

    public void assertResellerCannotSeeCostAndBaseLinePriceUnderServiceCharges() {
        utils.waitForElementVisible(By.xpath(commonMethods.ADD_XPATH));
      //  utils.clickBtn(By.xpath(commonMethods.ADD_XPATH));
        utils.switchToNewWindow(By.xpath(commonMethods.ADD_XPATH));
        utils.waitForElementVisible(By.xpath(DESCRIPTION_TEXT_ON_ADD_SURCHARGE_PAGE));
        utils.assertElementNotPresent(By.xpath(COST_PRICE_TEXT_ON_ADD_SURCHARGE_PAGE));
        utils.assertElementNotPresent(By.xpath(BASELINE_COST_TEXT_ON_ADD_SURCHARGE_PAGE));
        utils.waitForElementVisible(By.xpath(SALES_PRICE_TEXT_ON_ADD_SURCHARGE_PAGE));
    }

    public void editAndClearPrice(String field, String placeHolder, String value) {
        utils.waitForElementVisible(By.xpath("//input[@id='" + field + "'][@placeholder='" + placeHolder + "']"));
        utils.sendText(By.id("" + field + ""), "" + value + "");
        utils.clearText(By.id("" + field + ""));
        utils.checkAlert();
        utils.waitForElementVisible(By.xpath("//input[@id='" + field + "'][@placeholder='" + placeHolder + "']"));
    }

    public void editPriceJustBeforeSaving(String field, String placeHolder, String value) {
        utils.waitForElementVisible(By.xpath("//input[@id='" + field + "'][@placeholder='" + placeHolder + "']"));
        utils.sendText(By.id("" + field + ""), "" + value + "");
    }

    public void priceRevertsBackWhenClearedEvenAfterSaving(String field, String value, String placeHolder) {
        utils.waitForElementVisible(By.xpath("//input[@id='" + field + "'][@value='" + value + "']"));
        utils.clearText(By.id("" + field + ""));
        utils.checkAlert();
        utils.waitForElementVisible(By.xpath("//input[@id='" + field + "'][@placeholder='" + placeHolder + "']"));
    }

    public void addServicePage_PriceRevertsBackWhenFieldIsEmpty() {
        utils.waitForElementVisible(By.xpath(commonMethods.ADD_XPATH));
     //  utils.clickBtn(By.xpath(commonMethods.ADD_XPATH));
        utils.switchToNewWindow(By.xpath(commonMethods.ADD_XPATH));
        utils.waitForElementVisible(By.id(SERVICECHARGE_CHARGETYPE_DROPDOWN));
        utils.selectByVisibleText(By.id(SERVICECHARGE_CHARGETYPE_DROPDOWN), "Analogue Basic Rental");
        editAndClearPrice(SALES_PRICE_FIELD, "13.0000", "15");
        editAndClearPrice(COST_PRICE_FIELD, "8.6400", "5");
        editAndClearPrice(BASELINE_COST_FIELD, "9.0000", "10");
    }

    public void addServicePage_editPriceAndSaveChanges() {
        utils.waitForElementVisible(By.id(FIRSTPAYMENT_DESC_FIELD));
        utils.clickBtn(By.id(FIRSTPAYMENT_DESC_FIELD));
        today = new java.util.Date().getTime();
        day = Integer.toString(Integer.parseInt(new SimpleDateFormat("dd").format(today)));
        utils.selectDay(By.partialLinkText(day), day);
        utils.waitForElementVisible(By.id(SERVICECHARGE_QUANTITY_FIELD));
        utils.sendText(By.id(SERVICECHARGE_QUANTITY_FIELD), "1");
        utils.waitForElementVisible(By.id(SERVICECHARGE_DESC_FIELD));
        RanServiceChargeName = utils.randomName();
        utils.sendText(By.id(SERVICECHARGE_DESC_FIELD), RanServiceChargeName);
        utils.checkAlert();
        editPriceJustBeforeSaving(SALES_PRICE_FIELD, "13.0000", "15");
        editPriceJustBeforeSaving(COST_PRICE_FIELD, "8.6400", "5");
        editPriceJustBeforeSaving(BASELINE_COST_FIELD, "9.0000", "10");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
    }

    public void addServicePage_assertPriceRevertsBackWhenEmptyEvenAfterSavingChanges() {
        utils.switchToPreviousWindow(1);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanServiceChargeName + "')]"));
       // utils.clickBtn(By.xpath("//a[contains(text(),'" + RanServiceChargeName + "')]"));
        utils.switchToNewWindow(By.xpath("//a[contains(text(),'" + RanServiceChargeName + "')]"));
        priceRevertsBackWhenClearedEvenAfterSaving(SALES_PRICE_FIELD, "15.0000", "13.0000");
        priceRevertsBackWhenClearedEvenAfterSaving(COST_PRICE_FIELD, "5.0000", "8.6400");
        priceRevertsBackWhenClearedEvenAfterSaving(BASELINE_COST_FIELD, "10.0000", "9.0000");
    }
}

