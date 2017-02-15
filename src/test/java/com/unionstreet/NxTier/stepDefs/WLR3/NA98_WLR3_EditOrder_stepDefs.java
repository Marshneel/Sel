package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 09/02/2017.
 */


public class NA98_WLR3_EditOrder_stepDefs {
    WebModel webModel=new WebModel();


    @And("^Create an order and submit it$")
    public void createAnOrderAndSubmitIt() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Transfer Order");
        webModel.getWlr3_orderDetails_page().enterPhoneNumberAndPostCodeToInitiateTheTransfer("01202300908", "lu1 1dq");
    webModel.getWlr3_orderDetails_page().enterEmergencyInfo();
    }

    @When("^I access edit order page and click the order ID$")
    public void iAccessEditOrderPageAndClickTheOrderID() throws InterruptedException {
        webModel.getEditOrderPage().submitOrder();

    }

    @Then("^I should be able to edit and submit the order successful$")
    public void iShouldBeAbleToEditAndSubmitTheOrderSuccessful() throws Exception {
        webModel.getEditOrderPage().amendOrder();
        webModel.getWlr3_networkCallingFeaturesPage().populateNetworkCallingFeatures();
        webModel.getWlr3_directoryInformationPage().populatingDirectoryInformation("Telecom");
        webModel.getWlr3_orderDetails_page().assertChangesForAmendOrder();
        webModel.getEditOrderPage().submitAmendedOrder();
        webModel.getEditOrderPage().checkOpenReachNotificationForAmend();
        webModel.getEditOrderPage().pushNotificationsForChangeOfAddressService();
        webModel.getEditOrderPage().checkOpenReachNotificationsForOrderSuccessfulSubmission();

        webModel.getUtils().sqlExeQuery("Portal", "test01-sql01", "nxtiere2e", "delete from CustomerCLIBase where cli='01202300908'");


    }


}
