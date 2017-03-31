package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 26/01/2017.
 */
public class NA88_WLR3_Modify_Order_stepDefs {

    WebModel webModel = new WebModel();
    NA44_Agent_Login_stepDefs na44_agent_login_stepDefs = new NA44_Agent_Login_stepDefs();

    @And("^I create a new business customer with a quote$")
    public void iCreateANewBusinessCustomerWithAQuote()  throws InterruptedException {
        na44_agent_login_stepDefs.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().createQuote();
        webModel.getOrdersManagerPage().searchQuoteByBcRN();
        webModel.getOrdersManagerPage().clickOnQuoteID();
    }

    @When("^Initiate a modify order on the quote$")
    public void initiateAModifyOrderOnTheQuote() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Modify Order");

    }

    @And("^Access the WLR order details page$")
    public void accessTheWLROrderDetailsPage() throws InterruptedException {
        webModel.getWlr3_modify_orderPage().assertTextOnModifyOrderPage();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrderWithWrongCLI();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrder("02063678369", "LU1 1DQ");
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage();
    }

    @Then("^I should be able to check all the tabs and verify assertions$")
    public void iShouldBeAbleToCheckAllTheTabsAndVerifyAssertions() throws Throwable {
        //add installation address and assert on the orderDetails screen
        webModel.getwlr3_newProvide_anaMultLine_sitePage().zoomOutOnInstallationAddressUnderModifyOrder();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ");
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26");
        //verify OrderType tab
        webModel.getWlr3_orderDetails_page().verifyOrderTypeTab();
        //verify lineInformation tab
        webModel.getWlr3_line_information_page().verifyLineInformationTab("Level 3", "3");
        //verify network call features (verify by revoking and issuing the features)
        webModel.getWlr3_orderDetails_page().checkNetworkCallFeaturesBeforeRemoval();
        webModel.getWlr3_networkCallingFeaturesPage().enterNetworkFeatures();
        webModel.getWlr3_networkCallingFeaturesPage().depopulateAndVerifyNetworkCallingFeatures();
        webModel.getWlr3_orderDetails_page().checkNetworkCallFeaturesAfterRemoval();
        webModel.getWlr3_networkCallingFeaturesPage().enterNetworkFeatures();
        webModel.getWlr3_networkCallingFeaturesPage().rePopulateNetworkCallingFeatures();
        //verify appointment page
        webModel.getWlr3_appointmentPage().accessAppointmentpage();
        webModel.getWlr3_newProvide_anaMultLine_datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_appointmentPage().saveAppointments();
        webModel.getWlr3_orderDetails_page().assertAppointmentInfo();
    }

    @And("^make sure order is completed and ready for submission$")
    public void makeSureOrderIsCompletedAndReadyForSubmission() throws Throwable {
        //assert that the order is completed by verifying for the presence of green tick
        webModel.getEditOrderPage().verifyOrderCompletion();
    }


}
