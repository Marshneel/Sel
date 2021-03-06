package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

import java.sql.SQLException;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class EditOrderPage {

    public final String ADD_PRODUCT_AND_SERVICE_BUTTON = "//span[text()='Add a product or service']";
    private final String REDCROSS = "//td[contains(@title,'Information Missing')]";
    public final String GREEN_TICK = "//td[@class='green-tick']";
    private final String ADD_VIEW_NOTES = "//span[contains(text(),'Messages')]";
    private final String CUSTOMER_RADIOBUTTON = "SendToCustomer";
    private final String INTERNAL_RADIOBUTTON = "SendToInternal";
    private final String SERVICE_NOT_COMPLETED_MESSAGE = "//div[contains(text(),'Services are not completed')]";
    private final String SAVE_AND_SUBMIT_ORDER = "//span[text()='Save & Submit Order']";
    private final String ORDER_CONTACT = "Order_order_contact_id";
    private final String ORDER_PENDING_TEXT_IN_NOTIFICATIONS = "//table[@id='orderHistory-table']//td[contains(text(),'Order Pending')]";
    private final String ORDER_ACKNOWLEDGED_TEXT_IN_NOTIFICATIONS = "//table[@id='orderHistory-table']//td[contains(text(),'Order Acknowledged')]";
    private final String ORDER_COMMITTED_TEXT_IN_NOTIFICATIONS = "//table[@id='orderHistory-table']//td[contains(text(),'Committed')]";
    private final String ORDER_COMPLETED_TEXT_IN_NOTIFICATIONS = "//table[@id='orderHistory-table']//td[contains(text(),'Order Completed')]";
    private final String LINE_TESTING_TEXT_ON_ORDERS_PAGE = "//div[@id='contentPanel']//td[contains(text(),'Line Testing')]";
    private final String ORDER_OWNER_DROPDOWN_ON_EDIT_ORDER_PAGE = "Order_owned_by_id";
    private final String SAVE_AND_SUBMIT_QUOTE = "//div[@id='buttonMenu']//span[contains(text(),'Save & Submit Order')]";
    private final String AMEND_ORDER_BUTTON = "AmendOrder";
    private final String SUBMIT_AMENDED_ORDER = "SubmitAmend";
    private final String REASON_FOR_AMENDING_ORDER = "WLR3Order_amend_reason";
    private final String OPENREACH_NOTIFICATIONS_BUTTON_ON_ORDER_SUMMARY_PAGE = "//button[contains(@onclick,'ShowOrderHistoryPopup')]";
    private final String ORDER_NOTIFICATIONS_BUTTON_AFTER_SUBMISSION = "//input[contains(@onclick,'ShowOrderHistoryPopup')]";
    private final String AMEND_SENT_TEXT_ON_OPENREACH_NOTIFICATIONS = "//div[@id='divorderHistory']//td[contains(text(),'Amend sent')]";
    private final String SERVICE_NOT_COMPLETED_ERROR_MESSAGE = "//div[@id='Message_Info'][contains(text(),'Error: This order requires Owner to be set!')]";
    public final String VALIDATE_LINE_TYPE_BUTTON = "//button[contains(@onclick,'return ValidateLineType()')]";

    public static String RanNumberForSubmission;
    public static String RanNumberForCancellation;
    public static String currentDate;


    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods = new CommonMethods();
    OrdersManagerPage ordersManagerPage = new OrdersManagerPage();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    NxTierServicesPage nxTierServicesPage=new NxTierServicesPage();

    public void getToAddServicePage() throws InterruptedException, SQLException {
        utils.getOrdersPage();
        ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
    }


    public void clickAddProductsAndServicesButton() throws InterruptedException, SQLException {
        utils.clickBtn(By.xpath(ADD_PRODUCT_AND_SERVICE_BUTTON));
    }

    public void assertInvalidQuoteBeforeSubmitting() throws InterruptedException, SQLException {
        try {
            utils.waitForElementVisible(By.xpath(REDCROSS));
        } catch (Exception e) {
            ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
            utils.waitForElementVisible(By.xpath(REDCROSS));
        }
    }

    public void assertInvalidQuoteAfterSubmitting() throws InterruptedException {
        utils.selectByIndex(By.id(ORDER_CONTACT), 1);
        utils.scrollUp(By.xpath(SAVE_AND_SUBMIT_ORDER));
        utils.clickBtn(By.xpath(SAVE_AND_SUBMIT_ORDER));
        utils.waitForElementVisible(By.xpath(SERVICE_NOT_COMPLETED_MESSAGE));
    }

    public void assertValidQuoteBeforeSubmitting() throws InterruptedException, SQLException {

        try {
            utils.waitForElementVisible(By.xpath(GREEN_TICK));
        } catch (Exception e) {
            ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
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
        utils.checkAlert();
       utils.waitForElementVisible(By.id(CUSTOMER_RADIOBUTTON));
        utils.clickBtn(By.id("OrderPopup"));
        utils.clickBtnWithWait(By.id(CUSTOMER_RADIOBUTTON));
        utils.waitForElementVisible(By.id(INTERNAL_RADIOBUTTON));
        utils.clickBtn(By.id("OrderPopup"));
        utils.clickBtnWithWait(By.id(INTERNAL_RADIOBUTTON));
    }

    public void assertCustomer_InternalTabsNotPresent() {
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.checkAlert();
        utils.assertElementNotPresent(By.id(CUSTOMER_RADIOBUTTON));
        utils.assertElementNotPresent(By.id(INTERNAL_RADIOBUTTON));
    }

    public void verifyOrderCompletion() throws InterruptedException, SQLException {
        utils.switchToPreviousWindow(0);
        //load created quote
        ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
        // check for the green tick
        try {
            utils.waitForElementVisible(By.xpath(GREEN_TICK));
        } catch (Exception e) {
            ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
            utils.waitForElementVisible(By.xpath(GREEN_TICK));
        }
        System.out.println("NA87 completed");
    }
    public void verifyOrderCompletionForNxtierAndWlr3ItemsForCP(String NxtierService) throws InterruptedException, SQLException
    {
       // utils.switchToPreviousWindow(1);
        ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
        utils.waitForElementVisible(By.xpath("//a[text()='"+NxtierService+"']"));
        utils.waitForElementVisible(By.xpath("//a[contains(@onclick,'OpenNewWLR3OrderDetailPopup')]"));
        utils.selectByIndex(By.id(ORDER_OWNER_DROPDOWN_ON_EDIT_ORDER_PAGE), 1);
        Thread.sleep(1000);
        utils.scrollUp(By.xpath("//span[text()='Save & Submit Order']"));
        utils.waitForElementVisible(By.xpath("//span[text()='Save & Submit Order']"));
        utils.clickBtn(By.xpath("//span[text()='Save & Submit Order']"));
        utils.switchToPreviousWindow(0);
        ordersManagerPage.AssertPresenceOfNxtiereAndWLR3ItemsInSameOrder();

    }

    public void accessOrder() throws InterruptedException, SQLException {
        ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
        utils.waitForElementVisible(By.xpath(GREEN_TICK));
    }

    public void submitOrder() throws InterruptedException {
        utils.selectByIndex(By.id(ORDER_OWNER_DROPDOWN_ON_EDIT_ORDER_PAGE), 1);
       // utils.waitForElementVisible(By.xpath(SAVE_AND_SUBMIT_QUOTE));
        utils.clickBtn(By.xpath(SAVE_AND_SUBMIT_QUOTE));
        utils.switchToPreviousWindow(1);

    }

    public void getToAmendOrderButton() throws InterruptedException, SQLException {
        ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.ITEMID_ON_EDITORDER));
        utils.clickBtn(By.xpath(wlr3_orderDetails_page.ITEMID_ON_EDITORDER));
        utils.waitForElementVisible(By.id(AMEND_ORDER_BUTTON));
        utils.clickBtn(By.id(AMEND_ORDER_BUTTON));
    }

    public void startOrderAmend() throws InterruptedException, SQLException {
        getToAmendOrderButton();
        utils.selectByIndex(By.id(REASON_FOR_AMENDING_ORDER), 1);
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void startAmendWithCustomerDelayReason() throws InterruptedException, SQLException {
        getToAmendOrderButton();
        utils.selectByVisibleText(By.id(REASON_FOR_AMENDING_ORDER), "In Response To Customer Delay");
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void submitAmendedOrder() {
        utils.clickBtn(By.id(SUBMIT_AMENDED_ORDER));
    }

    public void checkOpenReachNotificationForAmend() throws InterruptedException {
        utils.refreshPage();
       utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.ITEMID_ON_EDITORDER));
        utils.clickBtn(By.xpath(wlr3_orderDetails_page.ITEMID_ON_EDITORDER));
        utils.waitForElementVisible(By.xpath(OPENREACH_NOTIFICATIONS_BUTTON_ON_ORDER_SUMMARY_PAGE));
        utils.clickBtn(By.xpath(OPENREACH_NOTIFICATIONS_BUTTON_ON_ORDER_SUMMARY_PAGE));
        utils.waitForElementVisible(By.xpath(AMEND_SENT_TEXT_ON_OPENREACH_NOTIFICATIONS));
    }

    public void checkOpenReachNotificationsForOrderSuccessfulSubmission() throws InterruptedException, SQLException {
        utils.getOrdersPage();
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
     try{   utils.waitForElementVisible(By.xpath(LINE_TESTING_TEXT_ON_ORDERS_PAGE));}
     catch (Exception e){utils.refreshPage();
         utils.waitForElementVisible(By.xpath(LINE_TESTING_TEXT_ON_ORDERS_PAGE));
     }
        ordersManagerPage.loadOrdersManagerAndClickOnQuoteID(newBusinessCustomerPage.RanName);
        utils.waitForElementVisible(By.xpath(ORDER_NOTIFICATIONS_BUTTON_AFTER_SUBMISSION));
        utils.clickBtn(By.xpath(ORDER_NOTIFICATIONS_BUTTON_AFTER_SUBMISSION));
        utils.waitForElementVisible(By.xpath(ORDER_PENDING_TEXT_IN_NOTIFICATIONS));
        utils.waitForElementVisible(By.xpath(ORDER_ACKNOWLEDGED_TEXT_IN_NOTIFICATIONS));
        utils.waitForElementVisible(By.xpath(ORDER_COMMITTED_TEXT_IN_NOTIFICATIONS));
        utils.waitForElementVisible(By.xpath(ORDER_COMPLETED_TEXT_IN_NOTIFICATIONS));
    }

    public void assertCeaseIsCancelled() throws InterruptedException {
        utils.getOrdersPage();
        utils.waitForElementVisible(By.xpath(ordersManagerPage.TASK_POPUP));
        utils.waitForElementVisible(By.xpath(ordersManagerPage.ORDERID_UNDER_TASK));
        utils.clickBtn(By.xpath(ordersManagerPage.ORDERID_UNDER_TASK));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath(ORDER_NOTIFICATIONS_BUTTON_AFTER_SUBMISSION));
        utils.clickBtn(By.xpath(ORDER_NOTIFICATIONS_BUTTON_AFTER_SUBMISSION));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'End User not moving')]"));
    }

    public void pushOpenReachNotificationsForSubmittedOrder(String CLI, String addressKey) throws Exception {
        RanNumberForSubmission = utils.randomNumber();
        currentDate = utils.getCurrentDate("dd/MM/yyyy");
        utils.accessCMDAndPowerShell("cmd.exe","cd \"src\\test\\Resources\\WLR3Tools\" && CmdController 10.1.9.112 \"Order Pending\" +0 " + RanNumberForSubmission + "");
        utils.accessCMDAndPowerShell("cmd.exe","cd \"src\\test\\Resources\\WLR3Tools\" && CmdController 10.1.9.112 \"OrderUpdate Acknowledged\" +0 " + RanNumberForSubmission + " notes");
        utils.accessCMDAndPowerShell("cmd.exe","cd \"src\\test\\Resources\\WLR3Tools\" && CmdController 10.1.9.112 \"OrderUpdate Committed\" +0 " + RanNumberForSubmission + " notes " + currentDate + " " + CLI + " " + addressKey + " " + '"' + '"');
        utils.accessCMDAndPowerShell("cmd.exe","cd \"src\\test\\Resources\\WLR3Tools\" && CmdController 10.1.9.112 \"OrderUpdate Completed\" +0 " + RanNumberForSubmission + " notes " + currentDate + " " + CLI + " " + addressKey + " " + '"' + '"');
    }

    public void acknowledgeNotificationForUCease(String CLI) throws Exception {
        RanNumberForCancellation = utils.randomNumber();
        utils.accessCMDAndPowerShell("cmd.exe","cd \"src\\test\\Resources\\WLR3Tools\" && CmdController 10.1.9.112 \"UCeaseOrderUpdate Acknowledged\" +0 " + RanNumberForCancellation + " DMA " + CLI + " CP Requested O2 " + '"' + '"');
        System.out.println(RanNumberForCancellation);
    }

    public void commitAndCompletedNotificationForUCease(String CLI) throws Exception {
        utils.accessCMDAndPowerShell("cmd.exe","cd \"src\\test\\Resources\\WLR3Tools\" && CmdController 10.1.9.112 \"UCeaseOrderUpdate Committed\" +0 " + RanNumberForCancellation + " DMA " + CLI + " CP Requested O2 " + '"' + '"' + " " + currentDate);
        utils.accessCMDAndPowerShell("cmd.exe","cd \"src\\test\\Resources\\WLR3Tools\" && CmdController 10.1.9.112 \"UCeaseOrderUpdate Completed\" +0 " + RanNumberForCancellation + " DMA " + CLI + " CP Requested O2 " + '"' + '"' + " " + currentDate);
    }

    public void submitBatchOrderBeforeOIDsGenerated() throws InterruptedException {
        utils.waitForElementVisible(By.id(ORDER_CONTACT));
        utils.selectByIndex(By.id(ORDER_CONTACT), 1);
       utils.waitForElementVisible(By.xpath(SAVE_AND_SUBMIT_QUOTE));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(SAVE_AND_SUBMIT_QUOTE));
    }

    public void errorMessageWhenOrderSubmittedWithOutOIDs() {
        utils.waitForElementVisible(By.xpath(SERVICE_NOT_COMPLETED_ERROR_MESSAGE));
    }


}
