package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 19/06/2017.
 */
public class CreateTariffPage {


    ElementUtils utils=new ElementUtils();
    CommonMethods commonMethods=new CommonMethods();
    public static String RanTariffPlanName;

    public void addTariffPlan() {
        RanTariffPlanName = utils.randomName();
        utils.sendText(By.id("TariffName1"), RanTariffPlanName);
        utils.waitForElementVisible(By.id("tariffSaveAndCloseButton"));
        utils.clickBtn(By.id("tariffSaveAndCloseButton"));
        utils.switchToPreviousWindow(0);
    }

    public void editTariffPlan() throws InterruptedException {
        commonMethods.search(RanTariffPlanName);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanTariffPlanName + "')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[contains(text(),'" + RanTariffPlanName + "')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("TariffName1"));
        utils.sendText(By.id("TariffName1"), RanTariffPlanName + "changed name");
        utils.waitForElementVisible(By.id("tariffSaveAndCloseButton"));
        utils.clickBtn(By.id("tariffSaveAndCloseButton"));
        utils.switchToPreviousWindow(0);
        commonMethods.search(RanTariffPlanName + "changed name");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanTariffPlanName + "changed name')]"));
    }

    public void validationsForNewTariffScreenByCP() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//input[@value='2'][@id='tariff_type']"));
        utils.waitForElementVisible(By.xpath("//input[@value='2'][@id='BasedOnType']"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//input[@value='2'][@id='BasedOnType']"));
        utils.waitForElementVisible(By.xpath("//input[@value='2'][@id='buyOrSale']"));
    }
    public void validationsForNewTariffScreenByAgent() throws InterruptedException {
        utils.waitForElementVisible(By.id("TariffName1"));
        String tariffName=utils.randomName();
        utils.sendText(By.id("TariffName1"),tariffName);
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Tariff Name')]"));
        utils.assertElementNotPresent(By.xpath("//input[@value='1'][@id='tariff_type']"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//input[@value='2'][@id='tariff_type']"));
        utils.waitForElementVisible(By.xpath("//input[@value='1'][@id='BasedOnType']"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//input[@value='2'][@id='BasedOnType']"));
        utils.assertElementNotPresent(By.xpath("//input[@value='1'][@id='buyOrSale']"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//input[@id='BasedOnType'][@value='0']"));
        utils.waitForElementVisible(By.id("tariffSaveAndCloseButton"));
        utils.clickBtn(By.id("tariffSaveAndCloseButton"));
        utils.switchToPreviousWindow(0);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+tariffName+"')]/../following-sibling::td[contains(text(),'Baseline')]"));
    }
    public void createBlankTariff(){
        RanTariffPlanName = utils.randomName();
        utils.sendText(By.id("TariffName1"), RanTariffPlanName);
        utils.waitForElementVisible(By.xpath("//legend[contains(text(),'Tariff Category')]/following-sibling::label[1]"));
        utils.clickBtn(By.xpath("//legend[contains(text(),'Tariff Category')]/following-sibling::label[1]"));
        utils.waitForElementVisible(By.xpath("//legend[contains(text(),'Tariff Type')]/following-sibling::label[1]"));
        utils.clickBtn(By.xpath("//legend[contains(text(),'Tariff Type')]/following-sibling::label[1]"));
        utils.waitForElementVisible(By.xpath("//input[@id='BasedOnType'][@value='0']"));
        utils.clickBtn(By.xpath("//input[@id='BasedOnType'][@value='0']"));
        utils.waitForElementVisible(By.id("tariffSaveAndCloseButton"));
        utils.clickBtn(By.id("tariffSaveAndCloseButton"));
        utils.switchToPreviousWindow(0);
    }
    public void createTariffPlanBasedOnOtherPlan(String value) throws InterruptedException {
        RanTariffPlanName = utils.randomName();
        utils.sendText(By.id("TariffName1"), RanTariffPlanName);
        utils.waitForElementVisible(By.xpath("//legend[contains(text(),'Tariff Category')]/following-sibling::label[3]"));
        utils.clickBtn(By.xpath("//legend[contains(text(),'Tariff Category')]/following-sibling::label[3]"));
        utils.waitForElementVisible(By.xpath("//legend[contains(text(),'Tariff Type')]/following-sibling::label[2]"));
        utils.clickBtn(By.xpath("//legend[contains(text(),'Tariff Type')]/following-sibling::label[2]"));
        utils.waitForElementVisible(By.xpath("//input[@id='BasedOnType'][@value='"+value+"']"));
        utils.clickBtn(By.xpath("//input[@id='BasedOnType'][@value='"+value+"']"));
        utils.waitForElementVisible(By.xpath("//input[@id='buyOrSale'][@value='0']"));
        utils.clickBtn(By.xpath("//input[@id='buyOrSale'][@value='0']"));
        utils.waitForElementVisible(By.id("basetariff"));
        utils.selectByVisibleText(By.id("basetariff"),"Sell 2p NGCS AC (+60 sec)");
        utils.waitForElementVisible(By.id("basemarkup"));
        utils.sendText(By.id("basemarkup"),"100");
        utils.waitForElementVisible(By.id("tariffSaveAndCloseButton"));
        utils.clickBtn(By.id("tariffSaveAndCloseButton"));
        utils.switchToPreviousWindow(0);}


  public void assertChargesOfTariffThatIsBasedOnAnAnotherTariff(String value,String attribute,boolean baseVal) throws InterruptedException {
      commonMethods.search(RanTariffPlanName);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+RanTariffPlanName+"')]"));
     Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[contains(text(),'"+RanTariffPlanName+"')]"));
       utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("HrefTariffRates"));
        utils.clickBtn(By.id("HrefTariffRates"));
        utils.checkAlert();
        utils.waitForElementVisible(By.xpath("//input[@id='RatesList_0__r_peak' and "+attribute+"='"+value+"']"));
        utils.waitForElementVisible( By.xpath("//input[@id='RatesList_0__r_offpeak' and "+attribute+"='"+value+"']"));
      if(baseVal) {
          utils.waitForElementVisible(By.xpath("//input[@id='RatesList_0__r_weekend' and " + attribute + "='" + value + "']"));
      }
      else {utils.waitForElementVisible(By.xpath("//input[@id='RatesList_0__b_weekend' and @value='"+value+"']"));

      }

        utils.waitForElementVisible(By.xpath("//input[contains(@onclick,'SaveAndClose')]"));
      utils.clickBtn(By.xpath("//input[contains(@onclick,'SaveAndClose')]"));
        utils.switchToPreviousWindow(0);






    }


}
