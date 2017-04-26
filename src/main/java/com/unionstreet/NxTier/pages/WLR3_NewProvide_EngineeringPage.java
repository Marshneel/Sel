package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_EngineeringPage {

    private final String ENGINEERING_NOTES_TEXTBOX_UNDER_SITEINFO = "WLR3Order_engineering_notes";
    private final String MAINS_POWER_WITHIN_THREE_METERS_LABEL_UNDER_ENGINEERING_INFO="//label[contains(text(),'Mains power within 3 meters')]";
    private final String EVENTS_AND_EXHIBITIONS_LABEL_UNDER_ENGINEERING_INFO="//label[contains(text(),'Events and exhibitions')]";
    private final String SBUS_EXTENSION_SHORT="WLR3Order_sbus_short";
    private final String SBUS_EXTENSION_MEDIUM="WLR3Order_sbus_medium";
    private final String TRC_BAND_MANDATORY_MESSAGE="//span[contains(text(),'TRC Band authorization is required for the site visit!')]";
    private final String SBUS_LOCATION_FIELD_MANDATORY_MESSAGE="//span[@data-valmsg-for='WLR3Order.sbus_location']//span[contains(text(),'This field is required')]";
    private final String RJ45_FIELD_MANDATORY_MESSAGE="//div[@id='sbusRJ45Container']//span[contains(text(),'This field is required')]";
   private final String RJ45_MUST_BE_NUMBER_MESSAGE="//span[contains(text(),'The field RJ45 must be a number.')]";
    private final String RJ45_TEXT_BOX="WLR3Order_sbus_rj45";
    private final String SBUS_LOCATION_TEXT_BOX="WLR3Order_sbus_location";
    private final String TRC_BAND_DROP_DOWN="WLR3Order_trc_band";
    private final String ADDITIONAL_SITE_VISIT_REASON_DROP_BOX="WLR3Order_additional_site_visit_reason";
    ElementUtils utils = new ElementUtils();
    WLR3_New_Provide_OrderPage wlr3_new_provide__orderPage =new WLR3_New_Provide_OrderPage();
    WLR3_NewProvide_ProvisionPage wlr3_newProvide_provisionPage=new WLR3_NewProvide_ProvisionPage();

    public void populatingEngineeringNotesUnderENGINEERING(String notes) {
        utils.waitForElementVisible(By.xpath(wlr3_newProvide_provisionPage.ENGINEERING_INFO_TEXT_UNDER_SITEINFO));
        utils.sendText(By.id(ENGINEERING_NOTES_TEXTBOX_UNDER_SITEINFO),notes);
    }
    public void assertionsForISDNE30NewProvidengineeringNotes(){
        utils.waitForElementVisible(By.xpath(MAINS_POWER_WITHIN_THREE_METERS_LABEL_UNDER_ENGINEERING_INFO));
        utils.waitForElementVisible(By.xpath(EVENTS_AND_EXHIBITIONS_LABEL_UNDER_ENGINEERING_INFO));
    }

    public void sBusExtension() throws InterruptedException {
        utils.waitForElementVisible(By.id(ADDITIONAL_SITE_VISIT_REASON_DROP_BOX));
        utils.selectByVisibleText(By.id(ADDITIONAL_SITE_VISIT_REASON_DROP_BOX),"SBusExtension");
        utils.waitForElementVisible(By.id(SBUS_EXTENSION_SHORT));
        utils.waitForElementVisible(By.id(SBUS_EXTENSION_MEDIUM));
        wlr3_new_provide__orderPage.navigateToNextScreen();
        utils.waitForElementVisible(By.xpath(TRC_BAND_MANDATORY_MESSAGE));
        utils.waitForElementVisible(By.xpath(RJ45_FIELD_MANDATORY_MESSAGE));
        utils.waitForElementVisible(By.xpath(SBUS_LOCATION_FIELD_MANDATORY_MESSAGE));
        utils.selectByIndex(By.id(TRC_BAND_DROP_DOWN),1);
        utils.sendText(By.id(SBUS_LOCATION_TEXT_BOX),"1st floor");
        utils.sendText(By.id(RJ45_TEXT_BOX),"RJ45");
        utils.waitForElementVisible(By.xpath(RJ45_MUST_BE_NUMBER_MESSAGE));
        utils.sendText(By.id(RJ45_TEXT_BOX),"5");
    }
    public void setAdditionalSiteVisitReason() throws InterruptedException {
        utils.selectByIndex(By.id(ADDITIONAL_SITE_VISIT_REASON_DROP_BOX),1);
        wlr3_new_provide__orderPage.navigateToNextScreen();
        utils.waitForElementVisible(By.xpath(TRC_BAND_MANDATORY_MESSAGE));
        utils.selectByIndex(By.id(TRC_BAND_DROP_DOWN),1);
    }

}
