package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NA196_SDSK_OpenReach_Access_Availability_stepDefs
{
    WebModel webModel=new WebModel();
    NA160_SDSK_Login_Incident__Triage_stepDefs na160=new NA160_SDSK_Login_Incident__Triage_stepDefs();

    @When("^I raise an Openreach Incident with the linetype ISDN(\\d+)E$")
    public void iRaiseAnOpenreachIncidentWithTheLinetypeISDNE(int arg0) throws java.lang.Exception
    {
        webModel.getDashBoardPage().switchGateway("10.1.9.112");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false,false,false);
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(false,"01202300945", "WLR3 ISDN 30 ETSI", "2", "4", true,"LU1 1DQ");

    }


    @Then("^I should be able to see the validations related to Access Availability upon saving the Incident$")
    public void iShouldBeAbleToSeeTheValidationsRelatedToAccessAvailabilityUponSavingTheIncident() throws InterruptedException
    {
        webModel.getServiceDesk_ticketDetailsPage().assertAccessAvailabilityForISDN30E();
        webModel.getServiceDesk_ticketDetailsPage().SelectDateTimeForSiteInformation();
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();
        webModel.getServiceDesk_actionsPage().assertIncidentViewAndAmendDetails();
    }
}
