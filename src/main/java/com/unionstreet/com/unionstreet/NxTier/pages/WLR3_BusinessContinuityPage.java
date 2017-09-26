package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

import java.sql.SQLException;

/**
 * Created by RajeshG on 10/03/2017.
 */
public class WLR3_BusinessContinuityPage {

    private final String LOAD_BUSINESS_CONTINUITY_POPUP="//a[contains(@onclick,'loadBusinessContinuityPopup')]";

    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    WLR3_NewProvide_FeaturesPage wlr3_newProvide_featuresPage=new WLR3_NewProvide_FeaturesPage();


    public void loadBusinessContinuity() throws InterruptedException, SQLException {

        try {
            Thread.sleep(1000);
            utils.returnElement(By.xpath(LOAD_BUSINESS_CONTINUITY_POPUP)).click();
        } catch (Exception e) {
            wlr3_orderDetails_page.loadTabOnWLR3OrderSummaryPage();
            Thread.sleep(1000);
            utils.returnElement(By.xpath(LOAD_BUSINESS_CONTINUITY_POPUP)).click();
        }
    }

    public void selectBusinessContinuity() throws InterruptedException, SQLException {
        try {
           // utils.waitForElementVisible(By.id(wlr3_newProvide_featuresPage.BUSINESS_CONTINUITY_CHECKBOX));
            utils.returnElement(By.id(wlr3_newProvide_featuresPage.BUSINESS_CONTINUITY_CHECKBOX)).click();
        } catch (Exception e) {
            wlr3_orderDetails_page.loadTabOnWLR3OrderSummaryPage();
            Thread.sleep(1000);
            utils.clickBtn(By.xpath(LOAD_BUSINESS_CONTINUITY_POPUP));
            utils.waitForElementVisible(By.id(wlr3_newProvide_featuresPage.BUSINESS_CONTINUITY_CHECKBOX));
            utils.clickBtn(By.id(wlr3_newProvide_featuresPage.BUSINESS_CONTINUITY_CHECKBOX));
        }
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
}
