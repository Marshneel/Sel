package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 09/02/2017.
 */


public class NA98_WLR3_AmendOrder_stepDefs {
    WebModel webModel = new WebModel();


    @And("^Create an order and submit it$")
    public void createAnOrderAndSubmitIt() throws InterruptedException {
        //initiating a transfer order
        webModel.getAddServicePage().searchAndAddService("Transfer Order");
        webModel.getWlr3_orderDetails_page().enterPhoneNumberAndPostCodeToInitiateTheTransfer("01202300908", "lu1 1dq");
        webModel.getWlr3_orderDetails_page().enterEmergencyInfo();
    }

    @When("^I access edit order page and click the order ID$")
    public void iAccessEditOrderPageAndClickTheOrderID() throws InterruptedException {
       webModel.getEditOrderPage().accessOrder();
    }

    @Then("^I should be able to amend and submit the order successful$")
    public void iShouldBeAbleToAmendAndSubmitTheOrderSuccessful() throws Exception {
        webModel.getEditOrderPage().submitOrder();
        webModel.getEditOrderPage().amendOrder();
        //editing network calling features and directory info
        webModel.getWlr3_networkCallingFeaturesPage().populateNetworkCallingFeatures();
        webModel.getWlr3_directoryInformationPage().populatingDirectoryInformation("Telecom");
        webModel.getWlr3_orderDetails_page().assertChangesForAmendOrder();
        //submitting the amended order
        webModel.getEditOrderPage().submitAmendedOrder();
        //check for amend order sent on the order notifications
        webModel.getEditOrderPage().checkOpenReachNotificationForAmend();
        //push the 4 notifications from the CmdController
        webModel.getEditOrderPage().pushOpenReachNotificationsForSubmittedOrder("01202300908","A00001043137");
        //check the text for the 4 notifications on the openReach notifications
        webModel.getEditOrderPage().checkOpenReachNotificationsForOrderSuccessfulSubmission();
        //delete the CLI from the site
        webModel.getUtils().sqlExeQuery("Portal", "test01-sql01", "nxtiere2e", "delete from CustomerCLIBase where cli='01202300908'");
        // clicks each of the tasks and process them
        webModel.getOrdersManagerPage().completeTask();
    }

}
