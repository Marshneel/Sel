package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 28/05/2017.
 */
public class ServiceDeskPage {
    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();



    public void assertTextOnServiceDesk() throws InterruptedException, SQLException, UnsupportedEncodingException, ClassNotFoundException {
       utils.waitForElementVisible(By.xpath("//h1[contains(text(),'Log an incident')]"));}

    public void searchByAccountName(String accountName) throws InterruptedException {
        utils.waitForElementVisible(By.id("search_Account_Name"));
        utils.sendText(By.id("search_Account_Name"),accountName);
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//input[@id='search_Account_Name']/following-sibling::span//span[contains(text(),'Search')]"));

    }

    public void searchByShortName(String shortName) throws InterruptedException {
        utils.waitForElementVisible(By.id("search_Account_Number"));
        utils.sendText(By.id("search_Account_Number"),shortName);
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//input[@id='search_Account_Number']/following-sibling::span//span[contains(text(),'Search')]"));
    }
    public void searchResultsForServiceDesk(String type){
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+type+"')]"));

    }
    public void assertNotFound(String type){
        utils.assertElementNotPresent(By.xpath("//td[contains(text(),'"+type+"')]"));
    }
    public void searchByCLI(String CLI) throws InterruptedException {
        utils.waitForElementVisible(By.id("search_CLI"));
        utils.sendText(By.id("search_CLI"),CLI);
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//input[@id='search_CLI']/following-sibling::span//span[contains(text(),'Search')]"));
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
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Account Status')]/following-sibling::p[contains(text(),'"+accountStatus+"')]"));
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'sla')]/following-sibling::p[contains(text(),'"+SLAstatus+"')]"));

    }public void clickIncidentButton(){
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Log an Incident')]"));
        utils.clickBtn(By.xpath("//span[contains(text(),'Log an Incident')]"));
    }
    public void assertAccessGrantedToLoginIncident(){
        utils.waitForElementVisible(By.xpath("//h1[contains(text(),'Log an incident')]"));
        
    }
    public void assertNoSLAwarningPopUp(){
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'No SLA')]"));
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'You can not create a ticket for this account because there is no SLA in place.Please contact your Service Desk administrator.')]"));
    }
    public void assertAccountOhHoldYellowPopUp(){
        utils.waitForElementVisible(By.xpath("//h4[@id='modal-alert-label'][contains(text(),'Account Status')]"));
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'This account has been flagged as being on hold. Would you still like to log an Incident?')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'Yes, continue.')]"));
    }

    public void assertAccountOnHoldRedPopUp(){
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'You can not create a ticket for this account')]"));
        utils.waitForElementVisible(By.xpath("//button[contains(text(),'Ok')]"));
        utils.clickBtn(By.xpath("//button[contains(text(),'Ok')]"));
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
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'Access Denied')]"));
    }

    }



