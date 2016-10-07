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
    WebModel webModel=new WebModel();
    NA54_JavaMethodToRunSQLScriptsFromSeleniumEnvironment_stepDefs na_54_CreateAjavaMethodToRunSQLScriptsFromSeleniumEnvironment_stepDefs=new NA54_JavaMethodToRunSQLScriptsFromSeleniumEnvironment_stepDefs();
    @And("^I create a new quote and add a service with addOnActivation charge$")
    public void iCreateANewQuoteAndAddAServiceWithAddOnActivationCharge() throws InterruptedException {
        na_54_CreateAjavaMethodToRunSQLScriptsFromSeleniumEnvironment_stepDefs.createANewQuoteAndAddAServiceThatContainsAServiceCharge();
        webModel.getDashBoardPage().addServiceToQuote("addOnActivationCharge");
        webModel.getDashBoardPage().savingQuoteAndExtractingOrderServiceID();
    }

    @When("^I run SQL query$")
    public void iRunSQLQuery() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlQuery("select SellPrice from Order_Services_Products where OrderServicesID="+webModel.getDashBoardPage().getServiceOrderID()+"");
    }

    @Then("^The charge should be visible in the back end$")
    public void theChargeShouldBeVisibleInTheBackEnd() throws SQLException {
        webModel.getUtils().assertThereIsCharge("SellPrice",20);
    }
}
