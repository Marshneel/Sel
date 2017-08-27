package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by rajeshg on 20/08/2017.
 */
public class _NA181_SDSK_Service_Maintenance_Levels_stepDefs {

    WebModel webModel=new WebModel();
    NA160_SDSK_Login_Incident__Triage_stepDefs na160=new NA160_SDSK_Login_Incident__Triage_stepDefs();
    @And("^I raise an open reach incident on an either of the virtual line$")
    public void iRaiseAnOpenReachIncidentOnAnEitherOfTheVirtualLine() throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set product='WLR RCF' where serviceid='ORCF00000002'");
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails("01202300912","WLR RCF","2","2",false);


    }

    @Then("^The service maintenance levels should be un-available for virtualLines$")
    public void theServiceMaintenanceLevelsShouldBeUnAvailableForVirtualLines() throws InterruptedException, UnsupportedEncodingException, ClassNotFoundException, SQLException {
        webModel.getServiceDesk_ticketDetailsPage().assertServiceMaintenanceLevelsAbsent(true,false);
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set product='WLR3 ISDN RCF' where serviceid='ORCF00000002'");

    }

    @Given("^I am logged in as agentAdam$")
    public void iAmLoggedInAsAgentAdam() throws InterruptedException {
        webModel.getLoginPage().loginAsAgentAdam();

    }


    @Then("^The service maintenance levels dropdown should be un-available for selection$")
    public void theServiceMaintenanceLevelsDropdownShouldBeUnAvailableForSelection() throws InterruptedException, UnsupportedEncodingException, ClassNotFoundException {
        webModel.getServiceDesk_ticketDetailsPage().assertServiceMaintenanceLevelsAbsent(false,true);

    }

    @When("^I raise an open reach incident on an ISDN (\\d+) line with care level plan (\\d+)$")
    public void iRaiseAnOpenReachIncidentOnAnISDNLineWithCareLevelPlan(int arg0, int arg1) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set CareLevel='2' where serviceid='OI3000000001'");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails("01202300945","WLR3 ISDN 30 ETSI","8","2",true);

    }

    @Then("^A validation message stating the unavailability of service maintenance levels should be thrown$")
    public void aValidationMessageStatingTheUnavailabilityOfServiceMaintenanceLevelsShouldBeThrown() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getServiceDesk_ticketDetailsPage().assertThatServiceLevelsUnavailableForISDN30WithLevel2();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set CareLevel='4' where serviceid='OI3000000001'");


    }

    @When("^I raise an open reach incident on \"([^\"]*)\" with \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iRaiseAnOpenReachIncidentOnWithAnd(String line, String type, String numberOfLines, String maintenanceLevel) throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(line,type,numberOfLines,maintenanceLevel,true);



    }

    @Then("^The service maintenance levels should be available$")
    public void theServiceMaintenanceLevelsShouldBeAvailable() {
        webModel.getServiceDesk_ticketDetailsPage().assertServiceMaintenanceLevelsPresent();

    }

    @When("^I raise an open reach incident on a line that has care level (\\d+)$")
    public void iRaiseAnOpenReachIncidentOnALineThatHasCareLevel(int arg0) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set CareLevel='2' where serviceid='02063678369'");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().assertTextOnTicketDetailsPage();
        webModel.getServiceDesk_ticketDetailsPage().clickObtainInstallationDetailsWithOutPopulatingCLIAndPostCode();
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails("02063678369","PSTN Single Line","2","2",true);
    }

    @Then("^The service time should drop basing on the plan i choose$")
    public void theServiceTimeShouldDropBasingOnThePlanIChoose() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException, ParseException {
        webModel.getServiceDesk_ticketDetailsPage().assertCurrentServiceLevelWithCurrent(true,false,false);
        webModel.getServiceDesk_ticketDetailsPage().assertCurrentServiceLevel("Level 2");
        webModel.getServiceDesk_ticketDetailsPage().selectServiceLevel("Level 3");
        webModel.getServiceDesk_ticketDetailsPage().assertCurrentServiceLevelWithCurrent(false,true,false);
        webModel.getServiceDesk_ticketDetailsPage().selectServiceLevel("Level 4");
        webModel.getServiceDesk_ticketDetailsPage().assertCurrentServiceLevelWithCurrent(false,false,true);
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set CareLevel='2.5' where serviceid='02063678369'");


    }
}
