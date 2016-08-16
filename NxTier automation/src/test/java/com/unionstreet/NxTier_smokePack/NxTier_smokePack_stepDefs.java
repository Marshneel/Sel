package com.unionstreet.NxTier_smokePack;

import com.unionstreet.NxTier_smokePack.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class NxTier_smokePack_stepDefs {

    WebModel webModel = new WebModel();

    @Given("^I am on login page$")
    public void iAmOnLoginPage() {
        webModel.getLoginPage().OnLoginPage();
    }

    @When("^I enter valid username and password$")
    public void iEnterValidUsernameAndPassword() {
        webModel.getLoginPage().doLogin();
    }

    @Then("^Login is successful$")
    public void LoginIsSuccessful() {
        webModel.getDashBoardPage().assertLogin();
        webModel.getDashBoardPage().logOut();
    }

    @When("^I enter invalid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterInvalidAnd(String userName, String passWord) {
        webModel.getLoginPage().failedLogin(userName, passWord);
    }

    @Then("^The login should fail$")
    public void TheLoginShouldFail() {
        webModel.getLoginPage().assertFailedLogin();
    }


    @Given("^I am logged into the account as admin$")
    public void iAmLoggedIntoTheAccountAsAdmin() {
        webModel.getLoginPage().doLogin();
    }

    @When("^I access add new business customer page$")
    public void iAccessAddNewBusinessCustomerPage() {
        webModel.getNewBusinessCustomerPage().clickContactManagerButton();
        webModel.getNewBusinessCustomerPage().onAddNewBusinessCustomerPage();
    }

    @And("^Provide all the required info$")
    public void provideAllTheRequiredInfo() {
        webModel.getNewBusinessCustomerPage().companyInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().siteInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().siteContactInfoForNewBusinessCustomer();
    }

    @Then("^A new customer should be successfully created$")
    public void aNewCustomerShouldBeSuccessfullyCreated() {
        webModel.getContactManagerPage().assertNewBusinessCustomer();
        webModel.getDashBoardPage().logOut();
    }

    @And("^I have added a new business customer$")
    public void iHaveAddedANewBusinessCustomer() {
        webModel.getNewBusinessCustomerPage().clickContactManagerButton();
        webModel.getNewBusinessCustomerPage().onAddNewBusinessCustomerPage();
        webModel.getNewBusinessCustomerPage().companyInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().siteInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().siteContactInfoForNewBusinessCustomer();
    }

    @When("^I access invoicing and billing details section under company menu and provide all required info$")
    public void iAccessInvoicingAndBillingDetailsSectionUnderCompanyMenuAndProvideAllRequiredInfo() {
        webModel.getCompanyMenuPage().addInvoicingDetails();
        webModel.getCompanyMenuPage().addBillingDetails();
    }

    @Then("^Invoice details and billing details of that particular customer should be updated, respectively$")
    public void invoiceDetailsAndBillingDetailsOfThatParticularCustomerShouldBeUpdatedRespectively() {
        webModel.getCompanyMenuPage().assertSavedInvoiceDetails();
        webModel.getCompanyMenuPage().assertSavedBillingDetails();

        webModel.getDashBoardPage().logOut();
    }

    @When("^I access CLIs and service charges section under company menu and provide all required info$")
    public void iAccessCLIsAndServiceChargesSectionUnderCompanyMenuAndProvideAllRequiredInfo() {
        webModel.getCompanyMenuPage().addCLIs();
        webModel.getCompanyMenuPage().addRecurringChargesPart1();
        webModel.getCompanyMenuPage().addRecurringChargesPart2();
        webModel.getCompanyMenuPage().addOneOffChargesPart1();
        webModel.getCompanyMenuPage().addOneOffChargesPart2();
    }

    @Then("^CLIs and service charges of that particular customer should be updated, respectively$")
    public void clisAndServiceChargesOfThatParticularCustomerShouldBeUpdatedRespectively() {
        webModel.getCompanyMenuPage().assertCLIs();
        webModel.getCompanyMenuPage().assertAddedRecurringCharges();
        webModel.getCompanyMenuPage().assertAddedOneOffCharges();
        webModel.getDashBoardPage().logOut();
    }

    @When("^I access orders under company menu and provide all required details$")
    public void iAccessOrdersUnderCompanyMenuAndProvideAllRequiredDetails() {
        webModel.getCompanyMenuPage().addOrders();
    }

    @Then("^I should be able to generate a quote$")
    public void iShouldBeAbleToGenerateAQuote() {
        webModel.getCompanyMenuPage().assertAddedOrders();
        webModel.getDashBoardPage().logOut();
    }

    @When("^I access pricing details under company menu and provide all required info$")
    public void iAccessPricingDetailsUnderCompanyMenuAndProvideAllRequiredInfo() {
        webModel.getCompanyMenuPage().addPricingDetails();
    }

    @Then("^Pricing details of that particular cusotmer  should be updated$")
    public void pricingDetailsOfThatParticularCusotmerShouldBeUpdated() {
        webModel.getCompanyMenuPage().assertAddedPricingDetails();
        webModel.getDashBoardPage().logOut();
    }
}










