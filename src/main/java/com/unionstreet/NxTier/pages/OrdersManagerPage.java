package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.sql.SQLException;

/**
 * Created by rajeshg on 24/10/2016.
 */
public class OrdersManagerPage {
    private static String QUOTE_RanName;
    public final String QUOTE = "bodyContent";
    public final String ADD_PRODUCT_AND_SERVICE_BUTTON = "//span[text()='Add a product or service']";
    public final String CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE = "//div[text()='customService']";
    public final String INVISIBLE_ORDER_SERVICESID = "//input[@id='Service_ID']";
    private final String CREATEQUOTE_BUTTON = "//a[@href='#'][contains(@onclick,'OpenStartQuote')]";
    //TODO
    private final String ORDER_QUOTE_DESCRIPTION_FIELD = "//input[@class='textfield']";
    private final String ORDERS_SAVEQUOTE_BUTTON = "CreateQuoteButton";
    private final String QUOTEBOX = "StartQuote";
    private final String QUOTEID = "//a[contains(@href,'Orders/EditOrder')]";
    private final String REDCROSS = "//td[@class='red-cross']";
    private final String GREEN_TICK = "//td[@class='green-tick']";
    private final String MANDATORY_CONTROL_FIELD = "//input[@controlid='mandatoryControl']";
    private final String SAVE_AND_SUBMIT_ORDER = "//span[text()='Save & Submit Order']";
    private final String CPONLY = "//label[@class='helpIcon'][contains(text(),'CPonly')]";
    private final String SERVICE_NOT_COMPLETED_MESSAGE = "//div[text()='Services are not completed']";
    private final String ORDER_CONTACT = "Order_order_contact_id";
    private final String AGENT = "//td[text()='agentCompany']";
    private final String RESELLER = "//td[text()='reseller']";
    private final String ADD_VIEW_NOTES = "//span[text()='Add / View Notes']";
    private final String CUSTOMER_RADIOBUTTON = "SendToCustomer";
    private final String INTERNAL_RADIOBUTTON = "SendToInternal";
    private final String CPONLY_CHECKBOX = "Checkbox0";
    private final String SERVICE_INVENTORY_MANAGER = "//a[contains(@href,'ServiceInventoryManager')]";
    private final String AGENT_AND_RESELLER_SERVICE = "//a[text()='ServiceForAgent&Reseller']";
    private final String ASSIGN_SERVICE_INVENTORY = "HrefAssignServiceInventory";
    private final String AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER = "checkbox0";
    private final String AGENT_LINKTEXT = "//a[@href='#'][contains(text(),'agent')]";
    private final String QUOTE_LINKTEST = ".box-title";
    private final String LABEL_WITHIN_A_SERVICE="//label[@for='Service_Details']";

    ElementUtils utils = new ElementUtils();
    ContactManagerPage contactManagerPage = new ContactManagerPage();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    CommonMethods commonMethods = new CommonMethods();
    DashBoardPage dashBoardPage = new DashBoardPage();
    LoginPage loginPage = new LoginPage();
    CompanyMenuPage companyMenuPage = new CompanyMenuPage();
    SettingsPage settingsPage=new SettingsPage();

    public void clickCreateQuoteButton() throws InterruptedException {

      utils.waitForElementVisible(By.xpath(CREATEQUOTE_BUTTON));
        utils.jumpToPopUpWindow(By.xpath(CREATEQUOTE_BUTTON));
    }

    public void onQuotePage() throws InterruptedException {
        utils.clickBtn(By.cssSelector(QUOTE_LINKTEST));
       utils.sendText(By.xpath(ORDER_QUOTE_DESCRIPTION_FIELD),newBusinessCustomerPage.RanName);
        utils.clickBtn(By.cssSelector(QUOTE_LINKTEST));
        utils.selectByVisibleText(By.id("CompanyId"),newBusinessCustomerPage.RanName);
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));

    }

    public void assertQuotePageForAgentandReseller() throws InterruptedException {
        utils.searchAndAssertTextNotPresent(By.id(QUOTEBOX), "Select Owner");
        utils.searchAndAssertTextNotPresent(By.id(QUOTEBOX), "Select Team");
        utils.waitForElementVisible(By.id(ORDERS_SAVEQUOTE_BUTTON));
        utils.jumpToPopUpWindow(By.id(ORDERS_SAVEQUOTE_BUTTON));
        utils.jumpToParentPopUp();
       utils.getOrdersPage();
    }

    public void assertCPQuotePage() {
        utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Order Owner");
        utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Team");
        utils.waitForElementVisible(By.id(ORDERS_SAVEQUOTE_BUTTON));
        utils.jumpToPopUpWindow(By.id(ORDERS_SAVEQUOTE_BUTTON));
        utils.jumpToParentPopUp();
        utils.getOrdersPage();
    }

    public void checkQuotesForAgent() {
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "aBILLity");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.searchAndAssertTextNotPresent(By.id(QUOTE), "aBILLity");
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.searchAndAssertTextNotPresent(By.id(QUOTE), "reseller");
    }

    public void checkQuoteForReseller() {
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "aBILLIty");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.searchAndAssertTextNotPresent(By.id(QUOTE), "aBILLIty");
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.searchAndAssertTextNotPresent(By.id(QUOTE), "agent");
    }

    public void checkQuotesForCP() {
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.assertTheElementAndTextPresent(By.xpath(AGENT), "agentCompany");
        utils.searchAndAssertTextPresent(By.id(QUOTE), "agentCompany");
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.assertTheElementAndTextPresent(By.xpath(RESELLER), "reseller");
        utils.searchAndAssertTextPresent(By.id(QUOTE), "reseller");
    }

    public void assertQuote() {
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), newBusinessCustomerPage.RanName);
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.searchAndAssertTextPresent(By.id(QUOTE), newBusinessCustomerPage.RanName);
    }

    public void assertCompanyIsAccessibleFromCompanyAndSiteDropDown() {
        utils.waitForElementVisible(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY));
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), newBusinessCustomerPage.RanName);
        utils.waitForElementVisible(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE));
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), utils.getProperty("shortName"));
    }

    public void createQuote(String business_customer) throws InterruptedException {
        utils.clickBtn(By.cssSelector(QUOTE_LINKTEST));
        QUOTE_RanName = utils.randomName();
        utils.sendText(By.xpath(ORDER_QUOTE_DESCRIPTION_FIELD), QUOTE_RanName);
        utils.clickBtn(By.cssSelector(QUOTE_LINKTEST));
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), business_customer);
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.clickBtn(By.cssSelector(QUOTE_LINKTEST));
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), business_customer);
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.clickBtn(By.cssSelector(QUOTE_LINKTEST));
        utils.jumpToPopUpWindow(By.id(ORDERS_SAVEQUOTE_BUTTON));
        utils.jumpToParentPopUp();
        utils.getOrdersPage();
    }

    public void searchQuoteByQRN() {
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), QUOTE_RanName);
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
    }

    public void assertAgentCannotViewQuotes() {
        utils.searchAndAssertTextNotPresent(By.id(QUOTE), QUOTE_RanName);
    }

    public void createQuote() throws InterruptedException {

        utils.clickBtn(By.cssSelector(QUOTE_LINKTEST));
        utils.sendText(By.xpath(ORDER_QUOTE_DESCRIPTION_FIELD), newBusinessCustomerPage.RanName);
        utils.clickBtn(By.cssSelector(QUOTE_LINKTEST));
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), newBusinessCustomerPage.RanName);
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.clickBtn(By.cssSelector(QUOTE_LINKTEST));
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), utils.getProperty("shortName"));
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.clickBtn(By.cssSelector(QUOTE_LINKTEST));
        utils.jumpToPopUpWindow(By.id(ORDERS_SAVEQUOTE_BUTTON));
        utils.jumpToParentPopUp();
        utils.getOrdersPage();
    }

    public void searchQuoteByBcRN() {
        utils.waitForElementVisible(By.xpath(CREATEQUOTE_BUTTON));
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), newBusinessCustomerPage.RanName);
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
    }

    public void clickOnQuoteID() {
        utils.clickBtn(By.xpath(QUOTEID));
        utils.switchToNewWindow();
    }

    public void clickAddProductsAndServicesButton() {
        utils.waitForElementVisible(By.xpath(ADD_PRODUCT_AND_SERVICE_BUTTON));
        utils.clickBtn(By.xpath(ADD_PRODUCT_AND_SERVICE_BUTTON));
    }

    public void assertCPonlyValuePresent() {
        utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
        commonMethods.search(utils.getProperty("serviceName_CustomService"));
        utils.waitForElementVisible(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.clickBtn(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath(LABEL_WITHIN_A_SERVICE));
        utils.waitForElementVisible(By.xpath(CPONLY));
    }

    public void assertCPonlyValueNotPresent() {
        utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
        commonMethods.search(utils.getProperty("serviceName_CustomService"));
        utils.waitForElementVisible(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.clickBtn(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath(LABEL_WITHIN_A_SERVICE));
        utils.assertElementNotPresent(By.xpath(CPONLY));
    }

    public void assertInvalidQuoteBeforeSubmitting() {
        utils.waitForElementVisible(By.xpath(REDCROSS));
    }

    public void assertInvalidQuoteAfterSubmitting() {
        utils.selectByIndex(By.id(ORDER_CONTACT), 1);
        utils.clickBtn(By.xpath(SAVE_AND_SUBMIT_ORDER));
        utils.waitForElementVisible(By.xpath(SERVICE_NOT_COMPLETED_MESSAGE));
    }

    public void populateMandatoryField() {
        utils.clickBtn(By.xpath(MANDATORY_CONTROL_FIELD));
        utils.sendText(By.xpath(MANDATORY_CONTROL_FIELD), "hello");
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
        utils.switchToPreviousWindow();
    }

    public void assertValidQuoteBeforeSubmitting() {

        utils.waitForElementVisible(By.xpath(GREEN_TICK));
    }

    public void assertValidQuoteAfterSubmitting() {
        utils.waitForElementVisible(By.xpath(GREEN_TICK));
        utils.selectByIndex(By.id(ORDER_CONTACT), 1);
        utils.clickBtn(By.xpath(SAVE_AND_SUBMIT_ORDER));
    }

    public void savingQuoteAndExtractingOrderServiceID() {
        utils.switchToNewWindow();
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(INVISIBLE_ORDER_SERVICESID));
        utils.getAttributeOfElement(By.xpath(INVISIBLE_ORDER_SERVICESID), "value");
    }

    public String getServiceOrderID() {
        return utils.getAttributeOfElement(By.xpath(INVISIBLE_ORDER_SERVICESID), "value");
    }

    public void accessAdd_ViewNotes() {
        utils.waitForElementVisible(By.xpath(ADD_VIEW_NOTES));
        utils.jumpToPopUpWindow(By.xpath(ADD_VIEW_NOTES));
        utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
    }

    public void assertCustomer_InternalTabsPresent() throws InterruptedException {
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
        utils.waitForElementVisible(By.id(CUSTOMER_RADIOBUTTON));
       utils.clickBtnWithWait(By.id(CUSTOMER_RADIOBUTTON));
        utils.waitForElementVisible(By.id(INTERNAL_RADIOBUTTON));
        utils.clickBtnWithWait(By.id(INTERNAL_RADIOBUTTON));
    }

    public void assertCustomer_InternalTabsNotPresent() {
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
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
        utils.waitForElementVisible(By.xpath(INVISIBLE_ORDER_SERVICESID));
        utils.getAttributeOfElement(By.xpath(INVISIBLE_ORDER_SERVICESID), "value");
    }

    public void assertCPonlyCheckBoxIsAbsent() {
        utils.switchToNewWindow();
        utils.assertElementNotPresent(By.id(CPONLY_CHECKBOX));
        saveTheServiceAndGetTheOrderServicesID();
    }

    public void accessingAssignServicePage() {
        utils.clickBtn(By.xpath(SERVICE_INVENTORY_MANAGER));
        utils.clickBtn(By.xpath(AGENT_AND_RESELLER_SERVICE));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id(ASSIGN_SERVICE_INVENTORY));
        utils.clickBtn(By.id(ASSIGN_SERVICE_INVENTORY));
    }

    public void makeSureAgentDoesNotHaveAgentAndResellerService() {
        utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
        commonMethods.search("agent");
        utils.waitForElementVisible(By.xpath(AGENT_LINKTEXT));
        utils.waitForElementVisible(By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER));
        utils.makeSureBoxIsUnChecked(By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER), By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER));
    }

    public void saveAssignServicePage()  {
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
        utils.switchToParentWindow();
        dashBoardPage.logOut();
    }

    public void makeSureAgentHasAgentAndResellerService() {
        utils.closeCurrentPage();
        utils.switchToParentWindow();
        dashBoardPage.logOut();
        loginPage.loginAsCP();
        companyMenuPage.clickConfigManager();
        accessingAssignServicePage();
        commonMethods.search("agent");
        utils.waitForElementVisible(By.xpath(AGENT_LINKTEXT));
        utils.waitForElementVisible(By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER));
        utils.makeSureBoxIsChecked(By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER), By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER));
    }

    public void assertChargeOnGUI(String charge) {
        utils.waitForElementVisible(By.xpath("//td[@class='totalTotal'][text()='" + charge + "']"));
    }

    public void assertThereIsCharge(String column, double value) throws SQLException {
        utils.result.next();
        double one = utils.result.getDouble(column);
        Assert.assertTrue(one == value);
    }

    public void assertThereIsNoCharge() {
        try {
            Assert.assertFalse(utils.result.next());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
