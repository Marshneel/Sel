package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 17/02/2017.
 */
public class NA99_WLR3_BatchTransfer_stepDefs {
    WebModel webModel=new WebModel();

    @When("^I initiate a batch transfer and submit it with out generating OIDs$")
    public void iInitiateABatchTransferAndSubmitItWithOutGeneratingOIDs() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Batch Transfer Order");
        webModel.getWlr3_batchTransferPage().addCLIsToTheOrder("01202300908","LU1 1DQ");
        webModel.getEditOrderPage().submitBatchOrderBeforeOIDsGenerated();
    }

    @Then("^An error message should be thrown$")
    public void anErrorMessageShouldBeThrown() {
        webModel.getEditOrderPage().errorMessageWhenOrderSubmittedWithOutOIDs();

    }
}
