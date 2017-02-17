package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 17/02/2017.
 */
public class WLR3_BatchTransferPage {

    private final String TEXT_ON_BATCH_ORDER_POPUP="//div[@id='wlr3OrderDetailPopupDiv']//h3[contains(text(),'Add lines to order')]";
    private final String ADD_BUTTON="//button[contains(@onclick,'return wlr3BatchTransferFeatures.ValidateManualUpload();')]";
    private final String ERROR_MESSAGE_UPON_LEAVING_FIELDS_BLANK="singleItemError";
    private final String CLI_FIELD="SingleItem_ManualCLI";
    private final String POSTCODE_FIELD="SingleItem_ManualPostCode";
    private final String EMERGENCY_INFO_FIELD="SingleItem_ManualEmergencyInfo";
    private final String DELETE_BUTTON="//a[contains(@onclick,'return wlr3BatchTransferFeatures.RemoveRow')]";
    private final String ADD_TO_BATCH_BUTTON="//button[contains(@onclick,'return wlr3BatchTransferFeatures.Validate();')]";

    ElementUtils utils=new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();

    public void addCLIsToTheOrder(String CLI, String postCode){
        utils.waitForElementVisible(By.xpath(TEXT_ON_BATCH_ORDER_POPUP));
        //click add button with empty fields
        utils.clickBtn(By.xpath(ADD_BUTTON));
        //error message
        utils.waitForElementVisible(By.id(ERROR_MESSAGE_UPON_LEAVING_FIELDS_BLANK));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.sendText(By.id(CLI_FIELD),CLI);
        utils.sendText(By.id(POSTCODE_FIELD),postCode);
        utils.sendText(By.id(EMERGENCY_INFO_FIELD),"EmergencyInfo");
        utils.clickBtn(By.xpath(ADD_BUTTON));
        utils.waitForElementVisible(By.xpath(DELETE_BUTTON));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.clickBtn(By.xpath(ADD_TO_BATCH_BUTTON));
    }


}
