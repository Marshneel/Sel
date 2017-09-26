package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

import java.sql.SQLException;

/**
 * Created by rajeshg on 24/10/2016.
 */
public class OrdersManagerPage {

    public static String QUOTE_RanName;

    public final String QUOTE = "bodyContent";
    public final String INVISIBLE_ORDER_SERVICESID = "//input[@id='Service_ID']";
    private final String CREATEQUOTE_BUTTON = "//a[contains(@onclick,'OpenStartQuote')]";
    //TODO
    private final String ORDER_QUOTE_DESCRIPTION_FIELD = "QuoteDescription";
    private final String ORDERS_SAVEQUOTE_BUTTON = "CreateQuoteButton";
    private final String QUOTEBOX = "StartQuote";
    private final String AGENT = "//div[@id='contentPanel']//td[contains(text(),'agentCompany')]";
    private final String RESELLER = "//div[@id='contentPanel']//td[contains(text(),'reseller')]";
    private final String AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER = "checkbox0";
    private final String LOCATOR_FOR_BOX_HEADER = "contentPanel";
    private final String ORDER_TASK = "//div[@id='tasksContentPanel']//a[contains(@onclick,'return TaskPopup')]";
    private final String DONE_CHECKBOX = "//label[text()='Done']";
    private final String SUBMIT_DONE = DONE_CHECKBOX;
    private final String CEASE_REASON = "UnsolicitedCeaseDetail_CancelReason";
    public final String TASK_POPUP = "//div[@id='tasksContentPanel']//a[contains(@onclick,'return TaskPopup')]";
    public final String ORDERID_UNDER_TASK = "//div[@id='tasksContentPanel']//a[contains(@href,'nxtiere2e/Orders/EditOrder')]";
    public final String CLICK_ON_THE_ORDER_FROM_LIST="//a[contains(@href,'Orders/EditOrder')]";
    private final String SAVE = "saveBtn";
    private final String AGENT_TEXT="//a[@href='#'][contains(text(),'agent')]";
    private final String NO_SEARCH_RECORDS="//div[@id='orderContentPanel']//td[contains(text(),'No Records')]";

    ElementUtils utils = new ElementUtils();
    WLR_and_NxTierServicesPage wlr_and_nxTierServicesPage = new WLR_and_NxTierServicesPage();

    ContactManagerPage contactManagerPage = new ContactManagerPage();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    CommonMethods commonMethods = new CommonMethods();
    DashBoardPage dashBoardPage = new DashBoardPage();
    LoginPage loginPage = new LoginPage();
    SettingsPage settingsPage = new SettingsPage();

    public void clickCreateQuoteButton() throws InterruptedException {

        try {
          //  utils.waitForElementVisible(By.xpath(CREATEQUOTE_BUTTON));
           Thread.sleep(1000);
            utils.jumpToPopUpWindow(By.xpath(CREATEQUOTE_BUTTON));
        } catch (Exception e) {
            utils.getOrdersPage();
        //    utils.waitForElementVisible(By.xpath(CREATEQUOTE_BUTTON));
            Thread.sleep(1000);
            utils.jumpToPopUpWindow(By.xpath(CREATEQUOTE_BUTTON));
        }
    }

    public void onQuotePage() throws InterruptedException {
        utils.sendText(By.id(ORDER_QUOTE_DESCRIPTION_FIELD), newBusinessCustomerPage.RanName);
        utils.selectByVisibleText(By.id("CompanyId"), newBusinessCustomerPage.RanName);
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
    }

    public void onQuotePageForReseller() throws InterruptedException {
        newBusinessCustomerPage.Reseller_RanName = utils.randomName();
        utils.sendText(By.id(ORDER_QUOTE_DESCRIPTION_FIELD), newBusinessCustomerPage.Reseller_RanName);
        utils.selectByVisibleText(By.id("CompanyId"), "reseller");
        utils.selectByVisibleText(By.id("SiteId"), "reseller");
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
    }

    public void assertQuotePageForAgentandReseller() throws InterruptedException {
        utils.searchAndAssertTextNotPresent(By.id(QUOTEBOX), "Select Owner");
        utils.searchAndAssertTextNotPresent(By.id(QUOTEBOX), "Select Team");
       // utils.waitForElementVisible(By.id(ORDERS_SAVEQUOTE_BUTTON));
        Thread.sleep(1000);
        utils.navigateToEditOrderPopupAndClose(By.id(ORDERS_SAVEQUOTE_BUTTON));
    }

    public void assertCPQuotePage() throws InterruptedException {
        utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Order Owner");
        utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Team");
       // utils.waitForElementVisible(By.id(ORDERS_SAVEQUOTE_BUTTON));
        Thread.sleep(1000);
        utils.navigateToEditOrderPopupAndClose(By.id(ORDERS_SAVEQUOTE_BUTTON));
    }

    public void checkQuotesForAgent() throws InterruptedException {
        utils.waitForElementVisible(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "aBILLity");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementVisible(By.xpath(NO_SEARCH_RECORDS));
        utils.waitForElementVisible(By.xpath("//div[@id='pageLoader'][@class='page-loader']"));
        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath("//div[@id='pageLoader'][@class='page-loader']"));
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
        }
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementVisible(By.xpath(NO_SEARCH_RECORDS));
    }

    public void checkQuoteForReseller() throws InterruptedException {
      //  utils.waitForElementVisible(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "aBILLity");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementVisible(By.xpath(NO_SEARCH_RECORDS));
        utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
        Thread.sleep(1000);
        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
        } catch (Exception e) {
          //  utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
            Thread.sleep(2000);
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
        }
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.waitForElementVisible(By.xpath(NO_SEARCH_RECORDS));
    }

    public void checkQuotesForCP() throws InterruptedException {

       // utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementVisible(By.xpath(AGENT));
        utils.getOrdersPage();
     //   utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
        Thread.sleep(1000);
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementVisible(By.xpath(RESELLER));
    }


    public void assertQuote() {
        utils.getOrdersPage();
        utils.searchAndAssertTextPresent(By.id(QUOTE), newBusinessCustomerPage.RanName);
    }

    public void assertQuoteForReseller() {
        utils.getOrdersPage();
        utils.searchAndAssertTextPresent(By.id(QUOTE), newBusinessCustomerPage.Reseller_RanName);
    }

    public void assertCompanyIsAccessibleFromCompanyAndSiteDropDown() {
        utils.waitForElementVisible(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY));
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), newBusinessCustomerPage.RanName);
        utils.waitForElementVisible(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE));
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), utils.getProperty("shortName"));
    }

    public void createQuote(String business_customer) throws InterruptedException {
        QUOTE_RanName = utils.randomName();
        utils.sendText(By.id(ORDER_QUOTE_DESCRIPTION_FIELD), QUOTE_RanName);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), business_customer);
        Thread.sleep(1000);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), business_customer);
        Thread.sleep(1000);
        utils.navigateToEditOrderPopupAndClose(By.id(ORDERS_SAVEQUOTE_BUTTON));
        utils.getOrdersPage();
    }

    public void createQuoteForReseller() throws InterruptedException {
        utils.sendText(By.id(ORDER_QUOTE_DESCRIPTION_FIELD), newBusinessCustomerPage.Reseller_RanName);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), "reseller");
        Thread.sleep(1000);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), newBusinessCustomerPage.Reseller_RanName);
        Thread.sleep(1000);
        utils.navigateToEditOrderPopupAndClose(By.id(ORDERS_SAVEQUOTE_BUTTON));
    }

    public void searchQuoteByQRN() {
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), QUOTE_RanName);
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
    }

    public void assertAgentCanViewQuotes() {
        utils.searchAndAssertTextPresent(By.id(QUOTE), QUOTE_RanName);
    }

    public void createQuote() throws InterruptedException {
        utils.sendText(By.id(ORDER_QUOTE_DESCRIPTION_FIELD), newBusinessCustomerPage.RanName);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), newBusinessCustomerPage.RanName);
        Thread.sleep(1000);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), utils.getProperty("shortName"));
        Thread.sleep(1000);
        utils.navigateToEditOrderPopupAndClose(By.id(ORDERS_SAVEQUOTE_BUTTON));
    }

    public void searchQuoteByBcRN(String businessCustomer) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//td[text()='" + businessCustomer + "']"));
    }

    public void clickOnQuoteID(String type) throws SQLException {
        utils.sqlQuery("Portal", "test01-sql01", "nxtiere2e", "select order_id from orders where OrderDescription ='" + type + "'");
        utils.result.next();
        String one = utils.result.getString("order_id");
       try{ utils.waitForElementVisible(By.xpath("//a[text()='" + one + "']"));
           utils.clickBtn(By.xpath("//a[text()='" + one + "']"));
        utils.switchToNewWindow();}
       catch (Exception e){utils.checkAlert();}
    }

    public void loadOrdersManagerAndClickOnQuoteID(String type) throws InterruptedException, SQLException {
        try {
           // utils.switchToPreviousWindow(0);
            clickOnQuoteID(type);
        } catch (Exception e) {
            utils.getOrdersPage();
            clickOnQuoteID(type);

        }
    }
    public void savingQuoteAndExtractingOrderServiceID() throws InterruptedException {

        try {
            utils.clickBtn(By.xpath(commonMethods.SAVE_XPATH));
        } catch (Exception e) {
            utils.checkAlert();
        }
        utils.waitForElementVisible(By.xpath(INVISIBLE_ORDER_SERVICESID));
        utils.getAttributeOfElement(By.xpath(INVISIBLE_ORDER_SERVICESID), "value");
    }

    public String getServiceOrderID() {
        return utils.getAttributeOfElement(By.xpath(INVISIBLE_ORDER_SERVICESID), "value");
    }

    public void saveTheServiceAndGetTheOrderServicesID() {
        utils.clickBtn(By.xpath(commonMethods.SAVE_XPATH));
        utils.waitForElementVisible(By.xpath(INVISIBLE_ORDER_SERVICESID));
        utils.getAttributeOfElement(By.xpath(INVISIBLE_ORDER_SERVICESID), "value");
    }

    public void makeSureAgentDoesNotHaveAgentAndResellerService() throws InterruptedException {
        utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
        commonMethods.search("agent");
        utils.waitForElementVisible(By.id(LOCATOR_FOR_BOX_HEADER));
        utils.waitForElementVisible(By.xpath(AGENT_TEXT));
        utils.waitForElementVisible(By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER));
        try {
            utils.makeSureBoxIsUnChecked(By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER), By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER));
        } catch (Exception e) {
            utils.makeSureBoxIsUnChecked(By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER), By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER));
        }
    }

    public void saveAssignServicePage() throws InterruptedException {
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        dashBoardPage.logOut();
    }

    public void makeSureAgentHasAgentAndResellerService() throws InterruptedException {
        utils.closeCurrentPage();
        utils.switchToParentWindow();
        dashBoardPage.logOut();
        loginPage.doLogin();
        dashBoardPage.clickConfigManager();
        wlr_and_nxTierServicesPage.accessingAssignServicePage();
        commonMethods.search("agent");
        utils.waitForElementVisible(By.xpath(AGENT_TEXT));
        utils.waitForElementVisible(By.id(LOCATOR_FOR_BOX_HEADER));
        utils.waitForElementVisible(By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER));
        utils.makeSureBoxIsChecked(By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER), By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER));
    }

    public void clickDone() {
        utils.getOrdersPage();
       // utils.waitForElementVisible(By.xpath(ORDER_TASK));
        utils.returnElement(By.xpath(ORDER_TASK)).click();
      //  utils.waitForElementVisible(By.xpath(DONE_CHECKBOX));
        utils.returnElement(By.xpath(DONE_CHECKBOX)).click();
        utils.clickBtn(By.xpath(SUBMIT_DONE));
    }

    public void processCease(String company, String CLI) {
        utils.getOrdersPage();
        utils.waitForElementVisible(By.xpath(TASK_POPUP));
        utils.clickBtn(By.xpath(ORDERID_UNDER_TASK));
        utils.switchToNewWindow();
      //  utils.waitForElementVisible(By.xpath("//a[text()='" + company + "']"));
                     utils.returnElement(By.xpath("//a[text()='" + company + "']")).click();
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'" + CLI + "')]"));
        utils.selectByIndex(By.id(CEASE_REASON), 1);
        utils.clickBtn(By.id(SAVE));
    }

    public void proofOfProcessedOrder(String order) {
        utils.getOrdersPage();
        utils.waitForElementVisible(By.xpath("//div[@id='tasksContentPanel']//td[contains(text(),'" + order + "')]"));
        utils.waitForElementVisible(By.xpath("//div[@id='tasksContentPanel']//td[contains(text(),'" + newBusinessCustomerPage.RanName + "')]"));
    }
    public void clickOnQuote(){
      try{  //utils.waitForElementVisible(By.xpath(CLICK_ON_THE_ORDER_FROM_LIST));
        utils.returnElement(By.xpath(CLICK_ON_THE_ORDER_FROM_LIST)).click();
      utils.switchToNewWindow();}
      catch (Exception e){utils.getOrdersPage();
          //utils.waitForElementVisible(By.xpath(CLICK_ON_THE_ORDER_FROM_LIST));
          utils.returnElement(By.xpath(CLICK_ON_THE_ORDER_FROM_LIST)).click();
          utils.switchToNewWindow();
      }
    }
}