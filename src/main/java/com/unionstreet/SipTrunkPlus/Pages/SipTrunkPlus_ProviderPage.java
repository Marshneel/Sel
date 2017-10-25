package com.unionstreet.SipTrunkPlus.Pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by rajeshg on 06/09/2017.
 */
public class SipTrunkPlus_ProviderPage {

    ElementUtils utils=new ElementUtils();
   public static String providerName;

    public void clickProvidersOnSettingDropDown(){
       utils.waitForElementVisible(By.xpath("//span[contains(text(),'Providers')]"));
        utils.clickBtn(By.xpath("//span[contains(text(),'Providers')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Add Provider Template')]"));
    }
    public void loadAddProviderPage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Add Provider Template')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'Add Provider Template')]"));
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'Add Provider')]"));

    }

    public String generateXpathForAddProviderPart1(String variable){
        String xPath="//span[contains(text(),'"+variable+"')]/../../following-sibling::td[2]/input";
        return xPath;}
    public String generateXpathForAddProviderPart2(String variable){
        String xPath="//span[contains(text(),'"+variable+"')]/../../following-sibling::td[2]//input";
        return xPath;}

    public void clickOnExclamation(String message) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//div[@class='v-errorindicator']"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//div[@class='v-errorindicator']"));
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'"+message+"')]"));
    }

    public void checkValidationMessageForNumericFieldsOnAddProviderPage(String field, String toolTip) throws InterruptedException {
        utils.clickBtn(By.xpath(generateXpathForAddProviderPart2(field)));
        utils.waitForElementVisible(By.xpath("//pre[contains(text(),'"+toolTip+"')]"));
        utils.sendText(By.xpath(generateXpathForAddProviderPart2(field)),"lkjh");
        clickOnExclamation("Only digits allowed in this field");
        utils.sendText(By.xpath(generateXpathForAddProviderPart2(field)),"9000");
        clickOnExclamation("Number must be between 1-3600");
    }
   public String xpathToActivateSlidesOnCreateProviderPage(String field){
       String xPath="//span[contains(text(),'"+field+"')]/../../following-sibling::td[2]//label[@class='onoffswitch-slider off']";
       return xPath;}

    public void activateSlidesOnNewProviderPage(String userName,String realm, String passWord ){
        utils.clickBtn(By.xpath(xpathToActivateSlidesOnCreateProviderPage(userName)));
        utils.clickBtn(By.xpath(xpathToActivateSlidesOnCreateProviderPage(realm)));
        utils.clickBtn(By.xpath(xpathToActivateSlidesOnCreateProviderPage(passWord)));


    }

    public void populateNewProviderPage(String ping, String expirySeconds, String rotarySeconds) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(generateXpathForAddProviderPart1("Name")));
       providerName=utils.randomName();
       activateSlidesOnNewProviderPage("Username","Realm","Password");
       Thread.sleep(1000);
        utils.sendText(By.xpath(generateXpathForAddProviderPart1("Name")),providerName);
        String providerID=utils.randomNumber();
        utils.sendText(By.xpath(generateXpathForAddProviderPart1("UST Provider ID")),providerID);
        checkValidationMessageForNumericFieldsOnAddProviderPage("Ping","Ping every x seconds");
        utils.sendText(By.xpath(generateXpathForAddProviderPart2("Ping")),ping);
        checkValidationMessageForNumericFieldsOnAddProviderPage("Expire Seconds","Expire in seconds");
        utils.sendText(By.xpath(generateXpathForAddProviderPart2("Expire Seconds")),expirySeconds);
        checkValidationMessageForNumericFieldsOnAddProviderPage("Retry Seconds","How many seconds before a retry when a failure or timeout occurs");
        utils.sendText(By.xpath(generateXpathForAddProviderPart2("Retry Seconds")),rotarySeconds);
        utils.clickBtn(By.xpath(generateXpathForAddProviderPart2("Caller ID Type")));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'RPID')]"));
        utils.clickBtn(By.xpath("//span[contains(text(),'RPID')]"));
        utils.clickBtn(By.xpath(generateXpathForAddProviderPart2("Register Transport")));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'TCP')]"));
        utils.clickBtn(By.xpath("//span[contains(text(),'TCP')]"));
       utils.waitForElementVisible(By.xpath("//span[contains(text(),'Save')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'Save')]"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+providerName+"')]/following-sibling::td[contains(text(),'"+providerID+"')]"));
    }

}
