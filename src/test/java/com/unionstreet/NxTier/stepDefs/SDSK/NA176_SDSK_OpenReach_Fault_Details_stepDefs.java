package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by rajeshg on 01/08/2017.
 */
public class NA176_SDSK_OpenReach_Fault_Details_stepDefs {
    WebModel webModel=new WebModel();
    NA160_SDSK_Login_Incident__Triage_stepDefs na160=new NA160_SDSK_Login_Incident__Triage_stepDefs();

    @Given("^I am logged in as AdamR with zoom$")
    public void iAmLoggedInAsAdamRWithZoom() throws Throwable {
        webModel.getUtils().loadBranchURLForServiceDesk("");
        webModel.getLoginPage().loginAsAdamR();
    }



    @When("^I navigate to fault details page and choose single analogue line$")
    public void iNavigateToFaultDetailsPageAndChooseSingleAnalogueLine() throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails("02063678369","PSTN Single Line","2","2",true);
    }

    @Then("^I should be able to check validations pertaining to single analogue line$")
    public void iShouldBeAbleToCheckValidationsPertainingToSingleAnalogueLine() throws InterruptedException {

        webModel.getServiceDesk_ticketDetailsPage().faultDetails_assertionForAnalogueLines(false);

    }


    @When("^I navigate to fault details page and choose multi-line$")
    public void iNavigateToFaultDetailsPageAndChooseMultiLine() throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails("01202300909","PSTN Multi Line Aux","2","2",true);

    }

    @Then("^I should be able to check validations pertaining to multi-line$")
    public void iShouldBeAbleToCheckValidationsPertainingToMultiLine() throws InterruptedException {
        webModel.getServiceDesk_ticketDetailsPage().faultDetails_assertionForAnalogueLines(true);

    }

    @When("^I navigate to fault details page and choose ISDN(\\d+)E$")
    public void iNavigateToFaultDetailsPageAndChooseISDNE(int arg0) throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails("01202300945","WLR3 ISDN 30 ETSI","8","4",true);

    }

    @Then("^I should be able to check validations pertaining to ISDN(\\d+)E$")
    public void iShouldBeAbleToCheckValidationsPertainingToISDNE(int arg0) throws InterruptedException {
        webModel.getServiceDesk_ticketDetailsPage().faultDetails_assertionForISDN30E();
        webModel.getServiceDesk_ticketDetailsPage().validateSampleCalls();
    }

    @When("^I navigate to fault details page and choose ISDN(\\d+) System$")
    public void iNavigateToFaultDetailsPageAndChooseISDNSystem(int arg0) throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails("01202300920","WLR3 ISDN 2e System","2","2",true);


    }

    @Then("^I should be able to check validations pertaining to ISDN(\\d+) System$")
    public void iShouldBeAbleToCheckValidationsPertainingToISDNSystem(int arg0) throws InterruptedException {
        webModel.getServiceDesk_ticketDetailsPage().faultDetails_assertionForISDN2();

    }
}
