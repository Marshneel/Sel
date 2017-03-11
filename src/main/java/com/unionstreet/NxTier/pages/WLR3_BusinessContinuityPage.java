package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 10/03/2017.
 */
public class WLR3_BusinessContinuityPage {
    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    OrdersManagerPage ordersManagerPage=new OrdersManagerPage();

    public void selectBusinessContinuity() throws InterruptedException {

        try {
            Thread.sleep(1000);
            utils.clickBtn(By.xpath("//a[contains(@onclick,'loadBusinessContinuityPopup')]"));
        } catch (Exception e) {
           wlr3_orderDetails_page.loadTabOnWLR3OrderSummaryPage();
            Thread.sleep(1000);
            utils.clickBtn(By.xpath("//a[contains(@onclick,'loadBusinessContinuityPopup')]"));
        }
        utils.waitForElementVisible(By.id("WLR3Order_site_assurance_option_1"));
        utils.clickBtn(By.id("WLR3Order_site_assurance_option_1"));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
}
