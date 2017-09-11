package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/**
 * Created by rajeshg on 29/08/2017.
 */
public class NA187_SDSK_Search_An_Incident_stepDefs {

    WebModel webModel=new WebModel();

    @Given("^I am logged in as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iAmLoggedInAsAnd(String userName, String passWord) throws InterruptedException {
        webModel.getUtils().loadBranchURLForServiceDesk(":9050");
        webModel.getLoginPage().login(userName, passWord);


    }

    @When("^I navigate to the browse incident page$")
    public void iNavigateToTheBrowseIncidentPage()  {
        webModel.getDashBoardPage().loadServiceDesk(":9050/RajeshNB");
        webModel.getServiceDesk_ticketDetailsPage().navigateToBrowseIncidents();

    }

    @Then("^I should be able to search by for the incidents \"([^\"]*)\" and perform all the validations$")
    public void iShouldBeAbleToSearchByForTheIncidentsAndPerformAllTheValidations(String by) throws InterruptedException {
        webModel.getServiceDesk_ticketDetailsPage().browserIncidents(by,"fgdgd","Regenrate bill");
        webModel.getServiceDesk_ticketDetailsPage().validateColumns_BrowserIncidents();


    }
    @Given("^I am logged in as AdamR and navigate to the branchURL$")
    public void iAmLoggedInAsAdamRAndNavigateToTheBranchURL() throws InterruptedException {
        webModel.getUtils().loadBranchURLForServiceDesk(":9050");
        webModel.getLoginPage().loginAsAdamR();

    }


    @Then("^I should be able to validate the data view$")
    public void iShouldBeAbleToValidateTheDataView() throws InterruptedException {
        webModel.getServiceDesk_ticketDetailsPage().validateShowEntries();
        webModel.getServiceDesk_ticketDetailsPage().validatePagination();

    }


}

