package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class WLR3_SiteInformationPage {

    private final String TEXT_ON_SITE_INFORMATION = "//legend[text()='Site Contact']";
    private final String SELECTCONTACT_UNDER_SITEINFO = "ContactList";
    private final String SUBMIT_BUTTON = "saveBtn";

    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();

    public void populatingSiteInformation() throws InterruptedException {
        utils.waitForElementVisibleForWLR3Page(By.xpath(wlr3_orderDetails_page.TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        utils.waitForElementVisible(By.id("siteInformationSummaryPanel"));
        utils.scrollUp(By.id("siteInformationSummaryPanel"));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        utils.waitForElementVisible(By.xpath(TEXT_ON_SITE_INFORMATION));
        utils.selectByIndex(By.id(SELECTCONTACT_UNDER_SITEINFO), 1);
        utils.waitForElementVisible(By.id(SUBMIT_BUTTON));
        utils.scrollUp(By.id(SUBMIT_BUTTON));
        utils.javaScriptExecutorClick(By.id(SUBMIT_BUTTON));
    }

    public void depopulateSiteInformation() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        utils.waitForElementVisible(By.id("siteInformationSummaryPanel"));
        utils.scrollUp(By.id("siteInformationSummaryPanel"));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        utils.waitForElementVisible(By.xpath(TEXT_ON_SITE_INFORMATION));
        utils.selectByVisibleText(By.id(SELECTCONTACT_UNDER_SITEINFO), "Select");
        utils.waitForElementVisible(By.id(SUBMIT_BUTTON));
        utils.scrollUp(By.id(SUBMIT_BUTTON));
        utils.javaScriptExecutorClick(By.id(SUBMIT_BUTTON));
    }
}
