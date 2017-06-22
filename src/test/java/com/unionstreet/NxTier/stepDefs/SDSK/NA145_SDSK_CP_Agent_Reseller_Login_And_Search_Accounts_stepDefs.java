package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 30/05/2017.
 */
public class NA145_SDSK_CP_Agent_Reseller_Login_And_Search_Accounts_stepDefs {
    WebModel webModel = new WebModel();


    @And("^have created a business customer and assigned required data$")
    public void haveCreatedABusinessCustomerAndAssignedRequiredData() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getServiceDeskPage().grantingServiceDeskAccess();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03012345678'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03087654321'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03012348765'");
        webModel.getCompanyMenuPage().addCLIs("business customer created by CP", "03012345678");
        webModel.getUtils().switchToPreviousWindow(0);
        webModel.getCompanyMenuPage().addCLIs("business customer agent assigned", "03087654321");
        webModel.getUtils().switchToPreviousWindow(0);
        webModel.getCompanyMenuPage().addCLIs("site called business customer", "03012348765");
        webModel.getUtils().switchToPreviousWindow(0);


    }

    @When("^I am on the service desk page$")
    public void iAmOnTheServiceDeskPage() throws InterruptedException, SQLException, ClassNotFoundException, UnsupportedEncodingException {
        webModel.getDashBoardPage().loadServiceDesk("/nxtiere2e");
        webModel.getServiceDeskPage().assertTextOnServiceDesk();
    }

    @Then("^I should be able search by Account name, Account number & CLI and get all the relevant details in the CP search$")
    public void iShouldBeAbleSearchByAccountNameAccountNumberCLIAndGetAllTheRelevantDetailsInTheCPSearch() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {

        ////search by account name///////////////////////////////////////
        //search for CP and agent by account name
        webModel.getServiceDeskPage().searchByAccountName("business customer");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("business customer agent assigned");
        webModel.getServiceDeskPage().searchResultsForServiceDesk("business customer created by CP");
        //search for reseller by account name
        webModel.getServiceDeskPage().searchByAccountName("reseller");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("site called business customer");
        ////search by short name////////////////////////////////////////////
        //search for CP by short name
        webModel.getServiceDeskPage().searchByShortName("CP");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("business customer created by CP");
        //research results for agent by short name
        webModel.getServiceDeskPage().searchByShortName("agent");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("business customer agent assigned");
        //search for reseller by short name
        webModel.getServiceDeskPage().searchByShortName("site called business customer");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("site called business customer");
        ///search by CLI//////////////////////////////////////////////////
        //search for CP by CLI
        webModel.getServiceDeskPage().searchByCLI("03012345678");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("business customer created by CP");
        //search for agent by CLI
        webModel.getServiceDeskPage().searchByCLI("03087654321");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("business customer agent assigned");
        //search for reseller by CLI
        webModel.getServiceDeskPage().searchByCLI("03012348765");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("site called business customer");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03012345678'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03087654321'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03012348765'");
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("^I am logged in as agent and CP has already assigned me a business customer$")
    public void iAmLoggedInAsAgentAndCPHasAlreadyAssignedMeABusinessCustomer() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsCP();
        haveCreatedABusinessCustomerAndAssignedRequiredData();
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsAgent();
    }

    @When("^I am on the service desk page as an agent$")
    public void iAmOnTheServiceDeskPageAsAnAgent() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getDashBoardPage().loadServiceDesk("/nxtiere2e");
        webModel.getServiceDeskPage().assertTextOnServiceDesk();
    }

    @Then("^I should be able search by Account name, Account number & CLI and get all the relevant details in the agent search$")
    public void iShouldBeAbleSearchByAccountNameAccountNumberCLIAndGetAllTheRelevantDetailsInTheAgentSearch() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {

        ////search by account name///////////////////////////////////////
        //search for CP and agent by account name
        webModel.getServiceDeskPage().searchByAccountName("business customer");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("business customer agent assigned");
        webModel.getServiceDeskPage().assertNotFound("business customer created by CP");
        //search for reseller by account name
        webModel.getServiceDeskPage().searchByAccountName("reseller");
        //result
        webModel.getServiceDeskPage().assertNotFound("site called business customer");

        ////search by short name////////////////////////////////////////////
        //search for CP by short name
        webModel.getServiceDeskPage().searchByShortName("CP");
        //results
        webModel.getServiceDeskPage().assertNotFound("business customer created by CP");
        //research results for agent by short name
        webModel.getServiceDeskPage().searchByShortName("agent");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("business customer agent assigned");
        //search for reseller by short name
        webModel.getServiceDeskPage().searchByShortName("site called business customer");
        //results
        webModel.getServiceDeskPage().assertNotFound("site called business customer");
        ///search by CLI//////////////////////////////////////////////////
        //search for CP by CLI
        webModel.getServiceDeskPage().searchByCLI("03012345678");
        //results
        webModel.getServiceDeskPage().assertNotFound("business customer created by CP");
        //search for agent by CLI
        webModel.getServiceDeskPage().searchByCLI("03087654321");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("business customer agent assigned");
        //search for reseller by CLI
        webModel.getServiceDeskPage().searchByCLI("03012348765");
        //results
        webModel.getServiceDeskPage().assertNotFound("site called business customer");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03012345678'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03087654321'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03012348765'");
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("^I am logged in a reseller and CP has already created a site under me$")
    public void iAmLoggedInAResellerAndCPHasAlreadyCreatedASiteUnderMe() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getLoginPage().loginAsCP();
        haveCreatedABusinessCustomerAndAssignedRequiredData();
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsReseller();
    }

    @When("^I am on the service desk page as a reseller$")
    public void iAmOnTheServiceDeskPageAsAReseller() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getDashBoardPage().loadServiceDesk("/nxtiere2e");
        webModel.getServiceDeskPage().assertTextOnServiceDesk();

    }

    @Then("^I should be able search by Account name, Account number & CLI and get all the relevant details in the reseller search$")
    public void iShouldBeAbleSearchByAccountNameAccountNumberCLIAndGetAllTheRelevantDetailsInTheResellerSearch() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        ////search by account name///////////////////////////////////////
        //search for CP, agent and reseller by account name
        webModel.getServiceDeskPage().searchByAccountName("business customer");
        //results
        webModel.getServiceDeskPage().assertNotFound("business customer agent assigned");
        webModel.getServiceDeskPage().assertNotFound("business customer created by CP");
        webModel.getServiceDeskPage().searchResultsForServiceDesk("site called business customer");
        ////search by short name////////////////////////////////////////////
        //search for CP by short name
        webModel.getServiceDeskPage().searchByShortName("CP");
        //results
        webModel.getServiceDeskPage().assertNotFound("business customer created by CP");
        //research results for agent by short name
        webModel.getServiceDeskPage().searchByShortName("agent");
        //results
        webModel.getServiceDeskPage().assertNotFound("business customer agent assigned");
        //search for reseller by short name
        webModel.getServiceDeskPage().searchByShortName("site called business customer");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("site called business customer");
        ///search by CLI//////////////////////////////////////////////////
        //search for CP by CLI
        webModel.getServiceDeskPage().searchByCLI("03012345678");
        //results
        webModel.getServiceDeskPage().assertNotFound("business customer created by CP");
        //search for agent by CLI
        webModel.getServiceDeskPage().searchByCLI("03087654321");
        //results
        webModel.getServiceDeskPage().assertNotFound("business customer agent assigned");
        //search for reseller by CLI
        webModel.getServiceDeskPage().searchByCLI("03012348765");
        //results
        webModel.getServiceDeskPage().searchResultsForServiceDesk("site called business customer");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03012345678'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03087654321'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "delete from CustomerCLIBase where CLI='03012348765'");
    }


    @Given("^I am logged in as CP and assign service desk permissions$")
    public void iAmLoggedInAsCPAndAssignServiceDeskPermissions() throws InterruptedException, SQLException, UnsupportedEncodingException, ClassNotFoundException {
        webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsCP();
       webModel.getServiceDeskPage().grantingServiceDeskAccess();
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsCP();

    }

}
