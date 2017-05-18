package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class WLR3_SiteInformationPage {


    private final String SELECTCONTACT_UNDER_SITEINFO = "ContactList";
    private final String SUBMIT_BUTTON = "saveBtn";
    private final String RECOVER_LINE_PLANT = "WLR3Order_recover_line_plant";
    private final String TRC_BAND_DROPDOWN = "WLR3Order_trc_band";
    private final String ENGINEERING_NOTES_TEXT_BOX="WLR3Order_engineering_notes";
    private final String ADDITIONAL_SITE_VISIT_REASON_CHECKBOX="WLR3Order_known_damage_to_cabling";
    private final String FLOOR_TEXT_BOX="WLR3Order_floor";
    private final String ROOM_TEXT_BOX="WLR3Order_room";
    private final String PROVISION_TYPE_PANEL="//legend[text()='Provision Type']";
    private final String TAKE_OVER_AN_EXISTING_LINE="//label[contains(text(),'Take Over Working Line')]";
    private final String PROVIDE_A_NEW_LINE="//label[contains(text(),'Provide Line')]";



    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    WLR3_NewProvide_SitePage wlr3_newProvide__sitePage = new WLR3_NewProvide_SitePage();
    WLR3_NewProvide_ProvisionPage wlr3_newProvide_provisionPage=new WLR3_NewProvide_ProvisionPage();


    public void populatingSiteInformation() throws InterruptedException {
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        wlr3_orderDetails_page.clickSiteInfo();
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
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.TEXT_ON_SITE_INFORMATION));
        utils.selectByVisibleText(By.id(SELECTCONTACT_UNDER_SITEINFO), "Select");
        utils.waitForElementVisible(By.id(SUBMIT_BUTTON));
        utils.scrollUp(By.id(SUBMIT_BUTTON));
        utils.javaScriptExecutorClick(By.id(SUBMIT_BUTTON));
    }

    public void assertAbsenceOfRLPcheckBoxUnderSiteInfo() {
        utils.assertElementNotPresent(By.id(RECOVER_LINE_PLANT));
    }

    public void enterTelephoneNumberUnderSiteInfoAndAssertPresenceOfRLPcheckBox() {
        utils.waitForElementVisible(By.id(RECOVER_LINE_PLANT));
    }

    public void populateTelNumberUnderSiteInfo(String number) {
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.waitForElementVisible(By.id(wlr3_newProvide__sitePage.TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO));
        utils.sendText(By.id(wlr3_newProvide__sitePage.TELEPHONE_NUMBER_TEXTBOX_UNDER_SITEINFO), number);
    }

    public void assertTerminationTypeForPremiumLine(String terminationType1,String terminationType2) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//select[@id='WLR3Order_termination_type']//option[contains(text(),'" + terminationType1 + "')]"));
        utils.waitForElementVisible(By.xpath("//select[@id='WLR3Order_termination_type']//option[contains(text(),'" + terminationType2 + "')]"));
    }
    public void switchBetweenTerminationTypes(String changeTo){
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.TEXT_ON_SITE_INFORMATION));
        utils.selectByVisibleText(By.id("WLR3Order_termination_type"),changeTo);

    }
    public void assertTerminationTypeForBasicLines(String available, String unavailable){
        utils.waitForElementVisible(By.xpath("//select[@id='WLR3Order_termination_type']//option[contains(text(),'" + available + "')]"));
        utils.assertElementNotPresent(By.xpath("//select[@id='WLR3Order_termination_type']//option[contains(text(),'" + unavailable + "')]"));
    }

    public void assertAndPopulateTerminationTypeForBasicLineSwitch(String unAvailableTerminationType, String selectTerminationType) throws InterruptedException {

        //assert that the termination type for premium line is unavailable for selection for basic line switch
        utils.assertElementNotPresent(By.xpath("//select[@id='WLR3Order_termination_type']//option[contains(text(),'" + unAvailableTerminationType + "')]"));
        //select termination type from the drop down
        utils.selectByVisibleText(By.id(wlr3_newProvide_provisionPage.TERMINATION_TYPE_DROPDOWN_UNDER_SITEINFO), "" + selectTerminationType + "");
    }
    public void setUpTRCband(){
    //setup TRC band
        utils.selectByVisibleText(By.id(TRC_BAND_DROPDOWN), "Band 1 - Up to 2 Hours");
    }
    public void siteInfoForISDNNewProvide(String bandRange) throws InterruptedException {
      loadSiteInfo();
        utils.selectByVisibleText(By.id("WLR3Order_trc_band"),""+bandRange+"");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+bandRange+"')]"));
    }
    public void loadSiteInfo() throws InterruptedException {
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
    }
    public void populateFloorAndRoomForNewProvideIDSN2() throws InterruptedException {
        utils.sendText(By.id(FLOOR_TEXT_BOX),"floor");
        utils.sendText(By.id(ROOM_TEXT_BOX),"room");
    }
    public void saveSiteInfoChanges() {
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
    public void assertProvisionTypeAbsentInISDN30Modify() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.assertElementNotPresent(By.xpath(PROVISION_TYPE_PANEL));
        utils.assertElementNotPresent(By.xpath(TAKE_OVER_AN_EXISTING_LINE));
        utils.assertElementNotPresent(By.xpath(PROVIDE_A_NEW_LINE));
    }
    public void assertionForISDN30ModifyEngineeringNotes() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.assertElementNotPresent(By.id("WLR3Order_mains_within_3m"));
        utils.assertElementNotPresent(By.id("WLR3Order_events_and_exhibitions"));
        utils.clickBtn(By.id(wlr3_orderDetails_page.CANCEL));}

    public void assignAdditionalSiteVisitReasonThroughCheckBox(){
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.waitForElementVisible(By.id(ADDITIONAL_SITE_VISIT_REASON_CHECKBOX));
        utils.makeSureBoxIsChecked(By.id(ADDITIONAL_SITE_VISIT_REASON_CHECKBOX),By.id(ADDITIONAL_SITE_VISIT_REASON_CHECKBOX));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
    public void de_AssignAdditionalSiteVisitReasonThroughCheckBox(){
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
       utils.waitForElementVisible(By.id(ADDITIONAL_SITE_VISIT_REASON_CHECKBOX));
        utils.makeSureBoxIsUnChecked(By.id(ADDITIONAL_SITE_VISIT_REASON_CHECKBOX),By.id(ADDITIONAL_SITE_VISIT_REASON_CHECKBOX));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
    public void populateAndSaveEngineeringNotes(){
        utils.sendText(By.id(ENGINEERING_NOTES_TEXT_BOX),"Engineering Notes");
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
    public void assertInstallTypeAbsentInModifyOrder(){
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.TEXT_ON_SITE_INFORMATION));
        utils.assertElementNotPresent(By.xpath("//label[contains(text(),'Install Type')]"));
        utils.assertElementNotPresent(By.id("WLR3Order_installation_type"));
    }
    public void assertInstallTypePresentInTransferOrder(){

        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Install Type')]"));
        utils.waitForElementVisible(By.id("WLR3Order_installation_type"));
    }
    public void assertValidationMessageForSiteInfoPhoneNumber(){
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'Please specify Site Contact telephone number')]"));
    }

}
