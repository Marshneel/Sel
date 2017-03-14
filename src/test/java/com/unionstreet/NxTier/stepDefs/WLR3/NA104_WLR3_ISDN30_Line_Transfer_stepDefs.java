package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 10/03/2017.
 */
public class NA104_WLR3_ISDN30_Line_Transfer_stepDefs {
    WebModel webModel = new WebModel();

    @When("^I initiate a transfer service on the line that has business continuity set$")
    public void iInitiateATransferServiceOnTheLineThatHasBusinessContinuitySet() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Transfer Order");
        webModel.getWlr3_orderDetails_page().enterPhoneNumberAndPostCodeToInitiateTheTransfer("01202300945", "lu1 1dq");
    }

    @Then("^An alert message should be displayed$")
    public void anAlertMessageShouldBeDisplayed() {
        webModel.getEditOrderPage().processBusinessContinuityAlert();

    }

    @And("^I initiate a transfer service on ISDN line$")
    public void iInitiateATransferServiceOnISDNLine() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Transfer Order");
        webModel.getWlr3_orderDetails_page().enterPhoneNumberAndPostCodeToInitiateTheTransfer("01202300800", "lu1 1dq");

    }

    @When("^I provide all the valid info$")
    public void iProvideAllTheValidInfo() throws InterruptedException {
        webModel.getWlr3_orderDetails_page().enterEmergencyInfo();
        webModel.getWlr3_line_information_page().verifyLineInfoForISDN30("2", "3", "4");
        webModel.getWlr3_orderDetails_page().assertLineInfoForISDN30("4");
        webModel.getWlr3_businessContinuityPage().loadBusinessContinuity();
        webModel.getWlr3_businessContinuityPage().selectBusinessContinuity();
        webModel.getWlr3_orderDetails_page().assertBusinessContinuity();
        webModel.getWlr3_newProvide_anaMultLine_numberingPage().checkLineNumberingForISDN("Renumber", "Renumber with QCR");
        webModel.getWlr3_orderDetails_page().assertLineNumberingForISDN("Renumber", "Renumber with QCR");
        webModel.getWlr3_siteInformationPage().siteInfoForISDN("Band 1 - Up to 2 Hours");
    }

    @Then("^I should be able to complete the order$")
    public void iShouldBeAbleToCompleteTheOrder() throws InterruptedException {
        webModel.getEditOrderPage().verifyOrderCompletion();

    }
}
