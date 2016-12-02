package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by rajeshg on 24/10/2016.
 */
public class AddServicePage {
    private final String SERVICE_ON_QUOTE_PAGE = "//a[text()='customService']";


    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods = new CommonMethods();
    OrdersManagerPage ordersManagerPage = new OrdersManagerPage();

    public void searchAndSelectService() {
        utils.waitForElementVisible(By.id(commonMethods.SEARCH_BUTTON));
        commonMethods.search(utils.getProperty("serviceName_CustomService"));
        utils.waitForElementVisible(By.xpath(ordersManagerPage.CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.clickBtn(By.xpath(ordersManagerPage.CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.switchToNewWindow();
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
        utils.switchToParentWindow();
    }

    public void clickService() {
        utils.clickBtn(By.xpath(SERVICE_ON_QUOTE_PAGE));
        utils.switchToNewWindow();
    }

    public void addServiceToQuote(String serviceName) {
        utils.jumpToPopUpWindow(By.xpath(ordersManagerPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
        commonMethods.search(serviceName);
        utils.waitForElementVisible(By.xpath("//div[text()='" + serviceName + "']"));
        utils.clickBtn(By.xpath("//div[text()='" + serviceName + "']"));
    }

    public void clickAddAProductOrService() {
        utils.jumpToPopUpWindow(By.xpath(ordersManagerPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
    }

    public void assertServicePresent(String serviceName) {
        utils.waitForElementVisible(By.xpath("//label[@id='selectedSiteLabel'][contains(text(),'vodafone')]"));
        utils.waitForElementVisible(By.xpath("//div[text()='" + serviceName + "']"));
    }

    public void assertServiceNotPresent(String serviceName) {
        utils.waitForElementVisible(By.xpath("//label[@id='selectedSiteLabel'][contains(text(),'vodafone')]"));
        utils.assertElementNotPresent(By.xpath("//div[text()='" + serviceName + "']"));
    }

}

