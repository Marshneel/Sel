package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 06/03/2017.
 */
public class NA102_Unsolicited_cease_stepDefs {

    WebModel webModel = new WebModel();


    @And("^There is a completed processed modify order available$")
    public void thereIsACompletedProcessedModifyOrderAvailable() throws Exception {
        webModel.getAddServicePage().searchAndAddService("Modify Order");
        webModel.getEditOrderPage().submitOrder();
        webModel.getEditOrderPage().pushOpenReachNotificationsForSubmittedOrder("01202300908","A00001043137");
    }

    @When("^I initiate an unsolicited cease on the line and push notifications using CmdController$")
    public void iInitiateAnUnsolicitedCeaseOnTheLineAndPushNotificationsUsingCmdController() {

    }

    @Then("^The cease should be placed on the line$")
    public void theCeaseShouldBePlacedOnTheLine()  {

    }
}
