package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_AnaMultLine_FeaturesPage {

    private final String NETWORK_FEATURES_TEXT = "//legend[text()='Network Features']";
    private final String CALL_DIVERSION_RADIOBUTTON_UNDER_NETWORK_FEATURES = "Features_7__value";
    private final String CALL_DIVERSION_RADIOBTN_UNDER_NETWORK_FEATURES = "AllLineBased_123";
    private final String BUSY_OUT_LINE_RADIOBTN_UNDER_NETWORK_FEATURES = "Features_6__value";
    private final String BUSINESS_CONTINUITY_TEXT="//label[text()='Business Continuity - Site Assurance Option']";
    private final String BUSINESS_CONTINUITY_CHECKBOX="WLR3Order_site_assurance_option_1";
    private final String BUSINESS_CONTINUITY_USER_NAME="WLR3Order_site_assurance_option1_name";
    private final String CARE_LEVEL_PLAN_TWO="//select[@id='WLR3Order_care_level']//option[contains(text(),'Level 2')]";
    private final String CARE_LEVEL_PLAN_THREE="//select[@id='WLR3Order_care_level']//option[contains(text(),'Level 3')]";
    private final String CARE_LEVEL_PLAN_FOUR="//select[@id='WLR3Order_care_level']//option[contains(text(),'Level 4')]";
    private final String CARE_LEVEL_DROP_DOWN="WLR3Order_care_level";

    ElementUtils utils = new ElementUtils();

    public void populateNetworkFeaturesUnderFEATURES() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(NETWORK_FEATURES_TEXT));
        //select call diversion
        utils.makeSureBoxIsChecked(By.id(CALL_DIVERSION_RADIOBUTTON_UNDER_NETWORK_FEATURES),By.id(CALL_DIVERSION_RADIOBUTTON_UNDER_NETWORK_FEATURES));
        utils.waitForElementVisible(By.id(CALL_DIVERSION_RADIOBTN_UNDER_NETWORK_FEATURES));
        //select busyOutLine radio tab
        utils.makeSureBoxIsChecked(By.id(CALL_DIVERSION_RADIOBTN_UNDER_NETWORK_FEATURES),By.id(CALL_DIVERSION_RADIOBTN_UNDER_NETWORK_FEATURES));
        Thread.sleep(1000);
        //un-check the 3rd radio button under busyOutLine
        utils.makeSureBoxIsUnChecked(By.id(BUSY_OUT_LINE_RADIOBTN_UNDER_NETWORK_FEATURES), By.id(BUSY_OUT_LINE_RADIOBTN_UNDER_NETWORK_FEATURES));
    }
    public void populateAndAssertFeaturesPageForISDN30(){
utils.waitForElementVisible(By.xpath(BUSINESS_CONTINUITY_TEXT));
        utils.clickBtn(By.id(BUSINESS_CONTINUITY_CHECKBOX));
        utils.waitForElementVisible(By.id(BUSINESS_CONTINUITY_USER_NAME));
    }
    public void serviceMaintenanceForISBN2(){
        utils.waitForElementVisible(By.id(CARE_LEVEL_DROP_DOWN));
        utils.waitForElementVisible(By.xpath(CARE_LEVEL_PLAN_TWO));
        utils.waitForElementVisible(By.xpath(CARE_LEVEL_PLAN_THREE));
        utils.waitForElementVisible(By.xpath(CARE_LEVEL_PLAN_FOUR));
    }

}
