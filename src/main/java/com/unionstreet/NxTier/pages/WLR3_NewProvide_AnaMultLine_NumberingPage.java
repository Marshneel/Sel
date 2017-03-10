package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_AnaMultLine_NumberingPage {

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
    private final String EDITICON_ON_SNDDI_POPUP = "//a[contains(@onclick,'ISDNLine.showISDNNumberingOption')]";
    private final String AUTOMATICALLY_ASSIGN_TEXT_UNDER_NUMBERING_OPTIONS_POPUP = "//legend[text()='Automatically assign']";
    private final String CONTINUE_BUTTON_UNDER_NUMBERING_OPTIONS_POPUP = "//a[contains(@onclick,'ISDNLine.saveAndCloseDDIOption')]";
    private final String ADDNEW_DDIRANGE_BUTTON = "add_row";
    private final String SNDDI_DDI_DROPDOWN = "DDIInfo_1__action";
    private final String MORE_DIRECTORY_INFO_TAB = "//a[contains(@onclick,'newProvideWizard.ValidateAndSubmitNumberingFormAndExecuteNext')]";
    private final String SNDDI_TAB_ON_DIRINFO_POPUP = "//ul[@id='directoryInformationNavigation']//a[contains(text(),'SNDDI')]";

    ElementUtils utils = new ElementUtils();
    WLR3_New_Provide_Analogue_Multiline_OrderPage wlr3_new_provide_analogue_multiline_orderPage = new WLR3_New_Provide_Analogue_Multiline_OrderPage();
    WLR3_LineNumberingPage wlr3_lineNumberingPage = new WLR3_LineNumberingPage();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    WLR3_DirectoryInformationPage wlr3_directoryInformationPage = new WLR3_DirectoryInformationPage();


    public void PopulateDirectoryInfoUnderNUMBERING(String info) throws InterruptedException {
        utils.waitForElementVisible(By.id(BUSINESS_DESC_TEXTBOX_UNDER_DIRECTORY_INFO));
        //check residential tab under directory location
        utils.clickBtn(By.id(RESIDENTIAL_RADIOBTN_UNDER_DIRECTORYINFO));
        //assert that the error is thrown when the contact and initials are not populated
        utils.clickBtn(By.xpath(wlr3_new_provide_analogue_multiline_orderPage.NEXT_BUTTON));
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

    public void populateAndAssertNumberingPageForISDN30(String label1UnderLineNum, String label2UnderLineNum, String labelOnPopUP) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'" + label1UnderLineNum + "')]"));
        utils.waitForElementVisible(By.xpath("//label[text()='" + label2UnderLineNum + "']"));
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.xpath("//label[text()='" + labelOnPopUP + "']"));
        utils.clickBtn(By.xpath(EDITICON_ON_SNDDI_POPUP));
        utils.waitForElementVisible(By.xpath(AUTOMATICALLY_ASSIGN_TEXT_UNDER_NUMBERING_OPTIONS_POPUP));
        utils.clickBtn(By.xpath(CONTINUE_BUTTON_UNDER_NUMBERING_OPTIONS_POPUP));
        utils.waitForElementVisible(By.id("DDIInfo_0__action"));
        utils.selectByVisibleText(By.id("DDIInfo_0__action"), "New DDI range");
        utils.sendText(By.id("DDIInfo_0__range"), "10000");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please enter a value less than or equal to 9999.')]"));
        utils.sendText(By.id("DDIInfo_0__range"), "9");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Invalid DDI Range. Range value must be in blocks of 10.')]"));
        utils.sendText(By.id("DDIInfo_0__range"), "0");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Invalid DDI Range. Range value must be in blocks of 10.')]"));
        utils.sendText(By.id("DDIInfo_0__range"), "100");
        utils.waitForElementVisible(By.id(ADDNEW_DDIRANGE_BUTTON));
        Thread.sleep(1000);
        utils.clickBtn(By.id(ADDNEW_DDIRANGE_BUTTON));
        utils.waitForElementVisible(By.id(SNDDI_DDI_DROPDOWN));
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
    }

    public void newDDIRangeHasNoTabUnderDirInfoUnlessMBNclicked() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.id(ADDNEW_DDIRANGE_BUTTON));
        Thread.sleep(1000);
        utils.clickBtn(By.id(ADDNEW_DDIRANGE_BUTTON));
        utils.selectByVisibleText(By.id("DDIInfo_1__action"), "New DDI range");
        Thread.sleep(1000);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));
        clickMoreDirInfoTab();
        Thread.sleep(1000);
        utils.assertElementNotPresent(By.xpath(SNDDI_TAB_ON_DIRINFO_POPUP));
        utils.clickBtn(By.xpath(wlr3_directoryInformationPage.CLOSE_POPUP));
        utils.waitForElementVisible(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.xpath("//input[contains(@onclick,'ISDNLine.setMBN(1);')]"));
        utils.clickBtn(By.xpath("//input[contains(@onclick,'ISDNLine.setMBN(1);')]"));
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
        utils.clickBtn(By.xpath(wlr3_directoryInformationPage.CLOSE_POPUP));
    }

    public void deleteAndAssertAddedDDIRange() throws InterruptedException {
        utils.clickBtn(By.xpath(wlr3_directoryInformationPage.CLOSE_POPUP));
        utils.waitForElementVisible(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.id(ADDNEW_DDIRANGE_BUTTON));
        Thread.sleep(1000);
        utils.clickBtn(By.id(ADDNEW_DDIRANGE_BUTTON));
        utils.waitForElementVisible(By.xpath("//a[contains(@onclick,'ISDNLine.removeRow(1);')]"));
        utils.assertElementNotPresent(By.xpath("//a[contains(@onclick,'ISDNLine.removeRow(0);')]"));
        utils.clickBtn(By.xpath("//a[contains(@onclick,'ISDNLine.removeRow(1);')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.id(ADDNEW_DDIRANGE_BUTTON));
        utils.waitForElementVisible(By.xpath("//a[contains(@onclick,'ISDNLine.removeRow(3);')]"));

    }

    public void checkLineNumberingForISDN(String action1, String action2) throws InterruptedException {
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(ADVANCED_LINE_NUMBERING_OPTIONS_UNDER_LINE_NUMBERING));
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Add or Remove SNDDI/DDI Ranges')]"));
        utils.selectByVisibleText(By.id("DDIInfo_0__action"), "" + action1 + "");
        utils.selectByVisibleText(By.id("DDIInfo_1__action"), "" + action2 + "");
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));

    }

}

