package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 13/01/2017.
 */
public class WLR3_New_Provide_Analogue_Multiline_OrderPage {


    public final String NEXT_BUTTON = "//a[starts-with(@onclick,'newProvideWizard.moveNext()')]";
    private final String SUBMIT_BUTTON = "//button[@type='submit']";
    private final String ANALOGUE_MULTILINE_TAB = "line_3";

    ElementUtils utils = new ElementUtils();

    public void clickAnalogueMultilineTab() {
        utils.waitForElementVisible(By.id(ANALOGUE_MULTILINE_TAB));
        utils.clickBtn(By.id(ANALOGUE_MULTILINE_TAB));
        utils.clickBtn(By.xpath(SUBMIT_BUTTON));
    }

    public void navigateToNextScreen() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(NEXT_BUTTON));
        Thread.sleep(1000);
        utils.waitForElementVisible(By.xpath("//div[@id='pageLoader'][@class='page-loader']"));
        try {
            utils.clickBtn(By.xpath(NEXT_BUTTON));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath("//div[@id='pageLoader'][@class='page-loader']"));
            utils.clickBtn(By.xpath(NEXT_BUTTON));
        }
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
    }

    public void navigateToPreviousScreen() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//a[@onclick='newProvideWizard.movePrevious()']"));
        Thread.sleep(1000);
        utils.waitForElementVisible(By.xpath("//div[@id='pageLoader'][@class='page-loader']"));

        try {
            utils.clickBtn(By.xpath("//a[@onclick='newProvideWizard.movePrevious()']"));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath("//div[@id='pageLoader'][@class='page-loader']"));
            utils.clickBtn(By.xpath("//a[@onclick='newProvideWizard.movePrevious()']"));
        }
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
    }
}
