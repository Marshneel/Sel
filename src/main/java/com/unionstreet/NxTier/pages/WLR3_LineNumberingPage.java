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
    public final String CONTINUETAB_UNDER_LINE_INFO = "//a[@onclick='return lineNumbering.hidePopup();'][contains(text(),'Continue')]";
    private final String AUTOMATICALLY_ALLOCATED_TEXT_ON_WLR_ORDERDETAILS_PAGE = "//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'Automatically allocated')]]";
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

    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();


    public void lineNumberingAutomaticallyAssignWithAssertions() throws InterruptedException {
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
        utils.waitForElementVisible(By.id("lineNumberingSummaryPanel"));
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
        utils.sendText(By.id(TEXTBOX_UNDER_SPECIFY_NEW_NUMBER_LINEINFO),"" + number + "");
        utils.clickBtn(By.xpath(RESERVETAB_UNDER_SPECIFY_NEW_NUMBER_LINE_INFO));
        utils.waitForElementVisible(By.xpath("//h1[text()='" + number + "']"));
        utils.clickBtn(By.xpath(CONTINUETAB_UNDER_LINE_INFO));
        utils.jumpToParentPopUp();
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("lineNumberingSummaryPanel"));
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


        utils.jumpToParentPopUp();
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisibleForWLR3Page(By.id("lineNumberingSummaryPanel"));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + number + "')]]"));
    }


    public void lineNumberingAutomaticallyAssignNumber(String number) throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
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
        utils.jumpToParentPopUp();
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("lineNumberingSummaryPanel"));
        utils.waitForElementVisible(By.xpath("//p[@id='display_wlr3order_TelephoneNumber'][text()[contains(.,'" + number + "')]]"));


    }

    public void clickImportFromOtherNetwork() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(IMPORT_FROM_ANOTHER_NETWORK_TAB));
            utils.clickBtn(By.xpath(IMPORT_FROM_ANOTHER_NETWORK_TAB));

    }

    public void enterNumberOnImportFromOtherNetworkPage(String number) throws InterruptedException {
       utils.waitForElementVisible(By.id(ENTER_NUMBER_TEXT_BOX_UNDER_IMPORT_FROM_ANOTHER_NETWORK));
        utils.clickBtn(By.id(ENTER_NUMBER_TEXT_BOX_UNDER_IMPORT_FROM_ANOTHER_NETWORK));
        utils.sendText(By.id(ENTER_NUMBER_TEXT_BOX_UNDER_IMPORT_FROM_ANOTHER_NETWORK),number);
    }

    public void importNumberWithChangeOfAddress(String number, String postCode) throws InterruptedException {
        clickImportFromOtherNetwork();
        enterNumberOnImportFromOtherNetworkPage(number);
        utils.clickBtn(By.id(MOVE_NUMBER_FROM_ANOTHER_ADDRESS_CHECK_BOX));
        utils.clickBtn(By.id(MOVE_NUMBER_FROM_ANOTHER_ADDRESS_POSTCODE));
        utils.sendText(By.id(MOVE_NUMBER_FROM_ANOTHER_ADDRESS_POSTCODE),postCode);
        utils.clickBtn(By.id(RESERVETAB_UNDER_IMPORT_FROM_ANOTHER_NETWORK));
        utils.waitForElementVisible(By.xpath("//h1[text()='" + number + "']"));
        utils.clickBtn(By.xpath(CONTINUE_AFTER_IMPORTING_FROM_ANOTHER_NETWORK));
        utils.jumpToParentPopUp();
    }

    public void clickContinueUnderNoChange() {
        utils.clickBtn(By.xpath(NO_CHANGES_TO_LINE_CONTINUE_BUTTON));
    }

    public void importFromOtherNetworkWithLetterOfAuthority(String number) throws InterruptedException {
        depopulateImportFromOtherNetworkFields();
        enterNumberOnImportFromOtherNetworkPage(number);
        utils.clickBtn(By.id(LETTER_OF_AUTHORITY_CHECKBOX));
        utils.clickBtn(By.id(CONTINUE_AFTER_LETTER_OF_AUTHORITY_CHECKED_IN));
        utils.jumpToParentPopUp();
    }

    public void importNumberWithVic(String number, String vic) throws InterruptedException {
        depopulateImportFromOtherNetworkFields();
        enterNumberOnImportFromOtherNetworkPage(number);
        utils.clickBtn(By.id(VIC_TEXTBOX_UNDER_LINE_INFO));
        utils.sendText(By.id(VIC_TEXTBOX_UNDER_LINE_INFO),vic);
        utils.clickBtn(By.id(RESERVETAB_UNDER_IMPORT_FROM_ANOTHER_NETWORK));
        utils.clickBtn(By.id(CONTINUETAB_UNDER_IMPORT_FROM_OTHER_NETWORK_LINE_INFO));
        utils.jumpToParentPopUp();
    }

    public void clickNoChangeTab() {
        utils.waitForElementVisible(By.xpath(NO_CHANGE_TAB));
        utils.clickBtn(By.xpath(NO_CHANGE_TAB));
    }

    public void depopulateImportFromOtherNetworkFields() throws InterruptedException {
        clickNoChangeTab();
        clickContinueUnderNoChange();
        utils.jumpToParentPopUp();
        wlr3_orderDetails_page.textOnWLR3OrderPage();
        utils.waitForElementVisible(By.id("lineNumberingSummaryPanel"));
        wlr3_orderDetails_page.clickLineNumbering();
        clickImportFromOtherNetwork();
    }

    public void closeLineNumberingPage() throws InterruptedException {
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//div[@id='popupDiv']//button[@id='closeBtn']"));
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
}
