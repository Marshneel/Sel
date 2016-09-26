package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import static com.unionstreet.NxTier.support.BaseClass.driver;

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
    private final String QUOTEID = "//a[@target='_blank']";
    ElementUtils utils = new ElementUtils();
    ContactManagerPage contactManagerPage = new ContactManagerPage();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    CommonMethods commonMethods = new CommonMethods();


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
            String pageURL = driver.getCurrentUrl();
            driver.get(pageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assertCPQuotePage() throws InterruptedException {
        try {
            utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Order Owner");
            utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Team");
            utils.jumpToPopUpWindow(By.id(ORDERS_SAVEQUOTE_BUTTON));
            driver.get(utils.getProperty("ordersURL"));
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
          utils.assertTheElementAndTextPresent(By.xpath("//tr[@class='table_row_alt_subchild']/td[3]"),"agent");
            utils.searchAndAssertTextPresent(By.id(QUOTE), "agent");
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.assertTheElementAndTextPresent(By.xpath("//tr[@class='table_row_alt_subchild']/td[3]"),"reseller");
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
        String pageURL = driver.getCurrentUrl();
        driver.get(pageURL);
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
        utils.selectByVisibleText(By.id(contactManagerPage.CREATEQUOTE_SELECTSITE), "vodafone");
        utils.clickBtn(By.id(ORDERS_SAVEQUOTE_BUTTON));
        String pageURL = driver.getCurrentUrl();
        driver.get(pageURL);
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

    public void clickAddServicesButton() {
        utils.clickBtn(By.xpath("//span[@class='icon icon--box']"));

    }

    public void assertCPonlyValuePresent() throws InterruptedException {
        commonMethods.search("customService");
        utils.clickBtn(By.id("S_4"));
        utils.switchToNewWindow();
        utils.searchAndAssertTextPresent(By.xpath("//div[@class='tab_contentEmpty clearfix']"),"CPonly");

    }
    public void assertCPonlyValueNotPresent() throws InterruptedException {
    commonMethods.search("customService");
    utils.clickBtn(By.id("S_4"));
    utils.switchToNewWindow();
    utils.searchAndAssertTextNotPresent(By.xpath("//div[@class='tab_contentEmpty clearfix']"),"CPonly");
}
    public void searchAndsSelectService(){
    commonMethods.search("customService");
    utils.clickBtn(By.id("S_4"));
    utils.switchToNewWindow();
    utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
    utils.switchToParentWindow();}

    public void assertInvalidQuoteBeforeSubmitting(){
        utils.waitForElementVisible(By.xpath("//td[@class='red-cross']"));
        }
    public void assertInvalidQuoteAfterSubmitting(){
        utils.clickBtn(By.xpath("//span[@class='icon icon--save']"));
        utils.waitForElementVisible(By.id("Message_Info"));
    }
    public void clickService(){
        utils.clickBtn(By.xpath("//a[contains(@href,'Orders/EditOrderServiceDetails')]"));
        utils.switchToNewWindow();}

    public void populateMandatoryField(){
        utils.clickBtn(By.xpath("//input[@controlid='mandatoryControl']"));
        utils.sendText(By.xpath("//input[@controlid='mandatoryControl']"),"hello");
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToParentWindow();}

    public void assertValidQuoteBeforeSubmitting(){
        utils.waitForElementVisible(By.xpath("//td[@class='green-tick']"));

    }
    public void assertValidQuoteAfterSubmitting(){
        utils.selectByIndex(By.id("Order_order_contact_id"),1);
        utils.clickBtn(By.xpath("//span[@class='icon icon--save']"));
        utils.waitForElementVisible(By.xpath("//div[@class='error_msg_invalid']"));
    }
}