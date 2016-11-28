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
    NA54_JavaMethodToRunSQLScriptsFromSeleniumEnvironment_stepDefs na_54=
            new NA54_JavaMethodToRunSQLScriptsFromSeleniumEnvironment_stepDefs();


    @When("^I access add_view notes on edit order page$")
    public void iAccessAdd_viewNotesOnEditOrderPage() {
        na_54.createANewQuoteAndAddAServiceThatContainsAServiceCharge();
        webModel.getOrdersManagerPage().accessAdd_ViewNotes();
    }

    @Then("^customer and internal tabs should be present and accessible$")
    public void customerAndInternalTabsShouldBePresentAndAccessible() {
        webModel.getOrdersManagerPage().assertCustomer_InternalTabsPresent();
        //webModel.getDashBoardPage().logOut();
    }


    @Then("^customer and internal tabs should be absent$")
    public void customerAndInternalTabsShouldBeAbsent() {
        webModel.getOrdersManagerPage().assertCustomer_InternalTabsNotPresent();

    }

    @Given("^I am logged in as agent and there is a service unassigned to me$")
    public void iAmLoggedInAsAgentAndThereIsAServiceUnassignedToMe() throws InterruptedException {
        webModel.getLoginPage().loginAsCP();
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getOrdersManagerPage().accessingAssignServicePage();
        webModel.getOrdersManagerPage().makeSureAgentDoesNotHaveAgentAndResellerService();
        webModel.getOrdersManagerPage().saveAssignServicePage();
        webModel.getLoginPage().loginAsAgent();
    }

    @When("^I access the services page$")
    public void iAccessTheServicesPage() {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getOrdersManagerPage().clickOnQuoteID();
        webModel.getAddServicePage().clickAddAProductOrService();
    }

    @Then("^I should not be able to see that particular service$")
    public void iShouldNotBeAbleToSeeThatParticularService() {
//        TODO
        webModel.getAddServicePage().assertServiceNotPresent("ServiceForAgent&Reseller");
    }

    @And("^I should be able to see the service once CP assigns it to me$")
    public void iShouldBeAbleToSeeTheServiceOnceCPAssignsItToMe() throws InterruptedException {
        webModel.getOrdersManagerPage().makeSureAgentHasAgentAndResellerService();
        webModel.getOrdersManagerPage().saveAssignServicePage();
        webModel.getLoginPage().loginAsAgent();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getOrdersManagerPage().clickOnQuoteID();
        webModel.getAddServicePage().clickAddAProductOrService();
        webModel.getAddServicePage().assertServicePresent("ServiceForAgent&Reseller");

    }
}
