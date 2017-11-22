package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


public class NA203_SDSK_Update_Incident_Owner_stepDefs
{
    WebModel webModel=new WebModel();
    NA160_SDSK_Login_Incident__Triage_stepDefs na160 = new NA160_SDSK_Login_Incident__Triage_stepDefs();
    @When("^I click on the owner dropdown$")
    public void iClickOnTheOwnerDropdown() throws InterruptedException
    {
        webModel.getServiceDesk_actionsPage().clickOnOwnerDropDown();
    }

    @Then("^I should be able to validate the list of contacts under cp$")
    public void iShouldBeAbleToValidateTheListOfContactsUnderCp()
    {

       webModel.getServiceDesk_actionsPage().printOwnerDropDownList();
    }

    @And("^on changing the owner to some other owner$")
    public void onChangingTheOwnerToSomeOtherOwner() throws InterruptedException
    {
        webModel.getServiceDesk_actionsPage().ChangeOwner("Alper Kazaca");
        webModel.getServiceDesk_actionsPage().ConfirmationModalPopup();
        webModel.getServiceDesk_actionsPage().clickOnOwnerDropDown();
        webModel.getServiceDesk_actionsPage().ChangeOwner("ACME Rockets");
        webModel.getServiceDesk_actionsPage().ConfirmationModalPopup();

    }

    @Then("^I should be able to see that a new default action has been created on Changing the Owner$")
    public void iShouldBeAbleToSeeThatANewDefaultActionHasBeenCreatedOnChangingTheOwner()
    {
        webModel.getServiceDesk_actionsPage().assertDefaultActionCreatedOnOwnerChange("Adam Reed","Alper Kazaca");
        webModel.getServiceDesk_actionsPage().assertDefaultActionCreatedOnOwnerChange("Alper Kazaca","ACME Rockets");

    }

    @Then("^I should be able to validate the list of contacts under agent$")
    public void iShouldBeAbleToValidateTheListOfContactsUnderAgent()
    {
        webModel.getServiceDesk_actionsPage().printOwnerDropDownList();


    }

    @Then("^I should be able to validate the list of contacts under reseller$")
    public void iShouldBeAbleToValidateTheListOfContactsUnderReseller()
    {

        webModel.getServiceDesk_actionsPage().printOwnerDropDownList();

    }

    @And("^raised an open reach incident$")
    public void raisedAnOpenReachIncident() throws java.lang.Exception
    {
        //webModel.getDashBoardPage().switchGateway("10.1.9.112");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false,false,true);
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(false,"02063678369", "PSTN Single Line", "1", "3", true,"LU1 1DQ");
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();
    }

    @Given("^I am logged in as agentAdam$")
    public void iAmLoggedInAsAgentAdam() throws InterruptedException
    {
        webModel.getUtils().loadBranchURLForServiceDesk("");
        webModel.getLoginPage().loginAsAgentAdam();

    }

    @And("^on changing the owner to some other owner for agent$")
    public void onChangingTheOwnerToSomeOtherOwnerForAgent() throws InterruptedException
    {

        webModel.getServiceDesk_actionsPage().ChangeOwner("Peter Pan");
        webModel.getServiceDesk_actionsPage().assertNotificationModalPopUp();
        webModel.getServiceDesk_actionsPage().clickOnOwnerDropDown();
        webModel.getServiceDesk_actionsPage().ChangeOwner("Site1 Testing");
        webModel.getServiceDesk_actionsPage().ConfirmationModalPopup();

    }

    @Then("^I should be able to see that a new default action has been created on Changing the Owner for Agent$")
    public void iShouldBeAbleToSeeThatANewDefaultActionHasBeenCreatedOnChangingTheOwnerForAgent()
    {
       webModel.getServiceDesk_actionsPage().assertDefaultActionCreatedOnOwnerChange("Jeanette Staton","Site1 Testing");
    }

    @And("^raised an open reach incident for cp$")
    public void raisedAnOpenReachIncidentForCp() throws java.lang.Exception
    {
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false,false,false);
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(false,"02063678369", "PSTN Single Line", "1", "3", true,"LU1 1DQ");
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();
    }


    @Given("^I am logged in as adamreseller$")
    public void iAmLoggedInAsAdamreseller() throws InterruptedException
    {
        webModel.getUtils().loadBranchURLForServiceDesk("");
        webModel.getLoginPage().loginAsAdamReseller();
    }

    @And("^on changing the owner to some other owner for reseller$")
    public void onChangingTheOwnerToSomeOtherOwnerForReseller() throws InterruptedException
    {
        webModel.getServiceDesk_actionsPage().ChangeOwner("Peter Pan");
        webModel.getServiceDesk_actionsPage().assertNotificationModalPopUp();
        webModel.getServiceDesk_actionsPage().clickOnOwnerDropDown();
        webModel.getServiceDesk_actionsPage().ChangeOwner("Site1 Testing");
        webModel.getServiceDesk_actionsPage().ConfirmationModalPopup();
    }

    @Then("^I should be able to see that a new default action has been created on Changing the Owner for Reseller$")
    public void iShouldBeAbleToSeeThatANewDefaultActionHasBeenCreatedOnChangingTheOwnerForReseller()
    {
        webModel.getServiceDesk_actionsPage().assertDefaultActionCreatedOnOwnerChange("Jeanette Staton","Site1 Testing");

    }
}
