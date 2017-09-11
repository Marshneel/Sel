package com.unionstreet.SipTrunkPlus.Pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by rajeshg on 06/09/2017.
 */
public class SipTrunkPlus_LoginPage {

  ElementUtils utils=new ElementUtils();

    public void loginAsMasterUser() throws InterruptedException {
        utils.loadSipTrunkURL();
        utils.waitForElementVisible(By.id("gwt-uid-3"));
        utils.sendText(By.id("gwt-uid-3"),"autotest01");
        utils.waitForElementVisible(By.id("gwt-uid-5"));
        utils.sendText(By.id("gwt-uid-5"),"Aswini747");
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Sign In')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'Sign In')]"));
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'SIP Trunk Plus by 500 Limited')]"));


    }
}
