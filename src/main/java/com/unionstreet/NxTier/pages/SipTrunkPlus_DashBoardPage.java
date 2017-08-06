package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by rajeshg on 03/08/2017.
 */
public class SipTrunkPlus_DashBoardPage {
    ElementUtils utils=new ElementUtils();
   SipTrunkPlus_AddResellerPage sipTrunkPlus_addResellerPage=new SipTrunkPlus_AddResellerPage();

    private String ADD_NEW_RESELLER_BUTTON="//span[contains(text(),'Add reseller')]/../..";
    private String NAVIGATE_TO_ROOT="//span[contains(text(),'ROOT')]";
    private String DELETE_ACCOUNT_BUTTON="//span[contains(text(),'Delete Account')]";
    private String SEARCH_BOX="gwt-uid-4";
    private String ADD_NEW_CLIENT_BUTTON="//span[contains(text(),'Add client')]";
    private String SLIDER_BUTTON="v-sliderpanel-caption";
    private String YES_BUTTON="//span[contains(text(),'Yes')]";

public void clickNewResellerButton() throws InterruptedException {
    utils.waitForElementVisible(By.xpath(ADD_NEW_RESELLER_BUTTON));
    Thread.sleep(1000);
    utils.javaScriptExecutorClick(By.xpath(ADD_NEW_RESELLER_BUTTON));
}

    public void SearchAndAssertReseller() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'New reseller"+sipTrunkPlus_addResellerPage.ranResellerName+"')]"));
        utils.waitForElementVisible(By.xpath(NAVIGATE_TO_ROOT));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(NAVIGATE_TO_ROOT));
        utils.waitForElementVisible(By.className(SLIDER_BUTTON));
        utils.clickBtn(By.className(SLIDER_BUTTON));
        utils.waitForElementVisible(By.id(SEARCH_BOX));
        utils.sendText(By.id(SEARCH_BOX),"New reseller"+sipTrunkPlus_addResellerPage.ranResellerName);
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'New reseller"+sipTrunkPlus_addResellerPage.ranResellerName+"')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//div[contains(text(),'New reseller"+sipTrunkPlus_addResellerPage.ranResellerName+"')]"));
    }

    public void deleteAccount() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(DELETE_ACCOUNT_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(DELETE_ACCOUNT_BUTTON));
        utils.waitForElementVisible(By.xpath(YES_BUTTON));
        Thread.sleep(2000);
        utils.javaScriptExecutorClick(By.xpath(YES_BUTTON));
    }
    public void deleteResellerAccount(boolean client) throws InterruptedException {
      deleteAccount();
       if(client){deleteAccount();}
        utils.waitForElementVisible(By.id(SEARCH_BOX));
        Thread.sleep(1000);
        utils.sendText(By.id(SEARCH_BOX),"New reseller"+sipTrunkPlus_addResellerPage.ranResellerName);
        utils.assertElementNotPresent(By.xpath("//div[contains(text(),'New reseller"+sipTrunkPlus_addResellerPage.ranResellerName+"')]"));
    }
    public void clickNewClientButton() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(ADD_NEW_CLIENT_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(ADD_NEW_CLIENT_BUTTON));
    }
    public void assertNewlyCreatedClient(){
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'New client"+sipTrunkPlus_addResellerPage.ranResellerName+"')]"));
        utils.clickBtn(By.xpath("//div[contains(text(),'New client"+sipTrunkPlus_addResellerPage.ranResellerName+"')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'New client"+sipTrunkPlus_addResellerPage.ranResellerName+"')]"));
    }

    }

