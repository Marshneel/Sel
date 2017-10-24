package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.BaseClass;
import com.unionstreet.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.unionstreet.support.ElementUtils.split;

/**
 * Created by rajeshg on 08/08/2017.
 */
public class ServiceDesk_TicketDetailsPage {
    private final String SELECT_CLI_FIELD_IS_REQUIRED = "//span[contains(text(),'The Select CLI field is required.')]";
    private final String THE_CONFIRM_POST_CODE_IS_REQUIRED = "//span[contains(text(),'The Confirm Postcode field is required.')]";
    private final String TEXT_ON_LINE_AND_INSTALLATION_DETAILS_PAGE = "//legend[contains(text(),'Line and installation details')]";
    private final String OBTAIN_ORDER_DETAILS = "obtainOrderDetails";
    private final String SELECT_CLI_DROPDOWN = "//input[@id='CLI']/following-sibling::a";
    private final String OPEN_REACH_SPINNER = "//span[@class='spinner']";
    private final String SEARCH_BOX_FOR_CLI = "//input[@type='search']";
    private final String SELECT_CLI_BUTTON = "//button[contains(text(),'Select')]";
    private final String CPS_PRESENT_RESULT = "//div[@id='installationDetailsContainer']/div/h4/following-sibling::div/div[4]/div/label/strong/label";
    private final String CALLING_AND_NETWORK_FEATURES = "//div[@id='installationDetailsContainer']/div/h4/following-sibling::div/div[5]/div/label/strong/label";
    private final String INTERMITTENT_FAULT_TEXT = "//label[text()[contains(.,'Intermittent Fault')]]";
    private final String STD_LINE_TEST_BUTTON = "//a[text()[contains(.,'Perform a line test')]]";
    private final String OVERNIGHT_LINE_TEST_BUTTON = "//a[text()[contains(.,'Overnight line test')]]";
    private final String FAULT_SQC_DROPDOWN = "StructuredQueryCodeId";
    private final String INCIDENT_SAVE_BUTTON = "wizardButton_SaveIncident";
    private final String TIME_RELATED_CHARGES_LABEL = "//legend[contains(text(),'Time Related Charges')]";
    private final String TEMPERORY_CALL_ROUTING_LABEL = "//legend[contains(text(),'Temporary Call Routing')]";
    private final String NETWORK_FEATURES_DROPDOWN = "AvailableNetworkFeatureId";
    private final String PIN_LABEL = "//label[text()[contains(.,'Pin')]]";
    private final String PIN_TEXT_FIELD = "Pin";
    private final String PIN_VALIDATION_MESSAGE = "//span[text()[contains(.,'Please enter a numeric pin of four digits')]]";
    private final String SAMPLE_CALLS_LABEL = "//h5[text()[contains(.,'Sample Calls')]]";
    private final String SAMPLE_CALLS_DATE_FIELD = "SampleCalls_0__SampleCallDate";
    private final String SAMPLE_CALLS_TIME_FIELD = "SampleCalls_0__SampleCallTime";
    private final String SAMPLE_CALLS_CLI_FIELD = "SampleCalls_0__SampleCallCLI";
    private final String SAMPLE_CALLS_DIALLED_FROM_TO_FIELD = "SampleCalls_0__SampleCallDialledFromTo";
    private final String DELETE_BUTTON_FOR_SAMPLECALLS_2ND_ROW = "//div[@id='sampleCallsContainer']/div[3]/div[4]//i";
    private final String DELETE_BUTTON_FOR_SAMPLECALLS_1ST_ROW = "//div[@id='sampleCallsContainer']/div[2]/div[4]//i";
    private final String TCR_DEFAULTED_TO_NONE = "//select[@id='TCRId']//option[contains(text(),'None')]";
    private final String TCR_DROPDOWN = "TCRId";
    private final String TRC_DEFAULTED_TO_BAND_0 = "//select[@id='TRCId']//option[@selected='selected'][contains(text(),'Band 0 - No authorisation')]";
    private final String LINE_TEST_LABEL = "//h1[text()[contains(.,'Line Test')]]";
    private final String FAULT_DETAILS_LABEL = "//legend[text()[contains(.,'Fault details')]]";
    private final String NEED_NOT_REPORT_LINE_FAULT = "//h3[contains(text(),'You are NOT advised to report this fault')]";
    private final String LINE_TEST_PASSED = "//strong[contains(text(),'Pass')]";
    private final String LINE_TEST_FAILED = "//strong[contains(text(),'Fail')]";
    private final String REDO_LINE_TEXT_BUTTON = "//a[contains(text(),'Reset / Run test again')]";
    private final String PASSED_LINE_TEST_DESC = "//strong[contains(text(),'Line Test OK')]";
    private final String REPORT_LINE_FAULT = "//h3[contains(text(),'You are advised to report this fault')]";
    private final String FAILED_LINE_TEST_DESC = "//strong[contains(text(),'FAULT - Line Tested OK but No Dial Tone Detected')]";
    private final String TEMPORARILY_SUSPEND_CPS_DEFAULTED_TO_NO = "//a[@href='#nav-pills-tab-5'][@aria-expanded='False'][contains(text(),'No')]";
    private final String TEMPORARILY_SUSPEND_CPS_SET_TO_YES = "//li[@class='active']//a[@href='#nav-pills-tab-6'][@aria-expanded='true'][contains(text(),'Yes')]";
    private final String YES_BUTTON_ON_TEMPORARILY_SUSPEND_CPS = "//a[@href='#nav-pills-tab-6']";
    private final String TRC_CLI_FIELD = "TCRDivertTo";
    private final String VALIDATION_MESSAGE_FOR_TCR_CALL_DIVERT_CLI = "//span[contains(text(),'Please enter a divert number')]";
    private final String TCR_CALL_DIVERT_CLI_CAN_ONLY_HAVE_SPACES_AND_NUMBERS = "//span[contains(text(),'To may only contain numbers or spaces')]";
    private final String DATE_IS_REQUIRED_FOR_SAMPLE_CALLS = "//li[text()[contains(.,'A Date is required for Sample Calls')]]";
    private final String CHOOSE_LINE_FOR_MULTILINE_LABEL = "//label[text()='Line']";
    private final String CHOOSE_LINE_FOR_MULTILINE_DROPDOWN = "Line";
    private final String CHOOSE_LINE_FOR_MULTILINE_VALIDATION_MESSAGE = "//span[text()='The field Line must be a number.']";
    private final String FEATURE_MUST_BE_SELECTED_VALIDATION_MESSAGE = "//span[text()[contains(.,'A Feature must be selected')]]";
    private final String DOWNTIME_TEXT_BOX = "wlr3_down_time";
    private final String VALIDATION_MESSAGE_FOR_EMPTY_SAMPLE_CALL_FIELD = "//li[text()[contains(.,'A Dialled From/To is required for Sample Calls')]]";
    private final String VALIDATION_MESSAGE_FOR_EMPTY_DOWNTIME = "//span[text()[contains(.,'Please enter a Down Time')]]";
    private final String VALIDATION_MESSAGE_FOR_UNACCEPTABLY_LENGTHY_DOWNTIME = "//span[text()[contains(.,'Downtime must be no more than 255 characters')]]";
    private final String ESTIMATED_DATE_AND_TIME_OF_REPAIR = "CareLvlEstFixDate";
    private final String CARE_LEVEL_PLAN_DROPDOWN = "SelectedCareLevel";
    private final String SERVICE_MAINTENANCE_LEVEL_TEXT_LABEL = "//legend[contains(text(),'Service Maintenance Levels')]";
    private final String TEXT_LABEL_EXPEDIATE_FAULT_BY_INCREASING_CARELEVEL = "//label[contains(text(),'Would you like to expedite this fault (may incur additional charge)?')]";
    private final String VALIDATION_MESSAGE_FOR_ISDN30_WITH_CARE_LEVEL_2 = "//i[contains(text(),'Openreach will not permit expedition of repairs on products currently at Service Maintenance Level 2.')]";
    private final String YES_BUTTON_TO_EXPEDITE_FAULT = "//label[contains(text(),'Would you like to expedite this fault (may incur additional charge)?')]/following-sibling::ul//a[contains(text(),'Yes')]";
    private final String LOAD_BROWSE_INCIDENTS_BUTTON = "//a[contains(text(),'Browse Incidents')]";
    private final String SERVICE_DESK_DROPDOWN_TAB = "//span[contains(text(),' Service Desk')]";
    private final String TEXT_ON_BROWSE_INCIDENTS_PAGE = "//small[contains(text(),'Browse Incidents')]";
    private final String SEARCH_BOX_BROWSE_INCIDENTS = "//input[@type='search']";
    private final String IMPORT_MANAGER_DROP_DOWN = "//span[text()=' Import Manager']";
    private final String NO_INCIDENTS_TEXT_LABEL = "//h5[contains(text(),'No Incidents Found')]";
    private final String EXPAND_BUTTON_ON_INCIDENT = "//table[@id='incidentsTable']//tbody/tr/td[1]";
    private final String RECESSED_CATEGORY_COLUMN = "//span[text()='Category']";
    private final String RECESSED_OWNER_COLUMN = "//span[text()='Owner']";
    private final String RECESSED_LOGGED_COLUMN = "//span[text()='Logged']";
    private final String EXPAND_BUTTON_ON_BROWSE_INCIDENTS_PAGE = "//div[@id='AccountDetail']/div/div/a[2]";
    private final String EXPANDED_LOGGED_COLUMN = "//th[text()='Logged']";
    private final String EXPANDED_OWNER_COLUMN = "//th[text()='Owner']";
    private final String EXPANDED_CATEGORY_COLUMN = "//th[text()='Category']";
    private final String INCIDENT_COLUMN = "//th[text()='Incident']";
    private final String SORTED_BY_ASC_ORDER = "//th[@aria-sort='ascending']";
    private final String SHOWS_1_TO_10_ROWS = "//div[contains(text(),'Showing 1 to 10')]";
    private final String SHOWS_51_TO_100_ROWS = "//div[contains(text(),'Showing 51 to 100')]";
    private final String FIRST_ITEM_ON_THE_FIRST_PAGE_WITH_ENTRIES_PER_PAGE_10 = "//td[@class='details-control sorting_1']//a[text()='1']";
    private final String LAST_ITEM_ON_THE_FIRST_PAGE_WITH_ENTRIES_PER_PAGE_10 = "//td[@class='details-control sorting_1']//a[text()='10']";
    private final String LAST_ITEM_ON_THE_FIRST_PAGE_WITH_ENTRIES_PER_PAGE_50 = "//td[@class='details-control sorting_1']//a[text()='50']";
    private final String ENTRIES_PER_PAGE_DROP_DOWN = "//select[@name='incidentsTable_length']";
    private final String PAGE_FOOTER_SHOWING_1_TO_50_ROWS_PER_PAGE = "//div[contains(text(),'Showing 1 to 50')]";
    private final String PAGINATION_ACTIVE_PAGE_1 = "//li[@class='paginate_button active']//a[contains(text(),'1')]";
    private final String PAGINATION_ACTIVE_PAGE_2 = "//li[@class='paginate_button active']//a[contains(text(),'2')]";
    private final String NAVIGATE_TO_PAGE_2 = "//li[@class='paginate_button ']//a[contains(text(),'2')]";
    private final String MINIFIED_SERVICE_DESK_PANEL = "//div[@class='fade page-sidebar-fixed page-header-fixed page-container in page-sidebar-minified']";
    private final String MAGNIFY_SERVICE_DESK_PANEL = "//span[@class='sidebar-minify-btn']";
    private final String SELECTAPPOINTMENTBTN = "//a[contains(text(),'Select Appointment')]";
    private final String SELECT_APPOINTMENT_SLOT_TEXT="//h4[contains(text(),'Select Appointment Slot')]";
    private final String CANCELBTN="//a[@id='reserveAppointment']//preceding-sibling::a[text()='Cancel']";
    private final String RESERVEBTN="//a[@id='reserveAppointment']";
    private final String NO_APPOINTMENT_RESERVED="//h5[text()=' Appointment Reserved: ']//strong[@id='AppointmentDateFriendly'][contains(text(),'No appointment reserved')]";

    private Date today;
    String currentDate;
    String currentTime;
    String currentDayOfTheWeek;
    String ExpectedDay;
    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods = new CommonMethods();


    public void assertTextOnTicketDetailsPage() {
        utils.waitForElementVisible(By.xpath(TEXT_ON_LINE_AND_INSTALLATION_DETAILS_PAGE));
    }
    public void BookAnAppointment(String slotTime) throws java.lang.Exception {
        ExpectedDay = new SimpleDateFormat("dd/MM/yyyy").format(NonSaturday());
        utils.waitForElementVisibleForOpenReach(By.xpath(SELECTAPPOINTMENTBTN));
        utils.clickBtn(By.xpath(SELECTAPPOINTMENTBTN));
        utils.waitForElementVisible(By.xpath(SELECT_APPOINTMENT_SLOT_TEXT));
        Thread.sleep(1000);
        utils.waitForElementVisibleForOpenReach(By.xpath("//a[@data-slotdate='"+ExpectedDay+"'][@data-slottime='Wlr3AppointmentTimeslotEM'][contains(text(),'"+slotTime+"')]"));
        utils.clickBtn(By.xpath("//a[@data-slotdate='"+ExpectedDay+"'][@data-slottime='Wlr3AppointmentTimeslotEM'][contains(text(),'"+slotTime+"')]"));
        utils.clickBtn(By.xpath(RESERVEBTN));
        utils.switchToPreviousWindow(0);


    } public void AssertAppointmentIsReserved(String slotTime) throws Exception {
        Thread.sleep(1000);
        String currentMonth = new SimpleDateFormat("MMMM").format(NonSaturday());
        String currentday=new SimpleDateFormat("EEEE").format(NonSaturday());
        String DatePart=ExpectedDay.substring(0,2);
        String YearPart=ExpectedDay.substring(6,10);
        utils.waitForElementVisibleForOpenReach(By.xpath("//h5[text()=' Appointment Reserved: ']//strong[@id='AppointmentDateFriendly'][contains(text(),'"+currentday+", "+currentMonth+" "+DatePart+", "+YearPart+" "+slotTime+"')]"));
        utils.sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update Defaultvalues set ValueString='10.1.9.112' where ID='760'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueString='10.1.9.112' where ID='760'");
        utils.accessCMDAndPowerShell("src\\test\\Resources\\WLR3Tools\\powershell.exe","Get-Service -Name Abillity_Server_PortalTest -ComputerName test01-ds01 | Restart-Service");

    }

    public void CancelAnAppointment(String slotTime) throws java.lang.Exception {

        utils.sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update Defaultvalues set ValueString='89.234.55.115' where ID='760'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueString='89.234.55.115' where ID='760'");
        utils.accessCMDAndPowerShell("src\\test\\Resources\\WLR3Tools\\powershell.exe","Get-Service -Name Abillity_Server_PortalTest -ComputerName test01-ds01 | Restart-Service");
        utils.jumpToPopUpWindow(By.xpath(SELECTAPPOINTMENTBTN));
        Thread.sleep(5000);
        utils.waitForElementVisible(By.xpath(SELECT_APPOINTMENT_SLOT_TEXT));
        utils.clickBtn(By.xpath("//a[contains(text(),'"+slotTime+"')]"));
        utils.waitForElementVisible(By.xpath(CANCELBTN));
        utils.clickBtn(By.xpath(CANCELBTN));
        utils.switchToPreviousWindow(0);
        Thread.sleep(1000);
        utils.waitForElementVisible(By.xpath(NO_APPOINTMENT_RESERVED));
        utils.sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update Defaultvalues set ValueString='10.1.9.112' where ID='760'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueString='10.1.9.112' where ID='760'");
        utils.accessCMDAndPowerShell("src\\test\\Resources\\WLR3Tools\\powershell.exe","Get-Service -Name Abillity_Server_PortalTest -ComputerName test01-ds01 | Restart-Service");

    }

    public void clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode() {
        utils.clickBtn(By.id(OBTAIN_ORDER_DETAILS));
        utils.waitForElementVisible(By.xpath(SELECT_CLI_FIELD_IS_REQUIRED));
        utils.waitForElementVisible(By.xpath(THE_CONFIRM_POST_CODE_IS_REQUIRED));
    }

    public void selectCLIToObtainInstallationDetails(boolean appointmentSelection, String cli, String lineType, String numberOfLines, String maintenanceLevel, boolean notVirtualLine, String postCode) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.waitForElementToBeClickable(By.xpath(SELECT_CLI_DROPDOWN));
        utils.clickBtn(By.xpath(SELECT_CLI_DROPDOWN));
        utils.waitForElementToVanish(By.xpath(OPEN_REACH_SPINNER));
        utils.sendText(By.xpath(SEARCH_BOX_FOR_CLI), "" + cli + "");
        utils.waitForElementVisible(By.xpath("//td[text()[contains(.,'" + cli + "')]]/following-sibling::td[text()[contains(.,'"+postCode+"')]]/following-sibling::td[3]/button[contains(text(),'Select')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(SELECT_CLI_BUTTON));
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Installation Details for " + cli + "')]"));
        utils.waitForElementVisible(By.xpath("//strong[contains(text(),'" + lineType + "')]"));
      if(appointmentSelection){  if (notVirtualLine) {
            utils.waitForElementVisible(By.xpath("//strong[contains(text(),'" + numberOfLines + "')]"));
            utils.waitForElementVisible(By.xpath("//strong[contains(text(),'" + maintenanceLevel + "')]"));
            utils.waitForElementVisibleForOpenReach(By.xpath(CPS_PRESENT_RESULT));
            String valueForCPS = BaseClass.driver.findElement(By.xpath(CPS_PRESENT_RESULT)).getText();
            String valueForCalAndNetwrkFeatures = BaseClass.driver.findElement(By.xpath(CALLING_AND_NETWORK_FEATURES)).getText();
            utils.twoValueArrayList("Yes", "No");
            Assert.assertTrue(utils.allValues.contains(valueForCPS));
            Assert.assertTrue(utils.allValues.contains(valueForCalAndNetwrkFeatures));
        }
    }}

    public void faultDetails_assertionForAnalogueLines(boolean multiLine) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(INTERMITTENT_FAULT_TEXT));
        if (multiLine) {
            utils.waitForElementVisible(By.xpath(CHOOSE_LINE_FOR_MULTILINE_LABEL));
            utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
            Thread.sleep(1000);
            utils.scrollUp(By.id(INCIDENT_SAVE_BUTTON));
            Thread.sleep(1000);
            utils.clickBtn(By.id(INCIDENT_SAVE_BUTTON));
            utils.waitForElementVisible(By.xpath(CHOOSE_LINE_FOR_MULTILINE_VALIDATION_MESSAGE));
            utils.waitForElementVisible(By.id(CHOOSE_LINE_FOR_MULTILINE_DROPDOWN));
            utils.selectByVisibleText(By.id(CHOOSE_LINE_FOR_MULTILINE_DROPDOWN), "1");
        }
        utils.waitForElementVisible(By.xpath(STD_LINE_TEST_BUTTON));
        utils.waitForElementVisible(By.xpath(OVERNIGHT_LINE_TEST_BUTTON));
        utils.selectByVisibleText(By.id(FAULT_SQC_DROPDOWN), "Exchange Service Facility");
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.id(INCIDENT_SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(FEATURE_MUST_BE_SELECTED_VALIDATION_MESSAGE));
       // utils.performClickActionTillElementIsDetected(By.xpath(FEATURE_MUST_BE_SELECTED_VALIDATION_MESSAGE), By.id(INCIDENT_SAVE_BUTTON));
        utils.waitForElementVisible(By.id(NETWORK_FEATURES_DROPDOWN));
        utils.selectByVisibleText(By.id(NETWORK_FEATURES_DROPDOWN), "Smart Divert");
        utils.waitForElementToBeClickable(By.xpath(TEXT_ON_LINE_AND_INSTALLATION_DETAILS_PAGE));
        Thread.sleep(1000);
        utils.scrollUp(By.xpath(TEXT_ON_LINE_AND_INSTALLATION_DETAILS_PAGE));
        utils.waitForElementVisible(By.xpath(PIN_LABEL));
        utils.waitForElementVisible(By.id(PIN_TEXT_FIELD));
        utils.sendText(By.id(PIN_TEXT_FIELD), "123455");
        utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
        utils.clickBtn(By.id(INCIDENT_SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(PIN_VALIDATION_MESSAGE));
    }

    public void faultDetails_assertionForISDN30E() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(SAMPLE_CALLS_LABEL));
        utils.waitForElementVisible(By.id(FAULT_SQC_DROPDOWN));
        utils.selectByVisibleText(By.id(FAULT_SQC_DROPDOWN), "Noisy");
       // utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
        utils.clickBtn(By.id(INCIDENT_SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(DATE_IS_REQUIRED_FOR_SAMPLE_CALLS));
        utils.waitForElementVisible(By.xpath(VALIDATION_MESSAGE_FOR_EMPTY_SAMPLE_CALL_FIELD));
            utils.waitForElementVisible(By.xpath(VALIDATION_MESSAGE_FOR_EMPTY_DOWNTIME));
        utils.waitForElementVisible(By.id(DOWNTIME_TEXT_BOX));
        Thread.sleep(1000);
        utils.scrollUp(By.xpath("//label[contains(text(),'Fault Notes')]"));
        Thread.sleep(1000);
        utils.sendText(By.id(DOWNTIME_TEXT_BOX), "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
        utils.clickBtn(By.id(INCIDENT_SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(VALIDATION_MESSAGE_FOR_UNACCEPTABLY_LENGTHY_DOWNTIME));
        Thread.sleep(1000);
        utils.scrollUp(By.xpath("//label[contains(text(),'Fault Notes')]"));
        Thread.sleep(1000);
        utils.sendText(By.id(DOWNTIME_TEXT_BOX), "mmmmmmmmmmm");
    }


    public void validateSampleCalls() throws InterruptedException {
        today = new Date();
        currentDate = new SimpleDateFormat("dd/MM/YYYY").format(today);
        currentTime = new SimpleDateFormat("KK:mm").format(today);
        utils.waitForElementVisible(By.id(SAMPLE_CALLS_DATE_FIELD));
        Thread.sleep(1000);
        utils.waitForElementVisible(By.id(SAMPLE_CALLS_DATE_FIELD));
        utils.scrollUp(By.xpath("//legend[contains(.,'Fault details')]"));
        utils.sendText(By.id(SAMPLE_CALLS_DATE_FIELD), currentDate);
        utils.waitForElementVisible(By.id(SAMPLE_CALLS_TIME_FIELD));
        utils.sendText(By.id(SAMPLE_CALLS_TIME_FIELD), currentTime);
        utils.waitForElementVisible(By.id(SAMPLE_CALLS_CLI_FIELD));
        utils.sendText(By.id(SAMPLE_CALLS_CLI_FIELD), "02012345678");
        utils.waitForElementVisible(By.id(SAMPLE_CALLS_DIALLED_FROM_TO_FIELD));
        utils.sendText(By.id(SAMPLE_CALLS_DIALLED_FROM_TO_FIELD), "02012345678");
        utils.waitForElementVisible(By.xpath(DELETE_BUTTON_FOR_SAMPLECALLS_2ND_ROW));
        utils.clickBtn(By.xpath(DELETE_BUTTON_FOR_SAMPLECALLS_2ND_ROW));
        Thread.sleep(1000);
        utils.assertElementNotPresent(By.xpath(DELETE_BUTTON_FOR_SAMPLECALLS_2ND_ROW));
        utils.waitForElementVisible(By.xpath(DELETE_BUTTON_FOR_SAMPLECALLS_1ST_ROW));
        utils.clickBtn(By.xpath(DELETE_BUTTON_FOR_SAMPLECALLS_1ST_ROW));
        utils.waitForElementVisible(By.xpath(DELETE_BUTTON_FOR_SAMPLECALLS_1ST_ROW));
        utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
        utils.clickBtn(By.id(INCIDENT_SAVE_BUTTON));
    }

    public void faultDetails_assertionForISDN2() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(STD_LINE_TEST_BUTTON));
        utils.assertElementNotPresent(By.xpath(OVERNIGHT_LINE_TEST_BUTTON));
        //temporary call routing
        utils.waitForElementVisible(By.xpath(TEMPERORY_CALL_ROUTING_LABEL));
        utils.waitForElementVisible(By.xpath(TCR_DEFAULTED_TO_NONE));
        utils.selectByVisibleText(By.id(TCR_DROPDOWN), "Call Divert");
        utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
        utils.clickBtn(By.id(INCIDENT_SAVE_BUTTON));
        try {
            utils.waitForElementVisible(By.xpath(VALIDATION_MESSAGE_FOR_TCR_CALL_DIVERT_CLI));
        } catch (Exception e) {
            System.out.println("no validation message for unpopulated call divert CLI");
        }
        Thread.sleep(1000);
        utils.scrollUp(By.xpath(TEMPERORY_CALL_ROUTING_LABEL));
        Thread.sleep(1000);
        utils.waitForElementVisible(By.id(TRC_CLI_FIELD));
        utils.sendText(By.id(TRC_CLI_FIELD), "020abcdef");
        utils.waitForElementVisible(By.xpath(TCR_CALL_DIVERT_CLI_CAN_ONLY_HAVE_SPACES_AND_NUMBERS));
        utils.sendText(By.id(TRC_CLI_FIELD), "02012345678");
        utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
        utils.assertElementNotPresent(By.xpath(TCR_CALL_DIVERT_CLI_CAN_ONLY_HAVE_SPACES_AND_NUMBERS));
        utils.waitForElementVisible(By.xpath(TEMPORARILY_SUSPEND_CPS_DEFAULTED_TO_NO));
        utils.assertElementNotPresent(By.xpath(TEMPORARILY_SUSPEND_CPS_SET_TO_YES));
        utils.clickBtn(By.xpath(YES_BUTTON_ON_TEMPORARILY_SUSPEND_CPS));
        utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(TEMPORARILY_SUSPEND_CPS_SET_TO_YES));
    }

    public void lineTest_Fail() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001',DPType='Internal',MainFaultLocation='EX',FaultReportAdvised='Y',LineStability='Stable',NetworkStability='Stable',StabilityStatement=' Stable - no adverse line test history',TestOutcome='Fail',DiagnosisDescription='FAULT - Line Tested OK but No Dial Tone Detected',DiagnosisCode='T073' where serviceid='02063678369'");
        utils.clickBtn(By.xpath("//a[text()[contains(.,'Perform a line test')]]"));
        utils.waitForElementVisible(By.xpath(LINE_TEST_FAILED));
        utils.waitForElementVisible(By.xpath(FAILED_LINE_TEST_DESC));
        utils.waitForElementVisible(By.xpath(REPORT_LINE_FAULT));
    }

    public void lineTest_Pass() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001',DPType=NULL,MainFaultLocation=NULL,FaultReportAdvised=NULL,LineStability='stable',NetworkStability='stable',StabilityStatement='stable',TestOutcome=NULL,DiagnosisDescription=NULL,DiagnosisCode=NULL where serviceid='02063678369'");
        utils.waitForElementVisible(By.xpath(REDO_LINE_TEXT_BUTTON));
        utils.clickBtn(By.xpath(REDO_LINE_TEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(LINE_TEST_PASSED));
        utils.waitForElementVisible(By.xpath(PASSED_LINE_TEST_DESC));
        utils.waitForElementVisible(By.xpath(NEED_NOT_REPORT_LINE_FAULT));
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Line Stability')]"));
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Network Stability')]"));
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Stability Statement')]"));
    }

    public void overNightLineTest() throws InterruptedException {
        Thread.sleep(1000);
        utils.scrollUp(By.xpath(TEXT_ON_LINE_AND_INSTALLATION_DETAILS_PAGE));
        utils.waitForElementToBeClickable(By.id("refreshOrderDetails"));
        utils.clickBtn(By.id("refreshOrderDetails"));
        utils.waitForElementVisible(By.xpath(OVERNIGHT_LINE_TEST_BUTTON));
        utils.clickBtn(By.xpath(OVERNIGHT_LINE_TEST_BUTTON));
        utils.waitForElementVisible(By.xpath(REDO_LINE_TEXT_BUTTON));
        utils.clickBtn(By.xpath(REDO_LINE_TEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(LINE_TEST_PASSED));
        utils.waitForElementVisible(By.xpath(PASSED_LINE_TEST_DESC));
        utils.assertElementNotPresent(By.xpath("//label[contains(text(),'Line Stability')]"));
        utils.assertElementNotPresent(By.xpath("//label[contains(text(),'Network Stability')]"));
        utils.assertElementNotPresent(By.xpath("//label[contains(text(),'Stability Statement')]"));
    }

    public void assertLineTestAndTRCAbsentForISDN30AndVirtualLines() {
        utils.waitForElementVisible(By.xpath(FAULT_DETAILS_LABEL));
        utils.assertElementNotPresent(By.xpath(LINE_TEST_LABEL));
        utils.assertElementNotPresent(By.xpath(TIME_RELATED_CHARGES_LABEL));
    }

    public void validateTimeRelatedCharges() {
        utils.waitForElementVisible(By.xpath(TIME_RELATED_CHARGES_LABEL));
        utils.waitForElementVisible(By.xpath(TRC_DEFAULTED_TO_BAND_0));

    }

    public void assertServiceMaintenanceLevelsAbsent(boolean isVirtualLine, boolean isAgent) throws InterruptedException, UnsupportedEncodingException, ClassNotFoundException {
        utils.waitForElementVisible(By.xpath("//legend[contains(text(),'Fault details')]"));
        if (isVirtualLine) {
            utils.assertElementNotPresent(By.xpath(SERVICE_MAINTENANCE_LEVEL_TEXT_LABEL));
        }
        if (isAgent) {
            utils.waitForElementVisible(By.xpath(SERVICE_MAINTENANCE_LEVEL_TEXT_LABEL));
            utils.assertElementNotPresent(By.xpath(TEXT_LABEL_EXPEDIATE_FAULT_BY_INCREASING_CARELEVEL));
        }
    }

    public void assertThatServiceLevelsUnavailableForISDN30WithLevel2() {
        utils.waitForElementVisible(By.xpath(VALIDATION_MESSAGE_FOR_ISDN30_WITH_CARE_LEVEL_2));
    }

    public void assertServiceMaintenanceLevelsPresent() {
        utils.waitForElementVisible(By.xpath(SERVICE_MAINTENANCE_LEVEL_TEXT_LABEL));
        utils.waitForElementVisible(By.xpath(TEXT_LABEL_EXPEDIATE_FAULT_BY_INCREASING_CARELEVEL));

    }

    public void assertCurrentServiceLevel(String currentLevel) {
        utils.waitForElementVisible(By.xpath("//strong[@id='CareLvlCurrentLvl'][contains(text(),'" + currentLevel + "')]"));
    }

    public void selectServiceLevel(String newLevel) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(YES_BUTTON_TO_EXPEDITE_FAULT));
        Thread.sleep(1000);
        utils.scrollUp(By.xpath(SERVICE_MAINTENANCE_LEVEL_TEXT_LABEL));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(YES_BUTTON_TO_EXPEDITE_FAULT));
        utils.waitForElementVisible(By.id(CARE_LEVEL_PLAN_DROPDOWN));
        utils.selectByVisibleText(By.id(CARE_LEVEL_PLAN_DROPDOWN), "" + newLevel + "");
    }


    public Date IfSaturday(boolean IncreaseByMonth) {
        Date Level2ExpectedSaturday = new Date();
        Calendar calLevel2NonSaturday = Calendar.getInstance();
        calLevel2NonSaturday.setTime(Level2ExpectedSaturday);
        calLevel2NonSaturday.add(Calendar.DATE, 2);
        if (IncreaseByMonth) {
            calLevel2NonSaturday.add(Calendar.YEAR, 2);
        }
        Level2ExpectedSaturday = calLevel2NonSaturday.getTime();
        return Level2ExpectedSaturday;
    }

    public Date NonSaturday() {
        Date Level2ExpectedNonSaturday = new Date();
        Calendar calLevel2NonSaturday = Calendar.getInstance();
        calLevel2NonSaturday.setTime(Level2ExpectedNonSaturday);
        calLevel2NonSaturday.add(Calendar.DATE, 1);
        Level2ExpectedNonSaturday = calLevel2NonSaturday.getTime();
        return Level2ExpectedNonSaturday;
    }

    public Date Level4Time() {
        Date Level4ExpectedTime = new Date();
        Calendar calLevel4ExpectedTime = Calendar.getInstance();
        calLevel4ExpectedTime.setTime(Level4ExpectedTime);
        calLevel4ExpectedTime.add(Calendar.HOUR_OF_DAY, 6);
        Level4ExpectedTime = calLevel4ExpectedTime.getTime();
        return Level4ExpectedTime;
    }


    public void assertCurrentServiceLevelWithCurrent(boolean level2, boolean level3, boolean level4) throws InterruptedException, ParseException {
        Thread.sleep(1000);
        utils.scrollUp(By.xpath(SERVICE_MAINTENANCE_LEVEL_TEXT_LABEL));
        utils.waitForElementVisible(By.id(ESTIMATED_DATE_AND_TIME_OF_REPAIR));
        utils.splitString(By.xpath("//strong[@id='CareLvlEstFixDate'][contains(text(),'')]"));
        String LevelDay = split[0];
        String LevelDate = split[1];
        String LevelTime = split[4];
//to get the date, time and day of the week for present day
        today = new Date();
        currentDayOfTheWeek = new SimpleDateFormat("EEEE").format(today);
        String CurrentTime = new SimpleDateFormat("HH:mm").format(today);
        String currentDate = new SimpleDateFormat("d").format(today);
        if (level2) {
            try {
                String ExpectedDayOfTheWeek = new SimpleDateFormat("EEEE" + ",").format(NonSaturday());
                String ExpectedDay = new SimpleDateFormat("d").format(NonSaturday());
                Assert.assertEquals(LevelDay, ExpectedDayOfTheWeek);
                Assert.assertEquals(LevelDate, ExpectedDay);
            } catch (AssertionError e) {
                String ExpectedDayOfTheWeek = new SimpleDateFormat("EEEE" + ",").format(IfSaturday(false));
                String ExpectedDay = new SimpleDateFormat("d").format(IfSaturday(false));
                Assert.assertEquals(LevelDay, ExpectedDayOfTheWeek);
                Assert.assertEquals(LevelDate, ExpectedDay);
                Assert.assertNotEquals(LevelTime, CurrentTime);
                Assert.assertEquals(LevelTime, "23:59");
            }
        }

        if (level3) {
            try {

                try {
                    Assert.assertEquals(LevelTime, "23:59");
                    Assert.assertEquals(LevelDate, currentDate);
                } catch (AssertionError e) {
                    Assert.assertEquals(LevelTime, "13:00");
                    String ExpectedDay = new SimpleDateFormat("d").format(NonSaturday());
                    Assert.assertEquals(LevelDate, ExpectedDay);
                }
            } catch (AssertionError e) {
                Assert.assertEquals(LevelTime, "13:00");
                String ExpectedDay = new SimpleDateFormat("d").format(IfSaturday(false));
                Assert.assertEquals(LevelDate, ExpectedDay);
            }
        }
        if ((level4)) {
            try {
                String level4ExpTime = new SimpleDateFormat("HH:mm").format(Level4Time());
                Assert.assertEquals(LevelTime, level4ExpTime);
                Assert.assertEquals(LevelDate, currentDate);
            } catch (AssertionError e) {
                String level4ExpTime = new SimpleDateFormat("HH:mm").format(Level4Time());
                Assert.assertEquals(LevelTime, level4ExpTime);
                String ExpectedDay = new SimpleDateFormat("d").format(NonSaturday());
                Assert.assertEquals(LevelDate, ExpectedDay);
            }

        }

    }

    public void clickBrowserIncidentsButton() {
            utils.clickBtn(By.xpath(LOAD_BROWSE_INCIDENTS_BUTTON));
    }

    public void navigateToBrowseIncidents() {
        if (utils.isElementAbsent(By.xpath(MINIFIED_SERVICE_DESK_PANEL))) {
            clickBrowserIncidentsButton();
        }
        if (utils.isElementPresent(By.xpath(MINIFIED_SERVICE_DESK_PANEL)))
            utils.clickBtn(By.xpath(MAGNIFY_SERVICE_DESK_PANEL));
        clickBrowserIncidentsButton();
        {
        }
    }

    public void browserIncidents(String by, String commonSearch, String finalSearch) throws InterruptedException {
        commonMethods.searchBoxWithVariableElement(By.xpath(SEARCH_BOX_BROWSE_INCIDENTS), by);
        utils.waitForElementVisibleForWLR3Page(By.xpath("//span[contains(text(),'" + by + "')]"));

        if (utils.isElementPresent(By.xpath(IMPORT_MANAGER_DROP_DOWN))) {
            commonMethods.searchBoxWithVariableElement(By.xpath(SEARCH_BOX_BROWSE_INCIDENTS), "" + commonSearch + "");
            utils.waitForElementVisibleForWLR3Page(By.xpath("//td[contains(text(),'Adam Co.')]"));
        }
        if (utils.isElementAbsent(By.xpath(IMPORT_MANAGER_DROP_DOWN))) {
            commonMethods.searchBoxWithVariableElement(By.xpath(SEARCH_BOX_BROWSE_INCIDENTS), "" + commonSearch + "");
            utils.waitForElementVisibleForWLR3Page(By.xpath(NO_INCIDENTS_TEXT_LABEL));
        }
        commonMethods.searchBoxWithVariableElement(By.xpath(SEARCH_BOX_BROWSE_INCIDENTS), "" + finalSearch + "");
        utils.waitForElementVisibleForWLR3Page(By.xpath("//span[contains(text(),'" + finalSearch + "')]"));
    }

    public void validateColumns_BrowserIncidents() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(EXPAND_BUTTON_ON_INCIDENT));
        utils.clickBtn(By.xpath(EXPAND_BUTTON_ON_INCIDENT));
        utils.waitForElementVisible(By.xpath(RECESSED_CATEGORY_COLUMN));
        utils.waitForElementVisible(By.xpath(RECESSED_OWNER_COLUMN));
        utils.waitForElementVisible(By.xpath(RECESSED_LOGGED_COLUMN));
        utils.waitForElementVisible(By.xpath(EXPAND_BUTTON_ON_BROWSE_INCIDENTS_PAGE));
        utils.clickBtn(By.xpath(EXPAND_BUTTON_ON_BROWSE_INCIDENTS_PAGE));
        utils.waitForElementVisible(By.xpath(EXPANDED_LOGGED_COLUMN));
        utils.waitForElementVisible(By.xpath(EXPANDED_OWNER_COLUMN));
        utils.waitForElementVisible(By.xpath(EXPANDED_CATEGORY_COLUMN));

    }

    public void validateShowEntries() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(INCIDENT_COLUMN));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(INCIDENT_COLUMN));
        utils.waitForElementVisible(By.xpath(SORTED_BY_ASC_ORDER));
        utils.waitForElementVisible(By.xpath(SHOWS_1_TO_10_ROWS));
        utils.waitForElementVisible(By.xpath(FIRST_ITEM_ON_THE_FIRST_PAGE_WITH_ENTRIES_PER_PAGE_10));
        utils.waitForElementVisible(By.xpath(LAST_ITEM_ON_THE_FIRST_PAGE_WITH_ENTRIES_PER_PAGE_10));
        utils.selectByVisibleText(By.xpath(ENTRIES_PER_PAGE_DROP_DOWN), "50");
        utils.waitForElementVisible(By.xpath(PAGE_FOOTER_SHOWING_1_TO_50_ROWS_PER_PAGE));
        utils.waitForElementVisible(By.xpath(LAST_ITEM_ON_THE_FIRST_PAGE_WITH_ENTRIES_PER_PAGE_50));
    }

    public void validatePagination() {
        utils.waitForElementVisible(By.xpath(PAGINATION_ACTIVE_PAGE_1));
        utils.clickBtn(By.xpath(NAVIGATE_TO_PAGE_2));
        utils.waitForElementVisible(By.xpath(PAGINATION_ACTIVE_PAGE_2));
        utils.waitForElementVisible(By.xpath(SHOWS_51_TO_100_ROWS));
    }
}









