package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class EditOrderPage {

    public final String ADD_PRODUCT_AND_SERVICE_BUTTON = "//span[text()='Add a product or service']";
    private final String REDCROSS = "//td[@class='red-cross']";
    public final String GREEN_TICK = "//td[@class='green-tick']";
    private final String ADD_VIEW_NOTES = "//span[text()='Add / View Notes']";
    private final String CUSTOMER_RADIOBUTTON = "SendToCustomer";
    private final String INTERNAL_RADIOBUTTON = "SendToInternal";
    private final String SERVICE_NOT_COMPLETED_MESSAGE = "//div[text()='Services are not completed']";
    private final String SAVE_AND_SUBMIT_ORDER = "//span[text()='Save & Submit Order']";
    private final String ORDER_CONTACT = "Order_order_contact_id";
    public final String QUOTEID_ON_EDITORDER_PAGE = "//a[contains(@onclick,'OpenNewWLR3OrderDetailPopup')]";

    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods = new CommonMethods();
    OrdersManagerPage ordersManagerPage = new OrdersManagerPage();
    NewBusinessCustomerPage newBusinessCustomerPage=new NewBusinessCustomerPage();

    public void clickAddProductsAndServicesButton() throws InterruptedException {
        try {
            utils.waitForElementVisible(By.xpath(ADD_PRODUCT_AND_SERVICE_BUTTON));
            utils.clickBtnWithWait(By.xpath(ADD_PRODUCT_AND_SERVICE_BUTTON));
        } catch (NoSuchElementException e) {
            utils.getOrdersPage();
            ordersManagerPage.clickOnQuoteID();
            utils.waitForElementVisible(By.xpath(ADD_PRODUCT_AND_SERVICE_BUTTON));
            utils.clickBtnWithWait(By.xpath(ADD_PRODUCT_AND_SERVICE_BUTTON));

        }
    }

    public void assertInvalidQuoteBeforeSubmitting() {
        try {
            utils.waitForElementVisible(By.xpath(REDCROSS));
        } catch (Exception e) {
            utils.getOrdersPage();
            commonMethods.search(newBusinessCustomerPage.RanName);
            utils.clickBtn(By.xpath(ordersManagerPage.QUOTEID));
            utils.switchToNewWindow();
            utils.waitForElementVisible(By.xpath(REDCROSS));
        }
    }

    public void assertInvalidQuoteAfterSubmitting() throws InterruptedException {
        utils.selectByIndex(By.id(ORDER_CONTACT), 1);
        utils.scrollUp(By.xpath(SAVE_AND_SUBMIT_ORDER));
        utils.clickBtn(By.xpath(SAVE_AND_SUBMIT_ORDER));
        utils.waitForElementVisible(By.xpath(SERVICE_NOT_COMPLETED_MESSAGE));
    }

    public void assertValidQuoteBeforeSubmitting() {

        try {
            utils.waitForElementVisible(By.xpath(GREEN_TICK));
        } catch (Exception e) {
            utils.getOrdersPage();
            utils.clickBtn(By.xpath(ordersManagerPage.QUOTEID));
            utils.switchToNewWindow();
            utils.waitForElementVisible(By.xpath(GREEN_TICK));
        }
    }

    public void assertValidQuoteAfterSubmitting() {
        utils.waitForElementVisible(By.xpath(GREEN_TICK));
    }

    public void accessAdd_ViewNotes() {
        utils.waitForElementVisible(By.xpath(ADD_VIEW_NOTES));
        utils.jumpToPopUpWindow(By.xpath(ADD_VIEW_NOTES));
        utils.waitForElementVisible(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.clickBtn(By.id("OrderPopup"));
        utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
    }

    public void assertCustomer_InternalTabsPresent() throws InterruptedException {
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
        utils.waitForElementVisible(By.id(CUSTOMER_RADIOBUTTON));
        utils.clickBtn(By.id("OrderPopup"));
        utils.clickBtnWithWait(By.id(CUSTOMER_RADIOBUTTON));
        utils.waitForElementVisible(By.id(INTERNAL_RADIOBUTTON));
        utils.clickBtn(By.id("OrderPopup"));
        utils.clickBtnWithWait(By.id(INTERNAL_RADIOBUTTON));
    }

    public void assertCustomer_InternalTabsNotPresent() {
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
        utils.assertElementNotPresent(By.id(CUSTOMER_RADIOBUTTON));
        utils.assertElementNotPresent(By.id(INTERNAL_RADIOBUTTON));
    }
    public void verifyOrderCompletion() throws InterruptedException {
        //load created quote
        try {
            utils.getOrdersPage();
            ordersManagerPage.clickOnQuoteID();
        } catch (Exception e) {
        }
        utils.jumpToPopUpWindow(By.xpath(QUOTEID_ON_EDITORDER_PAGE));
        // check for the green tick
        utils.waitForElementVisible(By.xpath(GREEN_TICK));
        System.out.println("NA87 completed");
    }
}