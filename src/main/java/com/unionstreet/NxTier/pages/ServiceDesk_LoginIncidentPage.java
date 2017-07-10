package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import static com.unionstreet.NxTier.support.BaseClass.driver;

/**
 * Created by RajeshG on 21/06/2017.
 */
public class ServiceDesk_LoginIncidentPage {

    private final String PLEASE_SELECT_A_CONTACT_OR_SPECIFY_THAT_THE_CALLER_IS_THIRD_PARTY="//p[contains(text(),'Please select a contact or specify that the caller is third party')]";
    private final String PLEASE_ENTER_A_CONTACT_NAME="//span[contains(text(),'Please enter a contact name')]";
    private final String PLEASE_ENTER_EITHER_AN_EMAIL_ADDRESS_OR_A_CONTACT_TELEPHONE_NUMBER="//span[contains(text(),'Please enter either an email address or a contact telephone number.')]";
    private final String CLICK_NEXT="//a[contains(text(),'Next')]";
    private final String CLICK_PREVIOUS="//a[contains(text(),'Previous')]";
    private final String TEXT_ON_CALLER_DETAILS="//span[contains(text(),'Caller Details')]";
    private final String SELECT_CONTACT_ON_CALLER_DETAILS_PAGE="ContactId";
    private final String PLEASE_ENTER_A_PRIORITY_LEVEL="//span[contains(text(),'Please enter a Priority level for this Incident')]";
    private final String EMAIL_ADDRESS_ON_CALLER_DETAILS_PAGE="ContactEmailAddress";
    private final String TRAIAGE_PAGE_HEADER_TEXT="//span[contains(text(),'Triage')]";
    private final String PLEASE_SELECT_AN_APPROPRIATE_SYMPTOM_FOR_THE_INCIDENT="//span[contains(text(),'Please select an appropriate Symptom for this Incident')]";
    private final String PLEASE_SELECT_AN_INCIDENT_CATEGORY="//span[contains(text(),'Please select an Incident Category')]";
    private final String PLEASE_SELECT_AN_OWNER_FOR_INCIDENT="//span[contains(text(),'Please select the Owner of this Incident')]";
    private final String PLEASE_SELECT_AN_INCIDENT_TYPE="//span[contains(text(),'Please select an Incident Type')]";
    private final String THE_SUMMARY_MUST_HAVE_NO_MORE_THAN_256_WORDS="//span[contains(text(),'The Summary must be no more than 256 characters')]";
    private final String THE_SUMMARY_CAN_BE_NO_MORE_THAN_80_CHARACTERS="//span[contains(text(),'The Summary must be no more than 80 characters')]";
    private final String PLEASE_ENTER_A_SUMMARY_FOR_INCIDENT="//span[contains(text(),'Please enter a brief Summary for this Incident')]";
    private final String EDIT_AN_INCIDENT="//h1[contains(text(),'Edit an incident')]";
    private final String PRIORITY_TEXT="//label[contains(text(),'Priority')]";
    private final String PRIORITY_DROPDOWN="IncidentPriority";
    private final String INCIDENT_TYPE="IncidentType";
    private final String INCIDENT_SYMPTOM="IncidentSymptom";
    private final String INCIDENT_CATEGORY="IncidentCategory";
    private final String INCIDENT_SUMMARY="IncidentSummary";
    private final String INCIDENT_OWNER="IncidentOwner";
    private final String CONTACT_IS_THIRD_PARTY_CHECKBOX="//label[contains(text(),'Contact is third-party')]";
    private final String CONTACT_NAME_FIELD="ContactName";
    private final String CONTACT_EMAILID="ContactEmailAddress";
    private final String SELECT_CLI_FIELD_IS_REQUIRED="//span[contains(text(),'The Select CLI field is required.')]";
    private final String THE_CONFIRM_POST_CODE_IS_REQUIRED="//span[contains(text(),'The Confirm Postcode field is required.')]";
    private final String TEXT_ON_LINE_AND_INSTALLATION_DETAILS_PAGE="//legend[contains(text(),'Line and installation details')]";
    private final String OBTAIN_ORDER_DETAILS="obtainOrderDetails";
    private final String SELECT_CLI_DROPDOWN="//input[@id='CLI']/following-sibling::a";
    private final String OPEN_REACH_SPINNER="//span[@class='spinner']";
    private final String SEARCH_BOX_FOR_CLI="//input[@type='search']";
    private final String SELECT_CLI_BUTTON="//button[contains(text(),'Select')]";
    private final String CPS_PRESENT_RESULT="//div[@id='installationDetailsContainer']/div/h4/following-sibling::div/div[4]/div/label/strong/label";
    private final String CALLING_AND_NETWORK_FEATURES="//div[@id='installationDetailsContainer']/div/h4/following-sibling::div/div[5]/div/label/strong/label";



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
       if(nextOrNot==true)
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
    public void assertTextOnTicketDetailsPage(){
        utils.waitForElementVisible(By.xpath(TEXT_ON_LINE_AND_INSTALLATION_DETAILS_PAGE));

    }
    public void clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode(){
        utils.clickBtn(By.id(OBTAIN_ORDER_DETAILS));
        utils.waitForElementVisible(By.xpath(SELECT_CLI_FIELD_IS_REQUIRED));
        utils.waitForElementVisible(By.xpath(THE_CONFIRM_POST_CODE_IS_REQUIRED));
    }
    public void selectCLIToObtainInstallationDetails(String cli, String lineType, String numberOfLines, String maintenanceLevel ) throws InterruptedException {
        utils.clickBtn(By.xpath(SELECT_CLI_DROPDOWN));
        utils.waitForElementToVanish(By.xpath(OPEN_REACH_SPINNER));
        utils.waitForElementVisible(By.xpath(SEARCH_BOX_FOR_CLI));
        utils.sendText(By.xpath(SEARCH_BOX_FOR_CLI),""+cli+"");
       Thread.sleep(1000);
        utils.clickBtn(By.xpath(SELECT_CLI_BUTTON));
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Installation Details for "+cli+"')]"));
        utils.waitForElementVisible(By.xpath("//strong[contains(text(),'"+lineType+"')]"));
        utils.waitForElementVisible(By.xpath("//strong[contains(text(),'"+numberOfLines+"')]"));
        utils.waitForElementVisible(By.xpath("//strong[contains(text(),'"+maintenanceLevel+"')]"));
        utils.waitForElementVisibleForOpenReach(By.xpath(CPS_PRESENT_RESULT));
        String valueForCPS=driver.findElement(By.xpath(CPS_PRESENT_RESULT)).getText();
        String valueForCalAndNetwrkFeatures=driver.findElement(By.xpath(CALLING_AND_NETWORK_FEATURES)).getText();
        utils.twoValueArrayList("Yes","No");
        Assert.assertTrue(utils.allValues.contains(valueForCPS));
        Assert.assertTrue(utils.allValues.contains(valueForCalAndNetwrkFeatures));





    }

}

