package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 21/06/2017.
 */
public class NA160_SDSK_Login_Incident__Triage_stepDefs {
    WebModel webModel =new WebModel();
    NA159_Login_Incident__Caller_Details_stepDefs na159=new NA159_Login_Incident__Caller_Details_stepDefs();

    @When("^I navigate to the triage page of the incident wizard$")
    public void iNavigateToTheTriagePageOfTheIncidentWizard() throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "SN_aBILLity_Portal", "update incident_types set is_default=NULL");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "SN_aBILLity_Portal", "update Defaultvalues set ValueNumber='0' where ID='150'");
      na159.iNavigateToTheCallerDetailsPageOfTheIncidentWizard();
        webModel.getServiceDesk_loginIncidentPage().clickNextAfterPopulatingContact();



    }

    @Then("^I should be able to check all the validations and populate it$")
    public void iShouldBeAbleToCheckAllTheValidationsAndPopulateIt() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getServiceDesk_loginIncidentPage().clickNextWithOutPopulatingTriage();
        webModel.getServiceDesk_loginIncidentPage().openReachIncident_Triage();
        webModel.getServiceDesk_loginIncidentPage().non_OpenReachIncident_Triage();
        webModel.getLoginPage().loginAsAdamR();
        na159.iNavigateToTheCallerDetailsPageOfTheIncidentWizard();
        webModel.getServiceDesk_loginIncidentPage().clickNextAfterPopulatingContact();
        webModel.getServiceDesk_loginIncidentPage().choosePriorityOverCategory();
    }
}
