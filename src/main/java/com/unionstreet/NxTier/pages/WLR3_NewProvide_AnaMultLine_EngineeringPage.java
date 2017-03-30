package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_AnaMultLine_EngineeringPage {

    private final String ENGINEERING_NOTES_TEXTBOX_UNDER_SITEINFO = "WLR3Order_engineering_notes";
    private final String ENGINEERING_INFO_TEXT_UNDER_SITEINFO = "//legend[text()='Engineering Information']";
    private final String MAINS_POWER_WITHIN_THREE_METERS_LABEL_UNDER_ENGINEERING_INFO="//label[contains(text(),'Mains power within 3 meters')]";
    private final String EVENTS_AND_EXHIBITIONS_LABEL_UNDER_ENGINEERING_INFO="//label[contains(text(),'Events and exhibitions')]";
    ElementUtils utils = new ElementUtils();
    WLR3_New_Provide_Analogue_Multiline_OrderPage wlr3_new_provide_analogue_multiline_orderPage=new WLR3_New_Provide_Analogue_Multiline_OrderPage();

    public void populatingEngineeringNotesUnderENGINEERING(String notes) {
        utils.waitForElementVisible(By.xpath(ENGINEERING_INFO_TEXT_UNDER_SITEINFO));
        utils.sendText(By.id(ENGINEERING_NOTES_TEXTBOX_UNDER_SITEINFO),notes);
    }
    public void assertionsForISDNE30NewProvidengineeringNotes(){
        utils.waitForElementVisible(By.xpath(MAINS_POWER_WITHIN_THREE_METERS_LABEL_UNDER_ENGINEERING_INFO));
        utils.waitForElementVisible(By.xpath(EVENTS_AND_EXHIBITIONS_LABEL_UNDER_ENGINEERING_INFO));
    }

    public void sBusExtension() throws InterruptedException {
        utils.waitForElementVisible(By.id("WLR3Order_additional_site_visit_reason"));
        utils.selectByVisibleText(By.id("WLR3Order_additional_site_visit_reason"),"SBusExtension");
        utils.waitForElementVisible(By.id("WLR3Order_sbus_short"));
        utils.waitForElementVisible(By.id("WLR3Order_sbus_medium"));
        wlr3_new_provide_analogue_multiline_orderPage.navigateToNextScreen();
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'TRC Band authorization is required for the site visit!')]"));
        utils.waitForElementVisible(By.xpath("//div[@id='sbusRJ45Container']//span[contains(text(),'This field is required')]"));
        utils.waitForElementVisible(By.xpath("//span[@data-valmsg-for='WLR3Order.sbus_location']//span[contains(text(),'This field is required')]"));
        utils.selectByIndex(By.id("WLR3Order_trc_band"),1);
        utils.sendText(By.id("WLR3Order_sbus_location"),"1st floor");
        utils.sendText(By.id("WLR3Order_sbus_rj45"),"RJ45");
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'The field RJ45 must be a number.')]"));
        utils.sendText(By.id("WLR3Order_sbus_rj45"),"5");



    }

}
