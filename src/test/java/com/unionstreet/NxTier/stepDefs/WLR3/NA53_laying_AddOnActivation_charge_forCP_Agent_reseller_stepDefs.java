package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by rajeshg on 06/10/2016.
 */
public class NA53_laying_AddOnActivation_charge_forCP_Agent_reseller_stepDefs {
    WebModel webModel = new WebModel();

    NA44_Agent_Login_stepDefs na44 = new NA44_Agent_Login_stepDefs();

    @And("^I create a new quote and add a service with addOnActivation charge$")
    public void iCreateANewQuoteAndAddAServiceWithAddOnActivationCharge() throws InterruptedException {
        na44.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().createQuote();
        webModel.getOrdersManagerPage().clickOnQuoteID();
//        TODO
        webModel.getAddServicePage().addServiceToQuote("addOnActivationCharge");
        webModel.getOrdersManagerPage().savingQuoteAndExtractingOrderServiceID();
    }

    @When("^I run SQL query$")
    public void iRunSQLQuery() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlQuery("Nxtiere2e", "autotest", "test01-sql01", "nxtiere2e", "select SellPrice from Order_Services_Products where OrderServicesID=" + webModel.getOrdersManagerPage().getServiceOrderID() + "");
    }

    @Then("^The charge should be visible in the back end$")
    public void theChargeShouldBeVisibleInTheBackEnd() throws SQLException {
        webModel.getOrdersManagerPage().assertThereIsCharge("SellPrice", 80.00);
        webModel.getOrdersManagerPage().assertChargeOnGUI("£80.00");
    }


}
