package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class WLR3_DirectoryInformationPage {

    private final String BUSINESS_NAME_DIRECTORY_INFORMATION = "DirectoryInfo_0__dir_TradingTitleSurname";
    //// TODO: 06/01/2017  
    private final String ENABLE_CHANGE_DIRECTORY_INFO_BUTTON = "//input[@value='Change'][starts-with(@onclick,'wlr3Directories.retainStateChanged')]";
    private final String EDIT = "editBtn";
    private final String BUSINESSNAME_UNDER_DIRECTORYINFO = "DirectoryInfo_0__dir_TradingTitleSurname";
    //// TODO: 06/01/2017  
    private final String SAVED_BUSINESSNAME_UNDER_DIRECTORYINFO = "//div[@style='display: block;'][contains(text(),'vodafone')]";

    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();

    public void populatingDirectoryInformation(String name) throws InterruptedException {
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("directoryInformationSummaryPanel"));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));
        Thread.sleep(1000);
        try {
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));
        } catch (Exception e) {
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));

        }
        utils.checkPoint("entered the directory info page to populate");
        utils.waitForElementVisible(By.id("retainDirInfoLabel"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(ENABLE_CHANGE_DIRECTORY_INFO_BUTTON));
        utils.waitForElementVisible(By.id(EDIT));
        utils.scrollUp(By.id(EDIT));
        utils.clickBtn(By.id(EDIT));
        utils.clickBtn(By.id(BUSINESS_NAME_DIRECTORY_INFORMATION));
        utils.sendText(By.id(BUSINESS_NAME_DIRECTORY_INFORMATION), name);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.javaScriptExecutorClick(By.id(wlr3_orderDetails_page.CLOSE));
        utils.jumpToParentPopUp();
    }

    public void editDirectoryInformation() throws InterruptedException {
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("directoryInformationSummaryPanel"));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));
        Thread.sleep(1000);
        try {
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));
        } catch (Exception e) {

            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));
            Thread.sleep(1000);
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));

        }
        utils.checkPoint("entered the directory info page to edit");
        utils.waitForElementVisible(By.id("changeDirInfoLabel"));
        utils.waitForElementVisible(By.id(EDIT));
        utils.scrollUp(By.id(EDIT));
        Thread.sleep(1000);
        utils.clickBtn(By.id(EDIT));
        utils.sendText(By.id(BUSINESSNAME_UNDER_DIRECTORYINFO), "vodafone");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath(SAVED_BUSINESSNAME_UNDER_DIRECTORYINFO));
        utils.javaScriptExecutorClick(By.id(wlr3_orderDetails_page.CLOSE));
    }
}
