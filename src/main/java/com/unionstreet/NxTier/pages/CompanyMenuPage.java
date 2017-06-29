package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.text.SimpleDateFormat;

import static com.unionstreet.NxTier.support.BaseClass.driver;

public class CompanyMenuPage {

    public static String RanNumber = RandomStringUtils.randomNumeric(8);
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
    private final String PRICING_DETAILS_PACKAGE_FIELD = "sinfo_package";
    private final String SITEDETAILS_POSTCODE = "PostCode";
    private final String SITEDETAILS_TELEPHONE = "Telephone";
    private final String SITEDETAILS_ACCOUNT_REF = "sage_id";
    private final String SITEDETAILS_BILLING_ADDRESS = "InvoiceAddress";
    private final String COMPANYSITES_BUTTON = "HrefCompanySites";
    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods = new CommonMethods();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    ConfigManagerPage configManagerPage=new ConfigManagerPage();
    CreateTariffPage createTariffPage=new CreateTariffPage();
    private long today;
    private String day;

    public void addNewSite() throws InterruptedException {
        accessCompanyMenu(NewBusinessCustomerPage.RanName);
        clickCompanySitesButton();
        utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow();
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
        utils.clickBtn(By.linkText(ranName));
        utils.switchToNewWindow();
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
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        try {
            utils.waitForElementVisible(By.id(CLI_NUMBER_FIELD));
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
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
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
        utils.selectByIndex(By.id(PRICING_DETAILS_PACKAGE_FIELD), 1);
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
        utils.switchToNewWindow();
        clickPricingDetails();
        utils.waitForElementVisible(By.id("EnableFreeminutes"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.id("EnableFreeminutes"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+configManagerPage.RanFreeMinutePlanName+"')]"));
        utils.searchAndAssertTextPresent(By.id("fmSiteTable"), ""+configManagerPage.RanFreeMinutePlanName+"");
        utils.selectByVisibleText(By.id("sinfo_LCR_Tariff"),createTariffPage.RanTariffPlanName);
    }
    public void assignTariffAndFreeMinutesToCustomer(String FreeMinutePlan,String TariffPlan) throws InterruptedException {
        utils.waitForElementVisible(By.id("EnableFreeminutes"));
        Thread.sleep(1000);
        utils.makeSureBoxIsChecked(By.id("EnableFreeminutes"),By.id("EnableFreeminutes"));
        utils.waitForElementVisible(By.xpath(" //table[@id='fmSiteTable']//td[contains(text(),'"+FreeMinutePlan+"')]"));
       Thread.sleep(1000);
        utils.makeSureBoxIsChecked(By.id("fmSelection13_isSelected"),By.id("fmSelection13_isSelected"));
        utils.waitForElementVisible(By.id("sinfo_LCR_Tariff"));
        utils.selectByVisibleText(By.id("sinfo_LCR_Tariff"),TariffPlan);
        utils.selectByVisibleText(By.id("sinfo_Data_Tariff"),TariffPlan);
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);
    }
    public void assertCPAssignedTariffAndFreeMinutes(String tariffVoiceField, String tariffDataField, String tariffPlan, String freeMinutePlan){
        utils.waitForElementVisible(By.xpath("//select[@id='"+tariffVoiceField+"']//option[@selected='selected'][contains(text(),'"+tariffPlan+"')]"));
        utils.waitForElementVisible(By.xpath("//select[@id='"+tariffDataField+"']//option[@selected='selected'][contains(text(),'"+tariffPlan+"')]"));
        utils.waitForElementVisible(By.xpath("//table[@id='fmSiteTable']//td[contains(text(),'"+freeMinutePlan+"')]/..//input[@checked='checked']"));
    }
    public void removeCPAssignedTariffAndFreeMinutes() throws InterruptedException {
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.id("EnableFreeminutes"));
        utils.selectByVisibleText(By.id("sinfo_LCR_Tariff"),"Select");
        utils.selectByVisibleText(By.id("sinfo_Data_Tariff"),"Select");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
    }
    public void assertAgentCannotSeeCPAssignedTariffAndFreeMinutes(String tariffPlan, String freeMinutePlan) throws InterruptedException {
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.id("EnableFreeminutes"));
        utils.assertElementNotPresent(By.xpath("//select[@id='sinfo_LCR_Tariff']//option[contains(text(),'"+tariffPlan+"')]"));
        utils.assertElementNotPresent(By.xpath("//select[@id='sinfo_Data_Tariff']//option[contains(text(),'"+tariffPlan+"')]"));
        utils.assertElementNotPresent(By.xpath("//table[@id='GroupTable']//tr[contains(text(),'"+freeMinutePlan+"')]"));
    }
    public void assertAgentCanOnlySeeAndAssignTariffAndFreeMinutePlansThatCPHasGivenPermissionFor(String tariffPlan, String unavailableTariffPlan) throws InterruptedException {
        utils.selectByVisibleText(By.id("sinfo_LCR_Tariff"),tariffPlan);
        utils.selectByVisibleText(By.id("sinfo_Data_Tariff"),tariffPlan);
        utils.assertElementNotPresent(By.xpath("//select[@id='sinfo_LCR_Tariff']//option[contains(text(),'"+unavailableTariffPlan+"')]"));
      //  Thread.sleep(1000);
      //  utils.makeSureBoxIsChecked(By.id("SelectFreeMins_2"),By.id("SelectFreeMins_2"));
    }
    public void assignOrDeletePackageToCustomer(String packageName){
        utils.waitForElementVisible(By.id("sinfo_package"));
        utils.selectByVisibleText(By.id("sinfo_package"),""+packageName+"");
        utils.waitForElementVisible(By.xpath("//input[contains(@onclick,'SaveAndClose')]"));
        utils.clickBtn(By.xpath("//input[contains(@onclick,'SaveAndClose')]"));
        utils.switchToPreviousWindow(0);

    }
    public void assertAgentCannotRe_AssignDeletedCustomerPackageUnlessItsAssignedToHim(String unavailablePackage, String availablePackage){
        utils.waitForElementVisible(By.id("sinfo_package"));
        utils.assertElementNotPresent(By.xpath("//select[@id='sinfo_package']//option[contains(text(),'"+unavailablePackage+"')]"));
        utils.waitForElementVisible(By.xpath("//select[@id='sinfo_package']//option[contains(text(),'"+availablePackage+"')]"));
    }
    public void selectingPackageFromDropDown(String packageName){
        utils.waitForElementVisible(By.id("sinfo_package"));
        utils.selectByVisibleText(By.id("sinfo_package"),packageName);
    }
    public void validatePricingDetailsPage_assertCheckedTariffsAndInitialSaveWithFreeMinutePackageAssertions() throws InterruptedException {
        utils.waitTillBoxChecked(By.id("IsVoiceTariffFromPackage"));
        utils.waitTillBoxChecked(By.id("IsDataTariffFromPackage"));
        utils.waitTillBoxChecked(By.id("IsMobileTariffFromPackage"));
        utils.waitTillBoxChecked(By.id("IsSCTariffFromPackage"));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitTillBoxChecked(By.id("EnableFreeminutes"));
        utils.waitTillBoxChecked(By.id("chkFreeminsfromPackage"));}

    public void validatePricingDetailsPage_unCheckPackageFreeMinutesAndAddNativeFreeMinutes() throws InterruptedException {
        utils.makeSureBoxIsUnChecked(By.id("chkFreeminsfromPackage"), By.id("chkFreeminsfromPackage"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'Voice - 500 UK Loc & Nat')]"));
        utils.makeSureBoxIsChecked(By.xpath("//table[@id='fmSiteTable']//tr/td[contains(text(),'Voice - 500 UK Loc & Nat')]/following-sibling::td/label"), By.xpath("//table[@id='fmSiteTable']//tr/td[contains(text(),'Voice - 500 UK Loc & Nat')]/following-sibling::td/label"));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath("//table[@id='fmSiteTable']//tr/td[contains(text(),'Voice - 500 UK Loc & Nat')]/following-sibling::td/input[@checked='checked']"));
    }
public void validatePricingDetailsPage_assertTariffDropDownCannotBeUnselectedWhenOnPackage(){

        utils.makeSureBoxIsChecked(By.id("chkFreeminsfromPackage"),By.id("chkFreeminsfromPackage"));
        utils.waitForElementVisible(By.xpath("//div[@id='packageFMList']//td[contains(text(),'Mobile Gamma Sharer 2000')]"));
        utils.makeSureBoxIsUnChecked(By.id("IsVoiceTariffFromPackage"),By.id("IsVoiceTariffFromPackage"));
        utils.waitForElementVisible(By.xpath("//select[@id='sinfo_LCR_Tariff']//option[contains(text(),'Select')]"));
        utils.assertUnchecked(By.id("IsVoiceTariffFromPackage"));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitTillBoxChecked(By.id("IsVoiceTariffFromPackage"));}
public void validatePricingDetailsPage_selectingNativeTariffFromDropDown(){
        utils.makeSureBoxIsUnChecked(By.id("IsVoiceTariffFromPackage"),By.id("IsVoiceTariffFromPackage"));
        utils.selectByVisibleText(By.id("sinfo_LCR_Tariff"),"Sell Data Tariff");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath("//select[@id='sinfo_LCR_Tariff']//option[@selected='selected'][contains(text(),'Sell Data Tariff')]"));
       utils.assertElementNotPresent(By.xpath("//select[@id='sinfo_LCR_Tariff']//option[contains(text(),'Buy')]"));
        utils.clickBtn(By.id("imgViewVoiceTariff"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Tariff Name : Sell Data Tariff')]"));







    }}

