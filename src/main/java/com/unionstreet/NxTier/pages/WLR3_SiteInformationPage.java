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
    private final String RECOVER_LINE_PLANT = "WLR3Order_recover_line_plant";
    private final String TRC_BAND_DROPDOWN = "WLR3Order_trc_band";
    private final String TERMINATION_TYPE = "WLR3Order_termination_type";


    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    WLR3_NewProvide_AnaMultLine_SitePage wlr3_newProvide_anaMultLine_sitePage = new WLR3_NewProvide_AnaMultLine_SitePage();


    public void populatingSiteInformation() throws InterruptedException {
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SITE_INFO_SUMMARY_PANEL));
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
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SITE_INFO_SUMMARY_PANEL));
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
        utils.assertElementNotPresent(By.id(RECOVER_LINE_PLANT));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));

    }

    public void enterTelephoneNumberUnderSiteInfoAndAssertPresenceOfRLPcheckBox(String number) {
        utils.sendText(By.id(wlr3_newProvide_anaMultLine_sitePage.TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO), number);
        utils.waitForElementVisible(By.id(RECOVER_LINE_PLANT));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void populateTelNumberOnChangeOfAddress(String number) {
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.sendText(By.id(wlr3_newProvide_anaMultLine_sitePage.TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO), number);
    }

    public void populateSiteInfoPhoneAndAssertIncOfTerminationType(String phone, String terminationType) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        try {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        }
        utils.waitForElementVisible(By.id(wlr3_newProvide_anaMultLine_sitePage.TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO));
        utils.sendText(By.id(wlr3_newProvide_anaMultLine_sitePage.TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO), "" + phone + "");
        //setup termination type
        utils.waitForElementVisible(By.xpath("//select[@id='WLR3Order_termination_type']//option[contains(text(),'" + terminationType + "')]"));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));

    }

    public void siteInfoPopupPopulateWithAssertionsForBasicLineSwitch(String unAvailableTerminationType, String selectTerminationType) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        try {
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        }
        utils.waitForElementVisible(By.id(wlr3_newProvide_anaMultLine_sitePage.TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO));
        //populate phone number under site contacts
        utils.sendText(By.id(wlr3_newProvide_anaMultLine_sitePage.TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO), "07894040256");
        //assert that the termination type for premium line is unavailable for selection for basic line switch
        utils.assertElementNotPresent(By.xpath("//select[@id='WLR3Order_termination_type']//option[contains(text(),'" + unAvailableTerminationType + "')]"));
        //select termination type from the drop down
        utils.selectByVisibleText(By.id(TERMINATION_TYPE), "" + selectTerminationType + "");
        //setup TRC band
        utils.selectByVisibleText(By.id(TRC_BAND_DROPDOWN), "Band 1 - Up to 2 Hours");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
    public void siteInfoForISDN(String bandRange) throws InterruptedException {
       Thread.sleep(1000);
        utils.clickBtn(By.xpath(wlr3_orderDetails_page.SITE_INFORMATION_BUTTON));
        utils.selectByVisibleText(By.id("WLR3Order_trc_band"),""+bandRange+"");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+bandRange+"')]"));


    }
}