package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 28/02/2017.
 */
public class NA101_WLR3_ISDN30_NewProvide_stepDefs {
    WebModel webModel = new WebModel();

    @When("^I initiate a new provide ISDN line order$")
    public void iInitiateANewProvideISDNLineOrder() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("New Provide Order");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().selectLineTypeForNewProvide("ISDN30E");

    }

    @Then("^I should be able to check the flow$")
    public void iShouldBeAbleToCheckTheFlow() throws InterruptedException {
        //populate SITE with assertions
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //populate PROVISION with assertions
        webModel.getWlr3_newProvide_anaMultLine_provisionPage().populateProvisionPageWithAssertionsForISDN30();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //populate FEATURES with assertions
        webModel.getWlr3_newProvide_anaMultLine_featuresPage().populateAndAssertFeaturesPageForISDN30();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //populate NUMBERING with assertions
        webModel.getWlr3_newProvide_anaMultLine_numberingPage().populateAndAssertNumberingPageForISDN30("SNDDI","Automatically Allocated","Auto allocate number");
       webModel.getWlr3_newProvide_anaMultLine_numberingPage().directoryInfoForISDN30();
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //populate DATE with assertions
        webModel.getWlr3_newProvide_anaMultLine_datePage().populateHazardAndWarningNotesUnderDATE("hazardNotes","warningNotes");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        webModel.getEditOrderPage().verifyOrderCompletion();
        //assetions on order summary page
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage();
        webModel.getWlr3_orderDetails_page().assertISDNNewProvideSummaryPage("8");




    }
}
