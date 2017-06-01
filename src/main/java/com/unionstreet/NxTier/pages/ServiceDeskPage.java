package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 28/05/2017.
 */
public class ServiceDeskPage {
    ElementUtils utils = new ElementUtils();


    public void assertTextOnServiceDesk(){
        utils.waitForElementVisible(By.xpath("//h1[contains(text(),'Log an incident')]"));
    }
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
    public void clickOnResult(String shortName){
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+shortName+"')]"));
        utils.clickBtn(By.xpath("//td[contains(text(),'"+shortName+"')]"));
    }
    public void assertAccountDetails(String companyName, String accountStatus,String SLAstatus){
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'"+companyName+"')]"));
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Account Status')]/following-sibling::p[contains(text(),'"+accountStatus+"')]"));
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'sla')]/following-sibling::p[contains(text(),'"+SLAstatus+"')]"));
    }
    public void assertSiteUnderAccountDetails(String companyName){
        utils.waitForElementVisible(By.xpath("//h5[contains(text(),'"+companyName+"')]"));
    }
    public void assertIncidents(String incidentSummary){
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+incidentSummary+"')]"));
    }

}

