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
    WLR3_NewProvide_AnaMultLine_SitePage wlr3_newProvide_anaMultLine_sitePage = new WLR3_NewProvide_AnaMultLine_SitePage();

    public void populatingSiteInformation() throws InterruptedException {
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("siteInformationSummaryPanel"));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        try {
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        }
        utils.waitForElementVisible(By.xpath(TEXT_ON_SITE_INFORMATION));
        utils.selectByIndex(By.id(SELECTCONTACT_UNDER_SITEINFO), 1);
        utils.waitForElementVisible(By.id(SUBMIT_BUTTON));
        utils.scrollUp(By.id(SUBMIT_BUTTON));
        utils.javaScriptExecutorClick(By.id(SUBMIT_BUTTON));
    }

    public void depopulateSiteInformation() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        utils.waitForElementVisible(By.id("siteInformationSummaryPanel"));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        try {
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        }
        utils.waitForElementVisible(By.xpath(TEXT_ON_SITE_INFORMATION));
        utils.selectByVisibleText(By.id(SELECTCONTACT_UNDER_SITEINFO), "Select");
        utils.waitForElementVisible(By.id(SUBMIT_BUTTON));
        utils.scrollUp(By.id(SUBMIT_BUTTON));
        utils.javaScriptExecutorClick(By.id(SUBMIT_BUTTON));
    }

    public void enterTelephoneNumberUnderSiteInfoAndAssertAbsenceOfRLPcheckBox(String number) {
        utils.sendText(By.id(wlr3_newProvide_anaMultLine_sitePage.TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO), number);
        utils.assertElementNotPresent(By.id("WLR3Order_recover_line_plant"));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));

    }

    public void enterTelephoneNumberUnderSiteInfoAndAssertPresenceOfRLPcheckBox(String number) {
        utils.sendText(By.id(wlr3_newProvide_anaMultLine_sitePage.TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO), number);
        utils.waitForElementVisible(By.id("WLR3Order_recover_line_plant"));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));


    }
}