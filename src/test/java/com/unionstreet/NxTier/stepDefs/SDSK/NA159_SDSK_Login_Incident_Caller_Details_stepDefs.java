package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 21/06/2017.
 */
public class NA159_SDSK_Login_Incident_Caller_Details_stepDefs {

    WebModel webModel=new WebModel();

    @Given("^I am logged in as AdamR$")
    public void iAmLoggedInAsAdamR() throws InterruptedException {
       webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsAdamR();

    }

    @When("^I navigate to the caller details page of the incident wizard$")
    public void iNavigateToTheCallerDetailsPageOfTheIncidentWizard() throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set is_default=NULL");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='1' where ID='156'");
        webModel.getDashBoardPage().loadServiceDesk(":9080/RajeshNB");
        webModel.getServiceDeskPage().assertTextOnServiceDesk();
        webModel.getServiceDeskPage().searchByShortName("Adam As A Reseller");
        webModel.getServiceDeskPage().clickOnResult("Adam As A Reseller");
        webModel.getServiceDeskPage().clickIncidentButton();
    }


    @Then("^I should be able to check all the validations and populate caller details page$")
    public void iShouldBeAbleToCheckAllTheValidationsAndPopulateCallerDetailsPage() {
        webModel.getServiceDesk_loginIncidentPage().clickNextWithOutPopulatingCallerDetailsTab();
        webModel.getServiceDesk_loginIncidentPage().clickNextAfterPopulatingContact();
        webModel.getServiceDesk_loginIncidentPage().clickPrevious();
        webModel.getServiceDesk_loginIncidentPage().populateThirdParty();


    }


}
