package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 31/01/2017.
 */
public class NA91_WLR3_Analogue_Premium_Single_Cease_stepDefs {


    WebModel webModel = new WebModel();


    @When("^I Initiate a cease order on the quote$")
    public void iInitiateACeaseOrderOnTheQuote() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='02063678369'");
        //select cease service
        webModel.getAddServicePage().searchAndAddService("Cease Order");
        webModel.getWlr3_modify_orderPage().assertTextOnModifyOrderPage();
        //initiate the cease
        webModel.getWlr3_modify_orderPage().initiatingModifyOrder("02063678369", "LU1 1DQ");
    }

    @Then("^I should be able to check recovery line plant and caller feature validations$")
    public void iShouldBeAbleToCheckRecoveryLinePlantAndCallerFeatureValidations() throws InterruptedException {
        webModel.getWlr3_cease_orderPage().textOnCeaseOrderPage();
        //check the validation with recovery line plant check box
        webModel.getWlr3_cease_orderPage().populateRecoveryLinePlantAndVerifyAssertion();
        webModel.getWlr3_cease_orderPage().navigateToPreviousScreen();
        webModel.getWlr3_cease_orderPage().dePopulateRecoveryLinePlantAndVerifyAssertion();
        webModel.getWlr3_cease_orderPage().navigateToPreviousScreen();
        //check the validation with features
        webModel.getWlr3_cease_orderPage().verifyCallFeatures_OneMonthCallerRedirect();
        webModel.getWlr3_cease_orderPage().verifyCallFeatures_QuarterlyCallerRedirect();
        webModel.getWlr3_cease_orderPage().verifyCallFeatures_RemoteCallForwarding();
        webModel.getWlr3_cease_orderPage().navigateToPreviousScreen();
        webModel.getWlr3_cease_orderPage().navigateToPreviousScreen();
    }

    @And("^check for order completion and final assertions on order summary page$")
    public void checkForOrderCompletionAndFinalAssertionsOnOrderSummaryPage() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        //verify the gree tick
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage();
        //perform assertions on the order page
        webModel.getWlr3_orderDetails_page().assertQuoteForCeaseOrder();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL' where serviceid='02063678369'");
    }
}
