package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



/**
 * Created by rajeshg on 12/09/2016.
 */
public class WLR3_permissions_stepdefs {
    WebModel webModel = new WebModel();


    @And("^have added a new business customer with required contact type$")
    public void haveAddedANewBusinessCustomerWithRequiredContactType() throws InterruptedException {
        webModel.getNewBusinessCustomerPage().clickContactManagerButton();
        webModel.getNewBusinessCustomerPage().onAddNewBusinessCustomerPage();
        webModel.getNewBusinessCustomerPage().companyInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().siteInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().siteContactInfoForNewBusinessCustomer();
    }

    @And("^have created a new agent permission group$")
    public void haveCreatedANewAgentPermissionGroup() throws InterruptedException {
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
    public void iWishToCreateAgentContactWithValidLoginCredentials() throws InterruptedException {
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().clickLoginUsers();
        webModel.getSettingsPage().clickAddLoginUsersButton();
        webModel.getSettingsPage().agentUserSelectCompany();
        webModel.getSettingsPage().agentUserAddContactDetails();
    }

    @Then("^the agent permission group should be available for selection under drop down under agentUser creation$")
    public void theAgentPermissionGroupShouldBeAvailableForSelectionUnderDropDownUnderAgentUserCreation() throws InterruptedException {
        webModel.getSettingsPage().agentUserAddLoginDetails();
    }


    @And("^I should be able to login with agent credentials$")
    public void iShouldBeAbleToLoginWithAgentCredentials() throws InterruptedException {
        webModel.getSettingsPage().loginAsAgent();
        webModel.getDashBoardPage().logOut();

    }

    @When("^I wish to create a business reseller contact with valid login credentials$")
    public void iWishToCreateABusinessResellerContactWithValidLoginCredentials() throws InterruptedException {
        webModel.getCompanyMenuPage().accessCompanyMenu();
        webModel.getSettingsPage().clickCompanyContacts();
        webModel.getSettingsPage().addNewCompanyContactButton();
        webModel.getSettingsPage().agentUserAddContactDetails();

    }

    @Then("^the agent permission group should be available for selection under drop down under business reseller contact creation$")
    public void theAgentPermissionGroupShouldBeAvailableForSelectionUnderDropDownUnderBusinessResellerContactCreation() throws InterruptedException {
        webModel.getSettingsPage().agentUserAddLoginDetails();
    }

    @And("^I should be able to login with reseller credentials$")
    public void iShouldBeAbleToLoginWithResellerCredentials() throws Throwable {
        webModel.getSettingsPage().loginAsReseller();
        webModel.getDashBoardPage().logOut();

    }

    @And("^Have created a new CP permission group under settings$")
    public void haveCreatedANewCPPermissionGroupUnderSettings() throws InterruptedException {
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
    public void iWishToCreateNewCPUnderLoginUsersSubMenu() throws InterruptedException {
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().clickLoginUsers();
        webModel.getSettingsPage().clickAddLoginUsersButton();
        webModel.getSettingsPage().addCPloginUserSelectCompanyandSite();
        webModel.getSettingsPage().createCPUserAddContactDetails();
    }

    @Then("^the CP permission should be available for selection under drop down during the CP creation$")
    public void theCPPermissionShouldBeAvailableForSelectionUnderDropDownDuringTheCPCreation() throws InterruptedException {
        webModel.getSettingsPage().createCPUserAddLoginDetails();
    }

    @And("^I should be able to login with CP credentials$")
    public void iShouldBeAbleToLoginWithCPCredentials() throws InterruptedException {
        webModel.getSettingsPage().loginAsCpUser();
        webModel.getDashBoardPage().logOut();
    }


    @Given("^I am logged in as an agent$")
    public void iAmLoggedInAsAnAgent() throws InterruptedException {
        webModel.getLoginPage().loginAsAgent();
    }

    @When("^I  access agent create Quote tab$")
    public void iAccessAgentCreateQuoteTab() {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().clickCreateQuoteButton();
        webModel.getDashBoardPage().onQuotePage();

    }

    @Then("^All required fields pertaining to an agent should be visible on the create quote window$")
    public void allRequiredFieldsPertainingToAnAgentShouldBeVisibleOnTheCreateQuoteWindow() throws InterruptedException {
        webModel.getDashBoardPage().assertQuotePageForAgentandReseller();

    }

    @And("^Only the quotes created by me and the ones created for my company should be visible$")
    public void onlyTheQuotesCreatedByMeAndTheOnesCreatedForMyCompanyShouldBeVisible() throws InterruptedException {
        webModel.getDashBoardPage().assertQuote();
        webModel.getDashBoardPage().checkQuotesForAgent();
        webModel.getDashBoardPage().logOut();
    }


    @Given("^I am logged in as a reseller$")
    public void iAmLoggedInAsAReseller() {
        webModel.getLoginPage().loginAsReseller();
    }

    @When("^I  access reseller create quote tab$")
    public void iAccessResellerCreateQuoteTab() {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().clickCreateQuoteButton();
        webModel.getDashBoardPage().onQuotePage();

    }

    @Then("^All required fields pertaining to a reseller should be visible on the create quote window$")
    public void allRequiredFieldsPertainingToAResellerShouldBeVisibleOnTheCreateQuoteWindow() throws InterruptedException {
        webModel.getDashBoardPage().assertQuotePageForAgentandReseller();

    }

    @And("^Only the quotes created by me and the ones created for companies under my contact list should be visible$")
    public void onlyTheQuotesCreatedByMeAndTheOnesCreatedForCompaniesUnderMyContactListShouldBeVisible() throws InterruptedException {
        webModel.getDashBoardPage().assertQuote();
        webModel.getDashBoardPage().checkQuoteForReseller();
        webModel.getDashBoardPage().logOut();
    }

    @Given("^I am logged in as a CP$")
    public void iAmLoggedInAsACP() {
        webModel.getLoginPage().LoginAsCP();
    }

    @When("^I  access create Quote tab for CP$")
    public void iAccessCreateQuoteTabForCP() throws InterruptedException {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().clickCreateQuoteButton();
        webModel.getDashBoardPage().onQuotePage();
    }

    @Then("^All required fields pertaining to a CP should be visible on the create quote window$")
    public void allRequiredFieldsPertainingToACPShouldBeVisibleOnTheCreateQuoteWindow() throws InterruptedException {
        webModel.getDashBoardPage().assertCPQuotePage();

    }

    @And("^all the quotes including that of the resellers and agents should be visible$")
    public void allTheQuotesIncludingThatOfTheResellersAndAgentsShouldBeVisible() throws InterruptedException {
        webModel.getDashBoardPage().assertQuote();
        webModel.getDashBoardPage().checkQuotesForCP();
        webModel.getDashBoardPage().logOut();
    }



}
