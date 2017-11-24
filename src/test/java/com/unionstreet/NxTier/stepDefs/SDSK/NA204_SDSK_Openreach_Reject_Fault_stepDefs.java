package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class NA204_SDSK_Openreach_Reject_Fault_stepDefs
{
    WebModel webModel=new WebModel();
    NA166_SDSK_OpenReach_LineTest_stepDefs na166 = new NA166_SDSK_OpenReach_LineTest_stepDefs();
    NA160_SDSK_Login_Incident__Triage_stepDefs na160 = new NA160_SDSK_Login_Incident__Triage_stepDefs();

    @Given("^i raise an openreach incident for Analogue LineType$")
    public void iRaiseAnOpenreachIncidentForAnalogueLineType() throws InterruptedException,ClassNotFoundException,SQLException,UnsupportedEncodingException
    {
        webModel.getUtils().loadBranchURLForServiceDesk(":9090");
        webModel.getLoginPage().loginAsAdamR();
        na166.iRaiseAnOpenReachIncidentOnAnAnalogueLine();
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();
    }

    @When("^clicking on reject option from the Options dropdown$")
    public void clickingOnRejectOptionFromTheOptionsDropdown()
    {
        webModel.getUtils().clickBtn(By.xpath("//a[contains(text(),'OPTIONS')]"));
        webModel.getUtils().clickBtn(By.id("modal_ServiceDesk_EditIncident_OpenreachRejectIncidentDigital"));
    }

    @Then("^Should be able to see a modal with dropdown field populated with reasons and Notes section$")
    public void shouldBeAbleToSeeAModalWithDropdownFieldPopulatedWithReasonsAndNotesSection()
    {

        webModel.getServiceDesk_actionsPage().RejectFaultOptionPopup();

    }

    @And("^should update the status description in the openreach fault details panel$")
    public void shouldUpdateTheStatusDescriptionInTheOpenreachFaultDetailsPanel()
    {
         webModel.getUtils().waitForElementVisible(By.xpath("//h4[contains(text(),'Openreach fault details')]"));
         webModel.getUtils().searchAndAssertTextPresent(By.xpath("//div[contains(text(),'Fault Rejected sent to openreach')]"),"Fault Rejected sent to openreach");
        // write code for default action created
    }

    @Given("^i raise an openreach incident for Digital LineType$")
    public void iRaiseAnOpenreachIncidentForDigitalLineType() throws InterruptedException,ClassNotFoundException,SQLException,UnsupportedEncodingException
    {

        webModel.getUtils().loadBranchURLForServiceDesk(":9090");
        webModel.getLoginPage().loginAsAdamR();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set CareLevel='2' where serviceid='OI3000000001'");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false,false,false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(true,"01202300945","WLR3 ISDN 30 ETSI","8","2",true,"LU1 1DQ");
    }
}
