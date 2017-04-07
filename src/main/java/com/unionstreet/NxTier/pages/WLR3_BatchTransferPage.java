package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

    ElementUtils utils=new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();
    NewBusinessCustomerPage newBusinessCustomerPage=new NewBusinessCustomerPage();

    public void addCLIsToTheOrder(String CLI, String postCode ){
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
        utils.waitForElementVisible(By.xpath("//input[@id='AssettList_0__CLI'][@value='"+CLI+"']"));
        utils.waitForElementVisible(By.xpath("//input[@id='AssettList_0__Postcode'][@value='"+postCode+"']"));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.clickBtn(By.xpath(ADD_TO_BATCH_BUTTON));
    }
    public void loadCSVFile(String path) throws InterruptedException, AWTException {
        utils.waitForElementVisible(By.xpath(TEXT_ON_BATCH_ORDER_POPUP));
        utils.waitForElementVisible(By.id("FileUpload"));
       utils.clickBtn(By.id("FileUpload"));
        StringSelection ss=new StringSelection("C:\\CSV files\\"+path+"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        utils.waitForElementVisible(By.xpath("//button[contains(@onclick,'return wlr3BatchTransferFeatures.ValidateUpload();')]"));
        utils.clickBtn(By.xpath("//button[contains(@onclick,'return wlr3BatchTransferFeatures.ValidateUpload();')]"));}

    public void assertNoErrorUponImport(){
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Batch to be transferred')]"));
       utils.waitForElementVisible(By.xpath("//div[@id='assettlistmessagelist'][@style='display:none;']"));
    }
    public void assertErrorMessageUponUploadingCSVfileWithOutCLI(){
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Batch to be transferred')]"));
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'Telephone Number cannot be empty')]"));
        utils.assertElementNotPresent(By.xpath("//div[@id='assettlistmessagelist'][@style='display:none;']"));
    }
    public void assertErrorMessageForPostCodeAndEmergencyInfo(){
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Batch to be transferred')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'The Postcode field is required.')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'The Emergency Information field is required.')]"));
    }
    public void insertPostCodeInToSite() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
      utils.sqlExeQuery("Portal", "test01-sql01", "nxtiere2e", "update Sitedetails set PostCode='LU1 1DQ' where SiteName='"+newBusinessCustomerPage.RanName+"'");
    }
    public void checkPopulateMissingPostCodeAndEmergencyInfo(){
        utils.waitForElementVisible(By.id("UseSiteInfoAsDefault"));
        utils.makeSureBoxIsChecked(By.id("UseSiteInfoAsDefault"),By.id("UseSiteInfoAsDefault"));
    }



}
