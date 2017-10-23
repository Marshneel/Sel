package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 21/06/2017.
 */
public class NA160_SDSK_Login_Incident__Triage_stepDefs {
    WebModel webModel =new WebModel();
    NA159_SDSK_Login_Incident_Caller_Details_stepDefs na159=new NA159_SDSK_Login_Incident_Caller_Details_stepDefs();

    @When("^I navigate to the triage page of the incident wizard$")
    public void iNavigateToTheTriagePageOfTheIncidentWizard() throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set is_default=NULL");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='0' where ID='150'");
      na159.iNavigateToTheCallerDetailsPageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().clickNextAfterPopulatingContact();



    }

    @Then("^I should be able to check all the validations and populate it$")
    public void iShouldBeAbleToCheckAllTheValidationsAndPopulateIt() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getServiceDesk_callerDetailsTriagePage().clickNextWithOutPopulatingTriage();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(true);

        webModel.getServiceDesk_callerDetailsTriagePage().non_OpenReachIncident_Triage();
        webModel.getUtils().loadBranchURLForServiceDesk("");
        webModel.getLoginPage().loginAsAdamR();
        na159.iNavigateToTheCallerDetailsPageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().clickNextAfterPopulatingContact();
        webModel.getServiceDesk_callerDetailsTriagePage().choosePriorityOverCategory();
    }
}
