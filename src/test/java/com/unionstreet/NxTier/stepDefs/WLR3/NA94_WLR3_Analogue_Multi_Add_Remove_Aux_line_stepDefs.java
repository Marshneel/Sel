package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 03/02/2017.
 */
public class NA94_WLR3_Analogue_Multi_Add_Remove_Aux_line_stepDefs {

    WebModel webModel = new WebModel();

    @When("^I Initiate an add_remove aux order on the quote$")
    public void iInitiateAnAdd_removeAuxOrderOnTheQuote() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='01202300909'");
        //initiating the AUX line service
        webModel.getAddServicePage().searchAndAddService("Add/Remove Aux Lines");
        webModel.getWlr3_addRemoveAuxLinePage().textOnAddRemoveAuxLinePage();
        webModel.getWlr3_addRemoveAuxLinePage().populateCLIandPostCode("01202300909","LU1 1DQ");
    }

    @And("^Provide the required info to increase the number of lines$")
    public void provideTheRequiredInfoToIncreaseTheNumberOfLines() {
        webModel.getWlr3_addRemoveAuxLinePage().textOnIncreaseOrDecreaseAuxLinePopUp();
        //continue without increasing or deceasing number of lines
        webModel.getWlr3_addRemoveAuxLinePage().continueWithOutAddOrDeleteLines();
        //increasing the number of lines
        webModel.getWlr3_addRemoveAuxLinePage().ChangeNumberOfLines("9");
    }

    @Then("^I should be able to assert line increase and check the flow$")
    public void iShouldBeAbleToAssertLineIncreaseAndCheckTheFlow() throws InterruptedException {
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage();
        //assert line number increase
        webModel.getWlr3_addRemoveAuxLinePage().assertLineNumberIncrease();
        //assert CLI
        webModel.getWlr3_addRemoveAuxLinePage().assertCLI();
        //assert charges
        webModel.getWlr3_addRemoveAuxLinePage().assertPresenceOfCharges();
        //assert Add_Aux line
        webModel.getWlr3_orderDetails_page().assertQuoteSummaryPageForAddAuxLine();
        //provide phone number under site info and verify recovery line plant checkBox
        webModel.getWlr3_orderDetails_page().clickOnSiteInfoErrorTabForIncrease();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_siteInformationPage().assertAbsenceOfRLPcheckBoxUnderSiteInfo();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        //provide hazard and warning notes
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage();
        webModel.getWlr3_appointmentPage().populateHazardAndWarningNotes();
    }

    @And("^Provide the required info to decrease the number of lines$")
    public void provideTheRequiredInfoToDecreaseTheNumberOfLines() {
        webModel.getWlr3_addRemoveAuxLinePage().ChangeNumberOfLines("7");
    }

    @Then("^I should be able to assert line decrease and check the flow$")
    public void iShouldBeAbleToAssertLineDecreaseAndCheckTheFlow() throws InterruptedException {
        webModel.getWlr3_addRemoveAuxLinePage().assertNumberDecrease();
        //provide phone number under site info and verify recovery line plant checkBox
        webModel.getWlr3_orderDetails_page().clickOnSiteInfoErrorTabForDecrease();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_siteInformationPage().enterTelephoneNumberUnderSiteInfoAndAssertPresenceOfRLPcheckBox();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage();
        //assert charges absent
        webModel.getWlr3_addRemoveAuxLinePage().assertAbsenceOfCharges();
        //assert remove_Aux line
        webModel.getWlr3_orderDetails_page().assertQuoteSummaryPageForRemoveAuxLine();
        webModel.getWlr3_appointmentPage().populateHazardAndWarningNotes();
        webModel.getEditOrderPage().verifyOrderCompletion();
    }

    @And("^When I try to reuse the same CLI for a service within the sale quote$")
    public void whenITryToReuseTheSameCLIForAServiceWithinTheSaleQuote() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        iInitiateAnAdd_removeAuxOrderOnTheQuote();
    }

    @Then("^An error with relevant text message should be thrown$")
    public void anErrorWithRelevantTextMessageShouldBeThrown() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_addRemoveAuxLinePage().errorMessage();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='01202300909'");
    }


}
