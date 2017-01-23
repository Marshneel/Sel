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

   ElementUtils utils=new ElementUtils();
    WLR3_New_Provide_Analogue_Multiline_OrderPage wlr3_new_provide_analogue_multiline_orderPage=new WLR3_New_Provide_Analogue_Multiline_OrderPage();

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
        Assert.assertEquals(decreaseValue, "2");
        //increase the number of lines and assert
        utils.clickBtn(By.xpath(INCREASE_NUMBER_OF_LINES_UNDER_INSTALLATION_INFO));
        String increaseValue = utils.getAttributeOfElement(By.id(NUMBER_OF_LINES_TEXT_BOX_UNDER_INSTALLATION_INFO), "value");
        Assert.assertEquals(increaseValue, "3");

        //view working lines popup
        utils.clickBtn(By.id(VIEW_WORKING_LINES_UNDER_LINE_PLANT_SUMMARY));
        utils.waitForElementVisible(By.xpath(TEXT_ON_WORKING_LINES_POPUP));
        utils.clickBtn(By.xpath(WORKING_LINES_POPUP_CLOSEBTN));
    }
}
