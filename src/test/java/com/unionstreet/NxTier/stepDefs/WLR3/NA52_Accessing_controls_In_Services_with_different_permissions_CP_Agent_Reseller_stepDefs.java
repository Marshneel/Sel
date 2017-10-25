package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.sql.SQLException;

/**
 * Created by rajeshg on 06/10/2016.
 */
public class NA52_Accessing_controls_In_Services_with_different_permissions_CP_Agent_Reseller_stepDefs {

    WebModel webModel = new WebModel();
    NA44_Agent_Login_stepDefs na44 = new NA44_Agent_Login_stepDefs();

    @And("^create a new quote and access a service for CP$")
    public void createANewQuoteAndAccessAServiceForCP() throws InterruptedException, SQLException {
        na44.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().loadAllOrders(false,true);
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().createQuote();
        webModel.getOrdersManagerPage().loadOrdersManagerAndClickOnQuoteID(webModel.getNewBusinessCustomerPage().RanName);
//        TODO
        webModel.getAddServicePage().addServiceToQuote("permissions");
    }

    @Then("^the CP only control should be visible and accessible$")
    public void theCPOnlyControlShouldBeVisibleAndAccessible() {
        webModel.getNxTierServicesPage().assertCPonlyCheckBoxPresentAndAccessible();
        System.out.println("NA52a done");
    }

    @And("^create a new quote and access a service for reseller$")
    public void createANewQuoteAndAccessAServiceForReseller() throws InterruptedException, SQLException {
        webModel.getOrdersManagerPage().loadOrdersManagerAndClickOnQuoteID(webModel.getNewBusinessCustomerPage().Reseller_RanName);
//        TODO
        webModel.getAddServicePage().addServiceToQuote("permissions");
    }


    @Then("^the CP only control should be invisible$")
    public void theCPOnlyControlShouldBeInvisible() throws InterruptedException {
        webModel.getNxTierServicesPage().assertCPonlyCheckBoxIsAbsent();
        webModel.getUtils().checkPoint("NA52b done");
    }


    @And("^create a new quote and access a service for agent$")
    public void createANewQuoteAndAccessAServiceForAgent() throws InterruptedException, SQLException {
        na44.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().loadAllOrders(true,false);
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().createQuote();
        webModel.getOrdersManagerPage().loadOrdersManagerAndClickOnQuoteID(webModel.getNewBusinessCustomerPage().RanName);
//        TODO
        webModel.getAddServicePage().addServiceToQuote("permissions");

    }
}