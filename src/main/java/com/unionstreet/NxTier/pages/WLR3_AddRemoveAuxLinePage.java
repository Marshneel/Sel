package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 03/02/2017.
 */
public class WLR3_AddRemoveAuxLinePage {

    private final String TEXT_ON_ADD_REMOVE_AUXLINE_PAGE="//div[@id='wlr3OrderDetailPopupDiv']//h3[contains(text(),'WLR3 Add/Remove Aux Lines Order')]";
    private final String TEXT_ON_INCREASE_DECREASE_AUXLINE_POPUP="//div[@id='wlr3OrderDetailPopupDiv']//h4[contains(text(),'Increase or Decrease Aux Lines')]";
    private final String ERROR_MESSAGE_WHEN_LINENUM_STAYS_THE_SAME="//span[contains(text(),'New number of lines needs to be less or more than the existing number of lines.')]";
    private final String SUBMIT_LINENUM_SELECTION="//button[contains(@onclick,'SubmitLineSelection')]";
    private final String EDIT_NUM_OF_LINES="RequestedNumberOfLines";
   private final String CLI_TEXT_ON_ORDER_SUMMARY="//div[contains(text(),'01202300909')]";
    private final String INCREASED_NUM_OF_LINES_ON_ORDER_SUMMARY_PAGE="//div[@id='div_WLR3Order_num_lines']//span[contains(text(),'9')]";
    private final String DECREASED_NUM_OF_LINES_ON_ORDER_SUMMARY_PAGE="//div[@id='div_WLR3Order_num_lines']//span[contains(text(),'7')]";
    private final String  ERROR_MESSAGE_UPON_DUPLICATING_CLI="//div[@id='validationSummary']//h5[contains(text(),'Sorry, this number cannot be processed')]";
    private final String CHARGES_RECURRING_TEXT="//div[@id='chargesSummaryPanel']//td[contains(text(),'Analogue Multi-Line')]";
    private final String ANALOGUE_MULTILINE_CHARGES="//div[@id='chargesSummaryPanel']//label[contains(text(),'Analogue Multi-Line')]";


    ElementUtils utils=new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();
    CompanyMenuPage companyMenuPage=new CompanyMenuPage();


    public void textOnAddRemoveAuxLinePage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(TEXT_ON_ADD_REMOVE_AUXLINE_PAGE));
    }

    public void populateCLIandPostCode(String phoneNumber,String postCode){
        utils.clickBtn(By.id(wlr3_orderDetails_page.MANUAL_ENTRY_TAB));
        utils.sendText(By.id(companyMenuPage.CLI_NUMBER_FIELD),phoneNumber);
        utils.sendText(By.id("Postcode"),postCode);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void textOnIncreaseOrDecreaseAuxLinePopUp(){
        utils.waitForElementVisible(By.xpath(TEXT_ON_INCREASE_DECREASE_AUXLINE_POPUP));
    }

    public void continueWithOutAddOrDeleteLines(){
        utils.clickBtn(By.xpath(SUBMIT_LINENUM_SELECTION));
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_WHEN_LINENUM_STAYS_THE_SAME));
    }

    public void ChangeNumberOfLines(String number){
        utils.sendText(By.id(EDIT_NUM_OF_LINES),number);
        utils.clickBtn(By.xpath(SUBMIT_LINENUM_SELECTION));
    }

    public void assertLineNumberIncrease(){
        utils.waitForElementVisible(By.xpath(INCREASED_NUM_OF_LINES_ON_ORDER_SUMMARY_PAGE));
    }
    public void assertNumberDecrease(){
        utils.waitForElementVisible(By.xpath(DECREASED_NUM_OF_LINES_ON_ORDER_SUMMARY_PAGE));
    }

    public void assertCLI(){
        utils.waitForElementVisible(By.xpath(CLI_TEXT_ON_ORDER_SUMMARY));
    }
public void errorMessage(){
    utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_UPON_DUPLICATING_CLI));
}

    public void assertPresenceOfCharges(){
        utils.waitForElementVisible(By.xpath(CHARGES_RECURRING_TEXT));
    }
    public void assertAbsenceOfCharges(){
        utils.assertElementNotPresent(By.xpath(ANALOGUE_MULTILINE_CHARGES));

    }

}
