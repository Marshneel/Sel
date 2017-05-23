package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.sql.SQLException;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class WLR3_NetworkCallingFeaturesPage {

    private final String ADMIN_CONTROLLED_CALL_DIV_UNDER_NTWRK_CAL_FEATURES = "Features_0__value";
    private final String ANONYMOUS_CAL_REJ_UNDER_NTWRK_CAL_FEATURES = "Features_1__value";

    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    ElementUtils utils = new ElementUtils();

    public void populateNetworkCallingFeatures() throws InterruptedException {
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.NETWORK_FEATURES_SUMMARY_PANEL));
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

    public void enterNetworkFeatures() throws InterruptedException, SQLException {

        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.NETWORK_FEATURES_SUMMARY_PANEL));
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
    public void assertFeaturesForRemoteCallFor_VirtualLines(){
                utils.waitForElementVisible(By.xpath("//label[contains(text(),'Raw Call Data')]"));
        utils.clickBtn(By.xpath("//label[contains(text(),'Raw Call Data')]"));
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Remote Call Forwarding')]"));

    }
    public void assertFeaturesForCallerRedirect(){
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Caller Redirect')]"));
        utils.sendText(By.id("Features_0__cli"),"0201234567");

    }
    public void editCallFeaturesForRemoteCallFor_VirtualLines(String CLI) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Raw Call Data')]"));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.clickBtn(By.id("Features_0__value"));
        utils.sendText(By.id("Features_1__cli"),CLI);
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
    public void editCallFeaturesForCallerRedirect_VirtualLines(String text){
        utils.waitForElementVisible(By.id("Features_0__cli"));
        utils.sendText(By.id("Features_0__cli"),""+text+"");
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
    public void toggleBetweenQuarterlyToMonthly_CallerRedirectVirtualLines() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Quarterly')]"));
        utils.waitForElementVisible(By.xpath("//input[@checked='checked'][@value='False']"));
        utils.makeSureBoxIsChecked(By.xpath("//input[@id='Features_0__monthly'][@value='True']"),By.xpath("//input[@id='Features_0__monthly'][@value='True']"));
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
    public void assertChangedFrequencyForCallerRedirect_VirtualLine(){
        utils.waitForElementVisible(By.xpath("//input[@checked='checked'][@value='True']"));
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
}
