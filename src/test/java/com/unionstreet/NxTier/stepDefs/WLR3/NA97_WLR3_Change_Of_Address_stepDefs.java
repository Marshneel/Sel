package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 13/02/2017.
 */
public class NA97_WLR3_Change_Of_Address_stepDefs {

    WebModel webModel=new WebModel();
    @When("^I initiate a change of address service$")
    public void iInitiateAChangeOfAddressService() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Change of Address");
        webModel.getEditOrderPage().textOnChangeOfAddressOrderPage();
        webModel.getWlr3_addRemoveAuxLinePage().populateCLIandPostCode();
        webModel.getWlr_and_nxTierServicesPage().verifyCurrentLine("Analogue Multiline (Current)");
        webModel.getWlr3_installationAddressPage().assertValidationMessage();
        webModel.getWlr3_installationAddressPage().populateAddressForChangeOfAddress();
        webModel.getWlr3_orderDetails_page().pickAddressFromSearchResults();


    }

    @When("^I provide a postCode that is within the same exchange under installation address$")
    public void iProvideAPostCodeThatIsWithinTheSameExchangeUnderInstallationAddress() {

    }

    @Then("^Retain option availability is displayed$")
    public void retainOptionAvailabilityIsDisplayed() {

    }

    @And("^When I provide a postCode that is outside the exchange$")
    public void whenIProvideAPostCodeThatIsOutsideTheExchange()  {

    }


    @Then("^Message stating retain option unavailability should be displayed$")
    public void messageStatingRetainOptionUnavailabilityShouldBeDisplayed()  {

    }
}
