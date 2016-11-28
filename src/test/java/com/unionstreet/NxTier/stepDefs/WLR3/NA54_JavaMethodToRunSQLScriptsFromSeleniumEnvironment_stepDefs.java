package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLException;

/**
 * Created by rajeshg on 03/10/2016.
 */
public class NA54_JavaMethodToRunSQLScriptsFromSeleniumEnvironment_stepDefs {

    WebModel webModel = new WebModel();
    NA44_Agent_Login_stepDefs na44 = new NA44_Agent_Login_stepDefs();

    @And("^create a new quote and add a service that contains a service charge$")
    public void createANewQuoteAndAddAServiceThatContainsAServiceCharge() {
        na44.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().createQuote();
        webModel.getOrdersManagerPage().searchQuoteByBcRN();
        webModel.getOrdersManagerPage().clickOnQuoteID();
    }

    @When("^I add the charge$")
    public void iAddTheCharge() {
//        TODO
        webModel.getAddServicePage().addingChargeOnTheQuote("serviceCharges");
    }

    @And("^query the database$")
    public void queryTheDatabase() {
        webModel.getUtils().sqlQuery("Nxtiere2e","autotest","test01-sql01","nxtiere2e","select sum(SellPrice) SellPrice from Order_Services_Products where OrderServicesID=" + webModel.getOrdersManagerPage().getServiceOrderID() + "");
    }

    @Then("^the charge should be visible$")
    public void theChargeShouldBeVisible() throws SQLException {
        webModel.getOrdersManagerPage().assertThereIsCharge("SellPrice",80.00);
        webModel.getOrdersManagerPage().assertChargeOnGUI("£80.00");
    }

    @And("^upon removing the charge the charge should disappear from the backend$")
    public void uponRemovingTheChargeTheChargeShouldDisappearFromTheBackend() {
        webModel.getAddServicePage().removingChargeOnTheQuote();
        webModel.getOrdersManagerPage().assertChargeOnGUI("£0.00");
        webModel.getUtils().sqlQuery("Nxtiere2e","autotest","test01-sql01","nxtiere2e","select SellPrice from Order_Services_Products where OrderServicesID=" + webModel.getOrdersManagerPage().getServiceOrderID() + "");
        webModel.getOrdersManagerPage().assertThereIsNoCharge();
    }
}
