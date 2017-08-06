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
 * Created by RajeshG on 21/06/2017.
 */
public class ServiceDesk_LoginIncidentPage {

    private final String PLEASE_SELECT_A_CONTACT_OR_SPECIFY_THAT_THE_CALLER_IS_THIRD_PARTY = "//p[contains(text(),'Please select a contact or specify that the caller is third party')]";
    private final String PLEASE_ENTER_A_CONTACT_NAME = "//span[contains(text(),'Please enter a contact name')]";
    private final String PLEASE_ENTER_EITHER_AN_EMAIL_ADDRESS_OR_A_CONTACT_TELEPHONE_NUMBER = "//span[contains(text(),'Please enter either an email address or a contact telephone number.')]";
    private final String CLICK_NEXT = "//a[contains(text(),'Next')]";
    private final String CLICK_PREVIOUS = "//a[contains(text(),'Previous')]";
    private final String TEXT_ON_CALLER_DETAILS = "//span[contains(text(),'Caller Details')]";
    private final String SELECT_CONTACT_ON_CALLER_DETAILS_PAGE = "ContactId";
    private final String PLEASE_ENTER_A_PRIORITY_LEVEL = "//span[contains(text(),'Please enter a Priority level for this Incident')]";
    private final String EMAIL_ADDRESS_ON_CALLER_DETAILS_PAGE = "ContactEmailAddress";
    private final String TRAIAGE_PAGE_HEADER_TEXT = "//span[contains(text(),'Triage')]";
    private final String PLEASE_SELECT_AN_APPROPRIATE_SYMPTOM_FOR_THE_INCIDENT = "//span[contains(text(),'Please select an appropriate Symptom for this Incident')]";
    private final String PLEASE_SELECT_AN_INCIDENT_CATEGORY = "//span[contains(text(),'Please select an Incident Category')]";
    private final String PLEASE_SELECT_AN_OWNER_FOR_INCIDENT = "//span[contains(text(),'Please select the Owner of this Incident')]";
    private final String PLEASE_SELECT_AN_INCIDENT_TYPE = "//span[contains(text(),'Please select an Incident Type')]";
    private final String THE_SUMMARY_MUST_HAVE_NO_MORE_THAN_256_WORDS = "//span[contains(text(),'The Summary must be no more than 256 characters')]";
    private final String THE_SUMMARY_CAN_BE_NO_MORE_THAN_80_CHARACTERS = "//span[contains(text(),'The Summary must be no more than 80 characters')]";
    private final String PLEASE_ENTER_A_SUMMARY_FOR_INCIDENT = "//span[contains(text(),'Please enter a brief Summary for this Incident')]";
    private final String EDIT_AN_INCIDENT = "//h1[contains(text(),'Edit an incident')]";
    private final String PRIORITY_TEXT = "//label[contains(text(),'Priority')]";
    private final String PRIORITY_DROPDOWN = "IncidentPriority";
    private final String INCIDENT_TYPE = "IncidentType";
    private final String INCIDENT_SYMPTOM = "IncidentSymptom";
    private final String INCIDENT_CATEGORY = "IncidentCategory";
    private final String INCIDENT_SUMMARY = "IncidentSummary";
    private final String INCIDENT_OWNER = "IncidentOwner";
    private final String CONTACT_IS_THIRD_PARTY_CHECKBOX = "//label[contains(text(),'Contact is third-party')]";
    private final String CONTACT_NAME_FIELD = "ContactName";
    private final String CONTACT_EMAILID = "ContactEmailAddress";
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
    private Date today;
    String currentDate;
   String currentTime;


    ElementUtils utils = new ElementUtils();

    public void correspondenceDetailsValidations() {
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_A_CONTACT_OR_SPECIFY_THAT_THE_CALLER_IS_THIRD_PARTY));
        utils.waitForElementVisible(By.xpath(PLEASE_ENTER_A_CONTACT_NAME));
        utils.waitForElementVisible(By.xpath(PLEASE_ENTER_EITHER_AN_EMAIL_ADDRESS_OR_A_CONTACT_TELEPHONE_NUMBER));
    }

    public void clickNext() {
        utils.waitForElementVisible(By.xpath(CLICK_NEXT));
        utils.clickBtn(By.xpath(CLICK_NEXT));
    }

    public void clickPrevious() {
        utils.waitForElementVisible(By.xpath(CLICK_PREVIOUS));
        utils.clickBtn(By.xpath(CLICK_PREVIOUS));
    }

    public void clickNextWithOutPopulatingCallerDetailsTab() {
        utils.waitForElementVisible(By.xpath(TEXT_ON_CALLER_DETAILS));
        clickNext();
        correspondenceDetailsValidations();
    }

    public void clickNextAfterPopulatingContact() {
        utils.waitForElementVisible(By.id(SELECT_CONTACT_ON_CALLER_DETAILS_PAGE));
        utils.selectByVisibleText(By.id(SELECT_CONTACT_ON_CALLER_DETAILS_PAGE), "Adam Reed (adam.reed@unionstreet.uk.com)");
        utils.waitForElementVisible(By.id(EMAIL_ADDRESS_ON_CALLER_DETAILS_PAGE));
        utils.sendText(By.id(EMAIL_ADDRESS_ON_CALLER_DETAILS_PAGE), "adam.reed@unionstreet.uk.com");
        clickNext();
        utils.waitForElementVisible(By.xpath(TRAIAGE_PAGE_HEADER_TEXT));
    }

    public void populateThirdParty() {
        utils.waitForElementVisible(By.xpath(CONTACT_IS_THIRD_PARTY_CHECKBOX));
        utils.clickBtn(By.xpath(CONTACT_IS_THIRD_PARTY_CHECKBOX));
        correspondenceDetailsValidations();
        utils.sendText(By.id(CONTACT_NAME_FIELD), "Adam Reed");
        utils.waitForElementVisible(By.id(CONTACT_EMAILID));
        utils.sendText(By.id(CONTACT_EMAILID), "adam.reed@unionstreet.uk.com");
        clickNext();
        utils.waitForElementVisible(By.xpath(TRAIAGE_PAGE_HEADER_TEXT));
    }

    public void validationMessagesOnnTriagePage() {
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_AN_APPROPRIATE_SYMPTOM_FOR_THE_INCIDENT));
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_AN_INCIDENT_CATEGORY));
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_AN_OWNER_FOR_INCIDENT));
    }

    public void clickNextWithOutPopulatingTriage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(TRAIAGE_PAGE_HEADER_TEXT));
        utils.waitForElementVisible(By.id("IncidentOwner"));
        utils.selectByVisibleText(By.id("IncidentOwner"), "Select...");
        clickNext();
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_AN_INCIDENT_TYPE));
        validationMessagesOnnTriagePage();
    }

    public void openReachIncident_Triage(Boolean nextOrNot) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set cli_type='1', openreach_function='1' where RecordID='4'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_symptoms set Symptom='Test Symptom 1', tmp_IncidentType='Test Type Fault 1' where RecordID='33'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_categories set category='Test Category 1',tmp_IncidentType='Test Type Fault 1' where RecordID='11'");
        utils.waitForElementVisible(By.id(INCIDENT_TYPE));
        utils.selectByVisibleText(By.id(INCIDENT_TYPE), "Test Type Fault 1");
        utils.waitForElementVisible(By.id("IncidentOwner"));
        utils.selectByVisibleText(By.id("IncidentOwner"), "Select...");
        clickNext();
        validationMessagesOnnTriagePage();
        clickNext();
        utils.waitForElementVisible(By.xpath(PLEASE_ENTER_A_SUMMARY_FOR_INCIDENT));
        populateSymptomAndCategory("Test Symptom 1", "Test Category 1");
        utils.waitForElementVisible(By.id(INCIDENT_SUMMARY));
        utils.sendText(By.id(INCIDENT_SUMMARY), "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        utils.waitForElementVisible(By.xpath(THE_SUMMARY_CAN_BE_NO_MORE_THAN_80_CHARACTERS));
        populateSummaryAndOwnerDropDown();
        clickNext();
        utils.waitForElementVisible(By.xpath("//a[@href='#tab3'][@aria-expanded='true']"));
        if (nextOrNot == true)
            clickPrevious();
    }

    public void populateSymptomAndCategory(String symptom, String category) {
        utils.waitForElementVisible(By.id(INCIDENT_SYMPTOM));
        utils.selectByVisibleText(By.id(INCIDENT_SYMPTOM), symptom);
        utils.waitForElementVisible(By.id(INCIDENT_CATEGORY));
        utils.selectByVisibleText(By.id(INCIDENT_CATEGORY), category);
    }

    public void populateSummaryAndOwnerDropDown() {
        utils.sendText(By.id(INCIDENT_SUMMARY), "summary");
        utils.waitForElementVisible(By.id(INCIDENT_OWNER));
        utils.selectByVisibleText(By.id(INCIDENT_OWNER), "Alex");

    }

    public void non_OpenReachIncident_Triage() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set cli_type='1', openreach_function='4' where RecordID='6'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_symptoms set Symptom='Test Symptom 3', tmp_IncidentType='Test Type Fault 3' where RecordID='35'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_categories set category='Test Category 3',tmp_IncidentType='Test Type Fault 3' where RecordID='13'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='1' where ID='156'");

        utils.waitForElementVisible(By.id(INCIDENT_TYPE));
        utils.selectByVisibleText(By.id(INCIDENT_TYPE), "Test Type Fault 3");
        clickNext();
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_AN_APPROPRIATE_SYMPTOM_FOR_THE_INCIDENT));
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_AN_INCIDENT_CATEGORY));
        populateSymptomAndCategory("Test Symptom 3", "Test Category 3");
        utils.waitForElementVisible(By.id(INCIDENT_SUMMARY));
        utils.sendText(By.id(INCIDENT_SUMMARY), "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        clickNext();
        utils.waitForElementVisible(By.xpath(THE_SUMMARY_MUST_HAVE_NO_MORE_THAN_256_WORDS));
        populateSummaryAndOwnerDropDown();
        try {
            clickNext();
        } catch (Exception e) {
            clickNext();
        }
        utils.waitForElementVisible(By.xpath(EDIT_AN_INCIDENT));
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='1' where ID='150'");
        utils.navigateBack();
        //clickPrevious();

    }

    public void choosePriorityOverCategory() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.waitForElementVisible(By.id(INCIDENT_TYPE));
        utils.selectByVisibleText(By.id(INCIDENT_TYPE), "Test Type Fault 3");
        utils.waitForElementVisible(By.id(INCIDENT_SYMPTOM));
        utils.selectByVisibleText(By.id(INCIDENT_SYMPTOM), "Test Symptom 2");
        populateSummaryAndOwnerDropDown();
        utils.waitForElementVisible(By.xpath(PRIORITY_TEXT));
        clickNext();
        utils.waitForElementVisible(By.xpath(PLEASE_ENTER_A_PRIORITY_LEVEL));
        utils.selectByIndex(By.id(PRIORITY_DROPDOWN), 1);
        clickNext();
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='0' where ID='150'");
    }

    public void assertTextOnTicketDetailsPage() {
        utils.waitForElementVisible(By.xpath(TEXT_ON_LINE_AND_INSTALLATION_DETAILS_PAGE));

    }

    public void clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode() {
        utils.clickBtn(By.id(OBTAIN_ORDER_DETAILS));
        utils.waitForElementVisible(By.xpath(SELECT_CLI_FIELD_IS_REQUIRED));
        utils.waitForElementVisible(By.xpath(THE_CONFIRM_POST_CODE_IS_REQUIRED));
    }

    public void selectCLIToObtainInstallationDetails(String cli, String lineType, String numberOfLines, String maintenanceLevel) throws InterruptedException {
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
        utils.waitForElementVisible(By.xpath("//strong[contains(text(),'" + numberOfLines + "')]"));
        utils.waitForElementVisible(By.xpath("//strong[contains(text(),'" + maintenanceLevel + "')]"));
        utils.waitForElementVisibleForOpenReach(By.xpath(CPS_PRESENT_RESULT));
        String valueForCPS = driver.findElement(By.xpath(CPS_PRESENT_RESULT)).getText();
        String valueForCalAndNetwrkFeatures = driver.findElement(By.xpath(CALLING_AND_NETWORK_FEATURES)).getText();
        utils.twoValueArrayList("Yes", "No");
        Assert.assertTrue(utils.allValues.contains(valueForCPS));
        Assert.assertTrue(utils.allValues.contains(valueForCalAndNetwrkFeatures));
    }

    public void faultDetails_assertionForAnalogueLines(boolean multiLine) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//label[text()[contains(.,'Intermittent Fault')]]"));
        if (multiLine) {
            utils.waitForElementVisible(By.xpath("//label[text()='Line']"));
            utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
            utils.clickBtn(By.id("wizardButton_SaveIncident"));
            utils.waitForElementVisible(By.xpath("//span[text()='The field Line must be a number.']"));
            utils.waitForElementVisible(By.id("Line"));
            utils.selectByVisibleText(By.id("Line"), "1");
        }
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'Perform a line test')]]"));
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'Overnight line test')]]"));
        utils.selectByVisibleText(By.id("StructuredQueryCode"), "Exchange Service Facility");
        utils.performClickActionTillElementIsDetected(By.xpath("//span[text()[contains(.,'A Feature must be selected')]]"), By.id("wizardButton_SaveIncident"));
        utils.waitForElementVisible(By.id("AvailableNetworkFeatureId"));
        utils.selectByVisibleText(By.id("AvailableNetworkFeatureId"), "Smart Divert");
        utils.waitForElementVisible(By.xpath("//label[text()[contains(.,'Pin')]]"));
        utils.waitForElementVisible(By.id("Pin"));
        utils.sendText(By.id("Pin"), "123455");
        utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
        utils.clickBtn(By.id("wizardButton_SaveIncident"));
        utils.waitForElementVisible(By.xpath("//span[text()[contains(.,'Please enter a numeric pin of four digits')]]"));
    }

    public void faultDetails_assertionForISDN30E() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//h5[text()[contains(.,'Sample calls')]]"));
        utils.waitForElementVisible(By.id("StructuredQueryCode"));
        utils.selectByVisibleText(By.id("StructuredQueryCode"), "Noisy");
        utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
        utils.clickBtn(By.id("wizardButton_SaveIncident"));
        utils.waitForElementVisible(By.xpath("//li[text()[contains(.,'A Date is required for Sample Calls')]]"));
        utils.waitForElementVisible(By.xpath("//li[text()[contains(.,'A Dialled From/To is required for Sample Calls')]]"));
        utils.waitForElementVisible(By.xpath("//span[text()[contains(.,'Please enter a Down Time')]]"));
        utils.waitForElementVisible(By.id("wlr3_down_time"));
        utils.sendText(By.id("wlr3_down_time"),"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        utils.waitForElementVisible(By.xpath("//span[text()[contains(.,'Downtime must be no more than 255 characters')]]"));
        Thread.sleep(1000);
        utils.sendText(By.id("wlr3_down_time"),"mmmmmmmmmmm");}



      public void validateSampleCalls() throws InterruptedException {  today = new Date();
        currentDate = new SimpleDateFormat("dd/MM/YYYY").format(today);
        currentTime=new SimpleDateFormat("KK:mm").format(today);
        utils.waitForElementVisible(By.id("SampleCalls_0__SampleCallDate"));
        utils.sendText(By.id("SampleCalls_0__SampleCallDate"), currentDate);
        utils.waitForElementVisible(By.id("SampleCalls_0__SampleCallTime"));
        utils.sendText(By.id("SampleCalls_0__SampleCallTime"), currentTime);
        utils.waitForElementVisible(By.id("SampleCalls_0__SampleCallCLI"));
        utils.sendText(By.id("SampleCalls_0__SampleCallCLI"),"02012345678");
        utils.waitForElementVisible(By.id("SampleCalls_0__SampleCallDialledFromTo"));
        utils.sendText(By.id("SampleCalls_0__SampleCallDialledFromTo"),"02012345678");
        utils.waitForElementVisible(By.xpath("//div[@id='sampleCallsContainer']/div[3]/div[4]//i"));
        utils.clickBtn(By.xpath("//div[@id='sampleCallsContainer']/div[3]/div[4]//i"));
        Thread.sleep(1000);
        utils.assertElementNotPresent(By.xpath("//div[@id='sampleCallsContainer']/div[3]/div[4]//i"));
        utils.waitForElementVisible(By.xpath("//div[@id='sampleCallsContainer']/div[2]/div[4]//i"));
        utils.clickBtn(By.xpath("//div[@id='sampleCallsContainer']/div[2]/div[4]//i"));
        utils.waitForElementVisible(By.xpath("//div[@id='sampleCallsContainer']/div[2]/div[4]//i"));
        utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
        utils.clickBtn(By.id("wizardButton_SaveIncident"));
    }
    public void faultDetails_assertionForISDN2() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'Perform a line test')]]"));
        utils.assertElementNotPresent(By.xpath("//a[text()[contains(.,'Overnight line test')]]"));
        //temporary call routing
        utils.waitForElementVisible(By.xpath("//legend[contains(text(),'Temporary Call Routing')]"));
        utils.waitForElementVisible(By.xpath("//select[@id='TCROptions']//option[contains(text(),'None')]"));
        utils.selectByVisibleText(By.id("TCROptions"),"Call Divert");
        utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
        utils.clickBtn(By.id("wizardButton_SaveIncident"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please enter a divert number')]"));
        utils.sendText(By.id("TCRDivertTo"),"020abcdef");
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'To may only contain numbers or spaces')]"));
        utils.sendText(By.id("TCRDivertTo"),"02012345678");
        utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
        utils.clickBtn(By.id("wizardButton_SaveIncident"));
        utils.assertElementNotPresent(By.xpath("//span[contains(text(),'To may only contain numbers or spaces')]"));
        utils.waitForElementVisible(By.xpath("//a[@href='#nav-pills-tab-5'][@aria-expanded='False'][contains(text(),'No')]"));
        utils.assertElementNotPresent(By.xpath("//li[@class='active']//a[@href='#nav-pills-tab-6'][@aria-expanded='true'][contains(text(),'Yes')]"));
        utils.clickBtn(By.xpath("//a[@href='#nav-pills-tab-6'][@aria-expanded='true'][contains(text(),'Yes')]"));
        utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
        utils.clickBtn(By.id("wizardButton_SaveIncident"));
        utils.waitForElementVisible(By.xpath("//li[@class='active']//a[@href='#nav-pills-tab-6'][@aria-expanded='true'][contains(text(),'Yes')]"));
    }
    public void lineTest_Fail() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001',DPType='Internal',MainFaultLocation='EX',FaultReportAdvised='Y',LineStability='Stable',NetworkStability='Stable',StabilityStatement=' Stable - no adverse line test history',TestOutcome='Fail',DiagnosisDescription='FAULT - Line Tested OK but No Dial Tone Detected',DiagnosisCode='T073' where serviceid='02063678369'");
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'Perform a line test')]]"));
        utils.clickBtn(By.xpath("//a[text()[contains(.,'Perform a line test')]]"));
        utils.waitForElementVisible(By.xpath("//strong[contains(text(),'Fail')]"));
        utils.waitForElementVisible(By.xpath("//strong[contains(text(),'FAULT - Line Tested OK but No Dial Tone Detected')]"));
        utils.waitForElementVisible(By.xpath("//h3[contains(text(),'You are advised to report this fault')]"));
    }
    public void lineTest_Pass() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001',DPType=NULL,MainFaultLocation=NULL,FaultReportAdvised=NULL,LineStability=NULL,NetworkStability=NULL,StabilityStatement=NULL,TestOutcome=NULL,DiagnosisDescription=NULL,DiagnosisCode=NULL where serviceid='02063678369'");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'Reset / Run test again')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'Reset / Run test again')]"));
        utils.waitForElementVisible(By.xpath("//strong[contains(text(),'Pass')]"));
        utils.waitForElementVisible(By.xpath("//strong[contains(text(),'Line Test OK')]"));
        utils.waitForElementVisible(By.xpath("//h3[contains(text(),'You are NOT advised to report this fault')]"));

    }
    public void assertLineTestAbsentForISDN30andISDN2lines(){
      //  utils.assertElementNotPresent();
       // utils.assertElementNotPresent();
    }




    }









