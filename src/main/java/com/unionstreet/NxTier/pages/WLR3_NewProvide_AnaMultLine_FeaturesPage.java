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

}
