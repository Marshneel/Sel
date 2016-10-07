package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;


public class DashBoardPage {
    private static String QUOTE_RanName;
    public final String DASHBOARD_TITLE = "menutitle";
    //TODO
    public final String LOGOUT_BUTTON = ".logout";
    private final String ORDERQUOTE_DESCRIPTION_FIELD = "QuoteDescription";
    private final String ORDERS_SAVEQUOTE_BUTTON = "CreateQuoteButton";
    private final String ORDERSMANAGER_BUTTON = "HrefOrdersManager";
    private final String CREATEQUOTE_BUTTON = ".add";
    public final String QUOTE = "bodyContent";
    private final String QUOTEBOX = "StartQuote";
    private final String QUOTENUMBER = "//div[@class='quote__order-number']";
    private final String QUOTEID = "//a[contains(@href,'Orders/EditOrder')]";
    private final String ADDPRODUCTANDSERVICEBUTTON = "//span[text()='Add a product or service']";
    private final String CUSTOMSERVICEONADDSERVICEPAGE = "//div[text()='customService']";
    private final String REDCROSS = "//td[@class='red-cross']";
    private final String GREENTICK = "//td[@class='green-tick']";
    private final String MANDATORYCONTROLFIELD = "//input[@controlid='mandatoryControl']";
    private final String SAVEANDSUBMITORDER = "//span[text()='Save & Submit Order']";
    private final String CPONLY = "//label[@class='helpIcon'][contains(text(),'CPonly')]";
    private final String SERVICENOTCOMPLETEDMESSAGE = "//div[text()='Services are not completed']";
    private final String PAGEERRORMESSAGE = "//div[@class='error_msg_invalid']";
    private final String SERVICEONQUOTEPAGE = "//a[text()='customService']";
    private final String ORDERCONTACT = "Order_order_contact_id";
    private final String AGENT = "//td[text()='agent']";
    private final String RESELLER = "//td[text()='reseller']";
    private final String CLOSE_BUTTON = ".close";
    private final String SERVICECHARGES_CHECKBOX = "Checkbox0";
    private final String INVISIBLEORDERSERVICESID = "//input[@id='Service_ID']";
    private final String ADD_VIEW_NOTES = "//span[text()='Add / View Notes']";
    private final String CUSTOMER_RADIOBUTTON = "SendToCustomer";
    private final String INTERNAL_RADIOBUTTON = "SendToInternal";
    private final String CPONLY_CHECKBOX = "Checkbox2";
    private final String SERVICEINVENTORY_MANAGER = "//a[contains(@href,'ServiceInventoryManager')]";
    private final String AGENTANDRESELLER_SERVICE = "//a[text()='ServiceForAgent&Reseller']";
    private final String ASSIGNSERVICEINVENTORY = "HrefAssignServiceInventory";
    private final String AGENTCHECKBOX_SERVICEFORAGENTANDRESELLER = "checkbox4";
    public String id;


    ElementUtils utils = new ElementUtils();
    ContactManagerPage contactManagerPage = new ContactManagerPage();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    CommonMethods commonMethods = new CommonMethods();
    LoginPage loginPage = new LoginPage();
    CompanyMenuPage companyMenuPage = new CompanyMenuPage();

    public void assertLogin() throws InterruptedException {
        utils.verifyStringMatch(By.id(DASHBOARD_TITLE), "DASHBOARD");
    }

    public void logOut() {
        utils.clickBtn(By.cssSelector(LOGOUT_BUTTON));
    }

    public void clickOrderManagerButton() {
        utils.clickBtn(By.id(ORDERSMANAGER_BUTTON));
        utils.waitForElementVisible(By.cssSelector(CREATEQUOTE_BUTTON));
    }

    public void clickCreateQuoteButton() {
        utils.jumpToPopUpWindow(By.cssSelector(CREATEQUOTE_BUTTON));
    }

    public void onQuotePage() {
        try {
            utils.clickBtn(By.id(ORDERQUOTE_DESCRIPTION_FIELD));
            QUOTE_RanName = utils.randomName();
            utils.sendText(By.id(ORDERQUOTE_DESCRIPTION_FIELD), QUOTE_RanName);
            utils.selectByIndex(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), 1);
        } catch (Exception e) {
        }
    }

    public void assertQuotePageForAgentandReseller() {
        try {
            utils.searchAndAssertTextNotPresent(By.id(QUOTEBOX), "Select Owner");
            utils.searchAndAssertTextNotPresent(By.id(QUOTEBOX), "Select Team");
            utils.jumpToPopUpWindow(By.id(ORDERS_SAVEQUOTE_BUTTON));
            utils.refreshCurrentURL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assertCPQuotePage() throws InterruptedException {
        try {
            utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Order Owner");
            utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Team");
            utils.jumpToPopUpWindow(By.id(ORDERS_SAVEQUOTE_BUTTON));
            utils.refreshCurrentURL();
        } catch (Exception e) {
        }
    }

    public void checkQuotesForAgent() throws InterruptedException {
        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "aBILLity");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.searchAndAssertTextNotPresent(By.id(QUOTE), "aBILLity");
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.searchAndAssertTextNotPresent(By.id(QUOTE), "reseller");
        } catch (Exception e) {
        }
    }

    public void checkQuoteForReseller() {
        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "aBILLIty");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.searchAndAssertTextNotPresent(By.id(QUOTE), "aBILLIty");
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.searchAndAssertTextNotPresent(By.id(QUOTE), "agent");
        } catch (Exception e) {
        }
    }

    public void checkQuotesForCP() throws InterruptedException {
        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.assertTheElementAndTextPresent(By.xpath(AGENT), "agent");
            utils.searchAndAssertTextPresent(By.id(QUOTE), "agent");
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.assertTheElementAndTextPresent(By.xpath(RESELLER), "reseller");
            utils.searchAndAssertTextPresent(By.id(QUOTE), "reseller");
        } catch (Exception e) {
        }
    }

    public void assertQuote() throws InterruptedException {

        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), QUOTE_RanName);
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.searchAndAssertTextPresent(By.id(QUOTE), QUOTE_RanName);
        } catch (Exception e) {
        }
    }

    public void assertCompanyIsAccessibleFromCompanyAndSiteDropDown() throws InterruptedException {
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), newBusinessCustomerPage.RanName);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), utils.getProperty("shortName"));
    }

    public void createQuote(String business_customer) throws InterruptedException {
        utils.clickBtn(By.id(ORDERQUOTE_DESCRIPTION_FIELD));
        QUOTE_RanName = utils.randomName();
        utils.sendText(By.id(ORDERQUOTE_DESCRIPTION_FIELD), QUOTE_RanName);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), business_customer);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), business_customer);
        utils.waitForElementVisible(By.id(ORDERS_SAVEQUOTE_BUTTON));
        utils.clickBtn(By.id(ORDERS_SAVEQUOTE_BUTTON));
        utils.refreshCurrentURL();
    }

    public void searchQuoteByQRN() throws InterruptedException {
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), QUOTE_RanName);
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.searchAndAssertTextPresent(By.id(QUOTE), QUOTE_RanName);
    }

    public void assertAgentCanViewAndEditQuotes() throws InterruptedException {
        utils.searchAndAssertTextPresent(By.id(QUOTE), QUOTE_RanName);
        utils.clickBtn(By.xpath(QUOTEID));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath(QUOTENUMBER));
    }

    public void createQuote() throws InterruptedException {
        utils.clickBtn(By.id(ORDERQUOTE_DESCRIPTION_FIELD));
        utils.sendText(By.id(ORDERQUOTE_DESCRIPTION_FIELD), newBusinessCustomerPage.RanName);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), newBusinessCustomerPage.RanName);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), utils.getProperty("shortName"));
        utils.clickBtn(By.id(ORDERS_SAVEQUOTE_BUTTON));
        utils.refreshCurrentURL();
    }

    public void searchQuoteByBcRN() {
        utils.waitForElementVisible(By.cssSelector(CREATEQUOTE_BUTTON));
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), newBusinessCustomerPage.RanName);
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
    }

    public void clickOnQuoteID() {
        utils.clickBtn(By.xpath(QUOTEID));
        utils.switchToNewWindow();
    }

    public void clickAddProductsAndServicesButton() {
        utils.clickBtn(By.xpath(ADDPRODUCTANDSERVICEBUTTON));

    }

    public void assertCPonlyValuePresent() throws InterruptedException {
        commonMethods.search(utils.getProperty("serviceName_CustomService"));
        utils.clickBtn(By.xpath(CUSTOMSERVICEONADDSERVICEPAGE));
        utils.switchToNewWindow();
        utils.searchAndAssertTextPresent(By.xpath(CPONLY), "CPonly");
    }

    public void assertCPonlyValueNotPresent() throws InterruptedException {
        commonMethods.search(utils.getProperty("serviceName_CustomService"));
        utils.clickBtn(By.xpath(CUSTOMSERVICEONADDSERVICEPAGE));
        utils.switchToNewWindow();
        utils.assertElementNotPresent(By.xpath(CPONLY));
    }

    public void searchAndSelectService() {
        commonMethods.search(utils.getProperty("serviceName_CustomService"));
        utils.clickBtn(By.xpath(CUSTOMSERVICEONADDSERVICEPAGE));
        utils.switchToNewWindow();
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToParentWindow();
    }

    public void assertInvalidQuoteBeforeSubmitting() {
        utils.waitForElementVisible(By.xpath(REDCROSS));
    }

    public void assertInvalidQuoteAfterSubmitting() {
        utils.selectByIndex(By.id(ORDERCONTACT), 1);
        utils.clickBtn(By.xpath(SAVEANDSUBMITORDER));
        utils.waitForElementVisible(By.xpath(SERVICENOTCOMPLETEDMESSAGE));
    }

    public void clickService() {
        utils.clickBtn(By.xpath(SERVICEONQUOTEPAGE));
        utils.switchToNewWindow();
    }

    public void populateMandatoryField() {
        utils.clickBtn(By.xpath(MANDATORYCONTROLFIELD));
        utils.sendText(By.xpath(MANDATORYCONTROLFIELD), "hello");
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(CLOSE_BUTTON));
        utils.switchToParentWindow();
    }

    public void assertValidQuoteBeforeSubmitting() {
        utils.waitForElementVisible(By.xpath(GREENTICK));
    }

    public void assertValidQuoteAfterSubmitting() {
        utils.selectByIndex(By.id(ORDERCONTACT), 1);
        utils.clickBtn(By.xpath(SAVEANDSUBMITORDER));
        utils.waitForElementVisible(By.xpath(PAGEERRORMESSAGE));
    }

    public void addServiceToQuote(String serviceName) {
        utils.jumpToPopUpWindow(By.xpath(ADDPRODUCTANDSERVICEBUTTON));
        utils.clickBtn(By.xpath("//div[text()='" + serviceName + "']"));


    }

    public void clickAddAProductOrService() {
        utils.jumpToPopUpWindow(By.xpath(ADDPRODUCTANDSERVICEBUTTON));
    }

    public void savingQuoteAndExtractingOrderServiceID() {
        utils.switchToNewWindow();
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(INVISIBLEORDERSERVICESID));
        utils.getAttributeOfElement(By.xpath(INVISIBLEORDERSERVICESID), "value");
    }

    public void addingChargeOnTheQuote(String serviceName) throws InterruptedException {
        utils.jumpToPopUpWindow(By.xpath(ADDPRODUCTANDSERVICEBUTTON));
        utils.clickBtn(By.xpath("//div[text()='" + serviceName + "']"));
        utils.switchToNewWindow();
        utils.javaScriptExecutorClick(By.id(SERVICECHARGES_CHECKBOX));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(INVISIBLEORDERSERVICESID));
        utils.getAttributeOfElement(By.xpath(INVISIBLEORDERSERVICESID), "value");
    }

    public void removingChargeOnTheQuote() throws InterruptedException {
        utils.javaScriptExecutorClick(By.id(SERVICECHARGES_CHECKBOX));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
    }

    public void accessAdd_ViewNotes() {
        utils.waitForElementVisible(By.xpath(ADD_VIEW_NOTES));
        utils.jumpToPopUpWindow(By.xpath(ADD_VIEW_NOTES));
        utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
    }

    public void assertCustomer_InternalTabsPresent() {
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.waitForElementVisible(By.id(CUSTOMER_RADIOBUTTON));
        utils.clickBtn(By.id(CUSTOMER_RADIOBUTTON));
        utils.waitForElementVisible(By.id(INTERNAL_RADIOBUTTON));
        utils.clickBtn(By.id(INTERNAL_RADIOBUTTON));
    }

    public void assertCustomer_InternalTabsNotPresent() {
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.assertElementNotPresent(By.id(CUSTOMER_RADIOBUTTON));
        utils.assertElementNotPresent(By.id(INTERNAL_RADIOBUTTON));
    }

    public void assertCPonlyCheckBoxPresentAndAccessible() {
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id(CPONLY_CHECKBOX));
        utils.javaScriptExecutorClick(By.id(CPONLY_CHECKBOX));
    }

    public void saveTheServiceAndGetTheOrderServicesID() {
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(INVISIBLEORDERSERVICESID));
        utils.getAttributeOfElement(By.xpath(INVISIBLEORDERSERVICESID), "value");
    }

    public void assertCPonlyCheckBoxIsAbsent() {
        utils.switchToNewWindow();
        utils.assertElementNotPresent(By.id(CPONLY_CHECKBOX));
        saveTheServiceAndGetTheOrderServicesID();
    }

    public void assertServiceNotPresent(String serviceName) {
        utils.assertElementNotPresent(By.xpath("//div[text()='" + serviceName + "']"));
    }

    public void assertServicePresent(String serviceName) {
        utils.waitForElementVisible(By.xpath("//div[text()='" + serviceName + "']"));
    }

    public void accessingAssignServicePage() {
        utils.clickBtn(By.xpath(SERVICEINVENTORY_MANAGER));
        utils.clickBtn(By.xpath(AGENTANDRESELLER_SERVICE));
        utils.switchToNewWindow();
        utils.clickBtn(By.id(ASSIGNSERVICEINVENTORY));
    }

    public void makeSureAgentDoesNotHaveAgentAndResellerService() {
        utils.waitForElementVisible(By.id(AGENTCHECKBOX_SERVICEFORAGENTANDRESELLER));
        utils.makeSureBoxIsUnChecked(By.id(AGENTCHECKBOX_SERVICEFORAGENTANDRESELLER), By.id(AGENTCHECKBOX_SERVICEFORAGENTANDRESELLER));
    }

    public void saveAssignServicePage() {
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToParentWindow();
        logOut();
    }

    public void makeSureAgentHasAgentAndResellerService() {
        utils.closeCurrentPage();
        utils.switchToParentWindow();
        logOut();
        loginPage.loginAsCP();
        companyMenuPage.clickConfigManager();
        accessingAssignServicePage();
        utils.waitForElementVisible(By.id(AGENTCHECKBOX_SERVICEFORAGENTANDRESELLER));
        utils.makeSureBoxIsChecked(By.id(AGENTCHECKBOX_SERVICEFORAGENTANDRESELLER), By.id(AGENTCHECKBOX_SERVICEFORAGENTANDRESELLER));
    }
}



