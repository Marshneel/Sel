package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;


/**
 * Created by rajeshg on 12/09/2016.
 *///
public class NA39_BDD_Scenarios_Creation_Of_User_Agent_Reseller_permissions_stepdefs {

    WebModel webModel = new WebModel();


    @And("^have added a new business customer with required contact type$")
    public void haveAddedANewBusinessCustomerWithRequiredContactType() throws
            InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        //passing SQL query to correct the attributes of agent and reseller
        webModel.getUtils().sqlExeQuery("Portal", "test01-sql01", "nxtiere2e", "update company set is_customer = 1, is_agent = 0, is_reseller = 1 where id = 109");
        webModel.getUtils().sqlExeQuery("Portal", "test01-sql01", "nxtiere2e", "update company set is_customer = 0, is_agent = 1, is_reseller = 0 where id = 108");
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getDashBoardPage().load_endCustomers();
        webModel.getNewBusinessCustomerPage().clickAddNewCustomerButton();
        webModel.getNewBusinessCustomerPage().companyInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().createContactType();
        webModel.getNewBusinessCustomerPage().addSiteInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().addSiteContactInfoForNewBusinessCustomer();
    }

    @And("^have created a new agent permission group$")
    public void haveCreatedANewAgentPermissionGroup() throws InterruptedException {
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().loadPermissionGroups();
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
        webModel.getSettingsPage().loadLoginUsers();
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
        System.out.println("NA39a completed");
    }

    @And("^Have created a new CP permission group under settings$")
    public void haveCreatedANewCPPermissionGroupUnderSettings() throws InterruptedException {
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().loadPermissionGroups();
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
        webModel.getSettingsPage().loadLoginUsers();
        webModel.getSettingsPage().clickCPUserTab();
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
        System.out.println("NA39b completed");
    }

    @Given("^I am logged in as agent$")
    public void iAmLoggedInAsAgent() throws InterruptedException {
        webModel.getLoginPage().loginAsAgent();
    }
    @When("^I access create Quote tab for agent$")
    public void iAccessCreateQuoteTabForAgent() throws InterruptedException {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().loadAllOrders(true,false);
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().onQuotePage();
    }



    @Then("^All required fields pertaining to an agent should be visible on the create quote window$")
    public void allRequiredFieldsPertainingToAnAgentShouldBeVisibleOnTheCreateQuoteWindow() throws
            InterruptedException {
        webModel.getOrdersManagerPage().assertQuotePageForAgentandReseller();
    }

    @And("^Only the quotes created by me and the ones created for my company should be visible$")
    public void onlyTheQuotesCreatedByMeAndTheOnesCreatedForMyCompanyShouldBeVisible() throws InterruptedException {
        webModel.getOrdersManagerPage().assertQuote();
        webModel.getOrdersManagerPage().checkQuotesForAgent();
        System.out.println("NA39c completed");
    }

    @Given("^I am logged in as reseller$")
    public void iAmLoggedInAsReseller() throws InterruptedException {
        webModel.getLoginPage().loginAsReseller();
    }


    @Then("^All required fields pertaining to a reseller should be visible on the create quote window$")
    public void allRequiredFieldsPertainingToAResellerShouldBeVisibleOnTheCreateQuoteWindow() throws
            InterruptedException {
        webModel.getOrdersManagerPage().assertQuotePageForAgentandReseller();
    }

    @And("^Only the quotes created for companies under my contact list should be visible$")
    public void onlyTheQuotesCreatedForCompaniesUnderMyContactListShouldBeVisible() throws InterruptedException {
        webModel.getOrdersManagerPage().assertQuoteForReseller();
        webModel.getOrdersManagerPage().checkQuoteForReseller();
        System.out.println("NA39d completed");


    }

    @When("^I access create Quote tab for Reseller$")
    public void iAccessCreateQuoteTabForReseller() throws InterruptedException {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().loadAllOrders(true,false);
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().onQuotePageForReseller();

    }

    @And("^Only the quotes created by me and the ones created for companies under my contact list should be visible$")
    public void onlyTheQuotesCreatedByMeAndTheOnesCreatedForCompaniesUnderMyContactListShouldBeVisible() throws
            InterruptedException {
        webModel.getOrdersManagerPage().assertQuote();
        webModel.getOrdersManagerPage().checkQuoteForReseller();
    }

    @Given("^I am logged in as CP$")
    public void iAmLoggedInAsCP() throws InterruptedException, AWTException {
        webModel.getLoginPage().doLogin();
    }


    @Then("^All required fields pertaining to a CP should be visible on the create quote window$")
    public void allRequiredFieldsPertainingToACPShouldBeVisibleOnTheCreateQuoteWindow() throws InterruptedException {
        webModel.getOrdersManagerPage().assertCPQuotePage();
    }

    @And("^all the quotes including that of the resellers and agents should be visible$")
    public void allTheQuotesIncludingThatOfTheResellersAndAgentsShouldBeVisible() throws InterruptedException {
        webModel.getOrdersManagerPage().assertQuote();
        webModel.getOrdersManagerPage().checkQuotesForCP();
        webModel.getUtils().checkPoint("NA39e completed");
    }


    @When("^i navigate to the add customer page and click both agent and reseller$")
    public void iNavigateToTheAddCustomerPageAndClickBothAgentAndReseller() throws InterruptedException {
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getDashBoardPage().load_endCustomers();
        webModel.getNewBusinessCustomerPage().clickAddNewCustomerButton();
        webModel.getNewBusinessCustomerPage().companyInfoForNewBusinessCustomer();

    }

    @Then("^A validation message should be thrown$")
    public void aValidationMessageShouldBeThrown() {
        webModel.getNewBusinessCustomerPage().validationMessage_whenAgentAndResellerCheckedIn();

    }



    @When("^I access create Quote tab for CP$")
    public void iAccessCreateQuoteTabForCP() throws InterruptedException {
                webModel.getDashBoardPage().clickOrderManagerButton();
                webModel.getDashBoardPage().loadAllOrders(false,true);
                webModel.getOrdersManagerPage().clickCreateQuoteButton();
                webModel.getOrdersManagerPage().onQuotePage();
        }

    }

