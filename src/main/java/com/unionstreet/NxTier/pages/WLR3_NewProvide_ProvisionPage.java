package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_ProvisionPage {

    public final String ENGINEERING_INFO_TEXT_UNDER_SITEINFO = "//legend[text()='Engineering Information']";
    private final String LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO = "//legend[text()='Line Plant Summary']";
    public final String TERMINATION_TYPE_DROPDOWN_UNDER_SITEINFO = "WLR3Order_termination_type";
    private final String TERMINATION_TYPE_MANDATORY_ERROR_MESSAGE = "//span[text()='Termination Type is required']";
    private final String INSTALLATION_TYPE_GUIDANCE_TAB = "installationTypeGuidance";
    private final String TEXT_ON_INSTALLATION_TYPE_GUIDANCE_PAGE = "//h3[contains(text(),'Installation Type Help')]";
    private final String INSTALLATION_TYPE_GUIDANCE_POPUP_CLOSEBTN = "//div[@id='dialog-container']//button[@id='closeBtn']";
    private final String DECREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO = "//a[contains(@onclick,'newProvideWizard.decreaseNumber')]";
    private final String INCREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO = "//a[contains(@onclick,'newProvideWizard.increaseNumber')]";
    private final String VIEW_WORKING_LINES_UNDER_LINE_PLANT_SUMMARY = "lnkwlt";
    private final String TEXT_ON_WORKING_LINES_POPUP = "//h3[contains(text(),'Line Plant Information')]";
    private final String WORKING_LINES_POPUP_CLOSEBTN = "//div[@id='modal-dialog-LinePlant']//button[@id='closeBtn']";
    private final String ORDER_NOTES_LABEL_FOR_ISDN = "//label[text()='Order Notes']";
    private final String ORDERNOTES_TOOL_TIP_CLICK = "openreachNotes";
    private final String TEXT_ON_ORDER_NOTES_TOOLTIP_POPUP = "//h4[text()='Openreach Notes']";
    private final String FLOOR_TEXT_BOX = "WLR3Order_floor";
    private final String ROOM_TEXT_BOX = "WLR3Order_room";
    private final String MINIMUM_CHANNELS_ERROR_MESSAGE = "//span[text()='Minimum 8 Channels required for this product.']";
    private final String MAXIMUM_CHANNELS_ERROR_MESSAGE = "//span[text()='Maximum 999 Channels allowed for this product.']";
    private final String MINIMUM_TWO_CHANNELS_REQUIRED="//span[contains(text(),'Minimum 2 Channels required for this product.')]";
    private final String MAXIMUM_SIXTY_CHANNELS_ALLOWED="//span[contains(text(),'Maximum 60 Channels allowed for this product.')]";
    private final String NUMBER_OF_CHANNELS_MUST_BE_MULTIPLES_OF_TWO="//span[contains(text(),'Number of channels for ISDN2 System must be in multiples of 2.')]";
private final String TAKE_OVER_WORKING_LINE_TEXT="//label[contains(text(),'Take Over Working Line')]";
    private final String TAKE_OVER_WORKING_LINE_RADIO_BUTTON="//div[@id='divlineplantoptionsctrl']//input[@id='order_type_0']";
    private final String TAKE_OVER_WORKING_CLI_BUTTON="lnklineplantgridcall";
    private final String LINEBOX_SELECTED_AS_DEFAULT_UNDER_TERMINATION_TYPE="//option[@selected='selected'][contains(text(),'Line Box')]";
    private final String NTTP_OPTION_UNDER_TERMINATION_TYPE="//select[@id='WLR3Order_termination_type']//option[contains(text(),'NTTP')]";
    private final String LINEBOX_OPTION_UNDER_TERMINATION_TYPE="//select[@id='WLR3Order_termination_type']//option[contains(text(),'Line Box')]";
    private final String SPECIFY_WORKING_LINE_MESSAGE="//div[@id='ItemError'][contains(text(),'Please specify which working line to take over')]";
    private final String PROVIDE_LINE_RADIO_BUTTON_UNDER_PROVISION="//div[@id='divlineplantoptionsctrl']//input[@id='order_type_3']";
    private final String EXCESS_CONSTRUCTION_CHARGES_DROPDOWN="WLR3Order_ecc_band";
    private final String OPEN_REACH_MANAGED="WLR3Order_coa_openreach";
    private final String MINIMUM_TWO_LINES_REQUIRED_FOR_THIS_PRODUCT="//span[contains(text(),'Minimum 2 Lines required for this product.')]";
    private final String MAXIMUM_99_LINES_REQUIRED_FOR_THIS_PRODUCT="//span[contains(text(),'Maximum 99 Lines allowed for this product.')]";
    private final String CHANNELS_TEXT="//label[contains(text(),'Channels')]";


    ElementUtils utils = new ElementUtils();
    WLR3_New_Provide_OrderPage wlr3_new_provide__orderPage = new WLR3_New_Provide_OrderPage();
    CommonMethods commonMethods=new CommonMethods();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();
    WLR3_LineNumberingPage wlr3_lineNumberingPage=new WLR3_LineNumberingPage();

    public void populateLinePlantSummaryUnderPROVISION() throws InterruptedException {
        //verify the error message when termination type is not selected
        utils.waitForElementVisible(By.xpath(LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO));
        utils.clickBtn(By.xpath(wlr3_new_provide__orderPage.NEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(TERMINATION_TYPE_MANDATORY_ERROR_MESSAGE));

        //select the termination type from the dropDown
        utils.selectByVisibleText(By.id(TERMINATION_TYPE_DROPDOWN_UNDER_SITEINFO),"NTTP");

        //verify the install type pop up
        utils.clickBtn(By.id(INSTALLATION_TYPE_GUIDANCE_TAB));
        utils.waitForElementVisible(By.xpath(TEXT_ON_INSTALLATION_TYPE_GUIDANCE_PAGE));
        utils.clickBtn(By.xpath(INSTALLATION_TYPE_GUIDANCE_POPUP_CLOSEBTN));
        utils.waitForElementVisible(By.xpath(LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO));
        Thread.sleep(1000);

        //view working lines popup
        utils.clickBtn(By.id(VIEW_WORKING_LINES_UNDER_LINE_PLANT_SUMMARY));
        utils.waitForElementVisible(By.xpath(TEXT_ON_WORKING_LINES_POPUP));
        utils.clickBtn(By.xpath(WORKING_LINES_POPUP_CLOSEBTN));
    }
    public void validateNumberOfLinesUnderProvisionForMultiline() {
        //decrease the number of lines and assert
       utils.waitForElementVisible(By.xpath(DECREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO));
        utils.clickBtn(By.xpath(DECREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO));
        String decreaseValue = utils.getAttributeOfElement(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX), "value");
        Assert.assertEquals(decreaseValue, "1");
        //increase the number of lines and assert
        utils.clickBtn(By.xpath(INCREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO));
        utils.clickBtn(By.xpath(INCREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO));
        String increaseValue = utils.getAttributeOfElement(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX), "value");
        Assert.assertEquals(increaseValue, "3");
    }
    public void enterChannelsInISDNNewProvide(String channels, String message) throws InterruptedException {
        utils.sendText(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX), channels);
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(wlr3_new_provide__orderPage.NEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(message));
    }

    public void populateProvisionPageWithAssertionsForISDN30() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(ORDER_NOTES_LABEL_FOR_ISDN));
        utils.clickBtn(By.id(ORDERNOTES_TOOL_TIP_CLICK));
        utils.waitForElementVisible(By.xpath(TEXT_ON_ORDER_NOTES_TOOLTIP_POPUP));
        utils.clickBtn(By.xpath(wlr3_lineNumberingPage.OK_BUTTON_ON_NEW_OR_REACTIVATE_OLD_SNDDI_VALIDATION_POPUP));
        utils.waitForElementVisible(By.id(FLOOR_TEXT_BOX));
        utils.sendText(By.id(FLOOR_TEXT_BOX), "1st floor");
        utils.sendText(By.id(ROOM_TEXT_BOX), "central Hall");
        enterChannelsInISDNNewProvide("7", MINIMUM_CHANNELS_ERROR_MESSAGE);
       enterChannelsInISDNNewProvide("1000",MAXIMUM_CHANNELS_ERROR_MESSAGE);
        utils.sendText(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX), "8");

    }
    public void provisionPageForISDN30ChangeOfAddress(){
        utils.waitForElementVisible(By.id(FLOOR_TEXT_BOX));
        utils.sendText(By.id(FLOOR_TEXT_BOX), "1st floor");
        utils.sendText(By.id(ROOM_TEXT_BOX), "central Hall");
        utils.sendText(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX), "9");
    }
    public void setProvisionTypeForNonMultiLine() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(TAKE_OVER_WORKING_LINE_TEXT));
        utils.waitForElementVisible(By.xpath(TAKE_OVER_WORKING_LINE_RADIO_BUTTON));
        utils.clickBtn(By.xpath(TAKE_OVER_WORKING_LINE_RADIO_BUTTON));
        utils.waitForElementVisible(By.id(TAKE_OVER_WORKING_CLI_BUTTON));
        wlr3_new_provide__orderPage.navigateToNextScreen();
        utils.waitForElementVisible(By.xpath(SPECIFY_WORKING_LINE_MESSAGE));
        utils.clickBtn(By.id(TAKE_OVER_WORKING_CLI_BUTTON));
        utils.waitForElementVisible(By.xpath(TEXT_ON_WORKING_LINES_POPUP));
        utils.clickBtn(By.xpath(commonMethods.CLOSE_POPUP));
       utils.waitForElementVisible(By.xpath(PROVIDE_LINE_RADIO_BUTTON_UNDER_PROVISION));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(PROVIDE_LINE_RADIO_BUTTON_UNDER_PROVISION));
        utils.selectByVisibleText(By.id(EXCESS_CONSTRUCTION_CHARGES_DROPDOWN),"Band 1 - Up to £300");
    }
    public void assertUnavailabilityOfTakeOverWorkingLineForMultiLineNewProvide(){
        utils.assertElementNotPresent(By.id(TAKE_OVER_WORKING_LINE_TEXT));
    }

    public void validatingNumberOfChannelsForISDN2System() throws InterruptedException {
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX));
        utils.sendText(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX),"0");
        wlr3_new_provide__orderPage.navigateToNextScreen();
        utils.waitForElementVisible(By.xpath(MINIMUM_TWO_CHANNELS_REQUIRED));
        utils.sendText(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX),"70");
        utils.waitForElementVisible(By.xpath(MAXIMUM_SIXTY_CHANNELS_ALLOWED));
        utils.sendText(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX),"3");
        utils.waitForElementVisible(By.xpath(NUMBER_OF_CHANNELS_MUST_BE_MULTIPLES_OF_TWO));
        utils.sendText(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX),"2");
        wlr3_new_provide__orderPage.navigateToNextScreen();
        utils.waitForElementVisible(By.xpath(ENGINEERING_INFO_TEXT_UNDER_SITEINFO));
    }
public void terminationTypeForAnalogueBasicLine(){
    utils.waitForElementVisible(By.xpath(LINEBOX_SELECTED_AS_DEFAULT_UNDER_TERMINATION_TYPE));
    utils.assertElementNotPresent(By.xpath(NTTP_OPTION_UNDER_TERMINATION_TYPE));
}
public void terminationTypeForPremiumLine(){
    utils.waitForElementVisible(By.xpath(LINEBOX_OPTION_UNDER_TERMINATION_TYPE));
    utils.waitForElementVisible(By.xpath(NTTP_OPTION_UNDER_TERMINATION_TYPE));
    utils.selectByVisibleText(By.id(TERMINATION_TYPE_DROPDOWN_UNDER_SITEINFO),"NTTP");
}
public void unTickOpenReachManaged(){
    utils.waitForElementVisible(By.id(OPEN_REACH_MANAGED));
    utils.makeSureBoxIsUnChecked(By.id(OPEN_REACH_MANAGED),By.id(OPEN_REACH_MANAGED));

}
public void validationForNumberOfLinesForMultiline(String min, String max, String validInt) throws InterruptedException {
    utils.waitForElementVisible(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX));
    utils.sendText(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX),min);
    Thread.sleep(1000);
    utils.javaScriptExecutorClick(By.xpath(wlr3_new_provide__orderPage.NEXT_BUTTON));
    utils.waitForElementVisible(By.xpath(MINIMUM_TWO_LINES_REQUIRED_FOR_THIS_PRODUCT));
    utils.sendText(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX),max);
    utils.waitForElementVisible(By.xpath(MAXIMUM_99_LINES_REQUIRED_FOR_THIS_PRODUCT));
    utils.sendText(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX),validInt);
}
public void assertChannelOptionsAbsent(){
    utils.waitForElementVisible(By.xpath(LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO));
    utils.assertElementNotPresent(By.xpath(CHANNELS_TEXT));
    utils.assertElementNotPresent(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX));
}
public void assertChannelOptionsPresent(){
    utils.waitForElementVisible(By.xpath(CHANNELS_TEXT));
    utils.waitForElementVisible(By.id(wlr3_orderDetails_page.EDIT_NUMBER_OF_CHANNELS_TEXT_BOX));
}



}
