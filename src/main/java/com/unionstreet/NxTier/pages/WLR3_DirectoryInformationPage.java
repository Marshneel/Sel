package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.awt.*;
import java.sql.SQLException;

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
    private final String CALL_SIGN_TAB = "//ul[@id='directoryInformationNavigation']//a[contains(text(),'Call Sign')]";
    private final String CHANGE_DIRECTORY_INFO_TAB = "changeDirInfoLabel";
    private final String RETAIN_DIRECTORY_INFO_TAB = "retainDirInfoLabel";

    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    CommonMethods commonMethods=new CommonMethods();



    public void populatingDirectoryInformation(String name) throws InterruptedException {
        utils.checkPoint("entered the directory info page to populate");
        utils.waitForElementVisible(By.id(RETAIN_DIRECTORY_INFO_TAB));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(ENABLE_CHANGE_DIRECTORY_INFO_BUTTON));
        utils.waitForElementVisible(By.id(EDIT));
        utils.scrollUp(By.id(EDIT));
        utils.clickBtn(By.id(EDIT));
        utils.clickBtn(By.id(BUSINESS_NAME_DIRECTORY_INFORMATION));
        utils.sendText(By.id(BUSINESS_NAME_DIRECTORY_INFORMATION), name);
    }
    public void saveAndCloseDirectoryInfo() throws InterruptedException {
      Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(commonMethods.CLOSE_POPUP));
    }

    public void editDirectoryInformation(String type) throws InterruptedException, SQLException {
        wlr3_orderDetails_page.textOnWLR3OrderPage(type);
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.DIRECTORY_INFO_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));
        Thread.sleep(1000);
        utils.scrollUp(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));
        try {
            Thread.sleep(1000);
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));
        } catch (Exception e) {

            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));
            Thread.sleep(1000);
            utils.jumpToPopUpWindow(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));
        }
        utils.checkPoint("entered the directory info page to edit");
        utils.waitForElementVisible(By.id(CHANGE_DIRECTORY_INFO_TAB));
        utils.waitForElementVisible(By.id(EDIT));
        utils.scrollUp(By.id(EDIT));
        Thread.sleep(1000);
        utils.clickBtn(By.id(EDIT));
        utils.sendText(By.id(BUSINESSNAME_UNDER_DIRECTORYINFO), "vodafone");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath(SAVED_BUSINESSNAME_UNDER_DIRECTORYINFO));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(commonMethods.CLOSE_POPUP));
    }

    public void assertUniqueNetworkFeatureUnderDirectoryInfoForSingleLine(String feature) throws InterruptedException, AWTException {
        utils.waitForElementVisible(By.xpath("//div[@id='directoryInformationSummaryPanel']//b[contains(text(),'" + feature + "')]"));
        utils.zoomOut();
            Thread.sleep(3000);
            utils.javaScriptExecutorClick(By.xpath(wlr3_orderDetails_page.DIRECTORY_INFORMATION_BUTTON));
        utils.setStdZoom();
        utils.waitForElementVisible(By.xpath("//ul[@id='directoryInformationNavigation']//a[contains(text(),'" + feature + "')]"));
        utils.clickBtn(By.xpath(CALL_SIGN_TAB));
        utils.waitForElementVisible(By.id(EDIT));
        utils.clickBtn(By.xpath(commonMethods.CLOSE_POPUP));
    }
    public void changeDirectoryType(String type) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//ul[@id='directoryInformationNavigation']/li[2]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//ul[@id='directoryInformationNavigation']/li[2]"));
       Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.id(EDIT));
        utils.selectByVisibleText(By.id("DirectoryInfo_0__dir_type_name"),type);
    }

}
