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
       //initiating the change of address service
        webModel.getAddServicePage().searchAndAddService("Change of Address");
        webModel.getEditOrderPage().textOnChangeOfAddressOrderPage();
        webModel.getWlr3_addRemoveAuxLinePage().populateCLIandPostCode("02063678369","LU1 1DQ");
        webModel.getWlr_and_nxTierServicesPage().verifyCurrentLine("Premium Analogue (Current)");
        webModel.getWlr3_installationAddressPage().assertValidationMessage();
    }

    @When("^I provide a postCode that is within the same exchange under installation address$")
    public void iProvideAPostCodeThatIsWithinTheSameExchangeUnderInstallationAddress() throws InterruptedException {
        //entering the postCode that is within the exchange
        webModel.getWlr3_installationAddressPage().searchForAddress("LU1 1DQ");
        webModel.getWlr3_orderDetails_page().pickAddressFromSearchResults();
        //entering phone number under siteInfo
        webModel.getWlr3_siteInformationPage().populateTelNumberOnChangeOfAddress("07894040256");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().multipleClicksOnNextButton();
    }

    @Then("^Retain option availability is displayed$")
    public void retainOptionAvailabilityIsDisplayed() throws InterruptedException {
        //check for the retain option
        webModel.getWlr3_newProvide_anaMultLine_numberingPage().checkPresenceOfRetainOptionInChangeOfAddress();
    }

    @When("^Provide a postCode that is outside the exchange$")
    public void provideAPostCodeThatIsOutsideTheExchange() throws InterruptedException {
        //entering the postCode that is outside the exchange
        webModel.getWlr3_installationAddressPage().searchForAddress("CB1 3NL");
        webModel.getWlr3_orderDetails_page().pickAddressFromSearchResults();
        //entering phone number under siteInfo
        webModel.getWlr3_siteInformationPage().populateTelNumberOnChangeOfAddress("07894040256");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().multipleClicksOnNextButton();
    }


    @Then("^Message stating retain option unavailability should be displayed$")
    public void messageStatingRetainOptionUnavailabilityShouldBeDisplayed() {
       //check that the retain option is unavailable
        webModel.getWlr3_newProvide_anaMultLine_numberingPage().checkAbsenceOfRetainInChangeOfAddress();
    }

    @And("^when i navigate forward and provide all required information$")
    public void whenINavigateForwardAndProvideAllRequiredInformation() throws InterruptedException {
       //populate the hazard warning notes
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide_anaMultLine_datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
    }

    @Then("^I should be able to complete the order and see a green tick$")
    public void iShouldBeAbleToCompleteTheOrderAndSeeAGreenTick() throws InterruptedException {
        //verify for the presence of the green tick
        webModel.getEditOrderPage().verifyOrderCompletion();
    }

}
