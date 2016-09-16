package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import static com.unionstreet.NxTier.support.BaseClass.driver;

public class DashBoardPage {
    public final String DASHBOARD_TITLE = "menutitle";
    //TODO
    public final String LOGOUT_BUTTON = ".logout";
    private final String ORDERQUOTE_DESCRIPTION_FIELD = "QuoteDescription";
    private final String ORDERS_SAVEQUOTE_BUTTON = "CreateQuoteButton";
    private final String ORDERSMANAGER_BUTTON = "HrefOrdersManager";
    private final String CREATEQUOTE_BUTTON = ".add";
    private final String QUOTESPAGE="bodyContent";
    private final String CREATEQUOTE_SELECTCOMPANY = "CompanyId";
    private final String QUOTE = "contentPanel";
    private final String QUOTEBOX = "StartQuote";
    private static String QUOTE_RanName;

    ElementUtils utils = new ElementUtils();
    ContactManagerPage contactManagerPage = new ContactManagerPage();


    public void assertLogin() throws InterruptedException {
        utils.verifyStringMatch(By.id(DASHBOARD_TITLE), "DASHBOARD");
    }

    public void logOut() {
        utils.clickBtn(By.cssSelector(LOGOUT_BUTTON));
    }

    public void clickOrderManagerButton() {
        utils.clickBtn(By.id(ORDERSMANAGER_BUTTON));
    }

    public void clickCreateQuoteButton() {
        utils.searchAndAssertTextPresent(By.id(QUOTESPAGE), "Create Quote");
        utils.jumpToPopUpWindow(By.cssSelector(CREATEQUOTE_BUTTON));
    }

    public void onQuotePage() {
        try {
            utils.clickBtn(By.id(ORDERQUOTE_DESCRIPTION_FIELD));
            QUOTE_RanName = utils.randomName();
            utils.sendText(By.id(ORDERQUOTE_DESCRIPTION_FIELD), QUOTE_RanName);
            utils.selectByIndex(By.id(CREATEQUOTE_SELECTCOMPANY),1);
        } catch (Exception e) {
        }
    }

    public void assertQuotePageForAgentandReseller() {
        try {
            utils.searchAndAssertTextNotPresent(By.id(QUOTEBOX),"Select Owner");
            utils.searchAndAssertTextNotPresent(By.id(QUOTEBOX),"Select Team");
            utils.jumpToPopUpWindow(By.id(ORDERS_SAVEQUOTE_BUTTON));
            driver.get(utils.getProperty("ordersURL"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assertCPQuotePage() throws InterruptedException {
        try {
            utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Select Owner");
            utils.searchAndAssertTextPresent(By.id(QUOTEBOX), "Select Team");
            utils.jumpToPopUpWindow(By.id(ORDERS_SAVEQUOTE_BUTTON));
            driver.get(utils.getProperty("ordersURL"));
        } catch (Exception e) {
        }
    }

    public void checkQuotesForAgent() throws InterruptedException {

        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "CP");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.searchAndAssertTextNotPresent(By.id(QUOTE),"CP");
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.searchAndAssertTextNotPresent(By.id(QUOTE),"reseller");
        } catch (Exception e) {
        }
    }

    public void checkQuoteForReseller() {
        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "CP");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.searchAndAssertTextNotPresent(By.id(QUOTE),"CP");
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.searchAndAssertTextNotPresent(By.id(QUOTE),"agent");
        } catch (Exception e) {
        }
    }

    public void checkQuotesForCP() throws InterruptedException {
        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "agent");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.searchAndAssertTextPresent(By.id(QUOTE),"agent");
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), "reseller");
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
            utils.searchAndAssertTextPresent(By.id(QUOTE),"reseller");
        } catch (Exception e) {
        }
    }

    public void assertQuote() throws InterruptedException {

        try {
            utils.sendText(By.id(contactManagerPage.SEARCH_BUTTON), QUOTE_RanName);
            utils.keyBoardEnter(By.id(contactManagerPage.SEARCH_BUTTON));
           utils.searchAndAssertTextPresent(By.id(QUOTE),QUOTE_RanName);
        } catch (Exception e) {
        }
    }
}