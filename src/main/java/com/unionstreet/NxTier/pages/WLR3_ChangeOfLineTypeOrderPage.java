package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 24/02/2017.
 */
public class WLR3_ChangeOfLineTypeOrderPage {

    ElementUtils utils=new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();

    public void addCLIsToTheOrder(String CLI, String postCode,String currentLine,String chooseLine ){
        utils.waitForElementVisible(By.xpath("//div[@id='wlr3OrderDetailPopupDiv']//h3[contains(text(),'WLR3 Change Order')]"));
        //click add button with empty fields
        utils.clickBtn(By.id("manualEntryBtn"));
        utils.sendText(By.id("CLI"),CLI);
        utils.sendText(By.id("Postcode"),postCode);
        utils.clickBtn(By.id("saveBtn"));
        utils.waitForElementVisible(By.xpath("//li[@class='LineTypeSelectionExistingProduct']//label[contains(text(),'"+currentLine+"')]"));
        utils.clickBtn(By.xpath("//li[contains(@onclick,'SelectLineType')]//label[contains(text(),'"+chooseLine+"')]"));
        utils.clickBtn(By.xpath("//button[contains(@onclick,'return ValidateLineType()')]"));
    }

}
