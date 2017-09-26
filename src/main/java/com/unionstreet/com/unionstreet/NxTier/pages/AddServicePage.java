package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

import java.awt.*;
import java.sql.SQLException;

/**
 * Created by rajeshg on 24/10/2016.
 */
public class AddServicePage {

    private final String TEXT_ON_THE_SELECTQUOTE_PAGE = "//input[@onclick='ShowSiteSelectionPopup();']";
    private final String SERVICE_ON_QUOTE_PAGE = "//a[text()='customService']";


    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods = new CommonMethods();
    NxTierServicesPage nxTierServicesPage = new NxTierServicesPage();
    EditOrderPage editOrderPage = new EditOrderPage();
    OrdersManagerPage ordersManagerPage = new OrdersManagerPage();
    NewBusinessCustomerPage newBusinessCustomerPage=new NewBusinessCustomerPage();


    public void searchAndSelectService() throws InterruptedException {
      //  utils.waitForElementVisible(By.xpath(nxTierServicesPage.CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.clickBtn(By.xpath("//div[@class='info_panel_1 fullwidth box-content']"));
        utils.returnElement(By.xpath(nxTierServicesPage.CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE)).click();
      //  utils.clickBtn(By.xpath(nxTierServicesPage.CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.switchToNewWindow();
      //  utils.waitForElementVisible(By.xpath(commonMethods.SAVE_AND_CLOSE_XPATH));
        try {
            utils.returnElement(By.xpath(commonMethods.SAVE_AND_CLOSE_XPATH)).click();
        } catch (Exception e) {
            utils.checkAlert();
        }
        utils.switchToPreviousWindow(1);
    }

    public void clickService() throws InterruptedException, AWTException {

        utils.returnElement(By.xpath(SERVICE_ON_QUOTE_PAGE)).click();
       // utils.clickBtn(By.xpath(SERVICE_ON_QUOTE_PAGE));
        utils.switchToNewWindow();
    }

    public void addServiceToQuote(String serviceName) throws InterruptedException, SQLException {
        try {
         //   utils.waitForElementVisible(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
            utils.jumpToPopUpWindow(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
        } catch (Exception e) {
            utils.getOrdersPage();
            ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
            utils.returnElement(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON)).click();
         // utils.clickBtn(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
           utils.switchToNewWindow();

        }
        utils.waitForElementVisible(By.xpath("//div[text()='" + serviceName + "']"));
        utils.clickBtn(By.xpath("//div[@class='info_panel_1 fullwidth box-content']"));
        utils.closeCurrentWindowAndJump(By.xpath("//div[text()='" + serviceName + "']"));
    }

    public void clickAddAProductOrService() throws InterruptedException, SQLException {
        try {
         //   utils.waitForElementVisible(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
            utils.jumpToPopUpWindow(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
        } catch (Exception e) {
            utils.getOrdersPage();
            ordersManagerPage.clickOnQuote();
            utils.returnElement(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON)).click();
          //  utils.clickBtnWithWait(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));

        }
    }

    public void assertServicePresent(String serviceName) throws InterruptedException, SQLException {
        try {
            utils.waitForElementVisible(By.xpath("//label[@id='selectedSiteLabel'][contains(text(),'vodafone')]"));
            utils.waitForElementVisible(By.xpath("//div[text()='" + serviceName + "']"));
        } catch (Exception e) {
            utils.getOrdersPage();
            ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
          //  utils.waitForElementVisible(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
            utils.jumpToPopUpWindow(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
            utils.waitForElementVisible(By.xpath("//label[@id='selectedSiteLabel'][contains(text(),'vodafone')]"));
            utils.waitForElementVisible(By.xpath("//div[text()='" + serviceName + "']"));
        }
    }

    public void assertServiceNotPresent(String serviceName) {
        utils.waitForElementVisible(By.xpath("//label[@id='selectedSiteLabel'][contains(text(),'vodafone')]"));
        utils.assertElementNotPresent(By.xpath("//div[text()='" + serviceName + "']"));
    }

    public void scrollToService() throws InterruptedException {
        utils.scrollUp(By.xpath(SERVICE_ON_QUOTE_PAGE));
    }

    public void searchAndAddService(String service, String customerName) throws InterruptedException, SQLException {
        try {
           // utils.waitForElementVisible(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
            utils.jumpToPopUpWindow(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
            utils.waitForElementVisible(By.xpath(TEXT_ON_THE_SELECTQUOTE_PAGE));
            utils.jumpToPopUpWindow(By.xpath("//div[text()='" + service + "']"));
        } catch (Exception e) {
            utils.getOrdersPage();
            ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(customerName);
         //   utils.waitForElementVisible(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
            utils.jumpToPopUpWindow(By.xpath(editOrderPage.ADD_PRODUCT_AND_SERVICE_BUTTON));
            utils.waitForElementVisible(By.xpath(TEXT_ON_THE_SELECTQUOTE_PAGE));
            utils.jumpToPopUpWindow(By.xpath("//div[text()='" + service + "']"));
        }

    }}