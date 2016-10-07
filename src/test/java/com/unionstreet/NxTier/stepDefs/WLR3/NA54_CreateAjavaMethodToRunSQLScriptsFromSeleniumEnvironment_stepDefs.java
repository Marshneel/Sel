package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by rajeshg on 03/10/2016.
 */
public class NA54_CreateAjavaMethodToRunSQLScriptsFromSeleniumEnvironment_stepDefs {
    WebModel webModel = new WebModel();
    NA44_Agent_Login_stepDefs na44_agent_login_stepDefs = new NA44_Agent_Login_stepDefs();

    @And("^create a new quote and add a service that contains a service charge$")
    public void createANewQuoteAndAddAServiceThatContainsAServiceCharge() throws InterruptedException {
        na44_agent_login_stepDefs.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().clickCreateQuoteButton();
        webModel.getDashBoardPage().createQuote();
        webModel.getDashBoardPage().searchQuoteByBcRN();
        webModel.getDashBoardPage().clickOnQuoteID();
    }

    @When("^I add the charge$")
    public void iAddTheCharge() throws InterruptedException {
        webModel.getDashBoardPage().addingChargeOnTheQuote("serviceCharges");

    }

    @And("^query the database$")
    public void queryTheDatabase() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlQuery("select SellPrice from Order_Services_Products where OrderServicesID=" + webModel.getUtils().id + "");
    }

    @Then("^the charge should be visible$")
    public void theChargeShouldBeVisible() throws SQLException {
        webModel.getUtils().assertThereIsCharge("SellPrice", 600);
    }

    @And("^upon removing the charge the charge should disappear from the backend$")
    public void uponRemovingTheChargeTheChargeShouldDisappearFromTheBackend() throws InterruptedException, SQLException {
        webModel.getDashBoardPage().removingChargeOnTheQuote();
        webModel.getUtils().assertThereIsNoCharge();

    }
}
