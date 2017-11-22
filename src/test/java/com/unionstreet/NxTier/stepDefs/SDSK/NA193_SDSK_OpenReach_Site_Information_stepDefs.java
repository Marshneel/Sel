package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.text.ParseException;

public class NA193_SDSK_OpenReach_Site_Information_stepDefs {

  WebModel webModel=new WebModel();
  NA160_SDSK_Login_Incident__Triage_stepDefs na160=new NA160_SDSK_Login_Incident__Triage_stepDefs();


    @Then("^I should not be able to see Access Details and Hazard Notes for virtual lines$")
    public void iShouldNotBeAbleToSeeAccessDetailsAndHazardNotesForVirtualLines()
    {
        webModel.getServiceDesk_ticketDetailsPage().assertAbsenceOfAccessDetailsAndHazardNotes();
    }


    @When("^I access site information  and save it$")
    public void iAccessSiteInformationAndSaveIt() throws InterruptedException,ParseException
    {
         webModel.getServiceDesk_ticketDetailsPage().AccessSiteInformation(false,false,true);
         webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();
    }

    @Then("^I should be able to see Incident View and Amend Details Page$")
    public void iShouldBeAbleToSeeIncidentViewAndAmendDetailsPage() throws InterruptedException,java.lang.Exception
    {
        webModel.getServiceDesk_actionsPage().assertIncidentViewAndAmendDetails();

    }

    @And("^I navigate to service desk page to raise an openreach incident with Analogue linetype$")
    public void iNavigateToServiceDeskPageToRaiseAnOpenreachIncidentWithAnalogueLinetype() throws java.lang.Exception
    {
        webModel.getDashBoardPage().switchGateway("10.1.9.112");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false,false,false);
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(false,"02063678369", "PSTN Single Line", "1", "3", true,"LU1 1DQ");

    }

    @And("^I navigate to service desk page to raise an openreach incident with ISDN(\\d+) linetype$")
    public void iNavigateToServiceDeskPageToRaiseAnOpenreachIncidentWithISDNLinetype(int arg0) throws java.lang.Exception
    {
        webModel.getDashBoardPage().switchGateway("10.1.9.112");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false,false,false);
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(false,"01202300920", "WLR3 ISDN 2e System", "2", "4", true,"LU1 1DQ");
    }

    @And("^I navigate to service desk page to raise an openreach incident with ISDN(\\d+) linetypes$")
    public void iNavigateToServiceDeskPageToRaiseAnOpenreachIncidentWithISDNLinetypes(int arg0) throws java.lang.Exception
    {
        webModel.getDashBoardPage().switchGateway("10.1.9.112");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false,false,false);
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(false,"01202300945", "WLR3 ISDN 30 ETSI", "2", "4", true,"LU1 1DQ");
    }

    @When("^I access site information for ISDN(\\d+) linetype  and save it$")
    public void iAccessSiteInformationForISDNLinetypeAndSaveIt(int arg0) throws java.lang.Exception
    {
        webModel.getServiceDesk_ticketDetailsPage().AccessSiteInformation(true,false,false);
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();

    }



    @When("^I access site information for ISDN(\\d+) linetypes and save it$")
    public void iAccessSiteInformationForISDNLinetypesAndSaveIt(int arg0) throws java.lang.Exception
    {
        webModel.getServiceDesk_ticketDetailsPage().AccessSiteInformation(false,true,false);
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();
    }

    @When("^I navigate to service desk page to raise an openreach incident with virtual linetype$")
    public void iNavigateToServiceDeskPageToRaiseAnOpenreachIncidentWithVirtualLinetype() throws java.lang.Exception
    {
        webModel.getDashBoardPage().switchGateway("10.1.9.112");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false,false,false);
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(false,"01202300912", "WLR RCF", "0", "0", false,"LU1 1DQ");

    }
}
