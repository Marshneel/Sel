package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 13/01/2017.
 */
public class WLR3_New_Provide_Analogue_Multiline_OrderPage {


    public final String NEXT_BUTTON = "//a[starts-with(@onclick,'newProvideWizard.moveNext()')]";
    public final String PREVIOUS_BUTTON="//a[@onclick='newProvideWizard.movePrevious()']";
    private final String SUBMIT_BUTTON = "//button[@type='submit']";
    private final String ANALOGUE_MULTILINE_TAB = "line_3";

    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();

    public void clickAnalogueMultilineTab() {
        utils.waitForElementVisible(By.id(ANALOGUE_MULTILINE_TAB));
        utils.clickBtn(By.id(ANALOGUE_MULTILINE_TAB));
        utils.clickBtn(By.xpath(SUBMIT_BUTTON));
    }

    public void navigateToNextScreen() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(NEXT_BUTTON));
        Thread.sleep(1000);
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        try {
            utils.clickBtn(By.xpath(NEXT_BUTTON));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
            utils.clickBtn(By.xpath(NEXT_BUTTON));
        }
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
    }
    public void multipleClicksOnNextButton() throws InterruptedException {
        utils.multipleCLick(By.xpath(NEXT_BUTTON),By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT),4);
    }
    public void multipleCLicksOnPreviousButton(){
        utils.multipleCLick(By.xpath(PREVIOUS_BUTTON),By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT),4);
    }

    public void navigateToPreviousScreen() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(PREVIOUS_BUTTON));
        Thread.sleep(1000);
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));

        try {
            utils.clickBtn(By.xpath(PREVIOUS_BUTTON));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
            utils.clickBtn(By.xpath(PREVIOUS_BUTTON));
        }
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
    }
}
