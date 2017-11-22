package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLException;

public class NA201_SDSK_Update_Incident_Priority_stepDefs
{
   WebModel webModel=new WebModel();
   NA160_SDSK_Login_Incident__Triage_stepDefs na160 = new NA160_SDSK_Login_Incident__Triage_stepDefs();

    @When("^I navigate to second step of Log an Incident wizard$")
    public void iNavigateToSecondStepOfLogAnIncidentWizard() throws java.lang.Exception
    {
        webModel.getDashBoardPage().switchGateway("10.1.9.112");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set is_default=NULL");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='1' where ID='150'");
        webModel.getDashBoardPage().loadServiceDesk();
        webModel.getServiceDeskPage().loadLoginIncidentPageAndAssertTextOnServiceDesk();
        webModel.getServiceDeskPage().searchByShortName("Adam As A Reseller");
        webModel.getServiceDeskPage().clickOnResult("Adam As A Reseller");
        webModel.getServiceDeskPage().clickIncidentButton();
        webModel.getServiceDesk_callerDetailsTriagePage().clickNextAfterPopulatingContact();
     }

    @Then("^I should be able to see the presence of Priority component$")
    public void iShouldBeAbleToSeeThePresenceOfPriorityComponent() throws InterruptedException
    {
         webModel.getServiceDesk_callerDetailsTriagePage().assertPresenceOfPriorityComponent();
    }

    @Given("^I am on View and Amend Details Page$")
    public void iAmOnViewAndAmendDetailsPage() throws java.lang.Exception
    {
        webModel.getDashBoardPage().switchGateway("10.1.9.112");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set is_default=NULL");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='1' where ID='150'");
        webModel.getUtils().loadBranchURLForServiceDesk("");
        webModel.getLoginPage().loginAsAdamR();
        webModel.getDashBoardPage().loadServiceDesk();
        webModel.getServiceDeskPage().loadLoginIncidentPageAndAssertTextOnServiceDesk();
        webModel.getServiceDeskPage().searchByShortName("Adam As A Reseller");
        webModel.getServiceDeskPage().clickOnResult("Adam As A Reseller");
        webModel.getServiceDeskPage().clickIncidentButton();
        webModel.getServiceDesk_callerDetailsTriagePage().clickNextAfterPopulatingContact();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false,true,false);
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(false,"02063678369", "PSTN Single Line", "1", "3", true,"LU1 1DQ");
        webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();
        webModel.getServiceDesk_actionsPage().assertIncidentViewAndAmendDetails();

    }


    @And("^should validate that a default action is created on priority change$")
    public void shouldValidateThatADefaultActionIsCreatedOnPriorityChange()  throws java.lang.Exception
    {
         webModel.getServiceDesk_actionsPage().assertDefaultActionCreatedOnPriorityChange(2,4);
        webModel.getServiceDesk_actionsPage().assertDefaultActionCreatedOnPriorityChange(4,1);

        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='0' where ID='150'");

    }


    @When("^changing the priority to other target clear badge should get refreshed$")
    public void changingThePriorityToOtherTargetClearBadgeShouldGetRefreshed() throws Throwable
    {
        webModel.getServiceDesk_actionsPage().UpdatePriorityAndAssertTargetClearBadgeRefreshed();
        webModel.getServiceDesk_actionsPage().ChangePriority(4);
        webModel.getServiceDesk_actionsPage().UpdatePriorityAndAssertTargetClearBadgeRefreshed();
        webModel.getServiceDesk_actionsPage().ChangePriority(1);
        webModel.getServiceDesk_actionsPage().UpdatePriorityAndAssertTargetClearBadgeRefreshed();
    }
}
