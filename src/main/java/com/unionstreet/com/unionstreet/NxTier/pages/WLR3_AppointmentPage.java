package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class  WLR3_AppointmentPage {
    //// TODO: 06/01/2017
    private final String GET_AVAILABILITY_UNDER_APPOINTMENTPAGE = "//a[contains(@onclick,'showNewBookAppointmentPopup')]";


    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    WLR3_NewProvide_DatePage wlr3_newProvide__datePage = new WLR3_NewProvide_DatePage();

    public void accessAppointmentpage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.waitForElementVisible(By.xpath(GET_AVAILABILITY_UNDER_APPOINTMENTPAGE));
       Thread.sleep(1000);
        utils.scrollUp(By.xpath(GET_AVAILABILITY_UNDER_APPOINTMENTPAGE));
        try {
            Thread.sleep(1000);
            utils.javaScriptExecutorClick(By.xpath(GET_AVAILABILITY_UNDER_APPOINTMENTPAGE));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
            Thread.sleep(1000);
            utils.javaScriptExecutorClick(By.xpath(GET_AVAILABILITY_UNDER_APPOINTMENTPAGE));
        }
    }
    public void bookAppointmentGeneral(String date, String timeSlot) {
        utils.clickBtn(By.xpath(GET_AVAILABILITY_UNDER_APPOINTMENTPAGE));
        utils.clickBtn(By.xpath("//div[@data-apptdate='" + date + "'][@data-appttime='AM (" + timeSlot + ")']"));
        utils.waitForElementVisible(By.xpath("//span[text()='Current Slot: " + date + ", Wed AM (" + timeSlot + ")']"));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void saveAppointments() {
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void populateHazardAndWarningNotes() throws InterruptedException {
        Thread.sleep(1000);
        try {
            utils.returnElement(By.xpath(wlr3_orderDetails_page.APPOINTMENT_TAB_ON_WLR3_ORDER_PAGE)).click();
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.javaScriptExecutorClick(By.xpath(wlr3_orderDetails_page.APPOINTMENT_TAB_ON_WLR3_ORDER_PAGE));
        }
        utils.waitForElementVisible(By.id(wlr3_newProvide__datePage.HAZARD_NOTES_TEXTBOX));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.sendText(By.id(wlr3_newProvide__datePage.HAZARD_NOTES_TEXTBOX), "hazardNotes");
        utils.sendText(By.id(wlr3_newProvide__datePage.WARNING_NOTES_TEXTBOX), "warningNotes");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));

    }
}
