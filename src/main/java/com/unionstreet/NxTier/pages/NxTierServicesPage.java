package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.sql.SQLException;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class NxTierServicesPage {

    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods = new CommonMethods();
    OrdersManagerPage ordersManagerPage = new OrdersManagerPage();

    public final String CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE = "//div[text()='customService']";
    private final String MANDATORY_CONTROL_FIELD = "//input[@controlid='mandatoryControl']";
    private final String CPONLY = "//label[@class='helpIcon'][contains(text(),'CPonly')]";
    private final String CPONLY_CHECKBOX = "Checkbox0";
    private final String LABEL_WITHIN_A_SERVICE = "//label[@for='Service_Details']";

    public void assertCPonlyValuePresent() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.pageJumpWithoutClose(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.waitForElementVisible(By.xpath(LABEL_WITHIN_A_SERVICE));
        utils.waitForElementVisible(By.xpath(CPONLY));
    }

    public void assertCPonlyValueNotPresent() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.pageJumpWithoutClose(By.xpath(CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE));
        utils.waitForElementVisible(By.xpath(LABEL_WITHIN_A_SERVICE));
        utils.assertElementNotPresent(By.xpath(CPONLY));
    }

    public void populateMandatoryField() {
        utils.clickBtn(By.xpath(MANDATORY_CONTROL_FIELD));
        utils.sendText(By.xpath(MANDATORY_CONTROL_FIELD), "hello");
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
        utils.switchToPreviousWindow();
    }

    public void assertCPonlyCheckBoxPresentAndAccessible() {
        utils.waitForElementVisible(By.id(CPONLY_CHECKBOX));
        utils.javaScriptExecutorClick(By.id(CPONLY_CHECKBOX));
    }

    public void assertCPonlyCheckBoxIsAbsent() throws InterruptedException {
        utils.switchToNewWindow();
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
