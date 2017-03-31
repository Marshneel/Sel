package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 24/03/2017.
 */
public class NA108_WLR3_ISDN2_New_Provide_stepDefs {
   WebModel webModel=new WebModel();

    @When("^I initiate a new provide ISDN Standard line order$")
    public void iInitiateANewProvideISDNStandardLineOrder() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("New Provide Order");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().selectLineTypeForNewProvide("ISDN2 Standard");
    }


    @Then("^I should be able to check and validate the flow of ISDN_Standard line$")
    public void iShouldBeAbleToCheckAndValidateTheFlowOfISDN_StandardLine() throws InterruptedException {
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide_anaMultLine_provisionPage().setProvisionType();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide_anaMultLine_engineeringPage().sBusExtension();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide_anaMultLine_featuresPage().serviceMaintenanceForISBN2();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide_anaMultLine_numberingPage().directoryInfoForISDN2();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide_anaMultLine_datePage().populateHazardAndWarningNotesUnderDATE("hazardNotes", "warningNotes");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage();
        webModel.getWlr3_orderDetails_page().siteInfoValidationMessagesForISDN2OnOrderSummaryPage();
        webModel.getWlr3_siteInformationPage().populateFloorAndRoomForNewProvideIDSN2();
        webModel.getEditOrderPage().verifyOrderCompletion();
    }

    @When("^I initiate a new provide ISDN System line order$")
    public void iInitiateANewProvideISDNSystemLineOrder() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("New Provide Order");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().selectLineTypeForNewProvide("ISDN2 System");
    }

    @Then("^I should be able to check and validate the flow of ISDN_System line$")
    public void iShouldBeAbleToCheckAndValidateTheFlowOfISDN_SystemLine() throws InterruptedException {
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide_anaMultLine_provisionPage().validatingNumberOfChannelsForISDN2System();
    }
}
