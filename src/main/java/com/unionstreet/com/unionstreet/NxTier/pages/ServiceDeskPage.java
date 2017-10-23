package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 28/05/2017.
 */
public class ServiceDeskPage {
    private final String LOGIN_AN_INCIDENT_BUTTON="//a[contains(text(),'Log an Incident')]";
    private final String LOGIN_AN_INCIDENT_HEADER_TEXT="//h1[contains(text(),'Log an incident')]";
    private final String LOGIN_AN_INCIDENT_CLICK="//span[contains(text(),'Log an Incident')]";
    private final String ACCESS_DENIED="//div[contains(text(),'Access Denied')]";
    private final String YOU_CANNOT_CREATE_A_TICKET_AS_THERE_IS_NO_SLA="//p[contains(text(),'You can not create a ticket for this account because there is no SLA in place.Please contact your Service Desk administrator.')]";
    private final String NO_SLA_TEXT="//h4[contains(text(),'No SLA')]";
    private final String ACCOUNT_ON_HOLD_DO_YOU_STILL_WANT_TO_CREATE_A_TICKET="//p[contains(text(),'This account has been flagged as being on hold. Would you still like to log an Incident?')]";
    private final String YOU_CANNOT_CREATE_A_TICKET_FOR_THIS_ACCOUNT="//p[contains(text(),'You can not create a ticket for this account')]";
    private final String SEARCH_BY_ACCOUNT_NAME_FIELD="search_Account_Name";
    private final String SEARCH_BY_ACCOUNT_NUMBER_FIELD="search_Account_Number";
    private final String SEARCH_CLI="search_CLI";
    private final String INITIATE_SEARCH_BY_ACCOUNT_NUMBER="//input[@id='search_Account_Number']/following-sibling::span//span[contains(text(),'Search')]";
    private final String INITIATE_SEARCH_BY_ACCOUNT_NAME="//input[@id='search_Account_Name']/following-sibling::span//span[contains(text(),'Search')]";
    private final String INITIATE_SEARCH_BY_CLI="//input[@id='search_CLI']/following-sibling::span//span[contains(text(),'Search')]";

    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();
    WLR3_LineNumberingPage wlr3_lineNumberingPage=new WLR3_LineNumberingPage();



    public void loadLoginIncidentPageAndAssertTextOnServiceDesk() throws InterruptedException, SQLException, UnsupportedEncodingException, ClassNotFoundException {
     Thread.sleep(1000);
       utils.clickBtn(By.xpath(LOGIN_AN_INCIDENT_BUTTON));
        utils.waitForElementVisible(By.xpath(LOGIN_AN_INCIDENT_HEADER_TEXT));}
    public void clickLogAnIncidentButton() throws InterruptedException {
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(LOGIN_AN_INCIDENT_BUTTON));

    }

    public void searchByAccountName(String accountName) throws InterruptedException {
        utils.waitForElementVisible(By.id(SEARCH_BY_ACCOUNT_NAME_FIELD));
        utils.sendText(By.id(SEARCH_BY_ACCOUNT_NAME_FIELD),accountName);
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(INITIATE_SEARCH_BY_ACCOUNT_NAME));

    }

    public void searchByShortName(String shortName) throws InterruptedException {
        utils.waitForElementVisible(By.id(SEARCH_BY_ACCOUNT_NUMBER_FIELD));
        utils.sendText(By.id(SEARCH_BY_ACCOUNT_NUMBER_FIELD),shortName);
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(INITIATE_SEARCH_BY_ACCOUNT_NUMBER));
    }
    public void searchResultsForServiceDesk(String type) throws InterruptedException {
        Thread.sleep(2000);
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+type+"')]"));


    }
    public void assertNotFound(String type){
        utils.assertElementNotPresent(By.xpath("//td[contains(text(),'"+type+"')]"));
    }
    public void searchByCLI(String CLI) throws InterruptedException {
        utils.waitForElementVisible(By.id(SEARCH_CLI));
        utils.sendText(By.id(SEARCH_CLI),CLI);
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(INITIATE_SEARCH_BY_CLI));
    }
    public void clickOnResult(String shortName) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+shortName+"')]"));
        Thread.sleep(2000);
        utils.clickBtn(By.xpath("//td[contains(text(),'"+shortName+"')]"));
    }
    public void assertAccountDetails(String companyName){
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'"+companyName+"')]"));

    }
    public void assertSiteUnderAccountDetails(String companyName){
        utils.waitForElementVisible(By.xpath("//h5[contains(text(),'"+companyName+"')]"));
    }
    public void assertIncidents(String incidentSummary){
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+incidentSummary+"')]"));
    }

    public void accountStatus_And_SlaStatus(String accountStatus, String SLAstatus) throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        if (utils.isElementPresent(By.xpath("//div[contains(text(),'agent')]"))) {
            utils.assertElementNotPresent(By.xpath("//h4[contains(text(),'Account Status')]/following-sibling::p[contains(text(),'" + accountStatus + "')]"));
            utils.assertElementNotPresent(By.xpath("//h4[contains(text(),'sla')]/following-sibling::p[contains(text(),'" + SLAstatus + "')]"));
        }
        if (utils.isElementPresent(By.xpath("//div[contains(text(),'reseller')]"))) {
            utils.assertElementNotPresent(By.xpath("//h4[contains(text(),'Account Status')]/following-sibling::p[contains(text(),'" + accountStatus + "')]"));
            utils.assertElementNotPresent(By.xpath("//h4[contains(text(),'sla')]/following-sibling::p[contains(text(),'" + SLAstatus + "')]"));
        }
        if (utils.isElementPresent(By.xpath("//div[contains(text(),'cp')]"))) {
            utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Account Status')]/following-sibling::p[contains(text(),'" + accountStatus + "')]"));
            utils.waitForElementVisible(By.xpath("//h4[contains(text(),'sla')]/following-sibling::p[contains(text(),'" + SLAstatus + "')]"));
        }
    }
        public void clickIncidentButton() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(LOGIN_AN_INCIDENT_CLICK));
            Thread.sleep(1000);
            utils.scrollUp(By.xpath(LOGIN_AN_INCIDENT_CLICK));
            Thread.sleep(1000);
        utils.clickBtn(By.xpath(LOGIN_AN_INCIDENT_CLICK));
    }
    public void assertAccessGrantedToLoginIncident(){
        utils.waitForElementVisible(By.xpath(LOGIN_AN_INCIDENT_HEADER_TEXT));
        
    }
    public void assertNoSLAwarningPopUp(){
        utils.waitForElementVisible(By.xpath(NO_SLA_TEXT));
        utils.waitForElementVisible(By.xpath(YOU_CANNOT_CREATE_A_TICKET_AS_THERE_IS_NO_SLA));
    }
    public void assertAccountOhHoldYellowPopUp(){
        utils.waitForElementVisible(By.xpath("//h4[@id='modal-alert-label'][contains(text(),'Account Status')]"));
        utils.waitForElementVisible(By.xpath(ACCOUNT_ON_HOLD_DO_YOU_STILL_WANT_TO_CREATE_A_TICKET));
        utils.clickBtn(By.xpath("//a[contains(text(),'Yes, continue.')]"));
    }

    public void assertAccountOnHoldRedPopUp(){
        utils.waitForElementVisible(By.xpath(YOU_CANNOT_CREATE_A_TICKET_FOR_THIS_ACCOUNT));
        utils.waitForElementVisible(By.xpath(wlr3_lineNumberingPage.OK_BUTTON_ON_NEW_OR_REACTIVATE_OLD_SNDDI_VALIDATION_POPUP));
        utils.clickBtn(By.xpath(wlr3_lineNumberingPage.OK_BUTTON_ON_NEW_OR_REACTIVATE_OLD_SNDDI_VALIDATION_POPUP));
    }
    public void grantingServiceDeskAccess() throws SQLException, UnsupportedEncodingException, ClassNotFoundException, InterruptedException {
        utils.sqlQuery("portal", "test01-sql01", "NxtierE2E", "select * from Group_Permissions where GTypeID='58dbb78d-8c9f-495f-99e6-0dbce29f02fe' and Name='Incident'");
        if (utils.result.next() == false) {
            utils.sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "insert into Group_Permissions ([Add],[View],[Edit],[Delete],PTypeID,GTypeID,Name,BaseID)values ('1','1','1','1','Service Desk','58dbb78d-8c9f-495f-99e6-0dbce29f02fe','Incident','12081')");
        } else {
        }
        Thread.sleep(1000);
        utils.sqlQuery("portal", "test01-sql01", "NxtierE2E", "select * from Group_Permissions where GTypeID='b99d95f9-bbec-45b1-abc2-db70df79c4ce' and Name='Incident'");
        if (utils.result.next() == false) {
            utils.sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "insert into Group_Permissions ([Add],[View],[Edit],[Delete],PTypeID,GTypeID,Name,BaseID)values ('1','1','1','1','Service Desk','b99d95f9-bbec-45b1-abc2-db70df79c4ce','Incident','12081')");
        } else {
        }
        Thread.sleep(1000);
    }
    public void revokingServiceDeskPermissions() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from Group_Permissions where BaseID='12081'");

    }
    public void assertServiceDeskAccessDenied(){

        utils.waitForElementVisible(By.xpath(ACCESS_DENIED));
    }


    }



