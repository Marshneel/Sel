package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.sql.SQLException;

/**
 * Created by rajeshg on 22/09/2016.
 */
public class NA49_OrderServiceAutomation_stepDefs {
    WebModel webModel = new WebModel();
    NA44_Agent_Login_stepDefs na44 = new NA44_Agent_Login_stepDefs();

    @And("^Have created a quote as a CP$")
    public void haveCreatedAQuoteAsACP() throws InterruptedException {
        na44.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().loadAllOrders(false,true);
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().createQuote();

    }

    @When("^I add a service from the quote details page$")
    public void iAddAServiceFromTheQuoteDetailsPage() throws InterruptedException, SQLException {
        webModel.getOrdersManagerPage().loadOrdersManagerAndClickOnQuoteID(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getEditOrderPage().clickAddProductsAndServicesButton();
    }

    @Then("^the control that is CP only should be visible$")
    public void theControlThatIsCPOnlyShouldBeVisible() throws InterruptedException {
        webModel.getNxTierServicesPage().assertCPonlyValuePresent();
        System.out.println("NA49a completed");
    }
///////////////////////////////////////////////////////////////////////////////////////////

    @Then("^the control that is CP only should be invisible$")
    public void theControlThatIsCPOnlyShouldBeInvisible() throws InterruptedException {
        webModel.getNxTierServicesPage().assertCPonlyValueNotPresent();
        System.out.println("NA49b completed");
    }

    @And("^Have created a quote for reseller$")
    public void haveCreatedAQuoteForReseller() throws InterruptedException {
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().loadAllOrders(true,false);
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().createQuoteForReseller();

    }
/////////////////////////////////////////////////////////////////////////////////////////////

    @When("^I access quote details and add a service without selecting the mandatory control$")
    public void iAccessQuoteDetailsAndAddAServiceWithoutSelectingTheMandatoryControl() throws InterruptedException, SQLException {
        webModel.getOrdersManagerPage().loadOrdersManagerAndClickOnQuoteID(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getEditOrderPage().clickAddProductsAndServicesButton();
        webModel.getAddServicePage().searchAndSelectService(webModel.getNxTierServicesPage().CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE,false);
    }

    @Then("^The quote should become invalid$")
    public void theQuoteShouldBecomeInvalid() throws InterruptedException, SQLException {
        webModel.getEditOrderPage().assertInvalidQuoteBeforeSubmitting();
        webModel.getEditOrderPage().assertInvalidQuoteAfterSubmitting();

    }

    @And("^When I add the omitted control, the quote should become valid$")
    public void whenIAddTheOmittedControlTheQuoteShouldBecomeValid() throws InterruptedException, AWTException, SQLException {
       // webModel.getAddServicePage().scrollToService();
        webModel.getAddServicePage().clickService();
        webModel.getNxTierServicesPage().populateMandatoryField();
        webModel.getEditOrderPage().assertValidQuoteBeforeSubmitting();
        webModel.getEditOrderPage().assertValidQuoteAfterSubmitting();
        webModel.getUtils().checkPoint("NA49 done");
    }


    @When("^I add a service from the quote details page for reseller$")
    public void iAddAServiceFromTheQuoteDetailsPageForReseller() throws SQLException, InterruptedException {
        webModel.getOrdersManagerPage().loadOrdersManagerAndClickOnQuoteID(webModel.getNewBusinessCustomerPage().Reseller_RanName);
        webModel.getEditOrderPage().clickAddProductsAndServicesButton();
    }

    @When("^I access quote details and add a service without selecting the mandatory control for agent$")
    public void iAccessQuoteDetailsAndAddAServiceWithoutSelectingTheMandatoryControlForAgent() throws SQLException, InterruptedException {
        webModel.getOrdersManagerPage().loadOrdersManagerAndClickOnQuoteID(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getEditOrderPage().clickAddProductsAndServicesButton();
        webModel.getAddServicePage().searchAndSelectService(webModel.getNxTierServicesPage().CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE,false);
    }

    @When("^I access quote details and add a service without selecting the mandatory control for reseller$")
    public void iAccessQuoteDetailsAndAddAServiceWithoutSelectingTheMandatoryControlForReseller() throws InterruptedException, SQLException {
        webModel.getOrdersManagerPage().loadOrdersManagerAndClickOnQuoteID(webModel.getNewBusinessCustomerPage().Reseller_RanName);
        webModel.getEditOrderPage().clickAddProductsAndServicesButton();
        webModel.getAddServicePage().searchAndSelectService(webModel.getNxTierServicesPage().CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE,false);
    }


    @And("^Have created a quote as an agent$")
    public void haveCreatedAQuoteAsAnAgent() throws InterruptedException {
        na44.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().loadAllOrders(true,false);
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().createQuote();
    }
}
