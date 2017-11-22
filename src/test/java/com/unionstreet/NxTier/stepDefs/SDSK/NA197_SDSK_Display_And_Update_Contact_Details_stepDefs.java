package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NA197_SDSK_Display_And_Update_Contact_Details_stepDefs
{
    WebModel webModel=new WebModel();
    NA160_SDSK_Login_Incident__Triage_stepDefs na160=new NA160_SDSK_Login_Incident__Triage_stepDefs();
    @And("^I submit an OpenReach Incident for Analogue Line$")
    public void iSubmitAnOpenReachIncidentForAnalogueLine() throws java.lang.Exception
    {
        webModel.getDashBoardPage().switchGateway("10.1.9.112");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false,false,false);
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(false,"02063678369", "PSTN Single Line", "1", "3", true,"LU1 1DQ");
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();
    }

    @When("^I am on View And Amend Details Page upon editing it$")
    public void iAmOnViewAndAmendDetailsPageUponEditingIt() throws InterruptedException
    {
       webModel.getServiceDesk_actionsPage().assertIncidentViewAndAmendDetails();
       webModel.getServiceDesk_actionsPage().ClickViewAndAmendDetailsEditIcon();


    }

    @Then("^I should be able to validate the fields$")
    public void iShouldBeAbleToValidateTheFields()
    {
        webModel.getServiceDesk_actionsPage().validateFieldsOnIncidentContactInformationModalForSelectContactDropdown();
        webModel.getServiceDesk_callerDetailsTriagePage().populateContactIsThirdPartyOnIncidentContactInformationModal();

    }

    @And("^I should be able to assert those saved changes in the Incident Contact Information component$")
    public void iShouldBeAbleToAssertThoseSavedChangesInTheIncidentContactInformationComponent() throws InterruptedException
    {
        webModel.getServiceDesk_actionsPage().ClickSaveBtnOnIncidentContactInformationModal();
        webModel.getServiceDesk_actionsPage().assertContactDetailsOnIncidentContactInformationModal();
    }
}
