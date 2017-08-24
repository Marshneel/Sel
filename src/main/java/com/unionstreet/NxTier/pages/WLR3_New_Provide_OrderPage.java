package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 13/01/2017.
 */
public class WLR3_New_Provide_OrderPage {


    public final String NEXT_BUTTON = "//a[starts-with(@onclick,'newProvideWizard.moveNext()')]";
    private final String SUBMIT_BUTTON = "//button[@type='submit']";
    private final String ANALOGUE_MULTILINE_TAB = "line_3";

    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    EditOrderPage editOrderPage = new EditOrderPage();

    public void clickAnalogueMultilineTab() {
        utils.waitForElementVisible(By.id(ANALOGUE_MULTILINE_TAB));
        utils.clickBtn(By.id(ANALOGUE_MULTILINE_TAB));
        utils.clickBtn(By.xpath(SUBMIT_BUTTON));
    }
    public void selectLineTypeTab(String lineType){
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'"+lineType+"')]"));
        utils.clickBtn(By.xpath("//label[contains(text(),'"+lineType+"')]"));
        utils.clickBtn(By.xpath(SUBMIT_BUTTON));

    }
    public void saveAndSwitchToOrderSummaryPage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(NEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        Thread.sleep(1000);
        utils.closeCurrentWindowAndJump(By.xpath(NEXT_BUTTON));
    }

    public void navigateToNextScreen() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(NEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        try {Thread.sleep(1000);
            utils.javaScriptExecutorClick(By.xpath(NEXT_BUTTON));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
            try {Thread.sleep(1000);
                utils.javaScriptExecutorClick(By.xpath(NEXT_BUTTON));
            } catch (Exception e1) {
                utils.checkAlert();
            }
        }
    }
    public void navigateToNextWithJavaCLick() throws InterruptedException {
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(NEXT_BUTTON));
    }

    public void multipleClicksOnNextButton(int number) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(NEXT_BUTTON));
        Thread.sleep(1000);
        utils.multipleCLick(By.xpath(NEXT_BUTTON), By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT), number);
    }

    public void selectLineTypeForNewProvide(String lineType) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//li[contains(@onclick,'SelectLineType')]//label[contains(text(),'" + lineType + "')]"));
       Thread.sleep(1000);
        utils.clickBtn(By.xpath("//li[contains(@onclick,'SelectLineType')]//label[contains(text(),'" + lineType + "')]"));
        utils.waitForElementVisible(By.xpath(editOrderPage.VALIDATE_LINE_TYPE_BUTTON));
        utils.clickBtn(By.xpath(editOrderPage.VALIDATE_LINE_TYPE_BUTTON));
    }


}
