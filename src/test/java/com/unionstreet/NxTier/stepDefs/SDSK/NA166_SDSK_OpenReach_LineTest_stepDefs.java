package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by rajeshg on 04/08/2017.
 */
public class NA166_SDSK_OpenReach_LineTest_stepDefs {
    WebModel webModel=new WebModel();
    NA160_SDSK_Login_Incident__Triage_stepDefs na160=new NA160_SDSK_Login_Incident__Triage_stepDefs();

    @When("^I raise an open reach incident on an analogue line$")
    public void iRaiseAnOpenReachIncidentOnAnAnalogueLine() throws ClassNotFoundException, SQLException, InterruptedException, UnsupportedEncodingException {
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_loginIncidentPage().openReachIncident_Triage(false);
        webModel.getServiceDesk_loginIncidentPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_loginIncidentPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();
        webModel.getServiceDesk_loginIncidentPage().selectCLIToObtainInstallationDetails("02063678369","PSTN Single Line","2","2");
    }

    @Then("^I should be able to validate the line test functionality$")
    public void iShouldBeAbleToValidateTheLineTestFunctionality() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
    webModel.getServiceDesk_loginIncidentPage().lineTest_Fail();
        webModel.getServiceDesk_loginIncidentPage().lineTest_Pass();
    }
}
