package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 13/04/2017.
 */
public class NA117_WLR3_ISDN30_Change_Of_Address_stepDefs {
    WebModel webModel=new WebModel();
    @When("^I initiate a change of address service for ISDN(\\d+)$")
    public void iInitiateAChangeOfAddressServiceForISDN(int arg0) throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Change of Address");
        webModel.getWlr3_orderDetails_page().textOnChangeOfAddressOrderPage();
        webModel.getWlr3_addRemoveAuxLinePage().populateCLIandPostCode("01202300945","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().confirmChangeOfOwnerShip();


    }

    @Then("^I should be able to check the validations and complete the change of address$")
    public void iShouldBeAbleToCheckTheValidationsAndCompleteTheChangeOfAddress() throws InterruptedException {
        webModel.getWlr3_installationAddressPage().searchForAddress("LU1 1DQ");
        webModel.getWlr3_orderDetails_page().pickAddressFromSearchResults();
        webModel.getWlr3_siteInformationPage().populateTelNumberOnChangeOfAddress("07894040256");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateEmergencyInfo();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide_anaMultLine_provisionPage().provisionPageForISDN30ChangeOfAddress();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().multipleClicksOnNextButton(4);
        webModel.getWlr3_newProvide_anaMultLine_datePage().populateHazardAndWarningNotesUnderDATE("hazardNotes", "warningNotes");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage();
        webModel.getWlr3_orderDetails_page().openReachAddressValidationForISDN30();
        webModel.getWlr3_orderDetails_page().editOpenReachManaged();
        webModel.getEditOrderPage().verifyOrderCompletion();



    }
}
