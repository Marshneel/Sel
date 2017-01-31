package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 31/01/2017.
 */
public class NA91_WLR3_Cease_Order_stepDefs {


    WebModel webModel=new WebModel();


    @When("^I Initiate a cease order on the quote$")
    public void iInitiateACeaseOrderOnTheQuote() throws InterruptedException {
        //select cease service
        webModel.getAddServicePage().searchAndAddService("Cease Order");
        webModel.getWlr3_modify_orderPage().assertTextOnModifyOrderPage();
        //initiate the cease
        webModel.getWlr3_modify_orderPage().initiatingModifyOrder("02063678369","LU1 1DQ");
    }

    @Then("^I should be able to check the work flow$")
    public void iShouldBeAbleToCheckTheWorkFlow() throws InterruptedException {
        webModel.getWlr3_cease_orderPage().textOnCeaseOrderPage();
        //check the validation with recovery line plant check box
        webModel.getWlr3_cease_orderPage().populateRecoveryLinePlantAndVerifyAssertion();
        webModel.getWlr3_cease_orderPage().navigateToPreviousScreen();
        webModel.getWlr3_cease_orderPage().dePopulateRecoveryLinePlantAndVerifyAssertion();
        webModel.getWlr3_cease_orderPage().navigateToPreviousScreen();
        //check the validation with features
        webModel.getWlr3_cease_orderPage().verifyCallFeatures();
        webModel.getWlr3_cease_orderPage().navigateToPreviousScreen();
        webModel.getWlr3_cease_orderPage().navigateToPreviousScreen();
        //verify the gree tick
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage();
        //perform assertions on the order page
        webModel.getWlr3_orderDetails_page().assertQuoteForCeaseOrder();





    }


}
