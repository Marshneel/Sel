package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by rajeshg on 06/10/2016.
 */
public class NA52_Accessing_controls_In_Services_with_different_permissions_CP_Agent_Reseller_stepDefs {

    WebModel webModel=new WebModel();
    NA44_Agent_Login_stepDefs na44 = new NA44_Agent_Login_stepDefs();

    @And("^create a new quote and access a service$")
    public void createANewQuoteAndAccessAService() {
        na44.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().createQuote();
        webModel.getOrdersManagerPage().searchQuoteByBcRN();
        webModel.getOrdersManagerPage().clickOnQuoteID();
//        TODO
        webModel.getAddServicePage().addServiceToQuote("permissions");
    }

    @Then("^the CP only control should be visible and accessible$")
    public void theCPOnlyControlShouldBeVisibleAndAccessible() {
        webModel.getOrdersManagerPage().assertCPonlyCheckBoxPresentAndAccessible();

    }

    @Then("^the CP only control should be invisible$")
    public void theCPOnlyControlShouldBeInvisible() {
        webModel.getOrdersManagerPage().assertCPonlyCheckBoxIsAbsent();
    }
}