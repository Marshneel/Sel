package com.unionstreet.com.unionstreet.NxTier.pages;

import com.sun.org.glassfish.gmbal.NameValue;
import com.unionstreet.support.BaseClass;
import com.unionstreet.support.ElementUtils;
import jdk.internal.dynalink.beans.StaticClass;
import org.apache.bcel.generic.ACONST_NULL;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 21/06/2017.
 */
public class ServiceDesk_CallerDetails_TriagePage {

    private final String PLEASE_SELECT_A_CONTACT_OR_SPECIFY_THAT_THE_CALLER_IS_THIRD_PARTY = "//p[contains(text(),'Please select a contact or specify that the caller is third party')]";
    private final String PLEASE_ENTER_A_CONTACT_NAME = "//span[contains(text(),'Please enter a contact name')]";
    private final String PLEASE_ENTER_EITHER_AN_EMAIL_ADDRESS_OR_A_CONTACT_TELEPHONE_NUMBER = "//span[contains(text(),'Please enter either an email address or a contact telephone number.')]";
    private final String CLICK_NEXT = "//a[contains(text(),'Next')]";
    private final String CLICK_PREVIOUS = "//a[contains(text(),'Previous')]";
    private final String CALLER_DETAILS_LABEL = "//span[contains(text(),'Caller Details')]";
    public final String SELECT_CONTACT_ON_CALLER_DETAILS_PAGE = "ContactId";
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
    private final String PRIORITY_LABEL = "//label[contains(text(),'Priority')]";
    private final String PRIORITY_DROPDOWN = "IncidentPriority";
    private final String INCIDENT_TYPE = "IncidentType";
    private final String INCIDENT_SYMPTOM = "IncidentSymptom";
    private final String INCIDENT_CATEGORY = "IncidentCategory";
    private final String INCIDENT_SUMMARY_TEXT_BOX = "IncidentSummary";
    private final String INCIDENT_OWNER = "IncidentOwner";
    private final String CONTACT_IS_THIRD_PARTY_CHECKBOX = "//label[contains(text(),'Contact is third-party')]";
    private final String CONTACT_NAME_FIELD = "ContactName";
    private final String CONTACT_EMAILID = "ContactEmailAddress";
    public WebElement ContactName;
    public WebElement Email;
    public WebElement TelephoneNumber;
    public static String NameValue;
    public static String EmailValue;
    public static String TelValue;


    ElementUtils utils = new ElementUtils();

    public void correspondenceDetailsValidations() {
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_A_CONTACT_OR_SPECIFY_THAT_THE_CALLER_IS_THIRD_PARTY));
        utils.waitForElementVisible(By.xpath(PLEASE_ENTER_A_CONTACT_NAME));
       // utils.waitForElementVisible(By.xpath(PLEASE_ENTER_EITHER_AN_EMAIL_ADDRESS_OR_A_CONTACT_TELEPHONE_NUMBER));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please enter a contact telephone number')]"));
    }

    public void clickNext()  {
      try{ utils.waitForElementVisible(By.xpath(CLICK_NEXT));
        Thread.sleep(1000);
        utils.scrollUp(By.xpath(CLICK_NEXT));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(CLICK_NEXT));
    }catch (Exception e){}}

    public void clickPrevious() throws InterruptedException {
        utils.clickBtn(By.xpath(CLICK_PREVIOUS));
    }

    public void clickNextWithOutPopulatingCallerDetailsTab() {
        utils.waitForElementVisible(By.xpath(CALLER_DETAILS_LABEL));
        clickNext();
        correspondenceDetailsValidations();
    }

    public void clickNextAfterPopulatingContact() {
        utils.waitForElementVisible(By.id(SELECT_CONTACT_ON_CALLER_DETAILS_PAGE));
        utils.selectByVisibleText(By.id(SELECT_CONTACT_ON_CALLER_DETAILS_PAGE), "Adam Reed (adam.reed@unionstreet.uk.com)");
        utils.waitForElementVisible(By.id(EMAIL_ADDRESS_ON_CALLER_DETAILS_PAGE));
        utils.sendText(By.id(EMAIL_ADDRESS_ON_CALLER_DETAILS_PAGE), "adam.reed@unionstreet.uk.com");
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please enter a contact telephone number')]"));
        utils.sendText(By.id("ContactTelephoneNumber"),"02012345678");
        clickNext();
        utils.waitForElementVisible(By.xpath(TRAIAGE_PAGE_HEADER_TEXT));
    }
    public void ValidateContactTelephoneNumberOnIncidentContactInformationModal()
    {
        utils.sendText(By.id("ContactTelephoneNumber"),"abcdefgh");
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'The telephone number must be made up of numeric characters only')]"));
        utils.sendText(By.id("ContactTelephoneNumber"),"020123");
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'The telephone number should be between 7 and 11 characters')]"));
    }
    public void populateContactIsThirdPartyOnIncidentContactInformationModal()
    {
        utils.waitForElementVisible(By.xpath(CONTACT_IS_THIRD_PARTY_CHECKBOX));
        utils.clickBtn(By.xpath(CONTACT_IS_THIRD_PARTY_CHECKBOX));
        ValidateContactTelephoneNumberOnIncidentContactInformationModal();
        utils.sendText(By.id(CONTACT_NAME_FIELD), "Adam R");
        ContactName= BaseClass.driver.findElement(By.id(CONTACT_NAME_FIELD));
        NameValue = ContactName.getAttribute("value");
        utils.sendText(By.id(CONTACT_EMAILID), "adam.reed@union.uk.com");
        Email = BaseClass.driver.findElement(By.id(CONTACT_EMAILID));
        EmailValue = Email.getAttribute("value");
        ValidateContactTelephoneNumberOnIncidentContactInformationModal();
        utils.sendText(By.id("ContactTelephoneNumber"),"56489237");
        TelephoneNumber = BaseClass.driver.findElement(By.id("ContactTelephoneNumber"));
        TelValue = TelephoneNumber.getAttribute("value");
    }

    public void assertPresenceOfPriorityComponent() throws InterruptedException
    {
        utils.waitForElementVisible(By.xpath(PRIORITY_LABEL));
        Thread.sleep(5000);
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
        //utils.waitForElementVisible(By.xpath(PLEASE_SELECT_AN_INCIDENT_CATEGORY));
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_AN_OWNER_FOR_INCIDENT));
    }

    public void clickNextWithOutPopulatingTriage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(TRAIAGE_PAGE_HEADER_TEXT));
        utils.waitForElementVisible(By.id(INCIDENT_OWNER));
        utils.selectByVisibleText(By.id(INCIDENT_OWNER), "Select...");
    utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
        utils.clickBtn(By.id("wizardButton_SaveIncident"));
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_AN_INCIDENT_TYPE));
        validationMessagesOnnTriagePage();
    }

//    public void openReachIncident_Triage(Boolean nextOrNot) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
//        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set cli_type='1', openreach_function='1' where RecordID='4'");
//        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_symptoms set Symptom='Test Symptom 1', tmp_IncidentType='Test Type Fault 1' where RecordID='33'");
//        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_categories set category='Test Category 1',tmp_IncidentType='Test Type Fault 1' where RecordID='11'");
//        utils.waitForElementVisible(By.id(INCIDENT_TYPE));
//        utils.selectByVisibleText(By.id(INCIDENT_TYPE), "Test Type Fault 1");
//        utils.waitForElementVisible(By.id(INCIDENT_OWNER));
//        utils.selectByVisibleText(By.id(INCIDENT_OWNER), "Select...");
//        clickNext();
//        validationMessagesOnnTriagePage();
//        clickNext();
//        utils.waitForElementVisible(By.xpath(PLEASE_ENTER_A_SUMMARY_FOR_INCIDENT));
//        populateSymptomAndCategory("Test Symptom 1", "Test Category 1");
//        utils.waitForElementVisible(By.id(INCIDENT_SUMMARY_TEXT_BOX));
//        utils.sendText(By.id(INCIDENT_SUMMARY_TEXT_BOX), "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
//        utils.waitForElementVisible(By.xpath(THE_SUMMARY_CAN_BE_NO_MORE_THAN_80_CHARACTERS));
//        populateSummaryAndOwnerDropDown();
//        clickNext();
//        utils.waitForElementVisible(By.xpath("//a[@href='#tab3'][@aria-expanded='true']"));
//        if (nextOrNot == true)
//            clickPrevious();
//    }
public void openReachIncident_Triage(Boolean nextOrNot,boolean prioritylevel,boolean agent) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set cli_type='1', openreach_function='1' where RecordID='4'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_symptoms set Symptom='Test Symptom 1', tmp_IncidentType='Test Type Fault 1' where RecordID='33'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_categories set category='Test Category 1',tmp_IncidentType='Test Type Fault 1' where RecordID='11'");
        utils.waitForElementVisible(By.id(INCIDENT_TYPE));
        utils.selectByVisibleText(By.id(INCIDENT_TYPE), "Test Type Fault 1");
        utils.waitForElementVisible(By.id(INCIDENT_OWNER));
        utils.selectByVisibleText(By.id(INCIDENT_OWNER), "Select...");
        clickNext();
        validationMessagesOnnTriagePage();
        //clickNext();
        utils.waitForElementVisible(By.xpath(PLEASE_ENTER_A_SUMMARY_FOR_INCIDENT));
        populateSymptomAndCategory("Test Symptom 1", "Test Category 1");
        utils.waitForElementVisible(By.id(INCIDENT_SUMMARY_TEXT_BOX));
        utils.sendText(By.id(INCIDENT_SUMMARY_TEXT_BOX), "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        utils.waitForElementVisible(By.xpath(THE_SUMMARY_CAN_BE_NO_MORE_THAN_80_CHARACTERS));
        populateSummaryAndOwnerDropDown();
        if(agent)
        {
            utils.waitForElementVisible(By.xpath("//p[contains(text(),'The Owner you have selected is missing required contact information. Please complete this information or select a different Owner to continue.')]"));
            utils.selectByVisibleText(By.id(INCIDENT_OWNER), "Jeanette Staton");
        }
        if(prioritylevel)
        {
            utils.waitForElementVisible(By.xpath(PLEASE_ENTER_A_PRIORITY_LEVEL));
            utils.selectByIndex(By.id(PRIORITY_DROPDOWN), 2);
        }
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
        utils.sendText(By.id(INCIDENT_SUMMARY_TEXT_BOX), "summary");
       utils.waitForElementVisible(By.id(INCIDENT_OWNER));
        utils.selectByVisibleText(By.id(INCIDENT_OWNER), "Adam Reed");
            }
    public int getNonOpenReachIncidentID() throws SQLException {
        utils.sqlQuery("Portal", "moe\\devsql2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "SELECT TOP 1 RecordID FROM incidents ORDER BY RecordID DESC");
        utils.result.next();
        String createdID = utils.result.getString("RecordID");
       int createdID_int=Integer.parseInt(createdID);

        return createdID_int;
    }
    public int getIncidentID() throws SQLException {
        utils.sqlQuery("Portal", "moe\\devsql2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "SELECT TOP 1 RecordID FROM incidents ORDER BY RecordID DESC");
        utils.result.next();
        String createdID = utils.result.getString("RecordID");
        int createdID_int=Integer.parseInt(createdID);

        return createdID_int;
    }



    public void non_OpenReachIncident_Triage() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set cli_type='1', openreach_function='4' where RecordID='6'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_symptoms set Symptom='Test Symptom 3', tmp_IncidentType='Test Type Fault 3' where RecordID='35'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_categories set category='Test Category 3',tmp_IncidentType='Test Type Fault 3' where RecordID='13'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='1' where ID='156'");

        utils.waitForElementVisible(By.id(INCIDENT_TYPE));
        utils.selectByVisibleText(By.id(INCIDENT_TYPE), "Test Type Fault 3");
        utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
        Thread.sleep(1000);
        utils.scrollUp(By.id("wizardButton_SaveIncident"));
        Thread.sleep(1000);
        utils.clickBtn(By.id("wizardButton_SaveIncident"));
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_AN_APPROPRIATE_SYMPTOM_FOR_THE_INCIDENT));
        utils.waitForElementVisible(By.xpath(PLEASE_SELECT_AN_INCIDENT_CATEGORY));
        populateSymptomAndCategory("Test Symptom 3", "Test Category 3");
        utils.waitForElementVisible(By.id(INCIDENT_SUMMARY_TEXT_BOX));
        utils.sendText(By.id(INCIDENT_SUMMARY_TEXT_BOX), "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
        utils.clickBtn(By.id("wizardButton_SaveIncident"));
        utils.waitForElementVisible(By.xpath(THE_SUMMARY_MUST_HAVE_NO_MORE_THAN_256_WORDS));
        populateSummaryAndOwnerDropDown();
            utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
            utils.clickBtn(By.id("wizardButton_SaveIncident"));
        utils.waitForElementVisible(By.xpath("//h1[contains(text(),'Incident #"+getNonOpenReachIncidentID()+"')]"));
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='1' where ID='150'");
        //utils.navigateBack();
        //clickPrevious();

    }

    public void choosePriorityOverCategory() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.waitForElementVisible(By.id(INCIDENT_TYPE));
        utils.selectByVisibleText(By.id(INCIDENT_TYPE), "Test Type Fault 3");
        utils.waitForElementVisible(By.id(INCIDENT_SYMPTOM));
        utils.selectByVisibleText(By.id(INCIDENT_SYMPTOM), "Test Symptom 2");
        populateSummaryAndOwnerDropDown();
        utils.waitForElementVisible(By.xpath(PRIORITY_LABEL));
        utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
        //Thread.sleep(1000);
        utils.scrollUp(By.id("wizardButton_SaveIncident"));
        //Thread.sleep(1000);
        utils.clickBtn(By.id("wizardButton_SaveIncident"));
        utils.waitForElementVisible(By.xpath(PLEASE_ENTER_A_PRIORITY_LEVEL));
        utils.selectByIndex(By.id(PRIORITY_DROPDOWN), 1);
      //utils.waitForElementVisible(By.id("wizardButton_SaveIncident"));
        utils.clickBtn(By.id("wizardButton_SaveIncident"));
        Thread.sleep(1000);

        //utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='0' where ID='150'");
    }
}