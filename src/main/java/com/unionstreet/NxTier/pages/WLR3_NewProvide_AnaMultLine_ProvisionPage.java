package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_AnaMultLine_ProvisionPage {


    private final String LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO = "//legend[text()='Line Plant Summary']";
    private final String TERMINATION_TYPE_DROPDOWN_UNDER_SITEINFO = "WLR3Order_termination_type";
    private final String TERMINATION_TYPE_MANDATORY_ERROR_MESSAGE = "//span[text()='Termination Type is required']";
    private final String INSTALLATION_TYPE_GUIDANCE_TAB = "installationTypeGuidance";
    private final String TEXT_ON_INSTALLATION_TYPE_GUIDANCE_PAGE = "//h3[contains(text(),'Installation Type Help')]";
    private final String INSTALLATION_TYPE_GUIDANCE_POPUP_CLOSEBTN = "//div[@id='dialog-container']//button[@id='closeBtn']";
    private final String DECREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO = "//a[contains(@onclick,'newProvideWizard.decreaseNumber')]";
    private final String INCREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO = "//a[contains(@onclick,'newProvideWizard.increaseNumber')]";
    private final String NUMBER_OF_LINES_TEXT_BOX_UNDER_INSTALLATION_INFO = "WLR3Order_num_lines";
    private final String VIEW_WORKING_LINES_UNDER_LINE_PLANT_SUMMARY = "lnkwlt";
    private final String TEXT_ON_WORKING_LINES_POPUP = "//h3[contains(text(),'Line Plant Information')]";
    private final String WORKING_LINES_POPUP_CLOSEBTN = "//div[@id='modal-dialog-LinePlant']//button[@id='closeBtn']";
    private final String ORDER_NOTES_LABEL_FOR_ISDN = "//label[text()='Order Notes']";
    private final String ORDERNOTES_TOOL_TIP_CLICK = "openreachNotes";
    private final String TEXT_ON_ORDER_NOTES_TOOLTIP_POPUP = "//h4[text()='Openreach Notes']";
    private final String OK_BUTTON = "//button[text()='Ok']";
    private final String FLOOR_TEXT_BOX = "WLR3Order_floor";
    private final String ROOM_TEXT_BOX = "WLR3Order_room";
    private final String CHENNELS = "WLR3Order_num_lines";
    private final String MINIMUM_CHANNELS_ERROR_MESSAGE = "//span[text()='Minimum 8 Channels required for this product.']";
    private final String MAXIMUM_CHANNELS_ERROR_MESSAGE = "//span[text()='Maximum 999 Channels allowed for this product.']";
    private final String MINIMUM_TWO_CHANNELS_REQUIRED="//span[contains(text(),'Minimum 2 Channels required for this product.')]";
    private final String MAXIMUM_SIXTY_CHANNELS_ALLOWED="//span[contains(text(),'Maximum 60 Channels allowed for this product.')]";
    private final String NUMBER_OF_CHANNELS_MUST_BE_MULTIPLES_OF_TWO="//span[contains(text(),'Number of channels for ISDN2 System must be in multiples of 2.')]";


    ElementUtils utils = new ElementUtils();
    WLR3_New_Provide_Analogue_Multiline_OrderPage wlr3_new_provide_analogue_multiline_orderPage = new WLR3_New_Provide_Analogue_Multiline_OrderPage();
    CommonMethods commonMethods=new CommonMethods();

    public void populateLinePlantSummaryUnderPROVISION() throws InterruptedException {
        //verify the error message when termination type is not selected
        utils.waitForElementVisible(By.xpath(LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO));
        utils.clickBtn(By.xpath(wlr3_new_provide_analogue_multiline_orderPage.NEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(TERMINATION_TYPE_MANDATORY_ERROR_MESSAGE));

        //select the termination type from the dropDown
        utils.selectByIndex(By.id(TERMINATION_TYPE_DROPDOWN_UNDER_SITEINFO), 1);

        //verify the install type pop up
        utils.clickBtn(By.id(INSTALLATION_TYPE_GUIDANCE_TAB));
        utils.waitForElementVisible(By.xpath(TEXT_ON_INSTALLATION_TYPE_GUIDANCE_PAGE));
        utils.clickBtn(By.xpath(INSTALLATION_TYPE_GUIDANCE_POPUP_CLOSEBTN));
        utils.waitForElementVisible(By.xpath(LINE_PLANT_SUMMARY_TEXT_ON_SITEINFO));
        Thread.sleep(1000);

        //decrease the number of lines and assert
        utils.clickBtn(By.xpath(DECREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO));
        String decreaseValue = utils.getAttributeOfElement(By.id(NUMBER_OF_LINES_TEXT_BOX_UNDER_INSTALLATION_INFO), "value");
        Assert.assertEquals(decreaseValue, "1");
        //increase the number of lines and assert
        utils.clickBtn(By.xpath(INCREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO));
        utils.clickBtn(By.xpath(INCREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO));
        String increaseValue = utils.getAttributeOfElement(By.id(NUMBER_OF_LINES_TEXT_BOX_UNDER_INSTALLATION_INFO), "value");
        Assert.assertEquals(increaseValue, "3");

        //view working lines popup
        utils.clickBtn(By.id(VIEW_WORKING_LINES_UNDER_LINE_PLANT_SUMMARY));
        utils.waitForElementVisible(By.xpath(TEXT_ON_WORKING_LINES_POPUP));
        utils.clickBtn(By.xpath(WORKING_LINES_POPUP_CLOSEBTN));
    }

    public void enterChannelsInISDNNewProvide(String channels, String message) throws InterruptedException {
        utils.sendText(By.id(CHENNELS), channels);
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(wlr3_new_provide_analogue_multiline_orderPage.NEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(message));
    }

    public void populateProvisionPageWithAssertionsForISDN30() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(ORDER_NOTES_LABEL_FOR_ISDN));
        utils.clickBtn(By.id(ORDERNOTES_TOOL_TIP_CLICK));
        utils.waitForElementVisible(By.xpath(TEXT_ON_ORDER_NOTES_TOOLTIP_POPUP));
        utils.clickBtn(By.xpath(OK_BUTTON));
        utils.waitForElementVisible(By.id(FLOOR_TEXT_BOX));
        utils.sendText(By.id(FLOOR_TEXT_BOX), "1st floor");
        utils.sendText(By.id(ROOM_TEXT_BOX), "central Hall");
        enterChannelsInISDNNewProvide("7", MINIMUM_CHANNELS_ERROR_MESSAGE);
       enterChannelsInISDNNewProvide("1000",MAXIMUM_CHANNELS_ERROR_MESSAGE);
        utils.sendText(By.id(CHENNELS), "8");

    }
    public void setProvisionType() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//div[@id='divlineplantoptionsctrl']//input[@id='order_type_0']"));
        utils.clickBtn(By.xpath("//div[@id='divlineplantoptionsctrl']//input[@id='order_type_0']"));
        utils.waitForElementVisible(By.id("lnklineplantgridcall"));
        wlr3_new_provide_analogue_multiline_orderPage.navigateToNextScreen();
        utils.waitForElementVisible(By.xpath("//div[@id='ItemError'][contains(text(),'Please specify which working line to take over')]"));
        utils.clickBtn(By.id("lnklineplantgridcall"));
        utils.waitForElementVisible(By.xpath("//h3[contains(text(),'Line Plant Information')]"));
        utils.clickBtn(By.xpath(commonMethods.CLOSE_POPUP));
       utils.waitForElementVisible(By.xpath("//div[@id='divlineplantoptionsctrl']//input[@id='order_type_3']"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//div[@id='divlineplantoptionsctrl']//input[@id='order_type_3']"));
        utils.selectByVisibleText(By.id("WLR3Order_ecc_band"),"Band 1 - Up to £300");
    }

    public void validatingNumberOfChannelsForISDN2System() throws InterruptedException {
        utils.waitForElementVisible(By.id("WLR3Order_num_lines"));
        utils.sendText(By.id("WLR3Order_num_lines"),"0");
        wlr3_new_provide_analogue_multiline_orderPage.navigateToNextScreen();
        utils.waitForElementVisible(By.xpath(MINIMUM_TWO_CHANNELS_REQUIRED));
        utils.sendText(By.id("WLR3Order_num_lines"),"70");
        utils.waitForElementVisible(By.xpath(MAXIMUM_SIXTY_CHANNELS_ALLOWED));
        utils.sendText(By.id("WLR3Order_num_lines"),"3");
        utils.waitForElementVisible(By.xpath(NUMBER_OF_CHANNELS_MUST_BE_MULTIPLES_OF_TWO));
        utils.sendText(By.id("WLR3Order_num_lines"),"2");
        wlr3_new_provide_analogue_multiline_orderPage.navigateToNextScreen();
        utils.waitForElementVisible(By.xpath("//legend[text()='Engineering Information']"));
    }


}
