package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 19/06/2017.
 */
public class CreateTariffPage {

    public final String TARIFF_RATES_BUTTON="HrefTariffRates";
    private final String SAVE_AND_CLOSE_CREATED_TARIFF="tariffSaveAndCloseButton";
    public final String TARIFF_NAME_TEXT_BOX="TariffName1";
    private final String BASELINE_TARIFF_RADIO_BUTTON="//input[@value='2'][@id='tariff_type']";
    private final String BUY_TARIFF_RADIO_BUTTON="//input[@value='1'][@id='tariff_type']";
    private final String BASED_ON_TARIFF_RADIO_BUTTON="//input[@value='2'][@id='BasedOnType']";
    private final String COPY_TARIFF_RADIO_BUTTON="//input[@value='1'][@id='BasedOnType']";
    private final String BLANK_TARIFF_RADIO_BUTTON="//input[@id='BasedOnType'][@value='0']";
    private final String BASE_LINE_RADIO_BUTTON_UNDER_BASE_TARIFF_SETTINGS="//input[@value='2'][@id='buyOrSale']";
    private final String BUY_RADIO_BUTTON_UNDER_BASE_TARIFF_SETTINGS="//input[@value='1'][@id='buyOrSale']";
    private final String MOBILE_RADIO_BUTTON_UNDER_TARIFF_CAT="//input[@value='Mobile'][@id='tariff_category']";
    private final String TARIFF_NAME_TEXT_ON_ADD_TARIFF_PAGE="//h4[contains(text(),'Tariff Name')]";
    private final String BASE_TARIFF_DROP_DOWN="basetariff";
    private final String MARKUP_PERCENTAGE_FIELD="basemarkup";
    public final String SEMI_TRANSPARENT_UNION_STREET_TEXT="//td[@class=' SemiTransparent'][contains(text(),'Union Street Telecoms')]";
    private final String NON_CREATOR_HAS_NO_CHECK_BOX_IN_ASSIGN_PLAN_PAGE="//a[@href='#'][contains(text(),'Union Street Telecoms')]/../../td[6]//input[@checked='checked']";
    private final String CREATOR_HAS_CHECK_BOX_IN_ASSIGN_PLAN_PAGE="//a[@href='#'][contains(text(),'agent')]/../../td[6]//input[@checked='checked']";

    ElementUtils utils=new ElementUtils();
    CommonMethods commonMethods=new CommonMethods();
    public static String RanTariffPlanName;

    public void addTariffPlan() {
        RanTariffPlanName = utils.randomName();
        utils.sendText(By.id(TARIFF_NAME_TEXT_BOX), RanTariffPlanName);
        utils.waitForElementVisible(By.id(BASE_TARIFF_DROP_DOWN));
        utils.selectByVisibleText(By.id(BASE_TARIFF_DROP_DOWN),"Sell 2p NGCS AC (+60 sec)");
        utils.waitForElementVisible(By.id(MARKUP_PERCENTAGE_FIELD));
        utils.sendText(By.id(MARKUP_PERCENTAGE_FIELD),"10");
        utils.waitForElementVisible(By.id(SAVE_AND_CLOSE_CREATED_TARIFF));
        utils.clickBtn(By.id(SAVE_AND_CLOSE_CREATED_TARIFF));
        utils.switchToPreviousWindow(0);
    }

    public void editTariffPlan() throws InterruptedException {
        commonMethods.search(RanTariffPlanName);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanTariffPlanName + "')]"));
      utils.clickBtn(By.xpath("//a[contains(text(),'" + RanTariffPlanName + "')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id(TARIFF_NAME_TEXT_BOX));
        utils.sendText(By.id(TARIFF_NAME_TEXT_BOX), RanTariffPlanName + "changed name");
        utils.waitForElementVisible(By.xpath(MOBILE_RADIO_BUTTON_UNDER_TARIFF_CAT));
        utils.clickBtn(By.xpath(MOBILE_RADIO_BUTTON_UNDER_TARIFF_CAT));
        utils.waitForElementVisible(By.id(SAVE_AND_CLOSE_CREATED_TARIFF));
        utils.clickBtn(By.id(SAVE_AND_CLOSE_CREATED_TARIFF));
        utils.switchToPreviousWindow(0);
        commonMethods.search(RanTariffPlanName + "changed name");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanTariffPlanName + "changed name')]"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'Mobile')]"));
    }

    public void validationsForNewTariffScreenByCP() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(BASELINE_TARIFF_RADIO_BUTTON));
        utils.waitForElementVisible(By.xpath(BASED_ON_TARIFF_RADIO_BUTTON));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(BASED_ON_TARIFF_RADIO_BUTTON));
        utils.waitForElementVisible(By.xpath(BASE_LINE_RADIO_BUTTON_UNDER_BASE_TARIFF_SETTINGS));
    }
    public void validationsForNewTariffScreenByAgent() throws InterruptedException {
        utils.waitForElementVisible(By.id(TARIFF_NAME_TEXT_BOX));
        String tariffName=utils.randomName();
        utils.sendText(By.id(TARIFF_NAME_TEXT_BOX),tariffName);
        utils.waitForElementVisible(By.xpath(TARIFF_NAME_TEXT_ON_ADD_TARIFF_PAGE));
        utils.assertElementNotPresent(By.xpath(BUY_TARIFF_RADIO_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(BASELINE_TARIFF_RADIO_BUTTON));
        utils.waitForElementVisible(By.xpath(COPY_TARIFF_RADIO_BUTTON));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(BASED_ON_TARIFF_RADIO_BUTTON));
        utils.assertElementNotPresent(By.xpath(BUY_RADIO_BUTTON_UNDER_BASE_TARIFF_SETTINGS));
        utils.waitForElementVisible(By.id(BASE_TARIFF_DROP_DOWN));
        utils.selectByVisibleText(By.id(BASE_TARIFF_DROP_DOWN),"Sell 2p NGCS AC (+60 sec)");
        utils.waitForElementVisible(By.id(MARKUP_PERCENTAGE_FIELD));
        utils.sendText(By.id(MARKUP_PERCENTAGE_FIELD),"10");
        utils.assertElementNotPresent(By.xpath(BLANK_TARIFF_RADIO_BUTTON));
        utils.waitForElementVisible(By.id(SAVE_AND_CLOSE_CREATED_TARIFF));
        utils.clickBtn(By.id(SAVE_AND_CLOSE_CREATED_TARIFF));
        utils.switchToPreviousWindow(0);
        commonMethods.search(tariffName);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+tariffName+"')]"));
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+tariffName+"')]/../following-sibling::td[contains(text(),'Baseline')]"));
    }
    public void createBlankTariff(String tariffCategory, String tariffType, String baseTariffSetting, boolean cp, boolean agent) throws InterruptedException {
        RanTariffPlanName = utils.randomName();
        Thread.sleep(1000);
        utils.sendText(By.id(TARIFF_NAME_TEXT_BOX), RanTariffPlanName);
        utils.waitForElementVisible(By.xpath("//legend[contains(text(),'Tariff Category')]/following-sibling::label["+tariffCategory+"]"));
        utils.clickBtn(By.xpath("//legend[contains(text(),'Tariff Category')]/following-sibling::label["+tariffCategory+"]"));
        utils.waitForElementVisible(By.xpath("//legend[contains(text(),'Tariff Type')]/following-sibling::label["+tariffType+"]"));
        utils.clickBtn(By.xpath("//legend[contains(text(),'Tariff Type')]/following-sibling::label["+tariffType+"]"));
      if (cp){  utils.waitForElementVisible(By.xpath("//input[@id='BasedOnType'][@value='"+baseTariffSetting+"']"));
        utils.clickBtn(By.xpath("//input[@id='BasedOnType'][@value='"+baseTariffSetting+"']"));}
      if(agent){  utils.waitForElementVisible(By.id(BASE_TARIFF_DROP_DOWN));
          utils.selectByVisibleText(By.id(BASE_TARIFF_DROP_DOWN),"Sell 2p NGCS AC (+60 sec)");
          utils.waitForElementVisible(By.id(MARKUP_PERCENTAGE_FIELD));
          utils.sendText(By.id(MARKUP_PERCENTAGE_FIELD),"10");}
        utils.waitForElementVisible(By.id(SAVE_AND_CLOSE_CREATED_TARIFF));
        utils.clickBtn(By.id(SAVE_AND_CLOSE_CREATED_TARIFF));
        utils.switchToPreviousWindow(0);
    }
    public void createTariffPlanBasedOnOtherPlan(String tariffCategory, String tariffType ,String baseTariffSettings, String buyOrSell, String basedOnPlan) throws InterruptedException {
        RanTariffPlanName = utils.randomName();
        utils.sendText(By.id(TARIFF_NAME_TEXT_BOX), RanTariffPlanName);
        utils.waitForElementVisible(By.xpath("//legend[contains(text(),'Tariff Category')]/following-sibling::label["+tariffCategory+"]"));
        utils.clickBtn(By.xpath("//legend[contains(text(),'Tariff Category')]/following-sibling::label["+tariffCategory+"]"));
        utils.waitForElementVisible(By.xpath("//legend[contains(text(),'Tariff Type')]/following-sibling::label["+tariffType+"]"));
        utils.clickBtn(By.xpath("//legend[contains(text(),'Tariff Type')]/following-sibling::label["+tariffType+"]"));
        utils.waitForElementVisible(By.xpath("//input[@id='BasedOnType'][@value='"+baseTariffSettings+"']"));
        utils.clickBtn(By.xpath("//input[@id='BasedOnType'][@value='"+baseTariffSettings+"']"));
        utils.waitForElementVisible(By.xpath("//input[@id='buyOrSale'][@value='"+buyOrSell+"']"));
        utils.clickBtn(By.xpath("//input[@id='buyOrSale'][@value='"+buyOrSell+"']"));
        utils.waitForElementVisible(By.id(BASE_TARIFF_DROP_DOWN));
        utils.selectByVisibleText(By.id(BASE_TARIFF_DROP_DOWN),""+basedOnPlan+"");
        utils.waitForElementVisible(By.id(MARKUP_PERCENTAGE_FIELD));
        utils.sendText(By.id(MARKUP_PERCENTAGE_FIELD),"100");
        utils.waitForElementVisible(By.id(SAVE_AND_CLOSE_CREATED_TARIFF));
        utils.clickBtn(By.id(SAVE_AND_CLOSE_CREATED_TARIFF));
        utils.switchToPreviousWindow(0);}


  public void assertChargesOfTariffThatIsBasedOnAnAnotherTariff(String value,String attribute,boolean baseVal) throws InterruptedException {
      commonMethods.search(RanTariffPlanName);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+RanTariffPlanName+"')]"));
Thread.sleep(1000);
      utils.clickBtn(By.xpath("//a[contains(text(),'"+RanTariffPlanName+"')]"));
       utils.switchToNewWindow();
        utils.waitForElementVisible(By.id(TARIFF_RATES_BUTTON));
        utils.clickBtn(By.id(TARIFF_RATES_BUTTON));
        utils.checkAlert();
        utils.waitForElementVisible(By.xpath("//input[@id='RatesList_0__r_peak' and "+attribute+"='"+value+"']"));
        utils.waitForElementVisible( By.xpath("//input[@id='RatesList_0__r_offpeak' and "+attribute+"='"+value+"']"));
      if(baseVal) {
          utils.waitForElementVisible(By.xpath("//input[@id='RatesList_0__r_weekend' and " + attribute + "='" + value + "']"));
      }
      else {utils.waitForElementVisible(By.xpath("//input[@id='RatesList_0__b_weekend' and @value='"+value+"']"));

      }

        utils.waitForElementVisible(By.xpath(commonMethods.SAVE_AND_CLOSE_XPATH));
      utils.clickBtn(By.xpath(commonMethods.SAVE_AND_CLOSE_XPATH));
        utils.switchToPreviousWindow(0);
    }
    public void assertCreatedTariff(String tariffType, String category){
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+tariffType+"')]"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+category+"')]"));

    }
    public void distinguishAgentCreatedTariffs() throws InterruptedException {
        commonMethods.search(RanTariffPlanName);
        utils.waitForElementVisible(By.xpath("//tr[@class='table_row_alt  Bold']//a[contains(text(),'"+RanTariffPlanName+"')]"));
    }
    public void distinguishCPCreatedTariff(String tariff) throws InterruptedException {
        commonMethods.search(tariff);
        utils.waitForElementVisible(By.xpath(SEMI_TRANSPARENT_UNION_STREET_TEXT));
}
    public void cpCannotAssignAgentsPlanToAnyOneElseNorCanHeRevokeIt(String plan, String tabButton, String name) throws InterruptedException {
        commonMethods.search(plan);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+plan+"')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'"+plan+"')]"));
         utils.switchToNewWindow();
        utils.waitForElementVisible(By.id(""+tabButton+""));
        utils.clickBtn(By.id(""+tabButton+""));
        utils.waitForElementVisible(By.xpath("//tr[@class='SemiTransparent']//a[contains(text(),'"+name+"')]"));
        utils.assertElementNotPresent(By.xpath(NON_CREATOR_HAS_NO_CHECK_BOX_IN_ASSIGN_PLAN_PAGE));
        utils.waitForElementVisible(By.xpath(CREATOR_HAS_CHECK_BOX_IN_ASSIGN_PLAN_PAGE));



    }
}
