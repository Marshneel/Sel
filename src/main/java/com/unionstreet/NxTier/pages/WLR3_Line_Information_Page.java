package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 28/02/2017.
 */


public class WLR3_Line_Information_Page {


    private final String TEXT_ON_LINEINFO_PAGE = "//h3[contains(text(),'Line Information')]";
    private final String SERVICE_MAINTENANCE_TAB = "WLR3Order_care_level";
    private final String CARE_LEVEL_DEFAULTED_TO_SELECT = "//select[@id='WLR3Order_care_level']//option[contains(text(),'Select')]";
    private final String POINT_TO_MULTIPOINT_TEXT_ON_LINE_INFO_PAGE="//label[contains(text(),'Point-to-Multipoint')]";
   private final String POINT_TO_POINT_TEXT_ON_LINE_INFO_PAGE="//label[contains(text(),'Point-to-Point')]";
   private final String DEFAULTED_TO_POINT_TO_MULTIPOINT="//input[@checked='checked'][@id='rdop2mp']";
   private final String DEFAULTED_TO_POINT_TO_POINT="//input[@checked='checked'][@id='rdop2p']";
    private final String ERROR_MESSAGE_WHEN_CHANGED_FROM_DEFAULT_POINT_TO_MULTIPOINT__TO__POINT_TO_POINT="//span[contains(text(),'This is not a valid selection for this line type / DDI configuration.')]";
    private final String POINT_TO_POINT_RADIO_BUTTON="rdop2p";
   private final String POINT_TO_MULTIPOINT_RADIO_BUTTON="rdop2mp";
    private final String ERROR_MESSAGE_STATING_SIGNAL_TYPE_MANDATORY_FOR_NTTP="//div[contains(text(),'You must select a Signal Type when the Termination Type of NTTP has been specified')]";
   private final String CHOOSE_SIGNAL_TYPE="WLR3Order_signal_type";
    private final String DIGITS_TO_SWITCH_TEXT_BOX="WLR3Order_digits_to_switch";


    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();


    public void verifyLineInformationTab(String level, String level_no) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.LINE_INFO_TAB));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(wlr3_orderDetails_page.LINE_INFO_TAB));
        utils.waitForElementVisible(By.xpath(TEXT_ON_LINEINFO_PAGE));
        utils.waitForElementVisible(By.id(SERVICE_MAINTENANCE_TAB));
        utils.selectByVisibleText(By.id(SERVICE_MAINTENANCE_TAB), level);
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
       utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath("//div[@id='lineInformationSummaryPanel']//p[contains(text(),'" + level_no + "')]"));
    }


    public void setCareLevelForPremiumLineSwitch(String unavailable, String available) throws InterruptedException {
        //assert message that recommends care level plan greater than or equal to 2.5 on the order summary page, for premium line switch
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.CARE_LEVEL_PLAN_WARNING_MESSAGE));
       wlr3_orderDetails_page.loadLineInfo();
        //verify that the care level plan is defaulted to select
        utils.waitForElementVisible(By.xpath(CARE_LEVEL_DEFAULTED_TO_SELECT));
        //verify that care level plan 1 that is recommended for basic line is not available for the premium line switch
        utils.assertElementNotPresent(By.xpath("//select[@id='WLR3Order_care_level']//option[contains(text(),'" + unavailable + "')]"));
        //choose care level plan 2.5 from the drop down
        utils.selectByVisibleText(By.id(SERVICE_MAINTENANCE_TAB), "" + available + "");
        //save the changes
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void setCareLevelForBasicLineSwitch(String available) throws InterruptedException {
        //enter line info panel;
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.LINE_INFO_TAB));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(wlr3_orderDetails_page.LINE_INFO_TAB));
        utils.waitForElementVisible(By.id(SERVICE_MAINTENANCE_TAB));
        //choose care level plan 1 from the drop down
        utils.selectByVisibleText(By.id(SERVICE_MAINTENANCE_TAB), "" + available + "");
        //save the changes
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void verifyLineInfoForISDN30(String number1, String number2, String number3) throws InterruptedException {
        wlr3_orderDetails_page.loadLineInfo();
        utils.waitForElementVisible(By.xpath("//select[@id='WLR3Order_care_level']//option[contains(text(),'" + number1 + "')]"));
        utils.waitForElementVisible(By.xpath("//select[@id='WLR3Order_care_level']//option[contains(text(),'" + number2 + "')]"));
        utils.waitForElementVisible(By.xpath("//select[@id='WLR3Order_care_level']//option[contains(text(),'" + number3 + "')]"));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void assertLineInfoForISDN30(){
        utils.waitForElementVisible(By.id("WLR3Order_standby_power_required"));
        utils.waitForElementVisible(By.id("WLR3Order_radio_delivery_accepted"));


    }
    public void assertPointToMultiPointConfigForISDN2Standard(){
        utils.waitForElementVisible(By.xpath(DEFAULTED_TO_POINT_TO_MULTIPOINT));
        utils.waitForElementVisible(By.xpath(POINT_TO_POINT_TEXT_ON_LINE_INFO_PAGE));
        utils.makeSureBoxIsChecked(By.id(POINT_TO_POINT_RADIO_BUTTON),By.id(POINT_TO_POINT_RADIO_BUTTON));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_WHEN_CHANGED_FROM_DEFAULT_POINT_TO_MULTIPOINT__TO__POINT_TO_POINT));
    }
    public void convertingPointToPoint_To_PointToMultiPointWithSingleSNDDI(){
        utils.waitForElementVisible(By.xpath(DEFAULTED_TO_POINT_TO_POINT));
        utils.waitForElementVisible(By.xpath(POINT_TO_MULTIPOINT_TEXT_ON_LINE_INFO_PAGE));
        utils.makeSureBoxIsChecked(By.id(POINT_TO_MULTIPOINT_RADIO_BUTTON),By.id(POINT_TO_MULTIPOINT_RADIO_BUTTON));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
    public void setSignalType() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_STATING_SIGNAL_TYPE_MANDATORY_FOR_NTTP));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(wlr3_orderDetails_page.LINE_INFO_TAB));
        utils.waitForElementVisible(By.id(CHOOSE_SIGNAL_TYPE));
        utils.selectByVisibleText(By.id(CHOOSE_SIGNAL_TYPE),"Dual Tone");
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
    public void assertDigitsToSwitchForAllISDN(String allowedRange, String digits){
        utils.waitForElementVisible(By.id(DIGITS_TO_SWITCH_TEXT_BOX));
        utils.sendText(By.id(DIGITS_TO_SWITCH_TEXT_BOX),"0");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please enter a value between "+allowedRange+".')]"));
    utils.sendText(By.id(DIGITS_TO_SWITCH_TEXT_BOX),"100");
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please enter a value between "+allowedRange+".')]"));
        utils.sendText(By.id(DIGITS_TO_SWITCH_TEXT_BOX),""+digits+"");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }


}
