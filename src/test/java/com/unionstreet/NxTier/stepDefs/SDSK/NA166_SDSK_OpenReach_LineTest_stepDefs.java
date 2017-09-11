package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
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
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails("02063678369","PSTN Single Line","2","2",true);
    }

    @Then("^I should be able to validate the line test functionality$")
    public void iShouldBeAbleToValidateTheLineTestFunctionality() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
    webModel.getServiceDesk_ticketDetailsPage().lineTest_Fail();
        webModel.getServiceDesk_ticketDetailsPage().lineTest_Pass();
        webModel.getServiceDesk_ticketDetailsPage().overNightLineTest();
    }

    @And("^I should be able to assert that the line test is absent for ISDN(\\d+) and virtual lines$")
    public void iShouldBeAbleToAssertThatTheLineTestIsAbsentForISDNAndVirtualLines(int arg0)  {

    }

    @When("^I navigate to obtain installation details page$")
    public void iNavigateToObtainInstallationDetailsPage() throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();

    }

    @Then("^I should be able to assert that the lineTest is un-available for ISDN(\\d+) and virtual lines$")
    public void iShouldBeAbleToAssertThatTheLineTestIsUnAvailableForISDNAndVirtualLines(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails("01202300945","WLR3 ISDN 30 ETSI","8","4",true);
        webModel.getServiceDesk_ticketDetailsPage().assertLineTestAndTRCAbsentForISDN30AndVirtualLines();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set product='WLR RCF' where serviceid='ORCF00000002'");
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails("01202300912","WLR RCF","2","2",false);
        webModel.getServiceDesk_ticketDetailsPage().assertLineTestAndTRCAbsentForISDN30AndVirtualLines();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set product='WLR3 ISDN RCF' where serviceid='ORCF00000002'");

    }
}
