package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by rajeshg on 22/09/2016.
 */
public class NA44_Agent_Login_stepDefs {

    WebModel webModel = new WebModel();

    @And("^Have created a new customer$")
    public void haveCreatedANewCustomer() {
        webModel.getNewBusinessCustomerPage().clickContactManagerButton();
        webModel.getNewBusinessCustomerPage().clickAddNewCustomerButton();
        webModel.getNewBusinessCustomerPage().addCompanyInfoForNewBusinessCustomerCreatedWithDefaultContactTypes();
        webModel.getNewBusinessCustomerPage().addSiteInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().addSiteContactInfoForNewBusinessCustomer();
    }

    @When("^I access create Quote window$")
    public void iAccessCreateQuoteWindow() {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().clickCreateQuoteButton();
    }

    @Then("^the newly created customer details should appear under the company and site drop downs$")
    public void theNewlyCreatedCustomerDetailsShouldAppearUnderTheCompanyAndSiteDropDowns() throws InterruptedException {
        webModel.getDashBoardPage().assertCompanyIsAccessibleFromCompanyAndSiteDropDown();
    }

    ////////////////////////////////////////two///////////////////////////////////////////////////////
    @Given("^I am logged in as an agent after the CP has created a quote for a \"([^\"]*)\" assigned to me$")
    public void iAmLoggedInAsAnAgentAfterTheCPHasCreatedAQuoteForAAssignedToMe(String customer_name) throws InterruptedException {
        webModel.getLoginPage().loginAsCP();
        webModel.getNewBusinessCustomerPage().clickContactManagerButton();
        webModel.getContactManagerPage().searchForBusinessCustomer(customer_name);
        webModel.getContactManagerPage().assignAnAgentForBC();
    }

    @And("^a quote been created for my \"([^\"]*)\" by a CP$")
    public void aQuoteBeenCreatedForMyByACP(String customer_name) throws InterruptedException {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().clickCreateQuoteButton();
        webModel.getDashBoardPage().createQuote(customer_name);
        webModel.getDashBoardPage().logOut();
    }

    @When("^I access orders manager$")
    public void iAccessOrdersManager() {
        webModel.getLoginPage().loginAsAgent();
        webModel.getDashBoardPage().clickOrderManagerButton();
    }

    @Then("^I should be able to see and access that particular quote$")
    public void iShouldBeAbleToSeeAndAccessThatParticularQuote() throws InterruptedException {
        webModel.getDashBoardPage().searchQuoteByQRN();
        webModel.getDashBoardPage().assertAgentCanViewAndEditQuotes();
    }


}
