package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 06/06/2017.
 */
public class ConfigManagerPage {

    ElementUtils utils=new ElementUtils();
    CommonMethods commonMethods=new CommonMethods();
    public static String RanTariffPlanName;
    public static String RanFreeMinutePlanName;

    public void assignTariffPlanToAgent(String tariffplan) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'Config Manager')]"));
        commonMethods.search(""+tariffplan+"");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+tariffplan+"')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[contains(text(),'"+tariffplan+"')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("HrefAssignTarrifs"));
        utils.clickBtn(By.id("HrefAssignTarrifs"));
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'agent')]/../following-sibling::td[5]//input[@id='checkbox1']"));
       Thread.sleep(1000);
        utils.makeSureBoxIsChecked(By.xpath("//a[contains(text(),'agent')]/../following-sibling::td[5]//input[@id='checkbox1']"),By.xpath("//a[contains(text(),'agent')]/../following-sibling::td[5]//input[@id='checkbox1']"));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);
    }
    public void assignFreeMinutesPlanToAgent(String freeMinutePlan) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        utils.clickBtn(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        commonMethods.search(""+freeMinutePlan+"");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+freeMinutePlan+"')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[contains(text(),'"+freeMinutePlan+"')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("HrefAssignFreeMinutes"));
        utils.clickBtn(By.id("HrefAssignFreeMinutes"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'agent')]/following-sibling::td[3]/input[@id='checkbox1']"));
        Thread.sleep(1000);
        utils.makeSureBoxIsChecked(By.xpath("//td[contains(text(),'agent')]/following-sibling::td[3]/input[@id='checkbox1']"),By.xpath("//td[contains(text(),'agent')]/following-sibling::td[3]/input[@id='checkbox1']"));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);
    }
    public void assertTariff(String tariffName){
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+tariffName+"')]"));
    }
    public void assertFreeMinutes(String freeMinutePlan){
        utils.clickBtn(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+freeMinutePlan+"')]"));
    }
    public void assertFreeMinutesAreNotEditable(String freeMinutePlan){
        utils.clickBtn(By.xpath("//a[contains(text(),'"+freeMinutePlan+"')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath("//img[@title='Edit Free Minutes Details']"));
        utils.clickBtn(By.xpath("//img[@title='Edit Free Minutes Details']"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath("//textarea[@id='Dfreeminutedetails_description'][@disabled='disabled']"));
        utils.waitForElementVisible(By.xpath("//select[@id='Dfreeminutedetails_what_id'][@disabled='disabled']"));
    }
    public void assertTariffAreNotEditable(String tariffPlan){
        utils.switchToPreviousWindow(0);
        utils.waitForElementVisible(By.xpath("//div[@id='subMenu']//a[contains(@href,'tariff')]"));
        utils.clickBtn(By.xpath("//div[@id='subMenu']//a[contains(@href,'tariff')]"));
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+tariffPlan+"')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'"+tariffPlan+"')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath("//input[@id='TariffName1'][@disabled='disabled']"));
        utils.waitForElementVisible(By.id("HrefTariffRates"));
        utils.clickBtn(By.id("HrefTariffRates"));
        utils.waitForElementVisible(By.xpath("//input[@id='RatesList_0__r_mincharge'][@disabled='disabled']"));
    }
    public void addTariffPlan() {
        utils.waitForElementVisible(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("TariffName1"));
        RanTariffPlanName=utils.randomName();
        utils.sendText(By.id("TariffName1"),RanTariffPlanName);
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);
    }
    public void addFreeMinutesPlan(){
       utils.waitForElementVisible(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        utils.clickBtn(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        utils.waitForElementVisible(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("Plan_name"));
     RanFreeMinutePlanName=utils.randomName();
        utils.sendText(By.id("Plan_name"),RanFreeMinutePlanName);
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("Dfreeminutedetails_amount"));
        utils.sendText(By.id("Dfreeminutedetails_amount"),"100");
        utils.selectByVisibleText(By.id("Dfreeminutedetails_what_id"),"Calls");
        utils.waitForElementVisible(By.xpath("//div[@id='divProgress'][contains(@style,'display: none;')]"));
        utils.selectByVisibleText(By.id("Dfreeminutedetails_apply_to_id"),"Per Company");
        utils.selectByVisibleText(By.id("Dfreeminutedetails_frequency_id"),"Daily");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);
    }
    public void editTariffPlan() throws InterruptedException {
        commonMethods.search(RanTariffPlanName);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+RanTariffPlanName+"')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[contains(text(),'"+RanTariffPlanName+"')]"));
       utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("TariffName1"));
        utils.sendText(By.id("TariffName1"),RanTariffPlanName+"changed name");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);
        commonMethods.search(RanTariffPlanName+"changed name");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+RanTariffPlanName+"changed name')]"));
    }
    public void editFreeMinutePlan() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        utils.clickBtn(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        commonMethods.search(RanFreeMinutePlanName);
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[contains(text(),'"+RanFreeMinutePlanName+"')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("Plan_name"));
        utils.sendText(By.id("Plan_name"),RanFreeMinutePlanName+"changed name");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);
        commonMethods.search(RanFreeMinutePlanName+"changed name");
       try{ utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+RanFreeMinutePlanName+"changed name')]"));
    }catch (Exception e){
           System.out.println("agent is not able to edit a free minute plan");
       }}
}
