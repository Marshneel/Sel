package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 29/03/2017.
 */
public class WLR3_Summary_Charges_Page {
    ElementUtils utils=new ElementUtils();

    public void editChargesForISDN30Modify() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//a[contains(@onclick,'loadWLR3Charges')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[contains(@onclick,'loadWLR3Charges')]"));
        utils.clickBtn(By.xpath("//a[contains(@onclick,'getWLR3ChargesEdit')]"));
        utils.waitForElementVisible(By.xpath("//button[contains(@onclick,'saveWLR3Charges')]"));
        utils.sendText(By.id("ChargeList_0__install_charge"), "100");
        utils.sendText(By.id("ChargeList_0__recurring_charge"), "200");
        utils.selectByVisibleText(By.id("ChargeList_0__freq_id"), "Annual");
        utils.clickBtn(By.xpath("//button[contains(@onclick,'saveWLR3Charges')]"));
        Thread.sleep(1000);
        try {
            utils.clickBtn(By.xpath("//div[@id='popupDiv']//button[@id='closeBtn']"));
        } catch (Exception e) {
            Thread.sleep(1000);
            utils.clickBtn(By.xpath("//div[@id='popupDiv']//button[@id='closeBtn']"));

        }
    }}