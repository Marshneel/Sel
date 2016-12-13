package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/**
 * Created by rajeshg on 12/09/2016.
 *///
public class NA39_BDD_Scenarios_Creation_Of_User_Agent_Reseller_permissions_stepdefs {

    WebModel webModel = new WebModel();


    @And("^have added a new business customer with required contact type$")
    public void haveAddedANewBusinessCustomerWithRequiredContactType() {
        webModel.getNewBusinessCustomerPage().clickContactManagerButton();
        webModel.getNewBusinessCustomerPage().clickAddNewCustomerButton();
        webModel.getNewBusinessCustomerPage().companyInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().addSiteInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().addSiteContactInfoForNewBusinessCustomer();
    }

    @And("^have created a new agent permission group$")
    public void haveCreatedANewAgentPermissionGroup() {
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().clickAddPermissionsButton();
        webModel.getSettingsPage().addAgentPermissionGroups_General();
        webModel.getSettingsPage().addPermissionGroups_Configuration();
        webModel.getSettingsPage().addPermissionGroups_ContactManager();
        webModel.getSettingsPage().addPermissionGroups_ImportManager();
        webModel.getSettingsPage().addPermissionGroups_InvoiceManager();
        webModel.getSettingsPage().addPermissionGroups_OrdersManager();
        webModel.getSettingsPage().addPermissionGroups_Reports();
        webModel.getSettingsPage().addPermissionGroups_RevenueAssurance();
        webModel.getSettingsPage().addPermissionGroups_Settings();
        webModel.getSettingsPage().addPermissionGroups_WorkPlace();
        webModel.getSettingsPage().saveAndCloseAddPermissions();
    }

    @When("^I wish to create agent contact with valid login credentials$")
    public void iWishToCreateAgentContactWithValidLoginCredentials() {
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().clickLoginUsers();
        webModel.getSettingsPage().clickAddLoginUsersButton();
        webModel.getSettingsPage().agentUserSelectCompany();
        webModel.getSettingsPage().agentUserAddContactDetails();
    }

    @Then("^the agent permission group should be available for selection under drop down under agentUser creation$")
    public void theAgentPermissionGroupShouldBeAvailableForSelectionUnderDropDownUnderAgentUserCreation() {
        webModel.getSettingsPage().agentUserAddLoginDetails();
    }

    @And("^I should be able to login with agent credentials$")
    public void iShouldBeAbleToLoginWithAgentCredentials() throws InterruptedException {
        webModel.getSettingsPage().loginAsAgent();
    }

    @When("^I wish to create a business reseller contact with valid login credentials$")
    public void iWishToCreateABusinessResellerContactWithValidLoginCredentials() {
        webModel.getCompanyMenuPage().accessCompanyMenu();
        webModel.getSettingsPage().clickCompanyContacts();
        webModel.getSettingsPage().addNewCompanyContactButton();
        webModel.getSettingsPage().agentUserAddContactDetails();
    }

    @Then("^the agent permission group should be available for selection under drop down under business reseller contact creation$")
    public void theAgentPermissionGroupShouldBeAvailableForSelectionUnderDropDownUnderBusinessResellerContactCreation() {
        webModel.getSettingsPage().agentUserAddLoginDetails();

    }

    @And("^I should be able to login with reseller credentials$")
    public void iShouldBeAbleToLoginWithResellerCredentials() {
        webModel.getSettingsPage().loginAsReseller();
        webModel.getDashBoardPage().logOut();
    }

    @And("^Have created a new CP permission group under settings$")
    public void haveCreatedANewCPPermissionGroupUnderSettings() {
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().clickAddPermissionsButton();
        webModel.getSettingsPage().addCPPermissionGroups_General();
        webModel.getSettingsPage().addPermissionGroups_Configuration();
        webModel.getSettingsPage().addPermissionGroups_ContactManager();
        webModel.getSettingsPage().addPermissionGroups_ImportManager();
        webModel.getSettingsPage().addPermissionGroups_InvoiceManager();
        webModel.getSettingsPage().addPermissionGroups_OrdersManager();
        webModel.getSettingsPage().addPermissionGroups_Reports();
        webModel.getSettingsPage().addPermissionGroups_RevenueAssurance();
        webModel.getSettingsPage().addPermissionGroups_Settings();
        webModel.getSettingsPage().addPermissionGroups_WorkPlace();
        webModel.getSettingsPage().saveAndCloseAddPermissions();
    }

    @When("^I wish to create new CP under login users sub-menu$")
    public void iWishToCreateNewCPUnderLoginUsersSubMenu() {
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().clickLoginUsers();
        webModel.getSettingsPage().clickCPUserTab();
        webModel.getSettingsPage().clickAddLoginUsersButton();
        webModel.getSettingsPage().addCPloginUserSelectCompanyandSite();
        webModel.getSettingsPage().createCPUserAddContactDetails();
    }

    @Then("^the CP permission should be available for selection under drop down during the CP creation$")
    public void theCPPermissionShouldBeAvailableForSelectionUnderDropDownDuringTheCPCreation() {
        webModel.getSettingsPage().createCPUserAddLoginDetails();
    }

    @And("^I should be able to login with CP credentials$")
    public void iShouldBeAbleToLoginWithCPCredentials() {
        webModel.getSettingsPage().loginAsCpUser();
        webModel.getDashBoardPage().logOut();
    }

    @Given("^I am logged in as agent$")
    public void iAmLoggedInAsAgent() {
        webModel.getLoginPage().loginAsAgent();
    }

    @When("^I access create Quote tab$")
    public void iAccessCreateQuoteTab() throws InterruptedException {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().onQuotePage();
    }

    @Then("^All required fields pertaining to an agent should be visible on the create quote window$")
    public void allRequiredFieldsPertainingToAnAgentShouldBeVisibleOnTheCreateQuoteWindow() throws InterruptedException {
        webModel.getOrdersManagerPage().assertQuotePageForAgentandReseller();
    }

    @And("^Only the quotes created by me and the ones created for my company should be visible$")
    public void onlyTheQuotesCreatedByMeAndTheOnesCreatedForMyCompanyShouldBeVisible() throws InterruptedException {
        webModel.getOrdersManagerPage().assertQuote();
       webModel.getOrdersManagerPage().checkQuotesForAgent();

    }

    @Given("^I am logged in as reseller$")
    public void iAmLoggedInAsReseller() {
        webModel.getLoginPage().loginAsReseller();
    }


    @Then("^All required fields pertaining to a reseller should be visible on the create quote window$")
    public void allRequiredFieldsPertainingToAResellerShouldBeVisibleOnTheCreateQuoteWindow() throws InterruptedException {
        webModel.getOrdersManagerPage().assertQuotePageForAgentandReseller();
    }

    @And("^Only the quotes created by me and the ones created for companies under my contact list should be visible$")
    public void onlyTheQuotesCreatedByMeAndTheOnesCreatedForCompaniesUnderMyContactListShouldBeVisible() throws InterruptedException {
        webModel.getOrdersManagerPage().assertQuote();
        webModel.getOrdersManagerPage().checkQuoteForReseller();

}

    @Given("^I am logged in as CP$")
    public void iAmLoggedInAsCP() {
        webModel.getLoginPage().loginAsCP();
    }


    @Then("^All required fields pertaining to a CP should be visible on the create quote window$")
    public void allRequiredFieldsPertainingToACPShouldBeVisibleOnTheCreateQuoteWindow() throws InterruptedException {
        webModel.getOrdersManagerPage().assertCPQuotePage();
    }

    @And("^all the quotes including that of the resellers and agents should be visible$")
    public void allTheQuotesIncludingThatOfTheResellersAndAgentsShouldBeVisible() throws InterruptedException {
        webModel.getOrdersManagerPage().assertQuote();
        webModel.getOrdersManagerPage().checkQuotesForCP();

    }
}
