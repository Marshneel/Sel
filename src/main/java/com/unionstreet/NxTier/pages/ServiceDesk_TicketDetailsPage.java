package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.unionstreet.NxTier.support.BaseClass.driver;

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
    private final String FAULT_SQC_DROPDOWN = "StructuredQueryCode";
    private final String INCIDENT_SAVE_BUTTON = "wizardButton_SaveIncident";
    private final String TIME_RELATED_CHARGES_LABEL = "//legend[contains(text(),'Time Related Charges')]";
    private final String TEMPERORY_CALL_ROUTING_LABEL = "//legend[contains(text(),'Temporary Call Routing')]";
    private final String NETWORK_FEATURES_DROPDOWN = "AvailableNetworkFeatureId";
    private final String PIN_LABEL = "//label[text()[contains(.,'Pin')]]";
    private final String PIN_TEXT_FIELD = "Pin";
    private final String PIN_VALIDATION_MESSAGE = "//span[text()[contains(.,'Please enter a numeric pin of four digits')]]";
    private final String SAMPLE_CALLS_LABEL = "//h5[text()[contains(.,'Sample calls')]]";
    private final String SAMPLE_CALLS_DATE_FIELD = "SampleCalls_0__SampleCallDate";
    private final String SAMPLE_CALLS_TIME_FIELD = "SampleCalls_0__SampleCallTime";
    private final String SAMPLE_CALLS_CLI_FIELD = "SampleCalls_0__SampleCallCLI";
    private final String SAMPLE_CALLS_DIALLED_FROM_TO_FIELD = "SampleCalls_0__SampleCallDialledFromTo";
    private final String DELETE_BUTTON_FOR_SAMPLECALLS_2ND_ROW = "//div[@id='sampleCallsContainer']/div[3]/div[4]//i";
    private final String DELETE_BUTTON_FOR_SAMPLECALLS_1ST_ROW = "//div[@id='sampleCallsContainer']/div[2]/div[4]//i";
    private final String TCR_DEFAULTED_TO_NONE = "//select[@id='TCROptions']//option[contains(text(),'None')]";
    private final String TCR_DROPDOWN = "TCROptions";
    private final String TRC_DEFAULTED_TO_BAND_0 = "//select[@id='TRCBands']//option[@selected='selected'][contains(text(),'Band 0 - No authorisation')]";
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
    private final String YES_BUTTON_ON_TEMPORARILY_SUSPEND_CPS = "//a[@href='#nav-pills-tab-6'][@aria-expanded='true'][contains(text(),'Yes')]";
    private final String TRC_CLI_FIELD = "TCRDivertTo";
    private final String VALIDATION_MESSAGE_FOR_TCR_CALL_DIVERT_CLI = "//span[contains(text(),'Please enter a divert number')]";
    private final String TCR_CALL_DIVERT_CLI_CAN_ONLY_HAVE_SPACES_AND_NUMBERS = "//span[contains(text(),'To may only contain numbers or spaces')]";
    private final String DATE_IS_REQUIRED_FOR_SAMPLE_CALLS = "//li[text()[contains(.,'A Date is required for Sample Calls')]]";
    private final String CHOOSE_LINE_FOR_MULTILINE_LABEL = "//label[text()='Line']";
    private final String CHOOSE_LINE_FOR_MULTILINE_DROPDOWN = "Line";
    private final String CHOOSE_LINE_FOR_MULTILINE_VALIDATION_MESSAGE = "//span[text()='The field Line must be a number.']";
    private final String FEATURE_MUST_BE_SELECTED_VALIDATION_MESSAGE = "//span[text()[contains(.,'A Feature must be selected')]]";
    private final String DOWNTIME_TEXT_BOX = "wlr3_down_time";

    private Date today;
    String currentDate;
    String currentTime;
    ElementUtils utils=new ElementUtils();



    public void assertTextOnTicketDetailsPage() {
        utils.waitForElementVisible(By.xpath(TEXT_ON_LINE_AND_INSTALLATION_DETAILS_PAGE));
    }

    public void clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode() {
        utils.clickBtn(By.id(OBTAIN_ORDER_DETAILS));
        utils.waitForElementVisible(By.xpath(SELECT_CLI_FIELD_IS_REQUIRED));
        utils.waitForElementVisible(By.xpath(THE_CONFIRM_POST_CODE_IS_REQUIRED));
    }

    public void selectCLIToObtainInstallationDetails(String cli, String lineType, String numberOfLines, String maintenanceLevel, boolean notVirtualLine) throws InterruptedException {
        utils.waitForElementToBeClickable(By.xpath(SELECT_CLI_DROPDOWN));
        utils.clickBtn(By.xpath(SELECT_CLI_DROPDOWN));
        utils.waitForElementToVanish(By.xpath(OPEN_REACH_SPINNER));
        utils.waitForElementVisible(By.xpath(SEARCH_BOX_FOR_CLI));
        utils.sendText(By.xpath(SEARCH_BOX_FOR_CLI), "" + cli + "");
        utils.waitForElementVisible(By.xpath("//td[text()[contains(.,'"+cli+"')]]/following-sibling::td[text()[contains(.,'LU1 1DQ')]]/following-sibling::td[3]/button[contains(text(),'Select')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(SELECT_CLI_BUTTON));
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Installation Details for " + cli + "')]"));
        utils.waitForElementVisible(By.xpath("//strong[contains(text(),'" + lineType + "')]"));
        if(notVirtualLine){   utils.waitForElementVisible(By.xpath("//strong[contains(text(),'" + numberOfLines + "')]"));
            utils.waitForElementVisible(By.xpath("//strong[contains(text(),'" + maintenanceLevel + "')]"));
            utils.waitForElementVisibleForOpenReach(By.xpath(CPS_PRESENT_RESULT));
            String valueForCPS = driver.findElement(By.xpath(CPS_PRESENT_RESULT)).getText();
            String valueForCalAndNetwrkFeatures = driver.findElement(By.xpath(CALLING_AND_NETWORK_FEATURES)).getText();
            utils.twoValueArrayList("Yes", "No");
            Assert.assertTrue(utils.allValues.contains(valueForCPS));
            Assert.assertTrue(utils.allValues.contains(valueForCalAndNetwrkFeatures));}
    }

    public void faultDetails_assertionForAnalogueLines(boolean multiLine) throws InterruptedException {
        utils.waitForElementVisible(By.xpath(INTERMITTENT_FAULT_TEXT));
        if (multiLine) {
            utils.waitForElementVisible(By.xpath(CHOOSE_LINE_FOR_MULTILINE_LABEL));
            utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
            utils.clickBtn(By.id(INCIDENT_SAVE_BUTTON));
            utils.waitForElementVisible(By.xpath(CHOOSE_LINE_FOR_MULTILINE_VALIDATION_MESSAGE));
            utils.waitForElementVisible(By.id(CHOOSE_LINE_FOR_MULTILINE_DROPDOWN));
            utils.selectByVisibleText(By.id(CHOOSE_LINE_FOR_MULTILINE_DROPDOWN), "1");
        }
        utils.waitForElementVisible(By.xpath(STD_LINE_TEST_BUTTON));
        utils.waitForElementVisible(By.xpath(OVERNIGHT_LINE_TEST_BUTTON));
        utils.selectByVisibleText(By.id(FAULT_SQC_DROPDOWN), "Exchange Service Facility");
        utils.performClickActionTillElementIsDetected(By.xpath(FEATURE_MUST_BE_SELECTED_VALIDATION_MESSAGE), By.id(INCIDENT_SAVE_BUTTON));
        utils.waitForElementVisible(By.id(NETWORK_FEATURES_DROPDOWN));
        utils.selectByVisibleText(By.id(NETWORK_FEATURES_DROPDOWN), "Smart Divert");
        utils.waitForElementToBeClickable(By.xpath("//legend[contains(text(),'Line and installation details')]"));
        Thread.sleep(1000);
        utils.scrollUp(By.xpath("//legend[contains(text(),'Line and installation details')]"));
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
        utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
        utils.clickBtn(By.id(INCIDENT_SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(DATE_IS_REQUIRED_FOR_SAMPLE_CALLS));
        utils.waitForElementVisible(By.xpath("//li[text()[contains(.,'A Dialled From/To is required for Sample Calls')]]"));
        utils.waitForElementVisible(By.xpath("//span[text()[contains(.,'Please enter a Down Time')]]"));
        utils.waitForElementVisible(By.id(DOWNTIME_TEXT_BOX));
        utils.sendText(By.id(DOWNTIME_TEXT_BOX),"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        utils.waitForElementVisible(By.xpath("//span[text()[contains(.,'Downtime must be no more than 255 characters')]]"));
        Thread.sleep(1000);
        utils.sendText(By.id(DOWNTIME_TEXT_BOX),"mmmmmmmmmmm");}


    public void validateSampleCalls() throws InterruptedException {  today = new Date();
        currentDate = new SimpleDateFormat("dd/MM/YYYY").format(today);
        currentTime=new SimpleDateFormat("KK:mm").format(today);
        utils.waitForElementVisible(By.id(SAMPLE_CALLS_DATE_FIELD));
        utils.sendText(By.id(SAMPLE_CALLS_DATE_FIELD), currentDate);
        utils.waitForElementVisible(By.id(SAMPLE_CALLS_TIME_FIELD));
        utils.sendText(By.id(SAMPLE_CALLS_TIME_FIELD), currentTime);
        utils.waitForElementVisible(By.id(SAMPLE_CALLS_CLI_FIELD));
        utils.sendText(By.id(SAMPLE_CALLS_CLI_FIELD),"02012345678");
        utils.waitForElementVisible(By.id(SAMPLE_CALLS_DIALLED_FROM_TO_FIELD));
        utils.sendText(By.id(SAMPLE_CALLS_DIALLED_FROM_TO_FIELD),"02012345678");
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
        utils.selectByVisibleText(By.id(TCR_DROPDOWN),"Call Divert");
        utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
        utils.clickBtn(By.id(INCIDENT_SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(VALIDATION_MESSAGE_FOR_TCR_CALL_DIVERT_CLI));
        utils.sendText(By.id(TRC_CLI_FIELD),"020abcdef");
        utils.waitForElementVisible(By.xpath(TCR_CALL_DIVERT_CLI_CAN_ONLY_HAVE_SPACES_AND_NUMBERS));
        utils.sendText(By.id(TRC_CLI_FIELD),"02012345678");
        utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
        utils.clickBtn(By.id(INCIDENT_SAVE_BUTTON));
        utils.assertElementNotPresent(By.xpath(TCR_CALL_DIVERT_CLI_CAN_ONLY_HAVE_SPACES_AND_NUMBERS));
        utils.waitForElementVisible(By.xpath(TEMPORARILY_SUSPEND_CPS_DEFAULTED_TO_NO));
        utils.assertElementNotPresent(By.xpath(TEMPORARILY_SUSPEND_CPS_SET_TO_YES));
        utils.clickBtn(By.xpath(YES_BUTTON_ON_TEMPORARILY_SUSPEND_CPS));
        utils.waitForElementVisible(By.id(INCIDENT_SAVE_BUTTON));
        utils.clickBtn(By.id(INCIDENT_SAVE_BUTTON));
        utils.waitForElementVisible(By.xpath(TEMPORARILY_SUSPEND_CPS_SET_TO_YES));
    }
    public void lineTest_Fail() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001',DPType='Internal',MainFaultLocation='EX',FaultReportAdvised='Y',LineStability='Stable',NetworkStability='Stable',StabilityStatement=' Stable - no adverse line test history',TestOutcome='Fail',DiagnosisDescription='FAULT - Line Tested OK but No Dial Tone Detected',DiagnosisCode='T073' where serviceid='02063678369'");
        utils.waitForElementVisible(By.xpath(STD_LINE_TEST_BUTTON));
        utils.clickBtn(By.xpath(STD_LINE_TEST_BUTTON));
        utils.waitForElementVisible(By.xpath(LINE_TEST_FAILED));
        utils.waitForElementVisible(By.xpath(FAILED_LINE_TEST_DESC));
        utils.waitForElementVisible(By.xpath(REPORT_LINE_FAULT));
    }
    public void lineTest_Pass() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001',DPType=NULL,MainFaultLocation=NULL,FaultReportAdvised=NULL,LineStability=NULL,NetworkStability=NULL,StabilityStatement=NULL,TestOutcome=NULL,DiagnosisDescription=NULL,DiagnosisCode=NULL where serviceid='02063678369'");
        utils.waitForElementVisible(By.xpath(REDO_LINE_TEXT_BUTTON));
        utils.clickBtn(By.xpath(REDO_LINE_TEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(LINE_TEST_PASSED));
        utils.waitForElementVisible(By.xpath(PASSED_LINE_TEST_DESC));
        utils.waitForElementVisible(By.xpath(NEED_NOT_REPORT_LINE_FAULT));}


    public void overNightLineTest() throws InterruptedException {
        Thread.sleep(1000);
        utils.scrollUp(By.xpath("//legend[contains(text(),'Line and installation details')]"));
        utils.waitForElementToBeClickable(By.id("refreshOrderDetails"));
        utils.clickBtn(By.id("refreshOrderDetails"));
        utils.waitForElementVisible(By.xpath(OVERNIGHT_LINE_TEST_BUTTON));
        utils.clickBtn(By.xpath(OVERNIGHT_LINE_TEST_BUTTON));
        utils.waitForElementVisible(By.xpath(REDO_LINE_TEXT_BUTTON));
        utils.clickBtn(By.xpath(REDO_LINE_TEXT_BUTTON));
        utils.waitForElementVisible(By.xpath(LINE_TEST_PASSED));
        utils.waitForElementVisible(By.xpath(PASSED_LINE_TEST_DESC));
    }

    public void assertLineTestAndTRCAbsentForISDN30AndVirtualLines(){
        utils.waitForElementVisible(By.xpath(FAULT_DETAILS_LABEL));
        utils.assertElementNotPresent(By.xpath(LINE_TEST_LABEL));
        utils.assertElementNotPresent(By.xpath(TIME_RELATED_CHARGES_LABEL));
    }

    public void validateTimeRelatedCharges(){
        utils.waitForElementVisible(By.xpath(TIME_RELATED_CHARGES_LABEL));
        utils.waitForElementVisible(By.xpath(TRC_DEFAULTED_TO_BAND_0));

    }


}











