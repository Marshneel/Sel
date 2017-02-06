package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class WLR3_NetworkCallingFeaturesPage {

    private final String ADMIN_CONTROLLED_CALL_DIV_UNDER_NTWRK_CAL_FEATURES = "Features_0__value";
    private final String ANONYMOUS_CAL_REJ_UNDER_NTWRK_CAL_FEATURES = "Features_1__value";

    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    ElementUtils utils = new ElementUtils();

    public void populateNetworkCallingFeatures() throws InterruptedException {
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("networkFeaturesSummaryPanel"));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.NETWORK_FEATURES_BUTTON));
        try {
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.NETWORK_FEATURES_BUTTON));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.NETWORK_FEATURES_BUTTON));
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.NETWORK_FEATURES_BUTTON));
        }
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        utils.checkPoint("entered the network calling features page to populate");
        utils.makeSureBoxIsChecked(By.id(ADMIN_CONTROLLED_CALL_DIV_UNDER_NTWRK_CAL_FEATURES),By.id(ADMIN_CONTROLLED_CALL_DIV_UNDER_NTWRK_CAL_FEATURES));
        utils.makeSureBoxIsChecked(By.id(ANONYMOUS_CAL_REJ_UNDER_NTWRK_CAL_FEATURES),By.id(ANONYMOUS_CAL_REJ_UNDER_NTWRK_CAL_FEATURES));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void enterNetworkFeatures() throws InterruptedException {

        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("networkFeaturesSummaryPanel"));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.NETWORK_FEATURES_BUTTON));
        Thread.sleep(1000);
        try {
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.NETWORK_FEATURES_BUTTON));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.NETWORK_FEATURES_BUTTON));
            Thread.sleep(1000);
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.NETWORK_FEATURES_BUTTON));
        }
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void depopulateNetworkCallingFeatures() throws InterruptedException {
        utils.checkPoint("entered the network calling features page to de-populate");
        utils.makeSureBoxIsUnChecked(By.id(ADMIN_CONTROLLED_CALL_DIV_UNDER_NTWRK_CAL_FEATURES), By.id(ADMIN_CONTROLLED_CALL_DIV_UNDER_NTWRK_CAL_FEATURES));
        utils.makeSureBoxIsUnChecked(By.id(ANONYMOUS_CAL_REJ_UNDER_NTWRK_CAL_FEATURES), By.id(ANONYMOUS_CAL_REJ_UNDER_NTWRK_CAL_FEATURES));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void depopulateAndVerifyNetworkCallingFeatures() throws InterruptedException {
        utils.makeSureBoxIsUnChecked(By.id("Features_1__value"), By.id("Features_1__value"));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void rePopulateNetworkCallingFeatures(){
        utils.makeSureBoxIsChecked(By.id("Features_1__value"),By.id("Features_1__value"));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));

    }
}
