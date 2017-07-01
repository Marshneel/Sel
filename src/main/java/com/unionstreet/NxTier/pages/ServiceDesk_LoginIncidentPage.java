package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 21/06/2017.
 */
public class ServiceDesk_LoginIncidentPage {

    ElementUtils utils = new ElementUtils();

    public void correspondenceDetailsValidations() {
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'Please select a contact or specify that the caller is third party')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please enter a contact name')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please enter either an email address or a contact telephone number.')]"));
    }

    public void clickNext() {
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'Next')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'Next')]"));
    }

    public void clickPrevious() {
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'Previous')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'Previous')]"));
    }

    public void clickNextWithOutPopulatingCallerDetailsTab() {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Caller Details')]"));
        clickNext();
        correspondenceDetailsValidations();
    }

    public void clickNextAfterPopulatingContact() {
        utils.waitForElementVisible(By.id("ContactId"));
        utils.selectByVisibleText(By.id("ContactId"), "Adam Reed (adam.reed@unionstreet.uk.com)");
        utils.waitForElementVisible(By.id("ContactEmailAddress"));
        utils.sendText(By.id("ContactEmailAddress"), "adam.reed@unionstreet.uk.com");
        clickNext();
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Triage')]"));
    }

    public void populateThirdParty() {
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Contact is third-party')]"));
        utils.clickBtn(By.xpath("//label[contains(text(),'Contact is third-party')]"));
        correspondenceDetailsValidations();
        utils.sendText(By.id("ContactName"), "Adam Reed");
        utils.waitForElementVisible(By.id("ContactEmailAddress"));
        utils.sendText(By.id("ContactEmailAddress"), "adam.reed@unionstreet.uk.com");
        clickNext();
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Triage')]"));
    }

    public void validationMessagesOnnTriagePage() {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please select an appropriate Symptom for this Incident')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please select an Incident Category')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please select the Owner of this Incident')]"));
    }

    public void clickNextWithOutPopulatingTriage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Triage')]"));
        clickNext();
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please select an Incident Type')]"));
        validationMessagesOnnTriagePage();
    }

    public void openReachIncident_Triage() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "SN_aBILLity_Portal", "update incident_types set cli_type='1', openreach_function='1' where RecordID='4'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "SN_aBILLity_Portal", "update incident_symptoms set Symptom='Test Symptom 1', tmp_IncidentType='Test Type Fault 1' where RecordID='33'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "SN_aBILLity_Portal", "update incident_categories set category='Test Category 1',tmp_IncidentType='Test Type Fault 1' where RecordID='11'");
        utils.waitForElementVisible(By.id("IncidentType"));
        utils.selectByVisibleText(By.id("IncidentType"), "Test Type Fault 1");
        clickNext();
        validationMessagesOnnTriagePage();
        clickNext();
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please enter a Summary for this Incident')]"));
        populateSymptomAndCategory("Test Symptom 1", "Test Category 1");
        utils.waitForElementVisible(By.id("IncidentSummary"));
        utils.sendText(By.id("IncidentSummary"), "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'The Summary must be no more than 80 characters')]"));
        populateSummaryAndOwnerDropDown();
        clickNext();
        utils.waitForElementVisible(By.xpath("//a[@href='#tab3'][@aria-expanded='true']"));
        clickPrevious();
    }

    public void populateSymptomAndCategory(String symptom, String category) {
        utils.waitForElementVisible(By.id("IncidentSymptom"));
        utils.selectByVisibleText(By.id("IncidentSymptom"), symptom);
        utils.waitForElementVisible(By.id("IncidentCategory"));
        utils.selectByVisibleText(By.id("IncidentCategory"), category);
    }

    public void populateSummaryAndOwnerDropDown() {
        utils.sendText(By.id("IncidentSummary"), "summary");
        utils.waitForElementVisible(By.id("IncidentOwner"));
        utils.selectByVisibleText(By.id("IncidentOwner"), "Alex");

    }

    public void non_OpenReachIncident_Triage() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "SN_aBILLity_Portal", "update incident_types set cli_type='1', openreach_function='4' where RecordID='6'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "SN_aBILLity_Portal", "update incident_symptoms set Symptom='Test Symptom 3', tmp_IncidentType='Test Type Fault 3' where RecordID='35'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "SN_aBILLity_Portal", "update incident_categories set category='Test Category 3',tmp_IncidentType='Test Type Fault 3' where RecordID='13'");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "SN_aBILLity_Portal", "update Defaultvalues set ValueNumber='1' where ID='156'");

        utils.waitForElementVisible(By.id("IncidentType"));
        utils.selectByVisibleText(By.id("IncidentType"), "Test Type Fault 3");
        clickNext();
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please select an appropriate Symptom for this Incident')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please select an Incident Category')]"));
        populateSymptomAndCategory("Test Symptom 3", "Test Category 3");
        utils.waitForElementVisible(By.id("IncidentSummary"));
        utils.sendText(By.id("IncidentSummary"), "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm" +
                "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        clickNext();
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'The Summary must be no more than 256 characters')]"));
        populateSummaryAndOwnerDropDown();
        try {
            clickNext();
        } catch (Exception e) {
            clickNext();
        }
        utils.waitForElementVisible(By.xpath("//h1[contains(text(),'Edit an incident')]"));
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "SN_aBILLity_Portal", "update Defaultvalues set ValueNumber='1' where ID='150'");
       utils.navigateBack();
        //clickPrevious();

    }

    public void choosePriorityOverCategory() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.waitForElementVisible(By.id("IncidentType"));
        utils.selectByVisibleText(By.id("IncidentType"), "Test Type Fault 3");
        utils.waitForElementVisible(By.id("IncidentSymptom"));
        utils.selectByVisibleText(By.id("IncidentSymptom"), "Test Symptom 2");
        populateSummaryAndOwnerDropDown();
        utils.waitForElementVisible(By.xpath("//label[contains(text(),'Priority')]"));
        clickNext();
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Please enter a Priority level for this Incident')]"));
        utils.selectByIndex(By.id("IncidentPriority"), 1);
        clickNext();
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "SN_aBILLity_Portal", "update Defaultvalues set ValueNumber='0' where ID='150'");
    }
}

