package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.NxTier.support.WebModel;
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
        webModel.getServiceDesk_loginIncidentPage().openReachIncident_Triage(false);
        webModel.getServiceDesk_loginIncidentPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_loginIncidentPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();




    }

    @Then("^I should be able to select a CLI and obtain its installation details$")
    public void iShouldBeAbleToSelectACLIAndObtainItsInstallationDetails() throws InterruptedException {
        webModel.getServiceDesk_loginIncidentPage().selectCLIToObtainInstallationDetails("02063678369","PSTN Single Line","2","2",true);
    }
}
