package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 07/07/2017.
 */
public class NA165_SDSK_Populate_OIDs_stepDefs {
    WebModel webModel=new WebModel();

    NA160_SDSK_Login_Incident__Triage_stepDefs na160=new NA160_SDSK_Login_Incident__Triage_stepDefs();
    @When("^I navigate to line and installation details of login in incident page$")
    public void iNavigateToLineAndInstallationDetailsOfLoginInIncidentPage() throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false,false,false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();




    }

    @Then("^I should be able to select a CLI and obtain its installation details$")
    public void iShouldBeAbleToSelectACLIAndObtainItsInstallationDetails() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(true,"02063678369","WLR Single Line","2","2",true,"LU1 1DQ");
    }
}
