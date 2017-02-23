package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rajeshg on 24/10/2016.
 */
public class OrdersManagerPage {

    private static String QUOTE_RanName;

    public final String QUOTE = "bodyContent";
    public final String INVISIBLE_ORDER_SERVICESID = "//input[@id='Service_ID']";
    public final String QUOTEID = "//a[contains(@href,'Orders/EditOrder')]";
    private final String CREATEQUOTE_BUTTON = "//a[@class='add'][text()[contains(.,'Create Quote')]]";
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

    ElementUtils utils = new ElementUtils();
    WLR_and_NxTierServicesPage wlr_and_nxTierServicesPage = new WLR_and_NxTierServicesPage();

    ContactManagerPage contactManagerPage = new ContactManagerPage();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    CommonMethods commonMethods = new CommonMethods();
    DashBoardPage dashBoardPage = new DashBoardPage();
    LoginPage loginPage = new LoginPage();
    CompanyMenuPage companyMenuPage = new CompanyMenuPage();
    SettingsPage settingsPage = new SettingsPage();
    AddSiteDetailsPage addSiteDetailsPage = new AddSiteDetailsPage();

    public void clickCreateQuoteButton() throws InterruptedException {

        try {
            utils.waitForElementVisible(By.xpath(CREATEQUOTE_BUTTON));
            utils.jumpToPopUpWindow(By.xpath(CREATEQUOTE_BUTTON));
        } catch (Exception e) {
            utils.getOrdersPage();
            utils.waitForElementVisible(By.xpath(CREATEQUOTE_BUTTON));
            utils.jumpToPopUpWindow(By.xpath(CREATEQUOTE_BUTTON));
        }
    }

    public void onQuotePage() throws InterruptedException {
        utils.sendText(By.id(ORDER_QUOTE_DESCRIPTION_FIELD), newBusinessCustomerPage.RanName);
        utils.selectByVisibleText(By.id("CompanyId"), newBusinessCustomerPage.RanName);
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
    }

    public void onQuotePageForReseller() throws InterruptedException {
        addSiteDetailsPage.Reseller_RanName = utils.randomName();
        utils.sendText(By.id(ORDER_QUOTE_DESCRIPTION_FIELD), addSiteDetailsPage.Reseller_RanName);
        utils.selectByVisibleText(By.id("CompanyId"), "reseller");
        utils.selectByVisibleText(By.id("SiteId"), "reseller");
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
    }

    public void assertQuotePageForAgentandReseller() throws InterruptedException {
        utils.searchAndAssertTextNotPresent(By.id(QUOTEBOX), "Select Owner");
        utils.searchAndAssertTextNotPresent(By.id(QUOTEBOX), "Select Team");
        utils.waitForElementVisible(By.id(ORDERS_SAVEQUOTE_BUTTON));
        Thread.sleep(1000);
        utils.closePopup(By.id(ORDERS_SAVEQUOTE_BUTTON));
    }

    public void assertCPQuotePage() throws InterruptedException {
        utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Order Owner");
        utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Team");
        utils.waitForElementVisible(By.id(ORDERS_SAVEQUOTE_BUTTON));
        Thread.sleep(1000);
        utils.closePopup(By.id(ORDERS_SAVEQUOTE_BUTTON));
    }

    public void checkQuotesForAgent() throws InterruptedException {
        utils.waitForElementVisible(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "aBILLity");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementVisible(By.xpath("//div[@id='orderContentPanel']//td[contains(text(),'No Records')]"));
        utils.waitForElementVisible(By.xpath("//div[@id='pageLoader'][@class='page-loader']"));
        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath("//div[@id='pageLoader'][@class='page-loader']"));
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
        }
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementVisible(By.xpath("//div[@id='orderContentPanel']//td[contains(text(),'No Records')]"));
    }

    public void checkQuoteForReseller() throws InterruptedException {
        utils.waitForElementVisible(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "aBILLity");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementVisible(By.xpath("//div[@id='orderContentPanel']//td[contains(text(),'No Records')]"));
        utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
        Thread.sleep(1000);
        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
        } catch (Exception e) {
            utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
            Thread.sleep(2000);
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
        }
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.waitForElementVisible(By.xpath("//div[@id='orderContentPanel']//td[contains(text(),'No Records')]"));
    }

    public void checkQuotesForCP() throws InterruptedException {

        utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementVisible(By.xpath(AGENT));
        utils.waitForElementVisible(By.xpath("//div[@id='pageLoader'][@class='page-loader']"));
        try {
            Thread.sleep(1000);
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath("//div[@id='pageLoader'][@class='page-loader']"));
            Thread.sleep(1000);
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
        }
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
        utils.waitForElementToVanish(By.id(settingsPage.AWAITING_PROCESS));
        utils.waitForElementVisible(By.xpath(RESELLER));
    }


    public void assertQuote() {
        utils.getOrdersPage();
        utils.searchAndAssertTextPresent(By.id(QUOTE), newBusinessCustomerPage.RanName);
    }

    public void assertQuoteForReseller() {
        utils.getOrdersPage();
        utils.searchAndAssertTextPresent(By.id(QUOTE), addSiteDetailsPage.Reseller_RanName);
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
        utils.closePopup(By.id(ORDERS_SAVEQUOTE_BUTTON));
        utils.getOrdersPage();
    }

    public void createQuoteForReseller() throws InterruptedException {
        utils.sendText(By.id(ORDER_QUOTE_DESCRIPTION_FIELD), addSiteDetailsPage.Reseller_RanName);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), "reseller");
        Thread.sleep(1000);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), addSiteDetailsPage.Reseller_RanName);
        Thread.sleep(1000);
        utils.closePopup(By.id(ORDERS_SAVEQUOTE_BUTTON));
    }

    public void searchQuoteByQRN() {
        utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), QUOTE_RanName);
        utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
    }

    public void assertAgentCannotViewQuotes() {
        utils.searchAndAssertTextNotPresent(By.id(QUOTE), QUOTE_RanName);
    }

    public void createQuote() throws InterruptedException {
        utils.sendText(By.id(ORDER_QUOTE_DESCRIPTION_FIELD), newBusinessCustomerPage.RanName);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTCOMPANY), newBusinessCustomerPage.RanName);
        Thread.sleep(1000);
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), utils.getProperty("shortName"));
        Thread.sleep(1000);
        utils.closePopup(By.id(ORDERS_SAVEQUOTE_BUTTON));
    }

    public void searchQuoteByBcRN() {
        commonMethods.search(newBusinessCustomerPage.RanName);
        utils.waitForElementVisible(By.xpath("//td[text()='" + newBusinessCustomerPage.RanName + "']"));
    }

    public void clickOnQuoteID() throws InterruptedException {
        try {
            utils.waitForElementVisible(By.xpath(QUOTEID));
            Thread.sleep(1000);
            utils.clickBtn(By.xpath(QUOTEID));
            try {
                utils.checkAlert();
            } catch (Exception e) {
            }
            Thread.sleep(1000);
            utils.switchToNewWindow();
        } catch (Exception e) {
            utils.getOrdersPage();
            utils.waitForElementVisible(By.xpath(QUOTEID));
            utils.clickBtn(By.xpath(QUOTEID));
            try {
                utils.checkAlert();
            } catch (Exception ex) {
            }
            Thread.sleep(1000);
            utils.switchToNewWindow();
        }
    }

    public void savingQuoteAndExtractingOrderServiceID() throws InterruptedException {
        utils.switchToNewWindow();
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
        utils.waitForElementVisible(By.xpath(INVISIBLE_ORDER_SERVICESID));
        utils.getAttributeOfElement(By.xpath(INVISIBLE_ORDER_SERVICESID), "value");
    }

    public String getServiceOrderID() {
        return utils.getAttributeOfElement(By.xpath(INVISIBLE_ORDER_SERVICESID), "value");
    }

    public void saveTheServiceAndGetTheOrderServicesID() {
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(INVISIBLE_ORDER_SERVICESID));
        utils.getAttributeOfElement(By.xpath(INVISIBLE_ORDER_SERVICESID), "value");
    }

    public void makeSureAgentDoesNotHaveAgentAndResellerService() {
        utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
        commonMethods.search("agent");
        utils.waitForElementVisible(By.id(LOCATOR_FOR_BOX_HEADER));
        utils.waitForElementVisible(By.xpath("//a[@href='#'][contains(text(),'agent')]"));
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
        companyMenuPage.clickConfigManager();
        wlr_and_nxTierServicesPage.accessingAssignServicePage();
        commonMethods.search("agent");
        utils.waitForElementVisible(By.xpath("//a[@href='#'][contains(text(),'agent')]"));
        utils.waitForElementVisible(By.id(LOCATOR_FOR_BOX_HEADER));
        utils.waitForElementVisible(By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER));
        utils.makeSureBoxIsChecked(By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER), By.id(AGENT_CHECKBOX_SERVICE_FOR_AGENT_AND_RESELLER));
    }

    public void clickDone() {
        utils.getOrdersPage();
        utils.waitForElementVisible(By.xpath(ORDER_TASK));
        utils.clickBtn(By.xpath(ORDER_TASK));
        utils.waitForElementVisible(By.xpath(DONE_CHECKBOX));
        utils.clickBtn(By.xpath(DONE_CHECKBOX));
        utils.clickBtn(By.xpath(SUBMIT_DONE));
    }

    public void completeTask() {
        try {
            do {
                clickDone();
            }
            while (utils.isElementPresent(By.xpath(ORDER_TASK)) == true);
        } catch (Exception e) {
        }
    }

    public void compareXMLResult() throws IOException, SQLException, ClassNotFoundException, SAXException {

        try {

            utils.sqlQuery("portal", "test01-sql01", "MockCVF", "select TOP 1 xml from XmlDump ORDER BY id DESC");
            utils.result.next();
            String actual = utils.result.getString("xml");
            ArrayList<String> scripts = new ArrayList<String>();
            scripts.add("USAgentRajeshG");
            scripts.add("490871001");
            scripts.add("DMA");
            scripts.add("USAgentRajeshG");
            scripts.add(newBusinessCustomerPage.RanName);
            scripts.add("01202300908");
            scripts.add("Premium");
            scripts.add("0987654321");
            scripts.add("WLR3 PSTN Single Line");
            scripts.add("490871001");
            scripts.add("lu1 1dq");
            scripts.add("364877501");
            scripts.add("01202300908");
            Assert.assertTrue(actual.contains((CharSequence) scripts));
        } catch (Exception e) {

        }
    }

}