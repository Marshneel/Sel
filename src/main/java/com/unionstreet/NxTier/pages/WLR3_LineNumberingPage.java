package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 06/01/2017.
 */
public class WLR3_LineNumberingPage {

    private final String IMPORT_FROM_ANOTHER_NETWORK_TAB = "//a[@href='#default-tab-Import_from_other_network']";
    private final String ENTER_NUMBER_TEXT_BOX_UNDER_IMPORT_FROM_ANOTHER_NETWORK = "WLR3Order_porting_dn";
    private final String MOVE_NUMBER_FROM_ANOTHER_ADDRESS_CHECK_BOX = "WLR3Order_move_indicator";
    private final String MOVE_NUMBER_FROM_ANOTHER_ADDRESS_POSTCODE = "WLR3Order_current_postcode";
    private final String RESERVETAB_UNDER_IMPORT_FROM_ANOTHER_NETWORK = "buttonImportFromOtherNetworkReserve";
    private final String CONTINUE_AFTER_IMPORTING_FROM_ANOTHER_NETWORK = "//div[@id='reservedPortNumber']//a";
    private final String NO_CHANGE_TAB = "//a[@href='#default-tab-No_change']";
    private final String NO_CHANGES_TO_LINE_CONTINUE_BUTTON = "//a[@onclick='lineNumbering.submitChanges(0);']";
    private final String LETTER_OF_AUTHORITY_CHECKBOX = "WLR3Order_letter_of_authority";
    private final String CONTINUE_AFTER_LETTER_OF_AUTHORITY_CHECKED_IN = "submitImportFromOtherNetworkContinue";
    private final String AUTOMATICALLY_ASSIGNTAB_UNDER_LINE_INFO = "//a[@href='#default-tab-Automatically_assign']";
    private final String CONTINUETAB_UNDER_AUTOMATICALLY_ASSIGN_LINE_INFO = "//a[@onclick='lineNumbering.submitChanges(1);']";
    public final String CONTINUETAB_UNDER_LINE_INFO = "//a[contains(@onclick,'return lineNumbering.hidePopup();')][contains(text(),'Continue')]";
    private final String AUTOMATICALLY_ALLOCATED_TEXT_ON_WLR_ORDERDETAILS_PAGE = "//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'Automatically Allocate')]]";
    private final String TEXTBOX_UNDER_SPECIFY_NEW_NUMBER_LINEINFO = "SpecificNewNumberToReserve";
    private final String RESERVETAB_UNDER_SPECIFY_NEW_NUMBER_LINE_INFO = "//a[contains(@onclick,'return lineNumbering.reservedSpecificNumber')]";
    private final String GET_NUMBERSTAB_UNDER_SELECT_FROM_LIST_LINE_INFO = "//button[contains(@onclick,'return lineNumbering.getAvailableNumbers')]";
    private final String RESERVETAB_UNDER_SELECT_FROM_LIST_LINE_INFO = "//a[contains(@onclick,'return lineNumbering.reservedSelectedNumber')]";
    public final String ALLOCATENOW_TAB_UNDER_AUTOMATICALLY_ASSIGN_NOW_LINE_INFO = "//a[contains(@onclick,'return lineNumbering.assignNow')]";
    private final String VIC_TEXTBOX_UNDER_LINE_INFO = "WLR3Order_vic";
    private final String SPECIFY_NEW_NUMBERTAB_UNDER_LINE_NUM = "//a[@href='#default-tab-Specify_new_number']";
    private final String SELECT_FROM_LISTTAB_UNDER_LINE_INFO = "//a[@href='#default-tab-Select_from_list']";
    public final String AUTOMATICALLY_ASSIGN_NOWTAB_UNDER_LINE_INFO = "//a[@href='#default-tab-Automatically_assign_now']";
    private final String ALERT_ON_LINE_INFO = "//div[@class='alert alert-danger']";
    private final String CONTINUETAB_UNDER_IMPORT_FROM_OTHER_NETWORK_LINE_INFO = "submitImportFromOtherNetworkContinue";
    private final String ADD_NEW_DDI = "//a[contains(text(),'Add New DDI / DDI Range')]";
    private final String VALIDATION_TO_PREVENT_ADDITION_OF_NEW_SNDDI = "//div[contains(text(),'Maximum 5 SNDDIs/DDI Ranges can be active. You can delete an existing row to add a new one.')]";
    private final String VALIDATION_TO_PREVENT_ACTIVATION_OF_EXISTING_SNDDI = "//div[contains(text(),'Maximum 5 SNDDIs/DDI Ranges can be active')]";
    private final String OK_BUTTON_ON_NEW_OR_REACTIVATE_OLD_SNDDI_VALIDATION_POPUP = "//button[contains(text(),'Ok')]";
    public final String SNDDI_DDI_DROPDOWN_ROW0 = "DDIInfo_0__action";
    public final String SNDDI_DDI_DROPDOWN_ROW1 = "DDIInfo_1__action";
    private final String SNDDI_DDI_DROPDOWN_ROW2 = "DDIInfo_2__action";
    private final String DELETE_TEXT_UNDER_LINE_NUMBERING_WLR3_ORDER_DETAILS_PAGE = "//div[contains(text(),'Remove')]";
    private final String ASSERTING_NEWLY_ADDED_SNDDI_UNDER_NUMBERING_SUMMARY = "//select[@id='numberOption5']//option[contains(text(),'Allocate')]";
    private final String ASSERTING_NEWLY_ADDED_SNDDI_UNDER_ACTION = "//option[contains(text(),'New SNDDI')]";
    private final String THIRD_ROW_MBN_RADIO_BUTTON = "//input[contains(@onclick,'ISDNLine.setMBN(2);')]";
    private final String SECOND_ROW_MBN_RADIO_BUTTON = "//input[contains(@onclick,'ISDNLine.setMBN(1);')]";
    private final String CLI_FIELD_FOR_CALL_REDIRECT_OR_FORWARD="WLR3Order_ForwardedOrRedirectedTo";
    private final String TAKE_NUMBER_FROM_ANOTHER_WORKING_LINE_TAB="//a[contains(@href,'#default-tab-Take_from_another_working_line')]";
    private final String TAKE_NUMBER_BUTTON="//a[contains(text(),'Take Number')]";
    private final String ERROR_MESSAGE_FOR_EMPTY_TAKE_OVER_NUMBER_FIELD="//div[contains(text(),'Please specify the number to take over.')]";
    private final String ERROR_MESSAGE_FOR_EMPTY_POSTCODE="//div[text()[contains(.,'Postcode field is mandatory.')]]";
    private final String ERROR_MESSAGE_TO_PROVIDE_CORRECT_DETAILS="//div[text()[contains(.,'Please correct the details below before continuing!')]]";
    private final String TAKE_OVER_NUMBER_FIELD="WLR3Order_donated_number";
    private final String TAKE_OVER_NUMBER_POSTCODE="WLR3Order_current_postcode";
    private final String NUMBER_SUCCESSFULLY_TAKEN_AND_SAVED_MESSAGE="//p[contains(text(),'Successfully taken and saved')]";
    private final String  EMPTY_FIELD_ERROR_MESSAGE="//span[contains(text(),'This field is required.')]";
    private final String FIELD_TO_SPECIFY_NUMBER_FOR_RESERVATION="SpecificNewNumberToReserve";

    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    CommonMethods commonMethods = new CommonMethods();


    public void lineNumberingAutomaticallyAssignWithAssertions() throws InterruptedException, SQLException {
        utils.waitForElementVisible(By.xpath(AUTOMATICALLY_ASSIGNTAB_UNDER_LINE_INFO));
        try {
            utils.clickBtn(By.xpath(AUTOMATICALLY_ASSIGNTAB_UNDER_LINE_INFO));
            utils.clickBtn(By.xpath(CONTINUETAB_UNDER_AUTOMATICALLY_ASSIGN_LINE_INFO));
        } catch (Exception e) {
            utils.clickBtn(By.xpath(AUTOMATICALLY_ASSIGNTAB_UNDER_LINE_INFO));
            utils.clickBtn(By.xpath(CONTINUETAB_UNDER_AUTOMATICALLY_ASSIGN_LINE_INFO));
        }

        utils.jumpToParentPopUp();
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.LINE_NUMBERING_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath(AUTOMATICALLY_ALLOCATED_TEXT_ON_WLR_ORDERDETAILS_PAGE));
    }

    public void lineNumberingSpecifyNewNumber(String number) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "delete from dbo.reserved_numbers where number='" + number + "'");
        utils.waitForElementVisible(By.xpath(SPECIFY_NEW_NUMBERTAB_UNDER_LINE_NUM));
        try {
            utils.clickBtn(By.xpath(SPECIFY_NEW_NUMBERTAB_UNDER_LINE_NUM));
            utils.clickBtn(By.id(TEXTBOX_UNDER_SPECIFY_NEW_NUMBER_LINEINFO));
        } catch (Exception e) {
            utils.clickBtn(By.xpath(SPECIFY_NEW_NUMBERTAB_UNDER_LINE_NUM));
            utils.clickBtn(By.id(TEXTBOX_UNDER_SPECIFY_NEW_NUMBER_LINEINFO));
        }
        utils.sendText(By.id(TEXTBOX_UNDER_SPECIFY_NEW_NUMBER_LINEINFO), "" + number + "");
        utils.clickBtn(By.xpath(RESERVETAB_UNDER_SPECIFY_NEW_NUMBER_LINE_INFO));
        utils.waitForElementVisible(By.xpath("//h1[text()='" + number + "']"));
        utils.clickBtn(By.xpath(CONTINUETAB_UNDER_LINE_INFO));
        utils.jumpToParentPopUp();}

    public void assertionForLineNumberingSpecifyNewNumber(String number) throws InterruptedException, SQLException {
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.LINE_NUMBERING_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + number + "')]]"));

    }

    public void lineNumberingSelectFromList(String number) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.waitForElementVisible(By.xpath(SELECT_FROM_LISTTAB_UNDER_LINE_INFO));
        try {
            utils.clickBtn(By.xpath(SELECT_FROM_LISTTAB_UNDER_LINE_INFO));
        } catch (Exception e) {
            utils.clickBtn(By.xpath(SELECT_FROM_LISTTAB_UNDER_LINE_INFO));
        }
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "delete from dbo.reserved_numbers where number='" + number + "'");
        utils.clickBtn(By.xpath(GET_NUMBERSTAB_UNDER_SELECT_FROM_LIST_LINE_INFO));
        utils.waitForElementVisible(By.xpath("//label[text()='" + number + "']"));
        utils.clickBtn(By.xpath("//label[text()='" + number + "']"));
        utils.waitForElementVisible(By.xpath(RESERVETAB_UNDER_SELECT_FROM_LIST_LINE_INFO));
        utils.clickBtn(By.xpath(RESERVETAB_UNDER_SELECT_FROM_LIST_LINE_INFO));
        utils.waitForElementVisible(By.xpath(CONTINUETAB_UNDER_LINE_INFO));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(CONTINUETAB_UNDER_LINE_INFO));
        utils.jumpToParentPopUp();}
        public void assertionForSelectFromList(String number) throws InterruptedException, SQLException {
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisibleForWLR3Page(By.id(wlr3_orderDetails_page.LINE_NUMBERING_SUMMARY_PANEL));
            utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + number + "')]]"));
    }

    public void lineNumberingAutomaticallyAssignNumber(String number) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.waitForElementVisible(By.xpath(AUTOMATICALLY_ASSIGN_NOWTAB_UNDER_LINE_INFO));
        try {
            utils.clickBtn(By.xpath(AUTOMATICALLY_ASSIGN_NOWTAB_UNDER_LINE_INFO));
        } catch (Exception e) {
            utils.clickBtn(By.xpath(AUTOMATICALLY_ASSIGN_NOWTAB_UNDER_LINE_INFO));
        }
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "delete from dbo.reserved_numbers where number='" + number + "'");
        utils.clickBtn(By.xpath(ALLOCATENOW_TAB_UNDER_AUTOMATICALLY_ASSIGN_NOW_LINE_INFO));
        utils.waitForElementVisible(By.xpath("//h1[text()='" + number + "']"));
        utils.javaScriptExecutorClick(By.xpath(CONTINUETAB_UNDER_LINE_INFO));
        utils.jumpToParentPopUp();}


        public void assertionForAutomaticallyAssign(String number) throws InterruptedException, SQLException {
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.LINE_NUMBERING_SUMMARY_PANEL));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + number + "')]]"));
    }
    public void assertionForNumberAllocationOnWizard(String number){
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'A new number has been reserved for this line')]"));
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'"+number+"')]"));


    }

    public void clickImportFromOtherNetwork() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(IMPORT_FROM_ANOTHER_NETWORK_TAB));
        utils.clickBtn(By.xpath(IMPORT_FROM_ANOTHER_NETWORK_TAB));

    }

    public void enterNumberOnImportFromOtherNetworkPage(String number) throws InterruptedException {
        utils.waitForElementVisible(By.id(ENTER_NUMBER_TEXT_BOX_UNDER_IMPORT_FROM_ANOTHER_NETWORK));
        utils.clickBtn(By.id(ENTER_NUMBER_TEXT_BOX_UNDER_IMPORT_FROM_ANOTHER_NETWORK));
        utils.sendText(By.id(ENTER_NUMBER_TEXT_BOX_UNDER_IMPORT_FROM_ANOTHER_NETWORK), number);
    }

    public void importNumberWithChangeOfAddress(String number, String postCode) throws InterruptedException {
        clickImportFromOtherNetwork();
        enterNumberOnImportFromOtherNetworkPage(number);
        utils.clickBtn(By.id(MOVE_NUMBER_FROM_ANOTHER_ADDRESS_CHECK_BOX));
        utils.clickBtn(By.id(MOVE_NUMBER_FROM_ANOTHER_ADDRESS_POSTCODE));
        utils.sendText(By.id(MOVE_NUMBER_FROM_ANOTHER_ADDRESS_POSTCODE), postCode);
        utils.clickBtn(By.id(RESERVETAB_UNDER_IMPORT_FROM_ANOTHER_NETWORK));
        utils.waitForElementVisible(By.xpath("//h1[text()='" + number + "']"));
        utils.clickBtn(By.xpath(CONTINUE_AFTER_IMPORTING_FROM_ANOTHER_NETWORK));
        utils.jumpToParentPopUp();
    }

    public void clickContinueUnderNoChange() {
        utils.clickBtn(By.xpath(NO_CHANGES_TO_LINE_CONTINUE_BUTTON));
    }

    public void importFromOtherNetworkWithLetterOfAuthority(String number) throws InterruptedException, SQLException {
        depopulateImportFromOtherNetworkFields();
        enterNumberOnImportFromOtherNetworkPage(number);
        utils.clickBtn(By.id(LETTER_OF_AUTHORITY_CHECKBOX));
        utils.clickBtn(By.id(CONTINUE_AFTER_LETTER_OF_AUTHORITY_CHECKED_IN));
        utils.jumpToParentPopUp();
    }

    public void importNumberWithVic(String number, String vic) throws InterruptedException, SQLException {
        depopulateImportFromOtherNetworkFields();
        enterNumberOnImportFromOtherNetworkPage(number);
        utils.clickBtn(By.id(VIC_TEXTBOX_UNDER_LINE_INFO));
        utils.sendText(By.id(VIC_TEXTBOX_UNDER_LINE_INFO), vic);
        utils.clickBtn(By.id(RESERVETAB_UNDER_IMPORT_FROM_ANOTHER_NETWORK));
        utils.clickBtn(By.id(CONTINUETAB_UNDER_IMPORT_FROM_OTHER_NETWORK_LINE_INFO));
        utils.jumpToParentPopUp();
    }

    public void clickNoChangeTab() {
        utils.waitForElementVisible(By.xpath(NO_CHANGE_TAB));
        utils.clickBtn(By.xpath(NO_CHANGE_TAB));
    }

    public void depopulateImportFromOtherNetworkFields() throws InterruptedException, SQLException {
        clickNoChangeTab();
        clickContinueUnderNoChange();
        utils.jumpToParentPopUp();
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.LINE_NUMBERING_SUMMARY_PANEL));
        wlr3_orderDetails_page.clickLineNumbering();
        clickImportFromOtherNetwork();
    }

    public void closeLineNumberingPage() throws InterruptedException {
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(commonMethods.CLOSE_POPUP));
    }

    public void assertionForLineNumberingWithAddress() {

        utils.clickBtn(By.xpath(SPECIFY_NEW_NUMBERTAB_UNDER_LINE_NUM));
        utils.assertElementNotPresent(By.xpath(ALERT_ON_LINE_INFO));
        utils.clickBtn(By.xpath(SELECT_FROM_LISTTAB_UNDER_LINE_INFO));
        utils.assertElementNotPresent(By.xpath(ALERT_ON_LINE_INFO));
        utils.clickBtn(By.xpath(AUTOMATICALLY_ASSIGN_NOWTAB_UNDER_LINE_INFO));
        utils.assertElementNotPresent(By.xpath(ALERT_ON_LINE_INFO));
    }

    public void assertionForLineNumberingWithOutAddress() {
        utils.clickBtn(By.xpath(SPECIFY_NEW_NUMBERTAB_UNDER_LINE_NUM));
        utils.waitForElementVisible(By.xpath(ALERT_ON_LINE_INFO));
        utils.clickBtn(By.xpath(SELECT_FROM_LISTTAB_UNDER_LINE_INFO));
        utils.waitForElementVisible(By.xpath(ALERT_ON_LINE_INFO));
        utils.clickBtn(By.xpath(AUTOMATICALLY_ASSIGN_NOWTAB_UNDER_LINE_INFO));
        utils.waitForElementVisible(By.xpath(ALERT_ON_LINE_INFO));
        System.out.println("NA64a completed");
    }

    public void addingNewSNDDIBeyondTheRangeForISDN30Modify() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(ADD_NEW_DDI));
        utils.clickBtn(By.xpath(ADD_NEW_DDI));
        utils.waitForElementVisible(By.xpath(VALIDATION_TO_PREVENT_ADDITION_OF_NEW_SNDDI));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(OK_BUTTON_ON_NEW_OR_REACTIVATE_OLD_SNDDI_VALIDATION_POPUP));
    }

    public void deleteActionAndAddingNewSNDDIForISDN30Modify() throws InterruptedException, SQLException {
        utils.waitForElementVisible(By.id(SNDDI_DDI_DROPDOWN_ROW1));
        utils.selectByVisibleText(By.id(SNDDI_DDI_DROPDOWN_ROW1), "Remove");
        utils.clickBtn(By.xpath(ADD_NEW_DDI));
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath(DELETE_TEXT_UNDER_LINE_NUMBERING_WLR3_ORDER_DETAILS_PAGE));
        wlr3_orderDetails_page.clickLineNumbering();
        utils.waitForElementVisible(By.xpath(ASSERTING_NEWLY_ADDED_SNDDI_UNDER_NUMBERING_SUMMARY));
        utils.waitForElementVisible(By.xpath(ASSERTING_NEWLY_ADDED_SNDDI_UNDER_ACTION));
    }

    public void revertingDeleteActionOnLineNumberingPopUpForISDN30Modify() throws InterruptedException {
        utils.waitForElementVisible(By.id(SNDDI_DDI_DROPDOWN_ROW1));
        utils.selectByVisibleText(By.id(SNDDI_DDI_DROPDOWN_ROW1), "Renumber");
     //   utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath(VALIDATION_TO_PREVENT_ACTIVATION_OF_EXISTING_SNDDI));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(OK_BUTTON_ON_NEW_OR_REACTIVATE_OLD_SNDDI_VALIDATION_POPUP));
    }

    public void mBNValidationOnLineNumberingPopUpForISDN30Modify(String number1, String number2, String number3, String allocationType) throws InterruptedException, SQLException {
        utils.selectByVisibleText(By.id(SNDDI_DDI_DROPDOWN_ROW2), "Remove");
        utils.selectByVisibleText(By.id(SNDDI_DDI_DROPDOWN_ROW2), "Remove");
        utils.selectByVisibleText(By.id(SNDDI_DDI_DROPDOWN_ROW2), "Remove");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath("//b[text()='SNDDI - " + number1 + "']"));
        utils.waitForElementVisible(By.xpath("//b[text()='SNDDI - " + number2 + "']"));
        utils.waitForElementVisible(By.xpath("//b[text()='SNDDI - " + allocationType + "']"));
        wlr3_orderDetails_page.clickLineNumbering();
        utils.waitForElementVisible(By.xpath(THIRD_ROW_MBN_RADIO_BUTTON));
        Thread.sleep(1000);
        utils.makeSureBoxIsChecked(By.xpath(SECOND_ROW_MBN_RADIO_BUTTON), By.xpath(SECOND_ROW_MBN_RADIO_BUTTON));
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath(wlr3_orderDetails_page.TEXT_ON_WLR3_ORDER_DETAIL_PAGE));
        Thread.sleep(1000);
        utils.assertElementNotPresent(By.xpath("//b[text()='SNDDI - " + number3 + "']"));
    }

    public void validatePreviousNumberManagementOptionsInModifyOrder(String selectTypeOfForward, String forwardToCLI) {
        utils.waitForElementVisible(By.xpath(AUTOMATICALLY_ASSIGNTAB_UNDER_LINE_INFO));
        utils.clickBtn(By.xpath(AUTOMATICALLY_ASSIGNTAB_UNDER_LINE_INFO));
        utils.waitForElementVisible(By.xpath("//label[text()[contains(.,'" + selectTypeOfForward + "')]]"));
        utils.clickBtn(By.xpath("//label[text()[contains(.,'" + selectTypeOfForward + "')]]"));
        utils.waitForElementVisible(By.id(CLI_FIELD_FOR_CALL_REDIRECT_OR_FORWARD));
        utils.sendText(By.id(CLI_FIELD_FOR_CALL_REDIRECT_OR_FORWARD), "" + forwardToCLI + "");
        utils.waitForElementVisible(By.xpath(CONTINUETAB_UNDER_AUTOMATICALLY_ASSIGN_LINE_INFO));
        utils.clickBtn(By.xpath(CONTINUETAB_UNDER_AUTOMATICALLY_ASSIGN_LINE_INFO));
    }

    public void takeNumberFromAnotherWorkingLine_emptyFieldValidations() {
        utils.waitForElementVisible(By.xpath(TAKE_NUMBER_FROM_ANOTHER_WORKING_LINE_TAB));
        utils.clickBtn(By.xpath(TAKE_NUMBER_FROM_ANOTHER_WORKING_LINE_TAB));
        utils.waitForElementVisible(By.id(CLI_FIELD_FOR_CALL_REDIRECT_OR_FORWARD));
        utils.sendText(By.id(CLI_FIELD_FOR_CALL_REDIRECT_OR_FORWARD), "");
        utils.clickBtn(By.xpath(TAKE_NUMBER_BUTTON));
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_FOR_EMPTY_TAKE_OVER_NUMBER_FIELD));
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_FOR_EMPTY_POSTCODE));
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_TO_PROVIDE_CORRECT_DETAILS));

    }

    public void takeNumberFromAnotherWorkingLine_populateFields(String takeOverNumber,String forwardToCLI) throws InterruptedException {
        utils.waitForElementVisible(By.id(TAKE_OVER_NUMBER_FIELD));
        utils.sendText(By.id(TAKE_OVER_NUMBER_FIELD), ""+takeOverNumber+"");
        utils.sendText(By.id(TAKE_OVER_NUMBER_POSTCODE), "LU1 1DQ");
        utils.sendText(By.id(CLI_FIELD_FOR_CALL_REDIRECT_OR_FORWARD), ""+forwardToCLI+"");
        utils.clickBtn(By.xpath(TAKE_NUMBER_BUTTON));
       utils.waitForElementVisible(By.xpath(NUMBER_SUCCESSFULLY_TAKEN_AND_SAVED_MESSAGE));
        utils.waitForElementVisible(By.xpath("//h1[contains(text(),'"+takeOverNumber+"')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(CONTINUETAB_UNDER_LINE_INFO));
        utils.waitForElementVisible(By.xpath("//div[text()[contains(.,'"+takeOverNumber+"')]]"));
    }

    public void validationForEmptyCallForwardCLIField_Under_SpecifyNewNumber(String selectTypeOfForward, String reserveNumber) throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.waitForElementVisible(By.xpath(SPECIFY_NEW_NUMBERTAB_UNDER_LINE_NUM));
        utils.clickBtn(By.xpath(SPECIFY_NEW_NUMBERTAB_UNDER_LINE_NUM));
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "delete from dbo.reserved_numbers where number='"+reserveNumber+"'");
        utils.sendText(By.id(FIELD_TO_SPECIFY_NUMBER_FOR_RESERVATION), ""+reserveNumber+"");
        utils.waitForElementVisible(By.xpath("//label[text()[contains(.,'"+selectTypeOfForward+"')]]"));
        utils.clickBtn(By.xpath("//label[text()[contains(.,'"+selectTypeOfForward+"')]]"));
        utils.clickBtn(By.xpath(RESERVETAB_UNDER_SPECIFY_NEW_NUMBER_LINE_INFO));
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_TO_PROVIDE_CORRECT_DETAILS));
        utils.waitForElementVisible(By.xpath(EMPTY_FIELD_ERROR_MESSAGE));
    }
    public void checkValidationsOnEmptyCLIField_UnderAutomaticallyAssign(String selectTypeOfForward){
        utils.waitForElementVisible(By.xpath(AUTOMATICALLY_ASSIGNTAB_UNDER_LINE_INFO));
        utils.clickBtn(By.xpath(AUTOMATICALLY_ASSIGNTAB_UNDER_LINE_INFO));
        utils.waitForElementVisible(By.xpath("//label[text()[contains(.,'"+selectTypeOfForward+"')]]"));
        utils.clickBtn(By.xpath("//label[text()[contains(.,'"+selectTypeOfForward+"')]]"));
        utils.waitForElementVisible(By.xpath(CONTINUETAB_UNDER_AUTOMATICALLY_ASSIGN_LINE_INFO));
        utils.clickBtn(By.xpath(CONTINUETAB_UNDER_AUTOMATICALLY_ASSIGN_LINE_INFO));
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_TO_PROVIDE_CORRECT_DETAILS));
        utils.waitForElementVisible(By.xpath(EMPTY_FIELD_ERROR_MESSAGE));
    }
    public void addingExtraSNDDI() throws InterruptedException, SQLException {
        wlr3_orderDetails_page.clickLineNumbering();
        utils.waitForElementVisible(By.xpath(ADD_NEW_DDI));
        utils.clickBtn(By.xpath(ADD_NEW_DDI));
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }
    public void addingExtraDDIRange() throws InterruptedException, SQLException {
        wlr3_orderDetails_page.clickLineNumbering();
        utils.waitForElementVisible(By.id(SNDDI_DDI_DROPDOWN_ROW1));
        utils.selectByVisibleText(By.id(SNDDI_DDI_DROPDOWN_ROW1),"New DDI range");
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

}

