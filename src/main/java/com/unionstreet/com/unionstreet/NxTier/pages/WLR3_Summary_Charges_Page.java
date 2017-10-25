package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 29/03/2017.
 */
public class WLR3_Summary_Charges_Page {
    ElementUtils utils=new ElementUtils();
    CommonMethods commonMethods=new CommonMethods();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();


    private final String LOAD_CHARGES_ON_WLR3_EDIT_ORDER_PAGE="//a[contains(@onclick,'loadWLR3Charges')]";
    private final String EDIT_BUTTON_ON_WLR3_CHARGE_SUMMARY_POPUP="//a[contains(@onclick,'getWLR3ChargesEdit')]";
    private final String SAVE_EDITED_CHARGES_ON_WLR3_CHARGES_POPUP="//button[contains(@onclick,'saveWLR3Charges')]";
    public final String FIRST_ROW_CHARGE_FIELD_UNDER_SETUP = "ChargeList_0__install_charge";
    private final String FIRST_ROW_CHARGE_FIELD_UNDER_RENTAL="ChargeList_0__recurring_charge";
    private final String FIRST_ROW_DURATION_UNDER_FREQUENCY="ChargeList_0__freq_id";

    public void editChargesForISDN30Modify() throws InterruptedException {
       utils.waitForElementVisible(By.xpath(LOAD_CHARGES_ON_WLR3_EDIT_ORDER_PAGE));
        Thread.sleep(1000);
      try{  utils.clickBtn(By.xpath(LOAD_CHARGES_ON_WLR3_EDIT_ORDER_PAGE));}
      catch (Exception e){
          Thread.sleep(1000);
          utils.clickBtn(By.xpath(LOAD_CHARGES_ON_WLR3_EDIT_ORDER_PAGE));
      }
        utils.waitForElementVisible(By.xpath(EDIT_BUTTON_ON_WLR3_CHARGE_SUMMARY_POPUP));
        utils.clickBtn(By.xpath(EDIT_BUTTON_ON_WLR3_CHARGE_SUMMARY_POPUP));
        utils.waitForElementVisible(By.xpath(SAVE_EDITED_CHARGES_ON_WLR3_CHARGES_POPUP));
        utils.sendText(By.id(FIRST_ROW_CHARGE_FIELD_UNDER_SETUP), "100");
        utils.sendText(By.id(FIRST_ROW_CHARGE_FIELD_UNDER_RENTAL), "200");
        utils.selectByVisibleText(By.id(FIRST_ROW_DURATION_UNDER_FREQUENCY), "Annual");
        utils.clickBtn(By.xpath(SAVE_EDITED_CHARGES_ON_WLR3_CHARGES_POPUP));
        Thread.sleep(1000);
        try {
            utils.clickBtn(By.xpath(commonMethods.CLOSE_POPUP));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.clickBtn(By.xpath(commonMethods.CLOSE_POPUP));

        }
    }}