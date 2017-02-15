package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 13/02/2017.
 */
public class NA97_WLR3_Change_Of_Address_stepDefs {

    WebModel webModel = new WebModel();

    @When("^I initiate a change of address service$")
    public void iInitiateAChangeOfAddressService() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Change of Address");
        webModel.getEditOrderPage().textOnChangeOfAddressOrderPage();
        webModel.getWlr3_addRemoveAuxLinePage().populateCLIandPostCode("02063678369");
        webModel.getWlr_and_nxTierServicesPage().verifyCurrentLine("Premium Analogue (Current)");
        webModel.getWlr3_installationAddressPage().assertValidationMessage();


    }

    @When("^I provide a postCode that is within the same exchange under installation address$")
    public void iProvideAPostCodeThatIsWithinTheSameExchangeUnderInstallationAddress() throws InterruptedException {
        webModel.getWlr3_installationAddressPage().searchForAddress("LU1 1DQ");
        webModel.getWlr3_orderDetails_page().pickAddressFromSearchResults();
        webModel.getWlr3_siteInformationPage().populateTelNumberOnChangeOfAddress("07894040256");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
    }

    @Then("^Retain option availability is displayed$")
    public void retainOptionAvailabilityIsDisplayed() throws InterruptedException {
        webModel.getWlr3_newProvide_anaMultLine_numberingPage().checkPresenceOfRetainOptionInChangeOfAddress();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToPreviousScreen();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToPreviousScreen();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToPreviousScreen();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToPreviousScreen();
    }

    @And("^When I provide a postCode that is outside the exchange$")
    public void whenIProvideAPostCodeThatIsOutsideTheExchange() throws InterruptedException {
        webModel.getWlr3_installationAddressPage().searchForAddress("CB1 3NL");
        webModel.getWlr3_orderDetails_page().pickAddressFromSearchResults();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
    }


    @Then("^Message stating retain option unavailability should be displayed$")
    public void messageStatingRetainOptionUnavailabilityShouldBeDisplayed() {
        webModel.getWlr3_newProvide_anaMultLine_numberingPage().checkAbsenceOfRetainInChangeOfAddress();

    }

    @And("^when i navigate forward and provide all required information$")
    public void whenINavigateForwardAndProvideAllRequiredInformation() throws InterruptedException {
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide_anaMultLine_datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
    }

    @Then("^I should be able to complete the order and see a green tick$")
    public void iShouldBeAbleToCompleteTheOrderAndSeeAGreenTick() throws InterruptedException {
        webModel.getEditOrderPage().verifyOrderCompletion();
    }
}
