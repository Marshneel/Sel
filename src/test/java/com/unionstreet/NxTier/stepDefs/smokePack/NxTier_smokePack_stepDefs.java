package com.unionstreet.NxTier.stepDefs.smokePack;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;


public class NxTier_smokePack_stepDefs {


    WebModel webModel = new WebModel();


    @Given("^I am on login page$")
    public void iAmOnLoginPage() {
        webModel.getLoginPage().OnLoginPage();
    }

    @When("^I enter valid username and password$")
    public void iEnterValidUsernameAndPassword() throws IOException, InterruptedException {
       webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().doLogin();
    }

    @Then("^Login is successful$")
    public void LoginIsSuccessful() throws InterruptedException {
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

    @Given("^I am logged in as an admin$")
    public void iAmLoggedInAsAnAdmin() throws InterruptedException {
       webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().doLogin();
    }

    @When("^I access add new business customer page$")
    public void iAccessAddNewBusinessCustomerPage() throws InterruptedException {
        webModel.getNewBusinessCustomerPage().clickContactManagerButton();
        webModel.getNewBusinessCustomerPage().clickAddNewCustomerButton();
    }

    @And("^Provide all the required info$")
    public void provideAllTheRequiredInfo() {
        webModel.getNewBusinessCustomerPage().addCompanyInfoForNewBusinessCustomerCreatedWithDefaultContactTypes();
        webModel.getNewBusinessCustomerPage().addSiteInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().addSiteContactInfoForNewBusinessCustomer();
    }

    @Then("^A new customer should be successfully created$")
    public void aNewCustomerShouldBeSuccessfullyCreated() throws InterruptedException {
        webModel.getContactManagerPage().assertNewBusinessCustomer();
        webModel.getDashBoardPage().logOut();
    }

    @And("^I have added a new business customer$")
    public void iHaveAddedANewBusinessCustomer() throws InterruptedException {
        webModel.getNewBusinessCustomerPage().clickContactManagerButton();
        webModel.getNewBusinessCustomerPage().clickAddNewCustomerButton();
        webModel.getNewBusinessCustomerPage().addCompanyInfoForNewBusinessCustomerCreatedWithDefaultContactTypes();
        webModel.getNewBusinessCustomerPage().addSiteInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().addSiteContactInfoForNewBusinessCustomer();
    }

    @When("^I access Company Sites under the company menu and provide all the required info$")
    public void iaccessinvoicingandbillingdetailssectionundercompanymenuandprovideallrequiredinfo() throws InterruptedException {
        webModel.getCompanyMenuPage().addNewSite();
        webModel.getCompanyMenuPage().addNewSiteNames();
        webModel.getCompanyMenuPage().addNewSiteAddress();
        webModel.getCompanyMenuPage().setOwnSiteBillingAddress();
        webModel.getCommonMethods().saveAndClosePage();
    }

    @Then("^A new site should appear under the respective company's menu$")
    public void anewsiteshouldappearundertherespectivecompanysmenu() {
        webModel.getCompanyMenuPage().assertNewSite();
    }

    @When("^I access invoicing and billing details section under company menu and provide all required info$")
    public void iAccessInvoicingAndBillingDetailsSectionUnderCompanyMenuAndProvideAllRequiredInfo() throws InterruptedException {
        webModel.getCompanyMenuPage().addInvoicingDetails();
        webModel.getCompanyMenuPage().addBillingDetails();
    }

    @Then("^Invoice details and billing details of that particular customer should be updated, respectively$")
    public void invoiceDetailsAndBillingDetailsOfThatParticularCustomerShouldBeUpdatedRespectively() throws InterruptedException {
        webModel.getCompanyMenuPage().assertSavedInvoiceDetails();
        webModel.getCompanyMenuPage().assertSavedBillingDetails();
        webModel.getDashBoardPage().logOut();
    }

    @When("^I access CLIs and service charges section under company menu and provide all required info$")
    public void iAccessCLIsAndServiceChargesSectionUnderCompanyMenuAndProvideAllRequiredInfo() throws InterruptedException {
        webModel.getCompanyMenuPage().addCLIs(webModel.getNewBusinessCustomerPage().RanName,webModel.getCompanyMenuPage().RanNumber,true,true);
        webModel.getCompanyMenuPage().addRecurringChargesPart1();
        webModel.getCompanyMenuPage().addRecurringChargesPart2();
        webModel.getCompanyMenuPage().addOneOffChargesPart1();
        webModel.getCompanyMenuPage().addOneOffChargesPart2();
    }

    @Then("^CLIs and service charges of that particular customer should be updated, respectively$")
    public void clisAndServiceChargesOfThatParticularCustomerShouldBeUpdatedRespectively() throws InterruptedException {
        webModel.getCompanyMenuPage().assertCLIs();
        webModel.getCompanyMenuPage().assertAddedRecurringCharges();
        webModel.getCompanyMenuPage().assertAddedOneOffCharges();
        webModel.getDashBoardPage().logOut();
    }

    @When("^I access pricing details under company menu and provide all required info$")
    public void iAccessPricingDetailsUnderCompanyMenuAndProvideAllRequiredInfo() throws InterruptedException {
        webModel.getCompanyMenuPage().addPricingDetails();
    }

    @Then("^Pricing details of that particular customer  should be updated$")
    public void pricingDetailsOfThatParticularCustomerShouldBeUpdated() throws InterruptedException {
//        webModel.getCompanyMenuPage().assertAddedPricingDetails();
        webModel.getDashBoardPage().logOut();
    }

}
















