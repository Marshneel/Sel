package com.unionstreet.SipTrunkPlus.Pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

import static com.unionstreet.SipTrunkPlus.Pages.SipTrunkPlus_ProviderPage.providerName;

/**
 * Created by rajeshg on 03/08/2017.
 */
public class SipTrunkPlus_AddResellerPage {

    SipTrunkPlus_ProviderPage sipTrunkPlus_providerPage=new SipTrunkPlus_ProviderPage();

    private String CREATE_BUTTON="//span[text()[contains(.,'Create')]]";
    private String NEXT_BUTTON="//span[contains(text(),'Next')]";
    private String ADD_PROFILE="//div[@class='v-select-twincol-buttons']/div[1][@role='button']";



    ElementUtils utils = new ElementUtils();
    public static String ranResellerName;

    public String generateXpathForAddResellerPage_Part1(String variable){
        String xPath="//div[@class='v-window-contents']//span[text()[contains(.,'"+variable+"')]]/../..//following-sibling::td[@class='v-formlayout-contentcell']/input";
        return xPath;
    }
    public String generateXpathForAddResellerPage_Part2(String variable){
        String xPath="//div[@class='v-window-contents']//span[text()[contains(.,'"+variable+"')]]/../..//following-sibling::td[@class='v-formlayout-contentcell']//input";
   return xPath;
    }


    public void addNewResellerPage_General(boolean reseller, String type) throws InterruptedException {
     if(reseller) {  ranResellerName=utils.randomName();}
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'"+type+"')]"));
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part1("Portal Client Name / Ref")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part1("Portal Client Name / Ref")), ""+type+"" + ranResellerName);
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part1("Email")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part1("Email")), ranResellerName + "@email.com");
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part1("Company Name")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part1("Company Name")), ranResellerName);
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part1("Company Contact Surname")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part1("Company Contact Surname")), ranResellerName);
        utils.waitForElementVisible(By.xpath(NEXT_BUTTON));
        Thread.sleep(2000);
        utils.javaScriptExecutorClick(By.xpath(NEXT_BUTTON));}

    public void addNewResellerPage_Additional(boolean providerAlreadyCreated) throws InterruptedException {
       if(providerAlreadyCreated){utils.waitForElementVisible(By.xpath("//option[contains(text(),'"+providerName+"')]"));
           utils.clickBtn(By.xpath("//option[contains(text(),'"+providerName+"')]"));
           utils.waitForElementVisible(By.xpath("//div[@class='v-select-twincol v-widget v-has-width']/div[2]/div[1]"));
           utils.clickBtn(By.xpath("//div[@class='v-select-twincol v-widget v-has-width']/div[2]/div[1]"));}
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part1("Billing E-mail Address")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part1("Billing E-mail Address")), ranResellerName + "@email.com");
        utils.waitForElementVisible(By.xpath(NEXT_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(NEXT_BUTTON));}

    public void addNewResellerPage_Personalization() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part1("Greeting 1")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part1("Greeting 1")), ranResellerName);
        utils.waitForElementVisible(By.xpath(NEXT_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(NEXT_BUTTON));}

    public void addNewResellerPage_BusinessAddress(String type, String country) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part1("Address 1 (Street / Thoroughfare)")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part1("Address 1 (Street / Thoroughfare)")), "SheenRoad");
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part1("House/Premises Number")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part1("House/Premises Number")), "39");
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part1("City (Locality)")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part1("City (Locality)")), "Richmond");
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part2("Country")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part2("Country")), "United Kingdom");
        Thread.sleep(1000);
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'"+country+"')]"));
        utils.clickBtn(By.xpath("//span[contains(text(),'"+country+"')]"));
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part2("Postcode")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part2("Postcode")), "TW9 1AJ");
        utils.waitForElementVisible(By.xpath(CREATE_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(CREATE_BUTTON));
        utils.waitForElementVisible(By.xpath("//span[text()='"+type+"" + ranResellerName + "']"));
    }

    public void addClient_ChooseReseller() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(generateXpathForAddResellerPage_Part2("Reseller")));
        utils.sendText(By.xpath(generateXpathForAddResellerPage_Part2("Reseller")),"New reseller"+ranResellerName);
        utils.waitForElementVisible(By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']//span[contains(text(),'New reseller"+ranResellerName+"')]"));
        Thread.sleep(2000);
        utils.clickBtn(By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']//span[contains(text(),'New reseller"+ranResellerName+"')]"));
        utils.waitForElementVisible(By.xpath(NEXT_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(NEXT_BUTTON));}
    public void addClient_additional(String profile) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//option[contains(text(),'"+profile+"')]"));
        utils.clickBtn(By.xpath("//option[contains(text(),'"+profile+"')]"));
        utils.waitForElementVisible(By.xpath(ADD_PROFILE));
        utils.clickBtn(By.xpath(ADD_PROFILE));
        utils.waitForElementVisible(By.xpath(NEXT_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(NEXT_BUTTON));
    }



    }
