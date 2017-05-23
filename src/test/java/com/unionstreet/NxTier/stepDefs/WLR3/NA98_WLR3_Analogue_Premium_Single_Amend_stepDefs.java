package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLException;

/**
 * Created by RajeshG on 09/02/2017.
 */


public class NA98_WLR3_Analogue_Premium_Single_Amend_stepDefs {
    WebModel webModel = new WebModel();


    @And("^Create an order and submit it$")
    public void createAnOrderAndSubmitIt() throws InterruptedException, SQLException {
        //initiating a transfer order
        webModel.getAddServicePage().searchAndAddService("Transfer Order");
        webModel.getWlr3_orderDetails_page().enterPhoneNumberAndPostCodeToInitiateTheTransfer("01202300908", "lu1 1dq");
        webModel.getWlr3_orderDetails_page().enterEmergencyInfo();
    }

    @When("^I access edit order page and click the order ID$")
    public void iAccessEditOrderPageAndClickTheOrderID() throws InterruptedException, SQLException {
        webModel.getEditOrderPage().accessOrder();
    }

    @Then("^I should be able to amend and submit the order successful$")
    public void iShouldBeAbleToAmendAndSubmitTheOrderSuccessful() throws Exception {
        webModel.getEditOrderPage().submitOrder();
        webModel.getEditOrderPage().startOrderAmend();
        //editing network calling features and directory info
        webModel.getWlr3_networkCallingFeaturesPage().populateNetworkCallingFeatures();
        webModel.getWlr3_directoryInformationPage().populatingDirectoryInformation("Telecom");
        webModel.getWlr3_orderDetails_page().assertChangesForAmendOrder();
        //submitting the amended order
        webModel.getEditOrderPage().submitAmendedOrder();
        //check for amend order sent on the order notifications
        webModel.getEditOrderPage().checkOpenReachNotificationForAmend();
        //push the 4 notifications from the CmdController
        webModel.getEditOrderPage().pushOpenReachNotificationsForSubmittedOrder("01202300908", "A00001043137");
        //check the text for the 4 notifications on the openReach notifications
        webModel.getEditOrderPage().checkOpenReachNotificationsForOrderSuccessfulSubmission();
        // clicks each of the tasks and process them
        webModel.getOrdersManagerPage().clickDone();
    }

    @And("^There is a processed transfer order available$")
    public void thereIsAProcessedTransferOrderAvailable() {
    webModel.getOrdersManagerPage().proofOfProcessedOrder("Analogue Premium - Transfer");
    }
    @When("^I initiate an unsolicited cease on the line and push notifications to cancel it using CmdController$")
    public void iInitiateAnUnsolicitedCeaseOnTheLineAndPushNotificationsToCancelItUsingCmdController() throws Exception {
        webModel.getEditOrderPage().acknowledgeNotificationForUCease("01202300908");
    }

    @Then("^The cease should be cancelled on the line$")
    public void theCeaseShouldBeCancelledOnTheLine() throws Throwable {
        webModel.getOrdersManagerPage().processCease("vodafone","01202300908");
        webModel.getEditOrderPage().commitAndCompletedNotificationForUCease("01202300908");
        webModel.getEditOrderPage().assertCeaseIsCancelled();

    }
}
