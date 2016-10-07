package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by rajeshg on 05/10/2016.
 */
public class NA51_ServiceDesignerApplication_Familiarise_stepDefs {
    WebModel webModel = new WebModel();


    @When("^I access add_view notes on edit order page$")
    public void iAccessAdd_viewNotesOnEditOrderPage() {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().clickOnQuoteID();
        webModel.getDashBoardPage().accessAdd_ViewNotes();

    }

    @Then("^customer and internal tabs should be present and accessible$")
    public void customerAndInternalTabsShouldBePresentAndAccessible() {
        webModel.getDashBoardPage().assertCustomer_InternalTabsPresent();

    }


    @Then("^customer and internal tabs should be absent$")
    public void customerAndInternalTabsShouldBeAbsent() {
        webModel.getDashBoardPage().assertCustomer_InternalTabsNotPresent();

    }


    @Given("^I am logged in as agent and there is a service unassigned to me$")
    public void iAmLoggedInAsAgentAndThereIsAServiceUnassignedToMe() {
        webModel.getLoginPage().loginAsCP();
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getDashBoardPage().accessingAssignServicePage();
        webModel.getDashBoardPage().makeSureAgentDoesNotHaveAgentAndResellerService();
        webModel.getDashBoardPage().saveAssignServicePage();
        webModel.getLoginPage().loginAsAgent();
    }

    @When("^I access the services page$")
    public void iAccessTheServicesPage() {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().clickOnQuoteID();
        webModel.getDashBoardPage().clickAddAProductOrService();

    }

    @Then("^I should not be able to see that particular service$")
    public void iShouldNotBeAbleToSeeThatParticularService() {
        webModel.getDashBoardPage().assertServiceNotPresent("ServiceForAgent&Reseller");
    }

    @And("^I should be able to see the service once CP assigns it to me$")
    public void iShouldBeAbleToSeeTheServiceOnceCPAssignsItToMe() {
        webModel.getDashBoardPage().makeSureAgentHasAgentAndResellerService();
        webModel.getDashBoardPage().saveAssignServicePage();
        webModel.getLoginPage().loginAsAgent();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().clickOnQuoteID();
        webModel.getDashBoardPage().clickAddAProductOrService();
        webModel.getDashBoardPage().assertServicePresent("ServiceForAgent&Reseller");
    }
}
