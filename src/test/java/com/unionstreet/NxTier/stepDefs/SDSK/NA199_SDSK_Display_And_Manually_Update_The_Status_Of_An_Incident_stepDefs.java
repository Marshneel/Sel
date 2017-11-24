package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class NA199_SDSK_Display_And_Manually_Update_The_Status_Of_An_Incident_stepDefs
{
    WebModel webModel=new WebModel();
    NA166_SDSK_OpenReach_LineTest_stepDefs na166 = new NA166_SDSK_OpenReach_LineTest_stepDefs();
    @Given("^User has raised an open reach incident$")
    public void userHasRaisedAnOpenReachIncident() throws java.lang.Exception
    {

        webModel.getUtils().loadBranchURLForServiceDesk(":9090");
        webModel.getLoginPage().loginAsAdamR();
        na166.iRaiseAnOpenReachIncidentOnAnAnalogueLine();
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();

    }

    @And("^performed an action$")
    public void performedAnAction() throws java.lang.InterruptedException,SQLException
    {
        webModel.getServiceDesk_actionsPage().navigateToNewActionsPopup("Made call");
        webModel.getServiceDesk_actionsPage().assertEmailFieldAbsentOnCallActionsPopUp();
        webModel.getServiceDesk_actionsPage().assertContactDetailsOnActionsPopUp("adam.reed@unionstreet.uk.com","02012345678","Test Symptom 1","Reed, Adam");
        webModel.getServiceDesk_actionsPage().saveActionPopUp();

    }

    @Then("^should be able to validate the current status of the incident$")
    public void shouldBeAbleToValidateTheCurrentStatusOfTheIncident() throws java.lang.InterruptedException
    {
        webModel.getServiceDesk_actionsPage().assertActionsPage();
        webModel.getServiceDesk_actionsPage().assertOpenReachLoggedActionEntry();
        webModel.getServiceDesk_actionsPage().retrieveCurrentStatusOfAnIncident("Queued");

     }

    @When("^changes the current status to some other status$")
    public void changesTheCurrentStatusToSomeOtherStatus() throws InterruptedException, java.sql.SQLException
    {
        webModel.getServiceDesk_actionsPage().updateActionStatus();

    }

    @Then("^should be able to assert that a default action has been created$")
    public void shouldBeAbleToAssertThatADefaultActionHasBeenCreated()
    {
         webModel.getServiceDesk_actionsPage().assertDefaultActionCreatedOnStatusChange("Queued","Waiting");
         webModel.getServiceDesk_actionsPage().assertDefaultActionCreatedOnStatusChange("Waiting","Complete");
    }

    @And("^has raised an open reach incident$")
    public void hasRaisedAnOpenReachIncident() throws ClassNotFoundException, SQLException, InterruptedException, UnsupportedEncodingException
    {
        na166.iRaiseAnOpenReachIncidentOnAnAnalogueLine();
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();
    }
}
