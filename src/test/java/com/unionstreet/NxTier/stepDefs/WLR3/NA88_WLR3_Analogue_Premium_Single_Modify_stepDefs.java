package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 26/01/2017.
 */
public class NA88_WLR3_Analogue_Premium_Single_Modify_stepDefs {

    WebModel webModel = new WebModel();
    NA44_Agent_Login_stepDefs na44_agent_login_stepDefs = new NA44_Agent_Login_stepDefs();

    @And("^I create a new business customer with a quote$")
    public void iCreateANewBusinessCustomerWithAQuote() throws InterruptedException, SQLException {
        na44_agent_login_stepDefs.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().loadAllOrders(false,true);
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().createQuote();
        webModel.getOrdersManagerPage().searchQuoteByBcRN(webModel.getNewBusinessCustomerPage().RanName);
       // webModel.getUtils().switchToPreviousWindow(0);
        webModel.getOrdersManagerPage().loadOrdersManagerAndClickOnQuoteID(webModel.getNewBusinessCustomerPage().RanName);
    }

    @When("^Initiate a modify order on the quote$")
    public void initiateAModifyOrderOnTheQuote() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='02063678369'");
        webModel.getAddServicePage().searchAndAddService("Modify Order",webModel.getNewBusinessCustomerPage().RanName);

    }

    @And("^Access the WLR order details page$")
    public void accessTheWLROrderDetailsPage() throws InterruptedException, SQLException {
        webModel.getWlr3_modify_orderPage().assertTextOnModifyOrderPage();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrderWithWrongCLI();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrder("02063678369", "LU1 1DQ");
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
    }

    @Then("^I should be able to check all the tabs and verify assertions$")
    public void iShouldBeAbleToCheckAllTheTabsAndVerifyAssertions() throws Throwable {
        //add installation address and assert on the orderDetails screen
        webModel.getwlr3_newProvide_anaMultLine_sitePage().zoomOutOnInstallationAddressUnderModifyOrder();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ","A00001043137");
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26","A00001043137");
        //verify OrderType tab
        webModel.getWlr3_orderDetails_page().verifyOrderTypeTab();
        //verify lineInformation tab
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().verifyLineInformationTab("Level 3", "3");
        //verify network call features (verify by revoking and issuing the features)
        webModel.getWlr3_orderDetails_page().checkNetworkCallFeaturesBeforeRemoval();
        webModel.getWlr3_networkCallingFeaturesPage().enterNetworkFeatures(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_networkCallingFeaturesPage().depopulateAndVerifyNetworkCallingFeatures();
        webModel.getWlr3_orderDetails_page().checkNetworkCallFeaturesAfterRemoval();
        webModel.getWlr3_networkCallingFeaturesPage().enterNetworkFeatures(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_networkCallingFeaturesPage().rePopulateNetworkCallingFeatures();
        //verify appointment page
        webModel.getWlr3_appointmentPage().accessAppointmentpage();
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_appointmentPage().saveAppointments();
        webModel.getWlr3_orderDetails_page().assertAppointmentInfo();
    }

    @And("^make sure order is completed and ready for submission$")
    public void makeSureOrderIsCompletedAndReadyForSubmission() throws Throwable {
        //assert that the order is completed by verifying for the presence of green tick
       // webModel.getUtils().switchToPreviousWindow(0);
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='02063678369'");

    }
}