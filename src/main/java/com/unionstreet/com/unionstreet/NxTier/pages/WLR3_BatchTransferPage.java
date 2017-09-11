package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

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
    private final String ADD_TO_BATCH_BUTTON="//button[contains(@onclick,'return wlr3BatchTransferFeatures.Validate();')]";
    private final String UPLOAD_FILE="FileUpload";
    private final String IMPORT_FILE_BUTTON="//button[contains(@onclick,'return wlr3BatchTransferFeatures.ValidateUpload();')]";
    private final String BATCH_TO_BE_TRANSFERRED_TEXT="//h4[contains(text(),'Batch to be transferred')]";
    private final String ABSENCE_OF_BLUE_WARNING_MESSAGE_UPON_IMPORT="//div[@id='assettlistmessagelist'][@style='display:none;']";
    private final String BLUE_WARNING_MESSAGE_FOR_EMPTY_CLI_FIELD="//p[contains(text(),'Telephone Number cannot be empty')]";
    private final String ERROR_MESSAGE_FOR_MISSING_POSTCODE="//span[contains(text(),'The Postcode field is required.')]";
    private final String ERROR_MESSAGE_FOR_MISSING_EMERGENCY_INFO="//span[contains(text(),'The Emergency Information field is required.')]";
    private final String CHECKBOX_TO_AUTO_POPULATE_POSTCODE_AND_EMERGENCY_INFO="UseSiteInfoAsDefault";

    ElementUtils utils=new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();
    NewBusinessCustomerPage newBusinessCustomerPage=new NewBusinessCustomerPage();

    public void addCLIsToTheOrder(String CLI, String postCode ){
        utils.waitForElementVisible(By.xpath(TEXT_ON_BATCH_ORDER_POPUP));
        //clicks add button with empty fields
        utils.clickBtn(By.xpath(ADD_BUTTON));
        //error message
        utils.waitForElementVisible(By.id(ERROR_MESSAGE_UPON_LEAVING_FIELDS_BLANK));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.sendText(By.id(CLI_FIELD),CLI);
        utils.sendText(By.id(POSTCODE_FIELD),postCode);
        utils.sendText(By.id(EMERGENCY_INFO_FIELD),"EmergencyInfo");
        utils.clickBtn(By.xpath(ADD_BUTTON));
        utils.waitForElementVisible(By.xpath("//input[@id='AssettList_0__CLI'][@value='"+CLI+"']"));
        utils.waitForElementVisible(By.xpath("//input[@id='AssettList_0__Postcode'][@value='"+postCode+"']"));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.clickBtn(By.xpath(ADD_TO_BATCH_BUTTON));
    }
    public void loadTXTFile(String path) throws InterruptedException, AWTException {
        utils.waitForElementVisible(By.xpath(TEXT_ON_BATCH_ORDER_POPUP));
        utils.waitForElementVisible(By.id(UPLOAD_FILE));
        Thread.sleep(1000);
        utils.findFieldAndSendKeys(By.id(UPLOAD_FILE),"C:\\TXT files\\"+path+"");
        utils.waitForElementVisible(By.xpath(IMPORT_FILE_BUTTON));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(IMPORT_FILE_BUTTON));}

    public void assertNoErrorUponImport(){
        utils.waitForElementVisible(By.xpath(BATCH_TO_BE_TRANSFERRED_TEXT));
       utils.waitForElementVisible(By.xpath(ABSENCE_OF_BLUE_WARNING_MESSAGE_UPON_IMPORT));
    }
    public void assertErrorMessageUponUploadingTXTfileWithOutCLI(){
        utils.waitForElementVisible(By.xpath(BATCH_TO_BE_TRANSFERRED_TEXT));
        utils.waitForElementVisible(By.xpath(BLUE_WARNING_MESSAGE_FOR_EMPTY_CLI_FIELD));
        utils.assertElementNotPresent(By.xpath(ABSENCE_OF_BLUE_WARNING_MESSAGE_UPON_IMPORT));
    }
    public void assertErrorMessageForPostCodeAndEmergencyInfo(){
        utils.waitForElementVisible(By.xpath(BATCH_TO_BE_TRANSFERRED_TEXT));
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_FOR_MISSING_POSTCODE));
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_FOR_MISSING_EMERGENCY_INFO));
    }
    public void insertPostCodeInToSite() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
      utils.sqlExeQuery("Portal", "test01-sql01", "nxtiere2e", "update Sitedetails set PostCode='LU1 1DQ' where SiteName='"+newBusinessCustomerPage.RanName+"'");
    }
    public void checkPopulateMissingPostCodeAndEmergencyInfo(){
        utils.waitForElementVisible(By.id(CHECKBOX_TO_AUTO_POPULATE_POSTCODE_AND_EMERGENCY_INFO));
        utils.makeSureBoxIsChecked(By.id(CHECKBOX_TO_AUTO_POPULATE_POSTCODE_AND_EMERGENCY_INFO),By.id(CHECKBOX_TO_AUTO_POPULATE_POSTCODE_AND_EMERGENCY_INFO));
    }



}
