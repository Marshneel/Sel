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
        loadLineInfo();
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
        loadLineInfo();
        utils.waitForElementVisible(By.xpath("//select[@id='WLR3Order_care_level']//option[contains(text(),'" + number1 + "')]"));
        utils.waitForElementVisible(By.xpath("//select[@id='WLR3Order_care_level']//option[contains(text(),'" + number2 + "')]"));
        utils.waitForElementVisible(By.xpath("//select[@id='WLR3Order_care_level']//option[contains(text(),'" + number3 + "')]"));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));

    }
    public void loadLineInfo() throws InterruptedException {
        try {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(wlr3_orderDetails_page.LINE_INFO_TAB));
        } catch (Exception e) {
            wlr3_orderDetails_page.loadTabOnWLR3OrderSummaryPage();
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(wlr3_orderDetails_page.LINE_INFO_TAB));
        }
    }
}
