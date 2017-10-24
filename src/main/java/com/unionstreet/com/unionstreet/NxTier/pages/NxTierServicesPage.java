package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.awt.*;
import java.sql.SQLException;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class NxTierServicesPage {

    public final String CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE = "//div[text()='customService']";
    public final String MANDATORY_CONTROL_FIELD = "//input[@controlid='mandatoryControl']";
    private final String CPONLY = "//label[contains(text(),'CPonly')]";
    private final String CPONLY_CHECKBOX = "Checkbox0";
    private final String LABEL_WITHIN_A_SERVICE = "//label[@for='Service_Details']";
    private final String ABORT_BUTTON = "//input[contains(@onclick,'Abort')]";
    private final String ABORT_SERVICE_TEXTAREA = "//label[text()='Abort Reason']/following-sibling::textarea";
    private final String CONFIRM_ABORT_BUTTON = "//input[@value='Confirm Abort']";

    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods = new CommonMethods();
    OrdersManagerPage ordersManagerPage = new OrdersManagerPage();

    public void assertCPonlyValuePresent() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.clickBtn(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath(LABEL_WITHIN_A_SERVICE));
        utils.waitForElementVisible(By.xpath(CPONLY));
    }

    public void assertCPonlyValueNotPresent() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.clickBtn(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath(LABEL_WITHIN_A_SERVICE));
        utils.assertElementNotPresent(By.xpath(CPONLY));
    }

    public void populateMandatoryField() {
        utils.clickBtn(By.xpath(MANDATORY_CONTROL_FIELD));
        utils.sendText(By.xpath(MANDATORY_CONTROL_FIELD), "hello");
        try {
            utils.clickBtn(By.xpath(commonMethods.SAVE_AND_CLOSE_XPATH));
        } catch (Exception e) {
            utils.checkAlert();
        }
        utils.switchToPreviousWindow(1);
    }

    public void clickCancelNxtierServices(String NxtierService) throws InterruptedException, AWTException {
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + NxtierService + "')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'" + NxtierService + "')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath(ABORT_BUTTON));
        utils.javaScriptExecutorClick(By.xpath(ABORT_BUTTON));
        utils.jumpToPopUpWindow(By.xpath("//div[@class='modal-content']"));
        Thread.sleep(1000);
        utils.waitForElementVisible(By.xpath(CONFIRM_ABORT_BUTTON));
        utils.clickBtn(By.xpath(ABORT_SERVICE_TEXTAREA));
        utils.sendText(By.xpath(ABORT_SERVICE_TEXTAREA),"Incomplete service");
         utils.clickBtn(By.xpath(CONFIRM_ABORT_BUTTON));
        Thread.sleep(2000);
        utils.clickEnter();
        Thread.sleep(1000);
        utils.switchToPreviousWindow(1);
    }


    public void assertCPonlyCheckBoxPresentAndAccessible() {
        utils.waitForElementVisible(By.id(CPONLY_CHECKBOX));
        utils.javaScriptExecutorClick(By.id(CPONLY_CHECKBOX));
    }

    public void assertCPonlyCheckBoxIsAbsent() throws InterruptedException {
       // utils.switchToNewWindow();
        utils.assertElementNotPresent(By.id(CPONLY_CHECKBOX));
        ordersManagerPage.saveTheServiceAndGetTheOrderServicesID();
    }

    public void assertChargeOnGUI(String charge) {
        utils.waitForElementVisible(By.xpath("//td[@class='totalTotal'][text()='" + charge + "']"));
    }

    public void assertThereIsCharge(String column, double value) throws SQLException {
        utils.result.next();
        double one = utils.result.getDouble(column);
        Assert.assertTrue(one == value);
    }
}
