package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class WLR3_AppointmentPage {
    //// TODO: 06/01/2017
    private final String GET_AVAILABILITY_UNDER_APPOINTMENTPAGE = "//a[contains(@onclick,'showNewBookAppointmentPopup')]";

    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();

    public void accessAppointmentpage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(GET_AVAILABILITY_UNDER_APPOINTMENTPAGE));
        try {
            utils.clickBtnWithWait(By.xpath(GET_AVAILABILITY_UNDER_APPOINTMENTPAGE));
        } catch (Exception e) {
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
}