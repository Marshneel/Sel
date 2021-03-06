package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 10/03/2017.
 */
public class NA104_WLR3_ISDN30_Transfer_stepDefs {
    WebModel webModel = new WebModel();

    @When("^I initiate a transfer service on the line that has business continuity set$")
    public void iInitiateATransferServiceOnTheLineThatHasBusinessContinuitySet() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI3000000001'");
        webModel.getAddServicePage().searchAndAddService("Transfer Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().enterPhoneNumberAndPostCodeToInitiateTheTransfer("01202300945", "lu1 1dq");
    }

    @Then("^An alert message should be displayed$")
    public void anAlertMessageShouldBeDisplayed() {
        webModel.getWlr3_orderDetails_page().processBusinessContinuityAlert();

    }

    @And("^I initiate a transfer service on ISDN line$")
    public void iInitiateATransferServiceOnISDNLine() throws InterruptedException, SQLException {
        webModel.getAddServicePage().searchAndAddService("Transfer Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().enterPhoneNumberAndPostCodeToInitiateTheTransfer("01202300800", "lu1 1dq");

    }

    @When("^I provide all the valid info$")
    public void iProvideAllTheValidInfo() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().enterEmergencyInfo(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_line_information_page().verifyLineInfoForISDN30("2", "3", "4","1");
        webModel.getWlr3_businessContinuityPage().loadBusinessContinuity();
        webModel.getWlr3_businessContinuityPage().selectBusinessContinuity();
        webModel.getWlr3_orderDetails_page().assertBusinessContinuity();
        webModel.getWlr3_newProvide__numberingPage().checkLineNumberingForISDN("Renumber", "Change no of DDIs");
        webModel.getWlr3_orderDetails_page().assertLineNumberingForISDN("Renumber", "Change DDIs");
        webModel.getWlr3_siteInformationPage().siteInfoForISDNNewProvide("Band 1 - Up to 2 hours");
    }

    @Then("^I should be able to complete the order$")
    public void iShouldBeAbleToCompleteTheOrder() throws InterruptedException, SQLException {
        webModel.getEditOrderPage().verifyOrderCompletion();

    }
}
