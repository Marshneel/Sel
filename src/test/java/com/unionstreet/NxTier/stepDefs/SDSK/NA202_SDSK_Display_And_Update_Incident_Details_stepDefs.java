package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class NA202_SDSK_Display_And_Update_Incident_Details_stepDefs
{
    WebModel webModel=new WebModel();
    NA166_SDSK_OpenReach_LineTest_stepDefs na166 = new NA166_SDSK_OpenReach_LineTest_stepDefs();

    @Then("^I should be able to see Incident Details Panel$")
    public void iShouldBeAbleToSeeIncidentDetailsPanel() throws InterruptedException
    {
       webModel.getServiceDesk_actionsPage().assertIncidentDetailsPanel();
       webModel.getServiceDesk_actionsPage().ValidateIncidentDetailsModalFieldsOnEditMode("Test Type Fault 1","Test Symptom 1","Test Category 1","summary","");


    }

    @And("^I should be able to edit the details and save the changes$")
    public void iShouldBeAbleToEditTheDetailsAndSaveTheChanges() throws InterruptedException
    {
          webModel.getServiceDesk_actionsPage().ClickEditIconOnIncidentDetailsPanel();
          webModel.getServiceDesk_actionsPage().assertIncidentDetailsPanel();
          webModel.getServiceDesk_actionsPage().EditFieldsOnIncidentDetailsModal("Bell ringing","Test Category 1.1","Fault","Notes");
          webModel.getServiceDesk_actionsPage().ClickSaveOnIncidentDetailsModal();
          webModel.getServiceDesk_actionsPage().ValidateIncidentDetailsModalFieldsOnEditMode("Test Type Fault 1","Test Symptom 1","Test Category 1","Fault","Notes");
    }

    @Given("^I am on Incident Details Panel$")
    public void iAmOnIncidentDetailsPanel() throws ClassNotFoundException, SQLException, InterruptedException, UnsupportedEncodingException
    {
        webModel.getUtils().loadBranchURLForServiceDesk("");
        webModel.getLoginPage().loginAsAdamR();
        na166.iRaiseAnOpenReachIncidentOnAnAnalogueLine();
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();
        webModel.getServiceDesk_actionsPage().assertIncidentDetailsPanel();
    }

    @When("^I change the Category to someother Category$")
    public void iChangeTheCategoryToSomeotherCategory()
    {
        webModel.getServiceDesk_actionsPage().ClickEditIconOnIncidentDetailsPanel();
        webModel.getServiceDesk_actionsPage().changeCategoryOnIncidentDetailsEditModal("Test Category 1.2");
        webModel.getServiceDesk_actionsPage().ClickSaveOnIncidentDetailsModal();
    }

    @Then("^I should be able to see that a new default action has been created on Changing the Category$")
    public void iShouldBeAbleToSeeThatANewDefaultActionHasBeenCreatedOnChangingTheCategory()
    {
       webModel.getServiceDesk_actionsPage().assertDefaultActionCreatedOnCategoryChange("Test Category 1","Test Category 1.2");
    }

    @Given("^I initiate an openreach incident and submit it$")
    public void iInitiateAnOpenreachIncidentAndSubmitIt() throws ClassNotFoundException, SQLException, InterruptedException, UnsupportedEncodingException
    {

        webModel.getUtils().loadBranchURLForServiceDesk("");
        webModel.getLoginPage().loginAsAdamR();
        na166.iRaiseAnOpenReachIncidentOnAnAnalogueLine();
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();
    }
}
