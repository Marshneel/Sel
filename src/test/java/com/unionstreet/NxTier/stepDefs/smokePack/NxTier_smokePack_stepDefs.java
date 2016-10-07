package com.unionstreet.NxTier.stepDefs.smokePack;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.*;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;


public class NxTier_smokePack_stepDefs {

    WebModel webModel = new WebModel();

    @Given("^I am on login page$")
    public void iAmOnLoginPage() throws SQLException, ClassNotFoundException, UnsupportedEncodingException {

        webModel.getLoginPage().OnLoginPage();
    }

    @When("^I enter valid username and password$")
    public void iEnterValidUsernameAndPassword() {
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
    public void iAmLoggedInAsAnAdmin() {
        webModel.getLoginPage().doLogin();
    }

    @When("^I access add new business customer page$")
    public void iAccessAddNewBusinessCustomerPage() {
        webModel.getNewBusinessCustomerPage().clickContactManagerButton();
        webModel.getNewBusinessCustomerPage().clickAddNewCustomerButton();
    }

    @And("^Provide all the required info$")
    public void provideAllTheRequiredInfo() {
        webModel.getNewBusinessCustomerPage().companyInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().addSiteInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().addSiteContactInfoForNewBusinessCustomer();
    }

    @Then("^A new customer should be successfully created$")
    public void aNewCustomerShouldBeSuccessfullyCreated() throws InterruptedException {
        webModel.getContactManagerPage().assertNewBusinessCustomer();
        webModel.getDashBoardPage().logOut();
    }


    @And("^I have added a new business customer$")
    public void iHaveAddedANewBusinessCustomer() {
        webModel.getNewBusinessCustomerPage().clickContactManagerButton();
        webModel.getNewBusinessCustomerPage().clickAddNewCustomerButton();
        webModel.getNewBusinessCustomerPage().companyInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().addSiteInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().addSiteContactInfoForNewBusinessCustomer();
    }

    @When("^I access Company Sites under the company menu and provide all the required info$")
    public void iaccessinvoicingandbillingdetailssectionundercompanymenuandprovideallrequiredinfo() {
        webModel.getCompanyMenuPage().addNewSite();
        webModel.getCompanyMenuPage().addNewSiteNames();
        webModel.getCompanyMenuPage().addNewSiteAddress();
        webModel.getCompanyMenuPage().setOwnSiteBillingAddress();
        webModel.getCommonMethods().saveAndClosePage();
    }

    @Then("^A new site should appear under the respective company's menu$")
    public void anewsiteshouldappearundertherespectivecompanysmenu() throws InterruptedException {
        webModel.getCompanyMenuPage().assertNewSite();
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


    @When("^I access pricing details under company menu and provide all required info$")
    public void iAccessPricingDetailsUnderCompanyMenuAndProvideAllRequiredInfo() {
        webModel.getCompanyMenuPage().addPricingDetails();
    }

    @Then("^Pricing details of that particular customer  should be updated$")
    public void pricingDetailsOfThatParticularCustomerShouldBeUpdated() throws InterruptedException {
        webModel.getCompanyMenuPage().assertAddedPricingDetails();
        webModel.getDashBoardPage().logOut();
    }


    @Given("^I am on home page$")
    public void iAmOnHomePage() {


    }

    @When("^I create a tariff under one of \"([^\"]*)\"$")
    public void iCreateATariffUnderOneOf(String tariff_Categories) {
        webModel.getCompanyMenuPage().addNewTariffWithTariffCategory(tariff_Categories);
    }


    @Then("^That particular tariff should be available for selection under that particular category under pricing details of that customer$")
    public void thatParticularTariffShouldBeAvailableForSelectionUnderThatParticularCategoryUnderPricingDetailsOfThatCustomer() {
        webModel.getCompanyMenuPage().verifyNewlyAddedTariffCategory();
        webModel.getDashBoardPage().logOut();
    }


    @When("^I create tariff under different \"([^\"]*)\"$")
    public void iCreateTariffUnderDifferent(String tariff_types) {
        webModel.getCompanyMenuPage().addTariffWithTariffTypes(tariff_types);
    }

    @Then("^that particular tariff should be available for selection in \"([^\"]*)\" under its tariff_type$")
    public void thatParticularTariffShouldBeAvailableForSelectionInUnderItsTariff_type(String tariff_search) throws InterruptedException {
        webModel.getCompanyMenuPage().searchAndAssertNewlyAddedTariffType(tariff_search);
        webModel.getDashBoardPage().logOut();
    }


    @When("^I create a new service charge type$")
    public void iCreateANewServiceChargeType() throws InterruptedException {
        webModel.getCompanyMenuPage().createNewServiceChargeType();
    }

    @Then("^I should be able to access it under service charge drop downs in one off and recurring charge types$")
    public void iShouldBeAbleToAccessItUnderServiceChargeDropDownsInOneOffAndRecurringChargeTypes() {
        webModel.getCompanyMenuPage().verifyServiceChargeTypes();
        webModel.getDashBoardPage().logOut();
    }


    @When("^I create a new billing package under package manager$")
    public void iCreateANewBillingPackageUnderPackageManager() {
        webModel.getCompanyMenuPage().createBillingPackage();
    }

    @Then("^I should be able to access it under package drop down in billing details$")
    public void iShouldBeAbleToAccessItUnderPackageDropDownInBillingDetails() {
        webModel.getCompanyMenuPage().verifyBillingPackage();
        webModel.getDashBoardPage().logOut();
    }


    @When("^I create a new free minutes plan with required details$")
    public void iCreateANewFreeMinutesPlanWithRequiredDetails() {
        webModel.getCompanyMenuPage().createNewFreeMinutePlan();
    }

    @Then("^The plan should be available for selection under package and billing details$")
    public void thePlanShouldBeAvailableForSelectionUnderPackageAndBillingDetails() {
        webModel.getCompanyMenuPage().verifyFreeMinutePlan();
        webModel.getDashBoardPage().logOut();

    }


    @When("^I create a new charge_group as per the designation$")
    public void iCreateANewCharge_groupAsPerTheDesignation() throws InterruptedException {
        webModel.getCompanyMenuPage().createChargeGroup();


    }


    @Then("^I should be able to search for it and find it under specified designation$")
    public void iShouldBeAbleToSearchForItAndFindItUnderSpecifiedDesignation() {
        webModel.getCompanyMenuPage().verifyChargeGroup();
        webModel.getDashBoardPage().logOut();

    }


}




