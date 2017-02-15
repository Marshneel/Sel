package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class WLR_and_NxTierServicesPage {

    private final String SERVICE_INVENTORY_MANAGER = "//a[contains(@href,'ServiceInventoryManager')]";
    private final String AGENT_AND_RESELLER_SERVICE = "//a[text()='ServiceForAgent&Reseller']";
    private final String ASSIGN_SERVICE_INVENTORY = "HrefAssignServiceInventory";
    ElementUtils utils = new ElementUtils();

    public void accessingAssignServicePage() throws InterruptedException {
        utils.clickBtn(By.xpath(SERVICE_INVENTORY_MANAGER));
        utils.clickBtn(By.xpath(AGENT_AND_RESELLER_SERVICE));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id(ASSIGN_SERVICE_INVENTORY));
        utils.clickBtn(By.id(ASSIGN_SERVICE_INVENTORY));
    }
    public void verifyCurrentLine(String line){
        utils.waitForElementVisible(By.xpath("//li[@id='line_2']//label[contains(text(),'"+line+"')]"));
        utils.clickBtn(By.xpath("//button[contains(@onclick,'return ValidateLineType')]"));


    }
}
