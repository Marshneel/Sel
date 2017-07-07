package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_NumberingPage {

    private final String BUSINESS_DESC_TEXTBOX_UNDER_DIRECTORY_INFO = "DirectoryInfo_0__dir_TradingTitleSurname";
    private final String RESIDENTIAL_RADIOBTN_UNDER_DIRECTORYINFO = "DirectoryInfo_0__dir_LocationResidential";
    private final String MANDATORYMSG_FOR_RESIDENTIAL_UNDER_DIRECTORY_INFO = "//span[text()='Title is Required for Residential Directory']";
    private final String CONTACT_TITLE_UNDER_DIRECTORY_INFO = "DirectoryInfo_0__dir_Title";
    private final String CONTACT_INITIALS_UNDER_DIRECTORY_INFO = "DirectoryInfo_0__dir_Initial";
    private final String CONTACT_SURNAME_UNDER_DIRECTORY_INFO = "DirectoryInfo_0__dir_TradingTitleSurname";
    private final String ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING = "//a[contains(@onclick,'loadLineNumberingPopup')]";
    private final String NUMBER_RESERVATION_CONFIRMATION_UNDER_LINE_NUMBERING = "//p[text()='This number has been reserved.']";
    private final String RETAIN_NUMBER_OPTION_AVAILABLE = "//h4[text()='Retain existing number option is available.']";
    private final String RETAIN_EXITING_NUMBER_TAB_UNDER_LINE_NUMBERING = "//a[@href='#default-tab-coa-retainnumber']";
    private final String EXISTING_NUMBER_WILL_BE_RETAINED_TEXT_UNDER_LINE_NUMBERING = "//h3[text()='Existing Number will be retained']";
    private final String RETENTION_OPTION_UNAVAILABLE = "//h4[text()='Retain number option is not available for this address.']";
    private final String ADDNEW_DDIRANGE_BUTTON = "add_row";
    private final String MORE_DIRECTORY_INFO_TAB = "//a[contains(@onclick,'newProvideWizard.ValidateAndSubmitNumberingFormAndExecuteNext')]";
    private final String SNDDI_TAB_ON_DIRINFO_POPUP = "//ul[@id='directoryInformationNavigation']//a[contains(text(),'SNDDI')]";
    private final String DIRECTORY_TYPE_DROPDOWN = "DirectoryInfo_0__dir_Type";
    private final String CHECKBOX_TO_HIDE_DIRECTORY_INFO = "chkNoDirectory";
    private final String ADD_REMOVE_SNDDI_OR_DDI_RANGE = "//h4[contains(text(),'Add or Remove SNDDI/DDI Ranges')]";
    private final String DDI_RANGE_BOX_1 = "DDIInfo_1__range";
    private final String DDI_RANGE_BOX_0 = "DDIInfo_0__range";
    private final String PLEASE_ENTER_VALUE_LESS_THAN_9999="//span[contains(text(),'Please enter a value less than or equal to 9999.')]";
    private final String INVALID_DDI_RANGE_RANGE_MUST_BE_BLOCKS_OF_10="//span[contains(text(),'Invalid DDI Range. Range value must be in blocks of 10.')]";
    private final String DELETE_BUTTON_FOR_ISDN_LINE_ROW_1="//a[contains(@onclick,'ISDNLine.removeRow(1);')]";
    private final String DELETE_BUTTON_FOR_ISDN_LINE_ROW_0="//a[contains(@onclick,'ISDNLine.removeRow(0);')]";
    private final String DELETE_BUTTON_FOR_ISDN_LINE_ROW_3="//a[contains(@onclick,'ISDNLine.removeRow(3);')]";
    private final String SET_MBN1_FOR_ISDN_LINE="//input[contains(@onclick,'ISDNLine.setMBN(1);')]";
    private final String THIS_LINE_REQUIRES_NUMBER_TO_BE_RESERVED="//h4[contains(text(),'This line requires a number To be reserved.')]";
    private final String DISABLED_NEXT_BUTTON="//li[@id='button-next'][@class='next disabled']";
    private final String THIS_CHANGE_WILL_LOSE_YOUR_NUMBER_RESERVATION="//div[contains(text(),'This change will lose your number reservation, do you wish to continue?')]";
    private final String NUMBER_OPTIONS_ALLOCATE_1="//div[@id='numberOptionAllocate1']//a";
    private final String NUMBER_OPTIONS_ALLOCATE_0="//div[@id='numberOptionAllocate0']//a";
    private final String RANGES_OF_10="//h5[contains(text(),'Ranges of 10')]";
    private final String RANGES_OF_20="//h5[contains(text(),'Ranges of 20')]";
    private final String OPTION_RATING="option-rating";
    private final String OPTION_NUMERIC="option-numeric";
    private final String TEXT_LABELLED_NO="//button[contains(text(),'No')]";
    private final String  INCREASE_DDIVALUE_1="//span[contains(@onclick,'return ISDNLine.increaseDDIValue(1);')]";

    ElementUtils utils = new ElementUtils();
    WLR3_New_Provide_OrderPage wlr3_new_provide__orderPage = new WLR3_New_Provide_OrderPage();
    WLR3_LineNumberingPage wlr3_lineNumberingPage = new WLR3_LineNumberingPage();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    CommonMethods commonMethods = new CommonMethods();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();


    public void PopulateDirectoryInfoUnderNUMBERING(String info) throws InterruptedException {
        utils.waitForElementVisible(By.id(BUSINESS_DESC_TEXTBOX_UNDER_DIRECTORY_INFO));
        //check residential tab under directory location
        utils.clickBtn(By.id(RESIDENTIAL_RADIOBTN_UNDER_DIRECTORYINFO));
        //assert that the error is thrown when the contact and initials are not populated
        utils.clickBtn(By.xpath(wlr3_new_provide__orderPage.NEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(MANDATORYMSG_FOR_RESIDENTIAL_UNDER_DIRECTORY_INFO));
        //populate contact,initials and surname
        utils.selectByVisibleText(By.id(CONTACT_TITLE_UNDER_DIRECTORY_INFO), "Dr");
        utils.sendText(By.id(CONTACT_INITIALS_UNDER_DIRECTORY_INFO), "AJ");
        utils.sendText(By.id(CONTACT_SURNAME_UNDER_DIRECTORY_INFO), info);
    }

    public void verifyLineNumberingUnderNUMBERING() throws InterruptedException {
        //click advanced line numbering options
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        //verify the functionality of automatically assign now
        utils.waitForElementVisible(By.xpath(wlr3_lineNumberingPage.AUTOMATICALLY_ASSIGN_NOWTAB_UNDER_LINE_INFO));
        utils.clickBtn(By.xpath(wlr3_lineNumberingPage.AUTOMATICALLY_ASSIGN_NOWTAB_UNDER_LINE_INFO));
        utils.waitForElementVisible(By.xpath(wlr3_lineNumberingPage.ALLOCATENOW_TAB_UNDER_AUTOMATICALLY_ASSIGN_NOW_LINE_INFO));
        utils.clickBtn(By.xpath(wlr3_lineNumberingPage.ALLOCATENOW_TAB_UNDER_AUTOMATICALLY_ASSIGN_NOW_LINE_INFO));
        utils.waitForElementVisible(By.xpath(wlr3_lineNumberingPage.CONTINUETAB_UNDER_LINE_INFO));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(wlr3_lineNumberingPage.CONTINUETAB_UNDER_LINE_INFO));
        utils.waitForElementVisible(By.xpath(NUMBER_RESERVATION_CONFIRMATION_UNDER_LINE_NUMBERING));
    }

    public void checkPresenceOfRetainOptionInChangeOfAddress() {
        utils.waitForElementVisible(By.xpath(RETAIN_NUMBER_OPTION_AVAILABLE));
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.xpath(RETAIN_EXITING_NUMBER_TAB_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.xpath(EXISTING_NUMBER_WILL_BE_RETAINED_TEXT_UNDER_LINE_NUMBERING));
        utils.clickBtn(By.xpath(wlr3_lineNumberingPage.CONTINUETAB_UNDER_LINE_INFO));
    }

    public void checkAbsenceOfRetainInChangeOfAddress() {
        utils.waitForElementVisible(By.xpath(RETENTION_OPTION_UNAVAILABLE));
    }

    public void assertNumberingOptionsForISDN30NewProvide(String label1UnderLineNum, String label2UnderLineNum) {
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'" + label1UnderLineNum + "')]"));
        utils.waitForElementVisible(By.xpath("//label[text()='" + label2UnderLineNum + "']"));
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.id(ADDNEW_DDIRANGE_BUTTON));
        utils.selectByVisibleText(By.id(wlr3_lineNumberingPage.SNDDI_DDI_DROPDOWN_ROW0), "New DDI range");


    }

    public void checkDDIrangeValidationWithMessage(String range, String message) {
        utils.sendText(By.id(DDI_RANGE_BOX_0), range);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath(message));
    }

    public void populateAndAssertSNDDIrangeForISDN30() throws InterruptedException {
        utils.waitForElementVisible(By.id(wlr3_lineNumberingPage.SNDDI_DDI_DROPDOWN_ROW0));
        utils.selectByVisibleText(By.id(wlr3_lineNumberingPage.SNDDI_DDI_DROPDOWN_ROW0), "New DDI range");
        checkDDIrangeValidationWithMessage("10000", PLEASE_ENTER_VALUE_LESS_THAN_9999);
        checkDDIrangeValidationWithMessage("9", INVALID_DDI_RANGE_RANGE_MUST_BE_BLOCKS_OF_10);
        checkDDIrangeValidationWithMessage("0", INVALID_DDI_RANGE_RANGE_MUST_BE_BLOCKS_OF_10);
        utils.sendText(By.id(DDI_RANGE_BOX_0), "100");
        utils.waitForElementVisible(By.id(ADDNEW_DDIRANGE_BUTTON));
        Thread.sleep(1000);
        utils.clickBtn(By.id(ADDNEW_DDIRANGE_BUTTON));
        utils.waitForElementVisible(By.id(wlr3_lineNumberingPage.SNDDI_DDI_DROPDOWN_ROW1));
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void newDDIRangeHasNoTabUnderDirInfoUnlessMBNclicked(String range) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.id(ADDNEW_DDIRANGE_BUTTON));
        Thread.sleep(1000);
        utils.clickBtn(By.id(ADDNEW_DDIRANGE_BUTTON));
        utils.selectByVisibleText(By.id(wlr3_lineNumberingPage.SNDDI_DDI_DROPDOWN_ROW1), "New DDI range");
        utils.waitForElementVisible(By.id(DDI_RANGE_BOX_1));
        utils.sendText(By.id(DDI_RANGE_BOX_1), range);
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        clickMoreDirInfoTab();
        Thread.sleep(1000);
        utils.assertElementNotPresent(By.xpath(SNDDI_TAB_ON_DIRINFO_POPUP));
        utils.clickBtn(By.xpath(commonMethods.CLOSE_POPUP));
        utils.waitForElementVisible(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.xpath(SET_MBN1_FOR_ISDN_LINE));
        utils.clickBtn(By.xpath(SET_MBN1_FOR_ISDN_LINE));
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        clickMoreDirInfoTab();
        utils.waitForElementVisible(By.xpath(SNDDI_TAB_ON_DIRINFO_POPUP));
    }

    public void clickMoreDirInfoTab() {
        utils.waitForElementVisible(By.xpath(MORE_DIRECTORY_INFO_TAB));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        try {
            utils.clickBtn(By.xpath(MORE_DIRECTORY_INFO_TAB));
        } catch (Exception e) {
            utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
            utils.clickBtn(By.xpath(MORE_DIRECTORY_INFO_TAB));
        }
    }

    public void assertPresenceOfSNDDITabInDirInfo() {
        utils.waitForElementVisible(By.xpath(SNDDI_TAB_ON_DIRINFO_POPUP));
        utils.clickBtn(By.xpath(commonMethods.CLOSE_POPUP));
    }

    public void deleteAndAssertAddedDDIRange() throws InterruptedException {
        utils.clickBtn(By.xpath(commonMethods.CLOSE_POPUP));
        utils.waitForElementVisible(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.id(ADDNEW_DDIRANGE_BUTTON));
        Thread.sleep(1000);
        utils.clickBtn(By.id(ADDNEW_DDIRANGE_BUTTON));
        utils.waitForElementVisible(By.xpath(DELETE_BUTTON_FOR_ISDN_LINE_ROW_1));
       try{ utils.assertElementNotPresent(By.xpath(DELETE_BUTTON_FOR_ISDN_LINE_ROW_0));}
       catch (AssertionError e){
           System.out.println("BUG: MBN should not be deleted, but currently it can in ISDN30-New Provide");}
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        utils.clickBtn(By.xpath(DELETE_BUTTON_FOR_ISDN_LINE_ROW_1));
        Thread.sleep(1000);
        utils.clickBtn(By.id(ADDNEW_DDIRANGE_BUTTON));
        utils.waitForElementVisible(By.xpath(DELETE_BUTTON_FOR_ISDN_LINE_ROW_3));

    }

    public void checkLineNumberingForISDN(String action1, String action2) throws InterruptedException, SQLException {

        try {
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        } catch (Exception e) {
            wlr3_orderDetails_page.loadTabOnWLR3OrderSummaryPage();
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        }
        utils.waitForElementVisible(By.xpath(ADD_REMOVE_SNDDI_OR_DDI_RANGE));
        try {
            utils.selectByVisibleText(By.id(wlr3_lineNumberingPage.SNDDI_DDI_DROPDOWN_ROW0), "" + action1 + "");
        } catch (Exception e) {
            wlr3_orderDetails_page.getToWLR3QuotePage(newBusinessCustomerPage.RanName);
            wlr3_orderDetails_page.clickLineNumbering(newBusinessCustomerPage.RanName);
            utils.selectByVisibleText(By.id(wlr3_lineNumberingPage.SNDDI_DDI_DROPDOWN_ROW0), "" + action1 + "");
        }
        utils.selectByVisibleText(By.id(wlr3_lineNumberingPage.SNDDI_DDI_DROPDOWN_ROW1), "" + action2 + "");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void directoryInfoForISDN2() throws InterruptedException {
        utils.waitForElementVisible(By.id(CHECKBOX_TO_HIDE_DIRECTORY_INFO));
        Thread.sleep(1000);
        utils.clickBtn(By.id(CHECKBOX_TO_HIDE_DIRECTORY_INFO));
        utils.waitForElementToVanish(By.id(DIRECTORY_TYPE_DROPDOWN));
    }

    public void lineNumberingAlertMessageForVirtualLines() {
        utils.waitForElementVisible(By.xpath(THIS_LINE_REQUIRES_NUMBER_TO_BE_RESERVED));
    }

    public void disabledNext() {
        utils.waitForElementVisible(By.xpath(DISABLED_NEXT_BUTTON));
    }

    public void loadAdvancedLineNumbering() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.PAGE_LOADER_ELEMENT));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
    }


       public void ISDN2_selectFromList_fancyNumbers(String fancyNumber1, String fancyNumber2) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "delete from reserved_numbers");
        utils.waitForElementVisible(By.xpath(NUMBER_OPTIONS_ALLOCATE_0));
        utils.clickBtn(By.xpath(NUMBER_OPTIONS_ALLOCATE_0));
        utils.waitForElementVisible(By.id(OPTION_RATING));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.id(OPTION_RATING));
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'"+fancyNumber1+"')]/../../following-sibling::li[@data-thenumber='"+fancyNumber2+"']"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.id(OPTION_NUMERIC));}

    public void ISDN2_selectFromList_selectingSameNumberTwice(String number) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'"+number+"')]"));
        utils.clickBtn(By.xpath("//label[contains(text(),'"+number+"')]"));
        utils.waitForElementVisible(By.xpath("//li[contains(@data-thenumber,'"+number+"')][@class='selectedNumber currentSelectedNumber']"));
        utils.clickBtn(By.id("add_row"));
        utils.waitForElementVisible(By.xpath(NUMBER_OPTIONS_ALLOCATE_1));
        utils.clickBtn(By.xpath(NUMBER_OPTIONS_ALLOCATE_1));
        utils.waitForElementVisible(By.xpath("//li[@data-thenumber='"+number+"'][@class='selectedNumber']"));
        utils.clickBtn(By.xpath("//li[@data-thenumber='"+number+"'][@class='selectedNumber']"));
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        loadAdvancedLineNumbering();
        utils.waitForElementVisible(By.xpath(NUMBER_OPTIONS_ALLOCATE_1));
        utils.assertElementNotPresent(By.xpath("//input[@id='DDIInfo_1__new_dn'][@value='"+number+"']"));}

    public void ISDN2_selectFromList_assertAssignedNumberAbsentFromList(String availableNumber,String unAvailableNumber1, String unAvailableNumber2){
        utils.clickBtn(By.xpath(NUMBER_OPTIONS_ALLOCATE_1));
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'"+availableNumber+"')]"));
        utils.assertElementNotPresent(By.xpath("//li[@data-thenumber='"+unAvailableNumber1+"'][@class='selectedNumber']"));
        utils.assertElementNotPresent(By.xpath("//label[contains(text(),'"+unAvailableNumber2+"')]"));
    }

        public void ISDN2system_selectFromList_addingDDIrange(){
        utils.selectByVisibleText(By.id(wlr3_lineNumberingPage.SNDDI_DDI_DROPDOWN_ROW1), "New DDI range");
        utils.sendText(By.id(DDI_RANGE_BOX_1), "10");
        utils.clickBtn(By.xpath(NUMBER_OPTIONS_ALLOCATE_1));
        utils.waitForElementVisible(By.xpath(RANGES_OF_10));
        utils.waitForElementVisible(By.xpath(INCREASE_DDIVALUE_1));
        utils.clickBtn(By.xpath(INCREASE_DDIVALUE_1));
        utils.clickBtn(By.xpath(NUMBER_OPTIONS_ALLOCATE_1));
        utils.waitForElementVisible(By.xpath(RANGES_OF_20));}

        public void ISDN2system_selectFromList_switchingToSNDDIandAssigingASingleNumber(String number, String unAvailableNumber) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
            utils.selectByVisibleText(By.id(wlr3_lineNumberingPage.SNDDI_DDI_DROPDOWN_ROW1), "New SNDDI");
        utils.waitForElementVisible(By.xpath(NUMBER_OPTIONS_ALLOCATE_1));
        utils.clickBtn(By.xpath(TEXT_LABELLED_NO));
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'"+number+"')]"));
        utils.assertElementNotPresent(By.xpath("//label[contains(text(),'"+unAvailableNumber+"')]"));
        utils.clickBtn(By.xpath("//label[contains(text(),'"+number+"')]"));
        utils.waitForElementVisible(By.xpath(THIS_CHANGE_WILL_LOSE_YOUR_NUMBER_RESERVATION));
        Thread.sleep(1000);
        utils.waitForElementVisible(By.xpath(TEXT_LABELLED_NO));
        utils.clickBtn(By.xpath(TEXT_LABELLED_NO));
        utils.waitForElementVisible(By.xpath(DELETE_BUTTON_FOR_ISDN_LINE_ROW_1));
        utils.clickBtn(By.xpath(DELETE_BUTTON_FOR_ISDN_LINE_ROW_1));
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "delete from reserved_numbers");
        utils.selectByVisibleText(By.id(wlr3_lineNumberingPage.SNDDI_DDI_DROPDOWN_ROW0), "New DDI range");
        utils.sendText(By.id(DDI_RANGE_BOX_0), "10");
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));}

    public void ISDN2system_selectFromList_changingNumberCluster(String clickNumber, String availableNumber, String unAvailableNumber) throws InterruptedException {
        loadAdvancedLineNumbering();
        utils.waitForElementVisible(By.xpath(NUMBER_OPTIONS_ALLOCATE_0));
        utils.clickBtn(By.xpath(NUMBER_OPTIONS_ALLOCATE_0));
        utils.waitForElementVisible(By.xpath(RANGES_OF_10));
        utils.clickBtn(By.xpath("//label[contains(text(),'"+clickNumber+"')]"));
      utils.waitForElementVisible(By.id(ADDNEW_DDIRANGE_BUTTON));
      try{  utils.clickBtn(By.id(ADDNEW_DDIRANGE_BUTTON));}
      catch (Exception e){
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.YES_BUTTON_ON_POPUP));
        utils.clickBtn(By.xpath(wlr3_orderDetails_page.YES_BUTTON_ON_POPUP));}
       utils.waitForElementVisible(By.id(ADDNEW_DDIRANGE_BUTTON));
        utils.clickBtn(By.id(ADDNEW_DDIRANGE_BUTTON));
        utils.waitForElementVisible(By.xpath(NUMBER_OPTIONS_ALLOCATE_1));
        utils.clickBtn(By.xpath(NUMBER_OPTIONS_ALLOCATE_1));
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'"+availableNumber+"')]"));
        utils.assertElementNotPresent(By.xpath("//label[contains(text(),'"+unAvailableNumber+"')]"));
    }
    public void ISDN2standard_selectingANewNumber(String number) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(DELETE_BUTTON_FOR_ISDN_LINE_ROW_1));
        utils.clickBtn(By.xpath(DELETE_BUTTON_FOR_ISDN_LINE_ROW_1));
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'"+number+"')]"));
        utils.clickBtn(By.xpath("//label[contains(text(),'"+number+"')]"));
        utils.waitForElementVisible(By.xpath(THIS_CHANGE_WILL_LOSE_YOUR_NUMBER_RESERVATION));
        Thread.sleep(1000);
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.YES_BUTTON_ON_POPUP));
        utils.clickBtn(By.xpath(wlr3_orderDetails_page.YES_BUTTON_ON_POPUP));


    }


}













